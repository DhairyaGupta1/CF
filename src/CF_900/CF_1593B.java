package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1593B {
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
            long n = input.nextLong();

            String num = n + "";
            int first0 = -1, first5 = -1;
            int firsta = -1, firstb = -1, len = num.length();

            for(int i = len - 1; i >= 0; i--){
                char c = num.charAt(i);

                if(c == '0' && first0 == -1) first0 = Math.max(i, first0);
                else if(first0 != -1 && (c == '0' || c == '5')) firsta = Math.max(i, firsta);

                if(c == '5' && first5 == -1)    first5 = Math.max(i, first5);
                else if(first5 != -1 && (c == '2' || c == '7')) firstb = Math.max(i, firstb);
            }

            int ans = len - first5 - 1 + first5 - firstb - 1;
            ans = Math.min(ans, len - first0 - 1 + first0 - firsta - 1);
            System.out.println(ans);
        }
    }
}
