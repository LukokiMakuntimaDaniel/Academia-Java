package Services;

import Controlers.CourseController;
import Model.Courses;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CourseService {
    ConnectionBD connectionBD = new ConnectionBD();
    ResultSet resultSet;
    String sqlStatment;
    public List<Courses> index() throws SQLException {
        sqlStatment = "select * from courses";
        List<Courses> courses = new ArrayList<>();
        resultSet = connectionBD.sqlResult(sqlStatment);
        while (resultSet.next()){
            Courses newCourse = new Courses();
             //newCourse.setNameCourse();

        }
        return null;
    }

    public boolean store(Courses course){

        return true;
    }

    public boolean update(Courses course){


        return false;
    }

    public boolean remove(int id){


        return false;
    }

    public CourseController show(int id){


        return null;
    }
}
