package org.trove;

import gnu.trove.map.hash.TIntObjectHashMap;

public class Example {

	public static void main(String[] args) {
		TIntObjectHashMap<String> map = new TIntObjectHashMap<String>();
		map.put(1, "hahajk.com");
		System.out.println(map.get(1));
	}
	
}
