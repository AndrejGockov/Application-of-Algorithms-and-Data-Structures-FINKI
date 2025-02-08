//        Дадени се луѓе, дел од кои меѓусебно се познаваат. Треба да се организираат дочеци на Нова Година, така што секој човек во едно друштво што слави заедно се познава со барем еден друг човек од тоа друшвто, а не се познава со никој надвор од тоа друштво. Да се одреди колку дочеци на Нова Година ќе организираат дадените луѓе.
//
//        Влез: Во првиот ред е даден бројот на луѓе N. Потоа во следните N редови се дадени имињата на луѓето. Во следниот ред е даден бројот на познанства M, а во следните M редови се дадени луѓето кои се познаваат.
//        Излез:  Бројот на дочеци на Нова Година.
//
//        Пример:
//        Влез:
//        6
//        Alice
//        Bob
//        Charlie
//        Diana
//        Eve
//        Frank
//        3
//        Alice Bob
//        Charlie Diana
//        Eve Frank
//
//        Излез:
//        3
//        (Објаснување: Alice и Bob претставуваат една група, Charlie и Diana се втора група, а Eve и Frank во трета)
//
//        /
//
//        You're given a group of people, some of whom know each other. The task is to organize New Year's Eve gatherings such that every person in a group celebrating together knows at least one other person in that group, and no one in the group knows anyone outside of it. Determine how many New Year's Eve gatherings will be organized by the given people.
//
//        Input: The first line contains the number of people N. The next N lines contain the names of the people. The next line contains the number of connections M, followed by M lines that specify the pairs of people who know each other.
//        Output: The number of cities the given objects are grouped into.
//
//        Example:
//        Input:
//        6
//        Alice
//        Bob
//        Charlie
//        Diana
//        Eve
//        Frank
//        3
//        Alice Bob
//        Charlie Diana
//        Eve Frank
//
//        Output:
//        3
//        (Explanation: Alice and Bob are one group, Charlie and Diana a second group, and Eve and Frank a third group)

import java.util.*;
import java.util.Map.Entry;

class AdjacencyListGraph<T> {
    private Map<T, Set<T>> adjacencyList;

    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(T vertex) {
        if (!adjacencyList.containsKey(vertex)) {
            adjacencyList.put(vertex, new HashSet<>());
        }
    }

    // Remove a vertex from the graph
    public void removeVertex(T vertex) {
        // Remove the vertex from all adjacency lists
        for (Set<T> neighbors : adjacencyList.values()) {
            neighbors.remove(vertex);
        }
        // Remove the vertex's own entry in the adjacency list
        adjacencyList.remove(vertex);
    }

    // Add an edge to the graph
    public void addEdge(T source, T destination) {
        addVertex(source);
        addVertex(destination);

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // for undirected graph
    }

    // Remove an edge from the graph
    public void removeEdge(T source, T destination) {
        if (adjacencyList.containsKey(source)) {
            adjacencyList.get(source).remove(destination);
        }
        if (adjacencyList.containsKey(destination)) {
            adjacencyList.get(destination).remove(source); // for undirected graph
        }
    }

    // Get all neighbors of a vertex
    public Set<T> getNeighbors(T vertex) {
        return adjacencyList.getOrDefault(vertex, new HashSet<>());
    }

    public void DFS(T startVertex) {
        Set<T> visited = new HashSet<>();
        DFSUtil(startVertex, visited);
    }

    private void DFSUtil(T vertex, Set<T> visited) {
        // Mark the current node as visited and print it
        visited.add(vertex);
        System.out.print(vertex + " ");

        // Recur for all the vertices adjacent to this vertex
        for (T neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                DFSUtil(neighbor, visited);
            }
        }
    }


    public void DFSNonRecursive(T startVertex, Set<T>visited) {
        Stack<T> stack = new Stack<>();

        stack.push(startVertex);
        while (!stack.isEmpty()) {
            T vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                System.out.print(vertex + " ");
                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    public void BFS(T startVertex, Set<T> visited) {
//        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            T vertex = queue.poll();
//            System.out.print(vertex + " ");

            for (T neighbor : getNeighbors(vertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public int shortestPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();

        visited.add(startVertex);
        queue.add(startVertex);
        int elementsAtLevel;
        int level = 0;

        while (!queue.isEmpty()) {
            elementsAtLevel = queue.size();
            while (elementsAtLevel > 0) {
                T vertex = queue.poll();
                if (vertex.equals(endVertex))
                    return level;

                for (T neighbor : getNeighbors(vertex)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
                elementsAtLevel--;
            }
            level++;
        }
        return -1;
    }

    public void pathsOfLengthN(T startVertex, int goalLength) {
        Set<T> visited = new HashSet<>();
        ArrayList<T> startPath = new ArrayList<>();
        startPath.add(startVertex);
        pathsOfLengthNUtil(startVertex, goalLength, visited, startPath);
    }

    private void pathsOfLengthNUtil(T vertex, int goalLength, Set<T> visited, List<T> currentPath) {
        if (currentPath.size()==goalLength+1) {
            System.out.println(currentPath);
            return;
        }
        visited.add(vertex);
        for (T neighbor : getNeighbors(vertex)) {
            if (!visited.contains(neighbor)) {
                currentPath.add(neighbor);
                pathsOfLengthNUtil(neighbor, goalLength, visited, currentPath);
                currentPath.remove(neighbor);
            }
        }
        visited.remove(vertex);
    }


    public void findPath(T startVertex, T endVertex) {
        Set<T> visited = new HashSet<>();
        Stack<T> invertedPath = new Stack<>();
        visited.add(startVertex);
        invertedPath.push(startVertex);

        while(!invertedPath.isEmpty() && !invertedPath.peek().equals(endVertex)) {
            T currentVertex = invertedPath.peek();
            T tmp = currentVertex;

            for(T vertex : getNeighbors(currentVertex)) {
                tmp = vertex;
                if(!visited.contains(vertex)) {
                    break;
                }
            }

            if(!visited.contains(tmp)) {
                visited.add(tmp);
                invertedPath.push(tmp);
            }
            else {
                invertedPath.pop();
            }
        }

        Stack<T> path = new Stack<>();
        while(!invertedPath.isEmpty()) {
            path.push(invertedPath.pop());
        }
        while(!path.isEmpty()) {
            System.out.println(path.pop());
        }
    }

    @Override
    public String toString() {
        String ret = new String();
        for (Entry<T, Set<T>> vertex : adjacencyList.entrySet())
            ret += vertex.getKey() + ": " + vertex.getValue() + "\n";
        return ret;
    }

    public int countGroups(){
        int groups = 0;
        Set<T>visited = new HashSet<>();

        for(T obj : adjacencyList.keySet()){
            if(!visited.contains(obj)){
                groups++;
                BFS(obj, visited);
            }
        }

        return groups;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        AdjacencyListGraph<String>objects = new AdjacencyListGraph<>();

        for(int i = 0; i < n; i++){
            String obj = input.next();
            objects.addVertex(obj);
        }

        int m = input.nextInt();

        for(int i = 0; i < m; i++){
            String obj = input.next();
            String connection = input.next();
            objects.addEdge(obj, connection);
        }

        System.out.println(objects.countGroups());
    }
}