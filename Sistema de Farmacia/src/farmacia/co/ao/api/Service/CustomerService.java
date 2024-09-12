package farmacia.co.ao.api.Service;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import farmacia.co.ao.api.Database.Conection;
import farmacia.co.ao.api.Model.Customer;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    PreparedStatement preparedStatement;
    Conection conection = new Conection();
    ResultSet resultSet;
    private String sqlStatment;

    public String getAllCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        this.sqlStatment = "select * from customers order by name asc";
        this.resultSet = this.conection.sqlResult(this.sqlStatment);
        ResultSet resultSet1 = this.resultSet;
        try {
            while (resultSet1.next()){
                Customer customer = new Customer();
                customer.setId(resultSet1.getInt("id"));
                customer.setAddress(resultSet1.getString("address"));
                customer.setName(resultSet1.getString("name"));
                customer.setEmail(resultSet1.getString("email"));
                customer.setPhone(resultSet1.getString("phone"));
                customer.setTaxNumber(resultSet1.getString("tax_number"));
                customers.add(customer);
            }
            Gson gson = new Gson();
            return  gson.toJson(customers);
        } catch (SQLException e) {
            return null;
        }
    }



}
