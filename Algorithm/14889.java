import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static void input() {
        N= scan.nextInt();
        ability = new int[N+1][N+1];
        for (int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                if(i == j) ability[i][j] = 0;
                ability[i][j] = scan.nextInt();
            }
        }
        teamChecker = new boolean[N+1];
    }

    static int N , ans;
    static int team1, team2 ;
    static int[][] ability;
    static boolean[] teamChecker;
    static int min = Integer.MAX_VALUE;

    static int abilityGap(){
        team1 = 0;
        team2 = 0;
        for(int i=1; i<N+1; i++) {
            for(int j=1; j<N+1; j++) {
                // true 면 스타트팀
                if(teamChecker[i] && teamChecker[j])
                    team1 += ability[i][j];

                // false 면 링크팀
                if(teamChecker[i] != true && teamChecker[j] != true)
                    team2 += ability[i][j];
            }
        }

        return Math.abs(team2 - team1);
    }

    static void rec_func(int k, int depth){
        if(depth == 2/N){
            ans = Math.min(abilityGap(), min);
        }
        else{
            for (int cand = k; cand <= N; cand++) {

                    teamChecker[cand] = true;
                    rec_func(cand+1, depth + 1);
                    teamChecker[cand] = false;
            }
        }

    }


    public static void main(String[] args) {
        input();
        rec_func(1,1);
        System.out.println(ans);
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