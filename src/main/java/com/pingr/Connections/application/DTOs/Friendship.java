package com.pingr.Connections.application.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pingr.Connections.core.Account;

@JsonSerialize
public class Friendship {
    @JsonProperty
    private Account a;

    @JsonProperty
    private Account b;

    public Friendship() {
    }

    public Friendship(Account a, Account b) {
        this.a = a;
        this.b = b;
    }

    public Account getA() {
        return a;
    }

    public void setA(Account a) {
        this.a = a;
    }

    public Account getB() {
        return b;
    }

    public void setB(Account b) {
        this.b = b;
    }
}
