package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1791D {
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
            int n = input.nextInt();
            String line = input.nextLine();

            int[] freq = new int[26], diffChar = new int[n], rdiffChar = new int[n];

            for(int i = 0; i < n; i++){
                char c = line.charAt(i);
                if(freq[c - 'a'] == 0)  diffChar[i] = ((i != 0) ? diffChar[i - 1] + 1 : 1);
                else    diffChar[i] = diffChar[i - 1];
                freq[c - 'a']++;
            }
            freq = new int[26];
            for(int i = n - 1; i >= 0; i--){
                char c = line.charAt(i);

                if(freq[c-'a'] == 0)    rdiffChar[i] = ((i != n - 1) ? rdiffChar[i + 1] + 1 : 1);
                else rdiffChar[i] = rdiffChar[i + 1];
                freq[c - 'a']++;
            }

            long max = 0;

            for(int i = 0; i < n - 1; i++){
                max = Math.max(max, diffChar[i] + rdiffChar[i + 1]);
            }

            System.out.println(max);
        }
    }
}
