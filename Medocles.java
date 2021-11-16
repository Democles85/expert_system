import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Medocles {
    static void most_Common_Symptoms() {
        System.out.println("\t Fever?");
        System.out.println("\t Cough?");
        System.out.println("\t Tiredness?");
        System.out.println("\t Loss of Taste or Smell?");
        System.out.println("\t All of them?");
        System.out.print("Shkruani nje nga simptomat e mesiperme: ");
    }

    static void all_Symptoms() {
        System.out.println("\t Fever?");
        System.out.println("\t Cough?");
        System.out.println("\t Tiredness?");
        System.out.println("\t Loss of Taste or Smell?");
        System.out.println("\t Sore throat?");
        System.out.println("\t Headache?");
        System.out.println("\t Aches and pains?");
        System.out.println("\t Diarrhoea?");
        System.out.println("\t Discolouration of fingers?");
        System.out.println("\t Red or irritated eyes?");
        System.out.println("\t All of them?");
        System.out.print("Shkruani nje nga simptomat e mesiperme: ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = 0;
        ArrayList<String> answers = new ArrayList<String>();

        System.out.println("\n\t  Medocles");
        System.out.println("Cfare simptomash po shfaqni?");
        most_Common_Symptoms();
        // Pergjigja per ciklin e pare te pyetjeve
        String answer0;
        answer0 = input.nextLine();
        answer0 = answer0.toLowerCase();
        // ----------------------------------------------------------------------------------------------------

        // Knowledge base arrays
        String[] most_Common_Symptoms = { "fever", "cough", "tiredness", "loss of taste or smell", "loss of taste",
                "loss of smell" };
        String[] less_Common_Symptoms = { "sore throat", "headache", "aches and pains", "diarrhoea",
                "discolouration of fingers", "red or irritated eyes" };
        String[] serious_Symptoms = { "difficulty breathing", "loss of speech", "chest pain" };
        // ----------------------------------------------------------------------------------------------------

        // Kthimi ne lista i knowledge base
        List<String> list0 = Arrays.asList(most_Common_Symptoms);
        List<String> list1 = Arrays.asList(less_Common_Symptoms);
        List<String> list2 = Arrays.asList(serious_Symptoms);
        // ----------------------------------------------------------------------------------------------------

        // Kontrolli nese pergjigjia gjendet ne knowledge base
        do {

            if (list0.contains(answer0)) {
                count++;
                answers.add(answer0);
                System.out.println("||=> Ju shfaqni " + count + " nga simptomat me te zakonshme per Covid-19."
                        + "\n\tAto jane: " + answers);
            } else if (answer0.equals("all of them") || answer0.equals("all of them.")) {
                System.out.println("||=> Ju shfaqni te gjitha simptomat me te zakonshme per Covid-19.");
            } else {
                System.out.println("||=> Simptoma e pershkruar nuk ekziston.");
                System.exit(0);
            }
            // Vazhdimi i pytjeve nese shpreh simptoma te tjera
            do {
                String answer1, answer2;

                System.out.println("Keni simptoma te tjera (po ose jo)? ");

                answer1 = input.nextLine();
                answer1 = answer1.toLowerCase();

                if (answer1.equals("po")) {
                    all_Symptoms();

                    answer2 = input.nextLine();
                    answer2 = answer2.toLowerCase();

                    if (list0.contains(answer2) || list1.contains(answer2) && answer2 != answer0) {
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
        if (answers.size() >= 4) {
            System.out.println("Ju keni 4 ose me shume simptoma per Covid-19!");
        } else {
            System.out.println("Ju keni me pak se 4 simptoma te Covid-19 e si rrjedhoje mos u shqetesoni!");
        }
        input.close();
    }
}
