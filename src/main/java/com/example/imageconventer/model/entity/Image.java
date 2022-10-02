package com.example.imageconventer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String imageFile;
    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn( name = "id",insertable = false,updatable = false)
    private User user;
}
