package org.example.services;
import org.example.Train;
import org.example.User;
import org.example.services.util.UserServiceUtil;

import java.io.IOException;
import java.util.*;


public class app {



    public static void main (String[] args){
        System.out.println("Running Train Booking System");
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        UserBookingService userBookingService;
        try {
            userBookingService = new UserBookingService(userTologin);
        }catch(IOException ex){
            System.out.println("There is somthing wrong");
            return;

        }
        while(option != 7){
            System.out.println("Choose option");
            System.out.println("1. sign up");
            System.out.println("2. login");
            System.out.println("3. fetch bookings");
            System.out.println("4. search trains");
            System.out.println("5. book a seat");
            System.out.println("6. cancel my booking");
            System.out.println("7. exit the app");
            option = scanner.nextInt();

            switch(option){
                case 1:
                    System.out.println("enter the username to signup");
                    String nameToSignUp = scanner.next();
                    System.out.println("enter the password to signup");
                    String passwordToSignUp = scanner.next();
                    User userToSignup = new User(nameToSignUp, passwordToSignUp,
                            UserServiceUtil.hashPassword(passwordToSignUp),
                            new ArrayList<>() , UUID.randomUUID().toString());
                    userBookingService.signUp(userToSignup);
                    break;

                case 2:
                    System.out.println("enter the username to login");
                    String nameToLogin = scanner.next();
                    System.out.println("enter the password to signup");
                    String passwordToLogin = scanner.next();
                    User userTologin = new User (nameToLogin, passwordToLogin,
                            UserServiceUtil.hashPassword(passwordToLogin),
                            new ArrayList<>(),UUID.randomUUID().toString());
                    try{
                        userBookingService = new UserBookingService(userTologin);

                    }catch (IOException ex){
                        return;

                    }
                    break;
                case 3:
                    System.out.println("Fetching your booking");
                    userBookingService.fetchBooking();
                    break;
                case 4:
                    System.out.println("type your source station");
                    String source = scanner.next();
                    System.out.println("type your destination station");
                    String dest = scanner.next();
                    List<Train> trains = userBookingService.getTrains(source,dest);
                    int index = 1;
                    for(Train t: trains){
                        System.out.println(index+"Train id :" +t.getTrainId());
                        for (Map.Entry<String, String> entry: t.getStationTimes().entrySet()){
                            System.out.println("station"+entry.getKey()+ " time:"+entry.getValue());

                        }
                    }
                    System.out.println("Select a train by typing 1,2,3...");
                    Train trainSelectedForBooking = trains.get(scanner.nextInt());
                    break;

                case 5:
                    System.out.println("Select a seat out of these seats");
                    List<List<Integer>> seats = userBookingService.fetchSeats(trainSelectedForBooking);
                    for (List<Integer> row: seats){
                        for (Integer val: row){
                            System.out.print(val+" ");
                        }
                        System.out.println();
                    }
                    System.out.println("Select the seat by typing the row and column");
                    System.out.println("Enter the row");
                    int row = scanner.nextInt();
                    System.out.println("Enter the column");
                    int col = scanner.nextInt();
                    System.out.println("Booking your seat....");
                    Boolean booked = userBookingService.bookTrainSeat(trainSelectedForBooking, row, col);
                    if(booked.equals(Boolean.TRUE)){
                        System.out.println("Booked! Enjoy your journey");
                    }else{
                        System.out.println("Can't book this seat");
                    }
                    break;
                default:
                    break;






            }


        }


    }

}