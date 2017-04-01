package test.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

/**
 * 利用Channel进行阻塞式的网络通信，服务端无响应回复
 * @author cgl   -   2017年3月1日上午9:20:54  
 * @description
 *
 */
public class TestBlockingServerChannel {

	
	/**
	 * 客户端
	 * @throws IOException
	 */
	@Test
	public void client() throws IOException {

		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9090));

		FileChannel fChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

		ByteBuffer btf = ByteBuffer.allocate(1024);
		
		while(fChannel.read(btf)!=-1){
			btf.flip();
			sChannel.write(btf);
			btf.clear();
		}
		
		sChannel.close();
		fChannel.close();
	}

	@Test
	public void server() throws IOException {
		ServerSocketChannel ssChannel=ServerSocketChannel.open();
		ssChannel.bind(new InetSocketAddress(9090));
		
		FileChannel fChannel=FileChannel.open(Paths.get("7.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		ByteBuffer btf=ByteBuffer.allocate(1024);
		
		SocketChannel sChannel = ssChannel.accept();
		
		while(sChannel.read(btf)!=-1){
			btf.flip();
			fChannel.write(btf);
			btf.clear();
		}

		fChannel.close();
		sChannel.close();
		ssChannel.close();
	}

}
