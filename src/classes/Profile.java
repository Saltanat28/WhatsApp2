package classes;

import enums.Status;

import java.util.List;

public class Profile {
    private long id;
    private String username;
    private String password;
    private String image;
    private String phoneNumber;
    private Status status;
    private List<Profile> contact;
    private List<String[]> messages;

    public Profile(long id, String username, String password, String image, String phoneNumber, Status status, List<Profile> contact, List<String[]> messages) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.image = image;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.contact = contact;
        this.messages = messages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Profile> getContact() {
        return contact;
    }

    public void setContact(List<Profile> contact) {
        this.contact = contact;
    }

    public List<String[]> getMessages() {
        return messages;
    }

    public void setMessages(List<String[]> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "\nProfile{" +
                "\nid=" + id +
                ", \nusername='" + username + '\'' +
                ", \npassword='" + password + '\'' +
                ", \nimage='" + image + '\'' +
                ", \nphoneNumber='" + phoneNumber + '\'' +
                ", \nstatus=" + status +
                ", \ncontact=" + contact +
                ", \nmessages=" + messages +
                "\n*************************\n";
    }
}
