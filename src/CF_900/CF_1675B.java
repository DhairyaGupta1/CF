package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1675B {
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

            int[] a = new int[n];
            for(int i = 0; i < n; i++)  a[i] = input.nextInt();

            boolean isPossible = true;
            int minOps = 0;
            for(int i = n - 2; i >= 0; i--){

                while(a[i] != 0 && a[i] >= a[i + 1]){
                    a[i] /= 2;
                    minOps++;
                }

                if(a[i] == 0 && i != 0) {
                    isPossible = false;
                    break;
                }
            }

            if(a[n - 1] == 0 && n != 1) System.out.println(-1);
            else System.out.println(isPossible ? minOps : -1);
        }
    }

}
