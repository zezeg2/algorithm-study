import java.io.*;
import java.util.*;

public class BOJ15654 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();


    static int N, M;
    static int[] numSet;
    static int[] selected;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        numSet = new int[N+1];
        for (int i = 1; i <= N; i++){

            numSet[i] = scan.nextInt();
        }
        selected = new int[M+1];
    }

    static void rec_func(int k){
        if (k == M+1){
            for (int i = 1; i <= M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        }
        else{
            for (int cand = 1; cand <= N; cand++){
                boolean isUsed = false;
                for (int i = 1; i <= k; i++){
                    if (selected[i] == numSet[cand]) isUsed = true;
                }
                if (!isUsed){
                    selected[k] = numSet[cand];
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        Arrays.sort(numSet);
        rec_func(1);
        System.out.println(sb.toString());
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