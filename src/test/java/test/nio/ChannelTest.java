package test.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

/**
 * 
 * @author cgl - 2017年2月27日上午9:04:56
 * 
 * @description channel 实现文件传输
 *
 */
public class ChannelTest {

	@Test
	public void test1() {// 2550-双向
		Instant start = Instant.now();
		FileInputStream is = null;
		FileOutputStream os = null;
		FileChannel inChannel = null;
		FileChannel outChannel = null;
		try {
			is = new FileInputStream("d:/1.rar");
			os = new FileOutputStream("d:/2.rar");

			inChannel = is.getChannel();
			outChannel = os.getChannel();
			ByteBuffer buf = ByteBuffer.allocate(1024);
			while (inChannel.read(buf) != -1) {
				buf.flip();
				outChannel.write(buf);
				buf.clear();
			}

			// plus
			/*
			 * FileChannel inChannel2= FileChannel.open(Paths.get("5.jpg"),
			 * StandardOpenOption.WRITE, StandardOpenOption.READ,
			 * StandardOpenOption.CREATE);
			 * 
			 * 
			 * while(outChannel.read(buf)!=-1){ buf.flip();
			 * inChannel2.write(buf); buf.clear(); } inChannel2.close();
			 */

		} catch (Exception e) {
			e.printStackTrace(System.out);
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (outChannel != null)
				try {
					outChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if (inChannel != null)
				try {
					inChannel.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis());

	}

	@Test
	public void test2() throws IOException {// 620
		Instant start = Instant.now();
		FileChannel inChannel = FileChannel.open(Paths.get("d:/1.rar"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("d:/4.rar"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);
		MappedByteBuffer inBuf = inChannel.map(MapMode.READ_ONLY, 0, inChannel.size());
		MappedByteBuffer outBuf = outChannel.map(MapMode.READ_WRITE, 0, inChannel.size());
		byte[] dst = new byte[inBuf.limit()];
		inBuf.get(dst);
		outBuf.put(dst);

		/*
		 * ByteBuffer dst = ByteBuffer.allocateDirect(1024);
		 * while(inChannel.read(dst)!=-1){
		 * 
		 * dst.flip(); outChannel.write(dst); dst.clear(); }
		 */
		inChannel.close();
		outChannel.close();
		Instant end = Instant.now();
		System.out.println(Duration.between(start, end).toMillis());
	}

	@Test
	public void test3() throws IOException {
		FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		FileChannel outChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

		inChannel.transferTo(0, inChannel.size(), outChannel);

		System.out.println(inChannel.size());
		System.out.println(inChannel.position());
		inChannel.close();
		outChannel.close();

	}

	/*
	 * 分散(Scatter)与聚集(Gather)
	 */
	@Test
	public void test4() throws Exception {

		FileChannel channel1 = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
		FileChannel channel2 = FileChannel.open(Paths.get("6.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ByteBuffer buf2 = ByteBuffer.allocate(25324);

		channel1.read(new ByteBuffer[] { buf1, buf2 });

		buf1.flip();
		buf2.flip();

		channel2.write(new ByteBuffer[] { buf2, buf1 });

		channel1.close();
		channel2.close();

	}

}
