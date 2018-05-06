package by.bntu.fitr.povt.assanoooovi4k.model;

import by.bntu.fitr.povt.assanoooovi4k.view.Printer;

import java.util.Scanner;

public class Inputer {

    public static int inputInt(String msg) {
        Scanner scanner = new Scanner(System.in);
        Printer.print(msg);
        int a = scanner.nextInt();
        return a;
    }

    public static int checkInput(String msg) {
        int a;

        while (true) {
            try {
                a = inputInt(msg);
                break;
            }
            catch (Exception e){
                    Printer.print("" + e + "\n");
            }
        }

        return a;
    }

    public static String inputString(String msg) {
        Printer.print(msg);
        return new Scanner(System.in).nextLine();
    }
}