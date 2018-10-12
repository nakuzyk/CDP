package kuzyk;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {

       final String link = "http://10.23.149.167:9999/BookingTicket/bookTicket.json?userId=1";
       final String filePath = "ticket.json";
       final String tickets = "tickets.xls";

        ReadAndWriteXml readingXml = new ReadAndWriteXml();
        ParseXml parseXml = new ParseXml();

        readingXml.writeXml(readingXml.readXml());

        parseXml.listToJson(parseXml.getStandardTickets(parseXml.editToList()));
        new PostRequest().getPost(link);

        EditToExcel excel = new EditToExcel();
        excel.addToExcel(filePath, tickets);
    }
}
