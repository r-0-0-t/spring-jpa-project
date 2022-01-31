package com.ishan.springjpaproject.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    @ManyToMany
    @JoinTable(name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    private List<Role> roles;

    @OneToOne
    private VoterId voterId;

    public VoterId getVoterId() {
        return voterId;
    }

    public void setVoterId(VoterId voterId) {
        this.voterId = voterId;
    }

    public User(String username, String firstName, String lastName) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = new ArrayList<Role>();
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
