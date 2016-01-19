package com.develogical;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ape06 on 19/01/2016.
 */
public class RecentlyUsedList {

    List<String> list = new ArrayList<>();

    public int length() {
        return (list.size());
    }

    public void add(String s) {
        if(list.contains(s))
        {
            list.remove(s);
            list.add(s);
        }
        else {
            if (s.length() > 0)
                list.add(s);
        }
    }

    public String getElement(int i) {
        return list.get(i-1);
    }

    public String getTopElement() {
        return list.get(list.size()-1);
    }
}
