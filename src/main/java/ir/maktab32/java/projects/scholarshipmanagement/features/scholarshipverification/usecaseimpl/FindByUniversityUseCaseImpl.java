package ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.scholarshipverification.usecase.FindByUniversityUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.Scholarship;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FindByUniversityUseCaseImpl implements FindByUniversityUseCase {
    public List<Scholarship> listScholarships(){
        User user = AuthenticationService.getInstance().getLoginUser();
        List<Scholarship> result = new ArrayList<Scholarship>();
        if(user != null && user.getRole().equals("University")){
            try{
                Connection connection = DatabaseConfig.getDatabaseConnection();
                String sql = "select * from scholarship where status = 'AcceptedByManager'";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    Scholarship scholarship = new Scholarship(
                            resultSet.getLong("id"),
                            resultSet.getString("status"),
                            resultSet.getString("name"),
                            resultSet.getString("family"),
                            resultSet.getString("nationalCode"),
                            resultSet.getString("lastUni"),
                            resultSet.getString("lastDegree"),
                            resultSet.getString("lastField"),
                            resultSet.getFloat("lastScore"),
                            resultSet.getString("applyUni"),
                            resultSet.getString("applyDegree"),
                            resultSet.getString("applyField"),
                            resultSet.getString("applyDate"),
                            resultSet.getLong("requesterId")
                    );
                    result.add(scholarship);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
