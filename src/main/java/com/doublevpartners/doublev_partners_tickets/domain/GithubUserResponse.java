package com.doublevpartners.doublev_partners_tickets.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GithubUserResponse {

    int totalCount;
    boolean incompleteResults;
    List<User> items;

}
