package karma.dobble.client;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Dobble client");

        System.out.print("Username: ");
        String userName = scanner.next("[a-zA-Z]*");

        DobbleClientEndpoint endpoint = new DobbleClientEndpoint(userName);

        while (true) {
            String msg = scanner.nextLine();
            endpoint.sendMessage(msg);
        }
    }
}
