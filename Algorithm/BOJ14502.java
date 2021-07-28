import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M, virusCount, ans;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] contaminated;
    static String[] shape;


    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        shape = new String[N];
        for (int i = 0; i < N; i++){
            shape[i] = scan.nextLine();
        }
        contaminated = new boolean[N][M];
        ans = Integer.MAX_VALUE;
    }

    static void dfs(int x, int y){
        contaminated[x][y] = true;
        virusCount++;
        for (int k = 0; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || nx >= N || ny < 0 || ny>= M) continue;
            if (shape[nx].charAt(ny) == '1') continue;
            if (contaminated[nx][ny]) continue;
            dfs(nx,ny);
        }
    }

    static void rec_func(int k){
        if(k == 3){
            int num_wall = 0;
            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){
                    if (shape[i].charAt(j) == '1') num_wall++;
                }
            }

            virusCount = 0;
            for (int i = 0; i < N; i++ ) {
                for (int j = 0; j < M; j++) {
                    if(shape[i].charAt(j) == '2'){
                        dfs(i,j);
                        ans = Math.min(ans, M*N - num_wall - virusCount);
                    }
                    continue;
                }
            }
            System.out.println(ans);
        }

        else{
            for (int i = 0; i < N; i++ ){
                for (int j = 0 ; j < M; j++){
                    if(shape[i].charAt(j) == '1') continue;
                    shape[i].setCharAt(j) = '1';
                    rec_func(k+1);
                }
            }
        }
    }


    public static void main(String[] args) {
        input();
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