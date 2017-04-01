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

public class TestBlockingSocketChannel2 {
	@Test
	public void client() throws IOException {

		FileChannel fChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);

		SocketChannel sChannel = SocketChannel.open();
		//sChannel.bind(new InetSocketAddress("127.0.0.1", 9091));
		sChannel.connect(new InetSocketAddress("127.0.0.1", 9091));

		ByteBuffer btf = ByteBuffer.allocate(1024);

		while (fChannel.read(btf) != -1) {
			btf.flip();
			sChannel.write(btf);
			btf.clear();
		}
		
		sChannel.shutdownOutput();//关闭输出流，服务端sChannel.read(btf)!=-1循环才会结束

		while (sChannel.read(btf) != -1) {
			btf.flip();
			System.out.println(new String(btf.array(), 0, btf.limit()));
			btf.clear();

		}

		fChannel.close();
		sChannel.close();//会关闭输出流，所以服务端的sChannel.read(btf)!=-1循环才会结束
	}

	@Test
	public void server() throws IOException {
		
		ServerSocketChannel ssChannel=ServerSocketChannel.open();
		ssChannel.bind(new InetSocketAddress(9091));
		
		FileChannel fChannel=FileChannel.open(Paths.get("9.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);
		
		ByteBuffer btf=ByteBuffer.allocate(1024);
		
		
		SocketChannel sChannel = ssChannel.accept();
		
		while(sChannel.read(btf)!=-1){
			btf.flip();
			
			fChannel.write(btf);
			
			btf.clear();
			
		}
		
		
		btf.put("你好，已经处理完毕！".getBytes());
		
		btf.flip();
		sChannel.write(btf);
		
		sChannel.close();
		fChannel.close();
	}

}
