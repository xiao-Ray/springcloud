package com.springcloud.commoncore.entity;

import java.io.Serializable;

public class Blog implements Serializable {

    private static final long serialVersionUID = 428988244025691167L;
    private Long id;
    private String name;
    private String content;

    public Blog(Long id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
