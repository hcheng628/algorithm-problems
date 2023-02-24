package us.supercheng.algorithm.problems.leetcode.sortthepeople;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> list = new ArrayList<>();

        for (int i = 0, len = names.length; i < len; i++)
            list.add(new Person(names[i], heights[i]));

        list.sort((p1, p2) -> p2.height - p1.height);

        for (int i = 0, len = names.length; i < len; i++)
            names[i] = list.get(i).name;

        return names;
    }

    class Person {

        String name;
        int height;

        public Person(String name, int height) {
            this.name = name;
            this.height = height;
        }

    }

}
