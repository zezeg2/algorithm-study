import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        checked = new boolean[N+1];
        for (int i = 1; i<=N; i++){
            nums[i] = scan.nextInt();
        }
        arr = new int[N+1];

    }

    static int N, M;
    static int[] nums,arr;
    static boolean checked[];

    static void rec_func(int count){
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!checked[i]) { // 방문안하고 현재값이 이전값보다 커야함
                if (count == 0 || (count > 0&& nums[i] > arr[count - 1])) {
                    checked[i] = true;
                    arr[count] = nums[i];
                    rec_func(count + 1);
                    arr[count] = 0; //0으로 초기화
                    checked[i] = false;
                }
            }
        }
    }



    public static void main(String[] args) {
        input();
        Arrays.sort(nums);
        rec_func(0);
        System.out.println(sb.toString());
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