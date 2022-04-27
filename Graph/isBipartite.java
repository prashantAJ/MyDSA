class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int arr[]=new int[n];
        Queue<Integer> q=new LinkedList();
        int val=1;
        for(int i=0;i<n;i++){
            if(arr[i]==0){
            q.add(i);
            arr[i]=val;
            while(!q.isEmpty()){
                int x=q.poll();
                
                int len=graph[x].length;
                int k=0;
                while(k<len)
                {
                    if(arr[graph[x][k]]==arr[x])
                        return false;
                    else if(arr[graph[x][k]]==0){
                        q.add(graph[x][k]);
                        arr[graph[x][k]]=(arr[x]==1)?2:1;
                    }
                    k++;
                }
            }
            }
        }
        return true;
    }
}
