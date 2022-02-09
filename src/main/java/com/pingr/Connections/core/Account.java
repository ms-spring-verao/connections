package com.pingr.Connections.core;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Account {
    @Id
    private Long id;

    @ElementCollection
    private Set<Long> friendsIds;

    public Account() {
        this.friendsIds = new HashSet<>();
    }

    public Account(Long id) {
        this.id = id;
        this.friendsIds = new HashSet<>();
    }

    public Account(Long id, Set<Long> friendsIds) {
        this.id = id;
        this.friendsIds = friendsIds;
    }

    public void addFriend(Account account) {
        this.friendsIds.add(account.getId());
    }

    public void removeFriend(Account account) {
        this.friendsIds.remove(account.getId());
    }

    public Set<Long> getFriendsIds() {
        return friendsIds;
    }

    public void setFriendsIds(Set<Long> friendsIds) {
        this.friendsIds = friendsIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getId(), account.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                '}';
    }

}
