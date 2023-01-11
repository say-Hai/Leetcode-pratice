//给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。 
//
// 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，那么请你返回 true ，否则返回 false 
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "1210"
//输出：true
//解释：
//num[0] = '1' 。数字 0 在 num 中出现了一次。
//num[1] = '2' 。数字 1 在 num 中出现了两次。
//num[2] = '1' 。数字 2 在 num 中出现了一次。
//num[3] = '0' 。数字 3 在 num 中出现了零次。
//"1210" 满足题目要求条件，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：num = "030"
//输出：false
//解释：
//num[0] = '0' 。数字 0 应该出现 0 次，但是在 num 中出现了两次。
//num[1] = '3' 。数字 1 应该出现 3 次，但是在 num 中出现了零次。
//num[2] = '0' 。数字 2 在 num 中出现了 0 次。
//下标 0 和 1 都违反了题目要求，所以返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// n == num.length 
// 1 <= n <= 10 
// num 只包含数字。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 51 👎 0


package leetcode.editor.cn;

import java.util.HashMap;

/**
 * 2283_判断一个数的数字计数是否等于数位的值
 * @author Lemon
 * @date 2023-01-11 20:57:48
 */
public class P2283_CheckIfNumberHasEqualDigitCountAndDigitValue{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P2283_CheckIfNumberHasEqualDigitCountAndDigitValue().new Solution();
	 }
	 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean digitCount(String num) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < num.length(); i++) {
			if(!map.containsKey(num.charAt(i))) {
				map.put(num.charAt(i), 1);
			} else {
				map.put(num.charAt(i), map.get(num.charAt(i)) + 1);
			}
		}
		for(int i = 0; i < num.length(); i++) {
			char c = (char)(i + '0');
			System.out.println(map.get(c) +  " " + num.charAt(i));
			if(!map.containsKey(c)) {
				if((num.charAt(i) - '0') != 0) {
					return false;
				} else {
					continue;
				}
			}

			else {
				if(map.get(c) != (num.charAt(i) - '0')) {
					return false;
				}
			}
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}