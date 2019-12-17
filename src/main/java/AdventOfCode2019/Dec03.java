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
    //two string Array for the wires
    String[] links;
    String[] rechts;

    class SortbyDistance implements Comparator<intpair> {
        // Used for sorting in ascending order of 
        // distance 

        @Override
        public int compare(intpair a, intpair b) {
            return a.getDistance() - b.getDistance();
        }
    }

    public Dec03(String[] links, String[] rechts) {
        this.links = links.clone();
        this.rechts = rechts.clone();
    }
    //A point of the wire lies on a pair of x,y-integers
    //intpair
    public class intpair {

        public int x;
        public int y;
        public int distance;

        public intpair(int x, int y) {
            this.x = x;
            this.y = y;
            int x1, y1;
            //for manhattan distance we need no negative ints
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
        //x and y as coordinates
        //dist as distance, how far the cable travells on given direction
        
        int x, y, dist;
        
        x = 0;
        y = 0;  
        //we need our cables
        //Cable "left"
        List<intpair> linkeListe = new ArrayList<>();
        //cable "right"
        List<intpair> rechteListe = new ArrayList<>();
        //our list of intersections, meight needed later
        List<intpair> list = new ArrayList<>();
        
        //as long as there are strings in the array
        //do for each string
        for (String link : links) {
            //the letter shows where to go
            //U is up so y+1
            if (link.charAt(0) == 'U') {
                //after the letter stands the distance
                dist = Integer.parseInt(link.substring(1));
                //now go as far as the entrance said
                for (int j = 0; j < dist; j++) {
                    
                    y = y + 1;
                    //write your location to the list "left"
                    linkeListe.add(new intpair(x, y));

                    j++;
                }
            }
            
            //same as U but now go down 
            //y-1
            if (link.charAt(0) == 'D') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y - 1;
                    linkeListe.add(new intpair(x, y));
                    j++;
                }
            }
            //now go left
            //x-1
            if (link.charAt(0) == 'L') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x - 1;
                    linkeListe.add(new intpair(x, y));
                    j++;
                }
            }
            //now go right 
            // x+1
                    
            if (link.charAt(0) == 'R') {
                dist = Integer.parseInt(link.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x + 1;
                    linkeListe.add(new intpair(x, y));
                    j++;
                }
            }
        }
// now cable 2
        //back to the root
        x = 0;
        y = 0;
        //and off we go
        for (String recht : rechts) {
            //up
            if (recht.charAt(0) == 'U') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y + 1;
                    rechteListe.add(new intpair(x, y));

                    j++;
                }
            }
            //down
            if (recht.charAt(0) == 'D') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    y = y - 1;
                    rechteListe.add(new intpair(x, y));
                    j++;
                }
            }
            //left
            if (recht.charAt(0) == 'L') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x - 1;
                    rechteListe.add(new intpair(x, y));
                    j++;
                }
            }
            //right
            if (recht.charAt(0) == 'R') {
                dist = Integer.parseInt(recht.substring(1));
                for (int j = 0; j < dist; j++) {
                    x = x + 1;
                    rechteListe.add(new intpair(x, y));
                    j++;
                }
            }
        }
        //search the whole list "right" item per item
        for (int i = 0; i < rechteListe.size(); i++) {
            //search the whole list "left" item per item
            for (int j = 0; j < linkeListe.size(); j++) {
                //if item "right" No. i value x is equal item "left" No. j value x AND
                //also item left y and right y
                if (linkeListe.get(j).getX() == rechteListe.get(i).getX() && linkeListe.get(j).getY() == rechteListe.get(i).getY()) {
                    //if its equal, right the tupel to the list of intersections
                    list.add(new intpair(linkeListe.get(j).getX(), linkeListe.get(j).getY()));
                }
            }

        }
        //sort the intersection list by the distance of the points
        Collections.sort(list, new SortbyDistance());
        //show me the list
        System.out.println("x     y      dist");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getX() + " " + list.get(i).getY() + " " + list.get(i).getDistance());

        }
        // return a String for the result
        //    return "Die Koordinaten mit der kleinesten Differenz: " + list.get(0).getDistance() + " mit den Werten X = " + list.get(0).getX() + "und Y = " + list.get(0).getY();
        return "affenschauckel";
    }
}
