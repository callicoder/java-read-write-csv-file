import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by rajeevkumarsingh on 25/09/17.
 */
public class OpenCSVReadAndParseToBean {
    private static final String SAMPLE_CSV_FILE_PATH = "./users-with-header.csv";

    public static void main(String[] args) throws IOException {

        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CSVUser> CSVUsers = csvToBean.parse();

            for (CSVUser CSVUser : CSVUsers) {
                System.out.println("Name : " + CSVUser.getName());
                System.out.println("Email : " + CSVUser.getEmail());
                System.out.println("PhoneNo : " + CSVUser.getPhoneNo());
                System.out.println("Country : " + CSVUser.getCountry());
                System.out.println("---------------------------");
            }
        }
    }
}


