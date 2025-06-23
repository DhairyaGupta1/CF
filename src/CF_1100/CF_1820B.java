package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1820B {
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
        String s = input.nextLine();
        int n = s.length();
        if(n == 1) {
            System.out.println(s);
            return;
        }
        boolean b = true;
        for(int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                b = false;
                break;
            }
        }
        long x = maxCons1s(n, s + s);
        if(b && s.charAt(0) == '1'){
            System.out.println((long)n * n);
            return;
        }
        long max = x;
        for(long i = 1; i <= x; i++){
            max = Math.max(max, (long)i * (x - i + 1));
        }

        System.out.println(max);
    }

    private static long maxCons1s(int n, String s){
        int max = 0, cnt = 0;

        for(int i = 0; i < n * 2; i++){
            if(s.charAt(i) == '1') {
                cnt++;
                max = Math.max(cnt, max);
            }
            else    cnt = 0;
        }

        if(max > n || cnt > n)  return n;
        return Math.max(max, cnt);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
