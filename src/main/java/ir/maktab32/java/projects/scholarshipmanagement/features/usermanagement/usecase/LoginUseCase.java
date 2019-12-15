package ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecase;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.UseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

@UseCase
public interface LoginUseCase {
    User login(String username , String password);
}
