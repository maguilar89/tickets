package com.doublevpartners.doublev_partners_tickets.application.create;

import com.doublevpartners.doublev_partners_tickets.domain.GithubUserResponse;
import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.domain.port.create.UserCreatorRepository;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.client.UserFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class UserCreator {

    private final UserCreatorRepository userCreatorRepository;
    private final UserFeignClient searchUsers;

    public UserCreator(UserCreatorRepository userCreatorRepository, UserFeignClient searchUsers) {
        this.userCreatorRepository = userCreatorRepository;
        this.searchUsers = searchUsers;
    }

    public User create(User user) {
        return userCreatorRepository.save(user);
    }

    @Transactional
    public void fetchAndSaveUsers(String query) {
        GithubUserResponse response = searchUsers.searchUser(query);
        List<User> items = response.getItems();

        for (User value : items) {
            User user =  User.builder()
                    .login(value.getLogin())
                    .id(value.getId())
                    .nodeId(value.getNodeId())
                    .avatarUrl(value.getAvatarUrl())
                    .url(value.getUrl())
                    .htmlUrl(value.getHtmlUrl())
                    .followersUrl(value.getFollowersUrl())
                    .followingUrl(value.getFollowingUrl())
                    .gistsUrl(value.getGistsUrl())
                    .starredUrl(value.getStarredUrl())
                    .subscriptionsUrl(value.getSubscriptionsUrl())
                    .organizationsUrl(value.getOrganizationsUrl())
                    .reposUrl(value.getReposUrl())
                    .eventsUrl(value.getEventsUrl())
                    .receivedEventsUrl(value.getReceivedEventsUrl())
                    .type(value.getType())
                    .siteAdmin(value.isSiteAdmin())
                    .score(value.getScore())
                    .build();
            userCreatorRepository.save(user);
        }
    }

}
