import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Medocles {
    // static void flu_Symptoms() {
    // System.out.println("\t Fever?");
    // System.out.println("\t Cough?");
    // System.out.println("\t Sore throat?");
    // System.out.println("\t Runny nose?");
    // System.out.println("\t Stuffy nose?");
    // System.out.println("\t Muscle ache?");
    // System.out.println("\t Body ache?");
    // System.out.println("\t Headache?");
    // System.out.println("\t Fatigue?");
    // System.out.println("\t Vomiting?");
    // System.out.println("\t Diarrhoea?");
    // System.out.println("\t All of them?");
    // System.out.print("Shkruani nje nga simptomat e mesiperme: ");
    // }

    // Covid Symptoms
    static void covid_Symptoms() {
        System.out.println("  Fever?");
        System.out.println("  Cough?");
        System.out.println("  Tiredness?");
        System.out.println("  Loss of Taste or Smell?");
        System.out.println("  Sore throat?");
        System.out.println("  Headache?");
        System.out.println("  Aches and pains?");
        System.out.println("  Diarrhoea?");
        System.out.println("  Discolouration of fingers?");
        System.out.println("  Red or irritated eyes?");
        System.out.println("  All of them?");
        System.out.print("Shkruani nje nga simptomat e mesiperme: ");
    }

    // Main Function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String answer0, answer1, answer2;
        int count = 0;
        ArrayList<String> answers = new ArrayList<String>();

        System.out.println("\n\t  Medocles");
        System.out.println("Cfare simptomash po shfaqni?");
        covid_Symptoms();
        // Pergjigja per ciklin e pare te pyetjeve
        answer0 = input.nextLine();
        answer0 = answer0.toLowerCase();
        // ----------------------------------------------------------------------------------------------------

        // Knowledge base arrays
        String[] covid_Symptoms = { "fever", "cough", "tiredness", "loss of taste or smell", "loss of taste",
                "loss of smell", "sore throat", "headache", "aches and pains", "diarrhoea", "discolouration of fingers",
                "red or irritated eyes", "red eyes", "irritated eyes", "difficulty breathing", "loss of speech",
                "chest pain" };
        // String[] flu_Symptoms = { "fever", "cough", "sore throat", "runny nose",
        // "stuffy nose", "muscle ache",
        // "body ache", "headache", "fatigue", "vomiting", "diarrhoea" };
        // ----------------------------------------------------------------------------------------------------

        // Kthimi ne lista i knowledge base
        List<String> list0 = Arrays.asList(covid_Symptoms);
        // ----------------------------------------------------------------------------------------------------

        // Kontrolli nese pergjigjia gjendet ne knowledge base
        do {

            if (list0.contains(answer0)) {
                count++;
                answers.add(answer0);
                System.out.println("||=> Ju shfaqni " + count + " nga simptomat me te zakonshme per Covid-19."
                        + "\n\tAto jane: " + answers);
            } else if (answer0.equals("all of them") || answer0.equals("all of them.")) {
                System.out.println(list0);
                count = list0.size();
                System.out.println("||=> Ju shfaqni te gjitha simptomat me te zakonshme per Covid-19.");
                break;
            } else {
                System.out.println("||=> Simptoma e pershkruar nuk ekziston.");
                System.exit(0);
            }
            // Vazhdimi i pytjeve nese shpreh simptoma te tjera
            do {
                System.out.println("Keni simptoma te tjera (po ose jo)? ");

                answer1 = input.nextLine();
                answer1 = answer1.toLowerCase();

                if (answer1.equals("po")) {
                    covid_Symptoms();

                    answer2 = input.nextLine();
                    answer2 = answer2.toLowerCase();

                    if (list0.contains(answer2) && answer2 != answer0) {
                        count++;
                        answers.add(answer2);
                        System.out.println("||=> Ju shfaqni " + count + " nga simptomat me te zakonshme per Covid-19."
                                + "\n\tAto jane: " + answers);
                    } else
                        System.out.println("||=> Ju shfaqni " + count + " nga simptomat me te zakonshme per Covid-19."
                                + "\n\tAto jane: " + answers);
                } else {
                    System.out.println("||=> Ju shfaqni " + count + " nga simptomat me te zakonshme per Covid-19."
                            + "\n\tAto jane: " + answers);
                    break;
                }

            } while (list0.contains(answer0));
            // ----------------------------------------------------------------------------------------------------
        } while (!list0.contains(answer0));
        // ----------------------------------------------------------------------------------------------------

        float shanci = 1;
        float length = list0.size();
        shanci = (count / length) * 100;
        System.out.println(shanci + "%"); // Perqindja e te pasurit Covid-19 sipas simptomave
        input.close();
    }
}
