package com.diyo.uij.ui;

import com.diyo.uij.model.User;
import com.diyo.uij.service.UserService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class UserUi {

    public static void displayUserInfo(User user) {
        System.out.println("Id: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Username: " + user.getUsername());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Mobile number: " + user.getMobileNo());
        System.out.println("Date of Birth: " + user.getDateOfBirth());
        System.out.println("Salary: " + user.getSalary());
    }


    public static User getUserInfo(Scanner sc, boolean isUpdate) {
        User user = new User();
        if (isUpdate) {
            System.out.println("Enter id to update: ");
            int userId = sc.nextInt();
            user.setId(userId);
        }
        System.out.println("Enter name: ");
        String name = sc.next();
        System.out.println("Enter email: ");
        String email = sc.next();
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        System.out.println("Enter mobile number: ");
        long mobileNumber = sc.nextLong();
        System.out.println("Enter salary: ");
        double salary = sc.nextDouble();
        System.out.println("Enter date of birth: ");
        String dob = sc.next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dateOfBirth = sdf.parse(dob);
            user.setDateOfBirth(dateOfBirth);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        user.setName(name);
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setMobileNo(mobileNumber);
        user.setSalary(salary);
        return user;
    }
}
