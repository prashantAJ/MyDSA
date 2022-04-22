class Solution {
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {
        if(m<n)
            return kthElement(arr2, arr1, m, n, k);
        int l=Math.max(0,k-m), h=Math.min(n,k);
        while(l<=h)
        {
            int mid=(l+h)/2;
            int right=k-mid;
            int l1,l2,r1,r2;
            l1= (mid==0) ? Integer.MIN_VALUE : arr1[mid-1];
            r1= (mid==n) ? Integer.MAX_VALUE : arr1[mid];
            l2= (right==0) ? Integer.MIN_VALUE : arr2[right-1];
            r2= (right==m) ? Integer.MAX_VALUE : arr2[right];
            if(l1<=r2 && l2<=r1)
                return Math.max(l1,l2);
            else if(l1>r2)
                h=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
}
