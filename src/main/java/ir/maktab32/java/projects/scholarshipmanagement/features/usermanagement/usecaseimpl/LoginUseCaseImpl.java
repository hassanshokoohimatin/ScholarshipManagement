package ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecaseimpl;

import ir.maktab32.java.projects.scholarshipmanagement.core.annotation.Service;
import ir.maktab32.java.projects.scholarshipmanagement.core.config.DatabaseConfig;
import ir.maktab32.java.projects.scholarshipmanagement.core.share.AuthenticationService;
import ir.maktab32.java.projects.scholarshipmanagement.features.usermanagement.usecase.LoginUseCase;
import ir.maktab32.java.projects.scholarshipmanagement.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class LoginUseCaseImpl implements LoginUseCase {
    public User login(String username , String password){

        try{
            Connection connection = DatabaseConfig.getDatabaseConnection();
            String sql = "select id , username , password , role from user where " +
                    "username = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("role")
                );
                AuthenticationService.getInstance().setLoginUser(user);
                System.out.println("you are logged in");
                return user;

            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        System.out.println("wrong username or password");
        return null;
    }
}
