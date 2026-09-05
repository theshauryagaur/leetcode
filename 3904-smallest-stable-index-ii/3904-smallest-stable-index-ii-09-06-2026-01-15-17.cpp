class Solution {
public:
    int firstStableIndex(vector<int>& nums, int k) {
        int n = nums.size();

        vector<int> maxPref(n);
        vector<int> minSuff(n);

        maxPref[0] = nums[0];
        minSuff[n-1] = nums[n-1];

        for(int i=1; i<n; i++){
            maxPref[i] = max(maxPref[i-1], nums[i]);
            minSuff[n-i-1] = min(minSuff[n-i], nums[n-i-1]);
        }

        for(int i=0; i<n; i++){
            if(maxPref[i] - minSuff[i] <= k) return i;
        }
        return -1;
    }
};