import java.io.*;
import java.util.*;

public class BOJ11652 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();


    static int N, count, max_count;
    static long ans;
    static long[] A;

    static void input() {
        N = scan.nextInt();
        A = new long[N];
        for (int i = 0; i < N; i++){
            A[i] = scan.nextLong();
        }
    }

    static void pro(){
        Arrays.sort(A,0,N);
        ans = A[0];
        count = 1, max_count = 1;
        for (int i = 1; i < N; i++){
            if (A[i] == A[i-1]){
                count++;
            }
            else{
                count = 1;
            }
            if(count > max_count){
                max_count = count;
                ans = A[i];
            }
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

//20291