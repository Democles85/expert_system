import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Medocles_v2 {
    static void covid_Symptoms() {
        System.out.println("----------------------------------------------");
        System.out.println("1)  Fever?");
        System.out.println("2)  Cough?");
        System.out.println("3)  Tiredness?");
        System.out.println("4)  Loss of Taste or Smell?");
        System.out.println("5)  Sore throat?");
        System.out.println("6)  Headache?");
        System.out.println("7)  Aches and pains?");
        System.out.println("8)  Diarrhoea?");
        System.out.println("9)  Discolouration of fingers?");
        System.out.println("10) Red or irritated eyes?");
        System.out.println("    Type 10 for all of them");
        System.out.println("----------------------------------------------");
    }

    static void pneumonia_Symptoms() {
        System.out.println("----------------------------------------------");
        System.out.println("1)  Difficulty breathing?");
        System.out.println("2)  Sweating and/or shivering?");
        System.out.println("3)  Rapid heartbeat?");
        System.out.println("4)  Loss of appettite?");
        System.out.println("5)  Chest pain?");
        System.out.println("6)  Joint and/or muscle pain?");
        System.out.println("7)  High temperature?");
        System.out.println("8)  Coughing up blood?");
        System.out.println("9)  Fatigue?");
        System.out.println("10) Wheezing?");
        System.out.println("11) Headaches?");
        System.out.println("    Type 11 for all of them");
        // System.out.println(" All of them?");
        System.out.println("  Maybe the symptoms above are more accurate to what you have?");
    }

    static void flu_Symptoms() {
        // TODO: Edit the symptoms for flu
        System.out.println("----------------------------------------------");
        System.out.println("1)  Feverish and/or Chills?");
        System.out.println("2)  Cough?");
        System.out.println("3)  Sore throat?");
        System.out.println("4)  Runny or stuffy nose?");
        System.out.println("5)  Muscle or body aches?");
        System.out.println("6)  Headaches?");
        System.out.println("7)  Vomiting?");
        System.out.println("8)  Fatigue?");
        System.out.println("9)  Diarrhoea?");
        System.out.println("    Type 9 for all of them");
        // System.out.println(" All of them?");
        System.out.println("  Maybe the symptoms above are more accurate to what you have?");
    }

    static void yes_answer(List<String> list, String before_answer) {
        Scanner input = new Scanner(System.in);

        float chance = 1;
        // float size = list.size();
        float size = 10;

        ArrayList<String> answers = new ArrayList<String>();
        answers.add(before_answer);
        // System.out.println(answers);
        int n;
        String answer;

        System.out.print("How many of the symptoms above are you showing? ");
        n = input.nextInt();
        // String[] a = new String[n];
        if (n == 10) {
            answers.addAll(list);
            answers.replaceAll(String::toUpperCase);
            String result = answers.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(" | ", "[ ", " ]"));
            System.out.println(result);
            System.out.println("The chance of you containing Covid-19 based on the symptoms is: 100%");

        } else {
            System.out.println("Enter the symptoms that you show below.");
            for (int i = 0; i <= n; i++) {
                answer = input.nextLine();
                answer = answer.toLowerCase();
                answers.add(answer);
            }
            answers.remove(1);
            if (!list.containsAll(answers)) {
                System.out.println("The symptoms you have entered are not correct");
                System.exit(0);
            } else {
                answers.replaceAll(String::toUpperCase);
                String result = answers.stream().map(x -> String.valueOf(x))
                        .collect(Collectors.joining(" | ", "[ ", " ]"));
                System.out.println(result);
                chance = ((n + 1) / size) * 100;
                String formated = String.format("%.02f", chance);
                System.out.println("The chance of you containing Covid-19 based on the symptoms is: " + formated + "%");
            }
        }
    }

    static void no_answer(List<String> list0, List<String> list1, String before_answer) {
        Scanner input = new Scanner(System.in);
        float chance = 1;
        // float size0 = list0.size(), size1 = list1.size();
        float size0 = 11, size1 = 9;
        ArrayList<String> answers = new ArrayList<String>();
        answers.add(before_answer);
        // System.out.println(answers);
        String answer0, answer1, answer2, answer3;

        System.out.print("Are you showing any of the symptoms above (yes or no)? ");
        answer1 = input.nextLine();
        answer1 = answer1.toLowerCase();
        int n;

        if (answer1.equals("yes")) {
            System.out.print("How many of the symptoms above are you showing? ");
            n = input.nextInt();
            if (n == 11) {
                answers.addAll(list0);
                answers.replaceAll(String::toUpperCase);
                String result = answers.stream().map(x -> String.valueOf(x))
                        .collect(Collectors.joining(" | ", "[ ", " ]"));
                System.out.println(result);
                System.out.println("The chance of you containing Pneumonia based on the symptoms is: 100%");
            } else {
                System.out.println("Enter the symptoms that you show below.");
                for (int i = 0; i <= n; i++) {
                    answer0 = input.nextLine();
                    answer0 = answer0.toLowerCase();
                    answers.add(answer0);
                }
                answers.remove(1);
                if (!list0.containsAll(answers)) {
                    System.out.println("The symptoms you have entered are not correct");
                    System.exit(0);
                } else {
                    answers.replaceAll(String::toUpperCase);
                    String result = answers.stream().map(x -> String.valueOf(x))
                            .collect(Collectors.joining(" | ", "[ ", " ]"));
                    System.out.println(result);
                    chance = ((n + 1) / size0) * 100;
                    String formated = String.format("%.02f", chance);
                    System.out.println(
                            "The chance of you containing Pneumonia based on the symptoms is: " + formated + "%");
                }
            }
        } else if (answer1.equals("no")) {
            flu_Symptoms();
            System.out.print("Are you showing any of the symptoms above (yes or no)? ");
            answer2 = input.nextLine();
            answer2 = answer2.toLowerCase();
            if (answer2.equals("yes")) {
                System.out.print("How many of the symptoms above are you showing? ");
                n = input.nextInt();
                if (n == 9) {
                    answers.addAll(list0);
                    answers.replaceAll(String::toUpperCase);
                    String result = answers.stream().map(x -> String.valueOf(x))
                            .collect(Collectors.joining(" | ", "[ ", " ]"));
                    System.out.println(result);
                    System.out.println("The chance of you containing Flu based on the symptoms is: 100%");
                } else {

                    System.out.println("Enter the symptoms that you show below.");
                    for (int i = 0; i <= n; i++) {
                        answer3 = input.nextLine();
                        answer3 = answer3.toLowerCase();
                        answers.add(answer3);
                    }
                    answers.remove(1);
                    if (!list1.containsAll(answers)) {
                        System.out.println("The symptoms you have entered are not correct");
                        System.exit(0);
                    } else {
                        answers.replaceAll(String::toUpperCase);
                        String result = answers.stream().map(x -> String.valueOf(x))
                                .collect(Collectors.joining(" | ", "[ ", " ]"));
                        System.out.println(result);
                        chance = ((n + 1) / size1) * 100;
                        String formated = String.format("%.02f", chance);
                        System.out.println(
                                "The chances of you containing Flu based on the symptoms is: " + formated + "%");
                    }
                }
            } else {
                System.exit(0);
            }
        } else {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] covid_Symptoms = { "fever", "cough", "tiredness", "loss of taste or smell", "loss of taste",
                "loss of smell", "sore throat", "headache", "aches and pains", "diarrhoea", "discolouration of fingers",
                "red or irritated eyes", "red eyes", "irritated eyes", "difficulty breathing", "loss of speech",
                "chest pain" };
        List<String> list0 = Arrays.asList(covid_Symptoms);

        String[] pneumonia_Symptoms = { "fever", "difficulty breathing", "sweating and shivering", "sweating",
                "shivering", "rapid heartbeat", "loss of appetite", "chest pain", "joint and muscle pain", "joint pain",
                "muscle pain", "high temperature", "coughing up blood", "fatigue", "wheezing", "headaches", "cough",
                "tiredness", "loss of taste or smell", "loss of taste", "loss of smell", "sore throat", "headache",
                "aches and pains", "diarrhoea", "discolouration of fingers", "red or irritated eyes", "red eyes",
                "irritated eyes", "loss of speech", "loss of appettite" };
        List<String> list1 = Arrays.asList(pneumonia_Symptoms);

        String[] flu_Symptoms = { "fever", "feverish/chills", "feverish", "chills", "cough", "sore throat",
                "runny or stuffy nose", "muscle or body aches", "headaches", "fatigue", "vomiting", "diarrhea",
                "tiredness", "loss of taste or smell", "loss of taste", "loss of smell", "sore throat", "headache",
                "aches and pains", "diarrhoea", "discolouration of fingers", "red or irritated eyes", "red eyes",
                "irritated eyes", "difficulty breathing", "loss of speech", "chest pain" };
        List<String> list2 = Arrays.asList(flu_Symptoms);

        // Different variables
        String answer0, answer1;
        // int count = 0;

        System.out.println("\tMedocles V2.1.0");
        covid_Symptoms();
        System.out.println("What symptoms are you showing?");

        answer0 = input.nextLine();
        answer0 = answer0.toLowerCase();

        if (answer0.equals(null)) {
            System.exit(0);
        }

        if (list0.contains(answer0)) {
            do {
                covid_Symptoms();
                System.out.print("Do you show any other symptoms from the above (yes or no)? ");
                answer1 = input.nextLine();
                answer1 = answer1.toLowerCase();
                switch (answer1) {
                case "yes":
                    yes_answer(list0, answer0);
                    break;
                case "no":
                    pneumonia_Symptoms();
                    no_answer(list1, list2, answer0);
                    break;
                default:
                    System.out.print("Unknown answer!");
                }
            } while (!list0.contains(answer0));
        }
    }
}
