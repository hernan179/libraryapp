package com.library.app.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class State{

@Id
private Integer id;

private String name;

}