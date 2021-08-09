import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static long K, ans;

    static void input() {
        N = scan.nextInt();
        K = scan.nextLong();
    }

    static void pro(){

        long left = 1;
        long right = K;

        while(right >= left){
            long mid = (left + right) / 2;
            long cnt = 0;
            for(int i = 1; i <= N; i++){
                cnt += Math.min(N,mid/i);
            }
            if (cnt < K) left = mid + 1;
            else {
                ans = mid;
                right = mid - 1;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(ans);
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