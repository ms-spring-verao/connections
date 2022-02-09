package com.pingr.Connections.core;

import com.pingr.Connections.core.exceptions.AccountNotFoundException;
import com.pingr.Connections.core.exceptions.FriendshipValidationException;
import com.pingr.Connections.core.exceptions.SelfFriendshipException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CancelFriendship {
    private final AccountRepository repo;
    private final EventsPublisher publisher;

    @Autowired
    public CancelFriendship(AccountRepository repo, EventsPublisher publisher) {
        this.repo = repo;
        this.publisher = publisher;
    }

    private void ensureExistence(Account account) throws AccountNotFoundException {
        Optional<Account> optional = this.repo.findById(account.getId());

        if (optional.isEmpty()) {
            throw new AccountNotFoundException(account);
        }
    }

    private void ensureDifferentAccounts(Account accountA, Account accountB) {
        if (accountA.equals(accountB)) {
            throw new SelfFriendshipException(accountA);
        }
    }

    public void validate(Account a, Account b) throws IllegalArgumentException {
        try {
            this.ensureExistence(a);
            this.ensureExistence(b);
            this.ensureDifferentAccounts(a, b);
        } catch (FriendshipValidationException fve) {
            throw new IllegalArgumentException(fve.getMessage());
        }
    }

    public void between(Account a, Account b) {
        a.removeFriend(b);
        b.removeFriend(a);
        this.repo.saveAll(List.of(a, b));
        this.publisher.emitFriendshipCanceled(a, b);
    }
}
