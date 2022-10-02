package com.example.imageconventer.model.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@IdClass(User.class)
@Table(name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String userName;
    private String password;
    private boolean verified;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Image> images;
}
