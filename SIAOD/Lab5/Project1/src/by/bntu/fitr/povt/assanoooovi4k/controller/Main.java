package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.Inputer;
import by.bntu.fitr.povt.assanoooovi4k.model.Massif;
import by.bntu.fitr.povt.assanoooovi4k.view.Printer;


public class Main {

    public static void main(String[] args) {
        int size = Inputer.checkInput("Введите размерность массива: ");

        Massif massif = new Massif(size);
        Printer.print("Массив: \n" + massif);

        Printer.print("\nСортировка, количество операций перестановки: " + massif.selectionSort() + "\n");
        Printer.print("Отсортированный массив: \n" + massif);

        int max = massif.linearMaxElSearch();
        Printer.print("\nНахождение максимального элемента линейным поиском. Максимальный элемент: " + max);
        Printer.print("Количество операций: " + massif.getCount());
        Printer.print("\nНахождение максимального элемента бинарным поиском. Максимальный элемент находится под индексом: " + massif.binarySearch(max));
        Printer.print("Количество операций: " + massif.getCount());
        Printer.print("\nНахождение максимального элемента индексно-последовательным поиском. Максимальный элемент находится под индексом: " + massif.indexedSequentialSearch(max));
        Printer.print("Количество операций: " + massif.getCount());

        Printer.print("\nНахождение произвольного элемента линейным поиском.");
        int value = Inputer.checkInput("Введите значение элемента: ");
        if (massif.linearSearch(value)) {
            Printer.print("Элемент найден.");
        } else {
            Printer.print("Элемент не найден.");
        }
        Printer.print("Количество операций: " + massif.getCount());

        Printer.print("\nНахождение произвольного элемента бинарным поиском.");
        value = Inputer.checkInput("Введите значение элемента: ");
        int index = massif.binarySearch(value);
        if (index >= 0) {
            System.out.println("Элемент присутствует под индексом " + index);
        } else {
            System.out.println("элемент отсутствует");
        }
        Printer.print("Количество операций: " + massif.getCount());

        Printer.print("\nНахождение максимального элемента индексно-последовательным поиском. Максимальный элемент находится под индексом: " + massif.indexedSequentialSearch(max));
        value = Inputer.checkInput("Введите значение элемента: ");
        index = massif.indexedSequentialSearch(value);
        if (index >= 0) {
            System.out.println("Элемент присутствует под индексом " + index);
        } else {
            System.out.println("элемент отсутствует");
        }
        Printer.print("\nКоличество операций: " + massif.getCount());
    }
}
