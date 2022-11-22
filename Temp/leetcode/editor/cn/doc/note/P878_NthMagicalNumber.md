### 最小公倍数 与 最大公约数
原理：约分法, 两个数的乘积等于这两个数的**最大公因数和最小公倍数的乘积**。

则最大公约数的计算：使用[辗转相除法(原理)](https://blog.csdn.net/weixin_43886797/article/details/85569998)
```
//递归实现
private int gcd(int a, int b) {
		return b != 0 ? gcd(b, a % b) : a;
	}
```
最小公倍数 = a*b / 最大公约数
```
	private int lcm(int a, int b) {
		return a * b / gcd(a, b);
	}
```
### 第n个神奇的数字 → 二分查找
设函数f(x)表示值为x的数字是a、b的第f(x)个神奇数字，且能被 a 整除的数的个数为⌊x/a⌋，能被 b 整除的个数为 ⌊b/x⌋，同时能被a 和b 整除的个数为⌊x/c⌋
````
f(x) = ⌊x/a⌋ + ⌊x/b⌋ - ⌊x/c⌋;
````