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
    private boolean status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn( name = "username",insertable = true,updatable = true)
    private User user;
}
