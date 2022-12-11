package interfaces;

import classes.Passport;

public interface PersonService {
    String createPassport();
    Passport getPassportByFirstName();
}
