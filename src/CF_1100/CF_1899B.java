package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CF_1899B {
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

        long max = 0, min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        max = max - min;
        List<Integer> fac = new ArrayList<>();

        long[] pref = new long[n];
        pref[0] = arr[0];
        for(int i = 1; i < n; i++)  pref[i] = pref[i - 1] + arr[i];

        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                fac.add(i);
                if(n / i != i)  fac.add(n / i);
            }
        }

//        for(int i : pref)   System.out.print(i + " ");
//        System.out.println();

        for(int f : fac){
            int si = f - 1, ei = f + si;
            long max2 = pref[si], min2 = pref[si];
            while(ei < n){
                min2 = Math.min(pref[ei] - pref[si], min2);
                max2 = Math.max(pref[ei] - pref[si], max2);
                si += f;
                ei += f;
            }
//            System.out.println(max2 + " " + min2);
            max = Math.max(max2 - min2, max);
        }

        System.out.println(max);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
