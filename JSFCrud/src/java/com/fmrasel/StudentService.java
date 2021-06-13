package com.fmrasel;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    public void save(Student st) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.save(st);
        tr.commit();
    }

    public void update(Student st) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.saveOrUpdate(st);
        tr.commit();
    }

    public void delete(Student st) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();
        session.delete(st);
        tr.commit();
    }

    public Student displayByID(int id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        tr.commit();
        return student;
    }

    public List<Student> getAll() {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();
        List<Student> students = session.createQuery("FROM Student").list();

        tr.commit();
        return students;
    }
}
