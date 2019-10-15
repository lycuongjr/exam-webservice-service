package example.service;

import com.google.gson.Gson;
import example.entity.Employee;
import example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class EmplyeeService {
@WebMethod
    public List<Employee>getEmployee(){
        List<Employee> employeeList = HibernateUtil.getSession().createQuery("from Employee ", Employee.class).list();
        for (Employee employee :
                employeeList) {
            System.out.println(employee.getId() + " - " + employee.getName() + " - " + employee.getSalary());
        }
        System.out.println(new Gson().toJson(employeeList));
        return HibernateUtil.getSession().createQuery("from Employee ", Employee.class).list();
    }
    public  void save (Employee e){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.saveOrUpdate(e);
            transaction.commit();

        }catch (Exception ex){
            if (transaction != null){
                transaction.rollback();
            }
        }

    }
        public void updateEmployee(Employee e, long id){
            Transaction transaction = null;
            try (Session session = HibernateUtil.getSession()){
                    transaction = session.beginTransaction();
                    e = session.get(Employee.class, id);
                    e.setName(e.getName());
                    e.setSalary(e.getSalary());
                    transaction.commit();
            }catch (Exception ex){
                if (transaction != null){
                    transaction.rollback();
                }
            }
        }
}
