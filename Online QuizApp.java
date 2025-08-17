import java.util.*;

class Question {
    String question;
    String[] options;
    int correctAnswer; // index of correct option (1-based)

    public Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println("\n" + question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 👉 List of Questions
        List<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of India?",
                new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 1));
        questions.add(new Question("Which language is platform independent?",
                new String[]{"C", "C++", "Java", "Python"}, 3));
        questions.add(new Question("Who is known as the father of computers?",
                new String[]{"Charles Babbage", "Alan Turing", "James Gosling", "Dennis Ritchie"}, 1));
        questions.add(new Question("Which company developed Java?",
                new String[]{"Microsoft", "Sun Microsystems", "Google", "IBM"}, 2));
        questions.add(new Question("Which keyword is used to inherit a class in Java?",
                new String[]{"this", "super", "extends", "implements"}, 3));

        int score = 0;

        // 👉 Quiz Loop
        System.out.println("=== Welcome to the Online Quiz App ===");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            q.displayQuestion();

            System.out.print("Enter your answer (1-4): ");
            int ans = sc.nextInt();

            if (q.checkAnswer(ans)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer is: " + q.options[q.correctAnswer - 1]);
            }
        }

        // 👉 Display Result
        System.out.println("\n=== Quiz Over ===");
        System.out.println("Your Score: " + score + " / " + questions.size());

        if (score == questions.size()) {
            System.out.println("🎉 Excellent! You got all correct!");
        } else if (score >= 3) {
            System.out.println("👍 Good Job! Keep practicing.");
        } else {
            System.out.println("😢 Better luck next time!");
        }

        sc.close();
    }
}
