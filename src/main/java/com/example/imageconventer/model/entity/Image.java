package com.example.imageconventer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "images")
public class Image implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String imageFile;
    private String status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn( name = "id",referencedColumnName = "id", insertable = false, updatable = false)
    private User user;
}
