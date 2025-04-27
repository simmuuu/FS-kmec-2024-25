import java.util.*;

public class friendsDSU {
    static int[] parent;
    static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] friends = new int[l][3];
        for (int i = 0; i < l; i++) {
            friends[i][0] = sc.nextInt();
            friends[i][1] = sc.nextInt();
            friends[i][2] = sc.nextInt();

        }
        Arrays.sort(friends, (a, b) -> Integer.compare(a[0], b[0]));
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;

        }
        for (int[] friend : friends) {
            if (union(friend[1], friend[2]) && count == 1) {
                System.out.println(friend[0]);
                return;
            }
        }
        System.out.println(-1);
    }

    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public static boolean union(int a, int b) {
        int p1 = find(a);
        int p2 = find(b);
        if (p1 == p2)
            return false;
        parent[p2] = p1;
        count--;
        return true;
    }
}
