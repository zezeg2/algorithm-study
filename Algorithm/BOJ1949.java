import java.io.*;
import java.util.*;

public class BOJ1949 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] population;
    static ArrayList<Integer>[] adj;
    static int[][] Dy;

    static void input() {
        N = scan.nextInt();
        population = new int[N+1];
        adj = new ArrayList[N+1];

        for (int i = 1; i <= N; i++){
            population[i] = scan.nextInt();
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++){
            int u = scan.nextInt(), v = scan.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        Dy = new int[N+1][2];
    }

    static void dfs(int x, int prev){
        Dy[x][0] = 0;
        Dy[x][1] = population[x];

        for (int y : adj[x]){
            if (y == prev) continue;
            dfs(y,x);
            Dy[x][0] += Math.max(Dy[y][0],Dy[y][1]);
            Dy[x][1] += Dy[y][0];
        }
    }

    static void pro(){
        dfs(1,-1);
        System.out.println(Math.max(Dy[1][0],Dy[1][1]));
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

// 위상관계가 존재하지 않는 일반 트리 형태의 문제도 큰 문제, 작은 문제 관계를 명확히 하기위해 부모, 자식 관계의 트리 문제로 가정하여  해결할 수 있는 경우가 있다