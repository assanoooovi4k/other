package by.bntu.fitr.povt.assanoooovi4k.model;

import java.util.Random;


public class Massif {

    int count;
    private int[] array;
    private int[] keyIndexTable;
    private int[] positionIndexTable;

    public Massif(int size) {
        Random random = new Random();
        array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(200) - 100;
        }

    }

    public Massif(int... ints) {
        array = ints;
    }


    public int getCount() {
        return count;
    }
    public int[] getArray() {
        return array;
    }
    
    public int getSize() {
        return array.length;
    }

    public int selectionSort() {
        count = 0;

        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1]) {
                   int temp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = temp;
                   count++;
                }
            }
        }

        return count;
    }

    public boolean linearSearch(int value) {
        count = 0;

        for (int i : array) {
            count++;
            if (i == value) {
                return true;
            }
        }

        return false;
    }

    public int linearMaxElSearch() {
        count = 0;

        int value = array[0];

        for (int i : array) {
            count++;
            if (i > value) {
                value = i;
            }
        }

        return value;
    }

    public int binarySearch(int value) {
        count = 0;
        return binarySearch(value, array, 0, array.length-1);
    }

    private int binarySearch(int val, int[] array, int low, int high) {
        count++;
        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        count++;
        if (val < array[mid]) {
            return binarySearch(val, array, low, mid - 1);
        } else if (val > array[mid]) {
            return binarySearch(val, array, mid + 1, high);
        } else {
            return mid;
        }
    }

    public int indexedSequentialSearch(int value) {
        count = 0;

        selectionSort();
        initIndexTable();

        int index = -1;
        int start = positionIndexTable.length - 1, end = array.length;

        count++;
        if (value < keyIndexTable[0]) {
            return index;
        }
        else {
            for (int i = 1; i < keyIndexTable.length; i++) {
                count++;
                if (value < keyIndexTable[i]) {
                    start = positionIndexTable[i - 1];
                    end = positionIndexTable[i];
                    break;
                }
            }
        }

        for (int i = start; i < end; i++) {
            count++;
            if(value == array[i]) {
                return i;
            }
        }

        return index;
    }

    private void initIndexTable() {
        this.keyIndexTable = new int[(array.length / 5)];
        this.positionIndexTable = new int[(array.length / 5)];

        int i, j;

        for (i = 0, j = 0; i < array.length; i += 5, j++) {
            keyIndexTable[j] = array[i];
            positionIndexTable[j] = i;
        }
    }

    public String printIndexTables() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Массив значений индексной таблицы:\n");
        for (int i : keyIndexTable  ) {
            stringBuilder.append(i).append("\t\t");
        }

        stringBuilder.append("\nМассив индексов индексной таблицы:\n");
        for (int i : positionIndexTable  ) {
            stringBuilder.append(i).append("\t\t");
        }

        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i : array) {
            stringBuilder.append(i).append("\t\t");
        }

        return stringBuilder.toString();
    }

}
