package com.doublevpartners.doublev_partners_tickets;

import com.doublevpartners.doublev_partners_tickets.application.create.UserCreator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartupRunner implements CommandLineRunner {

    private final UserCreator userCreator;
    private final static String INITIAL_PARAMETER = "manuel";

    public AppStartupRunner(UserCreator userCreator) {
        this.userCreator = userCreator;
    }


    @Override
    public void run(String... args) throws Exception {
        userCreator.fetchAndSaveUsers(INITIAL_PARAMETER);
    }
}