https://leetcode.com/problems/count-sub-islands/
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int result=0;
        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j]==1){
                    if(!makeIsland(i,j,grid1,grid2))
                        result++;
                }
            }
        }
        return result;
    }
    public boolean makeIsland(int r, int c, int[][] grid1, int[][] grid2){
        boolean flag=false;
        int[][] dir=new int[][]{{0,-1}, {0, 1}, {-1,0}, {1, 0}};
        grid2[r][c]=0;
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{r,c});
        while(!q.isEmpty()){
                int[] indexes=q.poll();
                if(grid1[indexes[0]][indexes[1]]!=1)
                    flag=true;
                for(int i=0;i<4;i++){
                    int nextR=indexes[0]+dir[i][0];
                    int nextC=indexes[1]+dir[i][1];
                    if(isSafe(nextR, nextC, grid2)){
                        q.add(new int[]{nextR,nextC});
                        grid2[nextR][nextC]=0;
                    }
                }
        }
        return flag;
    }
    public boolean isSafe(int r, int c, int[][] grid2){
        if(r<0 || r>=grid2.length || c<0 || c>=grid2[0].length || grid2[r][c]==0)
            return false;
        return true;
    }
}
