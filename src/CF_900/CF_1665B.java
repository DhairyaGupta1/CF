package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_1665B {
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

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            int n = input.nextInt(), maxFreq = 0;
            HashMap<Integer, Integer> freq = new HashMap<>();

            for(int i = 0; i < n; i++){
                int el = input.nextInt();
                freq.put(el, freq.getOrDefault(el, 0) + 1);
                maxFreq = Math.max(maxFreq, freq.get(el));
            }

            if(n == maxFreq)    System.out.println(0);
            else{
                double log = n * 1.0 / maxFreq;
                int exp = (int)Math.ceil(Math.log(log) / Math.log(2));
                int swaps = n - maxFreq;
//                System.out.println(swaps + exp + " swaps: " + swaps + " doubled: " + exp);
                System.out.println(swaps + exp);
            }
        }
    }

}
