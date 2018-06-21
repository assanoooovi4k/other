package by.bntu.fitr.povt.assanoooovi4k.model.concurrent;


import java.util.concurrent.Callable;

public class ConcurrentArray implements Callable<Integer[]> {
    private Integer[] array;

    public ConcurrentArray() {

    }

    public ConcurrentArray(Integer... array) {
        this.array = array;
    }

    public Integer[] getArray() {
        return array;
    }

    public void setArray(Integer[] array) {
        this.array = array;
    }

    private void sort() {
        if (array == null) {
            return;
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                }
            }
        }
    }

    @Override
    public Integer[] call() throws Exception {
        sort();
        return array;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
