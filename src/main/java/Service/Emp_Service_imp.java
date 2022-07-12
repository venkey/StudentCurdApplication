package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import DAO.Emp_DAO;
import Model.Employee;

@Service
@Transactional
public class Emp_Service_imp implements Emp_Services{
	
	@Autowired
	private Emp_DAO empdao;

	@Override
	public boolean saveEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empdao.saveEmp(emp);
	}

	@Override
	public List<Employee> getEmp() {
		// TODO Auto-generated method stub
		return empdao.getEmps();
	}

	@Override
	public boolean deleteEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empdao.deleteEmp(emp);
	}

	@Override
	public List<Employee> getEmpByID(Employee emp) {
		// TODO Auto-generated method stub
		return empdao.getEmpByID(emp);
	}

	@Override
	public boolean updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empdao.updateEmp(emp);
	}

}
