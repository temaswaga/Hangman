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

        for (int i = 0; i < 5; i++) {     // 5 итерраций потому-что добавил только 5 вопросов
            String answerYesOrNo = game.gameStarter();

            if (answerYesOrNo.equalsIgnoreCase("yes")) {
                System.out.println("\nWell, lets start!");
                int numberOfMistakes = 0;
                HashSet<Character> letters = new HashSet<>();
                for (int j = 0; j < 1000; j++) {
                    game.questionPrinter(i, words); // печатаю вопрос
                    game.hangmanPrinter(numberOfMistakes); // печатаю виселицу
                    int correctLettersNumber = game.wordPrinter(i, words, letters); // печатаю слово

                    String winOrLose = game.winOrLoseDefiner(i, words, numberOfMistakes, correctLettersNumber); // определяю победу или проигрыш, если все буквы отгаданы или 6 ошибок соответственно
                    if (winOrLose.equalsIgnoreCase("won") || winOrLose.equalsIgnoreCase("lost")) {
                        break;
                    }

                    Character lastInsertedLetter = game.lettersMemorizer(letters); // определяю наличие ошибки и добавляю последний введенный символ в HashSet
                    if (!game.mistakeDetector(i, words, lastInsertedLetter)) {
                        numberOfMistakes++;
                    };
                }
            }

            else if (answerYesOrNo.equalsIgnoreCase("no")) {
                System.out.println("Bye bye!");
                break;
            }

            else {
                System.out.println("Please answer yes or no");
                i = -1;
            }
        }

    }

    public String gameStarter() {
        System.out.println("Do you wanna to play? (yes/no)");
        String answerYesOrNo = scanner.nextLine();
        return answerYesOrNo;
    }

    public void questionPrinter(int indexOfQuestion, String[][] words) {
        System.out.println("Yours question is: " + words[indexOfQuestion][1]);
    }

    public int wordPrinter(int indexOfWord, String[][] words, HashSet<Character> letters) {   // перебираю буквы секретного слова и если мой HashSet contains эту букву - вывожу её вместо "_ "
        System.out.print("      ");
        int correctLettersNumber = 0;
        for (int i = 0; i < words[indexOfWord][0].length(); i++) {
            if (letters.contains(words[indexOfWord][0].charAt(i))) {
                System.out.print(words[indexOfWord][0].charAt(i) + " ");
                correctLettersNumber++;
            }
            else {
                System.out.print("_ ");
            }
        }
        return correctLettersNumber;
    }

    public Character lettersMemorizer(HashSet<Character> letters) {
        System.out.print("\n\n   Enter a letter: ");
        Character lastInsertedLetter = scanner.nextLine().charAt(0);
        letters.add(Character.toLowerCase(lastInsertedLetter));             // Добавляю в хешсет как нижний так и верхний регистры введенной буквы для того чтобы он был не важен
        letters.add(Character.toUpperCase(lastInsertedLetter));
        return lastInsertedLetter;
    }

    public boolean mistakeDetector(int indexOfWord, String[][] words, Character letter) {
        for (int i = 0; i < words[indexOfWord][0].length(); i++) {
            if (Character.toLowerCase(letter) == Character.toLowerCase(words[indexOfWord][0].charAt(i))) {  // Приводе обе переменные к нижнему регистру чтобы избежать ошибок при сравнении
                return true;
            }
        }
        return false;
    }

    public String winOrLoseDefiner(int indexOfWord, String[][] words, int numberOfMistakes, int correctLettersNumber) {
        if (numberOfMistakes >= MAX_COUNT_OF_MISTAKES) {
            System.out.println("\n\n  You are looser :P\n");
            return "lost";
        }
        if (correctLettersNumber == words[indexOfWord][0].length()) {
            System.out.println("\n\n  You have won the game!!!!! :D\n");
            return "won";
        }
        return "";
    }

    public void hangmanPrinter(int numberOfMistakes) {
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