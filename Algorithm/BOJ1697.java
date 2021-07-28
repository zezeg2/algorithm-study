import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, K;
    static boolean[] visit;
    static int[] dist;

    static void input() {
        N = scan.nextInt();
        K = scan.nextInt();
        visit = new boolean[100000 + 1];
        dist = new int[100000 + 1];
    }


    static int move(int x, int num){
        if (num == 1) x += 1;
        else if (num == 2 ) x -= 1;
        else x *= 2;
        return x;
    }

    static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.add(N);
        visit[N] = true;
        dist[N] = 0;

        while (!Q.isEmpty()){
            int qn = Q.poll();
            for (int k = 1; k <=3; k++){
                int nn = move(qn, k);
                if (0 <= nn && nn <=100000 && !visit[nn]){
                    visit[nn] = true;
                    dist[nn] = dist[qn] + 1;
                    Q.add(nn);
                }
            }
        }
    }

    static void pro(){
        bfs();
        System.out.println(dist[K]);
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

//1389, 5567