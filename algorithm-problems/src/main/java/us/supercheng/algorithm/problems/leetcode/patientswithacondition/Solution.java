package us.supercheng.algorithm.problems.leetcode.patientswithacondition;

public class Solution {

    String SQL = "SELECT patient_id, patient_name, conditions\n" +
            "FROM Patients\n" +
            "WHERE POSITION(\"DIAB1\" IN conditions) = 1 OR \n" +
            "    (POSITION(\"DIAB1\" IN conditions) > 1 AND SUBSTR(conditions, POSITION(\"DIAB1\" IN conditions) - 1, 1) = ' ');";

    String SQL2 = "SELECT patient_id, patient_name, conditions\n" +
            "FROM Patients\n" +
            "WHERE conditions LIKE 'DIAB1%' OR conditions LIKE '% DIAB1%'";

}
