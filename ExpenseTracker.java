import java.io.*;
import java.util.*;

public class ExpenseTracker{
    public static void main(String[] args){
        ArrayList<Expense> expenses = load();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("What would you like to do? 1 Add, 2 List, 3 Total, 4 Quit");
            String choice = sc.nextLine();
            if(choice.equals("4")){ 
                save(expenses);
                System.out.println("Goodbye!");
                break;
            }
            else if(choice.equals("1")){
                System.out.println("What is the description for this expense?");
                String desc = sc.nextLine().replace(",", " ");
                System.out.println("What was the amount of this expense?");
                double amount;
                try {
                    amount = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Enter a number.");
                    continue;   // back to the menu
                }
                if(amount <= 0){
                    System.out.println("Amount must be more than 0.");
                    continue;
                }
                System.out.println("What category is this expense?");
                String cat = sc.nextLine().replace(",", " ");
                expenses.add(new Expense(desc, amount, cat));
                System.out.println("Expense added");
            }
            else if(choice.equals("2")){
                if(expenses.isEmpty()) System.out.println("No expenses yet.");
                else{
                    int count = 1;
                    for(Expense e : expenses){
                        System.out.println(count + ": "+ e);
                        count++;
                    }
                }
            }
            else if(choice.equals("3")){
                double total = 0.0;
                for(Expense e : expenses){
                    total += e.getAmount();
                }
                System.out.printf("Total amount: $%.2f%n", total);
            }
            else System.out.println("Pick 1-4.");
        }
    }
    static void save(ArrayList<Expense> expenses){
        try(PrintWriter out = new PrintWriter(new FileWriter("expenses.txt"))){
            for(Expense e : expenses){
                out.println(e.getDescription() + "," + e.getAmount() + "," + e.getCategory());
            } 
        } catch (IOException ex) {
            System.out.println("Could not save: " + ex.getMessage());
        }
    }
    static ArrayList<Expense> load(){
        ArrayList<Expense> list = new ArrayList<>();
        File f = new File("expenses.txt");
        if (!f.exists()) return list;

        try (Scanner in = new Scanner(f)) {
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.isBlank()) continue;
                String[] parts = line.split(",");
                String description = parts[0];
                double amount = Double.parseDouble(parts[1]);
                String category = parts[2];
                list.add(new Expense(description, amount, category));
            }
        } catch (IOException ex) {
            System.out.println("Could not load: " + ex.getMessage());
        }
        return list;
    }
}
