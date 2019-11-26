/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package eew.client;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class EEWClient {
    URI uri;
    WebSocketClient webSocketClient;
    EEWEventListener eewEventListener;

    public EEWClient(URI uri) {
        this.uri = uri;
        webSocketClient = new WebSocketClient(this.uri) {
            @Override
            public void onOpen(ServerHandshake handshakedata) {

            }

            @Override
            public void onMessage(String message) {
                JsonObject rootObject = new Gson().fromJson(message, JsonObject.class);
                if (rootObject.get("result").getAsJsonObject().get("message").getAsString().equals("データがありません")) {
                    System.out.println("NoData");
                }else {
                    if (eewEventListener != null){
                        EEWInfo info = new EEWInfo();

                        EEWInfo.Result result = new EEWInfo.Result();
                        result.setMessage(rootObject.get("result").getAsJsonObject().get("message").getAsString());
                        result.setStatus(rootObject.get("result").getAsJsonObject().get("status").getAsString());
                        result.setIs_auth(rootObject.get("result").getAsJsonObject().get("is_auth").getAsBoolean());
                        info.setResult(result);

                        EEWInfo.Security security = new EEWInfo.Security();
                        security.setRealm(rootObject.get("security").getAsJsonObject().get("realm").getAsString());
                        security.setHash(rootObject.get("security").getAsJsonObject().get("hash").getAsString());
                        info.setSecurity(security);

                        info.setReport_time(rootObject.get("report_time").getAsString());
                        info.setRegion_code(rootObject.get("region_code").getAsString());
                        info.setRequest_time(rootObject.get("request_time").getAsString());
                        info.setRegion_name(rootObject.get("region_name").getAsString());

                        info.setLongitude(rootObject.get("longitude").getAsString());
                        info.setIs_cancel(rootObject.get("is_cancel").getAsBoolean());
                        info.setDepth(rootObject.get("depth").getAsString());
                        info.setCalcintensity(rootObject.get("calcintensity").getAsString());
                        info.setIs_final(rootObject.get("is_final").getAsBoolean());
                        info.setIs_training(rootObject.get("is_training").getAsBoolean());
                        info.setLatitude(rootObject.get("latitude").getAsString());
                        info.setOrigin_time(rootObject.get("origin_time").getAsString());
                        info.setMagunitude(rootObject.get("magunitude").getAsString());
                        info.setReport_num(rootObject.get("report_num").getAsString());
                        info.setRequest_hypo_type(rootObject.get("request_hypo_type").getAsString());
                        info.setReport_id(rootObject.get("report_id").getAsString());
                        info.setAlertflg(rootObject.get("alertflg").getAsString());

                        eewEventListener.happen(info);
                    }
                    System.out.println("Data Found!");
                }
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {

            }

            @Override
            public void onError(Exception ex) {

            }
        };
    }

    public void setEewEventListener(EEWEventListener eewEventListener) {
        this.eewEventListener = eewEventListener;
    }

    public void start() {
        webSocketClient.connect();
    }

    public void exit() {
        webSocketClient.close();
    }
}