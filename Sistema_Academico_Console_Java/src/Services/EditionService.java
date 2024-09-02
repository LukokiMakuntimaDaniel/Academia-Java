package Services;
import Model.Editions;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EditionService {
    private ConnectionBD dataConection = new ConnectionBD();
    private String sqlStatement;
    private ResultSet resultSet;
    PreparedStatement preparedStatement;

    public List<Editions> index(){
        try {
            List<Editions> editions = new ArrayList<>();
            sqlStatement = "select * from Editions";
            resultSet = dataConection.sqlResult(sqlStatement);
            while(resultSet.next()){
                Editions edition = new Editions();
                edition.setIdEdition(resultSet.getInt("idEdition"));
                edition.setDescription(resultSet.getString("description"));
                edition.setName(resultSet.getString("name"));
                edition.setStartDate(resultSet.getDate("startDate"));
                edition.setEndDate(resultSet.getDate("endDate"));
                editions.add(edition);
            }
            resultSet.close();
            dataConection.closeStatement();
            dataConection.closeConnection();
            return editions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean store(Editions edition){
        sqlStatement = "insert into editions(name,description,startDate,endDate) values(?,?,?,?)";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement = dataConection.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setString(1,edition.getName());
            preparedStatement.setString(2,edition.getDescription());
            preparedStatement.setString(3,simpleDateFormat.format(edition.getStartDate()) );
            preparedStatement.setString(4,simpleDateFormat.format(edition.getEndDate()));
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean update(int id, Editions edition){
        sqlStatement = "update editions set name=?,description=?,startDate=?,endDate=? where idEdition=?";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preparedStatement = dataConection.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setString(1,edition.getName());
            preparedStatement.setString(2,edition.getDescription());
            preparedStatement.setString(3,simpleDateFormat.format(edition.getStartDate()) );
            preparedStatement.setString(4,simpleDateFormat.format(edition.getEndDate()));
            preparedStatement.setInt(5,id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean remove(int id){
        sqlStatement = "delete from editions where idEdition =?";
        try {
            preparedStatement = dataConection.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            return  true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Editions show(int id){
        sqlStatement = "select * from editions where idEdition=?";
        Editions editions = new Editions();
        try {
            preparedStatement = dataConection.getConnection().prepareStatement(sqlStatement);
            preparedStatement.setInt(1,id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                editions.setName(resultSet.getString("name"));
                editions.setIdEdition(resultSet.getInt("idEdition"));
                editions.setStartDate(resultSet.getDate("startDate"));
                editions.setEndDate(resultSet.getDate("endDate"));
                editions.setDescription(resultSet.getString("description"));
            }
            return editions;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
