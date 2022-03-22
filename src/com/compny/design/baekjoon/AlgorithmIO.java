package com.compny.design.baekjoon;

import java.io.*;
import java.util.*;

public class AlgorithmIO {
//  -------------------------------------------------- Copy from Here --------------------------------------------------
    static StringBuilder sb = new StringBuilder();
    static FastReader scan = new FastReader();

    static int N, M;
    static int[] selected;

    static void input() {
        N = scan.nextInt();

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
//  --------------------------------------------------- Copy to Here ---------------------------------------------------
}