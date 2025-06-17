package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1899C {
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
        long maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            maxSum = Math.max(arr[i], maxSum);
        }
        if(n == 1){
            System.out.println(arr[0]);
            return;
        }

        int prev = 0;
        for(int i = 1; i < n; i++){
            if((arr[i] & 1) == (arr[i - 1] & 1)){
                maxSum = Math.max(maxSum, max(prev, i - 1, arr));
                prev = i;
            }
        }

        maxSum = Math.max(maxSum, max(prev, n - 1, arr));
        System.out.println(maxSum);
    }

    private static long max(int si, int ei, int[] arr){
        long max = arr[si], curr = 0;

        for(int i = si; i <= ei; i++){
            curr += arr[i];
            max = Math.max(max, curr);
            if(curr < 0)    curr = 0;
        }

        return max;
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
