package Services;

import Model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    ConnectionBD connectionBD = new ConnectionBD();
    PreparedStatement preparedStatement;
    String sqlStatment;
    ResultSet resultSet;

    public List<Users> index() throws SQLException {
        List<Users> users = new ArrayList<>();
        sqlStatment="select * from users";
        resultSet = connectionBD.sqlResult(sqlStatment);
        while (resultSet.next()){
            Users user = new Users();
            user.setIdUser(resultSet.getInt("idUser"));
            user.setNameUser(resultSet.getString("nameUser"));
            user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
            user.setNationality(resultSet.getString("nationality"));
            user.setNumberOfBi(resultSet.getString("numberOfBi"));
            user.setPassport(resultSet.getString("passport"));
            user.setDateOfIssue(resultSet.getDate("dateOfIssue"));
            user.setExpirationDate(resultSet.getDate("expirationDate"));
            user.setGender(resultSet.getString("gender"));
            user.setEmail(resultSet.getString("email"));
            user.setTelephone(resultSet.getString("telephone"));
            user.setPassword(resultSet.getString("password"));
            user.setUserType(resultSet.getString("userType"));
            user.setMunicipality(resultSet.getString("municipality"));
            user.setNeighborhood(resultSet.getString("neighborhood"));
            users.add(user);
        }
        return users;
    }

    public boolean store(Users user){
        Encriptation encriptation = new Encriptation();
        String encriptString = encriptation.encryptPassword(user.getPassword());
        sqlStatment ="INSERT INTO users (nameUser, dateOfBirth, nationality, numberOfBi, passport, dateOfIssue, expirationDate, gender, email, telephone, password, userType, municipality, neighborhood) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement= connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setString(1,user.getNameUser());
            preparedStatement.setString(2,simpleDateFormat.format(user.getDateOfBirth()));
            preparedStatement.setString(3,user.getNationality());
            preparedStatement.setString(4,user.getNumberOfBi());
            preparedStatement.setString(5,user.getPassport());
            preparedStatement.setString(6,simpleDateFormat.format(user.getDateOfIssue()));
            preparedStatement.setString(7,simpleDateFormat.format(user.getExpirationDate()));
            preparedStatement.setString(8,user.getGender());
            preparedStatement.setString(9,user.getEmail());
            preparedStatement.setString(10,user.getTelephone());
            preparedStatement.setString(11,encriptString);
            preparedStatement.setString(12,user.getUserType());
            preparedStatement.setString(13,user.getMunicipality());
            preparedStatement.setString(14,user.getNeighborhood());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean update(int id,Users user){
        sqlStatment = "UPDATE users SET nameUser = ?, dateOfBirth = ?, nationality = ?, numberOfBi = ?, passport = ?, dateOfIssue = ?, expirationDate = ?, gender = ?, email = ?, telephone = ?, password = ?, userType = ?, municipality = ?, neighborhood = ? WHERE idUser = ?;";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement= connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setString(1,user.getNameUser());
            preparedStatement.setString(2,simpleDateFormat.format(user.getDateOfBirth()));
            preparedStatement.setString(3,user.getNationality());
            preparedStatement.setString(4,user.getNumberOfBi());
            preparedStatement.setString(5,user.getPassport());
            preparedStatement.setString(6,simpleDateFormat.format(user.getDateOfIssue()));
            preparedStatement.setString(7,simpleDateFormat.format(user.getExpirationDate()));
            preparedStatement.setString(8,user.getGender());
            preparedStatement.setString(9,user.getEmail());
            preparedStatement.setString(10,user.getTelephone());
            preparedStatement.setString(11,user.getPassport());
            preparedStatement.setString(12,user.getUserType());
            preparedStatement.setString(13,user.getMunicipality());
            preparedStatement.setString(14,user.getNeighborhood());
            preparedStatement.setInt(15,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public boolean remove(int id){
        sqlStatment = "DELETE FROM users WHERE idUser=?";
        try {
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public Users show(int id){
        sqlStatment = "SELECT * FROM users WHERE idUser = ?;";
        try {
            Users user = new Users();
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setIdUser(resultSet.getInt("idUser"));
                user.setNameUser(resultSet.getString("nameUser"));
                user.setDateOfBirth(resultSet.getDate("dateOfBirth"));
                user.setNationality(resultSet.getString("nationality"));
                user.setNumberOfBi(resultSet.getString("numberOfBi"));
                user.setPassport(resultSet.getString("passport"));
                user.setDateOfIssue(resultSet.getDate("dateOfIssue"));
                user.setExpirationDate(resultSet.getDate("expirationDate"));
                user.setGender(resultSet.getString("gender"));
                user.setEmail(resultSet.getString("email"));
                user.setTelephone(resultSet.getString("telephone"));
                user.setPassword(resultSet.getString("password"));
                user.setUserType(resultSet.getString("userType"));
                user.setMunicipality(resultSet.getString("municipality"));
                user.setNeighborhood(resultSet.getString("neighborhood"));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
