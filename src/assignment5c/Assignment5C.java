//Armando Galan-Cedeño  Assignment5C
//CS121 Spring 2020
//April 2, 2020
//Purpose: Payroll Calculator - Modify 4B - add methods and a frequency counter

package assignment5c;
import javax.swing.JOptionPane;

public class Assignment5C 
{
    public static void main(String[] args) 
    {
        int answer;
        String fName, lName, fullName, message;
        
        JOptionPane.showMessageDialog(null, "Welcome to the HR Payroll Program.");
        answer = Integer.parseInt(JOptionPane.showInputDialog("Please provide "
            + "the following information: If the employee is salary enter a 1, if "
            + "the employee is hourly enter a 2, if the employee is commission "
            + "enter a 3, or to exit the program enter a 4."));
        
        while (answer < 1 || answer > 4)
        {
            answer = Integer.parseInt(JOptionPane.showInputDialog("Invalid input: "
                + "Please provide a number between 1 and 4."));
        }
        
        fName = JOptionPane.showInputDialog("Please enter your first name:");
        lName = JOptionPane.showInputDialog("Please enter your last name:");
        
        fullName = Name(fName, lName);
        
        message = String.format("Your full name is %s %s.", fName, lName);
        JOptionPane.showMessageDialog(null, message);
    
        
        
        /*
        Receive an integer of 1 back from each method such that counters will tally the number of weekly paychecks calculated for each type of employee.
        Print out the number of total successful paychecks calculated for each type of employee.
        */
    }

    public static String Name(String firstName, String lastName)
    {
        return firstName + lastName;
    }
    
    /*public static
    {
        
    }*/
        
    /*
    Prompt the user to enter their yearly pay amount and the company profit bonus percent
    Calculate their weekly pay
    Print out the employee’s name, total yearly salary plus profit bonus and this week's paycheck amount
    Pass back an integer of “1” directly to get added to the counter for the number of salaried employees whose paycheck has been calculated
    */
    
    
        
        
        
        
  
}
