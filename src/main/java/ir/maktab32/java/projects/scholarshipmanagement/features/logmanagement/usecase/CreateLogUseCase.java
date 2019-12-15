package ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecase;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.UseCase;

@UseCase
public interface CreateLogUseCase {
    void create(Long scholarshipId,String action);
}
