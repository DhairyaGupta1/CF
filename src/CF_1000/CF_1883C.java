package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1883C {
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
        int n = input.nextInt(), k = input.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)  arr[i] = input.nextInt();
        int min = k;

        if(min == 4){
            int num2 = 0, num3 = 0, num4 = 0;
            for(int i : arr){
                if(i % 4 == 2)  num2++;
                if(i % 4 == 3)  num3++;
                if(i % 4 == 0)  num4++;
            }

            if(num4 > 0 || num2 >= 2)   min = 0;
            else if(num2 >= 1 || num3 >= 1)  min = 1;
            else min = 2;
        }
        else{
            for(int i : arr){
                if(i % k == 0){
                    System.out.println(0);
                    return;
                }
                min = Math.min(k - (i % k), min);
            }
        }


        System.out.println(min);
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
