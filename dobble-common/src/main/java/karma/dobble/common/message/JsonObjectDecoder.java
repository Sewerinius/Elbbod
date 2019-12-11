package karma.dobble.common.message;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class JsonObjectDecoder implements Decoder.Text<JsonObject> {
//    private static Gson gson = new Gson();
    @Override
    public JsonObject decode(String s) throws DecodeException {
//        return gson.fromJson(s, JsonObject.class);
        return JsonParser.parseString(s).getAsJsonObject();
    }

    @Override
    public boolean willDecode(String s) {
        return s != null;
    }

    @Override
    public void init(EndpointConfig config) {

    }

    @Override
    public void destroy() {

    }
}
