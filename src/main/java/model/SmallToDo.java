package model;

import java.util.Objects;

public class SmallToDo {

    private long id;
    private boolean isDone;
    private String comment;

    public SmallToDo(long id, boolean isDone, String comment) {
        this.id = id;
        this.isDone = isDone;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public boolean isDone() {
        return isDone;
    }

    public String getComment() {
        return comment;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "SmallToDo{" +
                "id=" + id +
                ", isDone=" + isDone +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallToDo smallToDo = (SmallToDo) o;
        return id == smallToDo.id &&
                isDone == smallToDo.isDone &&
                Objects.equals(comment, smallToDo.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isDone, comment);
    }
}
