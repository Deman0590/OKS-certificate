package by.ivc.okscertificate.dto;

public class FunctionDTO {

    private Long id;
    private String name;
    private Long specializationId;
    private String specializationName;

    public FunctionDTO() {
    }

    public FunctionDTO(Long id, String name, Long specializationId, String specializationName) {
        this.id = id;
        this.name = name;
        this.specializationId = specializationId;
        this.specializationName = specializationName;
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

    public Long getSpecializationId() {
        return specializationId;
    }

    public void setSpecializationId(Long specializationId) {
        this.specializationId = specializationId;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }
}
