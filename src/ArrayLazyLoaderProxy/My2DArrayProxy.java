package ArrayLazyLoaderProxy;

import java.io.FileNotFoundException;

public class My2DArrayProxy implements IArray2D {
    private My2DArray my2DArray = null;
    private String fileName;

    public My2DArrayProxy(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setCoordinateVal(int row, int col, Object o) {
        if (this.my2DArray == null) {
            loadArray();
        }

        my2DArray.setCoordinateVal(row, col, o);
    }

    @Override
    public Object getCoordinateVal(int row, int col) {
        if (this.my2DArray == null) {
            loadArray();
        }

        return my2DArray.getCoordinateVal(row, col);
    }

    private void loadArray() {
        this.my2DArray = new My2DArray();
        try {
            this.my2DArray.loadFromFile(this.fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String toString() {
        if (this.my2DArray == null) {
            loadArray();
        }
        return my2DArray.toString();
    }
}
