package ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.UseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.Scholarship;
@UseCase
public interface RequestByStudentUseCase {
    void request(Scholarship scholarship);
}
