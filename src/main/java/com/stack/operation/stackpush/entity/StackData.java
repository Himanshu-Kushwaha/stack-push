package com.stack.operation.stackpush.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.internal.util.collections.Stack;

@Entity
@Table(name = "StackTable")
public class StackData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "stack_elements")
    private Integer stackElements;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Transient
    private Integer pushData;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    

    public Integer getStackElements() {
        return stackElements;
    }

    public void setStackElements(Integer stackElements) {
        this.stackElements = stackElements;
    }
    
    public Integer getPushData() {
        return pushData;
    }

    public void setPushData(Integer pushData) {
        this.pushData = pushData;
    }

    
}

