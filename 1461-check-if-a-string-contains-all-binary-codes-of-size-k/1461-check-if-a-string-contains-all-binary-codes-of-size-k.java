class Solution {
  public boolean hasAllCodes(String s, int k) {
    int n = s.length();
    int total = (int) Math.pow(2,k);

    if( (n-k+1) < total ) return false;

    int codes = 1 << k; // 2 ^ k
    HashSet<Integer> st = new HashSet<>();

    for (int i = 0; i <= n - k; i++) {
        st.add(Integer.parseInt(s.substring(i, i + k), 2));
        if (st.size() == codes) {
            return true;
        }
    }
    return st.size() == codes;
  }
}