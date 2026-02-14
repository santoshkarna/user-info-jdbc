package com.diyo.uij.controller;

import com.diyo.uij.model.User;
import com.diyo.uij.service.UserService;
import com.diyo.uij.service.UserServiceImpl;
import com.diyo.uij.ui.UserUi;

import java.util.List;
import java.util.Scanner;

//this is controller class
public class UserController {

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        Scanner sc = new Scanner(System.in);
        String decision;
        do {
            System.out.println("Enter add|update|delete|list|get");
            String choice = sc.next();
            switch (choice) {
                case "add":
                    User user = UserUi.getUserInfo(sc, false);
                    int saved = userService.insertUser(user);
                    if (saved > 0) {
                        System.out.println("User info saved successfully!!!");
                    } else {
                        System.out.println("Error in DB while inserting user!!!");
                    }
                    break;
                case "update":
                    User updateUser = UserUi.getUserInfo(sc, true);
                    int updated = userService.updateUser(updateUser);
                    if (updated > 0) {
                        System.out.println("User info updated successfully!!!");
                    } else {
                        System.out.println("Error in DB while updating user!!!");
                    }
                    break;
                case "delete":
                    System.out.println("Enter id to delete: ");
                    int id = sc.nextInt();
                    int deleted = userService.deleteUser(id);
                    if (deleted > 0) {
                        System.out.println("User deleted successfully!!!");
                    } else {
                        System.out.println("Error in DB while deleting user!!!");
                    }
                    break;
                case "list":
                    List<User> users = userService.findAllUsers();
                    for (User uu: users) {
                        UserUi.displayUserInfo(uu);
                        System.out.println("==============");
                    }
                    break;
                case "get":
                    System.out.println("Enter id to get: ");
                    int userId = sc.nextInt();
                    User u = userService.findUserById(userId);
                    UserUi.displayUserInfo(u);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Do you want to continue? (y/n)");
            decision = sc.next();
        }while(decision.equalsIgnoreCase("Y"));
        System.out.println("Goodbye!See you again!");
    }

}
