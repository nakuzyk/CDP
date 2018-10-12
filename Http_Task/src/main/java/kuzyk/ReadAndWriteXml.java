package kuzyk;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadAndWriteXml {


    public StringBuffer readXml() throws IOException {

        String link = "http://10.23.149.167:9999/BookingTicket/getAvailableTicket.xml";
        URL obj = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response;
    }

    public void writeXml(StringBuffer response) throws IOException {

        FileWriter writer = new FileWriter(("all_tickets.xml"));
        writer.write(response.toString());
        writer.append('\n');
        writer.flush();
    }

}