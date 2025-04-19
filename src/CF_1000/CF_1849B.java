package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CF_1849B {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st == null)  st = new StringTokenizer(br.readLine());
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();
        Comparator<Pair> com = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.y < o2.y) return 1;
                else if(o1.y == o2.y){
                    if(o1.x > o2.x) return 1;
                    else return -1;
                }
                else return -1;
            }
        };

        while(t-- > 0){
            int n = input.nextInt(), k = input.nextInt();
            Pair[] pairs = new Pair[n];
            for(int i = 0; i < n; i++) {
                pairs[i] = new Pair(i + 1, input.nextInt() % k);
            }

            Arrays.sort(pairs, com);

            int j = n - 1;
            while(j >= 0 && pairs[j].y == 0) j--;
            for(int i = j + 1; i < n; i++)  System.out.print(pairs[i].x + " ");
            for(int i = 0; i <= j; i++) System.out.print(pairs[i].x + " ");

            System.out.println();
        }
    }

    static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
