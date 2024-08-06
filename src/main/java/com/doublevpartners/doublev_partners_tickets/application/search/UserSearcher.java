package com.doublevpartners.doublev_partners_tickets.application.search;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.domain.port.search.UserSearcherRepository;
import org.springframework.stereotype.Service;


@Service
public class UserSearcher {

    private final UserSearcherRepository userSearcherRepository;

    public UserSearcher(UserSearcherRepository userSearcherRepository) {
        this.userSearcherRepository = userSearcherRepository;
    }

    public User findByLogin(String login) {
        return userSearcherRepository.findByLogin(login);
    }

}
