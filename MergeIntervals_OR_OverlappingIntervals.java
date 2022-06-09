class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (int[] a, int[] b)->{
           if(a[0]==b[0])
               return a[1]-b[1];
            else
                return a[0]-b[0];
        });
        int k=0;
        int[] current=new int[] {intervals[0][0],intervals[0][1]};
        for(int i=1;i<intervals.length;i++){
            int[] next={intervals[i][0],intervals[i][1]};
            if(current[1]>=next[0])
                current[1]=Math.max(current[1], next[1]);
            else{
                intervals[k][0]=current[0];
                intervals[k][1]=current[1];
                current[0]=next[0];
                current[1]=next[1];
                k++;
            }                
        }
        intervals[k][0]=current[0];
        intervals[k][1]=current[1];
        int result[][]=new int[k+1][2];
        for(int i=0;i<=k;i++)
            result[i]=intervals[i];
        return result;
    }
}
