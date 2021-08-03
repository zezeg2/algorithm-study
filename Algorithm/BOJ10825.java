import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static class Elem implements Comparable<Elem>{
         public String name;
         public int kor, eng, math;
         @Override
         public int compareTo(Elem other){
             if (kor != other.kor) return other.kor - kor;
             if (eng != other.eng) return eng - other.eng;
             if (math != other.math) return other.math - math;
             return name.compareTo(other.name);
         }

    }

    static int N;
    static Elem[] a;

    static void input() {
        N = scan.nextInt();
        a = new Elem[N];
        for (int i = 0; i < N; i++){
            a[i] = new Elem();
            a[i].name = scan.next();
            a[i].kor = scan.nextInt();
            a[i].eng = scan.nextInt();
            a[i].math = scan.nextInt();
        }
    }

    static void pro(){
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++){
            sb.append(a[i].name).append('\n');
        }
        System.out.println(sb);
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