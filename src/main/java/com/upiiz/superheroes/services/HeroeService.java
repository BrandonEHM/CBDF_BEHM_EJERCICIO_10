/*package com.upiiz.superheroes.services;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.repositories.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    //GET DE TODOS LOS HEROES
    public List<HeroeEntity> getAllHeroes(){
        return heroeRepository.findAll();
    }
    //GET DE UN HEROE
    public HeroeEntity getHeroeById(Long id){
        return heroeRepository.findById(id).orElse(null);
    }
    //POST DE UN HEROE
    public HeroeEntity createHeroe(HeroeEntity heroe){
        return heroeRepository.save(heroe);
    }
    //PUT DE UN HEROE
    public HeroeEntity updateHeroe(HeroeEntity heroe){
        return heroeRepository.save(heroe);
    }
    //DELETE DE UN HEROE
    public void deleteHeroe(Long id){
        heroeRepository.deleteById(id);
    }
}
*/
package com.upiiz.superheroes.services;

import com.upiiz.superheroes.entities.HeroeEntity;
import com.upiiz.superheroes.repositories.HeroeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HeroeService {
    @Autowired
    private HeroeRepository heroeRepository;

    // Obtener todos los héroes
    public List<HeroeEntity> getAllHeroes() {
        return heroeRepository.findAll();
    }

    // Obtener un héroe por ID
    public HeroeEntity getHeroeById(Long id) {
        return heroeRepository.findById(id).orElse(null);
    }

    // Crear un nuevo héroe
    public HeroeEntity createHeroe(HeroeEntity heroe) {
        return heroeRepository.save(heroe);
    }

    // Actualizar un héroe existente
    public HeroeEntity updateHeroe(HeroeEntity heroe, Long id) {
        return heroeRepository.findById(id).map(existingHeroe -> {
            existingHeroe.setNombre(heroe.getNombre());
            existingHeroe.setPoder(heroe.getPoder());
            existingHeroe.setUniverso(heroe.getUniverso());
            existingHeroe.setDebilidad(heroe.getDebilidad());
            existingHeroe.setUrlImagen(heroe.getUrlImagen());
            return heroeRepository.save(existingHeroe);
        }).orElse(null);
    }

    // Eliminar un héroe
    public boolean deleteHeroe(Long id) {
        if (heroeRepository.existsById(id)) {
            heroeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
