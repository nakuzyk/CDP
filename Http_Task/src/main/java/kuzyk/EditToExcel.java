package kuzyk;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class EditToExcel {


    public static Ticket[] parseFormJSonToTicketsList(String filePath) throws IOException {

        Gson gson = new Gson();
        String jsonData = FileUtils.readFileToString(new File(filePath), "UTF-8");
        Ticket[] tickets = gson.fromJson(jsonData, Ticket[].class);

        return tickets;
    }

    public static void getTicketsToExcel(Ticket[] tickets, String xlsFile) {

        try {

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("FirstSheet");

            HSSFRow rowHead = sheet.createRow((short) 0);
            rowHead.createCell(0).setCellValue("#");
            rowHead.createCell(1).setCellValue("Title");
            rowHead.createCell(2).setCellValue("Category");
            rowHead.createCell(3).setCellValue("Date");
            rowHead.createCell(4).setCellValue("ID");
            rowHead.createCell(5).setCellValue("Place");

            for (int i = 0; i < tickets.length; i++) {
                HSSFRow row = sheet.createRow((short) (i + 1));
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(tickets[i].getTitle());
                row.createCell(2).setCellValue(tickets[i].getCategory());
                row.createCell(3).setCellValue(tickets[i].getDate());
                row.createCell(4).setCellValue(tickets[i].getId());
                row.createCell(5).setCellValue(tickets[i].getPlace());
            }

            FileOutputStream fileOut = new FileOutputStream(xlsFile);
            workbook.write(fileOut);
            fileOut.close();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void addToExcel(String filePath, String xlsFile) throws IOException {

        getTicketsToExcel(parseFormJSonToTicketsList(filePath), xlsFile);
        System.out.println("\nExcel created.");
    }
}
