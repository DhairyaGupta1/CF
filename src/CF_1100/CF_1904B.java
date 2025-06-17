package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_1904B {
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
        int[] arr = new int[n], a = new int[n];
        long pref = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            a[i] = arr[i];
        }
        Arrays.sort(a);
        long ans = n - 1;
        for(int i = 0; i < n - 1; i++)  pref += a[i];
        HashMap<Integer, Long> hmap = new HashMap<>();
        hmap.put(a[n - 1], (long) (n - 1));

        for(int i = n - 2; i >= 0; i--){
            if(a[i] != a[i + 1]){
                if(pref < a[i + 1]) ans = i;

                hmap.put(a[i], ans);
            }
            pref -= a[i];
        }

        for(int i : arr){
            System.out.print(hmap.get(i) + " ");
        }
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
