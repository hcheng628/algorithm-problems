package us.supercheng.algorithm.problems.leetcode.employeeimportance;

import java.util.*;

public class App {

    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

    public int getImportance3(List<Employee> employees, int id) {
        Map<Integer, Employee> empValMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for(Employee each : employees) {
            empValMap.put(each.id, each);
            if(each.id == id) {
                for(int eachSub : each.subordinates)
                    queue.add(eachSub);
                sum = each.importance;
            }
        }
        while(queue.size() > 0) {
            Integer subEmpId = queue.poll();
            Employee cur = empValMap.get(subEmpId);
            sum += cur.importance;
            for(int eachSubEmpId : cur.subordinates)
                queue.add(eachSubEmpId);
        }
        return sum;
    }

    public int getImportance2(List<Employee> employees, int id) {
        Employee [] bucket = new Employee[2000];
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        for(Employee each : employees) {
            bucket[each.id] = each;
            if(each.id == id) {
                for(int eachSub : each.subordinates)
                    queue.add(eachSub);
                sum = each.importance;
            }
        }
        while(queue.size() > 0) {
            Employee cur = bucket[queue.poll()];
            sum += cur.importance;
            for(int eachSubEmpId : cur.subordinates)
                queue.add(eachSubEmpId);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        Employee [] bucket = new Employee[2000];
        for(Employee each : employees)
            bucket[each.id] = each;
        return managerImportance(bucket, id);
    }

    private int managerImportance(Employee [] bucket, int empId) {
        int totalVal = bucket[empId].importance;
        for(int subEmpId : bucket[empId].subordinates)
            totalVal += managerImportance(bucket, subEmpId);
        return totalVal;
    }
}
