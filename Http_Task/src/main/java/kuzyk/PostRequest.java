package kuzyk;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class PostRequest {

    public void getPost(String link) throws IOException {

        HttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(link);
        request.setEntity(new StringEntity("[1]", ContentType.APPLICATION_JSON));
        HttpResponse response = httpclient.execute(request);

        System.out.println("\nResponse Code: " + response.getStatusLine().getStatusCode());

        if (response.getStatusLine().getStatusCode() == 200) {
            System.out.println("The ticket successfully booked");
        }
    }
}
