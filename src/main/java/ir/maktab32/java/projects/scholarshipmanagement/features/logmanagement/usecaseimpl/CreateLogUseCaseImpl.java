package ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecase.CreateLogUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class CreateLogUseCaseImpl implements CreateLogUseCase {
    public void create(Long scholarshipId, String action) {
        User user = AuthenticationService.getInstance().getLoginUser();

        if (user != null){
            Long currentTime = System.currentTimeMillis();
            SimpleDateFormat formatDate = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
            java.util.Date date = new Date(currentTime);
            String stringDate = formatDate.format(date);
            try {
                Connection connection = DatabaseConfig.getDatabaseConnection();
                String sql = "insert into log(action, userId, userRole, date, scholarshipId) " +
                        "values(?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, action);
                preparedStatement.setLong(2, user.getId());
                preparedStatement.setString(3, user.getRole());
                preparedStatement.setString(4, stringDate);
                preparedStatement.setLong(5, scholarshipId);
                preparedStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
