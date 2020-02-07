/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author comrade
 * @param <E>
 */
public class VersionList<E> implements List<E> {

    //Stored items
    private final List<E> data;

    //Current Branch
    private String currentBranch = "init";

    //List of changes
    private List<Branch> versions_history;

    //Size of this version
    private int size;

    //Constructor
    public VersionList() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_hh:mm:sss");
        this.currentBranch = dateFormat.format(new Date());
        this.size = 0;
        this.data = new ArrayList<>();
        this.versions_history = new ArrayList<>();
    }

    public VersionList(Collection<? extends E> c) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_hh:mm:sss");
        this.currentBranch = dateFormat.format(new Date());
        this.size = 0;
        this.versions_history = new ArrayList<>();
        this.data = new ArrayList<>(c);
    }

    /**
     * Get size of the current List version
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * Is data empty
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    /**
     * Is data contains object
     * @param o
     * @return 
     */
    @Override
    public boolean contains(Object o) {
        return this.data.contains(o);
    }

    /**
     * Get data iterator
     * @return 
     */
    @Override
    public Iterator<E> iterator() {
        return this.data.iterator();
    }

    /**
     * Cast to array
     * @return 
     */
    @Override
    public Object[] toArray() {
        return this.data.toArray();
    }

    /**
     * Cast to array
     * @param <T>
     * @param a
     * @return 
     */
    @Override
    public <T> T[] toArray(T[] a) {
        return this.data.toArray(a);
    }

    /**
     * Add new Element to new branch
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, this.data.size(), PerformedAction.Add, e);
        boolean result = this.data.add(e);
        this.versions_history.add(br);

        return result;
    }

    /**
     * Remove object o
     * @param o
     * @return 
     */
    @Override
    public boolean remove(Object o) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, null, PerformedAction.RemoveAll, o);
        boolean result = this.data.remove(o);
        this.versions_history.add(br);

        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.data.containsAll(c);
    }

    /**
     * Add collection of Elemnts to the List
     *
     * @param c
     * @return
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, this.data.size(), PerformedAction.Add, c);
        boolean result = this.data.addAll(c);
        this.versions_history.add(br);

        return result;
    }

    /**
     * Add objects from collection c to index
     *
     * @param index
     * @param c
     * @return
     */
    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, index, PerformedAction.Add, c);
        boolean result = this.data.addAll(index, c);
        this.versions_history.add(br);

        return result;
    }

    /**
     * Remove all objects like in collection c
     *
     * @param c
     * @return
     */
    @Override
    public boolean removeAll(Collection<?> c) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, null, PerformedAction.RemoveAll, c);
        boolean result = this.data.removeAll(c);
        this.versions_history.add(br);

        return result;

    }

    /**
     * Retain all list by collection c
     *
     * @param c
     * @return
     */
    @Override
    public boolean retainAll(Collection<?> c) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, null, PerformedAction.RetainAll, c);
        boolean result = this.data.retainAll(c);
        this.versions_history.add(br);

        return result;
    }

    /**
     * Clear data list
     */
    @Override
    public void clear() {

        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, null, PerformedAction.RemoveAll, this.data);
        this.data.removeAll(this.data);
        this.versions_history.add(br);

    }

    @Override
    public E get(int index) {
        return this.data.get(index);
    }

    /**
     * Set element by index
     *
     * @param index
     * @param element
     * @return
     */
    @Override
    public E set(int index, E element) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, index, PerformedAction.Set, element);
        E result = this.data.set(index, element);
        this.versions_history.add(br);

        return result;

    }

    /**
     * Add element by index
     *
     * @param index
     * @param element
     */
    @Override
    public void add(int index, E element) {
        this.initBranch();

        Branch br = new Branch<>(this.currentBranch, index, PerformedAction.Add, element);
        this.data.add(index, element);
        this.versions_history.add(br);
    }

    /**
     * Remove by index
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        this.initBranch();

        E element = this.data.get(index);
        Branch br = new Branch<>(this.currentBranch, index, PerformedAction.RemoveIndex, element);
        E result = this.data.remove(index);
        this.versions_history.add(br);

        return result;

    }

    /**
     * Get index of object
     *
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        return this.data.indexOf(o);
    }

    /**
     * Get last index of data
     *
     * @param o
     * @return
     */
    @Override
    public int lastIndexOf(Object o) {
        return this.data.lastIndexOf(o);
    }

    /**
     * Get data list iterator
     *
     * @return
     */
    @Override
    public ListIterator<E> listIterator() {
        return this.data.listIterator();
    }

    /**
     * Get data list iterator with index
     *
     * @param index
     * @return
     */
    @Override
    public ListIterator<E> listIterator(int index) {
        return this.data.listIterator(index);
    }

    /**
     * Get part of the data array
     *
     * @param fromIndex
     * @param toIndex
     * @return
     */
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return this.data.subList(fromIndex, toIndex);
    }

    /**
     * Set title of new branch version
     *
     * @return
     */
    private String initBranch() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd_hh:mm:sss");
        String new_version = dateFormat.format(new Date());
        if (new_version.equals(this.currentBranch.substring(0, new_version.length()))) {
            new_version = new_version + ".V" + (int) (Math.random() * 100);
        }

        this.currentBranch = new_version;
        return this.currentBranch;

    }

    /**
     * Generate list by history of changes
     *
     * @param version
     * @return
     */
    private List<E> generateVersion(String version) {
        List<E> result_list = new ArrayList<>();
        List<Branch> hl = this.versions_history;

        int i = 0;
        for (i = 0; i < hl.size() && !hl.get(i).getBranch_name().equals(version); i++) {
            Branch<E> item = hl.get(i);
            result_list = this.performActionsOfBranch(item, result_list);
        }

        result_list = this.performActionsOfBranch(hl.get(i), result_list);
        return result_list;
    }

    /**
     * Make actions which was made on this branch
     *
     * @param item
     * @param list
     * @return
     */
    private List<E> performActionsOfBranch(Branch<E> item, List<E> list) {
        switch (item.getAction()) {
            case Add:
                list.addAll(item.getIndex(), item.getChanged_data());
                break;
            case RemoveAll:
                list.removeAll(item.getChanged_data());
                break;
            case RemoveIndex:
                list.remove((int) item.getIndex());
                break;
            case Set:
                list.set(item.getIndex(), item.getChanged_data().get(0));
                break;
            case RetainAll:
                list.retainAll(item.getChanged_data());
                break;
        }
        return list;
    }

    /**
     * Get list on version
     *
     * @param version
     * @return
     */
    public List<E> getListByVersion(String version) {
        return this.generateVersion(version);
    }

    /**
     * Get name of current branch
     * @return 
     */
    public String getCurrentBranch() {
        return this.currentBranch;
    }

}
