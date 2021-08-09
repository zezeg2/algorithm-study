import java.io.*;
import java.util.*;

public class BOJ20291 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();
    static class Elem implements Comparable<Elem>{
        String extension;

        @Override
        public int compareTo(Elem other){
            return this.extension.compareTo(other.extension);
        }
    }

    static int N;
    static Elem[] files;

    static void input() {
        N = scan.nextInt();
        files = new Elem[N+1];
        files[0] = new Elem();
        files[0].extension = "";
        for (int i = 1; i <= N; i++){
            String[] x = scan.nextLine().split("[.]");
            files[i] = new Elem();
            files[i].extension = x[1];
        }
    }

    static void pro(){
        Arrays.sort(files);
        int count = 0;
        for (int i = 1; i <= N; i++){
            if ((i >= 2)&&(!files[i].extension.equals(files[i-1].extension))) {
                sb.append(files[i-1].extension).append(' ').append(count).append('\n');
                count = 1;

            }
            else{
                count++;
            }
            if (i == N) sb.append(files[i].extension).append(' ').append(count).append('\n');

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