package by.bntu.fitr.povt.assanoooovi4k.model;

public class Logic {
    public static int indexMinEl(DoubleLinkedList<Integer> doubleLinkedList) {
        int size = doubleLinkedList.size();
        int index = 0;
        Integer[] integers = doubleLinkedList.toArray();
        Integer integer = integers[0];

        for (int i = 0; i <size ; i++) {
            if(integer<integers[i]) {
                index = i;
            }
        }

        return index;
    }
}
