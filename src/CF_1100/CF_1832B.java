package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1832B {
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
        int n = input.nextInt(), k = input.nextInt();
        int[] arr = new int[n];
        long sum = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        long[] min2 = new long[k], max = new long[k];
        min2[0] = arr[0] + arr[1];
        for(i = 2; i < 2 * k; i += 2){
            min2[i / 2] = arr[i] + arr[i + 1] + min2[i / 2 - 1];
        }
        max[0] = arr[n - 1];
        for(i = 1; i < k; i++){
            max[i] = arr[n - i - 1] + max[i - 1];
        }

        long minSub = Math.min(min2[k - 1], max[k - 1]);
//        System.out.println(minSub + " " + min2[0]);
        i = 0; j = k - 2;
        long curr = 0;
        for(i = 0; i < k - 1; i++){
            curr = Math.min(min2[i] + max[k - i - 2], min2[k - i - 2] + max[i]);
            minSub = Math.min(minSub, curr);
        }

        System.out.println(sum - minSub);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
