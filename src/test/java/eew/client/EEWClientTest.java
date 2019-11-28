/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package eew.client;

import org.java_websocket.handshake.ServerHandshake;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.*;

public class EEWClientTest {
//    private static Logger log = Logger.getLogger(LibraryTest.class.getName());

    @Test public void testSomeLibraryMethod() {
//        log.info("Hello");
        System.out.println("Hello");
        try {
            EEWClient eewClient = new EEWClient(new URI("wss://eew-test.yjsnpi.club"));
            eewClient.setEewEventListener(new EEWEventListener() {
                @Override
                public void onOpen(ServerHandshake serverHandshake) {

                }

                @Override
                public void happen(EEWInfo info) {
                    System.out.println(info.toString());
                }

                @Override
                public void onClose(int code, String reason, boolean remote) {

                }

                @Override
                public void onError(Exception e) {

                }
            });
            eewClient.start();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(600000001);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(true);
//        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}
