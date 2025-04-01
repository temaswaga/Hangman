import java.util.HashSet;
import java.util.Scanner;

public class Hangman {
    final static int MAX_COUNT_OF_MISTAKES = 6;
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Hangman game = new Hangman();
        String[][] words = new String[][]{{"Moscow", "What is the capital of the largest country?"},
                                          {"MIT", "What is the name of best techncial university?"},
                                          {"Moon", "What does Gru wanted to steal in the first serie of <Despicable Me>?" },
                                          {"Obama", "First black president of USA"},
                                          {"Minecraft", "Cubical computer game"}};

        for (int i = 0; i < 4; i++) {
            String answer = game.GameStarter();

            if (answer.equalsIgnoreCase("yes")) {
                System.out.println("\nWell, lets start!");
                int numberOfMistakes = 0;
                HashSet<Character> letters = new HashSet<>();
                for (int j = 0; j < 1000; j++) {
                    game.QuestionPrinter(i, words); // печатаю вопрос
                    game.HangmanPrinter(numberOfMistakes); // печатаю виселицу
                    int CorrectLettersNumber = game.WordPrinter(i, words, letters); // печатаю само слово

                    Character lastInsertedLetter = game.LettersMemorizer(letters); // определяю наличие ошибки
                    if (!game.MistakeDetector(i, words, lastInsertedLetter)) {
                        numberOfMistakes++;
                    };

                    String WinOrLose = game.WinOrLoseDefiner(i, words, numberOfMistakes, CorrectLettersNumber); // определяю победу или проигрыш
                    if (WinOrLose.equalsIgnoreCase("won") || WinOrLose.equalsIgnoreCase("lost")) {
                        break;
                    }
                }
            }

            else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Bye bye!");
                break;
            }

            else {
                System.out.println("Please answer yes or no");
                i = -1;
            }
        }

    }

    public String GameStarter() {
        System.out.println("Do you want to play? (yes/no)");
        String answer = scanner.nextLine();
        return answer;
    }

    public void QuestionPrinter(int indexOfQuestion, String[][] words) {
        System.out.println("Yours question is: " + words[indexOfQuestion][1]);
    }

    public int WordPrinter(int indexOfWord, String[][] words, HashSet<Character> letters) {
        System.out.print("      ");
        int CorrectLettersNumber = 0;
        for (int i = 0; i < words[indexOfWord][0].length(); i++) {
            if (letters.contains(words[indexOfWord][0].charAt(i))) {
                System.out.print(words[indexOfWord][0].charAt(i) + " ");
                CorrectLettersNumber++;
            }
            else {
                System.out.print("_ ");
            }
        }
        return CorrectLettersNumber;
    }

    public Character LettersMemorizer(HashSet<Character> letters) {
        System.out.print("\n\n   Write any letter: ");
        Character lastInsertedLetter = scanner.nextLine().charAt(0);
        letters.add(lastInsertedLetter);
        return lastInsertedLetter;
    }

    public boolean MistakeDetector(int indexOfWord, String[][] words, Character letter) {
        for (int i = 0; i < words[indexOfWord][0].length(); i++) {
            if (words[indexOfWord][0].charAt(i) == letter) {
                return true;
            }
        }
        return false;
    }

    public String WinOrLoseDefiner(int indexOfWord, String[][] words, int numberOfMistakes, int CorrectLettersNumber) {
        if (numberOfMistakes >= MAX_COUNT_OF_MISTAKES) {
            System.out.println("You are looser :P");
            return "lost";
        }
        if (CorrectLettersNumber == words[indexOfWord][0].length()) {
            System.out.println("You have won the game!!!!! :D");
            return "won";
        }
        return "";
    }

    public void HangmanPrinter(int numberOfMistakes) {
            if (numberOfMistakes == 0) {
                System.out.print(ZERO_MISTAKES);
            } else if (numberOfMistakes == 1) {
                System.out.print(ONE_MISTAKE);
            } else if (numberOfMistakes == 2) {
                System.out.print(TWO_MISTAKE);
            } else if (numberOfMistakes == 3) {
                System.out.print(THREE_MISTAKE);
            } else if (numberOfMistakes == 4) {
                System.out.print(FOUR_MISTAKE);
            } else if (numberOfMistakes == 5) {
                System.out.print(FIVE_MISTAKES);
            } else if (numberOfMistakes == 6) {
                System.out.print(SIX_MISTAKES);
            }
        }

    final static String ZERO_MISTAKES = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\";

    final static String ONE_MISTAKE = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t   (_)\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\";

    final static String TWO_MISTAKE = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t  _(_)_\n" +
            "\t\t||\t\t  \\. ./\n" +
            "\t\t||\t\t  (_._)\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\";

    final static String THREE_MISTAKE = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t  _(_)_\n" +
            "\t\t||\t\t |\\. ./\n" +
            "\t\t||\t\t |(_._)\n" +
            "\t\t||\t\t ]\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\";

    final static String FOUR_MISTAKE = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t  _(_)_\n" +
            "\t\t||\t\t |\\. ./|\n" +
            "\t\t||\t\t |(_._)|\n" +
            "\t\t||\t\t ]     ]\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\";

    final static String FIVE_MISTAKES = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t  _(_)_\n" +
            "\t\t||\t\t |\\. ./|\n" +
            "\t\t||\t\t |(_._)|\n" +
            "\t\t||\t\t ]||   ]\n" +
            "\t\t||\t\t  || \n" +
            "\t\t||\t\t  || \t\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\   ";

    final static String SIX_MISTAKES = "\t\t_______________\n" +
            "\t\t| ____________|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t\t|\n" +
            "\t\t||\t\t  _(_)_\n" +
            "\t\t||\t\t |\\. ./|\n" +
            "\t\t||\t\t |(_._)|\n" +
            "\t\t||\t\t ]|| ||]\n" +
            "\t\t||\t\t  || ||\n" +
            "\t\t||\t\t  || ||\t\n" +
            "\t\t||\n" +
            "\t\t||\n" +
            "\t\t| \\";
}