import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N;
    static int[] Nset;

    static void input() {
        N = scan.nextInt();
        Nset = new int[N+1];
        for (int i = 1; i <= N; i++){
            Nset[i] = scan.nextInt();
        }

    }

    static boolean func(int targetIdx){
        int  L = 1, R = N;
        int target = Nset[targetIdx];
        while(L < R){
            if (L == targetIdx) L++;
            else if(R == targetIdx) R--;
            else{
                if (Nset[L] + Nset[R] == target) return true;
                else if(Nset[L] + Nset[R] > target) R--;
                else L++;
            }
        }
        return false;
    }

    static void pro(){
        int ans = 0;
        Arrays.sort(Nset,1,N+1);

        for (int i = 1; i <= N; i++){
            if(func(i)) ans++;
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

// 관련 문제 2473