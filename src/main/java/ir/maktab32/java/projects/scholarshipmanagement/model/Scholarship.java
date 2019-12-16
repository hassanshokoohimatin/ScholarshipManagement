package ir.maktab32.java.projects.scholarshipmanagement.model;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Entity;
import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Id;

@Entity
public class Scholarship {

    @Id
    private Long id;
    private String status;
    private String name;
    private String family;
    private String nationalCode;
    private String lastUni;
    private String lastDegree;
    private String lastField;
    private float lastScore;
    private String applyUni;
    private String applyDegree;
    private String applyField;
    private String applyDate;
    private Long requesterId;

    public Scholarship(Long id, String status, String name, String family, String nationalCode, String lastUni, String lastDegree, String lastField, float lastScore, String applyUni, String applyDegree, String applyField, String applyDate, Long requesterId) {
        this.id = id;
        this.status = status;
        this.name = name;
        this.family = family;
        this.nationalCode = nationalCode;
        this.lastUni = lastUni;
        this.lastDegree = lastDegree;
        this.lastField = lastField;
        this.lastScore = lastScore;
        this.applyUni = applyUni;
        this.applyDegree = applyDegree;
        this.applyField = applyField;
        this.applyDate = applyDate;
        this.requesterId = requesterId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getLastUni() {
        return lastUni;
    }

    public void setLastUni(String lastUni) {
        this.lastUni = lastUni;
    }

    public String getLastDegree() {
        return lastDegree;
    }

    public void setLastDegree(String lastDegree) {
        this.lastDegree = lastDegree;
    }

    public String getLastField() {
        return lastField;
    }

    public void setLastField(String lastField) {
        this.lastField = lastField;
    }

    public float getLastScore() {
        return lastScore;
    }

    public void setLastScore(float lastScore) {
        this.lastScore = lastScore;
    }

    public String getApplyUni() {
        return applyUni;
    }

    public void setApplyUni(String applyUni) {
        this.applyUni = applyUni;
    }

    public String getApplyDegree() {
        return applyDegree;
    }

    public void setApplyDegree(String applyDegree) {
        this.applyDegree = applyDegree;
    }

    public String getApplyField() {
        return applyField;
    }

    public void setApplyField(String applyField) {
        this.applyField = applyField;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Long getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(Long requesterId) {
        this.requesterId = requesterId;
    }

    @Override
    public String toString() {
        return "Scholarship{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", lastUni='" + lastUni + '\'' +
                ", lastDegree='" + lastDegree + '\'' +
                ", lastField='" + lastField + '\'' +
                ", lastScore=" + lastScore +
                ", applyUni='" + applyUni + '\'' +
                ", applyDegree='" + applyDegree + '\'' +
                ", applyField='" + applyField + '\'' +
                ", applyDate='" + applyDate + '\'' +
                ", requesterId=" + requesterId +
                '}';
    }
}
