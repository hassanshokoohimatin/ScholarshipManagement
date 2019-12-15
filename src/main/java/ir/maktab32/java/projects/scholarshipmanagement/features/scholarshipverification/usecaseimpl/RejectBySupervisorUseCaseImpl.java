package ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecaseimpl.CreateLogUseCaseImpl;
import ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase.RejectBySupervisorUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class RejectBySupervisorUseCaseImpl implements RejectBySupervisorUseCase {
    public void reject(Long scholarshipId) {
        User user = AuthenticationService.getInstance().getLoginUser();
        if (user != null && user.getRole().equals("Supervisor")) {
            try {
                Connection connection = DatabaseConfig.getDatabaseConnection();
                String sql = "update scholarship set status = 'RejectedBySupervisor' where id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setLong(1, scholarshipId);
                preparedStatement.executeUpdate();
                System.out.println("rejected");
                new CreateLogUseCaseImpl().create(scholarshipId,"RejectedBySupervisor");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }
}
