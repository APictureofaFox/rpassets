package rpassets.core.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListModel<E extends AssetEntity> {
    private File file;
    private List<E> items;

    public ListModel(String filepath) {
        this.file = new File(filepath);
        try {
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Reader reader = new InputStreamReader(new FileInputStream(this.file), "UTF-8")) {
            Gson gson = new GsonBuilder().create();
            Type listType = new TypeToken<ArrayList<E>>(){}.getType();
            this.items = gson.fromJson(reader, listType);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addItem(E item) {
        items.add(item);
    }

    public void saveFile() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(this.file), "UTF-8")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(items, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
