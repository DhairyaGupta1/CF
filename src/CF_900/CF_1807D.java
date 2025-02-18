package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1807D {
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
            int n = input.nextInt(), q = input.nextInt();
            long[] arr = new long[n], prefix = new long[n + 1];

            for(int i = 1; i <= n; i++){
                arr[i-1] = input.nextInt();
                prefix[i] = prefix[i - 1] + arr[i - 1];
            }

            while(q-- > 0){
                int l = input.nextInt() - 1, r = input.nextInt() - 1;
                long k = input.nextLong();

                boolean b = (prefix[n] - (prefix[r + 1] - prefix[l]) + k * (r - l + 1)) % 2 == 1;
                System.out.println( b ? "YES" : "NO");
            }
        }
    }

}