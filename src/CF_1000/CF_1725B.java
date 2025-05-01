package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1725B
{
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

        int T = 1;

        while(T-- > 0){
            int n = input.nextInt(), D = input.nextInt();
            int[] arr = new int[n];

            for(int i = 0 ; i < n; i++) arr[i] = input.nextInt();
            Arrays.sort(arr);

            long wins = 0, left = n;
            for(int i = n - 1; i >= 0; i--){
                long req = (long) Math.ceil((D * 1.0) / arr[i]);
                if(req * arr[i] == D)   req++;
                if(left >= req){
                    left -= req;
                    wins++;
                }
                else break;
            }

            System.out.println(wins);
        }
    }
}
