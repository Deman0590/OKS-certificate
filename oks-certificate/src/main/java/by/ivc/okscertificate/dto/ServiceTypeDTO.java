package by.ivc.okscertificate.dto;

public class ServiceTypeDTO {

    private Long id;
    private String name;
    private Long workingTypeId;
    private String workingTypeName;

    public ServiceTypeDTO() {
    }

    public ServiceTypeDTO(Long id, String name, Long workingTypeId, String workingTypeName) {
        this.id = id;
        this.name = name;
        this.workingTypeId = workingTypeId;
        this.workingTypeName = workingTypeName;
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

    public Long getWorkingTypeId() {
        return workingTypeId;
    }

    public void setWorkingTypeId(Long workingTypeId) {
        this.workingTypeId = workingTypeId;
    }

    public String getWorkingTypeName() {
        return workingTypeName;
    }

    public void setWorkingTypeName(String workingTypeName) {
        this.workingTypeName = workingTypeName;
    }
}
