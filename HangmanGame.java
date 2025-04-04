import java.util.HashSet;

public class HangmanGame {


    public static void gamePlay() {
        for (int i = 0; i < Question.getQuestions().length; i++) {
            boolean answerToPlay = HangmanUI.askToPlay(i);
            if (!answerToPlay) {
                break;
            };

            if (answerToPlay) {
                int numberOfMistakes = 0;
                int numberOfCorrectLetters = 0;
                char[] alphabet = HangmanUI.alphabetCreater();
                HashSet<Character> letters = new HashSet<>();

                do {
                    HangmanUI.questionPrinter(i, Question.getQuestions());
                    HangmanUI.hangmanPrinter(numberOfMistakes);
                    HangmanUI.wordPrinter(i, Question.getAnswers(), letters);
                    HangmanUI.alphabetPrinter(alphabet);

                    char lastInsertedLetter = HangmanUI.letterInserter();
                    
                    int countOfParticularLetter = HangmanUI.frequencyOfTheLetterInWordFinder(i, Question.getAnswers(), lastInsertedLetter);

                    if(countOfParticularLetter == 0 && !letters.contains(lastInsertedLetter)) {
                        numberOfMistakes++;
                        HangmanUI.insertXInsteadOfLetter(alphabet, lastInsertedLetter);
                    } else if (countOfParticularLetter > 0 && !letters.contains(lastInsertedLetter)) {
                        numberOfCorrectLetters += countOfParticularLetter;
                        HangmanUI.insertVInsteadOfLetter(alphabet, lastInsertedLetter);
                    }

                    HangmanUI.letterToHashSetAdder(letters, lastInsertedLetter);

                    String winOrLose = HangmanUI.winOrLoseDefiner(i, Question.getAnswers(), numberOfMistakes, numberOfCorrectLetters);
                    if (winOrLose.equalsIgnoreCase("won") || winOrLose.equalsIgnoreCase("lost")) {
                        break;
                    }

                } while (numberOfMistakes < HangmanUI.MAX_COUNT_OF_MISTAKES);
            }
        }
    }
}
