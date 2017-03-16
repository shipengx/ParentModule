package aa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/*
 * Insert delete getRandom O(1)
 * 
 * Design a data structure that supports all following operations in average O(1) time.
 *     1. insert(val): inserts an item val to the set if not already present.
 *     2. remove(val): removes an item from the set if present.
 *     3. getRandom: returns a random element from current set of elements, each element must have the same probability of being returned.
 *     
 *    Example:
 *    // Init an empty set.
 *    RandomizedSet randomSet = new RandomizedSet();
 *    // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 *    randomSet.insert(1);
 *    // Returns false as 2 does not exist in the set.
 *    randomSet.remove(2);
 *    // Inserts 2 to the set, returns true. Set now contains [1,2].
 *    randomSet.insert(2);
 *    // getRandom should return either 1 or 2 randomly.
 *    randomSet.getRandom();
 *    // Removes 1 from the set, returns true. Set now contains [2].
 *    randomSet.remove(1);
 *    // 2 was already in the set, so return false.
 *    randomSet.insert(2);
 *    
 *    // Since 2 is the only number in the set, getRandom always return 2.
 *    randomSet.getRandom()
 * 
 */

public class InsertDeleteGetRandomO1 {

	ArrayList<Integer> nums;
	Map<Integer, Integer> map;
	Random r;

	/** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        nums = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
        r = new Random();
    }

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		map.put(val, nums.size());
		nums.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		int location = map.get(val);
		if (location < nums.size() - 1) {
			int lastone = nums.get(nums.size() - 1);
			nums.set(location, lastone);
			map.put(lastone, location);
		}

		map.remove(val);
		nums.remove(nums.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return nums.get(r.nextInt(nums.size()));
	}

}
