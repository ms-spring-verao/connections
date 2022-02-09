package com.pingr.Connections.core.exceptions;

import com.pingr.Connections.core.Account;

public class AccountNotFoundException extends FriendshipValidationException {
    public AccountNotFoundException(Account account) {
        super("Account id=" + account.getId() + " not found");
    }
}
