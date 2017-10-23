package javaapplication72;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class GetExample {
  OkHttpClient client = new OkHttpClient();

  
  String run(String url) throws IOException {
    Request request = new Request.Builder()
        .url(url)
            //api key
        .addHeader("user-key", "")
            
        
        .build();
   
    

    try (Response response = client.newCall(request).execute()) {
      return response.body().string();
    }
  }

  public static void main(String[] args) throws IOException {
      File file = new File("izmir.json");
      
        if (!file.exists()) {
            file.createNewFile();
        }
    GetExample example = new GetExample();
    List list = new ArrayList(); 
      
  String response = example.run("https://developers.zomato.com/api/v2.1/search?entity_id=376&entity_type=city");
   System.out.println(response);
    FileWriter fileWriter = new FileWriter(file, false);
        BufferedWriter bWriter = new BufferedWriter(fileWriter);
        bWriter.write(response);
        bWriter.close();
      
  }
}