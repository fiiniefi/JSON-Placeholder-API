package main;
import api.JSONPlaceholderAPI;

import java.io.*;
import javax.json.*;

public class Main {
    public static void main(String[] args) throws IOException {
        var postsJson = getPostsJson(
                new JSONPlaceholderAPI("https://jsonplaceholder.typicode.com/")
        );

        if(new File("posts").mkdir()) {
            for (JsonValue post : postsJson) {
                JsonValue postID = ((JsonObject) post).get("id");
                FileOutputStream stream = new FileOutputStream("posts/post_" + postID + ".txt");
                stream.write(post.toString().getBytes());
            }
        }
    }

    private static JsonArray getPostsJson(JSONPlaceholderAPI api) throws IOException {
        JsonReader jsonReader = Json.createReader(new StringReader(api.get_posts()));
        JsonArray postsJson = jsonReader.readArray();
        jsonReader.close();
        return postsJson;
    }
}
