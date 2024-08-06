package com.doublevpartners.doublev_partners_tickets.infrastructure.rest.client;

import com.doublevpartners.doublev_partners_tickets.domain.GithubUserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "githubClient", url = "https://api.github.com")
public interface UserFeignClient {

    @GetMapping("/search/users")
    GithubUserResponse searchUser(@RequestParam("q") String query);

}
