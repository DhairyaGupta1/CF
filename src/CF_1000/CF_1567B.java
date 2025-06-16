package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1567B {
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

    private static void solve(FastReader input, int[] arr){
        int mex = input.nextInt(), xor = input.nextInt();
        int currXor = arr[mex - 1], len = mex;

        if(currXor == xor)  System.out.println(len);
        else if((currXor ^ mex) == xor) System.out.println(len + 2);
        else System.out.println(len + 1);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();
        int[] arr = new int[1000000];
        for(int i = 1; i < arr.length; i++) arr[i] = i ^ arr[i - 1];
        while(t-- > 0){
            solve(input, arr);
        }
    }

}
