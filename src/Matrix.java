public class Matrix {

    public static void main(String[] args) {
        spiralPrint();
    }
    static boolean[][] seen;
    static int row , col;
    static int a[][] = { { 1, 2, 3, 4 },
    { 5, 6, 7, 8 },
    { 9, 10, 11, 12 },
    { 13, 14, 15, 16 } };
    public static void spiralPrint() {
       
        row = a.length;
        col = a[0].length;
        seen = new boolean[row][col];
        int rowPointer=0,colPointer = 0;
        right(rowPointer, colPointer);
    }

    public static void right(int rowPointer, int colPointer) {
        while(colPointer < col) {
            System.out.println(a[rowPointer][colPointer]);
            seen[rowPointer][colPointer]=true;
            colPointer++;
            if(colPointer == col-1 || seen[rowPointer][colPointer]) {
                down(rowPointer,colPointer);
            }
        }
    }
    public static void down(int rowPointer, int colPointer) {
        while(rowPointer < row) {
            System.out.println(a[rowPointer][colPointer]);
            seen[rowPointer][colPointer]=true;
            rowPointer++;
            if(rowPointer == row-1 || seen[rowPointer][colPointer]) {
                left(rowPointer, colPointer);
            } 
            
        }
        
    }
    public static void left(int rowPointer, int colPointer) {
        while(colPointer >= 0) {
            System.out.println(a[rowPointer][colPointer]);
            seen[rowPointer][colPointer]=true;

            colPointer--;
            if(colPointer == 0 || seen[rowPointer][colPointer]) {
                up(rowPointer,colPointer);
            }
        }
    }
    public static void up(int rowPointer, int colPointer) {
        while(rowPointer >= 0) {
            System.out.println(a[rowPointer][colPointer]);
            seen[rowPointer][colPointer]=true;
            rowPointer--;
            if(rowPointer == 0 || seen[rowPointer][colPointer]) {
                right(rowPointer, colPointer);
            } 
            
        }
    }

}