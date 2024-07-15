package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private final EntityManager em;

    @Autowired
    public EmployeeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Employee> findAll() {
        return em.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return em.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return em.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = em.find(Employee.class, id);
        em.remove(employee);
    }
}
