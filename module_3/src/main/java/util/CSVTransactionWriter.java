package util;

import com.opencsv.CSVWriter;
import dto.TransactionDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.util.List;
import java.util.stream.Collectors;

public class CSVTransactionWriter {
    private static final Logger loggerInfo = LoggerFactory.getLogger("info");
    private static final Logger loggerError = LoggerFactory.getLogger("error");

    private final String fileName;
    private final String[] header =
            new String[]{"id", "date", "value", "categoryType", "accountName"};

    public CSVTransactionWriter(String fileName) {
        this.fileName = fileName;
    }

    public void createReport(List<TransactionDto> transactionDtos) {
        loggerInfo.info("Writing data to to file {}", fileName);
        try (CSVWriter writer = new CSVWriter(new FileWriter(fileName))) {
            writer.writeNext(header);
            writer.writeAll(transactionDtos
                    .stream()
                    .map(TransactionDto::toStringArray)
                    .collect(Collectors.toList())
            );
        } catch (Exception e) {
            loggerError.error("Cannot write to file", e);
            throw new RuntimeException("Error while creating report");
        }
    }
}
