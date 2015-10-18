#include<stdio.h>
#include<string.h>
#include<stdlib.h>

char* convert(char* s, int row_num) {
    
    
    const int len = strlen(s);
    if (row_num <= 0 || len <= 1) {
        return s;
    }
    int size_of_zigzag = 0; // 每个zigzag图形的大小
    if (row_num % 2 == 0) {
        size_of_zigzag = (row_num + 1) * row_num;
    }
    else {
        size_of_zigzag = (row_num + 1) * (row_num + 1);
    }
    const int col_num_of_zigzag = (row_num + 1)/2; // 每个zigzag图形的列数    
    const int max_col_num = (len / size_of_zigzag + 1) * col_num_of_zigzag;
    char zigzag_square[row_num][max_col_num];
    memset(zigzag_square, NULL, sizeof(zigzag_square));
    char* dst_str = reinterpret_cast<char*>(malloc(len));
        
    int j = 0;
    int col = 1;
    int row = 1;
    int start_row = 1; // zigzag每个列的起始行
    while (j < len) {
        row = start_row;
        while (row <= row_num -start_row + 1) {
            zigzag_square[row-1][col-1] = s[j++];
            ++row;
        }
        ++col;
        if (col % (col_num_of_zigzag) == 0) { // 一个zigzag图形结束
            start_row = 1;
        }
        else {
            ++start_row;
        }
    }
    
    j = 0;
    for (col = 0; col < max_col_num; col++) {
        for (row = 0; row < row_num; row++) {
            if (zigzag_square[row][col] != NULL) {
                dst_str[j++] = zigzag_square[row][col];
            }
            if (j >= len) {
                break;
            }
        }
    }
    return dst_str;
}
int main() {
    char str[1000];
    int row_num = 0;
    while (scanf("%s %d", str, &row_num) != EOF) {
        char* dst = convert(str, row_num);
        printf("%s\n", dst);
        free(dst);
    }
    return 0;
}
