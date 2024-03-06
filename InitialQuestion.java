import java.util.List;

public class InitialQuestion {
    public Question getInitialQuestion() {
        return new Question("Вам нужна бытовая или электронная техника?",
                List.of(
                        new Answer("Мне нужна электронная техника", new Question("Вам нужны смартфоны или фототехника?",
                                List.of(
                                        new Answer("Мне нужно найти другую технику", new Question("Вам нужны ТВ, консоли, аудио?",
                                                List.of(
                                                        new Answer("Да это та техника которая мне нужна", new Question("Вам нужно ТВ?",
                                                                List.of(
                                                                        new Answer("Да, мне нужно ТВ", null),
                                                                        new Answer("Мне не нужно ТВ", new Question("Вам нужны консоли или аудио техника?",
                                                                                List.of(
                                                                                        new Answer("Мне нужно аудио", null),
                                                                                        new Answer("Мне нужны консоли", null)
        ), null))
                                                                ), null)),
                                                        new Answer("Нет, мне нужна другая техника", new Question("Вам нужны ПК или ноутбуки?",
                                                                List.of(
                                                                        new Answer("Мне нужны ноутбуки", null),
                                                                        new Answer("Мне нужны ПК", null)
                                                                ), null))
                                                ), null)),
                                        new Answer("Да, мне нужны смартфоны/фототехника", new Question("Вам нужны смартфоны?",
                                                List.of(
                                                        new Answer("Да, мне нужны смартфоны", null),
                                                        new Answer("Нет, мне нужна фототехника", null)
                                                ), null))
                                ), "Вы выбрали электронную технику, теперь вам нужно ответить на вопрос: <<нужны ли вам смартфоны или фототехника>>, если нет, то будет предложен другой вопрос что бы понять что вам нужно."
                        )),
                        new Answer("Мне нужна бытовая техника", new Question("Вам нужна техника для кухни?",
                                List.of(
                                        new Answer("Мне не нужна техника для кухни", new Question("Вам нужна встраиваемая техника?",
                                                List.of(
                                                        new Answer("Мне не нужна встраиваемая техника", new Question("Вам нужна техника для дома?",
                                                                List.of(
                                                                        new Answer("Да, мне нужна техника для дома", null),
                                                                        new Answer("Мне нужна другая техника", null)
                                                                ), null)),
                                                        new Answer("Да, мне нужна встраиваемая техника", null)
                                                ), null
                                        )),
                                        new Answer("Мне нужна только кухонная техника", null)
                                ), null
                        ))
                ), "От вашего выбора зависит, будете ли вы искать электронную технику или же бытовую."
        );
    }
}
