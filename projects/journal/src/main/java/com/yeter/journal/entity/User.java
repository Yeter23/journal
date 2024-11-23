package com.yeter.journal.entity;

import com.yeter.journal.enums.Gender;
import com.yeter.journal.enums.Role;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private  Integer id;
    @Column
    private String identityNo;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

}
