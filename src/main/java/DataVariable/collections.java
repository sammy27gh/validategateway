package DataVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class collections {

	public static void main(String args[]) {

		/*
		 * ArrayList<String> names = new ArrayList<String>(); // names.put();
		 * names.add("frankAye"); names.add("SamuelAndoh");
		 * names.add("Emmanuel Addey");
		 * 
		 * Iterator iter = names.iterator(); // iter.next(); while
		 * (iter.hasNext()) { System.out.println(iter.next()); }
		 */
		// extedTheTreeMap nnn = new extedTheTreeMap();

		// treeMap aa = new treeMap();
		// aa.treeMap();
		hashMap bb = new hashMap();
		bb.hashMap();
		// aa.i;

	}
}

class treeMap {
	// int i = 5;
	void treeMap() {

		TreeMap<String, Integer> names = new TreeMap<String, Integer>();
		names.put("frankAye", 1);
		names.put("SamuelAndoh", 3);
		names.put("Emmanuel Addey", 2);

		// Iterable iter = names.iterable();

		for (Map.Entry m : names.entrySet()) {

			System.out.println(m.getKey() + "please leave me the hell alone" + m.getValue());
		}

		System.out.println(names);

	}

}

class hashMap {
	void hashMap() {

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		hm.put("technical ", 1);
		hm.put("home ", 2);
		hm.put("Tearra ", 3);
		hm.put("Wright ", 4);
		hm.put("hello ", 5);

		for (Map.Entry p : hm.entrySet()) {

			System.out.println(p);
		}

	}
}
