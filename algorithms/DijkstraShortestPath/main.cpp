#include <assert.h>
#include <limits.h>
#include <queue>
#include <stack>
#include <vector>

#include <stdio.h>
/*
  find the single source shortest distance in undirected acyclic graph. There maybe unreachable vertex, the distance is -1;
  https://www.hackerrank.com/challenges/dijkstrashortreach
 */
using namespace std;
struct Dist {
    int _len;
    int _vertex;
    Dist(int len, int vertex) : _len(len), _vertex(vertex) {

    }
    bool operator<(const Dist& other) const {
        return _len > other._len;
    }
};
void calculateSingleSourceShortestDistance(const vector<vector<int> >& adjacent_matrix, const int single_source_vertex, vector<int>* shortestDistance) {
    priority_queue<Dist> next_dist;
    vector<bool> visited;

    if (adjacent_matrix.size() == 0) {
        return;
    }
    assert(adjacent_matrix.size() == adjacent_matrix[0].size());
    
    visited.reserve(adjacent_matrix.size());
    for (int i = 0; i < static_cast<int>(adjacent_matrix.size()); i++) {
        visited.push_back(false);
    }

    shortestDistance->clear();
    shortestDistance->reserve(adjacent_matrix.size());
    visited[single_source_vertex] = true;
    for (int i = 0; i < static_cast<int>(adjacent_matrix.size()); i++) {
        shortestDistance->push_back(adjacent_matrix[single_source_vertex][i]);
        if ((*shortestDistance)[i] != INT_MAX && i != single_source_vertex) {
            next_dist.push(Dist((*shortestDistance)[i], i));
        }
    }

    for (int visited_num = 1; visited_num < static_cast<int>(adjacent_matrix.size()); visited_num++) {
        if (next_dist.size() == 0) {
            break;
        }
        Dist dist = next_dist.top();
        while (visited[dist._vertex] == true) {
            next_dist.pop();
            dist = next_dist.top();
        }
        next_dist.pop();
        int vertex = dist._vertex;
        visited[vertex] = true;
        (*shortestDistance)[vertex] = dist._len;
        int len = dist._len;
        assert(len > 0 && len < INT_MAX);
        const vector<int>& adjacent = adjacent_matrix[vertex];
        for (int i = 0; i < static_cast<int>(adjacent.size()); i++) {
            if (i != vertex && visited[i] != true && adjacent[i] != INT_MAX && (*shortestDistance)[i] > len + adjacent[i]) {
                (*shortestDistance)[i] = len + adjacent[i];
                assert((*shortestDistance)[i] < INT_MAX);
                next_dist.push(Dist((*shortestDistance)[i], i));
            }
        }
    }
}
int main() {
    int test_case_number;
    int node_number;
    int edge_number;
    scanf("%d", &test_case_number);
    for (int i = 0; i < test_case_number; i++) {
        scanf("%d%d", &node_number, &edge_number);
        vector<vector<int> > adjacent_matrix;
        for (int j = 0; j < node_number; j++) {
            vector<int> outer_len(node_number, INT_MAX);
            adjacent_matrix.push_back(outer_len);
        }
        int len;
        int node1, node2;
        for (int j = 0; j < edge_number; j++) {
            scanf("%d%d%d", &node1, &node2, &len);
            assert(adjacent_matrix[node1-1][node2-1] == adjacent_matrix[node2-1][node1-1]);
            int current = adjacent_matrix[node1-1][node2-1];
            current = current > len ? len : current;
            adjacent_matrix[node1-1][node2-1] = adjacent_matrix[node2-1][node1-1] = current;
        }
        for (int j = 0; j < node_number; j++) {
            adjacent_matrix[j][j] = 0;
        }
        int single_source_vertex;
        scanf("%d", &single_source_vertex);
        vector<int> shortestDistance;
        calculateSingleSourceShortestDistance(adjacent_matrix, single_source_vertex-1, &shortestDistance);
        bool first = true;
        for (int i = 0; i < static_cast<int>(shortestDistance.size()); i++) {
            if (i != single_source_vertex-1) {
                int len = shortestDistance[i] != INT_MAX ? shortestDistance[i] : -1;
                if (first) {
                    printf("%d", len);
                    first = false;
                }
                else {
                    printf(" %d", len);
                }
            }
        }
        printf("\n");
    }
}
