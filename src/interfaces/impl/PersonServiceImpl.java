package interfaces.impl;

import classes.Passport;
import enums.Country;
import enums.Gender;
import interfaces.PersonService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonServiceImpl implements PersonService {
    private List<Passport> passports = new ArrayList<>();

    public List<Passport> getPassports() {
        return passports;
    }

    public void setPassports(List<Passport> passports) {
        this.passports = passports;
    }


    @Override
    public String createPassport() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter ID : ");
            long id = scanner.nextLong();

            System.out.print("Enter your name : ");
            String name = new Scanner(System.in).nextLine();

            System.out.print("Enter your last name : ");
            String lastName = new Scanner(System.in).nextLine();

            System.out.print("Enter your gender : ");
            String gender = new Scanner(System.in).nextLine();

            System.out.print("Enter your country : ");
            String country = new Scanner(System.in).nextLine();

            System.out.print("Enter your date of birth (yy-mm-dd) : ");
            String[] dateOfBirthList = new Scanner(System.in).nextLine().trim().split("-");

            if(id <= 0) throw new Exception("ID can't be negative a number.");
            if((name.isEmpty() || name.matches("[0-9]+") ||
                    (lastName.isEmpty() || lastName.matches("[0-9]+"))))
                throw new Exception("Name & Last Name Validation Error. Please make sure name & lastName are valid.");
            if(!gender.equals("MALE") && !gender.equals("FEMALE"))
                throw new Exception("Gender validation Error. Please, Enter a valid GENDER.");

            if(country.isEmpty() || country.matches("[0-9]+"))
                throw new Exception("Country validation Error. Please, Enter a valid COUNTRY.");

            if(dateOfBirthList.length != 3)
                throw new Exception("Date of birth validation Error. Please, Enter a valid DATE OF BIRTH.");

            LocalDate dateOfBirth = LocalDate.of(
                    Integer.parseInt(dateOfBirthList[0]),
                    Integer.parseInt(dateOfBirthList[1]),
                    Integer.parseInt(dateOfBirthList[2])
            );

            Passport newPassport = new Passport(
                    id,name,lastName,dateOfBirth, Country.valueOf(country), Gender.valueOf(gender));

            passports.add(newPassport);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "Passport CREATED successfully!";
    }

    @Override
    public Passport getPassportByFirstName() {
        try {
            System.out.print("Enter your first name : ");
            String firstName = new Scanner(System.in).nextLine();

            if (firstName.isEmpty())
                throw new Exception("first name can't be empty.");

            for (Passport passport : passports) {
                if(passport.getName().equals(firstName)){
                    return passport;
                }
            }
            throw new Exception("Passport was not found. Please provide a valid first name.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
