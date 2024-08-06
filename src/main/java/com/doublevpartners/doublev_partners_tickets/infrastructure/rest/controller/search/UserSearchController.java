package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.search;

import com.doublevpartners.doublev_partners_tickets.application.search.UserSearcher;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper.UserRestMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserSearchController {

    private final UserSearcher userSearcher;
    private final UserRestMapper userRestMapper;

    public UserSearchController(UserSearcher userSearcher, UserRestMapper userRestMapper) {
        this.userSearcher = userSearcher;
        this.userRestMapper = userRestMapper;
    }

    @GetMapping("/user/{login}/search")
    public UserResponse search(@PathVariable String login) {

        return userRestMapper.toResponse(userSearcher.findByLogin(login));

    }

}
