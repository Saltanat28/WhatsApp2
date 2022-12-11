import enums.Country;
import interfaces.PersonService;
import interfaces.impl.PersonServiceImpl;
import interfaces.impl.WhatsAppServiceImpl;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonServiceImpl personService = new PersonServiceImpl();
        WhatsAppServiceImpl whatsAppService = new WhatsAppServiceImpl();

        mainCycle:
        while(true){
            System.out.print("""
                1. CREATE PASSPORT
                2. GET ALL PASSPORTS
                3. REGISTER TO WHATSAPP
                4. GET ALL WHATSAPP USERS
                5. CHANGE WHATSAPP STATUS
                6. GET ALL WHATSAPP STATUSES
                7. GET ALL COUNTRY
                8. GO TO YOUR PROFILE
                9. GET PASSPORT BY FIRST NAME
                10. GET WHATSAPP STATUS BY USER
                11. ADD CONTACT
                12. SEND MESSAGE
                
                CHOOSE OPTION:\040""");
            int option = new Scanner(System.in).nextInt();
            switch (option){
                case 0 -> {
                    break mainCycle;
                }
                case 1 -> System.out.println(personService.createPassport());
                case 2 -> System.out.println(personService.getPassports());
                case 3 -> System.out.println(whatsAppService.createWhatsAppUser());
                case 4 -> System.out.println(whatsAppService.getProfiles());
                case 5 -> System.out.println(whatsAppService.changeWhatsAppStatus());
                case 6 -> System.out.println(whatsAppService.getWhatsAppStatuses());
                case 7 -> System.out.println("ALL COUNTRIES : " + Arrays.toString(Country.values()));
                case 8 -> System.out.println(whatsAppService.getProfile());
                case 9 -> System.out.println(personService.getPassportByFirstName());
                case 10 -> System.out.println(whatsAppService.getStatus());
                default -> System.out.println("Default Option");
            }
        }
    }
}