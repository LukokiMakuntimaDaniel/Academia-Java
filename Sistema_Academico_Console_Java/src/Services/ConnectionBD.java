package Services;

import java.sql.*;

public class ConnectionBD {
    private Statement statement;
     private ResultSet resultSet;

    private Connection connection = getConnection();
   
    public ResultSet getResultSet() {
        return resultSet;
    }

    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public Statement getStatement() {
        return statement;
    }

    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/sistemadegestaoacademica";
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

    public void closeStatement(){
        try {
            this.statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ResultSet sqlResult(String sqlStatment){
        try {
            this.statement = connection.createStatement();
            this.resultSet = this.statement.executeQuery(sqlStatment);
            return this.resultSet;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
