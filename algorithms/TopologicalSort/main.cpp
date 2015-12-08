#include <assert.h>

#include <stack>
#include <vector>

using namespace std;

void topologicalSort(const vector<vector<int> >& adjacent_matrix, vector<int>* order) {
    int available[adjacent_matrix.size()];
    memset(available, 0, sizeof(available)*sizeof(int));
    order->clear();
    stack<int> candidate;
    int in_degree[adjacent_matrix.size()];
    memset(in_degree, 0, sizeof(in_degree)*sizeof(int));
    for (int i = 0; i < adjacent_matrix.size(); i++) {
        const vector<int> weight = adjacent_matrix[i];
        for (int j = 0; j < weight.size(); j++) {
            if (weight[j] > 0) {
                ++in_degree[j];
            }
        }
    }

    for (int i = 0; i < sizeof(in_degree); i++) {
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
        for (int i = 0; i < weight.size(); i++) {
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
    for (int i = 0; i < order.size(); i++) {
        printf("%d\t", order[i]);
    }
    printf("\n");
    
    return 0;
}
