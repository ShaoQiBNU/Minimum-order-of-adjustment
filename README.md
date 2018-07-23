最小调整有序
===========
# 一. 问题描述

> 有一个整数数组，请编写一个函数，找出索引m和n，只要将m和n之间的元素排好序，整个数组就是有序的。注意：n-m应该越小越好，也就是说，找出符合条件的最短序列。给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的起点和终点。(原序列位置从0开始标号,若原序列有序，返回[0,0])。保证A中元素均为正整数。测试样例：[1,4,6,5,9,10],6，返回：[2,3]。

# 二. 求解
> 两种思路，第一种：对数组进行快速排序，时间复杂度为O(nlogn)，然后与原数组对比，第一个不同的数为m，最后一个不同的数为n。第二种思路：从左向右遍历，如果当前最大值之后还有比最大值小的数，说明这个数就是end索引；然后从右向左遍历，如果当前最小值之后还有比最小值大的数，说明这个数就是start索引。时间复杂度为O(n)。第二种思路代码如下：

```JAVA
import java.util.*;

public class order {
    public int[] minAdjust(int[] A, int n) {
        
        // 定义参数
        int[] b={0,0};
        int start=0;
        int end=0;
        int max=A[0];
        int min=A[n-1];
        
        // 个数少于2，则直接return
        if(n<2){
            return b;
        }
        
        // 从左向右，寻找end
        for (int i=0;i<n;i++ ) {
            
            if(A[i]>=max){
                max=A[i];
            }

            else{
                end=i;
            }
            
        }
       
       // 从右向左，寻找start
       for (int i=n-1;i>=0 ;i-- ) {
           
           if(A[i]<=min){
            min=A[i];
           }

           else{
            start=i;
           }
       }

       b[0]=start;
       b[1]=end;

       return b;
    }
    
    public static void main(String[] args){
        order order=new order();
        int n=6;
        int[] A={1,4,6,5,9,10};
        
        int[] res=order.minAdjust(A,n);
        
        for (int i=0;i<2 ;i++ ) {
            System.out.println(res[i]);
        }
        
    }
}
```

