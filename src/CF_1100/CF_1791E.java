package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1791E {
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
        int min = Integer.MAX_VALUE, numNeg = 0;
        long sum = 0; boolean has0 = false;
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            min = Math.min(min, Math.abs(arr[i]));
            sum += Math.abs(arr[i]);
            if(arr[i] == 0) has0 = true;
            if(arr[i] < 0)  numNeg++;
        }

        if(has0 || numNeg % 2 == 0){
            System.out.println(sum);
            return;
        }
        System.out.println(sum - 2L * min);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }
}
