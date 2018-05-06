package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.Inputer;
import by.bntu.fitr.povt.assanoooovi4k.model.Massif;
import by.bntu.fitr.povt.assanoooovi4k.view.Printer;


public class Main {

    public static void main(String[] args) {
        int lines = Inputer.checkInput("Введите количество строк: ");
        int columns = Inputer.checkInput("Введите количество столбцов: ");

        int[][] massif = Massif.createMassif(lines, columns);
        Printer.print(Massif.printMassif(massif, lines, columns));
}
}
