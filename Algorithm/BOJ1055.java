import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;
    static int[] indegree, T, Tdone;
    static ArrayList<Integer>[] adj;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        T = new int[N+1];
        for (int i = 1; i <= N; i++){
            T[i] = scan.nextInt();
        }
        Tdone = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++){
            adj[i] = new ArrayList<>();
        }
        indegree = new int[N+1];
        for (int i = 0; i < K; i++){
            int u = scan.nextInt(), v = scan.nextInt();
            adj[u].add(v);
            indegree[v]++;
        }
    }

    static void pro(){
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++){
            if (indegree[i] == 0){
                queue.add(i);
                Tdone[i] = T[i];
            }
        }
        while(!queue.isEmpty()){
            int x = queue.poll();
            for (int y : adj[x]){
                indegree[y]--;
                if(indegree[y] == 0) queue.add(y);
                Tdone[y] = Math.max(Tdone[y],Tdone[x]+T[y]);
            }
        }
        int W = scan.nextInt();
        System.out.println(Tdone[W]);

    }

    public static void main(String[] args) {
        int TC = scan.nextInt();
        for (int i = 0; i < TC; i++){
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

// 1516, 2056, 2637;