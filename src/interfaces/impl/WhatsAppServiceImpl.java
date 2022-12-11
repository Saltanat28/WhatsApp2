package interfaces.impl;

import classes.Passport;
import classes.Profile;
import enums.Status;
import interfaces.WhatsAppService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WhatsAppServiceImpl implements WhatsAppService {
    private List<Profile> profiles = new ArrayList<>();

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String createWhatsAppUser() {
        try {
            System.out.print("Enter ID : ");
            long id = new Scanner(System.in).nextLong();

            System.out.print("Enter your username : ");
            String username = new Scanner(System.in).nextLine().toLowerCase();

            System.out.print("Enter your password : ");
            String password = new Scanner(System.in).nextLine();

            System.out.print("Enter your phone number : ");
            String phoneNumber = new Scanner(System.in).nextLine().trim().toLowerCase();

            System.out.print("Enter your image link : ");
            String image = new Scanner(System.in).nextLine();


            if(id <= 0) throw new Exception("ID validation Error. ID must be greater than 0.");
            if(username.isEmpty() || username.matches("[0-9]+"))
                throw new Exception("Username validation Error. Username must contain only letters.");
            if(password.length() < 5 || username.length() < 5)
                throw new Exception("Username || Password validation ERROR. Username & Password must contain 5 or more letters.");
            if(phoneNumber.length() != 13 || !phoneNumber.startsWith("+996"))
                throw new Exception("Phone number validation Error. Please Enter a valid PHONE NUMBER!");

            if(image.isEmpty())
                throw new Exception("Image can't be EMPTY!");

            List<Profile> contacts = new ArrayList<>();
            List<String[]> messages = new ArrayList<>();
            Profile newProfile =
                    new Profile(id,username,password,image,phoneNumber, Status.HEY_I_USE_WHATSAPP,contacts,messages);

            profiles.add(newProfile);
            return "WhatsApp User is CREATED successfully!";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "WhatsApp USER creation FAILED!";
    }

    @Override
    public String changeWhatsAppStatus() {
        try {
            System.out.print("Enter your username : ");
            String username = new Scanner(System.in).nextLine().toLowerCase();

            System.out.print("Enter your password");
            String password = new Scanner(System.in).nextLine();


            if(username.length() < 5)
                throw new Exception("Username validation Error. Username must have 5 letters or more.");
            if(password.length() < 5)
                throw new Exception("Password validation Error. Password must have 5 letters or more.");

            for (Profile profile : profiles) {
                if(profile.getUsername().equals(username) && profile.getPassword().equals(password)){
                    System.out.println("ALL WHATSAPP STATUSES : " + Arrays.toString(Status.values()));
                    System.out.print("Enter your STATUS index : ");
                    int index = new Scanner(System.in).nextInt();
                    if(index < 0 || index > Status.values().length - 1)
                        throw new Exception("Status index validation error. Please enter a valid index number.");
                    profile.setStatus(Status.values()[index]);
                    return "WhatsApp Status CHANGED successfully!";
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "WHATSAPP status Change FAILED!";
    }

    @Override
    public List<Status> getWhatsAppStatuses() {
        return List.of(Status.values());
    }

    @Override
    public Profile getProfile() {
        try {
            System.out.print("Enter your username : ");
            String username = new Scanner(System.in).nextLine().toLowerCase();

            System.out.print("Enter your password : ");
            String password = new Scanner(System.in).nextLine();

            if (username.length() < 5 || password.length() < 5)
                throw new Exception("Username or Password validation Error. Please enter a valid username & password.");

            for (Profile profile : profiles) {
                if(profile.getUsername().equals(username) && profile.getPassword().equals(password)){
                    return profile;
                }
            }
            throw new Exception("User was not found! Please make you entered a valid username & password.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Status getStatus() {
        try {
            System.out.print("Enter your username : ");
            String username = new Scanner(System.in).nextLine().toLowerCase();

            System.out.print("Enter your password : ");
            String password = new Scanner(System.in).nextLine();

            if(username.length() < 5 || password.length() < 5)
                throw new Exception("Username & Password validation Error. Username or Password must contain 5 letters or more.");

            for (Profile profile : profiles) {
                if(profile.getUsername().equals(username) && profile.getPassword().equals(password)) {
                    return profile.getStatus();
                }
            }
            throw new Exception("User was not found! Please provide a valid Username or Password.");
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
