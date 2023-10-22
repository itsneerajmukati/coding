package matrix;

import java.util.ArrayList;
import java.util.List;

public class NQueen {

    public static void main(String[] args) {
        List<List<Integer>> ans = nQueen(4);
        System.out.println(ans);
    }

    static List<List<Integer>> nQueen(int n) {
        List<List<Integer> > result = new ArrayList<>();
        boolean[] cols = new boolean[n];
        boolean[] leftDiagonal = new boolean[2*n];
        boolean[] rightDiagonal = new boolean[2*n];
        List<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++)temp.add(0);
        solveNQUtil(result,n,0,temp,cols,leftDiagonal,rightDiagonal);
        return result;
    }
    private static void solveNQUtil(List<List<Integer>> result,int n,int row,List<Integer> comb, boolean[] cols
    , boolean[] leftDiagonal , boolean[] rightDiagonal){
        if(row==n){
          // if row==n it means we have successfully placed all n queens.
          // hence add current arrangement to our answer
          // comb represent current combination
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int col = 0;col<n;col++){
            if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
                continue;
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
            comb.set(row,col+1); // incrementing row as index are start from zero
            solveNQUtil(result,n,row+1,comb,cols,leftDiagonal,rightDiagonal);
            cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
        }
    }
    
}
