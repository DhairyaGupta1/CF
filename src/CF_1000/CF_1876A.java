package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class CF_1876A {
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

        int T = input.nextInt();
        Comparator<Pair> com = new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.y - o2.y;
            }
        };

        while(T-- > 0){
            int n = input.nextInt(), m = input.nextInt();

            Pair[] pairs = new Pair[n];
            for(int i = 0; i < n; i++)  pairs[i] = new Pair(input.nextInt(), 0);
            for(int i = 0; i < n; i++)  pairs[i].y = input.nextInt();

            Arrays.sort(pairs, com);


            long maxCost = m;
            int i = 0, left = n - 1;
            while(left > 0 && pairs[i].y <= m){
                long curr = Math.min(pairs[i].x, left);
                left -= (int) curr;
                maxCost += curr * pairs[i++].y;
            }

            maxCost += ((long)left) * m;
            System.out.println(maxCost);
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