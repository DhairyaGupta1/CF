package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_1831B {
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
            int[] a = new int[n], b = new int[n];
            long max_a = 0, max_b = 0, cnt = 1;

            for(int i = 0; i < n; i++)  a[i] = input.nextInt();
            for(int i = 0; i < n; i++)  b[i] = input.nextInt();

            int[] fa = new int[2 * n + 1], fb = new int[2 * n + 1];
            int x = 1;

            for(int i = 1; i < n; i++){
                if(a[i] == a[i - 1])    x++;
                else{
                    fa[a[i - 1]] = Math.max(fa[a[i - 1]], x);
                    x = 1;
                }
            }
            fa[a[n - 1]] = Math.max(fa[a[n - 1]], x);
            x = 1;

            for(int i = 1; i < n; i++){
                if(b[i] == b[i - 1])    x++;
                else{
                    fb[b[i - 1]] = Math.max(fb[b[i - 1]], x);
                    x = 1;
                }
            }
            fb[b[n - 1]] = Math.max(fb[b[n - 1]], x);
            long max = 0;
            for(int i = 0; i <= 2*n; i++){
                max = Math.max(max, fa[i] + fb[i]);
            }

            System.out.println(max);
        }
    }
}
