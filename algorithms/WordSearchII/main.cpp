#include<stdio.h>
#include<stdlib.h>
#include<string.h>
/*
  这种方法后来证明是不行的，会超时，900多个查询，规定时间内只能查完750个
 */
const int kLetterMaxSize = 26;
/*
  判断(i,j)这个位置是否满足条件，如果满足，看四个方向是不是有可以走的路。step当前走到了第几步
 */
bool canForward(char** board, int boardRowSize, int boardColSize, char* word, int i, int j, int step) {
    if (board[i][j] == word[step]) {
        if (step == (int)strlen(word) - 1) {
            return true;
        }
        char c = board[i][j];
        board[i][j] = '#';
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
void getWordStatics(const char* word, int letters[kLetterMaxSize]) {
    const int size = strlen(word);
    memset(letters, 0, kLetterMaxSize*sizeof(int));
    for (int i = 0; i < size; i++) {
        char c = word[i];
        ++letters[c-'a'];
    }
}
void getBoardStatics(const char** board, int boardRow, int boardCol, int letters[kLetterMaxSize]) {
    memset(letters, 0, sizeof(int) * kLetterMaxSize);
    for (int i = 0; i < boardRow; i++) {
        for (int j = 0; j < boardCol; j++) {
            const char c = board[i][j];
            ++letters[c-'a'];
        }
    }
}
bool mayExist(const int letters[kLetterMaxSize], const int wordLetters[kLetterMaxSize]) {
    for (int i = 0; i < kLetterMaxSize; i++) {
        if (wordLetters[i] > letters[i]) {
            return false;
        }
    }
    return true;
}
/**
 * Return an array of size *returnSize.
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** findWords(char** board, int boardRowSize, int boardColSize, char** words, int wordsSize, int* returnSize) {
    int letters[kLetterMaxSize];
    getStatics((const char**)board, boardRowSize, boardColSize, letters);
    int find[wordsSize];
    int count = 0;
    for (int i = 0; i < wordsSize; i++) {
        int wordLetters[kLetterMaxSize];
        getStatics((const char*)words[i], wordLetters);
        find[i] = 0;
        if (mayExist(letters, wordLetters)) {
            if (exist(board, boardRowSize, boardColSize, words[i])) {
                find[i] = 1;
                count++;
            }            
        }
    }
    *returnSize = count;
    char** result = (char**)malloc(sizeof(char*) * count);
    count = 0;
    for (int i = 0; i <= wordsSize - 1;i++) {
        if (find[i] == 1) {
            const int len = strlen(words[i]);
            result[count] = (char*)malloc(sizeof(char)*len + 1);
            strncpy(result[count], words[i], len);
            result[count][len] = '\0';
            count++;
        }
    }

    return result;
}
int main() {
    char wordsB[2][5] = {"eat", "oath"};
    char** words = (char**)malloc(sizeof(char*)*2);
    for (int i = 0; i < 2; i++) {
        words[i] = wordsB[i];
    }    
    char** board = (char**)malloc(sizeof(char*) * 4);
    for (int i = 0; i <= 3; i++) {
        board[i] = (char*)malloc(sizeof(char) * 4);
    }

    board[0][0] = 'o';
    board[0][1] = 'a';
    board[0][2] = 'a';
    board[0][3] = 'n';
    
    board[1][0] = 'e';
    board[1][1] = 't';
    board[1][2] = 'a';
    board[1][3] = 'e';
    
    board[2][0] = 'i';
    board[2][1] = 'h';
    board[2][2] = 'k';
    board[2][3] = 'r';    

    board[3][0] = 'i';
    board[3][1] = 'f';
    board[3][2] = 'l';
    board[3][3] = 'v';    
    
    char** result = NULL;
    int returnSize = 0;
    result = findWords((char**)board, 4, 4, (char**)words, 2, &returnSize);
    printf("found:%d words\n", returnSize);
    for (int i = 0; i < returnSize; i++) {
        printf("%s\n", result[i]);
        free(result[i]);
    }
    free(result);
    return 0;
}
