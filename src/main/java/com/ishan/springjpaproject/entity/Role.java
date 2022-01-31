package com.ishan.springjpaproject.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue
    private long id;
    @ManyToMany(mappedBy = "roles")
    private List<User> users;
    private String role;
}
