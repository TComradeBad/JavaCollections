/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 *
 * @author comrade
 * @param <E>
 */
public class VersionList<E> implements List<E> {

    //first element of the list
    protected Map<String, VersionListElement<E>> firstElements;

    //last current element of the list
    protected VersionListElement<E> lastElement;

    //Current Branch
    protected String currentBranch;

    //Constructor
    public VersionList() {
        this.currentBranch = "";
        this.firstElements = new HashMap<>();
    }

    //Get size of the List
    @Override
    public int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Add new Element to new branch
    @Override
    public boolean add(E e) {

        this.initBranch();

        if (this.firstElements.isEmpty()) {
            VersionListElement<E> el = new VersionListElement<>(this.currentBranch, e);
            this.firstElements.put(this.currentBranch, el);
            this.lastElement = el;

        } else {
            this.lastElement = this.lastElement.addNextElement(e, this.currentBranch);

        }
        return true;

    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Add collection of Elemnts to the List
    @Override
    public boolean addAll(Collection<? extends E> c) {

        this.initBranch();

        if (this.firstElements.isEmpty()) {

            VersionListElement<E> element = new VersionListElement<>(this.currentBranch, (E) c.toArray()[0]);
            VersionListElement<E> lastArrElement = element;

            for (int i = 1; i < c.size(); i++) {
                VersionListElement<E> el = lastArrElement.addNextElement((E) c.toArray()[i]);
                lastArrElement = el;
            }

            this.firstElements.put(currentBranch, element);
        } else {

            for (E el : c) {
                this.lastElement = this.lastElement.addNextElement(el, this.currentBranch);
            }
        }

        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Init new branch title
    protected String initBranch() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_hh:mm:ss");
        this.currentBranch = dateFormat.format(new Date());
        return this.currentBranch;

    }

}
