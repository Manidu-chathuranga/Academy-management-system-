package ABCChessClub;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean loggedIn = false;
        System.out.println("         ---Welcome to ABC Chess Academy---");
        while (!loggedIn) {
            System.out.print("Enter User ID: ");
            String userID = sc.next();
            System.out.print("Enter Password: ");
            String password = sc.next();

            if (userID.equals("admin") && password.equals("password")) {
                loggedIn = true;
                menu();

            } else if (!loggedIn) {
                System.out.println("Incorect Username Or Password\n\t Please try Again!..");
            }


        }
    }
    public static void menu(){
        Scanner sc = new Scanner(System.in);
        String ans = "y";
        while (ans.equals("y")) {
            System.out.println("=== Welcome to ABC Chess Academy ===\n       ---- Main Menu ----");
            System.out.println(" 1-Display Players Details \n 2-New Player Registration " +
                    "\n 3-Search Player  \n 4-Add Tournament Schedules \n 5-Search Tournaments " +
                    "\n 6-Tournament Details \n 7-Help \n 8-Exit");
            String option = sc.next();
            switch (option) {
                case "1":
                    readFile();
                    break;
                case "2":
                    System.out.println("---Player Registration---");
                    System.out.println("Enter Player First Name:");
                    String fName = sc.next();
                    System.out.println("Enter Player Last Name:");
                    String LName = sc.next();
                    System.out.println("Enter Player DOB (MM/DD/YY):");
                    String dob = sc.next();
                    System.out.println("Player Ratings (0 - 2000):");
                    int rat = sc.nextInt();
                    String line = fName + "   " + LName + "   " + dob + "   " + rat + " \n";
                    writeFile(line);
                    System.out.println("---Player added successfully!---\n");
                    break;
                case "3":
                    System.out.println("Enter player name to search:");
                    String searchName = sc.next();
                    searchPlayer(searchName);
                    break;
                case "4":
                    System.out.println("---Add new tournament Schedule---");
                    System.out.println("Tournament ID (Txxx):");
                    String touID = sc.next();
                    System.out.println("Tournament Name:");
                    String touName = sc.next();
                    System.out.println("Tournament Type (Standard/Quick/Bullet):");
                    String touType = sc.next();
                    System.out.println("Tournament Date (MM/DD/YY):");
                    String touDate = sc.next();
                    System.out.println("Tournament Time (24h format, e.g. 1400):");
                    int touTime = sc.nextInt();
                    System.out.println("Tournament Location (city name):");
                    String touLoc = sc.next();
                    String tou = touID + " " + touName + "   " + touType + "   " + touDate + "   "
                            + touTime + "   " + touLoc + " \n";
                    wirteTou(tou);
                    System.out.println("---Tournament Schedule added successfully---:");
                    break;
                case "5":
                    System.out.println("Enter tournament name to search:");
                    String searchTournament = sc.next();
                    searchTournament(searchTournament);
                    break;
                case "6":
                    readTou();
                    break;
                case "7":
                    readHelp();
                    break;
                case "8":
                    System.out.println("You have successfully logged out ");
                    System.out.println("Come Back!!!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
                    System.out.println("Come back!!!");
            }
            System.out.println("Do you want to continue? (y/n)");
            ans = sc.next();
        }
    }

    public static void searchPlayer(String name) {
        ArrayList<String> players = getList();
        if (players != null) {
            boolean found = false;
            for (String player : players) {
                if (player.toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(player);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No players found with that name");
            }
        }
    }

    public static void searchTournament(String name) {
        ArrayList<String> players = touList();
        if (players != null) {
            boolean found = false;
            for (String player : players) {
                if (player.toLowerCase().contains(name.toLowerCase())) {
                    System.out.println(player);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Can't find tournament Details");
            }
        }
    }

    public static void writeFile(String line) {
        try {
            FileWriter writer = new FileWriter("E:\\Projects\\ChessClub\\student.txt", true);
            writer.write(line);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void wirteTou(String tou) {
        try {
            FileWriter writer = new FileWriter("E:\\Projects\\ChessClub\\tournament.txt", true);
            writer.write(tou);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void readFile() {
        ArrayList<String> list = getList();
        if (list != null) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    public static void readHelp() {
        ArrayList<String> list = helpList();
        if (list != null) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    public static ArrayList<String> getList() {
        ArrayList<String> stdList = new ArrayList<>();
        try {
            File file = new File("E:\\Projects\\ChessClub\\student.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                stdList.add(line);
            }
            sc.close();
            return stdList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public static ArrayList<String> helpList() {
        ArrayList<String> stdList = new ArrayList<>();
        try {
            File file = new File("E:\\Projects\\ChessClub\\help.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                stdList.add(line);
            }
            sc.close();
            return stdList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
    public static void readTou() {
        ArrayList<String> list = touList();
        if (list != null) {
            for (String item : list) {
                System.out.println(item);
            }
        }
    }

    public static ArrayList<String> touList() {
        ArrayList<String> stdList = new ArrayList<>();
        try {
            File file = new File("E:\\Projects\\ChessClub\\tournament.txt");
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                stdList.add(line);
            }
            sc.close();
            return stdList;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}