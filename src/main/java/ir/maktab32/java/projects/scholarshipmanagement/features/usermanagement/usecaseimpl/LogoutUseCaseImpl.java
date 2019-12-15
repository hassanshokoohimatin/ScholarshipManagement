package ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecase.LogoutUseCase;
@Service
public class LogoutUseCaseImpl implements LogoutUseCase {
    public void logout() {
        AuthenticationService.getInstance().setLoginUser(null);
    }
}
