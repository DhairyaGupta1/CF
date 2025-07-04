package CF_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1821B {
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
        int[] a = new int[n], a_ = new int[n];
        for(int i = 0; i < n; i++)  a[i] = input.nextInt();
        for(int i = 0; i < n; i++)  a_[i] = input.nextInt();

        int[] maxLR = new int[2], curr = new int[2];
        curr[0] = 0; curr[1] = 0; boolean hadChange = false;
        for(int i = 1; i < n; i++){
            if(a_[i] >= a_[i - 1]) {
                curr[1]++;
                if(a_[i] != a[i])   hadChange = true;
//                System.out.println(curr[0] + " " + curr[1]);
            }
            else{
                if(curr[1] - curr[0] >= maxLR[1] - maxLR[0] && hadChange){
                    maxLR[1] = curr[1];
                    maxLR[0] = curr[0];
                }
                curr[0] = i; curr[1] = i;
                hadChange = false;
            }
        }

        if(curr[1] - curr[0] >= maxLR[1] - maxLR[0] && hadChange){
            maxLR[1] = curr[1];
            maxLR[0] = curr[0];
        }
        curr[0] = n - 1; curr[1] = n - 1;
        System.out.println((maxLR[0] + 1)+ " " + (maxLR[1] + 1));
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
