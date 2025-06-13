package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1155A {
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
        int len = input.nextInt();
        char[] arr = input.nextLine().toCharArray();

        if(isSorted(arr)){
            System.out.println("NO");
        }
    }

    private static boolean isSorted(char[] arr){
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < arr[i - 1]) {
                System.out.println("YES");
                System.out.println((i) + " " + (i + 1));
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = 1;

        while(t-- > 0){
            solve(input);
        }
    }

}
