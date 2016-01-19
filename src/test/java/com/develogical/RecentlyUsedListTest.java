package com.develogical;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by ape06 on 19/01/2016.
 */
public class RecentlyUsedListTest {


    RecentlyUsedList list = new RecentlyUsedList();

    @Test
    public void isEmptyAfterCreation()
    {
        assertThat(list.length(),is(0));
    }

    @Test
    public void hasIncreasedSizeAfterAddingOneElement()
    {

        int initialLength = list.length();
        list.add("First Element");
        int finalLength = list.length();

        assertThat(finalLength-initialLength,is(1));

    }

    @Test
    public void canRetrieveOneElement()
    {
        list.add("First Element");
        String s = list.getElement(1);
        assertThat(s,is("First Element"));
    }

    @Test
    public void canRetrieveNElements()
    {
        create5Elements();
        String s = list.getElement(2);
        assertThat(s,is("Second Element"));
    }

    private void create5Elements() {
        list.add("First Element");
        list.add("Second Element");
        list.add("Third Element");
        list.add("Fourth Element");
        list.add("Fifth Element");
    }

    @Test
    public void mostRecentElementIsFirst()
    {
        create5Elements();
        list.add("Sixth Element");
        String s = list.getTopElement();
        assertThat(s,is("Sixth Element"));
    }

    @Test
    public void hasNoDuplicateEntries()
    {
        create5Elements();
        list.add("Fifth Element");
        assertThat(list.length(),is(5));
    }

    @Test
    public void hasDuplicateGoneToTop()
    {
        create5Elements();
        list.add("Third Element");
        String s = list.getTopElement();
        assertThat(s,is("Third Element"));
    }

    @Test
    public void ignoresEmptyElement()
    {
        list.add("");
        assertThat(list.length(),is(0));
    }

}
