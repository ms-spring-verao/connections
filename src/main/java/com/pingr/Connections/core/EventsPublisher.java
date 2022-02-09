package com.pingr.Connections.core;

public interface EventsPublisher {
    void emitFriendshipEstablished(Account a, Account b);
    void emitFriendshipCanceled(Account a, Account b);
}
