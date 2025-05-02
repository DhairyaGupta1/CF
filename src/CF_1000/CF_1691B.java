package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class CF_1691B {
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
        int n = input.nextInt();
        HashMap<Long, Long> hmap = new HashMap<>();
        List<Long> el = new ArrayList<>();
        for(int i = 0; i < n; i++){
            long l = input.nextLong();
            if(hmap.containsKey(l)) hmap.put(l, hmap.get(l) + 1);
            else{
                hmap.put(l, 1l);
                el.add(l);
            }
        }
        for(long l : hmap.keySet()){
            if(hmap.get(l) == 1){
                System.out.println(-1);
                return;
            }
        }
        long idx = 0;

        for(long l : el){
            long freq = hmap.get(l);
            System.out.print((freq + idx) + " ");
            for(long i = idx + 1; i < idx + freq; i++) System.out.print(i + " ");
            idx = idx + freq;
        }
        System.out.println();
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }

}
