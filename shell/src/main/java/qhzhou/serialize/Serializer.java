package qhzhou.serialize;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by qianzhou on 5/2/15.
 */
public interface Serializer<T> {

    void serialize(T obj, OutputStream outputStream);

    T deserialize(InputStream inputStream);
}
