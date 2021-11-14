package echoServerExample;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {
    private static Socket clientSocket;
    private static ServerSocket server;
    private static PrintWriter printWriter;


    String[] advices = {"Будь решителен", "Посмотри сериальчик", "Лучше ляг поспи", "Много кода не бывает",
            "Старый друг лучше новых двух", "Даже и не думай сегодня что-то начинать", "Чай с коньячком лучшее решение"};

    public static void main(String[] args) {
        DailyAdviceServer adviceServer = new DailyAdviceServer();
        adviceServer.go();
    }

    public void go() {
        try {
            server = new ServerSocket(4000);
            while (true) {
                clientSocket = server.accept();
                printWriter = new PrintWriter(clientSocket.getOutputStream());
                String advice = getAdvice();
                printWriter.println(advice);
                printWriter.close();
                System.out.println(advice);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String getAdvice() {
        int random = (int) (Math.random() * advices.length);
        return advices[random];
    }


}
