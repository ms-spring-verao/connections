package com.pingr.Connections.application.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Set;

@JsonSerialize
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountFriends {
    @JsonProperty
    private Long accountId;

    @JsonProperty
    private int friendsCount;

    @JsonProperty
    private Set<Long> friendsIds;

    public AccountFriends() {
    }

    public AccountFriends(Long accountId, int friendsCount) {
        this.accountId = accountId;
        this.friendsCount = friendsCount;
    }

    public AccountFriends(Long accountId, Set<Long> friendsIds) {
        this.accountId = accountId;
        this.friendsIds = friendsIds;
    }

    public AccountFriends(Long accountId, int friendsCount, Set<Long> friendsIds) {
        this.accountId = accountId;
        this.friendsCount = friendsCount;
        this.friendsIds = friendsIds;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(int friendsCount) {
        this.friendsCount = friendsCount;
    }

    public Set<Long> getFriendsIds() {
        return friendsIds;
    }

    public void setFriendsIds(Set<Long> friendsIds) {
        this.friendsIds = friendsIds;
    }
}
