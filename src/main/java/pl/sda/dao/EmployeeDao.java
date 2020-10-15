package pl.sda.dao;

import pl.sda.model.Employee;

public class EmployeeDao extends AbstractDao<Employee> {

    public EmployeeDao() {
        super(Employee.class);
    }
}
