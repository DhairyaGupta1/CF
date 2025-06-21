package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1850E {
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
        long c = input.nextLong(), a = 0, b = 0;
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = input.nextLong();
        }

        long si = 0, ei = 1000000000;
        while(si <= ei){
            long sum = 0, mid = si + (ei - si) / 2;
            boolean overflow = false;
            for(long i : arr) {
                long side = i + 2 * mid;
                if(i > 1e9 || sum > c){
                    overflow = true;
                    break;
                }
                sum += side * side;
            }

            if(sum > c || overflow) ei = mid - 1;
            else if(sum < c)    si = mid + 1;
            else{
                System.out.println(mid);
                return;
            }
        }
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
