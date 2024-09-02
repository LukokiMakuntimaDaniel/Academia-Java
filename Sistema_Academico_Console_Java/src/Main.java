import Model.Editions;
import Model.University;
import Services.CollegeService;
import Services.EditionService;
import Services.Encriptation;
import Services.UniversityService;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Main {
    public static void main(String[] args) {
/*
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate startDate = LocalDate.parse("2024-06-21",dateTimeFormatter);
        LocalDate endDate = LocalDate.parse("2024-07-21",dateTimeFormatter);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = simpleDateFormat.parse("2024-06-21");
            endDate = simpleDateFormat.parse("2024-07-21");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        System.out.println(startDate);


        EditionService editionService = new EditionService();
        Editions editions = new Editions();
        editions.setName("kova");
        editions.setDescription("muita coisa");
        editions.setStartDate(startDate);
        editions.setEndDate(endDate);
       // editionService.store(editions);
        //editionService.store(editions);
       // editionService.remove(4);

        System.out.println(editionService.show(3).toString());
        //System.out.println(editionService.index().get(1).getName());



        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = simpleDateFormat.parse("2024-06-21");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        UniversityService universityService = new UniversityService();
        University university = new University();
        university.setUniversityName("colha");
        university.setFoundationData(startDate);
        universityService.update(3,university);

 */

        /*CollegeService collegeService = new CollegeService();
        System.out.println(collegeService.show(1).getFoundationData());*/
        Encriptation encriptation = new Encriptation();
        System.out.println(encriptation.encryptPassword("Lukoki Daniel"));
        System.out.println(encriptation.encryptPassword("Lukoki Daniel"));



    }
}