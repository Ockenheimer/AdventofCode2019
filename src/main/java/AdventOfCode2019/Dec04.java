/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdventOfCode2019;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author markusschaefer
 */
public class Dec04 {

    int lowest;
    int highest;
    List<String> hitlist = new ArrayList();

    public Dec04(String input) {
        this.lowest = Integer.parseInt(input.substring(0, 6));
        this.highest = Integer.parseInt(input.substring(7, input.length()));
//       this.highest = Integer.parseInt(input.substring(0, 6));
    }

    public int check() {

        int possible = 0;

        lab1:
        for (int i = this.lowest; i <= this.highest; i++) {
            String s = String.valueOf(i);

            boolean dou = false;

            int doumerker = 0;
            int fault = 0;
            int tri = 0;
//            Boolean quad = false;
//            Boolean quin = false;
// check decreasing, if so, skip 
            for (int j = 0; j < s.length() - 1; j++) {
                if (Integer.parseInt(s.substring(j, j + 1)) > Integer.parseInt(s.substring(j + 1, j + 2))) {

                    continue lab1;
                }
            }

            for (int j = 1; j <= s.length() - 1; j++) {
                int pre = Integer.parseInt(s.substring(j - 1, j));
                int cur = Integer.parseInt(s.substring(j, j + 1));

                if (cur == tri) {
                    continue;
                }
                if (dou && doumerker < cur && doumerker != 0) {
                    possible++;
                    hitlist.add(s + "\n");
                    continue lab1;

                }
                if (pre == cur && cur != doumerker) {
                    dou = true;
                    if (doumerker == 0) {
                        doumerker = cur;
                    }
                }

                if (j >= 2 && dou) {
                    int pre2 = Integer.parseInt(s.substring(j - 2, j - 1));
                    if (pre2 == cur) {
                        dou = false;
                        tri = cur;
                        doumerker = 0;

                    }
                }
                
            }

//                int checker = Integer.parseInt(s.substring(j, j + 1));
//                int follow = Integer.parseInt(s.substring(j + 1, j + 2));
//
//                if (!dou) {
//                    if (checker == follow && checker != fault) {
//                        if (checker > merker) {
//                            dou = true;
//                            merker = checker;
//                        } else {
//                            if (checker == follow) {
//                                dou = false;
//                        fault = checker;
//                            }
//}
//}
//}
//                if (j < s.length() - 3 && Integer.parseInt(s.substring(j + 2, j + 3)) == dou) {
//                    fault = dou;
//                    dou = 0;
//
//                }
            if (dou && doumerker != 0) {
                ++possible;
                hitlist.add(s + "\n");

            }
        }
        System.out.println(hitlist);
        return possible;
    }

}
