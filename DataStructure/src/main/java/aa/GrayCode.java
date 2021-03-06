package aa;

import java.util.ArrayList;
import java.util.List;

/*
 * Gray code
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code,
 * print the sequence of gray code, 
 * A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2].
 * its gray code sequence is:
 * 
 * 00 -- 0
 * 01 -- 1
 * 11 -- 3
 * 10 -- 2
 * 
 * Note: 
 * for a give n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 * For now, the judge is able to judge based on one instance of gray code sequence.
 * Sorry about that.
 * 
 */

public class GrayCode {

	public List<Integer> grayCode(int n) {
        if (n == 0) {
            List<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }
        List<Integer> result = grayCode(n-1);
        int numToAdd = 1 << (n-1);
        
        for (int i = result.size() - 1; i >= 0; i--) {
            result.add(numToAdd + result.get(i));
        }
        return result;
    }
	
}
