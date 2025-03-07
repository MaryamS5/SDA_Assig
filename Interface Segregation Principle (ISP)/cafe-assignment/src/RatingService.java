import java.util.Scanner;
import java.util.List;

interface IRatingService {
    void collectRating();
}

public class RatingService implements IRatingService {
    private final Scanner input = new Scanner(System.in);
    private final List<String> ratingOptions = List.of("Excellent", "Average", "Poor");

    @Override
    public void collectRating() {
        int rate;
        while (true) {
            displayOptions();
            System.out.print("Choice: ");
            rate = input.nextInt();

            if (rate >= 1 && rate <= ratingOptions.size()) {
                System.out.println("Thanks for rating, this will help us improve our service.");
                break;
            } else {
                System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void displayOptions() {
        System.out.println("How do you rate our customer service?");
        for (int i = 0; i < ratingOptions.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + ratingOptions.get(i));
        }
    }
}
