package us.supercheng.algorithm.problems.averagesalaryexcludingtheminimumandmaximumsalary;

public class Solution {

    public double average(int[] salary) {
        double min = salary[0],
               max = salary[1],
               total = 0.0;

        for (int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            total += s;
        }

        return (total - min - max) / (salary.length-2);
    }
}
