package by.ivc.okscertificate.dto;

public class WorkingTypeDTO {

    private Long id;
    private String name;

    public WorkingTypeDTO() {
    }

    public WorkingTypeDTO(Long id, String name) {
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

    public void setName(String name) {
        this.name = name;
    }
}
