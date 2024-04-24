package com.giulianoespejo.Diagrama.buen.sabor.Entity;

import jakarta.persistence.Entity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Imagen extends Base{
    private String denominacion;
}
