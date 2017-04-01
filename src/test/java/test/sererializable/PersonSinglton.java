package test.sererializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class PersonSinglton implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;

	private PersonSinglton(String name) {
		this.name = name;
	};

	private static PersonSinglton person = null;// new PersonSinglton("cgl");//
												// null;

	public static synchronized PersonSinglton getInstance() {
		if (person == null)
			return person = new PersonSinglton("cgl");
		return person;
	}

	private Object writeReplace() throws ObjectStreamException {
		System.out.println("1 write replace start");

		return this;
	}

	private void writeObject(java.io.ObjectOutputStream out) throws IOException {
		System.out.println("2 write object start");
		out.defaultWriteObject();

	}

	private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("3 read object start");

		in.defaultReadObject();

	}

	private Object readResolve() throws ObjectStreamException {
		System.out.println("4 read resolve start");

		return PersonSinglton.getInstance();

	}

	public static void main(String[] args) throws Exception {

		FileOutputStream out = new FileOutputStream(new File("D://person.dat"));

		ObjectOutputStream op = new ObjectOutputStream(out);

		op.writeObject(PersonSinglton.getInstance());

		op.close();

		FileInputStream in = new FileInputStream(new File("D://person.dat"));
		ObjectInputStream oi = new ObjectInputStream(in);
		Object person = oi.readObject();
		in = new FileInputStream(new File("D://person.dat"));
		oi = new ObjectInputStream(in);
		PersonSinglton person1 = (PersonSinglton) oi.readObject();

		System.out.println("sington person hashcode:" + person.hashCode());
		System.out.println("sington person1 hashcode:" + person1.hashCode());
		System.out.println("sington getInstance hashcode:" + PersonSinglton.getInstance().hashCode());
		System.out.println("sington person equals:" + (person == PersonSinglton.getInstance()));
		System.out.println("person equals1:" + (person1 == person));

	}

}
