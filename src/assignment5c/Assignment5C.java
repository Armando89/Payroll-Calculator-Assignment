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
        //final double BASE_PAY = 200;
        //final double COMMISSION = .10;
        //double wPaycheck, hrRate, otPay, regularPay, priceItems,
        //        totalAmount, totalComm;
        //int hrs, otHours, soldItems;
        int answer;
        String fName, lName, fullName, salEmployee, hrEmployee, commEmployee;
        
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
        //fullName = Name(fName, lName);
        fullName = fName + lName;
    
        salEmployee = Salary(fullName);
        hrEmployee = Hourly(fullName);
        //commEmployee = Commission(fullName);
 
        /*
        Receive an integer of 1 back from each method such that counters will tally the number of weekly paychecks calculated for each type of employee.
        Print out the number of total successful paychecks calculated for each type of employee.
        */
    }

    /*public static String Name(String firstName, String lastName)
    {
        return firstName + lastName;
    }*/
    
    public static String Salary(String Name)
    {
        double yrSal, annBonus, wPaycheck;
        String message;
        
        yrSal = Double.parseDouble(JOptionPane.showInputDialog("Please "
            + "provide the employee's yearly salary:"));

            while (yrSal < 30000 || yrSal > 65000)
            {
                yrSal = Double.parseDouble(JOptionPane.showInputDialog("Invalid input: "
                    + "The amount must be between $30,000 and $65,000."));
            }
        
        annBonus = Double.parseDouble(JOptionPane.showInputDialog("Please provide "
            + "the annual profit bonus percent:"));
        
        wPaycheck = (yrSal * (1 + annBonus)) / 52;
        
        message = String.format("This summary is for employee: %s. The employee's "
            + "yearly salary is $%.2f, which doesn't include the annual profit "
            + "bonus of %.2f percent, and its weekly paycheck amount is $%.2f.", 
            Name, yrSal, annBonus, wPaycheck);
        JOptionPane.showMessageDialog(null, message);
        
        return message;
        
    /*
    Pass back an integer of “1” directly to get added to the counter for the number of salaried employees whose paycheck has been calculated
    */  
    }
    
    public static String Hourly(String Name)
    {
        int hrs, otHours;
        double hrRate, otPay, regularPay, wPaycheck;
        String message;
        
        hrRate = Double.parseDouble(JOptionPane.showInputDialog("Please provide "
            + "the employee's hourly rate:"));
                        
            while (hrRate < 10 || hrRate > 25)
                {
                    hrRate = Double.parseDouble(JOptionPane.showInputDialog("Invalid "
                        + "input: The amount must be between $10.00 and $25.00."));
                }
                    
        hrs = Integer.parseInt(JOptionPane.showInputDialog("Please provide the "
            + "total number of hours worked:"));
                        
            while (hrs <= 0)
                {
                    hrs = Integer.parseInt(JOptionPane.showInputDialog("Invalid "
                        + "input: The number of hours must be greater than 0."));
                }
                        
            if (hrs > 40)
            { 
                otHours = Integer.parseInt(JOptionPane.showInputDialog("Please "
                    + "provide the number of overtime hours worked:"));

                otPay = ((hrRate * 1.5) * otHours);
                regularPay = hrRate * 40;
                wPaycheck = regularPay + otPay;

                message = String.format("This summary is for employee: %s. The "
                    + "employee's regular pay amount is $%.2f and its overtime "
                    + "pay amount is $%.2f. Overall, the employee's weekly paycheck "
                    + "amount equals to $%.2f.", Name, regularPay, otPay, wPaycheck);
                JOptionPane.showMessageDialog(null, message);
            }
            else
            {
                otPay = 0;
                regularPay = hrRate * hrs;
                wPaycheck = regularPay + otPay;

                message = String.format("This summary is for employee: %s. Since "
                    + "the employee did not work any overtime, its overtime pay "
                    + "equals $%.2f and its weekly paycheck/regular pay amount is "
                    + "$%.2f.", Name, otPay, wPaycheck);
                JOptionPane.showMessageDialog(null, message);
            }
        
        return message;
        
    /*
    Pass back an integer of “1” directly to get added to the counter for the number of hourly employees whose paycheck has been calculated    
    */
    }
    
    
    
        
        
        
        
  
}
