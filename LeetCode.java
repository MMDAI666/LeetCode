import java.util.*;


public class LeetCode {
    public static void main(String[] args) {


    }
}


/*
42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
*/
class Solution {
    public int trap(int[] height) {
        int res=0;
        int n = height.length;
        if (n<=1)return 0;

        int[] lMax = new int[n];//保存从左向右i的最大高度
        lMax[0]=height[0];

        int[] rMax = new int[n];//保存从右向左i的最大高度
        rMax[n-1]=height[n-1];
        int j=n-2;

        //遍历得到lMax和rMax
        for (int i = 1; i < n; i++) {
            lMax[i]=Math.max(height[i],lMax[i-1]);

            rMax[j]=Math.max(height[j],rMax[j+1]);
            j--;
        }

        //计算每个i位置能接的水量
        for (int i = 0; i < n; i++) {
            if (rMax[i]<=height[i] || lMax[i]<=height[i])continue;
            res +=Math.min(rMax[i],lMax[i])-height[i];
        }
        return res;
    }


    //双指针
    public int trap(int[] height){
        int res=0;
        int left=0;
        int n=height.length;
        int right=n-1;

        int lMax=height[left];
        int rMax=height[right];

        while (left<right)
        {
            if (lMax>rMax)
            {
                if (rMax>height[right]) res+=rMax-height[right];
                right--;
                rMax=Math.max(height[right],rMax);
            }
            else {
                if (lMax>height[left]) res+=lMax-height[left];
                left++;
                lMax=Math.max(height[left],lMax);
            }
        }
        return res;

    }
}

