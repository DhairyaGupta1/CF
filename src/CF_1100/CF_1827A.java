package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1827A {
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

    private static void solve(FastReader input){
        int n = input.nextInt();
        int[] a = new int[n], b = new int[n];

        for(int i = 0; i < n; i++)  a[i] = input.nextInt();
        for(int i = 0; i < n; i++)  b[i] = input.nextInt();

        Arrays.sort(a); Arrays.sort(b);

        int[] numSmall = new int[n];
        int i = 0, j = 0;

        while(i < n){
            while(j < n && a[i] > b[j]){
                j++;
            }

            while(j >= n && i < n){
                numSmall[i++] = j;
            }

            if(i < n)   numSmall[i++] = j;
        }
        long ans = 1, mod = (long)1e9 + 7;
//        System.out.println(mod);
        for(i = 0; i < n; i++){
            if(numSmall[i] == 0){
                System.out.println(0);
                return;
            }
//            System.out.print((numSmall[i] - i) + " ");
            ans = (ans * (numSmall[i] - i)) % mod;
        }


//        System.out.println(Math.max(ans, 0));
        System.out.println(ans);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
