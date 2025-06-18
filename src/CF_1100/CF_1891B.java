package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF_1891B {
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
        int n = input.nextInt(), q = input.nextInt();
        long[] a = new long[n];
        int min1 = 31;
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++)  a[i] = input.nextLong();
        for(int i = 0; i < q; i++) {
            int temp = input.nextInt();
            if(temp < min1){
                arr.add(temp);
                min1 = temp;
            }
        }

        int[] pow2 = new int[31];   pow2[0] = 1;
        for(int i = 1; i < 31; i++) pow2[i] = pow2[i - 1] * 2;

        for(int i = 0; i < n; i++){
            int min = 31;
            for(int j : arr){
                if(j > min) continue;

                if(a[i] % pow2[j] == 0) {
                    a[i] += pow2[j - 1];
                    min = j - 1;
                }
            }
        }

        for(long l : a) System.out.print(l + " ");
        System.out.println();
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
