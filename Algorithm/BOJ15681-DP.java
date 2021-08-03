import java.io.*;
import java.util.*;

public class BOJ15681 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, R, Q;
    static ArrayList<Integer>[] adj;
    static int[] Dy;


    static void input() {
        N = scan.nextInt();
        R = scan.nextInt();
        Q = scan.nextInt();
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < N-1; i++){
            int u = scan.nextInt(), v = scan.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

        Dy = new int[N+1];
    }

    static void dfs(int x, int par){
        Dy[x] = 1;
        for (int y : adj[x]){
            if (y == par) continue;
            dfs(y, x);
            Dy[x] += Dy[y];
        }
    }

    static void pro(){
        dfs(R, -1);
        for (int i = 0; i < Q; i++){
            int x  = scan.nextInt();
            sb.append(Dy[x]).append('\n');
        }
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