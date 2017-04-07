package test.activemq.produceor;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

public class ProducerTest {
	public static void main(String[] args) throws Exception {

/*		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("admin", "cglboy123", ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
		Connection connection = connectionFactory.createConnection();
		Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
		TextMessage textMessage = session.createTextMessage("hello");
		Destination destination = new ActiveMQQueue("queue1");
		textMessage.setJMSDestination(destination);
		MessageProducer producer = session.createProducer(destination);
		producer.send(textMessage);
		session.close();
		connection.close();*/

	}

}
