package DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Model.Employee;
@Repository
public class Emp_DAO_Imp implements Emp_DAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveEmp(Employee emp) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().save(emp);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Employee> getEmps() {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("hi");
		Query<Employee> query = currentSession.createQuery("from Post", Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public boolean deleteEmp(Employee emp) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(emp);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Employee> getEmpByID(Employee emp) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Employee> query = currentSession.createQuery("from employee where empid=:empid", Employee.class);
		query.setParameter("id", emp.getEmpid());
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public boolean updateEmp(Employee emp) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().update(emp);
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
