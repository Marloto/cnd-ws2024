package de.thi.inf.cnd.rest.adapter.outbound.mqtt;

import de.thi.inf.cnd.rest.adapter.outbound.mqtt.dto.NewPostEvent;
import de.thi.inf.cnd.rest.application.ports.outbound.PostEvents;
import de.thi.inf.cnd.rest.domain.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MqttPostEventsImpl implements PostEvents {

    @Autowired
    private MqttService publisher;

    @Override
    public void publishNewPost(Post post) {
        publisher.publishNewPost(NewPostEvent.fromPost(post));
    }
}
