class Solution {
    public void add(HashMap<Integer, Integer> side, int len){
        if(side.containsKey(len)){
            side.put(len, side.get(len) + 1);
        }
        else side.put(len, 1);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = (int) (Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
        int d13 = (int) (Math.pow(p1[0] - p3[0], 2) + Math.pow(p1[1] - p3[1], 2));
        int d14 = (int) (Math.pow(p1[0] - p4[0], 2) + Math.pow(p1[1] - p4[1], 2));
        int d23 = (int) (Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2));
        int d24 = (int) (Math.pow(p2[0] - p4[0], 2) + Math.pow(p2[1] - p4[1], 2));
        int d34 = (int) (Math.pow(p3[0] - p4[0], 2) + Math.pow(p3[1] - p4[1], 2));

        HashMap<Integer, Integer> sides = new HashMap<>();
        add(sides, d12);
        add(sides, d13);
        add(sides, d14);
        add(sides, d23);
        add(sides, d24);
        add(sides, d34);
        //System.out.println(d12+" "+d13+" "+d14+" "+d23+" "+d24+" "+d34);
        
        if(sides.size() == 2){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (Map.Entry<Integer, Integer> entry : sides.entrySet()) {
                min = Math.min(min, entry.getKey());
                max = Math.max(max, entry.getKey());
                //System.out.println(entry.getKey()+" "+ entry.getValue());
            }
            if((sides.get(min) == 4) && (sides.get(max) == 2)) return true; 

        }
        return false;
    }
}