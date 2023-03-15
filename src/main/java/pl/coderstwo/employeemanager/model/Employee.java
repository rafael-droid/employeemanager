package pl.coderstwo.employeemanager.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class Employee implements Serializable { //serializable pomaga w zmianie formatu np. json
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;
}
