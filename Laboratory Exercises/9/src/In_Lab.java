import java.util.*;
import java.util.Map.Entry;

public class In_Lab {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        AdjacencyListGraph<Integer>routers = new AdjacencyListGraph<>();

        for(int i = 0; i < m; i++){
            int router = input.nextInt();
            int connection = input.nextInt();
            routers.addEdge(router, connection);
        }
        int brokenRouter = input.nextInt();
        routers.removeVertex(brokenRouter);

        System.out.println(routers.countRoutersGroup());
    }
}