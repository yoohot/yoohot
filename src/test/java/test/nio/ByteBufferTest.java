package test.nio;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import org.junit.Test;

public class ByteBufferTest {

	@Test
	public void test1() throws UnsupportedEncodingException {

		ByteBuffer buffer = ByteBuffer.allocate(1024);
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");

		String str = "hello world";

		buffer.put(str.getBytes("iso-8859-1"));

		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");

		buffer.flip();
		byte[] dst = new byte[200];
		buffer.get(dst);
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");

		buffer.mark();
		buffer.get(dst);
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");

		buffer.reset();
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");

		buffer.rewind();// 重新读        position = 0; mark=-1
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");

		buffer.clear();// 还原，数据仍然在，被遗忘
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		System.out.println("-------------------\n");
	}

	@Test
	public void test2() {
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		buffer.put("abc程".getBytes());
		
		buffer.flip().flip();//flip将limit设置为当前position的值；      limit = position;   position = 0;   mark = -1;
		
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
	}
	
	@Test
	public void testCode() throws UnsupportedEncodingException{
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		
		buffer.put("abc程".getBytes("iso-8859-1"));
		
		buffer.flip();//.flip();
		
		System.out.println(buffer.position());
		System.out.println(buffer.capacity());
		System.out.println(buffer.limit());
		
		byte[] dst=new byte[4];
		buffer.get(dst);
		
		System.out.println(new String(dst,"iso-8859-1"));
		
		
		
		
	}
}
