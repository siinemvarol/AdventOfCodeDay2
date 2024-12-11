import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> reports = new ArrayList<>();
        BufferedReader reader;

        try {
            reader = new BufferedReader(new FileReader("day2.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] splitted = line.split(" ");
                ArrayList<Integer> report = new ArrayList<>();
                for (int i = 0; i < splitted.length; i++) {
                    report.add(Integer.valueOf(splitted[i]));
                }
                reports.add(report);
                line = reader.readLine();
            }
            reader.close();

//            System.out.println("reports list is...");
//            System.out.println(reports);

            int safeReportCount = 0;

            for (int i = 0; i < reports.size(); i++) {
                boolean leastOneMostThree = false;
                boolean increase = false;
                boolean decrease = false;
                for (int j = 0; j < reports.get(i).size() -1; j++) {
                    if(reports.get(i).get(j) != reports.get(i).get(j+1)) {
                        int difference = Math.abs(reports.get(i).get(j)-reports.get(i).get(j+1));
                        if(reports.get(i).get(j) > reports.get(i).get(j+1)) {
                            decrease = true;
                        }
                        if(reports.get(i).get(j) < reports.get(i).get(j+1)) {
                            increase = true;
                        }
                        if(difference >= 1 && difference <= 3) {
                            leastOneMostThree = true;
                        } else {
                            leastOneMostThree = false;
                            break;
                        }
                    } else {
                        leastOneMostThree = false;
                       break;
                    }
                }
                if(((decrease && !increase) || (!decrease && increase)) && leastOneMostThree) {
                    safeReportCount++;
    //                System.out.println("safe report is... " + reports.get(i));
                }
            }
            System.out.println("Count of safe reports is... " + safeReportCount);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}