#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*
  判断(i,j)这个位置是否满足条件，如果满足，看四个方向是不是有可以走的路。step当前走到了第几步
 */
bool canForward(char** board, int boardRowSize, int boardColSize, char* word, int i, int j, int step) {
    if (board[i][j] == word[step]) {
        char c = board[i][j];
        board[i][j] = '#';
        if (step == strlen(word) - 1) {
            return true;
        }
    
        if ( (i-1) >= 0 && canForward(board, boardRowSize, boardColSize, word, i-1, j, step+1) ||
            (i+1) < boardRowSize && canForward(board, boardRowSize, boardColSize, word, i+1, j, step+1) ||
            (j-1) >= 0 && canForward(board, boardRowSize, boardColSize, word, i, j-1, step+1) ||
            (j+1) < boardColSize && canForward(board, boardRowSize, boardColSize, word, i, j+1, step+1)) {
            board[i][j] = c;                                
            return true;
        }            
        board[i][j] = c;
    }
    return false;
}
bool exist(char** board, int boardRowSize, int boardColSize, char* word) {
    int len = strlen(word);
    if ( len == 0) {
        return true;
    }
    if (boardRowSize * boardColSize < len) {
        return false;
    }
    int step = 0;
    for (int i = 0; i < boardRowSize; i++) {
        for (int j = 0; j < boardColSize; j++) {
            if (board[i][j] == word[step]) {
                if (canForward(board, boardRowSize, boardColSize, word, i, j, step)) {
                    return true;
                }
            }
        }
    }
    return false;
}
int main() {
    char** board = (char**)malloc(sizeof(char*) * 3);
    for (int i = 0; i < 3; i++) {
        board[i] = (char*)malloc(sizeof(char) * 4);
    }

    board[0][0] = 'A';
    board[0][1] = 'B';
    board[0][2] = 'C';
    board[0][3] = 'E';
    
    board[1][0] = 'S';
    board[1][1] = 'F';
    board[1][2] = 'C';
    board[1][3] = 'S';
    
    board[2][0] = 'A';
    board[2][1] = 'D';
    board[2][2] = 'E';
    board[2][3] = 'E';    
    
    bool ret = exist(board, 3, 4, "ABCCED");
    printf("%s\n" , ret == true ? "true" : "false");

    ret = exist(board, 3, 4, "SEE");
    printf("%s\n" , ret == true ? "true" : "false");
    
    ret = exist(board, 3, 4, "ABCB");
    printf("%s\n" , ret == true ? "true" : "false");
    
    return 0;
}
