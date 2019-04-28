package main;
import api.JSONPlaceholderAPI;
import java.io.IOException;
import java.io.StringReader;
import javax.json.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var js = new JSONPlaceholderAPI("https://jsonplaceholder.typicode.com/");
        //System.out.print(js.get_posts());

        //JsonReader jsonReader = Json.createReader(new StringReader(posts.toString()));
        //JsonArray postsJson = jsonReader.readArray();
        //jsonReader.close();
    }
}
