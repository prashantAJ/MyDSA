class Solution {
    public static int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length, result=0;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) {
            return -1;
        }
        int[][] dir
            = new int[][]{ { 0, 1 }, {1,1}, { 0, -1 }, { 1, 0 }, { -1, 0 }, {1, -1}, {-1 ,1}, {-1,-1} };
        int[][] visited=new int[n][n];
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{0,0});
        visited[0][0]=1;
        while(!q.isEmpty()){
            int count=q.size();
            while(count-- >0){
                int[] indexes=q.poll();
                if(indexes[0] == n-1 && indexes[1] == n-1)
                    return result+1;
                for(int i=0;i<8;i++){
                    int nextR=indexes[0]+dir[i][0];
                    int nextC=indexes[1]+dir[i][1];
                    if(isSafe(nextR, nextC, visited, grid, n)){
                        q.add(new int[]{nextR,nextC});
                        visited[nextR][nextC]=1;
                    }
                }    
            }
            result++;
        }
        return -1;
    }
    public static boolean isSafe(int r, int c, int[][] visited, int[][] grid,int n){
        if(r<0 || r>=n || c<0 || c>=n || visited[r][c]==1 || grid[r][c]==1)
            return false;
        return true;
    }
}
