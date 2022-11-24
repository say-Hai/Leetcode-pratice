### 区间计数法
题意求在区间[l, r]之间的子数组， 可将问题**转换成在区间[0, r]的子数组个数 - [0, l - 1]子数组的个数**
####  函数f(x)
Q：为什么子数组的个数 += 它的长度 ?
````
ret += len;
````
A：根据数学归纳法，已知长度为n的数组的子数组个数为ret， 则长度为n+1的子数组长度为 ret + (n+1)*（除了新增的一个元素为一个子数组，还与前面n个元素可以组成n个新的子数组）*
````
public int subArray_len(int[] nums, int count) {
		int len = 0, ret = 0;
		for (int num : nums) {
			len = num <= count ? len + 1 : 0;
			ret += len;
		}
		return ret;
	}
````