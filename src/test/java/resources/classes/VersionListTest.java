/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author comrade
 */
public class VersionListTest {

    //Test example of VersionList
    private VersionList<Integer> example;

    public VersionListTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        this.example = new VersionList<>();
        Integer[] array = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        this.example.addAll(Arrays.asList(array));
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of size method, of class VersionList.
     *
     */
    @Test
    public void testSize() {
        int expected = 11;
        int result = this.example.size();
        assertEquals(expected, result);

    }

    /**
     * Test of isEmpty method, of class VersionList.
     */
    @Test
    public void testIsEmpty() {
        boolean expected = false;
        boolean result = this.example.isEmpty();
        assertEquals(expected, result);
        //--------------------------------------//
        expected = true;
        this.example = new VersionList<>();
        result = this.example.isEmpty();
        assertEquals(expected, result);
    }

    /**
     * Test of contains method, of class VersionList.
     */
    @Test
    public void testContains() {
        boolean expected = true;
        boolean result = this.example.contains(256);
        assertEquals(expected, result);
        //--------------------------------------//
        expected = false;
        result = this.example.contains(404);
        assertEquals(expected, result);

    }

    /**
     * Test of iterator method, of class VersionList.
     */
    @Test
    public void testIterator() {

        //It just returns iterator
    }

    /**
     * Test of toArray method, of class VersionList.
     */
    @Test
    public void testToArray_0args() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);
    }

    /**
     * Test of toArray method, of class VersionList.
     */
    @Test
    public void testToArray_GenericType() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        Object[] result = {};
        result = this.example.toArray(result);
        assertArrayEquals(expected, result);

    }

    /**
     * Test of add method, of class VersionList.
     */
    @Test
    public void testAdd_GenericType() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048};
        this.example.add(2048);
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of remove method, of class VersionList.
     */
    @Test
    public void testRemove_Object() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 256, 512, 1024};
        this.example.remove(new Integer(128));
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of containsAll method, of class VersionList.
     */
    @Test
    public void testContainsAll() {
        boolean expected = true;
        Integer[] data = {1, 32, 512};
        boolean result = this.example.containsAll(Arrays.asList(data));
        assertEquals(expected, result);
        //--------------------------------------//
        expected = false;
        data = new Integer[]{1, 32, 512, 404};
        result = this.example.containsAll(Arrays.asList(data));
        assertEquals(expected, result);
    }

    /**
     * Test of addAll method, of class VersionList.
     */
    @Test
    public void testAddAll_Collection() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 200, 300, 400, 500};
        Integer[] data = {200, 300, 400, 500};
        this.example.addAll(Arrays.asList(data));
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of addAll method, of class VersionList.
     */
    @Test
    public void testAddAll_int_Collection() {
        Integer[] expected = {1, 2, 4, 8, 200, 300, 400, 500, 16, 32, 64, 128, 256, 512, 1024};
        Integer[] data = {200, 300, 400, 500};
        this.example.addAll(4, Arrays.asList(data));
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of removeAll method, of class VersionList.
     */
    @Test
    public void testRemoveAll() {
        Integer[] expected = {2, 4, 8, 16, 64, 256, 1024};
        Integer[] data = {1, 32, 128, 512};
        this.example.removeAll(Arrays.asList(data));
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of retainAll method, of class VersionList.
     */
    @Test
    public void testRetainAll() {
        Integer[] expected = {2, 4, 8, 16, 64, 256, 1024};
        boolean exceptBool = true;
        Integer[] data = {2, 4, 8, 16, 64, 256, 1024};
        boolean resultBool = this.example.retainAll(Arrays.asList(data));
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);
        assertEquals(exceptBool, resultBool);

    }

    /**
     * Test of clear method, of class VersionList.
     */
    @Test
    public void testClear() {
        Object[] expected = {};
        this.example.clear();
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of get method, of class VersionList.
     */
    @Test
    public void testGet() {
        Integer expected = 128;
        Integer result = this.example.get(7);
        assertEquals(expected, result);

    }

    /**
     * Test of set method, of class VersionList.
     */
    @Test
    public void testSet() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 404, 256, 512, 1024};
        this.example.set(7, 404);
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of add method, of class VersionList.
     */
    @Test
    public void testAdd_int_GenericType() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 404, 128, 256, 512, 1024};
        this.example.add(7, 404);
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);

    }

    /**
     * Test of remove method, of class VersionList.
     */
    @Test
    public void testRemove_int() {
        Integer[] expected = {1, 2, 4, 8, 16, 32, 64, 256, 512, 1024};
        this.example.remove(7);
        Object[] result = this.example.toArray();
        assertArrayEquals(expected, result);
    }

    /**
     * Test of indexOf method, of class VersionList.
     */
    @Test
    public void testIndexOf() {
        Integer expected = 7;
        Object result = this.example.indexOf(128);
        assertEquals(expected, result);
    }

    /**
     * Test of lastIndexOf method, of class VersionList.
     */
    @Test
    public void testLastIndexOf() {
        this.example = new VersionList<>();
        Integer[] array = {1, 2, 4, 8, 16, 8, 64, 8, 256, 512, 1024};
        this.example.addAll(Arrays.asList(array));
        //--------------------------------//
        Integer expected = 7;
        Integer result = this.example.lastIndexOf(8);
        assertEquals(expected, result);

    }

    /**
     * Test of listIterator method, of class VersionList.
     */
    @Test
    public void testListIterator_0args() {

        //So it just return listIterator
    }

    /**
     * Test of listIterator method, of class VersionList.
     */
    @Test
    public void testListIterator_int() {
        //So it just return listIterator with index
    }

    /**
     * Test of subList method, of class VersionList.
     */
    @Test
    public void testSubList() {
        Integer[] expected = {64, 128, 256, 512};
        List<Integer> result = this.example.subList(6, 10);
        assertArrayEquals(expected, result.toArray());
    }

    /**
     * Test of getListByVersion method, of class VersionList.
     */
    @Test
    public void testGetListByVersion() {
        List<String> versions = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        VersionList<Integer> example = new VersionList<>();

        Object[] expected;
        Object[] result;

        versions.add(example.getCurrentBranch());
        int b;

        for (int i = 1; i <= 10; i++) {

            b = i * i;
            data.add(b);
            expected = data.toArray();

            example.add(b);
            versions.add(example.getCurrentBranch());
            result = example.getListByVersion(versions.get(i)).toArray();

            assertArrayEquals(expected, result);
        }

    }

    /**
     * Test of getCurrentBranch method, of class VersionList.
     */
    @Test
    public void testGetCurrentBranch() {
        boolean expected = false;
        boolean result = Objects.isNull(this.example.getCurrentBranch());
        assertEquals(expected, result);
    }

}
