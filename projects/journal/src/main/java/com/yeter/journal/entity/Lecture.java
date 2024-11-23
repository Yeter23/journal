package com.yeter.journal.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "lectures")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Lecture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  Integer id;
    public Integer getTeacherId(){
        return teacher.getId();
    }

    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private User teacher;
    @ManyToMany
    @JoinTable(name = "user_lectures",
    joinColumns = {@JoinColumn(name = "lecture_id",referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")})
    private List<User> student;
}
