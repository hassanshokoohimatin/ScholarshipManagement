package ir.maktab32.java.projects.scholarshipmanagement.model;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Entity;
import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Id;

@Entity
public class Log {
    @Id
    private Long id;
    private String action;
    private Long userId;
    private Long scholarshipId;
    private String userRole;
    private String date;

    public Log(Long id, String action, Long userId, Long scholarshipId, String userRole, String date) {
        this.id = id;
        this.action = action;
        this.userId = userId;
        this.scholarshipId = scholarshipId;
        this.userRole = userRole;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", action='" + action + '\'' +
                ", userId=" + userId +
                ", scholarshipId=" + scholarshipId +
                ", userRole='" + userRole + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
