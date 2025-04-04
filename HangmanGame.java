import java.util.HashSet;

public class HangmanGame extends HangmanUI {


    public static void gamePlay() {
        for (int i = 0; i < Question.getQuestions().length; i++) {
            boolean answerToPlay = askToPlay(i);
            if (!answerToPlay) {
                break;
            };

            if (answerToPlay) {
                int numberOfMistakes = 0;
                int numberOfCorrectLetters = 0;
                char[] alphabet = alphabetCreater();
                HashSet<Character> letters = new HashSet<>();

                do {
                    questionPrinter(i, Question.getQuestions());
                    hangmanPrinter(numberOfMistakes);
                    wordPrinter(i, Question.getAnswers(), letters);
                    alphabetPrinter(alphabet);

                    char lastInsertedLetter = letterInserter();
                    
                    int countOfParticularLetter = frequencyOfTheLetterInWordFinder(i, Question.getAnswers(), lastInsertedLetter);

                    if(countOfParticularLetter == 0 && !letters.contains(lastInsertedLetter)) {
                        numberOfMistakes++;
                        insertXInsteadOfLetter(alphabet, lastInsertedLetter);
                    } else if (countOfParticularLetter > 0 && !letters.contains(lastInsertedLetter)) {
                        numberOfCorrectLetters += countOfParticularLetter;
                        insertVInsteadOfLetter(alphabet, lastInsertedLetter);
                    }

                    letterToHashSetAdder(letters, lastInsertedLetter);

                    String winOrLose = winOrLoseDefiner(i, Question.getAnswers(), numberOfMistakes, numberOfCorrectLetters);
                    if (winOrLose.equalsIgnoreCase("won") || winOrLose.equalsIgnoreCase("lost")) {
                        break;
                    }

                } while (numberOfMistakes < MAX_COUNT_OF_MISTAKES);
            }
        }
    }
}
