package com.tienda.ordersbck.Controller;

import com.tienda.ordersbck.Entity.ListofOrder;
import com.tienda.ordersbck.Service.ListofordersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/listoforder")
public class ListoforderController {
    @Autowired
    private ListofordersService listofordersService;

    @GetMapping("get/all")
    public ResponseEntity<List<ListofOrder>> getAllListoforder() {
        List<ListofOrder> listoforders = listofordersService.getAllListoforders();
        return new ResponseEntity<>(listoforders, HttpStatus.OK);
    }

    @GetMapping("/getList/{id}")
    public ResponseEntity<ListofOrder> getListoforderById(@PathVariable String id) {
        Optional<ListofOrder> listoforder = listofordersService.getListoforderById(id);
        return listoforder.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/createList")
    public ResponseEntity<ListofOrder> createListoforder(@RequestBody ListofOrder listoforder) {
        ListofOrder newList = listofordersService.saveListoforder(listoforder);
        return new ResponseEntity<>(newList, HttpStatus.CREATED);
    }

    @DeleteMapping("deleteList/{id}")
    public ResponseEntity<ListofOrder> deleteListoforder(@PathVariable String id) {
        try{
            listofordersService.deleteListoforder(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/editList/{id}")
    public ResponseEntity<ListofOrder> editListoforder(@RequestBody ListofOrder listoforder, @PathVariable String id) {
        try{
            ListofOrder editListoforder = listofordersService.updateListoforder(id, listoforder);
            return new ResponseEntity<>(editListoforder, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}