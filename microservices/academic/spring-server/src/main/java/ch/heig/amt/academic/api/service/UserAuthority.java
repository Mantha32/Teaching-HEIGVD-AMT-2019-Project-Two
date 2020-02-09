package ch.heig.amt.academic.api.service;



public class UserAuthority {
    private String email;
    private boolean isAdmin;

    public UserAuthority(){}
    public UserAuthority(String mail, boolean isAdmin){
        this.email = mail;
        this.isAdmin = isAdmin;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isAdmin(){return isAdmin;}
    public  String getEmail(){return email;}


}
