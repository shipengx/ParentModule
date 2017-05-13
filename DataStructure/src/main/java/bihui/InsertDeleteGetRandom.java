package bihui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*
 * Design a data structure that supports all following operations in average O(1) time.
 * 1. insert(val): inserts an item val to the set if not already present.
 * 2. remove(val): removes an item val from the set if present.
 * 3. getRandom: Returns a random element from current set of elements. 
 * Each element must have the same probability of being returned.
 * 
 * Example:
 * 
 * Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * inserts 1 to the set. returns true as 1 was inserted succesfully
 * randomSet.insert(1);
 * 
 * returns false as 2 does not exist in the set
 * randomSet.remove(2);
 * 
 * inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2)
 * 
 * getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom()
 * 
 * removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1)
 * 
 * 2 was already in the set, so return false.
 * randomSet.insert(2)
 * 
 * since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom()
 * 
 */

public class InsertDeleteGetRandom {

	private List<Integer> list;
	private Map<Integer, Integer> map; // value <--> index
	private Random random;

	/** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        list   = new ArrayList<Integer>();
        map    = new HashMap<Integer, Integer>();
        random = new Random();
    }

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		} else {
			map.put(val, list.size());
			list.add(val);
			return true;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		boolean contain = map.containsKey(val);
		if (!contain)
			return false;
		int index = map.get(val);
		if (index < list.size() - 1) { // not the last one than swap the last
										// one with this val
			int lastone = list.get(list.size() - 1);
			list.set(index, lastone);
			map.put(lastone, index);
		}
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(random.nextInt(list.size()));
	}

}
