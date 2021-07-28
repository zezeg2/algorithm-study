import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input() {
        FastReader scan = new FastReader();
        N= scan.nextInt();
        nums = new int[N+1];
        operators = new int[5];
        for (int  i = 1; i <= N; i++) nums[i] = scan.nextInt();
        for (int  i = 1; i <= 4; i++) operators[i] = scan.nextInt();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

    }

    static int N, max, min;
    static int[] nums, operators;


    // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
    static int calculator(int operand1, int cand, int operand2 ){
        if(cand==1) return operand1 + operand2;
        else if(cand==2) return operand1 - operand2;
        else if(cand==3) return operand1 * operand2;
        else return operand1 / operand2;
    }
    static void rec_func(int k, int value){
        if(k == N){
//            int value = calculator();
            max = Math.max(max,value);
            min = Math.min(min,value);
        }
        else{
            for(int cand=1;cand<=4;cand++){
                if(operators[cand] >= 1){
                    operators[cand]--;
                    rec_func(k+1, calculator(value, cand, nums[k+1]));
                    operators[cand]++;
                }
            }
        }
    }



    public static void main(String[] args) {
        input();
        rec_func(1, nums[1]);
        sb.append(max).append('\n').append(min);
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