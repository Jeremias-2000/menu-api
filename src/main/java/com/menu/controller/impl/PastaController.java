package com.menu.controller.impl;

import com.menu.document.Pasta;
import com.menu.service.impl.PastaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/menu/pastas")
public class PastaController {
    @Autowired
    private PastaServiceImpl pastaService;

    @GetMapping
    public List<Pasta> findAll(){
        return pastaService.findAll();
    }
    @PostMapping
    public Pasta savePasta(@RequestBody Pasta newPasta){
        return pastaService.save(newPasta);
    }
}
