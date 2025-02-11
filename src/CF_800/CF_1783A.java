package CF_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF_1783A {
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
            for(int i = 0; i < n; i++)  arr[i] = input.nextInt();
            Arrays.sort(arr);
            int si = 0, ei = n -1;
            while(si <= ei){
                int temp = arr[si];
                arr[si++] = arr[ei];
                arr[ei--] = temp;
            }

            if(arr[0] == arr[n-1])  System.out.println("NO");
            else{
                int temp = arr[1];
                arr[1] = arr[n - 1];
                arr[n - 1] = temp;

                System.out.println("YES");
                for(int i : arr)    System.out.print(i + " ");
                System.out.println();
            }
        }
    }

}
