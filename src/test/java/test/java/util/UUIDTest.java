package test.java.util;

import java.util.UUID;

public class UUIDTest {
	
	public static void main(String[] args) {
		UUID uuid = UUID.fromString("12-34-56-78-9");
		System.out.println(uuid);
		System.out.println("00000012-0034-0056-0078-000000000009".length());
		System.out.println(UUID.randomUUID().toString().length());
	}

}
