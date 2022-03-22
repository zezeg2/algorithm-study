import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int M,N,K, ans;
    static boolean[][] visit, map;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};

    static void input() {
        M = scan.nextInt();
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[N][M];
        map = new boolean[N][M];
        for (int i = 0; i < K; i++){
            int u = scan.nextInt();
            int v = scan.nextInt();
            map[v][u] = true;
        }
        ans = 0;
    }

    static boolean dfs(int x, int y){
        if(x < 0 || y < 0 || x >= N || y >= M) return false;
        if(!map[x][y]) return false;
        if(visit[x][y]) return false;
        visit[x][y] = true;
        for (int k = 0; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            dfs(nx,ny);
        }
        return true;
    }

    static void pro(){
        for (int i = 0; i < N; i++) for (int j = 0; j < M; j++) if(dfs(i,j)) ans++;
        System.out.println(ans);
    }


    public static void main(String[] args) {
        int T = scan.nextInt();
        for (int i = 0; i < T; i++){
            input();
            pro();
        }
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}