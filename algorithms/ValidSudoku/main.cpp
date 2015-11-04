#include <stdio.h>
#include <vector>

using namespace std;

class Solution {
public:
    struct Point {
        int _x;
        int _y;
        Point() : _x(0), _y(0) {
            
        }
        Point(int x, int y) : _x(x), _y(y) {
        }
    };
    bool checkDigital(int* digital, char c) {
            if (c != '.') {
                int d = c-'1';
                if (digital[d] != 0) {
                    return false;
                }
                digital[d] = 1;                
            }
            return true;
    }
    bool isValidSudokuRow(const vector<vector<char> >& board, int row) {
        memset(_digital, 0, sizeof(int) * 9);
        for (int col = 0; col < 9; col++) {
            char c = board[row][col];
            if (c != '.') {
                if (!checkDigital(_digital, c)) {
                    return false;
                }
            }
        }
        return true;
    }
    bool isValidSudokuColumn(const vector<vector<char> >& board, int col) {
        memset(_digital, 0, sizeof(int) * 9);
        for (int row = 0; row < 9; row++) {
            char c = board[row][col];
            if (c != '.') {
                if (!checkDigital(_digital, c)) {
                    return false;
                }
            }            
        }
        return true;
    }
    bool isValidSudokuSquare(const vector<vector<char> >& board, const struct Point& start) {
        memset(_digital, 0, sizeof(int) * 9);
        for (int i = start._x; i < start._x + 3; i++) {
            for (int j = start._y; j < start._y + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!checkDigital(_digital, c)) {
                        return false;
                    }
                }                            
            }
        }
        return false;
    }
    bool isValidSudoku(const vector<vector<char> >& board) {
        bool isValid = false;
        for (int i = 0; i < board.size(); i++) {
            isValid = isValidSudokuRow(board, i);
            if (!isValid) {
                return false;
            }
        }
        for (int j = 0; j < board[0].size(); j++) {
            isValid = isValidSudokuColumn(board, j);
            if (!isValid) {
                return false;
            }            
        }
        for (int i = 0; i < 9; i++) {
            isValid = isValidSudokuSquare(board, _start[i]);
            if (!isValid) {
                return false;
            }                        
        }
        return true;
    }

    Solution() {
        _start[0] = Point(0, 0);
        _start[1] = Point(0, 3);
        _start[2] = Point(0, 6);
        _start[3] = Point(3, 0);
        _start[4] = Point(3, 3);
        _start[5] = Point(3, 6);
        _start[6] = Point(6, 0);
        _start[7] = Point(6, 3);
        _start[8] = Point(6, 6);                        
    }
private:
    Point _start[6];
    int _digital[9];
};
int main() {
    Solution solution;
    char b[9][9] = {
        {'.','8','7','6','5','4','3,','2','1'},
        {'2', '.','.','.','.','.','.','.','.'},
        {'3', '.','.','.','.','.','.','.','.'},
        {'4', '.','.','.','.','.','.','.','.'},
        {'5', '.','.','.','.','.','.','.','.'},
        {'6', '.','.','.','.','.','.','.','.'},
        {'7', '.','.','.','.','.','.','.','.'},
        {'8', '.','.','.','.','.','.','.','.'},
        {'9', '.','.','.','.','.','.','.','.'},
        
    };
    vector<vector<char> > board;
    for (int i = 0; i < 9; i++) {
        vector<char> v(&b[i][0], &b[i][9]);
        board.push_back(v);
    }
    bool isValid = solution.isValidSudoku(board);
    printf("%s\n", isValid ? "true" : "false");
    return 0;
}

