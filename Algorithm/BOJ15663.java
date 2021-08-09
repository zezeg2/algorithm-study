import java.io.*;
import java.util.*;

public class BOJ15663 {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N,M;
    static int[] nums, used;
    static int[] selected;
    static ArrayList<String> a;

    static void input(){
        N = scan.nextInt();
        M = scan.nextInt();
        nums = new int[N+1];
        used = new int[N+1];
        for (int i = 1; i <=N; i++){
            nums[i] = scan.nextInt();
        }
        selected = new int[M+1];
        Arrays.sort(nums);
        a = new ArrayList<String>();
    }

    static void rec_func(int k){
        if (k == M+1){
            String check = "";
            for (int i = 1; i <= M; i++){
                check += Integer.toString(selected[i]) + " ";
            }
            if(!a.contains(check)) {
                a.add(check);
                sb.append(check).append('\n');
            }
        }
        else{
            for (int cand = 1; cand <= N; cand++){
                boolean isUsed = false;
                for (int i = 1; i < k; i++){
                    if (selected[i] == nums[cand]) isUsed = true;
                }
                if(!isUsed){
                    selected[k] = nums[cand];
                    rec_func(k+1);
                    selected[k] = 0;
                }
            }
        }
    }


//    static class Elem implements Comparable<Elem>{
//        int value;
//        @Override
//        public int compareTo(Elem other){
//            return value - other.value;
//        }
//    }
//    static int N, M;
//    static Elem[] Ncapsule;
//    static Elem[] selected;
//    static ArrayList<String> a;
//
//    static void input() {
//        N = scan.nextInt();
//        M = scan.nextInt();
//        Ncapsule = new Elem[N+1];
//        selected = new Elem[M+1];
//
//        for (int i = 0; i <= N; i++){
//            Ncapsule[i] = new Elem();
//            if (i == 0) Ncapsule[i].value = 0;
//            else Ncapsule[i].value = scan.nextInt();
//        }
//        Arrays.sort(Ncapsule);
//
//        for (int i = 0; i <= M; i++){
//            selected[i] = new Elem();
//        }
//
//        a = new ArrayList<String>();
//    }
//
//    static void rec_func(int k){
//        if(k == M+1){
//            String check = "";
//            for (int i = 1; i <= M; i++){
//                check += Integer.toString(selected[i].value) + " ";
//            }
//            if(!a.contains(check)) {
//                a.add(check);
//                sb.append(check).append('\n');
//            }
//
//        }
//        else{
//            for (int cand = 1; cand <= N; cand++){
//                boolean isUsed = false;
//                for(int i = 1; i < k; i++){
//                    if (selected[i] == Ncapsule[cand]) isUsed = true;
//                }
//                if (!isUsed){
//                    selected[k] = Ncapsule[cand];
//                    rec_func(k+1);
//                    selected[k] = new Elem();
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
        System.out.println(a);
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