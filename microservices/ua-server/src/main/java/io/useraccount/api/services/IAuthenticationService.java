package io.useraccount.api.services;

public interface IAuthenticationService {
    String hashPassword(String password);
    boolean checkPassword(String password,String hashedPassword);
}
