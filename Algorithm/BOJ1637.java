import java.io.*;
import java.util.*;

public class BOJ1637 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, maxint, ans, total;
    static int[] A,B,C;

    static void input() {
        N = scan.nextInt();
        maxint = Integer.MIN_VALUE;
        A = new int[N];
        B = new int[N];
        C = new int[N];
        for (int i = 0; i < N; i++){
            A[i] = scan.nextInt();
            B[i] = scan.nextInt();
            C[i] = scan.nextInt();
            maxint = Math.max(maxint,B[i]);
        }
    }

    static void pro() {
        int left = 1;
        int right = maxint;
        boolean noodd = true;
        while (right >= left) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(A[i] > mid) continue;
                if (B[i] >= mid) cnt += (mid - A[i]) / C[i];
                else cnt += (B[i] - A[i]) / C[i] + 1;

            }
            if (cnt % 2 == 0) {
                ans = mid;
                left = mid + 1;
            }

            else {
                right = mid - 1;
                noodd = false;
            }
        }

        if (noodd) sb.append("NOTHING");
        else{
            for (int i = 0; i < N; i++) {
                if ((ans <= B[i] && ans >= A[i]) && ((ans - A[i]) % C[i] == 0)) total++;
            }
            sb.append(ans).append(' ').append(total);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
        System.out.println(sb);
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