package com.agile.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class AgileItem {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    protected Long id;

    @Column(unique = true, nullable = false)
    protected String name;

    protected String summary;

    protected String description;

    @Column(columnDefinition = "enum('New','InProgressDevelopment',"
        + "'InProgressTesting','InProgressDefectFix',"
        + "'Done')")
    @Enumerated(EnumType.STRING)
    protected State state;

    public AgileItem(){}

    public AgileItem(String name, String summary, String description, State
        state){
        this.name = name;
        this.summary = summary;
        this.description = description;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
