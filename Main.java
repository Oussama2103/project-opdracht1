import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        boolean isOwner = false;

        GoodOldGames goodOldGames = new GoodOldGames(); // Maak een instantie van GoodOldGames

        while (running) {
            System.out.println("Welkom bij Good ol' Games!");
            System.out.println("Bent u een eigenaar of een gebruiker?");
            System.out.println("1. Eigenaar");
            System.out.println("2. Gebruiker");
            System.out.println("3. Afsluiten");
            System.out.print("Selecteer uw rol: ");
            int roleOption = scanner.nextInt();

            switch (roleOption) {
                case 1:
                    isOwner = true;
                    handleOwnerActions(scanner, goodOldGames); // Voer acties voor eigenaar uit
                    break;
                case 2:
                    handleUserActions(scanner, goodOldGames); // Voer acties voor gebruiker uit
                    break;
                case 3:
                    running = false;
                    System.out.println("Bedankt voor uw bezoek aan Good ol' Games!");
                    break;
                default:
                    System.out.println("Ongeldige optie. Probeer opnieuw.");
            }
        }
        scanner.close();
    }

    private static void handleUserActions(Scanner scanner, GoodOldGames goodOldGames) {
        boolean userRunning = true;
        while (userRunning) {
            System.out.println("Gebruiker Menu:");
            System.out.println("1. Bekijk Reviews");
            System.out.println("2. Schrijf een Review");
            System.out.println("3. Bekijk beschikbare spellen");
            System.out.println("4. Terug naar Rolkeuze");
            System.out.print("Selecteer een optie: ");

            // Lees de invoer van de gebruiker als een string
            String input = scanner.nextLine();

            // Probeer de string om te zetten naar een integer
            try {
                int option = Integer.parseInt(input);

                // Voer de rest van de logica uit zoals eerder
                switch (option) {
                    case 1:
                        scanner.nextLine(); // Consume newline
                        System.out.print("Voer de naam van het spel in: ");
                        String gameToView = scanner.nextLine();
                        goodOldGames.displayReviews(gameToView);
                        break;
                    case 2:
                        writeReview(scanner, goodOldGames);
                        break;
                    case 3:
                        displayAvailableGames(goodOldGames);
                        break;
                    case 4:
                        userRunning = false;
                        break;
                    default:
                        System.out.println("Ongeldige optie. Probeer opnieuw.");
                }
            } catch (NumberFormatException e) {
                // Als de conversie naar een integer mislukt, geef een foutmelding
                System.out.println("Ongeldige invoer. Voer een getal in.");
            }
        }
    }

    private static void displayAvailableGames(GoodOldGames goodOldGames) {
        System.out.println("Beschikbare spellen om een review voor te schrijven:");
        for (String game : goodOldGames.getAvailableGames()) {
            System.out.println(game);
        }
    }

    private static void writeReview(Scanner scanner, GoodOldGames goodOldGames) {
        System.out.println("Voer de naam van het spel in: ");
        String gameName = scanner.next();

        // Controleer of het spel bestaat voordat we een review toevoegen
        if (goodOldGames.gameExists(gameName)) {
            System.out.print("Voer de score voor graphics in (1-10): ");
            int graphicsScore = scanner.nextInt();

            System.out.print("Voer de score voor gameplay in (1-10): ");
            int gameplayScore = scanner.nextInt();

            System.out.print("Voer de score voor verhaallijn in (1-10): ");
            int storylineScore = scanner.nextInt();

            // Voeg de review toe aan het spel
            goodOldGames.addReview(gameName, new Review(graphicsScore, gameplayScore, storylineScore, ""));

            // Voeg na het schrijven van een review de korting toe
            // (Deze korting wordt toegepast op basis van de gemiddelde rating van het spel)
            Game game = goodOldGames.getGameByName(gameName);
            if (game != null) {
                double averageRating = calculateAverageRating(game);
                double kortingPercentage = calculateKortingPercentage(averageRating);
                KortingGame kortingGame = new KortingGame(game, kortingPercentage);
                kortingGame.geefKorting(); // Bereken en pas de korting toe op het spel
            } else {
                System.out.println("Spel niet gevonden.");
            }
        } else {
            System.out.println("Spel niet gevonden.");
        }
    }



    private static double calculateAverageRating(Game game) {
        double totalRating = 0;
        List<Review> reviews = game.getReviews();
        for (Review review : reviews) {
            totalRating += (review.getGraphicsScore() + review.getGameplayScore() + review.getStorylineScore()) / 3.0;
        }
        return totalRating / reviews.size();
    }

    private static double calculateKortingPercentage(double averageRating) {
        // Stel de korting in op basis van de gemiddelde rating van het spel
        // Dit is slechts een voorbeeld; pas de logica aan zoals nodig
        if (averageRating >= 8.0) {
            return 10.0; // Lage korting bij hoge gemiddelde rating
        } else if (averageRating >= 6.0) {
            return 5.0; // Gemiddelde korting bij gemiddelde gemiddelde rating
        } else {
            return 0; // Geen korting bij lage gemiddelde rating
        }
    }

    private static void handleOwnerActions(Scanner scanner, GoodOldGames goodOldGames) {
        boolean ownerRunning = true;
        while (ownerRunning) {
            System.out.println("Eigenaar Menu:");
            System.out.println("1. Bekijk Reviews");
            System.out.println("2. Verwijder Review");
            System.out.println("3. Aanpassen Review");
            System.out.println("4. Bekijk beschikbare spellen");
            System.out.println("5. Terug naar Rolkeuze");
            System.out.print("Selecteer een optie: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Voer de naam van het spel in: ");
                    String gameToView = scanner.nextLine();
                    goodOldGames.displayReviews(gameToView);
                    break;
                case 2:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Voer de naam van het spel in: ");
                    String gameNameToRemoveReview = scanner.nextLine();
                    System.out.print("Voer de index van de review in om te verwijderen: ");
                    int reviewIndex = scanner.nextInt();
                    goodOldGames.deleteReview(gameNameToRemoveReview, reviewIndex);
                    break;
                case 3:
                    scanner.nextLine(); // Consume newline
                    System.out.print("Voer de naam van het spel in: ");
                    String gameNameToEditReview = scanner.nextLine();
                    System.out.print("Voer de index van de review in om aan te passen: ");
                    int reviewIndexToEdit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Voer de nieuwe review in: ");
                    String newReviewText = scanner.nextLine();
                    goodOldGames.editReview(gameNameToEditReview, reviewIndexToEdit, newReviewText);
                    break;
                case 4:
                    displayAvailableGames(goodOldGames);
                    break;
                case 5:
                    ownerRunning = false;
                    break;
                default:
                    System.out.println("Ongeldige optie. Probeer opnieuw.");
            }
        }
    }
}
