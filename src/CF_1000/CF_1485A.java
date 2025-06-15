package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1485A {
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
        long a = input.nextLong(), b = input.nextLong();
        boolean base1 = (b == 1);
        if(b == 1)  b++;
        long min = log(a, b) + 1;

        for(int i = 1; i < min; i++){
            min = Math.min((log(a, b + i) + i + 1), min);
        }
//        System.out.println("9 base 2: " + log(9, 2));
        System.out.println(min + (base1 ? 1 : 0));
    }

    private static long log(long a, long b){
        long cnt = 1, x = b;
        while(x <= a){
            x = x * b;
            cnt++;
        }
        return cnt - 1;
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
