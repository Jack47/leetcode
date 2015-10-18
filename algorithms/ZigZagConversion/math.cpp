#include<stdio.h>
#include<string.h>
#include<stdlib.h>
/*
  采用数学的方法来解，空间复杂度为O(n),时间复杂度也为O(n);
 */
char* convert(char* s, int row_num) {
    const int len = strlen(s);
    if (row_num <= 0 || len <= 1) {
        return s;
    }
    char* dst = (char*)malloc(len + 1);
    const int distance_row1 = 2 * row_num - 2; // 图形中第一行两个非空的相邻元素之间的距离
    int index = 1; // 第几个元素
    int j = 0;
    int row = 1;
    // 打印第一行/最后一行
    while (index <= len) {
        dst[j++] = s[index-1];
        index += distance_row1;
    }
    ++row;
    
    const int size_of_zigzag = 2 * row_num -2;
    const int col_num = (len/size_of_zigzag) * 2 + ((len % size_of_zigzag) + row_num -1) / row_num;
    // 打印中间的 2~row_num-2行
    int col = 1;
    // 逐行遍历
    while (row <= row_num-1) {
        index = 0;        
        for (col = 1; col <= col_num; col++) {
            if (col % 2 == 0) {
                const int distance = ((col-1) / 2) * size_of_zigzag + row_num; // 距离原点的距离
                index = distance + (row_num - row);
            }
            else {
                const int distance = (col / 2) * size_of_zigzag; // 距离原点的距离
                index = distance + row;
            }
            
            if (index > len) {
                break;
            }
            else {
                dst[j++] = s[index-1];
            }
        }
        ++row;
    }
    
    index = row_num;
    while (index <= len) {
        dst[j++] = s[index-1];
        index += distance_row1;
    }
    dst[j++] = '\0';
    return dst;
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
