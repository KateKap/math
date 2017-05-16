

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
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

    Queue queue = new Queue(100);
    //обход в ширину
    void bfs(int v, int f)
    {
        vertexList[v].isVisited = true;
        queue.insert(v);
        int vertex;

        //выведем вершину, с которой начинается обход, на экран
        System.out.println(vertexList[v].getLabel());
        //for (int i=v; i<=f; i++){
        while (queue.getRear()==f)//пока очередь не опустеет
        {
            int current = queue.pop();
            while ((vertex = getSuccessor(current)) != -1) {
                vertexList[vertex].isVisited = true;
                queue.insert(vertex);
                //вывод вершины на экран
                System.out.println(vertexList[vertex].getLabel());
            }

        }
    //}

        //сброс флагов
        for(int j = 0; j < vertexCount; j++)
            vertexList[j].isVisited = false;
    }

    //метод возвращает непосещенную вершину, смежную по отношению к v
    int getSuccessor (int v)
    {
        for(int j = 0; j < vertexCount; j++)
            if(matrix[v][j] == 1 && vertexList[j].isVisited == false)
                return j; //возвращает первую найденную вершину
        return -1; //таких вершин нет
    }

}