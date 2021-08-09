import java.io.*;
import java.util.*;

public class BOJ1181 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static class Elem implements Comparable<Elem>{
        int length;
        String word;

        @Override
        public int compareTo(Elem other){
            if (this.word.length() == other.word.length()) return this.word.compareTo(other.word);
            return this.word.length() - other.word.length();
        }
    }

    static int N;
    static Elem[] words;

    static void input() {
        N = scan.nextInt();
        words = new Elem[N+1];
        words[0] = new Elem();
        words[0].word = "";
        for(int i = 1; i <= N; i++){
            words[i] = new Elem();
            words[i].word = scan.nextLine();
            words[i].length = words[i].word.length();
        }
    }

    static void pro(){
        Arrays.sort(words);
        for (int i = 1; i <= N; i++){
            if (!words[i].word.equals(words[i-1].word)){
                sb.append(words[i].word).append('\n');
            }
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