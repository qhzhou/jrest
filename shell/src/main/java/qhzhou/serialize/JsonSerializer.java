package qhzhou.serialize;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.stream.JsonWriter;

import java.io.*;

/**
 * Created by qianzhou on 5/3/15.
 */
public class JsonSerializer<T> implements Serializer<T> {

    private static final Gson gson;

    static {
        gson = new Gson();
        //init gson
    }


    private final Class<T> clazz;

    public JsonSerializer(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void serialize(T obj, OutputStream outputStream) {
        final JsonWriter writer = new JsonWriter(new OutputStreamWriter(outputStream));
        try {
            gson.toJson(obj, clazz, writer);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new JsonIOException(e);
            }
        }
    }

    @Override
    public T deserialize(InputStream inputStream) {
        return gson.fromJson(new InputStreamReader(inputStream), clazz);
    }
}
