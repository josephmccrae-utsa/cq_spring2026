package edu.utsa.cs3443.codequantumspring2026;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    private ArrayList<User> userList;

    public UserManager() {
        this.userList = new ArrayList<User>();
        loadUsers();
    }


    private void addUser(User user) {
        userList.add(user);
    }

    private void loadUsers() {
        Scanner input = null;
        userList.clear();
        try {
            String line;
            User user;
            File inputFile = new File("data/users.txt");
            input = new Scanner(inputFile);

//            input.nextLine();   // Skips header
            while (input.hasNextLine()) {
                line = input.nextLine();
                user = convertLineToUser(line);
                if (user != null) {
                    addUser(user);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Reading data file: " + e.getMessage());
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private User convertLineToUser(String line) {
        String[] fields = line.split(",");
        if(fields.length != 3) {
            return null;
        }
        return new User(fields[0], fields[1], fields[2]);
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
