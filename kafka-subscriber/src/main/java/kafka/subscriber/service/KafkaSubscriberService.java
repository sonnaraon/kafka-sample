package kafka.subscriber.service;

import org.omg.CORBA.SystemException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import kafka.subscriber.domain.Ping;

@Component
public class KafkaSubscriberService {

    @KafkaListener(topics = "${ping.topic.name}", containerFactory = "pingKafkaListenerContainerFactory")
    public void pingListener(Ping ping, Acknowledgment ack) {
        try {
            System.out.println("Recieved ping message: " + ping);
            ack.acknowledge();
        } catch (Exception e) {
        	String msg = "�ý��ۿ� ����ġ ���� ������ �߻��߽��ϴ�";
        	System.out.println("Recieved ping message: " + msg + e);
        }
    }
}