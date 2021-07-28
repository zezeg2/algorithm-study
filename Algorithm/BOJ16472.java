import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, kind;
    static String message;
    static int[]  count;

    static void input() {
        N = scan.nextInt();
        message = scan.nextLine();
        count = new int[26];
    }

    static void add(char x){
        count[x-'a']++;
        if(count[x-'a'] == 1) kind++;
    }

    static void erase(char x){
        count[x-'a']--;
        if(count[x-'a'] == 0) kind--;
    }

    static void pro(){
        int len = message.length(),ans = 0;
        for (int L = 0, R = 0; R < len; R++){
            add(message.charAt(R));
            while(kind > N){
                erase(message.charAt(L++));
            }
            ans = Math.max(ans, R - L + 1);
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