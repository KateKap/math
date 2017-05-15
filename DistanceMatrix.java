import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Kate on 14.05.2017.
 */
public class DistanceMatrix {
    private static final int INF = 1000*1000*1000;

    public void findDistanceMatrix (){
        Scanner scanner = new Scanner(System.in);
        PrintWriter printWriter = new PrintWriter(System.out);

        int verticeCount = 4;
        int[][] arr = {
                {0, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 0}
        };
        /*Scanner in = new Scanner(System.in);
        System.out.print("Введите количество строк массива: ");
        verticeCount = in.nextInt();

        System.out.print("Введите количество столбцов массива: ");
        verticeCount = in.nextInt();


        int[][] arr = new int[verticeCount][verticeCount];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Введите элемент arr[" + i + "][" + j + "]:");
                arr[i][j] = in.nextInt();
            }
        }
        in.close();*/

        int[][] adjacencyMatrix = new int[verticeCount][verticeCount];

        for (int i=0; i<verticeCount; i++){
            for (int j=0; j<verticeCount; j++){
                adjacencyMatrix[i][j] = arr[i][j];

                if (adjacencyMatrix[i][j] == 0){
                    adjacencyMatrix[i][j] = INF;
                }
                printWriter.println(adjacencyMatrix[i][j]+" ");
            }
        }

        for (int k = 0; k < verticeCount; k++) {
            for (int i = 0; i < verticeCount; i++) {
                for (int j = 0; j < verticeCount; j++) {
                        adjacencyMatrix[i][j] = /*Math.min(adjacencyMatrix[i][j], */adjacencyMatrix[i][k] + adjacencyMatrix[k][j];//);
                    printWriter.print(adjacencyMatrix[i][j]);
                }
            }

        }



        // Для каждой пары вершин выведем величину
        // кратчайшего пути от i до j, или 0,
        // если j не достижима из i
        for (int i = 0; i < verticeCount; i++) {
            for (int j = 0; j < verticeCount; j++) {
                if (adjacencyMatrix[i][j] == INF) {
                    printWriter.print(0 + " ");
                } else {
                    printWriter.print(adjacencyMatrix[i][j] + " ");
                }
            }

            printWriter.println();
        }
        scanner.close();
        printWriter.close();
    }
}
