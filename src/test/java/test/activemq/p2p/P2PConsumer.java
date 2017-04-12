package test.activemq.p2p;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class P2PConsumer {
	
	
	public static void main(String[] args) {
		try {
			consumer();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

	public static void consumer() throws JMSException {

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

		Connection connection = factory.createConnection("admin", "cglboy123");
		
		connection.start();

		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		Destination queue = session.createQueue("tx-auto");

		MessageConsumer consumer = session.createConsumer(queue);

/*		consumer.setMessageListener(new MessageListener() {

			@Override
			public void onMessage(Message message) {
				try {
					System.out.println(((TextMessage) message).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}

			}
		});*/
		
		for(;;){
			Message message = consumer.receive(10000);
			if(message==null) break;
			System.out.println(((TextMessage) message).getText());
			System.out.println("----------------");
		}
		
/*		consumer.close();
	session.close();
		connection.close();*/

	}

}
