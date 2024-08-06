package com.doublevpartners.doublev_partners_tickets.domain.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum TicketStatusEnum {

    OPEN("abierto","1"),
    CLOSE("cerrado","2");

    private final String value;
    private final String code;

    public static TicketStatusEnum findByValue(String value) {
        return Stream.of(TicketStatusEnum.values())
                .filter(e -> e.getValue().equals(value))
                .findFirst()
                .orElse(null);
    }

    public static TicketStatusEnum findByCode(String code) {
        return Stream.of(TicketStatusEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElse(null);
    }

}
