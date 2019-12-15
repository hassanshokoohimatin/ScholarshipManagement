package ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecase;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.UseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.Log;

import java.util.List;

@UseCase
public interface FindLogUseCase {
    List<Log> listLogs(Long scholarshipId);
}
