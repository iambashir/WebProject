package com.fmrasel;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
public class StudentController {

    private Student student;
    private List<Student> students;
    StudentService service = new StudentService();
    public void saveStudent(){
        service.save(student);
    }
    public void updateStudent(){
        service.update(student);
    }
    public void deleteStudent(int id){
        service.delete(new Student(id) );
    }
    public void displayData(int id){
       student=service.displayByID(id);
    }

    public Student getStudent() {
        if(student==null){
            student=new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        students= service.getAll();
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
