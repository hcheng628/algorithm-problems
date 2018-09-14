# algorithm-problems

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Set<Triplet> set = new HashSet<>();
        
        if(nums.length < 3)
            return ret;
        
        for(int i=0;i<nums.length;i++) {
            for(int j=i+1;j<nums.length;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    if(nums[i] + nums[j] + nums[k] == 0) {
                        set.add( new Triplet(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        
        for(Triplet each : set) {
            List<Integer> list = new ArrayList<>();
            list.add(each.a);
            list.add(each.b);
            list.add(each.c);
            ret.add(list);
        }
        
        return ret;
    }
    
    class Triplet {
        public int a;
        public int b;
        public int c;
        
        public Triplet(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        
        public boolean equals(Object other) {
            if (other == null) return false;
            if (other == this) return true;
            if (!(other instanceof Triplet))return false;
            Triplet t = (Triplet) other;
            System.out.println("This: a: " + this.a + " b: " + this.b + " c:" + this.c);
            System.out.println(" In : a: " + t.a + " b: " + t.b + " c:" + t.c);

            if(this.a == t.a) {
                if(this.b == t.b && this.c == t.c) {
                    return true;
                }
                if(this.b == t.c && this.c == t.b) {
                    return true;
                }
            } else if (this.a == t.b) {
                if(this.b == t.c && this.c == t.a) {
                    return true;
                }
                if(this.b == t.a && this.c == t.c) {
                    return true;
                }
            } else if(this.a == t.c) {
                if(this.b == t.b && this.c == t.a) {
                    return true;
                }
                if(this.b == t.a && this.c == t.b) {
                    return true;
                }
            }
            return false;
        }
    }
}
