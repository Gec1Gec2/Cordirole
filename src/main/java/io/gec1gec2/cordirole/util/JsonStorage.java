package io.gec1gec2.cordirole.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;

public abstract class JsonStorage<T> {
    private final Gson gson;

    private T data;

    public T get() {
        return data;
    }

    public void set(T data) {
        this.data = data;
    }

    public void reinit() {
        init();
    }

    public JsonStorage() {
        this.gson = new Gson();
        init();
    }

    protected abstract String getFileName();
    public void save() throws IOException {
        var file = FabricLoader.getInstance().getConfigDir().resolve(getFileName()).toFile();

        FileWriter fileWriter = new FileWriter(file);

        String str = gson.toJson(data);
        fileWriter.write(str);
        fileWriter.close();
    }

    protected abstract T getBoilerplate();

    protected abstract Class getClazz();

    public void init() {
        var file = FabricLoader.getInstance().getConfigDir().resolve(getFileName()).toFile();

        if (!file.exists()) {
            data = getBoilerplate();
            try {
                save();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            file = FabricLoader.getInstance().getConfigDir().resolve(getFileName()).toFile();
            JsonReader reader = new JsonReader(new FileReader(file));
            data = gson.fromJson(reader, getClazz());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}