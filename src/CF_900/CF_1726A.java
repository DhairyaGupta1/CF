package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1726A {
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
            int n = input.nextInt();

            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, ans = max;
            int[] arr = new int[n];

            for(int i = 0; i < n; i++)  arr[i] = input.nextInt();

            for(int i = 1; i < n; i++)  max = Math.max(max, arr[i]);
            for(int i = 0; i < n - 1; i++)  min = Math.min(min, arr[i]);

            ans = Math.max(max - arr[0], arr[n - 1] - min);

            for(int i = 0; i < n; i++){
                ans = Math.max(-arr[(i + 1) % n] + arr[i], ans);
            }

            System.out.println(n == 1 ? 0 : ans);
        }
    }

}
