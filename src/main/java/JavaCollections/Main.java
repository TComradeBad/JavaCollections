/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCollections;

import java.util.ArrayList;
import java.util.Collection;



/**
 *
 * @author comrade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Collection<Integer> l = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            l.add(i * 12);
        }

        System.out.println(l.iterator().next().toString());
        l.iterator().next();
        
    }

}
