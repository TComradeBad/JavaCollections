/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaCollections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import resources.classes.VersionList;

/**
 *
 * @author comrade
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        VersionList<Integer> list = new VersionList<>();
        VersionList<Integer> list2 = new VersionList<>();
        list2.add(2);
        list2.add(29);

        List<String> versions = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i);
            versions.add(((VersionList<Integer>) list).getCurrentBranch());
        }
        list.set(4, 29);
        versions.add(((VersionList<Integer>) list).getCurrentBranch());

        list.set(3, 29);
        versions.add(((VersionList<Integer>) list).getCurrentBranch());

        list.retainAll(list2);
        versions.add(((VersionList<Integer>) list).getCurrentBranch());
        
        list.add(6);
        versions.add(((VersionList<Integer>) list).getCurrentBranch());


        versions.forEach((v) -> {
            System.out.println(v);
        });

        for (String v : versions) {
            System.out.println(list.getListByVersion(v));
        }

    }

}
