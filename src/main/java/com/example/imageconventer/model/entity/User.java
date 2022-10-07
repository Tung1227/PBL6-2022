package com.example.imageconventer.model.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.UUIDGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Table(name = "users")
@IdClass(UserId.class)
public class User implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Id
    private String userName;
    @Column
    private String password;
    @Column
    private boolean verified;
    @Column
    private String email;
    @Column
    private String cookie;
    @Column
    private String token;

    @OneToMany(mappedBy = "user",fetch = FetchType.EAGER)
    private List<Image> images;
}
