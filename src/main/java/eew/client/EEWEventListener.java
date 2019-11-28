package eew.client;

import org.java_websocket.handshake.ServerHandshake;

public interface EEWEventListener {
    void onOpen(ServerHandshake serverHandshake);
    void happen(EEWInfo info);
    void onClose(int code, String reason, boolean remote);
    void onError(Exception e);
}
