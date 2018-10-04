package kuzyk;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ViewTicketsSold {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        String query = "http://10.23.149.167:9999/BookingTicket/getAvailableTicket.xml";

        HttpURLConnection connection = null;
        try {
            connection = (HttpURLConnection) new URL(query).openConnection();

            connection.setRequestMethod("GET");
            connection.setUseCaches(false);
            connection.setConnectTimeout(2500);
            connection.setReadTimeout(2500);

            connection.connect();

            StringBuilder sb = new StringBuilder();

            if (HttpURLConnection.HTTP_OK == connection.getResponseCode()) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line;
                while ((line = in.readLine()) != null) {
                    sb.append(line);
                    sb.append("\n");
                }
                FileWriter writer = new FileWriter(("tickets.xml"));
                String s = sb.toString();
                writer.write(s);
                writer.append('\n');
                writer.flush();
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Tickets t = new Tickets();

        t.getTicketsList();
        List<Tickets> tickets =  Tickets.ticketsList;
        Tickets.ticketsList.forEach(s -> System.out.println(s));

        File file = new File("tickets.txt");
        PrintWriter pw = new PrintWriter(file);

        List<Tickets> standartT = new ArrayList<>();
        for (Tickets q:Tickets.ticketsList
             ) {
            if(q.getCategory().equals("STANDART"))standartT.add(q);
        }
        pw.println(standartT);
        //pw.println(t.ticketsList);
        pw.close();
    }
}
