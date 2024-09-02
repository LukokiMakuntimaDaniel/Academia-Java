package farmacia.co.ao.api.Database;

import java.sql.*;

public class Conection {
    private Statement statement;
    private ResultSet resultSet;
    private final Connection connection = getConnection();

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/farmacia";
            String username = "root";
            String password = "";
            return DriverManager.getConnection(jdbcUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(){
        try {
            this.connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet sqlResult(String sqlStament) {
        try {
            this.statement = this.connection.createStatement();
            this.resultSet = this.statement.executeQuery(sqlStament);
            return this.resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
