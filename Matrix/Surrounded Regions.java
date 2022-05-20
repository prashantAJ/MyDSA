https://leetcode.com/problems/surrounded-regions/
class Solution {
    public void solve(char[][] board) {
        int n=board.length, m=board[0].length;
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')
                makeIsland(i, 0, board, '+');
            if(board[i][m-1]=='O')
                makeIsland(i, m-1, board, '+');
        }
        for(int i=0;i<m;i++){
            if(board[0][i]=='O')
                makeIsland(0, i, board, '+');
            if(board[n-1][i]=='O')
                makeIsland(n-1, i, board, '+');
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='+')
                    board[i][j]='O';
                else
                    board[i][j]='X';
            }
        }
    }
    public void makeIsland(int r, int c, char[][] board, char ch){
        int[][] dir=new int[][]{{0,-1}, {0, 1}, {-1,0}, {1, 0}};
        Queue<int[]> q=new LinkedList();
        q.add(new int[]{r,c});
        board[r][c]=ch;
        while(!q.isEmpty()){
                int[] indexes=q.poll();
                for(int i=0;i<4;i++){
                    int nextR=indexes[0]+dir[i][0];
                    int nextC=indexes[1]+dir[i][1];
                    if(nextR>=0 && nextR<board.length && nextC>=0 && nextC<board[0].length && board[nextR][nextC]=='O'){
                        q.add(new int[]{nextR,nextC});
                        board[nextR][nextC]=ch;
                    }
                }
        }
    }
}
