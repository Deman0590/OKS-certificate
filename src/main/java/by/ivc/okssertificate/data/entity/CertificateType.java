package by.ivc.okssertificate.data.entity;

public class CertificateType {

    private Long id;
    private String name;

    public CertificateType() {
    }

    public CertificateType(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
