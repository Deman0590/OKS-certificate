package by.ivc.okssertificate.data.entity;

public class ServiceType {

    private long id;
    private String name;
    private WorkingType workingType;

    public ServiceType() {
    }

    public ServiceType(long id, String name, WorkingType workingType) {
        this.id = id;
        this.name = name;
        this.workingType = workingType;
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

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void setWorkingType(WorkingType workingType) {
        this.workingType = workingType;
    }
}
