package rehlitskiy;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;

public class SaveRead {

    public void saveJson(Films students, String fileName) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileWriter writer = new FileWriter(fileName);
        writer.write(gson.toJson(students));
        writer.close();
    }
    public Films readJson(String fileName) throws FileNotFoundException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(fileName));
        return gson.fromJson(bufferedReader, Films.class);
    }
}