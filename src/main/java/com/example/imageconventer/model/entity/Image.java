package com.example.imageconventer.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    @Column
    private String imageFile;
    @Column
    private String status;

    @ManyToOne
    @JoinColumn( name = "id",insertable = false,updatable = false)
    private User user;
}
