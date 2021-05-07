package lvc.cds;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jdk.jfr.Timestamp;

public class ServerTest {
    Server server;

    @BeforeAll
    public static void setUp() throws Exception {
        Server serverMock = mock(Server.class);
    }

    @Test
    @DisplayName("Testing the server")
    public void testServer() {
        assertEquals(1, 1);
    }
}