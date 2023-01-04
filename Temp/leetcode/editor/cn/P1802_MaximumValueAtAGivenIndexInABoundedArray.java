//给你三个正整数 n、index 和 maxSum 。你需要构造一个同时满足下述所有条件的数组 nums（下标 从 0 开始 计数）： 
//
// 
// nums.length == n 
// nums[i] 是 正整数 ，其中 0 <= i < n 
// abs(nums[i] - nums[i+1]) <= 1 ，其中 0 <= i < n-1 
// nums 中所有元素之和不超过 maxSum 
// nums[index] 的值被 最大化 
// 
//
// 返回你所构造的数组中的 nums[index] 。 
//
// 注意：abs(x) 等于 x 的前提是 x >= 0 ；否则，abs(x) 等于 -x 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 4, index = 2,  maxSum = 6
//输出：2
//解释：数组 [1,1,2,1] 和 [1,2,2,1] 满足所有条件。不存在其他在指定下标处具有更大值的有效数组。
// 
//
// 示例 2： 
//
// 输入：n = 6, index = 1,  maxSum = 10
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= maxSum <= 10⁹ 
// 0 <= index < n 
// 
//
// Related Topics 贪心 二分查找 👍 119 👎 0

package leetcode.editor.cn;
import java.util.*;
/**
 * 1802_有界数组中指定下标处的最大值
 * @author Lemon
 * @date 2023-01-04 16:33:12
 */
class P1802_MaximumValueAtAGivenIndexInABoundedArray{
	 public static void main(String[] args) {
	 	 Solution solution = new P1802_MaximumValueAtAGivenIndexInABoundedArray().new Solution();
		  solution.maxValue(4, 2, 6);
	 }
	 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxValue(int n, int index, int maxSum) {
		int l = 1, r = maxSum;
		while(l < r) {
			int mid = (l + r + 1) / 2;
			if(valid(mid, n, index, maxSum)) {
				l = mid;
			} else {
				r = mid - 1;
			}
		}
		return l;
    }
	public boolean valid(int mid, int n, int index, int maxSum) {
		long numSum = mid;
		for(int i = 1; i <= index; i++) {
			if(mid - i > 1) {
				numSum += mid - i;
			} else {
				numSum += 1;
			}
		}
		for(int i = index + 1; i < n; i++) {
			if(mid - i + index > 1) {
				numSum += mid - i + index;
			} else {
				numSum += 1;
			}
		}
		return numSum <= maxSum;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
