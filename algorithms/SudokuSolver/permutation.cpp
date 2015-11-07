#include <stdio.h>

#include <vector>

using namespace std;
void getPermutation(vector<int>& digitals, int nth, vector<vector<int> >* permutations, vector<int>* permutation) {
    if (nth <= 0) {
        permutations->push_back(*permutation);
        return;
    }
    
    for (int i = 0; i < digitals.size(); i++) { // only nth digital available
        if (digitals[i] != INT_MAX) {
            int digital = digitals[i];
            digitals[i] = INT_MAX;
            permutation->push_back(digital);
            getPermutation(digitals, nth-1, permutations, permutation);
            digitals[i] = digital;
            permutation->pop_back();
        }
    }    
}

void getPermutations(vector<int>& digitals, vector<vector<int> >* permutations) {
    vector<int> permutation;
    getPermutation(digitals, digitals.size(), permutations, &permutation);
}

int main() {
    vector<int> digitals;
    digitals.push_back(1);
    digitals.push_back(2);
    digitals.push_back(3);
    digitals.push_back(4);
    digitals.push_back(5);
    digitals.push_back(6);
    digitals.push_back(7);
    digitals.push_back(8);
    digitals.push_back(9);
    
    vector<vector<int> > permutations;
    getPermutations(digitals, &permutations);
    // printf("has %zu permutations\n", permutations.size());
    for (int i = 0; i < permutations.size(); i++) {
        for (int j = 0; j < permutations[i].size(); j++) {
            // printf("%d ", permutations[i][j]);
        }
        // printf("\n");
    }
    
    digitals.clear();
    digitals.push_back(7);
    digitals.push_back(9);
    digitals.push_back(1);
    permutations.clear();
    getPermutations(digitals, &permutations);
    // printf("has %zu permutations\n", permutations.size());           
    for (int i = 0; i < permutations.size(); i++) {
        for (int j = 0; j < permutations[i].size(); j++) {
            // printf("%d ", permutations[i][j]);
        }
        // printf("\n");
    }    

    
    return 0;
}
