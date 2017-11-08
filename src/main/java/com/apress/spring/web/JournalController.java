package com.apress.spring.web;
import com.apress.spring.domain.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.apress.spring.repository.JournalRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class JournalController  {
    @Autowired
    JournalRepository repo;



    @RequestMapping(value="/journal", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public @ResponseBody
    List<Journal> getJournal(){
        return repo.findAll();
    }


    @RequestMapping(value="/journala" )
    public @ResponseBody
    List<Journal> getJournla(){
        return repo.findAll();
    }

    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("journal", repo.findAll());
        return "index";
    }
}