package com.pingr.Connections.application;

import com.pingr.Connections.core.Account;
import com.pingr.Connections.core.EventsPublisher;
import com.pingr.Connections.core.events.FriendshipCanceledEvent;
import com.pingr.Connections.core.events.FriendshipEstablishedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventsPublisher implements EventsPublisher {
    @Value(value = "${topics.fshp_establd}")
    private String friendshipEstablishedTopic;

    @Value(value = "${topics.fshp_deleted}")
    private String friendshipCanceledTopic;

    @Autowired
    private KafkaTemplate<String, Object> template;

    @Override
    public void emitFriendshipEstablished(Account a, Account b) {
        this.template.send(
                this.friendshipEstablishedTopic,
                FriendshipEstablishedEvent.between(a, b));
    }

    @Override
    public void emitFriendshipCanceled(Account a, Account b) {
        this.template.send(
                this.friendshipCanceledTopic,
                FriendshipCanceledEvent.between(a, b));
    }
}
