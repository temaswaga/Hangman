public class Question {
    private static final String[] answers = new String[] {"Moscow", "MIT", "Moon", "Obama", "Minecraft"};
    private static final String[] questions = new String[] {"What is the capital of the largest country?", "What is the name of best techncial university?", "What does Gru wanted to steal in the first serie of <Despicable Me>?", "First black president of USA", "Cubical computer game"};

    public static String getAnswers(int numberOfQuestion) {
        return answers[numberOfQuestion];
    }

    public static String getQuestions(int numberOfQuestion) {
        return questions[numberOfQuestion];
    }
}
