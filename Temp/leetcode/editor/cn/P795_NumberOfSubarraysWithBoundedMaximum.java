//给你一个整数数组 nums 和两个整数：left 及 right 。找出 nums 中连续、非空且其中最大元素在范围 [left, right] 内的子数组
//，并返回满足条件的子数组的个数。 
//
// 生成的测试用例保证结果符合 32-bit 整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,4,3], left = 2, right = 3
//输出：3
//解释：满足条件的三个子数组：[2], [2, 1], [3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,9,2,5,6], left = 2, right = 8
//输出：7
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 0 <= left <= right <= 10⁹ 
// 
//
// Related Topics 数组 双指针 👍 237 👎 0

package leetcode.editor.cn;
import java.util.*;
/**
 * 795_区间子数组个数
 * @author Lemon
 * @date 2022-11-24 10:25:38
 */
class P795_NumberOfSubarraysWithBoundedMaximum{
	 public static void main(String[] args) {
	 	 Solution solution = new P795_NumberOfSubarraysWithBoundedMaximum().new Solution();
		  int nums[] = new int[]{73,55,36,5,55,14,9,7,72,52};
		  solution.numSubarrayBoundedMax(nums, 32, 69);
	 }
	 
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
		return subArray_len(nums, right) - subArray_len(nums, left - 1);
    }
	public int subArray_len(int[] nums, int count) {
		int len = 0, ret = 0;
		for (int num : nums) {
			len = num <= count ? len + 1 : 0;
			ret += len;
		}
		return ret;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}
