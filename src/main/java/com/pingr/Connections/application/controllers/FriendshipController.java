package com.pingr.Connections.application.controllers;

import com.pingr.Connections.application.DTOs.Friendship;
import com.pingr.Connections.core.Account;
import com.pingr.Connections.core.services.CancelFriendship;
import com.pingr.Connections.core.services.EstablishFriendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/friendships")
public class FriendshipController {

    private final EstablishFriendship establishFriendship;
    private final CancelFriendship cancelFriendship;

    @Autowired
    public FriendshipController(EstablishFriendship establishFriendship, CancelFriendship cancelFriendship) {
        this.establishFriendship = establishFriendship;
        this.cancelFriendship = cancelFriendship;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void establishFriendship(@RequestBody Friendship friendship) throws IllegalArgumentException {
        Account a = friendship.getA();
        Account b = friendship.getB();

        this.establishFriendship.validate(a, b);
        this.establishFriendship.between(a, b);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelFriendship(@RequestBody Friendship friendship) throws IllegalArgumentException {
        Account a = friendship.getA();
        Account b = friendship.getB();

        this.cancelFriendship.validate(a, b);
        this.cancelFriendship.between(a, b);
    }
}
