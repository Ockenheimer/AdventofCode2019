/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCode2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

/**
 *
 * @author markusschaefer
 */
public class Dec03 {

    String[] links;
    String[] rechts;

    class Sortbyroll implements Comparator<intpair> {
        // Used for sorting in ascending order of 
        // roll number 

        @Override
        public int compare(intpair a, intpair b) {
            return a.getDistance() - b.getDistance();
        }
    }

    public Dec03(String[] links, String[] rechts) {
        this.links = links.clone();
        this.rechts = rechts.clone();
    }

    public class intpair {

        public int x;
        public int y;
        public int distance;

        public intpair(int x, int y) {
            this.x = x;
            this.y = y;
            int x1, y1;
            if (x < 0) {
                x1 = x * -1;
            } else {
                x1 = x;
            }

            if (y < 0) {
                y1 = y * -1;
            } else {
                y1 = y;
            }
            this.distance = x1 + y1;

        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDistance() {
            return distance;
        }

    }

    public String distance() {
        int x, y, dist;
        x = 0;
        y = 0;

        List<intpair> linkeListe = new ArrayList<>();
        List<intpair> rechteListe = new ArrayList<>();
        List<intpair> list = new ArrayList<>();

        for (String link : links) {
            if (link.charAt(0) == 'U') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y + 1;
                    linkeListe.add(new intpair(x, y));

                    j++;
                }
            }
            if (link.charAt(0) == 'D') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y - 1;
                    linkeListe.add(new intpair(x, y));
                    j++;
                }
            }
            if (link.charAt(0) == 'L') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x - 1;
                    linkeListe.add(new intpair(x, y));
                    j++;
                }
            }
            if (link.charAt(0) == 'R') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x + 1;
                    linkeListe.add(new intpair(x, y));
                    j++;
                }
            }
        }
// und jetzt für rechts

        x = 0;
        y = 0;
        for (String recht : rechts) {
            if (recht.charAt(0) == 'U') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y + 1;
                    rechteListe.add(new intpair(x, y));

                    j++;
                }
            }
            if (recht.charAt(0) == 'D') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y - 1;
                    rechteListe.add(new intpair(x, y));
                    j++;
                }
            }
            if (recht.charAt(0) == 'L') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x - 1;
                    rechteListe.add(new intpair(x, y));
                    j++;
                }
            }
            if (recht.charAt(0) == 'R') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x + 1;
                    rechteListe.add(new intpair(x, y));
                    j++;
                }
            }
        }

        for (int i = 0; i < rechteListe.size(); i++) {
            for (int j = 0; j < linkeListe.size(); j++) {
                if (linkeListe.get(j).getX() == rechteListe.get(i).getX() && linkeListe.get(j).getY() == rechteListe.get(i).getY()) {
                    list.add(new intpair(linkeListe.get(j).getX(), linkeListe.get(j).getY()));
                }
            }

        }
        Collections.sort(list, new Sortbyroll());
        System.out.println("x     y      dist");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getX() + " " + list.get(i).getY() + " " + list.get(i).getDistance());

        }

        //    return "Die Koordinaten mit der kleinesten Differenz: " + list.get(0).getDistance() + " mit den Werten X = " + list.get(0).getX() + "und Y = " + list.get(0).getY();
        return "affenschauckel";
    }
}
