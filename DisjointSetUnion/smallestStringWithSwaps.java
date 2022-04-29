class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n=s.length();
        int size=pairs.size();
        int[] parent=new int[n];
        HashMap<Integer, PriorityQueue<Character>> sortedChars=new HashMap();
        HashMap<Integer, PriorityQueue<Integer>> sortedIndexes=new HashMap();
        for(int i=0;i<parent.length;i++)
            parent[i]=i;
        for(int i=0;i<size;i++){
            int x=pairs.get(i).get(0);
            int y=pairs.get(i).get(1);
            union(x,y,parent);
        }
        for(int i=0;i<n;i++){
            int x=find(i, parent);
            if(!sortedChars.containsKey(x)){
                sortedChars.put(x,new PriorityQueue<Character>());
                sortedIndexes.put(x,new PriorityQueue<Integer>());
            }
            PriorityQueue<Character> pq=sortedChars.get(x);
            pq.add(s.charAt(i));
            sortedChars.put(x,pq);
            PriorityQueue<Integer> q=sortedIndexes.get(x);
            q.add(i);
            sortedIndexes.put(x,q);
        }
        char[] result=new char[n];
        for(Integer i:sortedChars.keySet()){
            PriorityQueue<Character> charsPQ=sortedChars.get(i);
            PriorityQueue<Integer> indexesPQ=sortedIndexes.get(i);
            while(!charsPQ.isEmpty()){
                result[indexesPQ.poll()]=charsPQ.poll();
            }
        }
        return String.valueOf(result);
    }
    public static int find(int i, int[] parent){
        if(parent[i]==i)
            return i;
        return parent[i]=find(parent[i], parent);
    }
    public static void union(int a, int b, int[] parent){
        a=find(a, parent);
        b=find(b, parent);
        if(a!=b)
            parent[b]=a;
    }
}
