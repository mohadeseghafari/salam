import java.util.*;
import java.io.*;
public class class3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = scanner.nextInt();
        int i;
        int vertex1;
        int vertex2;
        int graphPointer = 1;
        int counter = 1;
        int time = 0;
        LinkedList<Integer> adj[];
        int[] vertices = new int[12];
        vertices[1] = 1;
        adj = new LinkedList[n];
        for (i = 1; i < 12; i++) {
            adj[i] = new LinkedList();
        }
        for (i = 0; i < n; i++) {
            vertex1 = scanner.nextInt();
            vertex2 = scanner.nextInt();
            adj[vertex1].add(vertex2);
            adj[vertex2].add(vertex1);
        }
        boolean visited[] = new boolean[12];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        visited[graphPointer] = true;
        queue.add(graphPointer);
        while (queue.size() != 0) {
            graphPointer = queue.poll();
            vertices[counter] = graphPointer;
            counter++;
            Iterator<Integer> iterator = adj[graphPointer].listIterator();
            while (iterator.hasNext()) {
                int nextIterator = iterator.next();
                if (!visited[nextIterator]) {
                    visited[nextIterator] = true;
                    queue.add(nextIterator);
                }
            }
        }
        int[] tabaghe = new int[12];
        tabaghe[1] = 0;
        for (i = 2; i < 12; i++) {
            tabaghe[i] = 100;
        }
        int x;
        for (i = 2; i < 12; i++) {
            x = 100;
            Iterator<Integer> iterate = adj[vertices[i]].listIterator();
            while (iterate.hasNext()) {
                int nextIterate = iterate.next();
                if (tabaghe[nextIterate] < x) {
                    x = tabaghe[nextIterate];
                }
            }
            tabaghe[vertices[i]] = x + 1;
        }
        System.out.println(90 / (tabaghe[11] * t));
    }

}