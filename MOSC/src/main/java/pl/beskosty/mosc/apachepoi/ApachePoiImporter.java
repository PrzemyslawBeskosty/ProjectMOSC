package pl.beskosty.mosc.apachepoi;

import java.io.InputStream;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pl.beskosty.mosc.entity.Contract;
import pl.beskosty.mosc.entity.Software;

/**
 *
 * @author Przemyslaw Beskosty
 */
public class ApachePoiImporter {

    private Workbook workbook;
    private List<Software> softwares;
    private boolean isXlsxFormat = false;
    private boolean isXlsFormat = false;
    private List<Contract> contracts = new ArrayList<>();

    private List<String> messagesList;
    private Map<Integer, String> columnMapping = new HashMap<>();

    /**
     * A constructor extracting data from a file.
     *
     * @param inputStream Data from the file.
     * @param fileName File name.
     * @param softwares List of systems needed to link to a contract....
     */
    public ApachePoiImporter(InputStream inputStream, String fileName, List<Software> softwares) {
        this.softwares = softwares;
        messagesList = new ArrayList<>();
        if (fileName.contains(".xlsx")) {
            isXlsxFormat = true;
        } else if (fileName.contains(".xls")) {
            isXlsFormat = true;
        } else {
            messagesList.add("Plik w złym formacie.");
            return;
        }
        try {
            if (isXlsxFormat) {
                workbook = new XSSFWorkbook(inputStream);
                initXLSXWorkbook();
            }
            if (isXlsFormat) {
                workbook = new HSSFWorkbook(inputStream);
            }
        } catch (Exception e) {

        }
    }

    /**
     * The function is called after receiving parameters. Extracts data from a
     * file and creates a list of objects from them.
     */
    private void initXLSXWorkbook() {
        //Get sheet. 
        XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(0);
        //Row iterator
        boolean firstRow = true;
        //Iterate over each row
        for (int rowNo = 0; rowNo < sheet.getLastRowNum(); rowNo++) {
            XSSFRow row = sheet.getRow(rowNo);
            Contract ctr = new Contract();
            int cols = 0;
            //Iterate over each column
            for (int cellNo = 0; cellNo < row.getLastCellNum(); cellNo++) {
                XSSFCell cell = row.getCell(cellNo);
                //For firstRow we prepare columnMapping. For rest we prepare data.                
                if (firstRow) {
                    columnMapping.put(cols, cell.getStringCellValue());
                } else {
                    String column = columnMapping.get(cols);
                    if (column.equals("system")) {
                        Software sft = null;
                        for (Software s : softwares) {
                            if (s.getName().equals(cell.getStringCellValue())) {
                                sft = s;
                            }
                        }
                        ctr.setClientSystem(sft);
                    } else if (column.equals("order_number")) {
                        ctr.setContractNumber(cell.getStringCellValue());

                    } else if (column.equals("from_date")) {
                        if (cell.getCellType().equals(CellType.NUMERIC) && DateUtil.isCellDateFormatted(cell)) {
                            ctr.setDateFrom(cell.getDateCellValue()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate());
                        }
                    } else if (column.equals("to_date")) {
                        if (cell.getCellType().equals(CellType.NUMERIC) && DateUtil.isCellDateFormatted(cell)) {
                            ctr.setDateTo(cell.getDateCellValue()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .toLocalDate());
                        }
                    } else if (column.equals("currency")) {
                        ctr.setCurrency(cell.getStringCellValue());
                    } else if (column.equals("amount")) {
                        if (cell.getCellType().equals(CellType.NUMERIC)) {
                            ctr.setAmount(cell.getNumericCellValue());
                        }
                    } else if (column.equals("amount_type")) {
                        ctr.setAmountType(cell.getStringCellValue());
                    } else if (column.equals("amount_period")) {
                        ctr.setAmountPeriod(cell.getStringCellValue());
                    } else if (column.equals("active")) {
                        String status = cell.getStringCellValue().equals("A") || cell.getStringCellValue().toLowerCase().equals("true") ? "A" : "N";
                        ctr.setStatus(status);
                    }
                }
                cols++;
            }
            if (!firstRow) {
                contracts.add(ctr);
            }
            if (firstRow) {
                firstRow = false;
            }
        }
    }

    /**
     * The function returns the contact list prepared in init.
     *
     * @return Returns the list of contracts.
     */
    public List<Contract> getContracts() {
        return contracts;
    }

}
