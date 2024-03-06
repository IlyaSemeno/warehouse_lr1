import java.util.List;

public class Question {
    private String text;
    private List<Answer> answers;
    private String helpMessage;

    public Question(String text, List<Answer> answers, String helpMessage) {
        this.text = text;
        this.answers = answers;
        this.helpMessage = helpMessage;
    }

    public String getText() {
        return text;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    public String getHelpMessage(){
        return helpMessage;
    }
}
