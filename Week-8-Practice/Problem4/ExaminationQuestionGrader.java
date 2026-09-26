import java.util.*;

interface Question {
    double evaluate();
    String getType();
}

class MCQQuestion implements Question {

    private String correctAnswer;
    private String studentAnswer;
    private double points;

    MCQQuestion(String correctAnswer,
                String studentAnswer,
                double points) {

        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "MCQ";
    }
}

class TFQuestion implements Question {

    private String correctAnswer;
    private String studentAnswer;
    private double points;

    TFQuestion(String correctAnswer,
               String studentAnswer,
               double points) {

        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {

        if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
            return points;
        }

        return 0;
    }

    public String getType() {
        return "TF";
    }
}

class EssayQuestion implements Question {

    private String correctAnswer;
    private String studentAnswer;
    private double points;

    EssayQuestion(String correctAnswer,
                  String studentAnswer,
                  double points) {

        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public double evaluate() {

        String[] keywords =
            correctAnswer.split(",");

        String answer =
            studentAnswer.toLowerCase();

        int matches = 0;

        for (String keyword : keywords) {

            keyword =
                keyword.trim().toLowerCase();

            if (answer.contains(keyword)) {
                matches++;
            }
        }

        if (matches >= 2) {
            return points * 0.75;
        }

        if (matches == 1) {
            return points * 0.50;
        }

        return 0;
    }

    public String getType() {
        return "ESSAY";
    }
}

public class ExaminationQuestionGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        Question[] questions =
            new Question[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            List<String> values =
                parseLine(line);

            String type = values.get(0);
            String questionText = values.get(1);
            String correctAnswer = values.get(2);
            String studentAnswer = values.get(3);
            double points =
                Double.parseDouble(values.get(4));

            if (type.equals("MCQ")) {

                questions[i] =
                    new MCQQuestion(
                        correctAnswer,
                        studentAnswer,
                        points
                    );

            } else if (type.equals("TF")) {

                questions[i] =
                    new TFQuestion(
                        correctAnswer,
                        studentAnswer,
                        points
                    );

            } else if (type.equals("ESSAY")) {

                questions[i] =
                    new EssayQuestion(
                        correctAnswer,
                        studentAnswer,
                        points
                    );
            }
        }

        double totalScore = 0;

        for (Question question : questions) {

            double score =
                question.evaluate();

            System.out.printf(
                "%s: %.2f%n",
                question.getType(),
                score
            );

            totalScore += score;
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );

        sc.close();
    }

    static List<String> parseLine(String line) {

        List<String> values =
            new ArrayList<>();

        boolean insideQuotes = false;

        StringBuilder current =
            new StringBuilder();

        for (int i = 0; i < line.length(); i++) {

            char ch = line.charAt(i);

            if (ch == '"') {

                insideQuotes = !insideQuotes;

            } else if (
                Character.isWhitespace(ch)
                && !insideQuotes
            ) {

                if (current.length() > 0) {

                    values.add(
                        current.toString()
                    );

                    current.setLength(0);
                }

            } else {

                current.append(ch);
            }
        }

        if (current.length() > 0) {
            values.add(current.toString());
        }

        return values;
    }
}