package com.doublevpartners.doublev_partners_tickets.domain;

import lombok.Getter;

@Getter
public class PageAsk {

    private final Integer page;
    private final Integer size;


    private PageAsk(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public static PageAsk create(Integer page, Integer size) {
        return new PageAsk(page, size);
    }

}
