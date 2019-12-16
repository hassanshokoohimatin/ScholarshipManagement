package ir.maktab32.java.projects.scholarshipmanagement.features.dashboard.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.dashboard.usecase.DashboardUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardUseCaseImpl implements DashboardUseCase {
    public void display() {
        Map<String, Integer> result = new HashMap<String, Integer>();
        User user = AuthenticationService.getInstance().getLoginUser();
        if (user == null)
            System.out.println("At first you have to login...\n");


        else {

           //for student
            if(user.getRole().equals("Student")) {
                try{
                    Connection connection = DatabaseConfig.getDatabaseConnection();
                    String sql = "select status, count(id) as countStatus from scholarship where requesterId = ? group by(status)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    preparedStatement.setLong(1, user.getId());
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String status = resultSet.getString("status");
                        int count = resultSet.getInt("countStatus");
                        result.put(status, count);
                    }
                    for (String status : result.keySet()) {
                        System.out.println("Status: " + status + "\tCount: " + result.get(status));
                        System.out.println("\n\n");
                    }
                }catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


             //for other users
            }
            else{
                try{
                    Connection connection = DatabaseConfig.getDatabaseConnection();
                    String sql = "select status, count(id) as countStatus from scholarship group by(status)";
                    PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        String status = resultSet.getString("status");
                        int count = resultSet.getInt("countStatus");
                        result.put(status, count);
                    }

                    for (String status : result.keySet()) {
                        System.out.println("Status: " + status + "\tCount: " + result.get(status));
                        System.out.println("\n\n");
                    }
                }catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}