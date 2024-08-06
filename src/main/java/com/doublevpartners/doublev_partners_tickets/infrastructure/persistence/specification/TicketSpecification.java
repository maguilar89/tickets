package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.specification;

import com.doublevpartners.doublev_partners_tickets.domain.TicketFilter;
import com.doublevpartners.doublev_partners_tickets.domain.enumeration.TicketStatusEnum;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.entity.TicketEntity;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Builder
public class TicketSpecification implements Specification<TicketEntity> {

    public final static String CREATION_DATE = "creationDate";
    public final static String STATUS = "status";

    private final transient TicketFilter filter;

    @Override
    public Predicate toPredicate(Root<TicketEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (filter.getInitialDate()!=null && filter.getFinalDate()!=null) {
            predicates.add(
                    criteriaBuilder.between(root.get(CREATION_DATE),
                            filter.getInitialDate().atStartOfDay(),
                            filter.getFinalDate().atTime(23, 59))
            );
        }

        if (!Objects.nonNull(filter.getStatus())) {
            predicates.add(
                    criteriaBuilder.equal(root.get(STATUS),
                            TicketStatusEnum.findByValue(filter.getStatus()).getValue())
            );
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
