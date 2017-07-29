package BinaryTree;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;

        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= i-1; j++) { // g(n) = g(0)*g(n-1) + g(1)*g(n-2).... + g(n-2)*g(1) + g(n-1)*g(0)
                g[i] += g[j]*g[i-j-1];
            }
        }
        return g[n];
    }
}
