package CF_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF_1862B {
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

            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(arr[0]);

            int prev = arr[0];
            int i = 1;
            while(i < n){
                if(arr[i] >= prev){
                    ans.add(arr[i]);
                    prev = arr[i];
                    i++;
                }
                else{
                    prev = 1;
                    ans.add(prev);
                }
            }

            System.out.println(ans.size());
            for(int j : ans)    System.out.print(j + " ");
            System.out.println();
        }
    }

}
