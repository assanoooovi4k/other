package by.bntu.fitr.povt.assanoooovi4k.model;

import java.util.Arrays;

public class Array implements Runnable{
    private int[] array;

    public Array(int... array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        sort();
        System.out.println(Arrays.toString(array));
    }

    public void sort() {
        Arrays.sort(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
