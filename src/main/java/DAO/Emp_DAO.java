package DAO;

import java.util.List;

import Model.Employee;

public interface Emp_DAO {
	public boolean saveEmp(Employee student);
	public List<Employee> getEmps();
	public boolean deleteEmp(Employee student);
	public List<Employee> getEmpByID(Employee emp);
	public boolean updateEmp(Employee emp);
}
