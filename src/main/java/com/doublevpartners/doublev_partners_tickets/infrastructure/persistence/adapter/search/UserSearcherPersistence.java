package com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.adapter.search;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.domain.port.search.UserSearcherRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.mapper.UserPersistenceMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.persistence.repository.UserJpaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Slf4j
@Repository
public class UserSearcherPersistence implements UserSearcherRepository {

    private final UserJpaRepository userJpaRepository;
    private final UserPersistenceMapper userPersistenceMapper;


    @Override
    public User findByLogin(String login) {
        return userPersistenceMapper.toDomain(userJpaRepository.findByLogin(login));
    }
}
