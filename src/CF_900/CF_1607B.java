package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1607B {
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
            long x0 = input.nextLong(), n = input.nextLong();
            long ans = x0;

            if(x0 % 2 == 0){
                if(n % 4 == 1)  ans += -n;
                if(n % 4 == 2)  ans += 1;
                if(n % 4 == 3)  ans += n + 1;
                if(n % 4 == 0)  ans += 0;
            }
            else{
                ans--;
                if(n % 4 == 1)  ans += n + 1;
                if(n % 4 == 2)  ans += 0;
                if(n % 4 == 3)  ans += -n;
                if(n % 4 == 0)  ans += 1;
            }

            if(n == 0)  System.out.println(x0);
            else    System.out.println(ans);
        }
    }
}
