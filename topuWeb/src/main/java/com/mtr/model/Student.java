package com.mtr.model;

import com.mtr.utils.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class Student {

    private int id;
    private String name, email, course, area, address;
    private String[] education;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String[] getEducation() {
        return education;
    }

    public void setEducation(String[] education) {
        this.education = education;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    Connection con;
    private ArrayList studentLists;

    public ArrayList studentLists() {
        try {
            studentLists = new ArrayList();
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setCourse(rs.getString("course"));
                student.setArea(rs.getString("area"));
                String s = rs.getString("education");
                String[] arr = s.split(" ");
                student.setEducation(arr);
                student.setAddress(rs.getString("address"));

                studentLists.add(student);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return studentLists;
    }

    public void save() {
        try {
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into student (name, email, course, area, education, address) values(?,?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, course);
            ps.setString(4, area);
            StringBuilder sb = new StringBuilder();
            for (String s : education) {
                sb.append(s + " ");
            }
            ps.setString(5, sb.toString());
            ps.setString(6, address);

            System.out.println(ps.executeUpdate());

            ps.close();
            con.close();
            //System.out.println(name + " " + email + " " + course + " " + area + " " + education[0]);
        } catch (Exception e) {
        } finally {
            clear();
        }
    }

    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

    public void edit(int id) {
        System.out.println("id is: " + id);
        try {
            Student s;
            con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from student where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Student();
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setCourse(rs.getString("course"));
                s.setArea(rs.getString("area"));
                String e = rs.getString("education");
                String[] education = e.split(" ");
                s.setEducation(education);
                s.setAddress(rs.getString("address"));
                sessionMap.put("editStudent", s);
            }
            
        } catch (Exception e) {
        }
    }

    public void delete(int id) {
        System.out.println("delete id is: " + id);
    }

    private void clear() {
        name = null;
        email = null;
        address = null;
    }
}
