package CF_900;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CF_1904A {
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
            int a = input.nextInt(), b = input.nextInt();
            int kx = input.nextInt(), ky = input.nextInt();
            int qx = input.nextInt(), qy = input.nextInt();


            int[][] kingList = new int[8][2], queenList = new int[8][2];
            addPossiblePos(kingList, kx, ky, a, b);
            addPossiblePos(queenList, qx, qy, a, b);

            int cnt = 0;
            boolean[] visited = new boolean[8];
            for(int i = 0; i < 8; i++){
                for(int j = 0; j < 8; j++){
                    if(!visited[j]){
                        if(kingList[i][0] == queenList[j][0] && kingList[i][1] == queenList[j][1]) {
                            cnt++;
                            visited[j] = true;
                        }
                    }
                }
            }

            System.out.println(a == b ? cnt/2 : cnt);
        }
    }

    public static void addPossiblePos(int[][] arr, int a, int b, int x, int y){
        arr[0] = new int[]{a + x, b + y};
        arr[1] = new int[]{a + x, b - y};

        arr[2] = new int[]{a - x, b + y};
        arr[3] = new int[]{a - x, b - y};

        arr[4] = new int[]{a + y, b + x};
        arr[5] = new int[]{a + y, b - x};

        arr[6] = new int[]{a - y, b + x};
        arr[7] = new int[]{a - y, b - x};
    }
}
