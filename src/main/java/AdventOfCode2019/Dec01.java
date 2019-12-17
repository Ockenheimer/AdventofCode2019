/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCode2019;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author markusschaefer
 */
public class Dec01 {

    static int ergebniss;
    static File file;

    private int berechnung(int zahl) {
        int fule = Math.toIntExact(Math.round(zahl / 3) - 2);
        if (fule > 0) {
            fule += berechnung(fule);
            return fule;
        } else {
            return 0;

        }
    }

    public Dec01(File file) {
        this.file = file;
    }

    public String endsumme() throws IOException {
        int summe = 0;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str;
            while ((str = bufferedReader.readLine()) != null && str.length() != 0) {

                summe += berechnung(Integer.parseInt(str));
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Dec01.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Das Ergebniss lautet " + summe;
    }

}
