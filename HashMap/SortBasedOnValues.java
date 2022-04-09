//Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
//Example 1:
//Input: nums = [1,1,1,2,2,3], k = 2
//Output: [1,2]
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fq=new HashMap();
        for(int i=0;i<nums.length;i++)
            fq.put(nums[i], fq.getOrDefault(nums[i],0)+1);
        Map<Integer,Integer> hm=getSortedMap(fq);
        
        Iterator<Integer> itr=hm.keySet().iterator();
        ArrayList<Integer> arr=new ArrayList(); 
        while(itr.hasNext() && k-->0)
            arr.add(itr.next());
        int[] values=new int[arr.size()];
        int x=0;
        for(Integer i:arr)
            values[x++]=i;
        return values;
    }
    
    public static HashMap<Integer,Integer> getSortedMap(Map<Integer,Integer> hm){
        List<Map.Entry<Integer,Integer>> list=new LinkedList<Map.Entry<Integer,Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer,Integer>>(){
           public int compare(Map.Entry<Integer,Integer> o1, Map.Entry<Integer,Integer> o2)
           {
               return (o2.getValue()).compareTo(o1.getValue());
           }
        });
        
        HashMap<Integer,Integer> map=new LinkedHashMap<Integer,Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            map.put(aa.getKey(), aa.getValue());
        }
        return map;
    } 
}
