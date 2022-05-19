class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length, m=grid[0].length;
        int[][] visited=new int[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    makeIsland(i, j, visited, grid);
                    count++;
                }
                    
            }
        }
        return count;
    }
    public void makeIsland(int r, int c, int[][] visited, char[][] grid){
        int[][] dir=new int[][]{{0,-1}, {0, 1}, {-1,0}, {1, 0}};
        visited[r][c]=1;
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
            int count=q.size();
            while(count-- > 0){
                int[] indexes=q.poll();
                for(int i=0;i<4;i++){
                    int nextR=indexes[0]+dir[i][0];
                    int nextC=indexes[1]+dir[i][1];
                    if(isSafe(nextR, nextC, visited, grid)){
                        q.add(new int[]{nextR,nextC});
                        visited[nextR][nextC]=1;
                    }
                }
            }
        }
    }
    public boolean isSafe(int r, int c, int[][] visited, char[][] grid){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || visited[r][c]==1 || grid[r][c]=='0')
            return false;
        return true;
    }
}
