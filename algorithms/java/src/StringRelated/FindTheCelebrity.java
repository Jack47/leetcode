package StringRelated;
class Base {
    public boolean knows(int i, int j){
        return true;
    }
}
public class FindTheCelebrity extends Base{
    public int findCelebrity(int n) {
        boolean[] inValid = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!inValid[i] &&isCelebrity(i, n, inValid)) {
                return i;
            }
        }
        return -1;
    }
    boolean isCelebrity(int i, int n, boolean [] inValid) {
        for(int j = 0; j < n; j++) {
            if(j == i) continue;
            if(!knows(j, i)) {
                inValid[i] = true;
                return false;
            } else {
                inValid[j] = true;
            }
            if(knows(i, j)) {
                inValid[i] = true;
                return false;
            }
        }
        return true;
    }
}
