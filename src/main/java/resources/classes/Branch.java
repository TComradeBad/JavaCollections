/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author comrade
 */
public class Branch<E> {

    //Action which was performed in this branch
    private final PerformedAction action;

    //Index where action was performed
    private Integer index;

    //Branch name
    private String branch_name;

    //data whis was used
    private List<E> changed_data;

    public Branch(String branch_name, Integer index, PerformedAction action, E data) {
        this.branch_name = branch_name;
        this.index = index;
        this.action = action;
        this.changed_data = new ArrayList<>();
        this.changed_data.add(data);

    }

    public Branch(String branch_name, Integer index, PerformedAction action, Collection<? extends E> data) {
        this.branch_name = branch_name;
        this.index = index;
        this.action = action;
        this.changed_data = new ArrayList<>();
        this.changed_data.addAll(data);

    }

    public PerformedAction getAction() {
        return action;
    }

    public Integer getIndex() {
        return index;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public List<E> getChanged_data() {
        return changed_data;
    }
    
    

}
