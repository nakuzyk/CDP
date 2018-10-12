package kuzyk;

import com.google.gson.Gson;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParseXml {

    public List editToList() throws ParserConfigurationException, IOException, SAXException {

        List<Ticket> ticketList = new ArrayList<>();

        File file = new File("all_tickets.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);

        NodeList ticketNodeList = document.getElementsByTagName("ticket");

        for (int i = 0; i < ticketNodeList.getLength(); i++) {
            if (ticketNodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element ticketElement = (Element) ticketNodeList.item(i);

                Ticket ticket = new Ticket();
                NodeList childNodes = ticketElement.getChildNodes();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    if (childNodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        Element childElement = (Element) childNodes.item(j);

                        String s = childElement.getNodeName();
                        if ("category".equals(s)) {
                            ticket.setCategory(childElement.getTextContent());

                        } else if ("date".equals(s)) {
                            ticket.setDate(childElement.getTextContent());

                        } else if ("id".equals(s)) {
                            ticket.setId(Integer.parseInt(childElement.getTextContent()));

                        } else if ("place".equals(s)) {
                            ticket.setPlace(Integer.parseInt(childElement.getTextContent()));

                        } else if ("title".equals(s)) {
                            ticket.setTitle(childElement.getTextContent());

                        }
                    }
                }
                ticketList.add(ticket);
            }
        }

        return ticketList;
    }

    public List<Ticket> getStandardTickets(List<Ticket> ticketList) {

        List<Ticket> standartTicketList = new ArrayList<>();

        for (int i = 0; i < ticketList.size(); i++) {
            if (ticketList.get(i).getCategory().equals("STANDART")) {
                standartTicketList.add(ticketList.get(i));
            }
        }

        System.out.println("\n");
        for (Ticket tct : standartTicketList) {
            System.out.println(tct);
        }
        return standartTicketList;
    }

    public void listToJson(List<Ticket> standartTicketList) throws IOException {

        Gson json = new Gson();

        File file = new File("ticket.json");
        PrintWriter pw = new PrintWriter(file);

        pw.println(json.toJson(standartTicketList));
        pw.close();
    }
}
