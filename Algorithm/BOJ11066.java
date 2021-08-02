import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[][] Dy;
    static int[][] sum;
    static int[] weight;

    static void input() {
        N = scan.nextInt();
        Dy = new int[N+1][N+1];
        sum = new int[N+1][N+1];
        weight = new int[N+1];
        for (int i = 1; i <= N; i++){
            weight[i] = scan.nextInt();
        }
    }

    static void prepro(){
        for (int i = 1; i <= N; i++){
            for (int j = i; j <= N; j++){
                sum[i][j] = sum[i][j-1] + weight[j];
            }
        }
    }

    static void pro(){
        prepro();
        for (int len = 2; len <= N; len++){
            for (int i = 1; i <= N - len + 1; i++){
                int j = i + len - 1;
                Dy[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++){
                    Dy[i][j] = Math.min(Dy[i][j],Dy[i][k]+Dy[k+1][j] + sum[i][j]);
                }
            }
        }
        System.out.println(Dy[1][N]);
    }



    public static void main(String[] args) {
        int T  = scan.nextInt();
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

//11049, 10942, 1509