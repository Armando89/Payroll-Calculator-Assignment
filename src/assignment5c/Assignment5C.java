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
        int salPaychecks = 0;
        int hrPaychecks = 0;
        int commPaychecks = 0;
        String fName, lName, fullName, salEmployee, hrEmployee, commEmployee, message;
        
        JOptionPane.showMessageDialog(null, "Welcome to the HR Payroll Program.");
        
        do
        {
            answer = Integer.parseInt(JOptionPane.showInputDialog("Please provide "
                + "the following information: If the employee is salary enter a 1, "
                + "if the employee is hourly enter a 2, if the employee is commission "
                + "enter a 3, or to exit the program enter a 4."));

                while (answer < 1 || answer > 4)
                {
                    answer = Integer.parseInt(JOptionPane.showInputDialog("Invalid "
                        + "input: Please provide a number between 1 and 4."));
                }
            
            switch (answer)
            {
                case 1:
                    fName = JOptionPane.showInputDialog("Please enter your first "
                        + "name:");
                    lName = JOptionPane.showInputDialog("Please enter your last "
                        + "name:");
            
                    salEmployee = Salary(fName, lName);
                    salPaychecks++;
                    break;
                    
                case 2:
                    fName = JOptionPane.showInputDialog("Please enter your first "
                        + "name:");
                    lName = JOptionPane.showInputDialog("Please enter your last "
                        + "name:");
            
                    hrEmployee = Hourly(fName, lName);
                    hrPaychecks++;
                    break;
                    
                case 3:
                    fName = JOptionPane.showInputDialog("Please enter your first "
                        + "name:");
                    lName = JOptionPane.showInputDialog("Please enter your last "
                        + "name:");
            
                    commEmployee = Commission(fName, lName);
                    commPaychecks++;
                    break;
            }
        } while (answer != 4);
        
        message = String.format("The total number of Salary paychecks calculated "
            + "is %s. The total number of Hourly paychecks calculated is %s. "
            + "The total number of Commission paychecks calculated is %s.", 
            salPaychecks, hrPaychecks, commPaychecks);
        JOptionPane.showMessageDialog(null, message);
    }

    public static String Salary(String firstName, String lastName)
    {
        double yrSal, annBonus, wPaycheck;
        String message;
        
        yrSal = Double.parseDouble(JOptionPane.showInputDialog("Please provide "
            + "your yearly salary:"));

            while (yrSal < 35000 || yrSal > 65000)
            {
                yrSal = Double.parseDouble(JOptionPane.showInputDialog("Invalid "
                    + "input: The amount must be between $35,000 and $65,000."));
            }
        
        annBonus = Double.parseDouble(JOptionPane.showInputDialog("Please provide "
            + "your company's annual profit bonus percent:"));
        
        wPaycheck = (yrSal * (1 + annBonus)) / 52;
        
        message = String.format("This summary is for employee: %s %s. The employee's "
            + "yearly salary is $%.2f, which doesn't include the annual profit "
            + "bonus of %.2f percent, and the weekly paycheck amount is $%.2f.", 
            firstName, lastName, yrSal, annBonus, wPaycheck);
        JOptionPane.showMessageDialog(null, message);
        
        return message; 
    }
    
    public static String Hourly(String firstName, String lastName)
    {
        int hrs, otHours;
        double hrRate, otPay, regularPay, wPaycheck;
        String message;
        
        hrRate = Double.parseDouble(JOptionPane.showInputDialog("Please provide "
            + "your hourly rate:"));
                        
            while (hrRate < 15 || hrRate > 25)
                {
                    hrRate = Double.parseDouble(JOptionPane.showInputDialog("Invalid "
                        + "input: The amount must be between $15.00 and $25.00."));
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

                message = String.format("This summary is for employee: %s %s. The "
                    + "employee's regular pay amount is $%.2f and its overtime "
                    + "pay amount is $%.2f. Overall, the employee's weekly paycheck "
                    + "amount equals to $%.2f.", firstName, lastName, regularPay, 
                    otPay, wPaycheck);
                JOptionPane.showMessageDialog(null, message);
            }
            else
            {
                otPay = 0;
                regularPay = hrRate * hrs;
                wPaycheck = regularPay + otPay;

                message = String.format("This summary is for employee: %s %s. "
                    + "Since the employee did not work any overtime, the overtime "
                    + "pay is $%.2f and the weekly paycheck/regular pay amount "
                    + "equals to $%.2f.", firstName, lastName, otPay, wPaycheck);
                JOptionPane.showMessageDialog(null, message);
            }
        
        return message;
    }
    
    public static String Commission(String firstName, String lastName)
    {
        final double COMMISSION = .10;
        final double BASE_PAY = 200;
        double priceItems, totalAmount, totalComm, wPaycheck;
        int soldItems;
        String message;
        
        soldItems = Integer.parseInt(JOptionPane.showInputDialog("Please enter "
            + "the number of items sold:"));
                    
            while (soldItems < 0 || soldItems > 500)
            {
                soldItems = Integer.parseInt(JOptionPane.showInputDialog("Invalid "
                    + "input: The number of items sold must be a positive number "
                    + "and should not exceed the quantity of 500."));
            }
                        
        priceItems = Double.parseDouble(JOptionPane.showInputDialog("Please enter "
            + "the price of the item(s):"));
                    
        totalAmount = (double)soldItems * priceItems;
        totalComm = totalAmount * COMMISSION;
        wPaycheck = totalComm + BASE_PAY;
                    
        message = String.format("This summary is for employee: %s %s. The total "
            + "amount for the item(s) sold is $%.2f. The employee's commission "
            + "amount equals to $%.2f and the total paycheck amount comes to $%.2f.", 
            firstName, lastName, totalAmount, totalComm, wPaycheck);
        JOptionPane.showMessageDialog(null, message);
    
        return message;
    }
}
