package Services;

import Model.University;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UniversityService {
    ConnectionBD connectionBD = new ConnectionBD();
    String sqlStatement;
    ResultSet resultSet;
    PreparedStatement preparedStatement;

    public List<University> index() throws SQLException {
        List<University> universities = new ArrayList<>();
        sqlStatement = "select * from university";
        resultSet = connectionBD.sqlResult(sqlStatement);
        while (resultSet.next()){
            University newUniversity = new University();
            newUniversity.setIdUniversity(resultSet.getInt("idUniversity"));
            newUniversity.setUniversityName(resultSet.getString("UniversityName"));
            newUniversity.setFoundationData(resultSet.getDate("foundationDate"));
            universities.add(newUniversity);
        }
        return universities;
    }

    public boolean store(University university){
        sqlStatement = "insert into university(UniversityName,foundationDate) values(?,?)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement= connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setString(1,university.getUniversityName());
            preparedStatement.setString(2,simpleDateFormat.format(university.getFoundationData()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id,University university){
        sqlStatement = "update university set UniversityName =?, foundationDate=? where idUniversity=?";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setString(1,university.getUniversityName());
            preparedStatement.setString(2,simpleDateFormat.format(university.getFoundationData()));
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean remove(int id){
        sqlStatement = "delete from university where idUniversity =?";
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public University show(int id){
        sqlStatement = "select * from university where idUniversity=?";
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            University university = new University();
            while (resultSet.next()){
                university.setIdUniversity(resultSet.getInt("idUniversity"));
                university.setUniversityName(resultSet.getString("UniversityName"));
                university.setFoundationData(resultSet.getDate("foundationDate"));
            }
            return university;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
