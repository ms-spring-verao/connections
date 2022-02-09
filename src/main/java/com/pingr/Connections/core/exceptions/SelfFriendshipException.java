package com.pingr.Connections.core.exceptions;

import com.pingr.Connections.core.Account;

public class SelfFriendshipException extends FriendshipValidationException {
    public SelfFriendshipException(Account account) {
        super("Cannot establish friendship with themselves {Account id=" + account.getId() + "} ");
    }
}
