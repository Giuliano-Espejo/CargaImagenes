package com.giulianoespejo.Diagrama.buen.sabor.Service;

import com.giulianoespejo.Diagrama.buen.sabor.Entity.Imagen;
import org.hibernate.service.spi.ServiceException;
import org.springframework.web.multipart.MultipartFile;

public interface ImagenService {
    public void save(String img) ;
    public void deleted(Long id);
    public Imagen getById(Long id);
}
