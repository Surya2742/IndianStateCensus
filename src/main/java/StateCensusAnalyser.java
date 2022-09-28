import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.*;
import java.util.ArrayList;

public class StateCensusAnalyser {

    File csvFile = new File("G:\\JAVA\\Intellij\\IndianCensus\\Census.csv");
    private ArrayList<CSVStateCensus> list;

    public ArrayList<CSVStateCensus> readInIndiaStateCensusData() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true)
                .addColumn("state").addColumn("population").addColumn("areaInSqKm")
                .addColumn("densityPerSqKm")
                .build();
        MappingIterator<CSVStateCensus> usersIter = csvMapper
                .readerWithTypedSchemaFor(CSVStateCensus.class)
                .with(csvSchema)
                .readValues(csvFile);
        list = (ArrayList<CSVStateCensus>) usersIter.readAll();
        return list;
    }
}
