package test;

import java.util.List;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;

public class PeekIteratorTest {

	public static void main(String[] args) {

		List<Integer> source = Lists.newArrayList();
		source.add(1);
		source.add(2);
		source.add(3);
		source.add(4);

		PeekingIterator<Integer> pk = Iterators.peekingIterator(source.iterator());

		while (pk.hasNext()) {

			if (pk.hasNext() && pk.peek() == 3) {
				System.out.println("---" + pk.next() + "---");
				pk.remove();
			} else {
				System.out.println("***" + pk.next() + "***");
			}
			System.out.println("size:"+source.size());
		}
		

	}

}
