import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input() {
        N= scan.nextInt();
        Nnumbers = new int[N+1];
        for (int i = 1; i <= N; i++) {
            Nnumbers[i] = scan.nextInt();
        }

        M= scan.nextInt();
        Mnumbers = new int[M+1];
        for (int i = 1; i <= M; i++) {
            Mnumbers[i] = scan.nextInt();
        }
    }

    static int N, M;
    static int[] Nnumbers, Mnumbers;

    static boolean findNumber(int[] Nnumbers, int startIdx, int endIdx, int X){
        while (startIdx < endIdx){
            int mid = (startIdx+endIdx)/2;
            if (X == Nnumbers[mid]) {
                return true;
            }

            if (X > Nnumbers[mid]){
                startIdx = mid + 1;
            }
            else {
                endIdx = mid - 1;
            }
        }
        return false;
    }

    static void pro(){
        Arrays.sort(Nnumbers, 1, N+1);
        for (int i = 1; i <= M; i++){
            if (findNumber(Nnumbers, 1, N, Mnumbers[i])){
                sb.append(1).append('\n');
            }
            else{
                sb.append(0).append('\n');
            }
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