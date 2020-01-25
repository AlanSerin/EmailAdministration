package emailapp;

import java.util.Scanner;

class user{
     String name;
     String surname;
     String department;

     public String displayName(){
         return name+" " + surname;
     }
}

public class email extends user{
    String address;
    String password;
    int mailboxcapacity = 500;
    String alternatemail;
    email(){
        Scanner input = new Scanner(System.in);
        System.out.println("Type your name and surname");
        name = input.next();
        surname = input.next();
        System.out.println("Enter department");
        department = input.next();
        generateEmail();
    }
    email(String name,String surname,String department){
        this.name = name;
        this.surname = surname;
        this.department = department;
        generateEmail();
    }

    public void generateEmail() {
        switch (department){
            case "Sales":
            case "SALES":
            case "sales":
                address = name.toLowerCase()+"."+surname.toLowerCase()
                        +"@"+department.toLowerCase()+".company.com";
                break;
            case "development":
            case "Development":
            case "DEVELOPMENT":
                address = name.toLowerCase()+"."+surname.toLowerCase()
                        +"@"+"development.company.com";
                break;
            case "accounting":
            case "Accounting":
            case "ACCOUNTING":
                address = name.toLowerCase()+"."+surname.toLowerCase()
                        +"@"+"accounting.company.com";
                break;
            default: address = name.toLowerCase()+"."+surname.toLowerCase()
                    +"@company.com";
        }
        generatePassword();
    }
    public void generatePassword() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
            password = sb.toString();
        }
        System.out.println("Password: "+ password);
        System.out.println("Account created");
    }
    public String displayemail(){
        return address;
    }
    public int displaymailboxcapacity(){
        return mailboxcapacity;
    }
    public String displaytAltEmail(){
        return alternatemail;
    }
    public String displayPassword(){
        return password;
    }
    public void setMailboxcapacity(int capacity){
        mailboxcapacity = capacity;
    }
    public void setAlternatemail(String alt){
        alternatemail = alt;
    }
    public void changePassword(String pw){
        password = pw;
    }

    public String DisplayInfo(){
        return "Name: " + displayName()+"\nEmail: " + displayemail() +"\nMailboxcapacity: "+ displaymailboxcapacity();
    }
}
