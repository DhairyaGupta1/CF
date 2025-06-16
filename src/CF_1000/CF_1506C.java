package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1506C {
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
        String a = input.nextLine(), b = input.nextLine();

        System.out.println(minDist(a, b));
    }

    private static long minDist(String a, String b){
        if(a.equals(b)) return 0;
        int m = lcs(a, b);
        return a.length() - m + b.length() - m;
    }

    private static int lcs(String a, String b){
        int m = a.length(), n = b.length();
        String max = "";
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j <= m; j++){
                String sub = a.substring(i, j);
                if(b.contains(sub) && sub.length() > max.length())  max = sub;
            }
        }

        return max.length();
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
