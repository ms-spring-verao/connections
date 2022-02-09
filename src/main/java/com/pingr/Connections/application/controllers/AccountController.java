package com.pingr.Connections.application.controllers;

import com.pingr.Connections.application.DTOs.AccountFriends;
import com.pingr.Connections.core.services.QueryFriendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(path = "/accounts/{id}/friends")
public class AccountController {
    private final QueryFriendship queryFriendship;

    @Autowired
    public AccountController(QueryFriendship queryFriendship) {
        this.queryFriendship = queryFriendship;
    }

    @GetMapping
    public AccountFriends getFriends(@PathVariable("id") Long id, @RequestParam(required = false) boolean count) {
        if (count) {
            int n = this.queryFriendship.countFriendsOf(id);
            return new AccountFriends(id, n);
        } else {
            Set<Long> ids = this.queryFriendship.getFriendsIdsOf(id);
            return new AccountFriends(id, ids);
        }
    }
}
