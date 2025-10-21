class FloodFillDFS {
    static int rows, cols;
    static int[][] grid;
    static boolean[][] visited;

    // 4 hướng di chuyển: lên, phải, xuống, trái
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        grid = new int[][] {
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {1, 0, 0, 0},
                {0, 0, 0, 1}
        };
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = dfs(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        System.out.println("Kích thước vùng lớn nhất: " + maxArea);
    }

    static int dfs(int x, int y) {
        // Đánh dấu đã thăm
        visited[x][y] = true;
        int count = 1;

        // Duyệt 4 hướng
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (isValid(nx, ny)) {
                count += dfs(nx, ny);
            }
        }
        return count;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < cols &&
                grid[x][y] == 1 && !visited[x][y];
    }
}