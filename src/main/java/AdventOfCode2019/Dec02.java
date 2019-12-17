/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCode2019;

/**
 *
 * @author markusschaefer
 */
public class Dec02 {

    static int[] array;
    static int[] merker;

    public Dec02(int[] array1) {
        array = array1.clone();
        merker = array1;

    }

    public void compute() {
        int i = 0;
        do {

            switch (array[i]) {

                case 1:
                    array[array[i + 3]] = array[array[i + 1]] + array[array[i + 2]];

                    break;

                case 2:
                    array[array[i + 3]] = array[array[i + 1]] * array[array[i + 2]];

                    break;

                case 99:

                 //   System.out.println("ICh habe fertig: " + array[0]);
                    break;

            }
            i += 4;

        } while (i < array.length - 1);
    }

    public String target(int ziel) {

        int j = 0;
        int i = 0;
        
            do {
                j = 0;
                do {
                    array = merker.clone();
                    array[1] = i;
                    array[2] = j;
                    this.compute();
                    if (array[0] == ziel) {
                        return "i ist " + i + " j ist " + j;
                        
                    }
                    j++;
                    System.out.println("i = " + i + " j = " + j);
                } while (j < 147);
                i++;
            } while (i < 146);

        return "Leider nichts gefunden";
         }

    public void setArray(int stelle, int wert) {
        array[stelle] = wert;
    }

    public static int getArray() {
        return array[0];
    }

}
