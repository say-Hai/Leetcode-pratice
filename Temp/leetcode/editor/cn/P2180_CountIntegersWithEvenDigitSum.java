//给你一个正整数 num ，请你统计并返回 小于或等于 num 且各位数字之和为 偶数 的正整数的数目。 
//
// 正整数的 各位数字之和 是其所有位上的对应数字相加的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 4
//输出：2
//解释：
//只有 2 和 4 满足小于等于 4 且各位数字之和为偶数。    
// 
//
// 示例 2： 
//
// 
//输入：num = 30
//输出：14
//解释：
//只有 14 个整数满足小于等于 30 且各位数字之和为偶数，分别是： 
//2、4、6、8、11、13、15、17、19、20、22、24、26 和 28 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 1000 
// 
//
// Related Topics 数学 模拟 👍 20 👎 0

package leetcode.editor.cn;
import java.util.*;
/**
 * 2180_统计各位数字之和为偶数的整数个数
 * @author Lemon
 * @date 2023-01-06 09:05:04
 */
class P2180_CountIntegersWithEvenDigitSum{
	 public static void main(String[] args) {
	 	 Solution solution = new P2180_CountIntegersWithEvenDigitSum().new Solution();
	 }
	 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countEven(int num) {
		int ans = 0;
		for (int i = 1; i <= num; i++) {
			int sum = 0, temp = i;
			while(temp > 0) {
				sum += temp%10;
				temp /= 10;
			}
			if(sum % 2 == 0)
				ans++;
		}
		return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
