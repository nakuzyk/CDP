package kuzyk;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tickets {
    Tickets() throws ParserConfigurationException, IOException, SAXException {}

    private String category;
    private String date;
    private int id;
    private int place;
    private String title;

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    public int getId() {
        return id;
    }

    public int getPlace() {
        return place;
    }

    public String getTitle() {
        return title;
    }

    File file = new File("tickets.xml");

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        static List<Tickets> ticketsList = new ArrayList<>();
        List<Tickets> filmsList = new ArrayList<>();

        void getTicketsList() throws IOException, ParserConfigurationException, SAXException {
         //   Element ticketsElement = (Element) document.getElementsByTagName("tickets").item(0);
            NodeList ticketNodeList = document.getElementsByTagName("ticket");


            for (int j = 0; j < ticketNodeList.getLength(); j++) {
                if (ticketNodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element ticketElement = (Element) ticketNodeList.item(j);

                    Tickets ticket = new Tickets();
                    Tickets f = new Tickets();

                    NodeList childNodes = ticketElement.getChildNodes();

                    for (int i = 0; i < childNodes.getLength(); i++) {
                        if (childNodes.item(i).getNodeType() == Node.ELEMENT_NODE) {

                            Element childElement = (Element) childNodes.item(i);

                            switch (childElement.getNodeName()) {
                                case "category":
                                    ticket.setCategory(childElement.getTextContent());
                                    break;
                                case "date":
                                    ticket.setDate(childElement.getTextContent());
                                    break;
                                case "id":
                                    ticket.setId(Integer.valueOf(childElement.getTextContent()));
                                    break;
                                case "place":
                                    ticket.setPlace(Integer.valueOf(childElement.getTextContent()));
                                    break;
                                case "title":
                                    ticket.setTitle(childElement.getTextContent());
                                    break;
                            }
                        }
                    }
                    ticketsList.add(ticket);
                }

            }

        }
    @Override
    public String toString() {
        return "Ticket{" +
                "category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", id=" + id +
                ", place=" + place +
                ", title='" + title + '\'' +
                '}';
    }
}
