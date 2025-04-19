package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CF_1859B {
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
            int[] min = new int[n];
            Arrays.fill(min, Integer.MAX_VALUE);
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>(n);

            long smallest = Integer.MAX_VALUE;

            for(int i = 0; i < n; i++){
                int len = input.nextInt();

                ArrayList<Integer> a = new ArrayList<>(len);
                Smallest2 s = new Smallest2();
                for(int j = 0; j < len; j++){
                    a.add(input.nextInt());
                    smallest = Math.min(a.get(j), smallest);
                    s.comp(a.get(j));
                }
                min[i] = s.sleast;
                arr.add(a);
            }

            Arrays.sort(min);
            for(int i = 1; i < n; i++)  smallest += min[i];

            System.out.println(smallest);
        }
    }

    static class Smallest2{
        int least;
        int sleast;

        public Smallest2(){
            least = Integer.MAX_VALUE;
            sleast = Integer.MAX_VALUE;
        }

        public void comp(int n){
            if(least > n){
                sleast = least;
                least = n;
            }
            else if(least == n){
                sleast = n;
            }
            else if(sleast > n){
                sleast = n;
            }
        }
    }
}
