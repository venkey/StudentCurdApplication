package Service;

import java.util.List;

import Model.Employee;

public interface Emp_Services {
	public boolean saveEmp(Employee emp);
	public List<Employee> getEmp();
	public boolean deleteEmp(Employee emp);
	public List<Employee> getEmpByID(Employee emp);
	public boolean updateEmp(Employee emp);
}
