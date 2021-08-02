import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[][] Dy;

    static void input() {
        N = scan.nextInt();
        Dy = new int[N+1][10];
    }

    static void pro(){
        for (int i = 0; i < 10; i++){
            Dy[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for(int j = 0; j < 10; j++){
                for (int prev = 0; prev <= j; prev++){
                    Dy[i][j] += Dy[i-1][prev];
                    Dy[i][j] %= 10007;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 10; i++){
            ans += Dy[N][i];
            ans %= 10007;
        }
        System.out.println(ans);
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

//2688, 1562, 2092, 5557, 1495, 9095, 15988, 15990