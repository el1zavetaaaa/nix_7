package level3.tasks;

import java.util.Random;

public class GameOfLife {
    public static void run() {

        int M = 10, N = 10;

        Random r = new Random();

        int[][] grid = new int[M][N];


        int count = 1;


        for (int row = 0; row < grid.length; row++) {
            System.out.print("\t");

            for (int column = 0; column < grid[row].length; column++) {
                grid[row][column] = 0 + r.nextInt(2);
                System.out.printf("  %d\t", grid[row][column]);

            }
            count++;
            System.out.println();
        }

        System.out.println("Original Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);
    }


    static void nextGeneration(int grid[][], int M, int N) {
        int[][] future = new int[M][N];


        for (int l = 1; l < M - 1; l++) {
            for (int m = 1; m < N - 1; m++) {

                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];


                aliveNeighbours -= grid[l][m];


                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;


                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;


                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;


                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();

        }
        System.out.println("*//1 - this symbols are used for alive cells;"
                + "\n" + ".//0 - this symbols are used for died cells.");
    }
}