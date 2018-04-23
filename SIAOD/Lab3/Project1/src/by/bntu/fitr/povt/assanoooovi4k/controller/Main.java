package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.DoubleLinkedList;
import by.bntu.fitr.povt.assanoooovi4k.model.Logic;


public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> ints = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> kek = new DoubleLinkedList<>();
        ints.addBack(200);
        ints.addBack(332);
        ints.addBack(4);
        ints.addBack(124);
        System.out.println(ints.toString());
        while(!ints.isEmpty()) {
            int index = Logic.indexMinEl(ints);
            kek.addBack(ints.deleteElement(index));
        }

        System.out.println(kek.toString());
    }
}
