//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 132 👎 0

package leetcode.editor.cn;
import java.util.*;
/**
 * 878_第 N 个神奇数字
 * @author Lemon
 * @date 2022-11-22 09:23:36
 */
class P878_NthMagicalNumber{
	 public static void main(String[] args) {
	 	 Solution solution = new P878_NthMagicalNumber().new Solution();
	 }
	 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public final int MOD = (int) (1e9 + 7);
    public int nthMagicalNumber(int n, int a, int b) {

		long l = Math.min(a, b);
		long r = (long) n * Math.min(a, b);
		int c = lcm(a, b);
		while(l <= r) {
			long mid = (l + r) / 2;
			long cnt = mid / a + mid / b - mid / c;
			if(cnt >= n) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return (int)((r + 1) % MOD);
    }

	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}

	private int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
