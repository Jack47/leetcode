package Graph;

public class AndroidUnlockPatterns {

    int[][] skip;
    boolean[] visited;

    int dfs(int cur, int remainSteps) {
        if(remainSteps == 0) return 1;
        int result = 0;
        for(int i = 1; i <= 9; i++) {
            if(!visited[i] &&( skip[cur][i] == 0 || visited[skip[cur][i]])){
                visited[i] = true;
                result += dfs(i, remainSteps-1);
                visited[i] = false;
            }
        }
        return result;
    }

    public int numberOfPatterns(int m, int n) {
        visited = new boolean[10];
        skip = new int[10][10];
        skip[1][3] = 2;
        skip[3][1] = 2;
        skip[1][7] = 4;
        skip[7][1] = 4;
        skip[3][9] = 6;
        skip[9][3] = 6;
        skip[7][9] = 8;
        skip[9][7] = 8;

        skip[1][9] = skip[9][1] = skip[4][6] = skip[6][4] = skip[2][8] = skip[8][2] = skip[3][7]
                = skip[7][3] = 5;
        int result = 0;
        for (int i = m; i <= n; i++) {
            result += dfs(1, i) * 4;
            result += dfs(2, i) * 4;
            result += dfs(5, i) * 4;
        }
        return result;
    }
}
