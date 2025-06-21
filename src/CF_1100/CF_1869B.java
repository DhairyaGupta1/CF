package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1869B {
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
        int n = input.nextInt(), k = input.nextInt(), a = input.nextInt() - 1, b = input.nextInt() - 1;
        long[][] coords = new long[n][2];
        for(int i = 0; i < n; i++){
            coords[i][0] = input.nextLong(); coords[i][1] = input.nextLong();
        }

        if(a + 1 <= k && b + 1 <= k){
            System.out.println(0);  return;
        }

        long minDist = abs(coords[a][0] - coords[b][0]) + abs(coords[a][1] - coords[b][1]);

        if(k != 0)  minDist = Math.min(minDist, minFromCity(a, coords, k) + minFromCity(b, coords, k));

        System.out.println(minDist);
    }

    private static long minFromCity(int a, long[][] coords, int k){
        long minDist = Long.MAX_VALUE;
        for(int i = 0; i < k; i++){
            long temp = abs(coords[a][0] - coords[i][0]) + abs(coords[a][1] - coords[i][1]);
            if(temp < minDist)  minDist = temp;
        }

        return minDist;
    }

    private static long abs(long a){
        if(a < 0)   return -a;
        return a;
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
