#include <assert.h>
#include <limits.h>

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
void calculateSingleSourceShortestDistance(const vector<vector<int> >& adjacent_matrix, const int single_source_vertex, vector<int>* shortestDistance) {
    vector<int> order;
    topologicalSort(adjacent_matrix, &order);
    vector<vector<int> > distance_matrix;
    for (int i = 0; i < static_cast<int>(shortestDistance->size()); i++) {
        (*shortestDistance)[i] = INT_MAX;
    }
    if (adjacent_matrix.size() == 0) {
        return;
    }
    assert(adjacent_matrix.size() == adjacent_matrix[0].size());
    for (int i = 0; i < static_cast<int>(adjacent_matrix.size()); i++) {
        vector<int> distance;
        for (int j = 0; j < static_cast<int>(adjacent_matrix[i].size()); j++) {
            const int weight = adjacent_matrix[i][j];
            distance.push_back(weight);
        }
        distance_matrix.push_back(distance);
    }
    for (int i = 1; i < static_cast<int>(order.size()); i++) {
        const int vertex = order[i];

        for (int j = 0; j < static_cast<int>(adjacent_matrix.size()); j++) {
            const int weight = adjacent_matrix[vertex][j];
            if (weight >= 0 && weight < INT_MAX) {
                for( int k = 0; k < static_cast<int>(adjacent_matrix.size()); k++) {
                    const int new_distance = distance_matrix[k][vertex] + weight;
                    if (new_distance < distance_matrix[k][j]) {
                        distance_matrix[k][j]  = new_distance;
                    }
                }
            }
        }
    }
    for (int i = 0; i < static_cast<int>(distance_matrix.size()); i++) {
        (*shortestDistance)[i] = distance_matrix[single_source_vertex][i];
    }
}
int main() {
    int test_case_number;
    int node_number;
    int edge_number;
    scanf("%d\n", &test_case_number);
    for (int i = 0; i < test_case_number; i++) {
        scanf("%d %d\n", &node_number, &edge_number);
        vector<vector<int> > adjacent_matrix;
        for (int j = 0; j < node_number; j++) {
            vector<int> len(INT_MAX, node_number);
            adjacent_matrix.push_back(len);
        }
        int len;
        int node1, node2;
        for (int j = 0; j < edge_number; j++) {
            scanf("%d %d %d\n", &node1, &node2, &len);
            adjacent_matrix[node1-1][node2-1] = len;
            adjacent_matrix[node2-1][node1-1] = len;            
        }
        int single_source_vertex;
        scanf("%d", &single_source_vertex);
        vector<int> shortestDistance;
        calculateSingleSourceShortestDistance(adjacent_matrix, single_source_vertex, &shortestDistance);
    }
}
