import java.util.HashSet;
import java.util.Scanner;

public class HangmanUI extends Question{
    final static int MAX_COUNT_OF_MISTAKES = 6;
    static Scanner scanner = new Scanner(System.in);

    public static String gameStarter(int numberOfIteration) {
        if (numberOfIteration == 0) {
            System.out.println("Do you wanna to play? (yes/no)");
        } else {
            System.out.println("Do you want to play again? (yes/no)");
        }
        return scanner.nextLine();
    }

    public static boolean askToPlay(int numberOfIteration) {
        do {
            String answerYesOrNo = HangmanUI.gameStarter(numberOfIteration);
            if (answerYesOrNo.equalsIgnoreCase("yes")) {
                return true;
            } else if (answerYesOrNo.equalsIgnoreCase("no")) {
                System.out.println("Bye bye!");
                return false;
            } else {
                System.out.println("Please, answer yes or no");
            }
        } while (true);
    }

    public static void questionPrinter(int numberOfQuestion, String[] questions) {
        System.out.println("Yours question is: " + questions[numberOfQuestion]);
    }

    public static void wordPrinter(int numberOfQuestion, String[] answers, HashSet<Character> letters) {   // перебираю буквы секретного слова и если мой HashSet contains эту букву - вывожу её вместо "_ "
        System.out.print("      ");
        for (int i = 0; i < answers[numberOfQuestion].length(); i++) {
            if (letters.contains(answers[numberOfQuestion].charAt(i))) {
                System.out.print(answers[numberOfQuestion].charAt(i) + " ");
            }
            else {
                System.out.print("_ ");
            }
        }
    }

    public static char letterInserter() {
        System.out.print("\n\n   Enter a letter: ");
        return scanner.nextLine().charAt(0);
    }

    public static void letterToHashSetAdder(HashSet<Character> letters, char letter) {
        letters.add(Character.toLowerCase(letter));      // Добавляю в хэшсет как нижний так и верхний регистры введенной буквы для того чтобы он был не важен
        letters.add(Character.toUpperCase(letter));
    }

    public static int frequencyOfTheLetterInWordFinder(int indexOfQuestion, String[] answers, Character letter) { // во
        int countOfLettersInWord = 0;
        for (int i = 0; i < answers[indexOfQuestion].length(); i++) {
            if (Character.toLowerCase(letter) == Character.toLowerCase(answers[indexOfQuestion].charAt(i))) {  // При вводе обе переменные к нижнему регистру, чтобы избежать ошибок при сравнении
                countOfLettersInWord++;
            }
        }
        return countOfLettersInWord;
    }

    public static void hangmanPrinter(int numberOfMistakes) throws IllegalArgumentException { // Обрабатываю случай если numberOfMistakes окажется не принадлежащим [0,5]
        if (numberOfMistakes < 0 || numberOfMistakes >= HANGMAN_STATES.length) {
            throw new IllegalArgumentException(
                    "Invalid number of mistakes: " + numberOfMistakes +
                            ". Must be between 0 and " + (HANGMAN_STATES.length - 1)
            );
        }
        System.out.print(HANGMAN_STATES[numberOfMistakes]);
    }

    public static String winOrLoseDefiner(int numberOfQuestion, String[] answers, int numberOfMistakes, int numberOfCorrectLetters) {
        if (numberOfMistakes >= MAX_COUNT_OF_MISTAKES) {
            System.out.println(HANGMAN_STATES[numberOfMistakes]);
            System.out.println("\n   You're loooooooser \uD83E\uDD2A \n");
            return "lost";
        }
        if (numberOfCorrectLetters == answers[numberOfQuestion].length()) {
            System.out.println("\n  You've won the game! \uD83E\uDD70 ");
            System.out.println("  The word was " + answers[numberOfQuestion] + "\n");
            return "won";
        }
        return "";
    }

    public static char[] alphabetCreater() {
        return "abcdefghijklmnopqrstuvwxyz".toCharArray();
    }

    public static void insertXInsteadOfLetter(char[] alphabet, char letter) {
        alphabet[letter - 'a'] = 'X';
    }

    public static void insertVInsteadOfLetter(char[] alphabet, char letter) {
        alphabet[letter - 'a'] = '✓';
    }

    public static void alphabetPrinter(char[] alphabet) {
        System.out.println("\n");
        for(int i = 0; i < alphabet.length && i < 10; i++) {
            System.out.print(alphabet[i] + " ");
        }
        System.out.println();
        for(int i = 10; i < alphabet.length && i < 20; i++) {
            System.out.print(alphabet[i] + " ");
        }
        System.out.print("\n    ");
        for(int i = 20; i < alphabet.length; i++) {
            System.out.print(alphabet[i] + " ");
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

    private static final String[] HANGMAN_STATES = new String[]{ZERO_MISTAKES, ONE_MISTAKE, TWO_MISTAKE, THREE_MISTAKE, FOUR_MISTAKE, FIVE_MISTAKES, SIX_MISTAKES};
}
