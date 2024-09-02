package Services;

import Model.Designations;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesignationService {
    ConnectionBD connectionBD = new ConnectionBD();
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sqlStatment;

    public List<Designations> index() throws SQLException {
        List<Designations> designations = new ArrayList<>();
        sqlStatment = "SELECT m.idModule,m.idCourse,m.moduleName,m.abbreviation AS moduleAbbreviation,m.duration,d.idDesignation,d.nameDesignation,d.abbreviation AS designationAbbreviation FROM Modules m JOIN  Designations d ON m.idModule = d.idModule;";
        resultSet = connectionBD.sqlResult(sqlStatment);
        while (resultSet.next()){
            Designations designation = new Designations();
            designation.setIdDesignation(resultSet.getInt("idDesignation"));
            designation.setNameDesignation(resultSet.getString("nameDesignation"));
            designation.setAbbreviation(resultSet.getString("abbreviation"));
            designation.setIdModule(resultSet.getInt("idModule"));
            designation.setIdCourse(resultSet.getInt("idCourse"));
            designation.setModuleName(resultSet.getString("moduleName"));
            designation.setAbreviation(resultSet.getString("moduleAbbreviation"));
            designation.setDuration(resultSet.getInt("duration"));
            designations.add(designation);
        }
        return designations;
    }

    public boolean store(Designations designation){

        return true;
    }

    public boolean update(Designations designation){


        return false;
    }

    public boolean remove(int id){


        return false;
    }

    public Designations show(int id){


        return null;
    }
}
