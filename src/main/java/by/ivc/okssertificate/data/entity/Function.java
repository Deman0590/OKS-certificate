package by.ivc.okssertificate.data.entity;

public class Function {

    private long id;
    private String name;
    private Specialization specialization;

    public Function() {
    }

    public Function(long id, String name, Specialization specialization) {
        this.id = id;
        this.name = name;
        this.specialization = specialization;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
