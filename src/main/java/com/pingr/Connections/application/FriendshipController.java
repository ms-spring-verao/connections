package com.pingr.Connections.application;

import com.pingr.Connections.application.DTOs.Friendship;
import com.pingr.Connections.core.Account;
import com.pingr.Connections.core.EstablishFriendship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/friendships")
public class FriendshipController {

    private final EstablishFriendship establishFriendship;

    @Autowired
    public FriendshipController(EstablishFriendship establishFriendship) {
        this.establishFriendship = establishFriendship;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void establishFriendship(@RequestBody Friendship friendship) throws IllegalArgumentException {
        Account a = friendship.getA();
        Account b = friendship.getB();

        this.establishFriendship.validate(a, b);
        this.establishFriendship.between(a, b);
    }
}
