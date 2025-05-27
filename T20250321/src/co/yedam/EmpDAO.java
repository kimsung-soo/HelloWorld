package co.yedam;

import java.util.ArrayList;
import java.util.List;

/*
 * 등록,수정,삭제,목록 기능을 구현.
 * 저장은 storage에 반영하도록 함.
 */
public class EmpDAO {

    List<Employee> storage = new ArrayList<>();

  
    public boolean add(Employee emp) {
        storage.add(emp);
        return true;
    }
    

    public boolean update(Employee emp) {
        if (delete(emp.getEmpId())) {
            storage.add(emp);
            return true;
        }
        return false;
    }

   
    public boolean delete(String empId) {
        return storage.removeIf(del -> del.getEmpId().equals(empId));
    }


    public List<Employee> list() {
        return storage;
    }

 
    public Employee Id(String empId) {
        for (Employee emp : storage) {
            if (emp.getEmpId().equals(empId)) {
                return emp;
            }
        }
        return null;
    }
}
