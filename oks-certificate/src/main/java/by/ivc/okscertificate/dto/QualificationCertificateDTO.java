package by.ivc.okscertificate.dto;

import java.util.Date;

public class QualificationCertificateDTO {

    private Long id;
    private Long organizationId;
    private String organizationName;
    private Long specializationId;
    private String specializationName;
    private String worker;
    private Long positionId;
    private String positionName;
    private int number;
    private Date startDate;
    private Date stopDate;

    public QualificationCertificateDTO() {
    }

    public QualificationCertificateDTO(Long id, Long organizationId, String organizationName, Long specializationId, String specializationName, String worker, Long positionId, String positionName, int number, Date startDate, Date stopDate) {
        this.id = id;
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.specializationId = specializationId;
        this.specializationName = specializationName;
        this.worker = worker;
        this.positionId = positionId;
        this.positionName = positionName;
        this.number = number;
        this.startDate = startDate;
        this.stopDate = stopDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStopDate() {
        return stopDate;
    }

    public void setStopDate(Date stopDate) {
        this.stopDate = stopDate;
    }
}
