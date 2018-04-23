package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.DoubleLinkedList;
import by.bntu.fitr.povt.assanoooovi4k.model.Logic;
import by.bntu.fitr.povt.assanoooovi4k.view.Printer;


public class Main {

    public static void main(String[] args) {
        DoubleLinkedList<Integer> ints = new DoubleLinkedList<>();
        DoubleLinkedList<Integer> newInts = new DoubleLinkedList<>();

        ints.addLast(200);
        ints.addLast(332);
        ints.addLast(4);
        ints.addLast(124);
        ints.addLast(-100);
        ints.addLast(0);

        Printer.print("Список: " + ints.toString());

        while(!ints.isEmpty()) {
            int index = Logic.indexMinEl(ints);
            newInts.addFirst(ints.remove(index));
        }

        Printer.print("Новый список: " + newInts.toString());
    }
}
