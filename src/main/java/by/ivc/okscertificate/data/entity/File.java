package by.ivc.okscertificate.data.entity;

public class File {
    private Long id;
    private String path;

    public File() {
    }

    public File(Long id, String path) {
        this.id = id;
        this.path = path;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}