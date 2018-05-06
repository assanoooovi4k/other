package by.bntu.fitr.povt.assanoooovi4k.model;

import java.util.Random;

public class Massif {

    public static int[][] createMassif(int lines, int columns) {
        int[][] massif = new int[lines][columns];

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                massif[i][j] = createElement();
            }
        }

        return massif;
    }

    public static int createElement() {
        Random random = new Random();
        return (random.nextInt(200) - 100);
    }

    public static String printMassif(int[][] massif, int lines, int columns) {
        StringBuilder builder = new StringBuilder("Massif:\n");

        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                String el = String.valueOf(massif[i][j]);
                if (el.length() < 2) {
                    builder.append(el).append("  \t\t");
                } else if (el.length() < 3){
                    builder.append(el).append(" \t\t");
                }
                else {
                    builder.append(el).append("\t\t");
                }
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
