package test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.Maps;

public class SelectionKeyAttachmentTest {

	@Test
	public void client() throws IOException {
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6379));
		sChannel.configureBlocking(false);
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		bbf.put((new Date() + ":你好，我是client1").getBytes());
		bbf.flip();
		sChannel.write(bbf);
		bbf.clear();
		sChannel.close();
	}
	
	@Test
	public void client2() throws IOException {
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 6379));
		sChannel.configureBlocking(false);
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		bbf.put((new Date() + ":你好，我是client2").getBytes());
		bbf.flip();
		sChannel.write(bbf);
		bbf.clear();
		sChannel.close();
	}

	@Test
	public void server() throws IOException, InterruptedException {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		ssChannel.configureBlocking(false);
		ssChannel.bind(new InetSocketAddress(6379));
		Selector selector = Selector.open();
		ssChannel.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0) {
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey sk = it.next();
				if (sk.isAcceptable()) {
					ServerSocketChannel ss = (ServerSocketChannel) sk.channel();
					SocketChannel sChannel = ss.accept();
					sChannel.configureBlocking(false);
					sChannel.register(selector, SelectionKey.OP_READ);
				} else if (sk.isReadable()) {
					SocketChannel sChannel = (SocketChannel) sk.channel();
					ByteBuffer buf = ByteBuffer.allocate(1024);
					int len = 0;
					len= sChannel.read(buf);
					while (len> 0) {
						buf.flip();
						System.out.println(new String(buf.array(), 0, len));
						buf.clear();
						len= sChannel.read(buf);
					}
				}
				//it.remove();//不移除的后果是本次的就绪的key集合下次会再次返回,导致无限循环，CPU消耗100%
			}
		}
		ssChannel.close();
	}

}
