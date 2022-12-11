package interfaces;

import classes.Profile;
import enums.Status;

import java.util.List;

public interface WhatsAppService {
    String createWhatsAppUser();
    String changeWhatsAppStatus();
    List<Status> getWhatsAppStatuses();
    Profile getProfile();
    Status getStatus();
}
