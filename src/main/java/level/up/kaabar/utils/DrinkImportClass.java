package level.up.kaabar.utils;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class DrinkImportClass {
    public static void main(String[] args) throws Exception {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/my_crm");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1805");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        CSVReader reader = new CSVReaderBuilder(new FileReader("C:\\Users\\Alex\\Documents\\LevelUp\\KAA_BAR\\src\\main\\resources\\drinks2.csv"))
                .withSkipLines(1)
                .build();

        List<Object[]> params = reader.readAll().stream()
                .map($ -> new Object[]{$[0], $[1], $[2], $[3], $[4]})
                .collect(Collectors.toList());
try {
        jdbcTemplate.batchUpdate("insert into drinks (drinkname, brand, price, quantity, typ) values (?, ?, ?, ?, ?)", params);

}
catch (Exception e){
    System.out.println(e);

}
    }
/*
    private static double setPrice(String value){
        double price = Double.parseDouble(value);
        if (price < 0) {
            price = price *-1;
            return price;
        }else {
            return price;
        }
    }*/
    //}
}