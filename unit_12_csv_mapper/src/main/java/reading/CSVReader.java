package reading;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    private static final String CSV = "unit_12_csv_mapper/src/main/resources/input.csv";
    public List<String[]> readCsvFile(){
        Path path = Paths.get(CSV);
        try {
            List<String> rows = Files.readAllLines(path);
            List<String[]> values = new ArrayList<>();
            for (String row : rows) {
                String[] splitRow = row.split(",");
                for (int i = 0; i < splitRow.length; i++) {
                    splitRow[i] = splitRow[i].trim();
                }
                values.add(splitRow);
            }
            return values;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
