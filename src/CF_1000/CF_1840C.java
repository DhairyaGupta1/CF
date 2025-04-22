package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1840C {
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
            int n = input.nextInt(), k = input.nextInt(), q = input.nextInt();

            long[] temp = new long[n];
            for(int i = 0; i < n; i++)  temp[i] = input.nextLong();

            int ei = 0;
            long cnt = 0, curr = 0;

            while(ei < n){
                if(temp[ei] <= q)   curr++;
                else{

                    cnt += (curr >= k) ? fact(curr + 1 - k, k) : 0;
                    curr = 0;
                }
                ei++;
            }

            cnt += (curr >= k) ? fact(curr + 1 - k, k) : 0;
            System.out.println(cnt);
        }
    }

    static long fact(long f, int k){
        long ans = f * (f + 1) / 2;
        return ans;
    }
}
