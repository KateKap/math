public class Main {

    public static void main(String[] args) {
        //DistanceMatrix distanceMatrix = new DistanceMatrix();
        //distanceMatrix.findDistanceMatrix();

        BFS method = new BFS("test");
        method.graph();
        method.addVertex("Che");//0
        method.addVertex("Kyiv");//1
        method.addVertex("Lviv");//2
        method.addVertex("Che2");//3
        method.addVertex("Kyiv2");//4
        method.addVertex("Lviv2");//5
        method.addEdge(0, 1);
        method.addEdge(1, 2);
        method.addEdge(2, 3);
        method.addEdge(0, 3);
        method.addEdge(3, 4);

        method.bfs(0, 3);

    }
}
