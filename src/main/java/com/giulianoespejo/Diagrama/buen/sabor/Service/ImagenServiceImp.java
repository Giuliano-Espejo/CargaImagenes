package com.giulianoespejo.Diagrama.buen.sabor.Service;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Imagen;
import com.giulianoespejo.Diagrama.buen.sabor.Repository.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServiceImp implements ImagenService{

    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    public void save(String path) {
        imagenRepository.save(Imagen.builder().denominacion(path).build());
    }

    @Override
    public void deleted(Long id) {
        imagenRepository.deleteById(id);
    }

    @Override
    public Imagen getById(Long id) {
        return imagenRepository.findById(id).orElseThrow(()->new NullPointerException("no se encontro la imagen"));
    }
}
