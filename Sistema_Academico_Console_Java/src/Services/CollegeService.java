package Services;

import Model.Colleges;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollegeService {
    ConnectionBD connectionBD = new ConnectionBD();
    String sqlStatment;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    public List<Colleges> index() throws SQLException {
        List<Colleges> colleges = new ArrayList<>();
        sqlStatment = "select * from colleges c inner join university u on u.idUniversity=c.idUniversity";
        resultSet= connectionBD.sqlResult(sqlStatment);
        while (resultSet.next()){
            Colleges college = new Colleges();
            college.setCollegeName(resultSet.getString("collegeName"));
            college.setIdUniversity(resultSet.getInt("idUniversity"));
            college.setUniversityName(resultSet.getString("UniversityName"));
            college.setFoundationData(resultSet.getDate("foundationDate"));
            college.setIdCollege(resultSet.getInt("idCollege"));
            colleges.add(college);
        }
        return  colleges;
    }

    public boolean store(Colleges college){
        sqlStatment = "insert into colleges(idUniversity,collegeName) values(?,?)";
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setString(1,college.getCollegeName());
            preparedStatement.setInt(2,college.getIdUniversity());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, Colleges college){
        sqlStatment = "update colleges set collegeName =?,idUniversity=? where idCollege=?";
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setString(1,college.getCollegeName());
            preparedStatement.setInt(2,college.getIdUniversity());
            preparedStatement.setInt(3,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            return  true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remove(int id){
        sqlStatment = "delete from colleges where idCollege=?";
        try {
            preparedStatement= connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            preparedStatement.close();
            return  true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Colleges show(int id){
        sqlStatment = "select * from colleges c inner join university u on u.idUniversity=c.idUniversity where idCollege=?";
        try {
            preparedStatement = connectionBD.getConnection().prepareStatement(sqlStatment);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            Colleges college = new Colleges();
            while (resultSet.next()){
                college.setCollegeName(resultSet.getString("collegeName"));
                college.setIdUniversity(resultSet.getInt("idUniversity"));
                college.setUniversityName(resultSet.getString("UniversityName"));
                college.setFoundationData(resultSet.getDate("foundationDate"));
                college.setIdCollege(resultSet.getInt("idCollege"));
            }
            resultSet.close();
            preparedStatement.close();
            return college;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
