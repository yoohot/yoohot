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
import java.util.Scanner;

import org.junit.Test;

public class TestNonBlockingSocketChannel {

	@Test
	public void client() throws IOException {

		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9192));
		sChannel.configureBlocking(false);

		ByteBuffer btf = ByteBuffer.allocate(1024);

		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNext()) {
			String s = scanner.next();
			btf.put((new Date().toString()+s).getBytes());
			btf.flip();
			sChannel.write(btf);
			btf.clear();
		}

		sChannel.close();
		scanner.close();
	}

	@Test
	public void server() throws IOException {
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		ssChannel.bind(new InetSocketAddress(9192));
		ssChannel.configureBlocking(false);

		Selector selector = Selector.open();

		ssChannel.register(selector, SelectionKey.OP_ACCEPT);

		 
		while (selector.select() > 0) {
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey key = it.next();
				if (key.isAcceptable()) {
					SocketChannel channel = ssChannel.accept();
					channel.configureBlocking(false);
					channel.register(selector, SelectionKey.OP_READ);
					System.out.println("来自客户端的请求已准备接受：");
				}

				if (key.isReadable()) {
					SocketChannel channel = (SocketChannel) key.channel();
					channel.configureBlocking(false);
					ByteBuffer dst = ByteBuffer.allocate(1024);
					channel.read(dst);
					dst.flip();
					System.out.println(new String(dst.array(), 0, dst.limit()));

				}
				it.remove();
			}

		}

		ssChannel.close();

	}

}
