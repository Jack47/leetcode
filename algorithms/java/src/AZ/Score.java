package AZ;

public class Score {
    public static int totalScore(String[] blocks, int n) {
        int score = 0;
        int prevScore = 0;
        int prevElderScore = 0;
        int prevElderElderScore = 0;
        int curScore = 0;
        for (int i = 0; i < n; i++) {
            curScore = 0;
            if(blocks[i].compareTo("Z") == 0) { // remove last score
                score -= prevScore;
                prevScore = prevElderScore;
                prevElderScore = prevElderElderScore;
                continue;
            }
            else if (blocks[i].compareTo("+") == 0) { // sum of the last two scores
                curScore = prevScore + prevElderScore;
            }
            else if (blocks[i].compareTo("X") == 0) { // double the last score
                curScore = 2 * prevScore;
            }
            else {
                try {
                    curScore = Integer.parseInt(blocks[i]);
                } catch (NumberFormatException e) {

                }

            }
            score += curScore;
            prevElderElderScore = prevElderScore;
            prevElderScore = prevScore;
            prevScore = curScore;
        }
        return score;
    }
}
