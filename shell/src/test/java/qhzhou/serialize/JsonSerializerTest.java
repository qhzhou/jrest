package qhzhou.serialize;

import com.google.gson.annotations.Expose;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by qianzhou on 5/3/15.
 */
public class JsonSerializerTest {

    private static class POJO {

        @Expose
        private String str;
        @Expose
        private int i;

        public String getStr() {
            return str;
        }

        public void setStr(String str) {
            this.str = str;
        }

        public int getI() {
            return i;
        }

        public void setI(int i) {
            this.i = i;
        }
    }

    @Test
    public void test() throws IOException {
        JsonSerializer<POJO> jsonSerializer = new JsonSerializer<>(POJO.class);
        POJO origin = new POJO();
        origin.setI(100);
        origin.setStr("test");

        final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.flush();
        jsonSerializer.serialize(origin, outputStream);
        POJO serialized = jsonSerializer.deserialize(new ByteArrayInputStream(outputStream.toByteArray()));
        compare(origin, serialized);

    }

    private static void compare(POJO a, POJO b) {
        assertEquals(a.getI(), b.getI());
        assertEquals(a.getStr(), b.getStr());

    }
}
