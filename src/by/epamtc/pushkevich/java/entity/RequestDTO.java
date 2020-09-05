package by.epamtc.pushkevich.java.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Objects;

public class RequestDTO implements Serializable {
    public static final long serialVersionUID = 1L;
    private File file;
    private String action;

    public RequestDTO() {
    }

    public RequestDTO(File file, String action) {
        this.file = file;
        this.action = action;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RequestDTO that = (RequestDTO) o;
        return Objects.equals(file, that.file) &&
                Objects.equals(action, that.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, action);
    }

    @Override
    public String toString() {
        return "RequestDTO{" +
                "file=" + file +
                ", action='" + action + '\'' +
                '}';
    }
}
