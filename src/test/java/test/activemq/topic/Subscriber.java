package test.activemq.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicSession;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;
/**
 * 
 * 消息持久化和持久订阅：
 * 
 * 两者完全不相同的概念
 *  消息持久化是broker在down掉后是否持久化消息
 *  持久化订阅是在订阅者inactive后恢复到active是否能获取非inactive时间断的消息。
 * 
 * 
 * 
 * 持久订阅
 *    发送者发送消息给jms provider，如果此时provider发现没有任何的消费者(包括在线/离线)，那么就会认为该消息无用，不需要存储，会直接删除。
   如果有在线的消费者，那么provider会将消息直接传送给在线消费者，因为这个时候连接是通的，消息有传输的通道。
   如果有离线的消费者，那么provider会把属于该消费者的消息存储下来，等消费者在线的时候，在将保存的离线消息推送给它。对于持久订阅者，jms 
provider会在该消费者第一次登录在线的时候，将它的身份信息记录下来。记录身份的关键就是clientId和订阅者name。当持久订阅者又重新在线的时 候，
   provider会根据当前连接的clientId和订阅者name，去查询属于它的离线消息，并进行推送。
 * 
 * @author cgl   -   2017年4月12日上午11:02:12  
 *  
 * @description
 *
 */
public class Subscriber {
	
	public static final String topic = "yoohot.topic1";

	public static void main(String[] args) throws JMSException {
		consume();
	}
	
	public static void consume() throws JMSException{
		

		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		   TopicConnection connection = factory.createTopicConnection("admin", "cglboy123");
		
		   connection.setClientID("123");
	
		
		
		 TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Topic topic2 = session.createTopic(topic);
		
		  TopicSubscriber subscriber = session.createDurableSubscriber(topic2, "yoohot.topic.session1");
		
			connection.start();
		  
		  subscriber.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				try {
					System.out.println(((TextMessage) message).getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
				System.out.println("----------------");
			}
		});
		
		
		
	//	consumer.close();
	}

}
