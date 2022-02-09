package com.pingr.Connections.core.services;

import com.pingr.Connections.core.Account;
import com.pingr.Connections.core.AccountRepository;
import com.pingr.Connections.core.exceptions.AccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class QueryFriendship {

    private final AccountRepository repo;

    @Autowired
    public QueryFriendship(AccountRepository repo) {
        this.repo = repo;
    }

    private Account findAccount(Long id) throws AccountNotFoundException {
        Optional<Account> optionalAccount = this.repo.findById(id);

        if (optionalAccount.isEmpty()) {
            throw new AccountNotFoundException(new Account(id));
        }

        return optionalAccount.get();
    }

    public int countFriendsOf(Long id) throws IllegalArgumentException {
        try {
            return this.findAccount(id).getFriendsIds().size();
        } catch (AccountNotFoundException anf) {
            throw new IllegalArgumentException(anf.getMessage());
        }
    }

    public Set<Long> getFriendsIdsOf(Long id) throws IllegalArgumentException {
        try {
            return this.findAccount(id).getFriendsIds();
        } catch (AccountNotFoundException anf) {
            throw new IllegalArgumentException(anf.getMessage());
        }
    }
}
