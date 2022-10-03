package com.example.imageconventer.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String userName;
    @Column
    private String password;
    @Column
    private boolean verified;
    @Column
    private String cookie;
    @Column
    private String token;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Image> images;
}
