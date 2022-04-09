// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list=new ArrayList<>();
        String[][] grid=new String[n][n];
        for (String[] row : grid)
            Arrays.fill(row, ".");
        return solve(0, grid, n, list);
    }
    
    public static List<List<String>> solve(int row, String[][] grid, int n, List<List<String>> list){
        if(row==n)
        {
            list.add(new ArrayList<String>());
            int listSize=list.size()-1;
            for(int i=0;i<n;i++)
            {
                String s="";
                for(int j=0;j<n;j++)
                    s+=grid[i][j];
                list.get(listSize).add(s);
            }
            return list;
        }
        
        for(int i=0; i<n; i++)
        {
            if(isValid(row, i, n, grid))
            {
                grid[row][i]="Q";
                solve(row+1, grid, n, list);
                grid[row][i]=".";
            }
        }
        return list;
    }
    
    public static boolean isValid(int row, int col, int n, String[][] grid){
        //Col check
        for(int i=0;i<n;i++)
            if(grid[i][col].equals("Q"))
                return false;
        //Row check
        for(int i=0;i<n;i++)
            if(grid[row][i].equals("Q"))
                return false;
        //Diagonal 1 Mid to Top Right
        for(int r=row, c=col; r>=0 && c<n; r--,c++)
            if(grid[r][c].equals("Q"))
                return false;
        //Mid to Bottom Left
        for(int r=row, c=col; r<n && c>=0; r++,c--)
            if(grid[r][c].equals("Q"))
                return false;
        //Diagonal 2 Mid to Bottom Right
        for(int r=row, c=col; r<n && c<n; r++,c++)
            if(grid[r][c].equals("Q"))
                return false;
        //Mid to Top Left
        for(int r=row, c=col; r>=0 && c>=0; r--,c--)
            if(grid[r][c].equals("Q"))
                return false;
        return true;
    } 
}
