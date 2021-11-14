package echoServerExample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DailyAdviceClient {

    private static Socket socket;
    private static BufferedReader reader;

    public static void main(String[] args) {
        DailyAdviceClient adviceClient = new DailyAdviceClient();
        adviceClient.go();
    }

    public void go() {
        try {
            socket = new Socket("localhost", 4000); //на моей машине этот порт свободен
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String advice = reader.readLine();
            System.out.println("Совет дня на сегодня: " + advice);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
