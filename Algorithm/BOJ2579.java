import java.io.*;
import java.util.*;

public class BOJ2579 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] stepPoint;
    static int[][] Dy;
    static ArrayList<Integer>[][] history;

    static void input() {
        N = scan.nextInt();
        stepPoint = new int[N+1];
        for(int i = 1; i <= N; i++){
            stepPoint[i] = scan.nextInt();
        }
        Dy = new int[N+1][2];
        history = new ArrayList[N+1][2];
        for (int i = 1; i <=N; i++){
            history[i][0] = new ArrayList<>();
            history[i][1] = new ArrayList<>();
        }
    }


    static void pro(){
        Dy[1][0] = 0;
        Dy[1][1] = stepPoint[1];
        history[1][1].add(1);
        if (N >=2){
            Dy[2][0] = stepPoint[2];
            Dy[2][1] = stepPoint[1] + stepPoint[2];
            history[2][0].add(2);
            history[2][1].add(1);
            history[2][1].add(2);
        }
        for (int i = 3; i <= N; i++){
            Dy[i][0] = Math.max(Dy[i - 2][0], Dy[i - 2][1]) + stepPoint[i];
            if (Dy[i-2][0] > Dy[i-2][1]){
                history[i][0] = history[i-2][0];
            }
            else{
                history[i][0] = history[i-2][1];
            }
            history[i][0].add(i);

            Dy[i][1] = Dy[i - 1][0] + stepPoint[i];
            history[i][1] = history[i-1][0];
            history[i][1].add(i);
        }

        int ans = Math.max(Dy[N][0], Dy[N][1]);

        System.out.println(ans);

        if (ans == Dy[N][0]) System.out.println(history[N][0]);
        else System.out.println(history[N][1]);
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

//1149, 2156, 2193, 1309, 2688