package rpassets.core.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListModel<E extends AssetEntity> {
    private final File file;
    private List<E> items;

    public ListModel(Class<E> clazz, String filepath) {
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
            this.items = gson.fromJson(reader, new ListOfJson<>(clazz));
            if (this.items == null) this.items = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile() {
        try (Writer writer = new OutputStreamWriter(new FileOutputStream(this.file), "UTF-8")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(items, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<E> getItems() {
        return this.items;
    }
}
