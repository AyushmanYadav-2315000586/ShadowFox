package Calculator;

import java.util.*;

public class EnhancedCalculator {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int opt=0;
        while(true){
            System.out.println("!Welcome to enhanced calculator!");
            System.out.println("1. Basic Operations");
            System.out.println("2. Scientific Operations");
            System.out.println("3. UnitConversion");
            System.out.println("4. Exit");
            System.out.print("Choose an Option: ");
            try{
                opt= sc.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input, Please enter a number");
                sc.next();
                continue;
            }

            switch (opt){
                case 1:
                    basic();
                    break;
                case 2:
                    sciCal();
                    break;
                case 3:
                    unitConve();
                    break;
                case 4:
                    System.out.println("Thank You!");
                    return;
                default:
                    System.out.println("!!! Invalid Choice !!!, Please try again");
            }
        }
    }

    public static void basic(){
        Scanner sc= new Scanner(System.in);
        System.out.println("\nBasic Operations");
        System.out.println("Choose Operation: \n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        int cnt=0;
        while(true) {
            System.out.print("Enter the number of values to operate on: ");
            try {
                cnt = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input, Please enter a valid number");
                sc.next();
            }
        }
        double []nums= new double[cnt];
        for(int i=0; i<cnt; i++){
            while (true) {
                System.out.print("Enter number " + (i + 1) + " : ");
                try {
                    nums[i] = sc.nextDouble();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input! Please enter a valid number");
                    sc.next();
                }
            }
        }
        int opr=0;
        while (true) {
            System.out.println("Choose Operations (1-4): ");
            try {
                opr = sc.nextInt();
                if (opr == 0) {
                    return;
                }
                if (opr<0 || opr>4){
                    System.out.println("Invalid Input! Please choose operation between 1 to 4");
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input, Please enter a Valid number");
                sc.next();
            }
        }
        double res=nums[0];
        switch (opr){
            case 1:
                for (int i=1; i<cnt; i++){
                    res+=nums[i];
                }
                System.out.println("Result: "+res);
                break;
            case 2:
                for(int i=1; i<cnt; i++){
                    res-=nums[i];
                }
                System.out.println("Result: "+res);
                break;
            case 3:
                for(int i=1; i<cnt; i++){
                    res*=nums[i];
                }
                System.out.println("Result: "+res);
                break;
            case 4:
                for(int i=1; i<cnt; i++){
                    if(nums[i]!=0){
                        res/=nums[i];
                    }
                    else{
                        System.out.println("Error Division! Divide by Zero");
                        return;
                    }
                }
                System.out.println("Result: "+res);
                break;
        }
    }

    public static void sciCal(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nScientific Operations");
        System.out.println("1. Square Root\n2. Exponents");
        System.out.print("Choose Operation: ");
        int opr=0;
        while(true){
            try{
                opr=sc.nextInt();
                if(opr<0||opr>2){
                    System.out.println("Invalid Choice! Choose an option between (1-2)");
                }
                else {
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input! Please enter a number");
                sc.next();
            }
        }
        if (opr == 0) {
            return;
        }
        switch (opr){
            case 1:
                System.out.print("Enter a number: ");
                double num=0;
                while (true){
                    try {
                        num=sc.nextDouble();
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("Square Root: "+Math.sqrt(num));
                break;
            case 2:
                double base=0;
                double exp=0;
                System.out.println("Enter Base:");
                while (true){
                    try {
                        base=sc.nextDouble();
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("Enter Exponent: ");
                while (true){
                    try{
                        exp=sc.nextDouble();
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Invalid input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("Result: "+Math.pow(base,exp));
            default:
                System.out.println("Invalid Input");
        }

    }

    public static void unitConve(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nUnit Conversion");
        System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius\n3. INR to USD\n4. USD to INR\n5. IND to AUD\n6. AUD to INR");
        System.out.print("Choose Conversion: ");
        int opr=0;
        while (true){
            try {
                opr=sc.nextInt();
                if(opr<0||opr>6){
                    System.out.println("!Please enter an input within range(1-6)!");
                }
                else{
                    break;
                }
            }
            catch (InputMismatchException e){
                System.out.println("Invalid Input , Please enter a valid input");
                sc.next();
            }
        }
        if (opr == 0) {
            return;
        }

        switch (opr){
            case 1:
                System.out.print("Enter the Temperature in Celsius: ");
                double cel=0;
                while (true) {
                    try {
                        cel = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("Fahrenheit: "+((cel*9/5)+32));
                break;
            case 2:
                System.out.print("Enter the Temperature in Fahrenheit: ");
                double far=0;
                while (true) {
                    try {
                        far = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("Celsius: "+((far-32)*5/9));
                break;
            case 3:
                System.out.print("Enter the amount in INR: ");
                double inr=0;
                while (true){
                    try {
                        inr = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("USD: "+(inr*0.012));
                break;
            case 4:
                System.out.print("Enter the amount in USD: ");
                double usd=0;
                while (true){
                    try {
                        usd = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("INR: "+(usd*85.73));
                break;
            case 5:
                System.out.print("Enter the amount in INR: ");
                double INR=0;
                while (true){
                    try {
                        INR = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("AUD: "+(INR*0.019));
                break;
            case 6:
                System.out.print("Enter the amount in AUD: ");
                double aud=0;
                while (true){
                    try {
                        aud = sc.nextDouble();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Input! Please enter a valid number");
                        sc.next();
                    }
                }
                System.out.println("INR: "+(aud*53.31));
                break;

        }

    }

}
