public class Answer {
    private String text;
    private Question nextQuestion;

    public Answer(String text, Question nextQuestion) {
        this.text = text;
        this.nextQuestion = nextQuestion;
    }

    public String getText() {
        return text;
    }

    public Question getNextQuestion() {
        return nextQuestion;
    }
}
