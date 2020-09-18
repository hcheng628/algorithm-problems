package us.supercheng.algorithm.problems.reformatdate;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String reformatDate(String date) {
        Map<String, String> map = new HashMap<>();
        String[] arr = date.split(" ");

        map.put("1st", "01");
        map.put("2nd", "02");
        map.put("3rd", "03");
        map.put("4th", "04");
        map.put("5th", "05");
        map.put("6th", "06");
        map.put("7th", "07");
        map.put("8th", "08");
        map.put("9th", "09");
        map.put("10th", "10");
        map.put("11th", "11");
        map.put("12th", "12");
        map.put("13th", "13");
        map.put("14th", "14");
        map.put("15th", "15");
        map.put("16th", "16");
        map.put("17th", "17");
        map.put("18th", "18");
        map.put("19th", "19");
        map.put("20th", "20");
        map.put("21st", "21");
        map.put("22nd", "22");
        map.put("23rd", "23");
        map.put("24th", "24");
        map.put("25th", "25");
        map.put("26th", "26");
        map.put("27th", "27");
        map.put("28th", "28");
        map.put("29th", "29");
        map.put("30th", "30");
        map.put("31st", "31");

        map.put("Jan", "01");
        map.put("Feb", "02");
        map.put("Mar", "03");
        map.put("Apr", "04");
        map.put("May", "05");
        map.put("Jun", "06");
        map.put("Jul", "07");
        map.put("Aug", "08");
        map.put("Sep", "09");
        map.put("Oct", "10");
        map.put("Nov", "11");
        map.put("Dec", "12");

        return arr[2] + "-" + map.get(arr[1]) + "-" + map.get(arr[0]);
    }
}