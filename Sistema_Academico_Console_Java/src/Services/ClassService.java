package Services;

import Model.Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ClassService {
    ConnectionBD connectionBD = new ConnectionBD();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sqlStatement;


    public List<Classes> index() throws SQLException {
        sqlStatement = "select * from classes";
        resultSet = connectionBD.sqlResult(sqlStatement);
        List<Classes> classes = new ArrayList<>();
        while (resultSet.next()){
            Classes classe = new Classes();
            classe.setIdClass(resultSet.getInt("idClass"));
            classe.setClassName(resultSet.getString("className"));
            classe.setEdition(resultSet.getString("edition"));
            classe.setYear(resultSet.getDate("year"));
            classe.setState(resultSet.getString("state"));
            classes.add(classe);
        }
        return classes;
    }

    public boolean store(Classes classe){
        sqlStatement = "INSERT INTO classes (className, edition, year, state) VALUES (?, ?, ?, ?)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setString(1,classe.getClassName());
            preparedStatement.setString(2,classe.getEdition());
            preparedStatement.setString(3,simpleDateFormat.format(classe.getYear()));
            preparedStatement.setString(4,"aberta");
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return  true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id,Classes classe){
        sqlStatement = "UPDATE classes SET className = ?, edition = ?, year = ?, state = ? WHERE idClass = ?";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setString(1,classe.getClassName());
            preparedStatement.setString(2,classe.getEdition());
            preparedStatement.setString(3,simpleDateFormat.format(classe.getYear()));
            preparedStatement.setString(4,classe.getState());
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return  true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remove(int id){
        sqlStatement = "DELETE FROM classes WHERE idClass = ?;";
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public Classes show(int id){
        sqlStatement = "SELECT * FROM classes WHERE idClass = ?;";
        Classes classe = new Classes();
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                classe.setIdClass(resultSet.getInt("idClass"));
                classe.setClassName(resultSet.getString("className"));
                classe.setEdition(resultSet.getString("edition"));
                classe.setYear(resultSet.getDate("year"));
                classe.setState(resultSet.getString("state"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return classe;
    }
}
