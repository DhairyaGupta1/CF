import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

public class CF_1873C {

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

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int t = input.nextInt();

        while(t-- > 0) {
            int points = 0;
            for(int i = 0; i < 10; i++){
                String line = input.next();
                for(int j = 0; j < 10; j++){
                    if(line.charAt(j) == 'X')   points += findPoints(i, j);
                }
            }
            System.out.println(points);
        }
    }

    static int findPoints(int i, int j){
        if(i == 0 || j == 0 || i == 9 || j == 9)    return 1;
        if(i == 1 || j == 1 || i == 8 || j == 8)    return 2;
        if(i == 2 || j == 2 || i == 7 || j == 7)    return 3;
        if(i == 3 || j == 3 || i == 6 || j == 6)    return 4;
        if(i == 4 || j == 4 || i == 5 || j == 5)    return 5;

        return -1;
    }
}