#include <assert.h>

#include <stack>
#include <vector>

using namespace std;

void topologicalSort(const vector<vector<int> >& adjacent_matrix, vector<int>* order) {
    if (adjacent_matrix.size() == 0) {
        return;
    }
    assert(adjacent_matrix.size() == adjacent_matrix[0].size());
    int available[adjacent_matrix.size()];
    memset(available, 0, adjacent_matrix.size()*sizeof(int));
    order->clear();
    stack<int> candidate;
    int in_degree[adjacent_matrix.size()];
    memset(in_degree, 0, adjacent_matrix.size()*sizeof(int));
    for (int i = 0; i < static_cast<int>(adjacent_matrix.size()); i++) {
        const vector<int> weight = adjacent_matrix[i];
        for (int j = 0; j < static_cast<int>(weight.size()); j++) {
            if (weight[j] > 0) {
                ++in_degree[j];
            }
        }
    }

    for (int i = 0; i < static_cast<int>(adjacent_matrix.size()); i++) {
        if (in_degree[i] == 0) {
            candidate.push(i);
        }
    }
    assert(candidate.size() > 0);
    while(candidate.size() > 0) {
        int vertex = candidate.top();
        order->push_back(vertex);
        candidate.pop();
        const vector<int> weight = adjacent_matrix[vertex];
        for (int i = 0; i < static_cast<int>(weight.size()); i++) {
            if (weight[i] > 0) {
                --in_degree[i];
                if (in_degree[i] == 0) {
                    candidate.push(i);
                }
            }
        }
    }
}
// test case
int main() {
    vector<vector<int> > adjacent_matrix;
    vector<int> order;
    int matrix1[][5] = {
        {0, 1, 2, 0, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 1, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 2, 0, 0},
    };
    for(int i = 0; i < 5; i++) {
        vector<int> row(matrix1[i], matrix1[i]+5);
        adjacent_matrix.push_back(row);
    }
    topologicalSort(adjacent_matrix, &order);
    for (int i = 0; i < static_cast<int>(order.size()); i++) {
        printf("%d\t", order[i]);
    }
    printf("\n");

    int matrix2[][6] = {
        {0, 1, 0, 1, 0, 0},
        {0, 0, 1, 0, 1, 1},
        {0, 0, 0, 0, 1, 1},
        {0, 1, 1, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 1, 0},
    };
    adjacent_matrix.clear();
    for(int i = 0; i < 6; i++) {
        vector<int> row(matrix2[i], matrix2[i]+6);
        adjacent_matrix.push_back(row);
    }
    topologicalSort(adjacent_matrix, &order);
    for (int i = 0; i < static_cast<int>(order.size()); i++) {
        printf("%d\t", order[i]);
    }
    printf("\n");
    
    return 0;
}
