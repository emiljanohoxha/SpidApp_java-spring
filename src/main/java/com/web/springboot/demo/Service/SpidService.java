package com.web.springboot.demo.Service;

import com.web.springboot.demo.Entities.Spid;
import com.web.springboot.demo.Entities.StatusEnum;
import com.web.springboot.demo.Entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class SpidService {
    private List<Spid> str_list = new ArrayList<Spid>();


    public Spid createSpid(User user , String description) {

        Spid spid = new Spid(user.getId(), new Date(),user,description);
        str_list.add(spid);
        System.out.println(String.format("Spid is created succesfully!", user.getId()));
        return spid;
    }

    public void listOfSpids(){
        System.out.println("List of all Spids:");
        str_list.stream().forEach(S ->System.out.print(S + " "));
    }

    public Spid getSpid(long id) throws Exception{
        for(int i=0; i <str_list.size();i++)
        {
            if(str_list.get(i).getId() == id){
                return str_list.get(i);
            }
        }
        throw  new Exception(String.format("Spid with id: '%id' does not exists ", id ));

    }

    public void approveSpid(long id) throws Exception {
        getSpid(id).setStatus(StatusEnum.APPROVED);
    }
    public void editSpid(long id, StatusEnum statusEnum) throws Exception {
        getSpid(id).setStatus(statusEnum);
    }
}
