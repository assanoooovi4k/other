package by.bntu.fitr.povt.assanoooovi4k.controller;

import by.bntu.fitr.povt.assanoooovi4k.model.Array;
import by.bntu.fitr.povt.assanoooovi4k.model.concurrent.ConcurrentArray;
import by.bntu.fitr.povt.assanoooovi4k.view.Output;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {
//        System.out.println(Locale.getDefault());
        ResourceBundle resourceBundle = ResourceBundle.getBundle("data");
        Output.printer(resourceBundle.getString("greetings") + "\n");


//	    int[] massif = {-1, 232, 324, 0, 24, -34, 23, 8, 313, -32};
//	    Array array = new Array(massif);
//
//	    Thread thread = new Thread(array);
//	    thread.start();
//	    Thread.sleep(10000);
//        Output.printer(array.toString());


		ExecutorService executorService = Executors.newFixedThreadPool(1);

		Integer[] integers =  {-1, 232, 324, 0, 24, -34, 23, 8, 313, -32};
//		ConcurrentArray array = new ConcurrentArray(integers);

		Callable<Integer[]> callable = new ConcurrentArray(integers);
		Future<Integer[]> future = executorService.submit(callable);

		try {
			Integer[] integerss = future.get();
			for (Integer integer:
				 integerss) {
				Output.printer(integer + " ");
			}
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

		executorService.shutdown();
	}
}
