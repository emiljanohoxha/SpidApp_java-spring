package entities.entites;

import service.service.SpidService;
import service.service.UserService;
import utils.StatusEnum;

public class Main {
    public static void main(String[] args){

        SpidService spidService = new SpidService();
        UserService userService = new UserService();

        User newUser = userService.createUser("John","gim","gimii");
        System.out.println("newUser"+ newUser);

        Spid newSpid = spidService.createSpid(newUser  , "not a description");
        System.out.println(newSpid.toString());

        try {
            spidService.approveSpid(0);
            spidService.editSpid(1, StatusEnum.READY_FOR_REVIEW);


        }catch(Exception e)
        {
            System.out.println(e);
        }
         spidService.listOfSpids();
    }

}
