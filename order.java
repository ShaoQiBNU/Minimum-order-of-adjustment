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