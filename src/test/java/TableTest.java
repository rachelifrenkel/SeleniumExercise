import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.annotations.Listeners;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Listeners(ExtentTestNGListener.class)
public class TableTest extends BaseTest {


    private final TablePage tablePage;
    ConfigReader configReader = new ConfigReader("src/main/resources/tableData.properties");
    String tableName = configReader.getProperty("table_name");
    String searchColumn = configReader.getProperty("search_column");
    String searchText = configReader.getProperty("search_text");
    String returnColumnText = configReader.getProperty("return_column_text");
    String expectedText = configReader.getProperty("expected_text");


    public TableTest() {
        tablePage = new TablePage(driver);
    }


    @Test
    @DisplayName("get table index and column,check the cell, verify get the expected text")
    public void testTable() {

        boolean isTableCellCorrect = tablePage.verifyTableCellTextWrapper(tableName, Integer.parseInt(searchColumn),
                searchText, Integer.parseInt(returnColumnText),
                expectedText);
        assertTrue(isTableCellCorrect, "verify get the expected text");
    }

    @Test
    @DisplayName("get table index and column,check the cell by xpath, verify get the expected text")
    public void testTableXpath() {

        String TableCellCorrect;
        try {
            TableCellCorrect = tablePage.getTableCellTextByXpathWrapper(tableName, Integer.parseInt(searchColumn),
                    searchText, Integer.parseInt(returnColumnText));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        assertEquals(TableCellCorrect, expectedText, "verify get the expected text");
    }

}
