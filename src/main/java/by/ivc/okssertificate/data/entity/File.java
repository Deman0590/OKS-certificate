package by.ivc.okssertificate.data.entity;

public class File {
    private long id;
    private String path;

    public File() {
    }

    public File(long id, String path) {
        this.id = id;
        this.path = path;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
