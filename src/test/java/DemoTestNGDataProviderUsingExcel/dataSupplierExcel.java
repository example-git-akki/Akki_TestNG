package DemoTestNGDataProviderUsingExcel;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;


public class dataSupplierExcel {

    @DataProvider(name = "enterExcelData")
    public String[][] getExcelData() throws Exception {

        FileInputStream fis = new FileInputStream("./src/test/resources/DataTestNg.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Sheet1");
        int noOfRows = sheet.getPhysicalNumberOfRows();
        int noOfColumns = sheet.getRow(0).getLastCellNum();
        System.out.println(noOfRows);
        System.out.println(noOfColumns);
        String[][] data = new String[noOfRows - 1][noOfColumns];
        for (int i = 0; i < noOfRows - 1; i++) {
            for (int j = 0; j < noOfColumns; j++) {
                DataFormatter df = new DataFormatter();
                data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));
            }
        }
        return data;
    }
}
