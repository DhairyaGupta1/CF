package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1826B {
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
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)  arr[i] = input.nextInt();
        boolean b = true;
        for(int i = 1; i < n; i++){
            if(arr[i] != arr[i - 1]){
                b = false;
                break;
            }
        }

        if(b){
            System.out.println(0);
            return;
        }
        int gcd = Math.abs(arr[0] - arr[n - 1]);
        for(int i = 1; i < n - 1; i++){
            if(i % 2 == 1 && i == n / 2)    continue;
            int diff = Math.abs(arr[i] - arr[n - i - 1]);
            gcd = gcd(Math.max(gcd, diff), Math.min(gcd, diff));
        }

        System.out.println(gcd);
    }

    private static int gcd(int i, int j){
        if(j == 0)  return i;
        return gcd(j, i % j);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
