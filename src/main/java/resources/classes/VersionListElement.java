/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.classes;

import java.util.HashMap;

import java.util.Map;

/**
 *
 * @author comrade
 */
public class VersionListElement<E> {

    //Element id
    private Integer id;

    //String Date of this object creation
    private String branch;

    //Pointer to previous ibject
    private VersionListElement<E> previousElement;

    //Map with String dates keys
    private Map<String, VersionListElement<E>> nextElements;

    //stored element    
    private E element;

    //======Constructors======//
    public VersionListElement(String branch) {
        this.branch = branch;
        this.element = null;
        this.previousElement = null;
        this.nextElements = new HashMap<>();
    }

    public VersionListElement(String branch, E element) {
        this.branch = branch;
        this.element = element;
        this.previousElement = null;
        this.nextElements = new HashMap<>();
    }

    public VersionListElement(String branch, E element, VersionListElement<E> previousElement) {
        this.branch = branch;
        this.element = element;
        this.previousElement = previousElement;
        this.nextElements = new HashMap<>();
    }

    public VersionListElement(String branch, E element, VersionListElement<E> previousElement, Map<String, VersionListElement<E>> nextElements) {
        this.branch = branch;
        this.element = element;
        this.previousElement = previousElement;
        this.nextElements = nextElements;
    }
    //===============================//

    //Add next element
    public VersionListElement<E> addNextElement(E element) {
        VersionListElement<E> nextElement = new VersionListElement<>(this.branch, element, this);
        this.nextElements.put(branch, nextElement);
        return nextElement;
    }

    //Add next element to the new branch
    public VersionListElement<E> addNextElement(E element, String branch) {
        VersionListElement<E> nextElement = new VersionListElement<>(branch, element, this);
        this.nextElements.put(branch, nextElement);
        return nextElement;
    }


    public VersionListElement<E> setPreviousElement(VersionListElement<E> element) {
        this.previousElement = element;
        return this.previousElement;
    }

}
