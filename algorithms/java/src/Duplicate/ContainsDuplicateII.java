package Duplicate;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int capacity = (int)(nums.length*0.75);
        capacity = capacity <= 0 ? 16 : capacity;
        MyHashMap myHashMap = new MyHashMap(capacity);

        for (int i = 0; i < nums.length; i++) {
            Integer pos = myHashMap.get(nums[i]);
            if (pos == null) {
                myHashMap.add(nums[i], i);
            }
            else {
                if (i - pos <= k) return true;
                else {
                    myHashMap.remove(nums[i]);
                    //update position
                    myHashMap.add(nums[i], i);
                }
            }
        }
        return false;
    }
}
