package com.pingr.Connections.core.events;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pingr.Connections.core.Account;

import java.util.HashMap;
import java.util.Map;

@JsonSerialize
public class FriendshipEstablishedEvent {

    @JsonProperty
    private String eventType;

    @JsonProperty
    private Map<String, Object> payload;

    public FriendshipEstablishedEvent() {
    }

    public FriendshipEstablishedEvent(String eventType, Map<String, Object> payload) {
        this.eventType = eventType;
        this.payload = payload;
    }

    public static FriendshipEstablishedEvent between(Account a, Account b) {
        Map<String, Object> payload = new HashMap<String, Object>();
        payload.put("either", a);
        payload.put("other", b);

        return new FriendshipEstablishedEvent(
                "FriendshipEstablishedEvent",
                payload
        );
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }

    public void setPayload(Map<String, Object> payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "AccountCreatedEvent{" +
                "eventType='" + eventType + '\'' +
                ", payload=" + payload +
                '}';
    }
}
