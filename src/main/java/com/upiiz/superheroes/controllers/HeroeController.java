package com.upiiz.superheroes.controllers;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.services.HeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/v1/heroes")
public class HeroeController {
    @Autowired
    private HeroeService heroeService;
    //GET DE TODOS LOS HEROES
    @GetMapping
    public ResponseEntity<List<HeroeEntity>> getHeroes(){
        return ResponseEntity.ok(heroeService.getAllHeroes());
    }
    //GET DE SOLO UN HEROE
    @GetMapping("/id")
    public ResponseEntity<HeroeEntity> getHeroeById(@RequestParam Long id){
        return ResponseEntity.ok(heroeService.getHeroeById(id));
    }
    //POST DE UN HEROE
    @PostMapping
    public ResponseEntity<HeroeEntity> createHeroe(@RequestBody HeroeEntity heroe){
        return ResponseEntity.ok(heroeService.createHeroe(heroe));
    }
    //PUT DE UN HEROE
    @PutMapping("/id")
    public ResponseEntity<HeroeEntity> updateHeroe(@RequestBody HeroeEntity heroe, @RequestParam Long id){
        return ResponseEntity.ok(heroeService.updateHeroe(heroe));
    }

    //DELETE DE UN HEROE
    @DeleteMapping("/id")
    public ResponseEntity<HeroeEntity> deleteHeroe(@RequestParam Long id){
        heroeService.deleteHeroe(id);
        return ResponseEntity.noContent().build();
    }
}
