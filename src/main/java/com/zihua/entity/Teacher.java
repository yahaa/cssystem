package com.zihua.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zihua on 17-1-25.
 * Teacher 实体，对应 Teacher 表
 * Teacher 和 Course 为多对多关系
 * Teacher 为主控方
 * Course 为被控方
 * 主键为 teacher_id
 * teacher_name 非空
 */
@Entity
public class Teacher implements Serializable {
    private int id;
    private String name;
    private Set<Course> course = new HashSet<Course>();

    @Id
    @Column(name = "teacher_id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "teacher_name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    @JoinTable(
            name = "open_course",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "crouse_id")
    )
    public Set<Course> getCourse() {
        return course;
    }

    public void setCourse(Set<Course> course) {
        this.course = course;
    }

    public boolean addCourse(Course c) {
        try {
            if (course.contains(c)) return false;
            course.add(c);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean deleCourseById(int cid) {
        for (Course t : course) {
            if (t.getId() == cid) {
                return course.remove(t);
            }
        }
        return false;
    }

    public boolean deleteCourseByName(String cname) {
        for (Course t : course) {
            if (t.getName() == cname) {
                return course.remove(t);
            }
        }
        return false;
    }
}
