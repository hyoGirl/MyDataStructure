package com.xulei.leetcode.Easy.Hash;

import java.util.List;

/**
 * 员工的重要性
 */
public class T690EmployeeImportance {


//    员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，
//    员工2的数据结构是[2, 10, [3]]，
//    员工3的数据结构是[3, 5, []]。
//    注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。



//    示例 1:
//
//    输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
//    输出: 11
//    解释:
//    员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。


    public int getImportance(List<Employee> employees, int id) {


        /**
         * 递归解法。只有直接上下级的关系才可以
         */

        for(Employee employee:employees){

            int idValue = employee.id;
            if(id == idValue){
                if(employee.subordinates.size()==0){
                    return employee.importance;
                }
                for(int ids:employee.subordinates){
                    employee.importance+=getImportance(employees,ids);
                }
                //这个地方要返回的结果是：for循环结束后的值
                return employee.importance;
            }
        }
        return  0;
    }
}


class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};