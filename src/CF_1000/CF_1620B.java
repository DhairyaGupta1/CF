package CF_1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF_1620B {
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
        int w = input.nextInt(), h = input.nextInt();
        ArrayList<Integer> s1 = new ArrayList<>(), s2 = new ArrayList<>(), s3 = new ArrayList<>(), s4 = new ArrayList<>();
        inputSides(s1, input);
        inputSides(s2, input);
        inputSides(s3, input);
        inputSides(s4, input);

        long l1 = s1.getLast() - s1.getFirst(), l2 = s2.getLast() - s2.getFirst();
        long b1 = s3.getLast() - s3.getFirst(), b2 = s4.getLast() - s4.getFirst();

        long ans = Math.max(l1 * h, l2 * h), ans2 = Math.max(b1 * w, b2 * w);
        ans = Math.max(ans, ans2);
        System.out.println(ans);
    }

    private static void inputSides(ArrayList<Integer> arr, FastReader input){
        int x = input.nextInt();
        for(int i = 0; i < x; i++) arr.add(input.nextInt());
    }

    public static void main(String[] args){
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0){
            solve(input);
        }
    }
}
