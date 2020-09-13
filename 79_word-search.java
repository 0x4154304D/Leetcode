class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board == null) return false;
        int[][] visited = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if(dfs(board, word, i, j, 0, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int x, int y, int index, int visited[][]) {
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        if (word.charAt(index) == board[x][y]) {
            visited[x][y] = 1;
            int[][] div = {{-1,0},{1,0},{0,1},{0,-1}};
            for (int i = 0; i < 4; ++i) {
                int xx = x + div[i][0];
                int yy = y + div[i][1];
                if (xx < 0 || yy < 0 || xx >= board.length || yy >= board[0].length) continue;
                if (visited[xx][yy] == 1) continue;
                if(dfs(board, word, xx, yy, index + 1, visited)){
                    return true;
                }
            }
            visited[x][y] = 0;
        }
        return false;
    }
}

//
public class Solution {
    public static boolean exist(char[][] args, String trim) {
        boolean[][] visit = new boolean[args.length][args[0].length];
        for (int i = 0; i < args.length; i++) {
            for (int j = 0; j < args[0].length; j++) {
                if (help(args, trim, i, j, 0, visit)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean help(char[][] temp, String s, int i, int j, int m, boolean[][] visit) {
        if (m == s.length()) {
            return true;
        }
        if (i < 0 || i >= temp.length || j < 0 || j >= temp[0].length || temp[i][j] != s.charAt(m) || visit[i][j]) {
            return false;
        }
        visit[i][j] = true;
        boolean res = help(temp, s, i - 1, j, m + 1, visit) || help(temp, s, i, j - 1, m + 1, visit)
                || help(temp, s, i + 1, j, m + 1, visit) || help(temp, s, i, j + 1, m + 1, visit);
        visit[i][j] = false;
        return res;
    }
}