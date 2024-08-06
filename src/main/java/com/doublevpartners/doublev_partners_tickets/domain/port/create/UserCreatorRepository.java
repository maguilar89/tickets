package com.doublevpartners.doublev_partners_tickets.domain.port.create;

import com.doublevpartners.doublev_partners_tickets.domain.User;

public interface UserCreatorRepository {

    User save(User user);

}
