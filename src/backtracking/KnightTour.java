package backtracking;

public class KnightTour {
    public static void main(String[] args) {
        int[][] sol = new int[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                sol[i][j]=-1;
            }
        }

        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

        sol[0][0]=0;
        if(solveKTUtil(0,0,sol,xMove,yMove,1)) {
            for(int i=0;i<sol.length;i++) {
                for(int j=0;j<sol[i].length;j++) {
                    System.out.print(sol[i][j]+"");
                }
            System.out.println("");
            }
        }else {
            System.out.println("no solution");
        }
        

    }

    static boolean solveKTUtil(int x, int y, 
                               int sol[][], int xMove[],
                               int yMove[],int movei)
    {
        int  next_x, next_y;
        if (movei == 64)
            return true;
  
        for (int k = 0; k < 8; k++) {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y, sol)) {
                sol[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y,sol, xMove, yMove,movei + 1))
                    return true;
                else
                    sol[next_x][next_y]= -1; // backtracking
            }
        }
  
        return false;
    }

    static boolean isSafe(int x, int y, int sol[][])
    {
        return (x >= 0 && x < 8 && y >= 0 && y < 8
                && sol[x][y] == -1);
    }

}

