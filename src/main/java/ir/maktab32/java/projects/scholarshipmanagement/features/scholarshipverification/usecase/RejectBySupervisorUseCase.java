package ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.UseCase;

@UseCase
public interface RejectBySupervisorUseCase {
    void reject(Long scholarshipId);
}
