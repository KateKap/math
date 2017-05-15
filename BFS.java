
/**
 * Created by Kate on 16.05.2017.
 */


public class BFS {
    private String label;
    private boolean isVisited;
    public BFS (String label){
        this.label = label;
        isVisited = false;
    }

    private final int VERTEX_MAX = 100;
    private BFS[] vertexList; //асив для збереження вершин
    private int vertexCount;
    private  int [][] matrix;

    public void graph(){
        matrix = new int[VERTEX_MAX][VERTEX_MAX];
        for (int i=0; i<VERTEX_MAX; i++)
            for (int j=0; j<VERTEX_MAX; j++)
                matrix[i][j]=0;
        vertexCount = 0;
        vertexList = new BFS[VERTEX_MAX];
    }

    public void addVertex (String label){
        vertexList[vertexCount++] = new BFS(label);
    }

    public void addEdge (int begin, int end){
        matrix[begin][end] = 1;
        matrix[end][begin] = 0;
    }

    //JQueue queue = new JQueue(100);
}