package com.skdev;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Todo {
    @Id
    @SequenceGenerator(
            sequenceName = "todo_id_sequence",
            name = "todo_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "todo_id_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int id;
    private String text;
    private boolean isDone;
    Todo(String text, boolean isDone) {
       this.text = text;
       this.isDone = isDone;
    }

    Todo(){}

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return this.isDone;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return getId() == todo.getId() && isDone() == todo.isDone() && Objects.equals(getText(), todo.getText());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getText(), isDone());
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", isDone=" + isDone +
                '}';
    }
}
