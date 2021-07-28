import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int w, h;
    static int[][] map;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    static void input() {
        w = scan.nextInt();
        h = scan.nextInt();
        map = new int[w][h];
        for (int i = 0; i < h; i++) for(int j = 0; j < w; j++) map[i][j] = scan.nextInt();
        visit = new boolean[h][w];
    }

//    static void bfs(int x, int y){
//        if(map[x][y] == 0) return;
//        Queue<Integer> Q = new LinkedList<>();
//
//        if (!visit[x][y]){
//            Q.add(x);
//            Q.add(y);
//            visit[x][y] = true;
//        }
//
//        while(!Q.isEmpty()){
//            int qx = Q.poll(), qy = Q.poll();
//            for (int k = 0; k < 8; k++){
//                int nx = qx + dir[k][0];
//                int ny = qy + dir[k][1];
//                if(nx < 0 || nx >= w || ny < 0 || ny >= h) continue;
//                if(map[nx][ny] == 0) continue;
//                if(visit[nx][ny]) continue;
//                visit[nx][ny] = true;
//                Q.add(nx);
//                Q.add(ny);
//            }
//        }
//
//    }

    static void dfs(int x, int y){
        visit[x][y] = true;
        for (int k = 0; k < 8; k++) {
            int nx = x + dir[k][0];
            int ny = y + dir[k][1];
            if (nx < 0 || ny < 0 || nx >= h || ny >= w) continue;  // 지도를 벗어나는 곳으로 가는가?
            if (map[nx][ny] == 0) continue;  // 갈 수 있는 칸인지 확인해야 한다.
            if (visit[nx][ny]) continue;  // 이미 방문한 적이 있는 곳인가?
            dfs(nx, ny);
        }
    }


    static void pro(){
        int ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (!visit[i][j] && map[i][j] == 1) {
                    ans++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(ans);
    }


    public static void main(String[] args) {
        while (true) {
            input();
            if (w == 0 && h == 0) break;
            pro();
        }
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