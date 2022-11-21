题意：给你n毫升A，B的汤，随机用四种方式分完，求A先被分完 + A、B同时分完/2 的概率和。
### 解法一 暴力搜索树
暴力搜索树：每次所有汤都有四种情况，则所有的情况构成了一个四叉树，我们仅需查找到我们所需要的路径即可。
````
private Map<Integer, int[]> map = new HashMap<Integer, int[]>() {{
		 put(1, new int[] {100, 0});
		 put(2, new int[] {75, 25});
		 put(3, new int[] {50, 50});
   		 put(4, new int[] {25, 75});
    }
};
private double dfs(int A, int B) {
	if(A <= 0) {
		if(B<= 0) {
			return 0.5;
		}
		return 1d;
	}
	if(A > 0 && B < 0) {
		return 0;
	}
	double ret = 0;
	for(int i = 1; i <= 4; i++) {
		int []choice = map.get(i);
		ret += dfs(A - choice[0], B - choice[1])*0.25;
	}
	return ret;
}
````
### 解法二 动态规划
可以看到暴力搜索树会有许多次重复的查询操作，则可以利用自底向上的动规来解决此问题。<br/>
**如何处理动规数组边界问题？**<br/>
如题：<br/>
①当动规数组**dp[i][0]**时，则此时A还未分完而B已经全部分完，此时不可能再把A分完，则概率ret= 0<br/>
②当动规数组**dp[0][0]**时，两者全部分完，则ret = 1/2 = 0.5（由题意得）<br/>
③当动规数组**dp[0][i]**时，A已全部分完，则ret = 1（题意）

