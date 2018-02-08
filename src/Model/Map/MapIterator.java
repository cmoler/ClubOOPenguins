package Model.Map;

public class MapIterator<T> implements Iter{

    private T[][] map = null;
    private int i = 0;
    private int j = 0;
    private int numRows = 0;
    private int numCols = 0;

    public MapIterator(T[][] map){
        this.map = map;
        numRows = map.length;
        numCols = map[0].length;
    }

    @Override
    public Object currentItem() {
        return map[i][j];
    }

    @Override
    public boolean isValid() {
        if (i >= numRows || j >= numCols) {
            return false;
        }
        return true;
    }

    @Override
    public void next() {
        if (j == numCols-1)
        {
            i++;
            j = 0;
        }
        else
        {
            j++;
        }
    }

    @Override
    public void reset() {
        i = 0;
        j = 0;
    }
}



