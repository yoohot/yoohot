package test;

import java.util.Set;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

public class TableTest {
	
	public static void main(String[] args) {
		
		
		Table<String, String, Integer> htable=HashBasedTable.create();
		htable.put("r1", "c1", 11);
		htable.put("r1", "c2", 12);
		htable.put("r2", "c1", 21);
		htable.put("r2", "c2", 22);
		htable.put("r2", "c2", 22);
		System.out.println(htable.size());
		Set<String> keySet = htable.rowKeySet();
		for(String set :keySet)System.out.println(set);
		System.out.println("====");
		Set<String> keySet2 = htable.columnKeySet();
		for(String set :keySet2)System.out.println(set);

		System.out.println("***");
		
		Table<String, String, String> tree=TreeBasedTable.create();
		
		tree.put("r1", "c1","cell1");
		tree.put("r1", "c2", "cell2");
		tree.put("r2", "c1", "cell3");
		tree.put("r2", "c2", "cell4");
		tree.put("r2", "c2", "cell4");
		System.out.println(tree.size());
		Set<String> tree1 = htable.rowKeySet();
		for(String set :tree1)System.out.println(set);
		System.out.println("====");
		Set<String> tree2 = htable.columnKeySet();
		for(String set :tree2)System.out.println(set);

		
		
	}

}
