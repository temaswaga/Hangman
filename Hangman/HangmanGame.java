package Hangman;

import java.util.HashSet;

public class HangmanGame {

    public static void gamePlay() {
        for (int i = 0; i < Questions.getQuestions(i).length(); i++) {
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
                    HangmanUI.questionPrinter(i);
                    HangmanUI.hangmanPrinter(numberOfMistakes);
                    HangmanUI.wordPrinter(i, letters);
                    HangmanUI.alphabetPrinter(alphabet);

                    char lastInsertedLetter = HangmanUI.letterInserter();
                    int countOfParticularLetter = HangmanUI.frequencyOfTheLetterInWordFinder(i, lastInsertedLetter);

                    if (countOfParticularLetter == 0 && !letters.contains(lastInsertedLetter)) {
                        numberOfMistakes++;
                        HangmanUI.insertXInsteadOfLetter(alphabet, lastInsertedLetter);
                    }
                    else if (countOfParticularLetter > 0 && !letters.contains(lastInsertedLetter)) {
                        numberOfCorrectLetters += countOfParticularLetter;
                        HangmanUI.insertVInsteadOfLetter(alphabet, lastInsertedLetter);
                    }

                    HangmanUI.letterToHashSetAdder(letters, lastInsertedLetter);

                    String winOrLose = HangmanUI.winOrLoseDefiner(i, numberOfMistakes, numberOfCorrectLetters);
                    if (winOrLose.equalsIgnoreCase("won") || winOrLose.equalsIgnoreCase("lost")) {
                        break;
                    }
                } while (numberOfMistakes < HangmanUI.MAX_COUNT_OF_MISTAKES);
            }
        }
    }
}
