class Solution {
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        // c.c. assume positions not null
        List<Integer> res = new ArrayList<Integer>();
        if (positions.length == 0) return res;
        
        UnionFind uf = new UnionFind(m, n);
        for (int[] pos : positions) {
            int i = pos[0], j = pos[1];
            // uf add island
            uf.addIsland(i, j);
            for ( int[] dir: DIRECTIONS) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii < 0 || ii >= m || jj < 0 || jj >= n) {
                    continue;
                }
                // check if the position is island
                // find out if the neighbor is the same island, if not, union
                if (uf.isIsland(ii, jj) && !uf.find(i, j, ii, jj)) {
                    uf.union(i, j, ii, jj);
                }
            }
            res.add(uf.getNumberOfIsland());
        }
        return res;
    }
    class UnionFind {
        public int[] parents, size;
        public int row, col, numberOfIsland;
        public UnionFind(int m, int n) {
            this.row = m;
            this.col = n;
            numberOfIsland = 0;
            size = new int[m * n];
            parents = new int[m * n];
            for (int i = 0; i < row * col; i++) {
                parents[i] = -1;
            }
        }
        public int getRoot(int p) { // p is the flattened index
            int cur = p;
            while (parents[cur] == cur) {
                parents[cur] = parents[parents[cur]]; // get original pos
                cur = parents[cur];
            }
            parents[p] = cur;
            return cur;
        }
        public boolean find(int i1, int j1, int i2, int j2) {
            // check neighbors are from one land
            int p = i1 * this.col + j1;
            int q = i2 * this.col + j2;
            return getRoot(p) == getRoot(q);
        }
        public void union(int i1, int j1, int i2, int j2) {
            // union two different islands
            // compare two sizes, connect the small one to the big one
            // make the bigger land pos new pos of the small one
            int p = this.col * i1 + j1;
            int q = this.col * i2 + j2;
            int rootP = getRoot(p), rootQ = getRoot(q);
            if (size[rootP] > size[rootQ]) {
                size[rootQ] += size[rootP];
                parents[rootQ] = rootP;
            } else { 
                size[rootP] += size[rootQ];
                parents[rootQ] = rootP;
            }
            this.numberOfIsland--;
        }
        public void addIsland(int m, int n) {
            // add to the island list to track each island position/id
            int idx = m * this.col + n;
            parents[idx] = idx;
            this.numberOfIsland++; // do we need size++?
        }
        public boolean isIsland(int i, int j) {
            // check island value is 1 --> return true or false
            return parents[i * this.col + j] >= 0;
        }
        public int getNumberOfIsland() {
            // return island number
            return this.numberOfIsland;
        }
    }
}