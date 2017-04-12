package test.activemq.p2p;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class P2PProducer {
	public static void main(String[] args) throws Exception {
              send(10);
	}

	//tcp://localhost:61616
	
	public static void send(int num) throws JMSException{
		
		ActiveMQConnectionFactory factory=new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection connection=factory.createConnection("admin","cglboy123");
		
		connection.start();
		
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination=session.createQueue("tx-auto");
		
		MessageProducer producer = session.createProducer(destination);
		
		producer.setDeliveryMode(DeliveryMode.PERSISTENT);
		
		for(int i=0;i<num;i++){
			TextMessage message = session.createTextMessage("hello-world:"+i);
			if(i%2==0){
				message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);
			}
			
			producer.send(message);
			
		}
		
		
		
		
		/*			producer.close();
		
	session.close();
		
		connection.close();
		*/
	}
}
