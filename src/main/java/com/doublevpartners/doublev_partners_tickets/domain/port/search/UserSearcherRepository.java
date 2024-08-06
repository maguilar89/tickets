package com.doublevpartners.doublev_partners_tickets.domain.port.search;

import com.doublevpartners.doublev_partners_tickets.domain.User;

public interface UserSearcherRepository {

    User findByLogin(String userName);

}
