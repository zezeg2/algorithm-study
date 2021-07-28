import java.io.*;
import java.util.*;
import java.lang.reflect.Array;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, group_count;
    static String[] a;
    static boolean[][] visit;
    static int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
    static ArrayList<Integer> group;


    static void input() {
        N = scan.nextInt();
        a = new String[N];
        for (int i = 0; i < N; i++){
            a[i] = scan.nextLine();
        }
        visit = new boolean[N][N];

    }

    static void dfs(int x, int y){
        group_count++;
        visit[x][y] = true;

        for (int k = 0; k < 4; k++){
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (a[nx].charAt(ny) == '0') continue;
            if (visit[nx][ny]) continue;

            dfs(nx,ny);
        }

    }
    static void pro(){
        group = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (!visit[i][j] && a[i].charAt(j) == '1'){
                    group_count = 0;
                    dfs(i,j);
                    group.add(group_count);
                }
            }
        }
        Collections.sort(group);
        sb.append(group.size()).append('\n');
        for (int cnt: group) sb.append(cnt).append('\n');
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

// 관련 문제 1012, 11724, 4963, 3184, 2606, 11403, 11725