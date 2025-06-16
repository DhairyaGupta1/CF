package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CF_1614B {
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
        int[] arr = new int[n];
        pair[] a = new pair[n];
        for(int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
            a[i] = new pair(i, arr[i]);
        }

        Arrays.sort(a, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.val - o2.val;
            }
        });

        int cnt = 1;
        boolean flg = true;
        long total = 0;
        for(int i = n - 1; i >= 0; i--){
            a[i].x = cnt;
            total += (long) Math.abs(cnt) * a[i].val;
            if(flg){
                flg = false;
                cnt = -cnt;

            }
            else{
                flg = true;
                cnt = -cnt + 1;
            }
        }

        System.out.println(total * 2);
        Arrays.sort(a, new Comparator<pair>() {
            @Override
            public int compare(pair o1, pair o2) {
                return o1.idx - o2.idx;
            }
        });

        System.out.print(0 + " ");
        for(pair p : a){
            System.out.print(p.x + " ");
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

class pair{
    int idx;
    int val;
    int x;

    public pair(int idx, int val){
        this.idx = idx;
        this.val = val;
    }
}
