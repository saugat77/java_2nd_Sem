package PhoneBook;

import PhoneBook.Helpers.DBUtils;

import java.sql.*;

public class UserRegistration {
    private Connection con;

    public UserRegistration() {
        try {
            con = DBUtils.getDbConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    ResultSet get() {
        try {
            String select = "SELECT * FROM phone";
            PreparedStatement statement = con.prepareStatement(select);
            return statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    void insert(String firstName, String lastName, String phoneNumber) {
        try {
            String insert = "INSERT INTO users (first_name, last_name, phone_number) " +
                "VALUES (?,?,?)";
            PreparedStatement statement = con.prepareStatement(insert);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);
            
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void update(int id, String firstName, String lastName,  String phoneNumber
    ) {
        try {
            String update = "UPDATE users SET first_name = ?, last_name=?, phone_no.=?" +
                " WHERE  id = ?";
            PreparedStatement statement = con.prepareStatement(update);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phoneNumber);

            statement.setInt(4, id);

            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void delete(int id){
        String delete = "DELETE FROM users WHERE id = ?";

        try {
            PreparedStatement statement = con.prepareStatement(delete);
            statement.setInt(1, id);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
