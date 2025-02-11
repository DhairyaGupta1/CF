package CF_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF_1777A {
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

        int nextInt() { return parseInt(next()); }

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
            int[] arr = new int[n];

            for(int i = 0; i < n; i++)  arr[i] = input.nextInt() % 2 == 0 ? 0 : 1;
            int min = 0, cnt = 1, prev = arr[0];

            for(int i = 1; i < n; i++){
                if(arr[i] == prev)  cnt++;
                else{
                    min += cnt - 1;
                    cnt = 1;
                    prev = arr[i];
                }
            }

            if(cnt != 1)    min += cnt - 1;

            System.out.println(min);
        }
    }

}
