package com.mondee.service;

import com.mondee.model.Employee;
import com.mondee.model.Leave;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.Transaction;
import javax.persistence.Query;
import javax.transaction.*;
import java.util.List;

@Service
public class LeaveService {

    @Autowired
    private SessionFactory factory;

    public List<Leave> getApplicants(Employee employee){
        Session session=factory.getSessionFactory().openSession();
       Query query= session.createQuery("from Leave l where l.eid=:x");
       query.setParameter("x",employee.eid);
      List<Leave> leave = query.getResultList();
        return leave;
    }

    public List<Leave> myApplicants(String dept){
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("from Leave l where l.deptName=:x");
        query.setParameter("x",dept);
        List<Leave> leave= query.getResultList();
        return leave;
    }

    public void acceptApplication(int id) {
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("update Leave a set a.status=:y where a.id=:z");
        Transaction trx=session.beginTransaction();
        query.setParameter("y","Accepted");
        query.setParameter("z",id);
        query.executeUpdate();
        trx.commit();
    }

    public void rejectApplication(int id) {
        Session session=factory.getSessionFactory().openSession();
        Query query= session.createQuery("update Leave a set a.status=:y where a.id=:z");
        Transaction trx=session.beginTransaction();
        query.setParameter("y","Rejected");
        query.setParameter("z",id);
        query.executeUpdate();
        trx.commit();
    }

}

