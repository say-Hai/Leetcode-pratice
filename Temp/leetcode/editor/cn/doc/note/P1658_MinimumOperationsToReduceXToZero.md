# 1658_将 x 减到 0 的最小操作数
## 解法1：通过逆向思维进行计算
> 从（可以看作循环数组）数组中找出一个子数组使其之和等于x，可将问题转换成从数组中找出一个子数组，使其和sum满足条件：**numSum - sum = x;**
> 则剩下的子数组即为我们要求的结果。
```java
int target = -x;
for (int num : nums) {
    target += num;
}
```
如何找到子数组使其和等于target？
> 使用双指针实现：确定左右指针→left、right。
>
>①：当target > sum 时，移动右指针使窗口扩大，则元素之和sum 增大。
>
>②：当窗口内元素之和sum > target时，将左指针向右移动，缩小窗口大小，直到sum <= target。
>
> ③：当sum == target时，则找出满足条件的窗口，返回结果。
```java
for(int right = 0; right < n; right++) {
    sum += nums[right];
    while(sum > target) {
        sum -= nums[left++];
    }
    if(sum == target)
        ans = Math.max(ans, right - left + 1);}
}
```
*注：一般把窗口大小不固定的叫做双指针，窗口大小固定的叫做滑动窗口。*