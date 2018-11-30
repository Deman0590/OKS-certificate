package by.ivc.okscertificate.data.entity;

import java.util.Date;
import java.util.List;

public class ComplianceCertificate {

    private Long id;
    private CertificateType certificateType;
    private ServiceType serviceType;
    private Date startDate;
    private Date endDate;
    private List<File> files;
    private List<Organization> organizations;
    private List<WorkingType> workingTypes;

    public ComplianceCertificate() {
    }

    public ComplianceCertificate(Long id, CertificateType certificateType, ServiceType serviceType, Date startDate, Date endDate, List<File> files, List<Organization> organizations, List<WorkingType> workingTypes) {
        this.id = id;
        this.certificateType = certificateType;
        this.serviceType = serviceType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.files = files;
        this.organizations = organizations;
        this.workingTypes = workingTypes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CertificateType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<WorkingType> getWorkingTypes() {
        return workingTypes;
    }

    public void setWorkingTypes(List<WorkingType> workingTypes) {
        this.workingTypes = workingTypes;
    }
}
