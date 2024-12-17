package com.tienda.ordersbck.Service;

import com.tienda.ordersbck.Entity.ListofOrder;
import com.tienda.ordersbck.Repository.ListoforderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListofordersService {
    @Autowired
    private ListoforderRepository listoforderRepository;

    public List<ListofOrder> getAllListoforders(){
        return listoforderRepository.findAll();
    }

    public Optional<ListofOrder> getListoforderById(String id){
        return listoforderRepository.findById(id);
    }

    public ListofOrder saveListoforder(ListofOrder listoforder){
        try{
            return listoforderRepository.save(listoforder);
        }catch (Exception e){
            throw  new RuntimeException("ERROR");
        }
    }

    public void deleteListoforder(String id){
        Optional<ListofOrder> listoforder = listoforderRepository.findById(id);
        if(listoforder.isPresent()){
            listoforderRepository.deleteById(id);
        }else{
            throw new RuntimeException("ERROR");
        }
    }

    public ListofOrder updateListoforder(String id ,ListofOrder listoforder){
        Optional<ListofOrder> existing = listoforderRepository.findById(id);
        if(existing.isPresent()){
            ListofOrder updatedListoforder = existing.get();

            updatedListoforder.setState(listoforder.getState());
            updatedListoforder.setCity(listoforder.getCity());
            updatedListoforder.setCustomerName(listoforder.getCustomerName());
            updatedListoforder.setOrderDate(listoforder.getOrderDate());

            return  listoforderRepository.save(updatedListoforder);
        }else{
            throw new RuntimeException("ERROR");
        }
    }
}
