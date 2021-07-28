import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] Nset, count;

    static void input() {
        N = scan.nextInt();
        Nset = new int[N+1];
        for (int i = 1; i <= N; i++){
            Nset[i] = scan.nextInt();
        }
        count = new int[100000 + 1];
    }

    static void pro(){
        long ans = 0;
        for (int L = 1, R = 0; L <= N; L++){
            while (R+1 <= N && count[Nset[R + 1]] == 0){
                R++;
                count[Nset[R]]++;
            }
            ans += R - L + 1;
            count[Nset[L]]--;
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