# 1802_有界数组中指定下标处的最大值
## 问题分析：
> 根据题意可知，需要保证nums[index]为最大值，且相邻元素差1，则可想到通过贪心思维，
> 保证nums[index]最大，且整个数组成一个金字塔结构，则确定了nums[index]上的元素，
> 即可确定整个数组的元素 → 计算出整个数组之和的大小numSum。再通过二分法找到最大符合
> numSum <= maxSum的nums[index].即为我们要求的结果。
## 解题思路：
> 要使用二分法首先确定左边界left、右边界right和中间mid，然后计算出以mid作为nums[index]时，
> 整个数组元素之和，再比较与maxSum的大小
> ① 若numSum <= maxSum，则left = mid（区间往右移动，说明结果在右侧）
> ② 若numSum > maxSum，则right = mid - 1（区间往左移动，且右边界不包含mid）
### **如何计算整个数组元素之和？**
**方法一：直接通过for循环进行计算**
> 通过for循环求出index左侧，同理可求出右侧元素之和
```
for(int i = 1; i <= index; i++) {
	if(mid - i > 1) {
		numSum += mid - i;
	} else {
		numSum += 1;
	}
}
```
> 问题所在（优化点）：等差数列之和，没有必要通过for循环来增加时间复杂度，而是可以通过数学方法计算。

**方法二：通过等差数列求和公式计算**
> 在利用等差公式时，需要考虑边界条件为1时的情况。
> 即通过比较index左侧长度(index [0,...,index - 1])/右侧长度(n - index - 1 [index+1,..., n - 1]) 与 mid之间的大小关系
```
if(length + 1 < mid) {//length长度代表左/右侧数组元素个数
     int small = mid - length;
     return (long) (mid - 1 + small) * length / 2;//[small,...,mid-1]之和：n*(a1 + an)/2
} else {
    int oneNum = length - mid + 1;//多余1的个数。[1,1,...,1,2,...,mid - 1].其中[1,2,...,mid-1]长度为mid-1，则[1,...,1]长度为 length - (mid - 1).
    return (long)(mid + 1)*mid/2 + oneNum;
}
时间复杂度：O(1)
```