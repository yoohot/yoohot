package test.activemq.topic;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class Publisher {

	public static final String topic = "yoohot.topic";
	
	public static void main(String[] args) throws JMSException {
		send();
	}

	public static void send() throws JMSException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection = factory.createConnection("admin", "cglboy123");

	

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Topic topic2 = session.createTopic(topic);

		TextMessage message = session.createTextMessage("topic.hello world----");

		MessageProducer producer = session.createProducer(topic2);

		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		connection.start();

		producer.send(message);
		
		//producer.close();

	}

}
