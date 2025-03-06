package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1624B {
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

        while(t-- > 0){
            long a = input.nextLong(), b = input.nextLong(), c = input.nextLong();

            double d1 = b - a, d2 = c - b;

            double c1 = b + d1, b1 = a + (c - a)/ 2.0, a1 = b - d2;

            if(b - a == c - b)  System.out.println("YES");
            else if(c1 != 0 && (c1 % c == 0) && c1 > c) System.out.println("YES");
            else if(b1 != 0 && (b1 % b == 0) && b1 > b) System.out.println("YES");
            else if(a1 != 0 && (a1 % a == 0) && a1 > a) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
