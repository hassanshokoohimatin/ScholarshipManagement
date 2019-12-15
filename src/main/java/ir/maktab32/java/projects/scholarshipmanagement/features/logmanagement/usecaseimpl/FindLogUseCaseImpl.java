package ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.features.logmanagement.usecase.FindLogUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindLogUseCaseImpl implements FindLogUseCase {
    public List<Log> listLogs(Long scholarshipId){
        List<Log> result = new ArrayList<Log>();
        try {
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String sql = "select * from log where scholarshipId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, scholarshipId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Long id = resultSet.getLong("id");
                String action = resultSet.getString("action");
                Long userId = resultSet.getLong("userId");
                String userRole = resultSet.getString("userRole");
                String date = resultSet.getString("date");
                result.add(new Log(id,action,userId,scholarshipId,userRole,date));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

}
