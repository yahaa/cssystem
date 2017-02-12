package com.zihua.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zihua on 17-1-25.
 */
@Entity
public class Student implements Serializable {
    private int id;
    private String name;
    private Set<Course> courses = new HashSet<Course>();

    @Id
    @Column(name = "student_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "student_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "select_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public boolean addCourse(Course course) {
        try {
            courses.add(course);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public boolean deleteCourseById(int courseId) {
        for (Course t : courses) {
            if (t.getId() == courseId) {
                return courses.remove(t);
            }
        }
        return false;
    }

    public boolean deleteCourseByName(String cname) {
        for (Course t : courses) {
            if (t.getName() == cname) {
                return courses.remove(t);
            }
        }
        return false;
    }


}
