import java.io.FileNotFoundException;
import java.util.HashSet;

public class HangmanGame extends HangmanUI {

    public static void gamePlay() throws FileNotFoundException {
        for (int i = 0; i < getQuestions().length; i++) {
            boolean answerToPlay = askToPlay(i);
            if (!answerToPlay) {
                break;
            };

            if (answerToPlay) {
                int numberOfMistakes = 0;
                int numberOfCorrectLetters = 0;
                char[] alphabet = alphabetCreater();
                HashSet<Character> letters = new HashSet<>();
                HashSet<Character> notCorrectLetters = new HashSet<>();

                do {
                    questionPrinter(i, getQuestions());     // печатаю вопрос
                    hangmanPrinter(numberOfMistakes);       // печатаю виселицу
                    wordPrinter(i, getAnswers(), letters);  // печатаю слово
                    alphabetPrinter(alphabet);              // печатаю алфавит

                    char lastInsertedLetter = letterInserter();     // Прошу ввести букву
                    
                    int countOfParticularLetter = frequencyOfTheLetterInWordFinder(i, getAnswers(), lastInsertedLetter);     // Определяю ошибку или же правильную букву (а точнее её кол-во в слове)

                    if(countOfParticularLetter == 0 && !letters.contains(lastInsertedLetter)) {             // считаю кол-во ошибок
                        numberOfMistakes++;
                        insertXInsteadOfLetter(alphabet, lastInsertedLetter);
                    } else if (countOfParticularLetter > 0 && !letters.contains(lastInsertedLetter)) {      // считаю кол-во угадов
                        numberOfCorrectLetters += countOfParticularLetter;          // += а не ++ потому-что есть слова с несколькими одинаковыми буквами, например Moscow (две о)
                        insertVInsteadOfLetter(alphabet, lastInsertedLetter);
                    }

                    letterToHashSetAdder(letters, lastInsertedLetter);     // добавляю введенную букву в HashSet

                    String winOrLose = winOrLoseDefiner(i, getAnswers(), numberOfMistakes, numberOfCorrectLetters); // определяю победу или проигрыш, если все буквы отгаданы или 6 ошибок соответственно
                    if (winOrLose.equalsIgnoreCase("won") || winOrLose.equalsIgnoreCase("lost")) {
                        break;
                    }

                } while (numberOfMistakes < MAX_COUNT_OF_MISTAKES);
            }
        }
    }
}
