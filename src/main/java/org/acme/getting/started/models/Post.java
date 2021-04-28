package org.acme.getting.started.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Post {
    @Id
    @GeneratedValue
    private Long id;
    private Date date;
    private String postTitle;
    private String postContent;
}