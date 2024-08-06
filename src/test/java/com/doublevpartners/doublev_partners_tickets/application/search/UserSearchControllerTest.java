package com.doublevpartners.doublev_partners_tickets.application.search;

import com.doublevpartners.doublev_partners_tickets.domain.User;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.controller.search.UserSearchController;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.mapper.UserRestMapper;
import com.doublevpartners.doublev_partners_tickets.infrastructure.rest.response.UserResponse;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
public class UserSearchControllerTest {

    private static final String USER_PATH = "/user";

    @Mock
    private UserSearcher userSearcher;

    @Mock
    private UserRestMapper userRestMapper;

    @InjectMocks
    private UserSearchController userSearchController;

    protected MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userSearchController)
                .build();
    }

    @Test
    public void whenFindUser_GivenNotValidParameters_thenResponseIsOk() {
        String login = "testLogin";
        User user = buildUserResponse();

        when(userSearcher.findByLogin(login)).thenReturn(user);

        UserResponse result = userSearchController.search(login);

        assertEquals(userRestMapper.toResponse(user), result);
    }

    private User buildUserResponse() {
        EasyRandom easyRandom = new EasyRandom();
        return easyRandom.nextObject(User.class)
                .withId(Long.valueOf(123))
                .withLogin("maguilar89")
                .withUrl("https://github.com/manuel");
    }


}
