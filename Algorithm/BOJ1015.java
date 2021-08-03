import java.io.*;
import java.util.*;

public class BOJ1015 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static class Elem implements Comparable<Elem>{
        int idx, value;

        @Override
        public int compareTo(Elem other){
            return value - other.value;
        }
    }

    static int N;
    static Elem[] B;
    static int[] P;

    static void input() {
        N = scan.nextInt();
        B = new Elem[N];
        for (int i = 0; i < N; i++){
            B[i] = new Elem();
            B[i].idx = i;
            B[i].value = scan.nextInt();
        }
        P = new int[N];
    }

    static void pro(){
        Arrays.sort(B);
        for (int i = 0; i < N; i++){
            P[B[i].idx] = i;
        }

        for (int i = 0; i < N; i++){
            sb.append(P[i]).append(' ');

        }
        System.out.println(sb.toString());

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