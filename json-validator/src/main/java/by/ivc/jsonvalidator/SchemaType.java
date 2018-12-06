package by.ivc.jsonvalidator;

public enum SchemaType {
    CertificateType("/certificate-type-dto-schema.json"),
    Function("/function-dto-schema.json"),
    Organization("/organization-dto-schema.json"),
    Position("/position-dto-schema.json"),
    QualificationCertificate("/qualification-certificate-dto-schema.json"),
    ServiceType("/service-type-dto-schema.json"),
    Specialization("/specialization-dto-schema.json"),
    WorkingType("/working-type-dto-schema.json");

    private String schema;

    SchemaType(String schema) {
        this.schema = schema;
    }

    public String getSchema() {
        return schema;
    }
}
