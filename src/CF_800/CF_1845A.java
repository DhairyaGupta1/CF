package CF_800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF_1845A {
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
        while(t-- > 0) {
            int n = input.nextInt(), k = input.nextInt(), x = input.nextInt();

            if((k == 1 || n == 1) && x == 1)    System.out.println("NO");
            else if(x == 1 && k == 2 && n % 2 == 1) System.out.println("NO");
            else{
                System.out.println("YES");
                if(x != 1){
                    System.out.println(n);
                    for(int i = 0; i < n; i++) System.out.print(1 + " ");
                    System.out.println();
                }
                else{
                    if(n % 2 == 0){
                        System.out.println(n/2);
                        for(int i = 0; i < n/2; i++)    System.out.print(2 + " ");
                        System.out.println();
                    }
                    else{
                        n -= 3;
                        System.out.println(1 + n/2);
                        System.out.print(3 + " ");
                        for(int i = 0; i < n/2; i++)    System.out.print(2 + " ");
                        System.out.println();
                    }
                }
            }
        }
    }

}
