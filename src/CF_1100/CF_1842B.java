package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1842B {
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
        int n = input.nextInt(), x = input.nextInt(), or = 0;
        int[] rating1 = new int[n], rating2 = new int[n], rating3 = new int[n];
        for(int i = 0; i < n; i++)  rating1[i] = input.nextInt();
        for(int i = 0; i < n; i++)  rating2[i] = input.nextInt();
        for(int i = 0; i < n; i++)  rating3[i] = input.nextInt();

        for(int rating : rating1){
            if(ok(rating, x))   or = (or | rating);
            else    break;
        }

        for(int rating : rating2){
            if(ok(rating, x))   or = (or | rating);
            else    break;
        }

        for(int rating : rating3){
            if(ok(rating, x))   or = (or | rating);
            else    break;
        }

        System.out.println(x == or ? "Yes" : "No");
    }

    private static boolean ok(int i, int j){
        if(i > j)   return false;
        return ((i & j) == i);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
