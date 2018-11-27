package by.ivc.okscertificate.data.entity;

public class File {
    private Long id;
    private String name;

    public File() {
    }

    public File(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public void setName(String path) {
        this.name = path;
    }
}
