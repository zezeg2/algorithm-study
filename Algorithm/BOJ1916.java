import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static class Edge{
        public int to, weight;
        public Edge(int _to, int _weight){
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info{
        public int idx, dist;
        public Info(){

        }
        public Info(int _idx, int _dist){
            this.idx = _idx;
            this.dist = _dist;
        }
    }

    static int N, M, start, end;
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static void input() {
        N = scan.nextInt();
        M = scan.nextInt();
        edges = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 1; i <= N; i++){
            edges[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++){
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            edges[u].add(new Edge(v,w));
        }

        start = scan.nextInt();
        end = scan.nextInt();

    }

    static void dijikstra(int start){
        // 모든 정점까지에 대한 거리를 무한대로 초기화
        for(int i = 1; i <=N; i++) dist[i] = Integer.MAX_VALUE;

        // 최소힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(start,0));
        dist[start] = 0;

        //시작점에 대한 정보(INformation)을 기록에 추가하고, 거리배열(dist)에 갱신
        while(!pq.isEmpty()){
            Info info = pq.poll();
            if(dist[info.idx] < info.dist) continue;
            for(Edge e: edges[info.idx]){
                if (dist[info.idx] + e.weight >= dist[e.to]) continue;
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }

    public static void main(String[] args) {
        input();
        dijikstra(start);
        System.out.println(dist[end]);
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