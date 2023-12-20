package matrix;

import java.util.Arrays;

public class GoldMine {

    public static void main(String[] args) {
        int mat[][] = new int[][] {
                {1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}};
        int max = 0;
        int[][] dp = new int[3][3];
        for (int[] ints : dp) Arrays.fill(ints, -1);
        for(int i=0; i< mat.length;i++) {
            int val = collectGold(mat, i, 0, 3, 3,dp);
            max = Math.max(val,max);
        }
        System.out.println(max);
    }

    public static int collectGold(int[][] mat, int x, int y, int r, int c, int[][] dp) {
        //System.out.println("x:" + x + "y:"+y);
        if(x < 0 || y == c || x == r || y < 0) {
            return 0;
        }
        //System.out.print(mat[x][y]);
        if(dp[x][y] != -1) {
            //System.out.println("no cal");
            return dp[x][y];
        }

        System.out.print(mat[x][y]);
        int right = collectGold(mat, x,y+1,r,c,dp);
        //System.out.println("right"+ right);
        int rightUp = collectGold(mat, x-1,y+1,r,c,dp);
        //System.out.println("rightUp"+ rightUp);
        int rightDown = collectGold(mat, x+1, y+1, r ,c,dp);
        //System.out.println("rightDown"+ rightDown);

        int res =  Math.max(right,Math.max(rightUp,rightDown))+mat[x][y];
        dp[x][y]=res;
        return res;

    }
}
