package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.module.BinaryTree;
import by.bntu.fitr.povt.assanoooovi4k.view.Printer;

public class Main {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert("c");
        tree.insert("a");
        tree.insert("b");
        tree.insert("d");

        Printer.print(tree);
        Printer.print("Количество листьев " + tree.countList());
    }
}
