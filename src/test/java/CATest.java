import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

public class CATest {
    private static final String path = "G:\\JAVA\\Intellij\\IndianCensus\\src\\main\\resources\\Census.csv";
    @Test
    public void givenIndianCensusCSVFile_WhenLoad_ShouldReturnCorrectRecords() throws IOException {
        StateCensusAnalyser censusAnalyzer = new StateCensusAnalyser();
        ArrayList<CSVStateCensus> list = censusAnalyzer.readInIndiaStateCensusData();
        Assert.assertEquals(29, list.size());
    }
}
