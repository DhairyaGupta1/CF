package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_1380A {
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
            int[] arr = new int[n], minBef = new int[n], minAft = new int[n], minBefIdx = new int[n], minAftIdx = new int[n];

            for(int i = 0; i < n; i++)  arr[i] = input.nextInt();
            int min = n + 1, minIdx = -1;

            for(int i = 0; i < n; i++){
                if(min > arr[i]){
                    min = arr[i];
                    minIdx = i;
                }
                minBef[i] = min;
                minBefIdx[i] = minIdx;
            }

            min = n + 1; minIdx = -1;
            for(int i = n - 1; i >= 0; i--){
                if(min > arr[i]){
                    min = arr[i];
                    minIdx = i;
                }
                minAft[i] = min;
                minAftIdx[i] = minIdx;
            }

            boolean found = false;

            for(int i = 0; i < n; i++){
                if(minBef[i] < arr[i] && minAft[i] < arr[i]){
                    found = true;

                    System.out.println("YES");
                    System.out.println((minBefIdx[i] + 1) + " " + (i + 1) + " " + (minAftIdx[i] + 1));
                    break;
                }
            }

            if(!found)  System.out.println("NO");
        }
    }

}
