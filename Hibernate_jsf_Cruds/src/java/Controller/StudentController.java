/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

@ManagedBean
public class StudentController {
    
    Student student=new Student();
    

    public Student getStudent() {
        
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    public void saveSt(){
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
         FacesContext.getCurrentInstance().addMessage("MessageId", new FacesMessage(FacesMessage.SEVERITY_INFO, "Save Successfull!", null));
    }
    
    public List<Student> getAllstudent(){
        List <Student> list = new ArrayList();
        
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
        session.beginTransaction();
        list = session.createCriteria(Student.class).list();
        session.getTransaction().commit();
        session.close();
        
        return list;
    }
    
    public void deleteSt(){
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();
        session.close();
         FacesContext.getCurrentInstance().addMessage("MessageIdUp", new FacesMessage(FacesMessage.SEVERITY_INFO, "Deleted Successfull!", null));
    }
    
    public void updateSt(){
        SessionFactory sessionFact = HibernateUtil.getSessionFactory();
        Session session = sessionFact.openSession();
        session.beginTransaction();
        session.saveOrUpdate(student);
        session.getTransaction().commit();
        session.close();
         FacesContext.getCurrentInstance().addMessage("MessageIdUp", new FacesMessage(FacesMessage.SEVERITY_INFO, "Updated Successfull!", null));
    }
}
