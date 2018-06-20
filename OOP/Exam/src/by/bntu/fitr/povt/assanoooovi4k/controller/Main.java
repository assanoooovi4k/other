package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.Array;
import by.bntu.fitr.povt.assanoooovi4k.view.Output;


public class Main {

    public static void main(String[] args) throws InterruptedException{
	    int[] massif = {-1, 232, 324, 0, 24, -34, 23, 8, 313, -32};
	    Array array = new Array(massif);

	    Thread thread = new Thread(array);
	    thread.start();
	    Thread.sleep(10000);
        Output.printer(array.toString());
    }
}
