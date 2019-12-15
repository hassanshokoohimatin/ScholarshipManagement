package ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.UseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.Scholarship;

import java.util.List;

@UseCase
public interface FindByStudentUseCase {
    List<Scholarship> listScholarships();
}
