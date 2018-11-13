package by.ivc.okssertificate.data.entity;

import java.util.Date;
import java.util.List;

public class QualificationCertificate {
    private Long id;
    private Organization organization;
    private Specialization specialization;
    private List<Function> functions;
    private String worker;
    private Position position;
    private int number;
    private Date startDate;
    private Date stopDate;

    public QualificationCertificate() {
    }

    public QualificationCertificate(Long id, Organization organization, Specialization specialization, List<Function> functions, String worker, Position position, int number, Date startDate, Date stopDate) {
        this.id = id;
        this.organization = organization;
        this.specialization = specialization;
        this.functions = functions;
        this.worker = worker;
        this.position = position;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(List<Function> functions) {
        this.functions = functions;
    }

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
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
