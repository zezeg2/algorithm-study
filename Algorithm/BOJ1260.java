import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M, V;
    static int[][] adj;
    static boolean[] visit;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        V = scan.nextInt();
        adj = new int[N+1][N+1];
        for (int i = 1; i <= M; i++){
            int x = scan.nextInt(), y = scan.nextInt();
            adj[x][y] = 1;
            adj[y][x] = 1;
        }

    }

    static void dfs(int x){
        visit[x] = true;
        sb.append(x).append(' ');
        for(int y = 1; y <= N; y++){
            if (adj[x][y] == 0 ) continue;
            if (visit[y]) continue;
            dfs(y);
        }
    }

    static void bfs(int x){
        Queue<Integer> que = new LinkedList<>();

        que.add(x);
        visit[x] = true;

        while (!que.isEmpty()){
            x = que.poll();
            sb.append(x).append(' ');
            for (int y = 1; y <= N; y++){
                if (adj[x][y] == 0) continue;
                if (visit[y]) continue;
                que.add(y);
                visit[y] = true;
            }
        }

    }

    static void pro(){
        visit = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        for (int i = 1; i <= N; i++ ) visit[i] = false;
        bfs(V);
        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
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