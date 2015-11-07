#include <vector>
#include <assert.h>
#include <stdio.h>


using namespace std;

class Solution {
public:
    bool solveSudoku(vector<vector<char> >& board) {
        vector< vector<vector<char> > > square_permutations;
        // get permutations for every square
        for (int i = 0; i < kSudokuSquareSize; i++) {
            vector<vector<char> > permutations;
            vector<char> letters;
            getAvailableLetters(board, i, &letters);
            getPermutations(letters, &permutations);
            square_permutations.push_back(permutations);
        }
        bool find = findSolution(square_permutations, 0, board);
        return find;
    }
    bool findSolution(const vector<vector<vector<char> > >& square_permutations, int square_index, vector<vector<char> >& board) {
        const vector<vector<char> >& permutations = square_permutations[square_index];
        bool ret = false;
        bool validSudoko = false;
        if (square_index >= square_permutations.size()) {
            return true;
        }
        printf("in square[%d]\n", square_index);
        for (int i = 0; i < permutations.size(); i++) {
            const vector<char> permutation = permutations[i];
            fillBoard(square_index, permutation, board);
            validSudoko = isValidSudoku(board);
            if (validSudoko) {
                ret = findSolution(square_permutations, square_index+1, board);
                if (ret == true) {
                    return true;
                }
            }
            revertBoard(square_index, permutation, board);
        }
        return false;
    }
public:
    const static int kSudokuSquareSize = 9;
    
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
    void getAvailableLetters(const vector<vector<char> >& board, int n, vector<char>* letters) {
        Point& start = _start[n];
        int invalidLetters[kSudokuSquareSize];
        memset(invalidLetters, 0, sizeof(int) * kSudokuSquareSize);
        
        for (int i = start._x; i < start._x + 3; i++) {
            for (int j = start._y; j < start._y + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    invalidLetters[c-'0'] = 1;
                }                            
            }
        }
        for (int i = 0; i < kSudokuSquareSize; i++) {
            if(invalidLetters[i] == 0) {
                letters->push_back(i+'0');
            }
        }
    }
    void revertBoard(int index, const vector<char> letters, vector<vector<char> >& board) {
        const Point& start = _start[index];
        int n = 0;
        for (int i = start._x; i < start._x + 3; i++) {
            for (int j = start._y; j <start._y + 3; j++) {
                if (board[i][j] == letters[n]) {
                    board[i][j] = '.';
                    n++;
                }
            }
        }
        assert(n == static_cast<int>(letters.size()));        
    }
    void fillBoard(int index, const vector<char> letters, vector<vector<char> >& board) {
        const Point& start = _start[index];
        int n = 0;
        for (int i = start._x; i < start._x + 3; i++) {
            for (int j = start._y; j <start._y + 3; j++) {
                if (board[i][j] == '.') {
                    board[i][j] = letters[n];
                    n++;
                }
            }
        }
        assert(n == static_cast<int>(letters.size()));
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
    void getPermutations(vector<char>& letters, vector<vector<char> >* permutations) {
        vector<char> permutation;
        getPermutation(letters, letters.size(), permutations, &permutation);
    }    
    void getPermutation(vector<char>& letters, int nth, vector<vector<char> >* permutations, vector<char>* permutation) {
        if (nth <= 0) {
            permutations->push_back(*permutation);
            return;
        }
        
        for (int i = 0; i < letters.size(); i++) { // only nth digital available
            if (letters[i] != '.') {
                int digital = letters[i];
                letters[i] = '.';
                permutation->push_back(digital);
                getPermutation(letters, nth-1, permutations, permutation);
                letters[i] = digital;
                permutation->pop_back();
            }
        }
    }

    Point _start[6];
    int _digital[9];
};

int main() {
    char b[9][9] = {
        {'.', '.','9','7','4','8','.','.','.'},
        {'7', '.','.','.','.','.','.','.','.'},
        {'.', '2','.','1','.','9','.','.','.'},
        {'.', '.','7','.','.','.','2','4','.'},
        {'.', '6','4','.','1','.','5','9','.'},
        {'.', '9','8','.','.','.','3','.','.'},
        {'.', '.','.','8','.','3','.','2','.'},
        {'.', '.','.','.','.','.','.','.','6'},
        {'.', '.','.','2','7','5','9','.','.'},
    };    
    vector<vector<char> > board;
    for (int i = 0; i < 9; i++) {
        vector<char> v(&b[i][0], &b[i][9]);
        board.push_back(v);
    }
    Solution solution;
    bool solved = solution.solveSudoku(board);
    printf("%s\n", solved ? "solveable" : "unsolveable");
    for (int i = 0; i < board.size(); i++) {
        for (int j = 0; j < board[0].size(); j++) {
            printf("%d ", board[i][j]);
        }
        printf("\n");
    }
    return 0;
}
