class Solution {
    static int min;
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[][] dir
            = new int[][]{ {1,1}, { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, {1, -1}, {-1 ,1}, {-1,-1} };
        min=Integer.MAX_VALUE;
        int[][] visited=new int[n][n];
        findPath(0, 0, dir, visited, grid, 1);
        return min==Integer.MAX_VALUE ? -1 : min;
    }
    public static void findPath(int r, int c, int[][] dir, int[][] visited, int[][] grid, int count){
        if(r==grid.length-1 && c==grid.length-1){
            if(grid[r][c]==0 && count<min)
                    min=count;
        }
        else{
            
                if(isSafe(r,c,visited,grid,grid.length)){
                    visited[r][c]=1;
                    for(int i=0;i<8;i++){
                        r=r+dir[i][0];
                        c=c+dir[i][1];
                        findPath(r,c,dir,visited,grid,count+1);
                        r=r-dir[i][0];
                        c=c-dir[i][1];
                    }
                    visited[r][c]=0;
                }
        }
        
    }
    public static boolean isSafe(int r, int c, int[][] visited, int[][] grid,int n){
        if(r<0 || r>=n || c<0 || c>=n || visited[r][c]==1 || grid[r][c]==1)
            return false;
        return true;
    }
}
