package by.ivc.okscertificate.data.entity;

public class ServiceType {

    private Long id;
    private String name;
    private WorkingType workingType;

    public ServiceType() {
    }

    public ServiceType(Long id, String name, WorkingType workingType) {
        this.id = id;
        this.name = name;
        this.workingType = workingType;
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
