package ru.pflb.controller;

import org.springframework.web.bind.annotation.*;
import ru.pflb.logic.Model;
import ru.pflb.logic.Transaction;

import java.util.Map;

@RestController
public class Controller {
    private static  final Model model = Model.getInstance();

    int count = 1;

    @PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
    public void addtransaction (@RequestBody Transaction transaction){
        model.add(count++, transaction);
    }

    @GetMapping(value = "/transaction", produces = "application/json")
    public Map<Integer, Transaction> getAll(){
        return model.getList();
    }
    @GetMapping(value = "/transaction/{id}", produces = "application/json")
    public Transaction getTransaction(@PathVariable Integer id){
        return model.getFromList(id);
    }
}
