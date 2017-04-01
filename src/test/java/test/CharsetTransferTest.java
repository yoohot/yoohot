package test;

public class CharsetTransferTest {

	public static void main(String[] args) throws Exception {

		System.out.println("中国".getBytes("utf-8").length);
		System.out.println("中国".getBytes("ISO-8859-1").length);
		System.out.println("中国".getBytes("gbk").length);

		System.out.println(new String("中国".getBytes("utf-8"), "ISO-8859-1"));

		String iso = new String("中国".getBytes("utf-8"), "ISO-8859-1");

		System.out.println(iso);
		System.out.println(new String(iso.getBytes("iso-8859-1"), "utf-8"));

	}

}
