# 考场就座问题
## 1、解题思路
利用TreeSet数据结构的特点，来对数据进行处理。
**特点**
> TreeSet是一个**有序**的且**没有重复元素**的集合。
> 底层实际使用的存储容器就是TreeMap
> TreeSet中的元素必须实现Comparable接口并重写**compareTo()**方法，TreeSet判断元素是否重复 、以及确定元素的顺序靠的都是这个方法；
> 不保留元素的插入顺序
> 不是线程安全的(但可以使用Collections.synchronizedSet（）包装器在外部进行同步)
## 2、 代码思路
1、通过dist来确定在两个元素之间最大距离的位置
2、区间范围为[prev, s]，d表示离两端最远的元素位置，即 *prev + (s - prev) / 2;*
3、最后再计算出最右端元素和边界元素之间的距离，即[last, N-1]的距离。
4、得出所有距离中的最大值
```
if(students.size() > 0) {
    int dist = students.first(); //位置0和第一个元素的距离
    Integer prev = null;//第一个元素没有前驱节点，即为null
    for (Integer s : students) {
        if(prev != null) {
            int d = (s - prev) / 2;
            if(d > dist) {
                dist = d;
                student = prev + d;
            }
        }
        prev = s;
    }
    if( N - 1 - students.last() > dist) {
        student = N - 1;
    }
}
```