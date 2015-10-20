/*
  判断(i,j)这个位置作为起点，像四个方向是不是有可以走的路。step代表下一步，visited用来标记当前走过的位置
 */
bool canForward(char** board, int boardRowSize, int boardColSize, char* word, int i, int j, int step, bool** visited) {
    if (step == strlen(word)+1) {
        return false;
    }
    int next_i = i;
    int next_j = j;
    for (int istep = -1; istep <= 1; istep +=2) {
        for (int jstep = -1; jstep <= 1; jstep +=2) {
            next_i = i + istep;
            next_j = j + istep;
            if (next_i >= 0 && next_i < boardRowSize &&
                next_j >= 0 && next_j < boardColSize) {
                if (visited[next_i][next_j] == false && board[next_i][next_j] == word[step]) {
                    visited[next_i][next_j] = true;
                    if (canForward(board, boardRowSize, boardColSize, word, next_i, next_j, step+1, visited)) {
                        return true;
                    }
                    visited[next_i][next_j] = false;
                }
            }
        }
    }
}
bool exist(char** board, int boardRowSize, int boardColSize, char* word) {
    int len = strlen(word);
    if ( len == 0) {
        return true;
    }
    bool visited[boardRowSize][boardColSize];
    for (int i = 0; i < boardRowSize; i++) {
        for (int j = 0; j < boardRowSize; j++) {        
            visited[i][j] = false;
        }
    }
    int step = 0;
    for (int i = 0; i < boardRowSize; i++) {
        for (int j = 0; j < boardColSize; j++) {
            if (board[i][j] == word[step]) {
                visited[i][j] = true;
                if (canForward(board, boardRowSize, boardColSize, word, i, j, step+1, visited)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
    }
    return false;
}
