package contactManager;

import java.util.*;

class Contact{
    private String name;
    private String contact;
    private String email;

    Contact(String name, String contact, String email){
        this.name=name;
        this.contact=contact;
        this.email=email;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setContact(String contact){
        this.contact=contact;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getName(){
        return name;
    }
    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Username: "+name+" , Contact: "+contact+" , Email Address "+email;
    }
}


public class ContactBook {
    static ArrayList<Contact> contactList=new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(true) {
            System.out.println("Welcome to Contact Management System");
            System.out.println("1. Add Contact\n2. View Contact\n3. Update Contact\n4. Delete Contact\n5. Exit?");
            System.out.print("Choose a command: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    displayAllPerson();
                    break;
                case 3:
                    modifyPerson();
                    break;
                case 4:
                    deletePerson();
                    break;
                case 5:
                    System.out.println("Thank You,Exiting......");
                    return;
                default:
                    System.out.println("Invalid Choice, Please enter valid number");
            }
        }


    }
    public static void addPerson(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter the Name of the Person: ");
        String name=sc.nextLine();
        System.out.print("Enter the Contact of the Person: ");
        String contact=sc.nextLine();
        System.out.print("Enter the E-Mail of the Person: ");
        String email=sc.nextLine();
        Contact con= new Contact(name,contact,email);
        contactList.add(con);
        System.out.println("Data added Successfully!");
    }
    public static void displayAllPerson(){
        Scanner sc= new Scanner(System.in);
        if(contactList.isEmpty()){
            System.out.println("SORRY,No Contacts to show");
        }
        else{
            for(int i=0; i< contactList.size(); i++){
                System.out.println((i+1)+": "+ contactList.get(i));
            }
        }

    }
    public static void modifyPerson(){
        Scanner sc = new Scanner(System.in);
        displayAllPerson();
        System.out.println("Enter the number of contact you want to change: ");
        int idx=sc.nextInt()-1;
        sc.nextLine();
        if(idx>=0 && idx< contactList.size()){
            Contact con= contactList.get(idx);
            System.out.println("If you want to change the name then type it or else press enter to skip this part: ");
            String name= sc.nextLine();
            if(!name.isEmpty()){
                con.setName(name);
            }
            System.out.println("If you want to change the contact then type it or else press enter to skip this part: ");
            String contact= sc.nextLine();
            if(!contact.isEmpty()){
                con.setContact(contact);
            }
            System.out.println("If you want to change the email then type it or else press enter to skip this part: ");
            String email= sc.nextLine();
            if(!email.isEmpty()){
                con.setEmail(email);
            }
            System.out.println("Person details updated");

        }
        else{
            System.out.println("Invalid Choice! Choose a valid number");
        }

    }
    public static void deletePerson(){
        Scanner sc= new Scanner(System.in);
        displayAllPerson();
        System.out.println("Enter the number of the contact you want to delete: ");
        int idx= sc.nextInt()-1;
        if(idx>=0 && idx<contactList.size()){
            contactList.remove(idx);
            System.out.println("Person Removed Successfully");
        }
        else{
            System.out.println("Invalid Input");
        }

    }

}
