class Solution {
    public int countStaircase(int[] nums) {
        int n = nums.length;
        int ans = 0;

        // freq[x]: Current frequency of element 'x' in the subarray nums[i...j]
        int[] freq = new int[100005];

        // distPos[x]: The arrival rank (1st, 2nd, 3rd distinct element) of 'x' in nums[i...j]. 
        // This dictates what freq[x] must eventually become for a valid staircase.
        int[] distPos = new int[100005];
        
        // lastSeenFreq[x]: The outer loop index 'i' when freq[x] was last cleared
        int[] lastSeenFreq = new int[100005];
        
        // lastSeenDist[x]: The outer loop index 'i' when distPos[x] was last cleared
        int[] lastSeenDist = new int[100005];

        Arrays.fill(lastSeenFreq, -1);
        Arrays.fill(lastSeenDist, -1);


        for(int i = 0; i < n; i++) {
            int dist = 0; // Counts total distinct elements seen so far in this inner loop
            
            for(int j = i; j < n; j++) {
                int x = nums[j];
                
                // LAZY CLEARING FOR FREQ: 
                // If we haven't touched freq[x] during THIS specific 'i' loop, reset it to 0
                if (lastSeenFreq[x] != i) {
                    freq[x] = 0;
                    lastSeenFreq[x] = i; // Mark that it is now clean for loop 'i'
                }
                
                // LAZY CLEARING FOR DISTPOS: 
                // If we haven't touched distPos[x] during THIS specific 'i' loop, reset it to -1
                if (lastSeenDist[x] != i) {
                    distPos[x] = -1; 
                    lastSeenDist[x] = i; // Mark that it is now clean for loop 'i'
                }
                
                int curFreq = freq[x];
                int pos = distPos[x];
                
                // PRUNING: If x's frequency exceeds its required rank (e.g., the 2nd distinct 
                // element appears 3 times), this subarray and all its extensions are invalid.
                if((pos != -1 && curFreq + 1 > pos) || ((dist * (dist + 1)) / 2) > n - i) break;
                
                // If this is the first time we are seeing 'x' in this subarray
                if(curFreq == 0) {
                    dist++;             // Increment total distinct elements count
                    distPos[x] = dist;  // Assign this element its arrival rank
                }
                
                // Update the frequency
                freq[x] = curFreq + 1;
                
                // Check if current subarray length perfectly matches a complete staircase sum: 1 + 2 + ... + dist
                if(j - i + 1 == (dist * (dist + 1)) / 2) {
                    ans++;
                }
            }
        }
        return ans;
    }
}