package com.bulut.todolist.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="todoitemdependency")
public class ToDoItemDependency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dependencyitem_id;

    private Long independencyitem_id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "list_id", referencedColumnName = "id")
    private ToDoList list_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDependencyitem_id() {
        return dependencyitem_id;
    }

    public void setDependencyitem_id(Long dependencyitem_id) {
        this.dependencyitem_id = dependencyitem_id;
    }

    public Long getIndependencyitem_id() {
        return independencyitem_id;
    }

    public void setIndependencyitem_id(Long independencyitem_id) {
        this.independencyitem_id = independencyitem_id;
    }
}