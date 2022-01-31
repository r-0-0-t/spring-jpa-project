package com.ishan.springjpaproject.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
@NoArgsConstructor
public class VoterId {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne(mappedBy = "voterId")
    private User user;
}
