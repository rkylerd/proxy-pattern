package ArrayLazyLoaderProxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class My2DArray implements IArray2D {
    private String[][] board2D;
    public My2DArray() {

    };

    public My2DArray(int rows, int cols) {
        this.board2D = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for ( int col = 0; col < cols; col++) {
                this.board2D[row][col] = "X";
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < this.board2D.length; row++) {
            for ( int col = 0; col < this.board2D[0].length; col++) {

                if (col == this.board2D[row].length -1) {
                    sb.append(this.board2D[row][col] + "\n");

                } else {
                    sb.append(this.board2D[row][col] + " ");

                }

            }
        }
        return sb.toString();
    }

    @Override
    public void setCoordinateVal(int row, int col, Object o) {
        this.board2D[row][col] = (String)o;
    }

    @Override
    public String getCoordinateVal(int row, int col) {
        return this.board2D[row][col];
    }

    public void saveToFile(String destinationFile) {

        File newFile = new File(destinationFile);

        try {
            PrintWriter writer = new PrintWriter(destinationFile);
            for (int row = 0; row < this.board2D.length; row++) {
                for ( int col = 0; col < this.board2D[0].length; col++) {

                    if (col == this.board2D[row].length -1) {
                        writer.print(this.board2D[row][col] + " \n ");
                    } else {
                        writer.print(this.board2D[row][col] + " ");
                    }

                }
            }

            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void loadFromFile(String fileName) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(fileName)).useDelimiter(" ");
        int rows = 0;
        int cols = 0;
        int mostCols = 0;
        List<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String next = scanner.next();

            list.add(next);
            if (next.equals("\n")) {
                rows++;
                if (cols > mostCols) {
                    mostCols = cols;
                }
                cols = 0;
            }
            else cols++;
        }

        this.board2D = new String[rows][mostCols];
        rows = 0;
        cols = 0;

        for (int i = 0; i < list.size(); i++) {


            if (list.get(i).equals("\n")) {
                rows++;
                cols = 0;
            } else {

                board2D[rows][cols] = list.get(i);
                cols++;
            }
        }


    }
}
