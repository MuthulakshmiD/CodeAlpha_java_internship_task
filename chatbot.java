import java.util.*;

public class AIChatbot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> responses = new HashMap<>();
        responses.put("hello", "Hi there! How can I help you?");
        responses.put("name", "I am your Java Chatbot.");
        responses.put("how are you", "I'm good! How about you?");
        responses.put("help", "You can ask me about my name, say hello, or say bye to exit.");

        System.out.println("Chatbot: Hello! Ask me something (type 'bye' to exit)");

        while (true) {
            System.out.print("You: ");
            String input = sc.nextLine().toLowerCase();

            if (input.contains("bye")) {
                System.out.println("Chatbot: Goodbye!");
                break;
            }

            boolean matched = false;
            for (String key : responses.keySet()) {
                if (input.contains(key)) {
                    System.out.println("Chatbot: " + responses.get(key));
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                System.out.println("Chatbot: Sorry, I don't understand.");
            }
        }

        sc.close();
    }
}
