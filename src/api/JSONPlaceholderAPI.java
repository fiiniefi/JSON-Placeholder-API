package api;
import java.io.*;
import java.net.*;

public class JSONPlaceholderAPI {
    private String url;

    public JSONPlaceholderAPI(String url){
        this.url = url;
    }

    public String getPosts() throws IOException{
        Posts p = new Posts(this.url);
        return p.getPosts();
    }
}


class Posts {
    private String url;

    Posts(String base_url) {
        this.url = base_url.concat("posts/");
    }

    String getPosts() throws IOException {
        HttpURLConnection connection = this.establish_connection();
        BufferedReader httpReader =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder posts = new StringBuilder();
        String line;

        while ((line = httpReader.readLine()) != null) {
            posts.append(line);
        }
        connection.disconnect();

        return posts.toString();
    }

    private HttpURLConnection establish_connection() throws IOException{
        URL postsURL = new URL(this.url);
        return (HttpURLConnection) postsURL.openConnection();
    }
}