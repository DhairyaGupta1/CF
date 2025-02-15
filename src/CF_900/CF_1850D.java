package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF_1850D {
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

        int nextInt() { return parseInt(next()); }

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
            long k = input.nextLong();

            long[] arr = new long[n];
            for(int i = 0; i < n; i++)  arr[i] = input.nextLong();

            Arrays.sort(arr);
            long cnt = 0, maxCnt = 0;
            for(int i = 1; i < n; i++){
                if(arr[i] - arr[i - 1] > k){
                    maxCnt = Math.max(maxCnt, cnt);
                    cnt = 0;
                }
                else cnt++;
            }

            if(cnt > maxCnt)    maxCnt = cnt;

            System.out.println(n - (maxCnt + 1));
        }
    }

}
