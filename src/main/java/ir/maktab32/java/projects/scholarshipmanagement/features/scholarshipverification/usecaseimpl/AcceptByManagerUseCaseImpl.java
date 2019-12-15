package ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase.AcceptByManagerUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class AcceptByManagerUseCaseImpl implements AcceptByManagerUseCase {
    public void accept(Long scholarshipId){
        User user = AuthenticationService.getInstance().getLoginUser();
        if(user != null && user.getRole().equals("Manager")){
            try {
                Connection connection = DatabaseConfig.getDatabaseConnection();
                String sql = "update scholarship set status = 'AcceptedByManager' where " +
                        "id = ? ";
                PreparedStatement preparedStatement =connection.prepareStatement(sql);
                preparedStatement.setLong(1, scholarshipId);
                preparedStatement.executeUpdate();
                System.out.println("accepted");
            }catch (SQLException e){
                e.printStackTrace();
            }catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
    }
}
