package com.giulianoespejo.Diagrama.buen.sabor.Controller;

import com.giulianoespejo.Diagrama.buen.sabor.Service.ImagenService;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.mock.web.MockMultipartFile;

@Controller
public class ImageUploadController {

    @Value("${upload.dir}")
    private String uploadDir;

    @Autowired
    private ImagenService imagenService;

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                // Obtener el nombre original del archivo
                String nombreArchivo = file.getOriginalFilename();
                // Construir la ruta completa de la carpeta de carga dentro del directorio del proyecto
                Path rutaCompleta = Paths.get(uploadDir + File.separator + nombreArchivo);
                // Guardar la imagen en la carpeta especificada
                // Guardar el nombre o ubicación de la imagen en la base de datos
                imagenService.save(rutaCompleta.toString()); // o guarda la ruta completa si lo prefieres
                Files.write(rutaCompleta, file.getBytes());
                // Opcional: responder con la ruta relativa del archivo guardado
                return "Imagen guardada exitosamente en " + rutaCompleta.toString();
            } catch (IOException e) {
                // Manejar cualquier excepción
                e.printStackTrace();
                return "Error al guardar la imagen";
            }
        } else {
            return "Archivo vacío";
        }
    }

    @GetMapping("/imagen/{id}")
    public ResponseEntity<byte[]> verImagen(@PathVariable Long id) {
        // Obtén la ruta del archivo desde la base de datos
        String path = imagenService.getById(id).getDenominacion();

        try {
            // Construye un objeto File a partir de la ruta del archivo
            File file = new File(path);

            // Lee el contenido del archivo como un arreglo de bytes
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] contenido = new byte[(int) file.length()];
            fileInputStream.read(contenido);
            fileInputStream.close();

            // Construye los headers de la respuesta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_JPEG); // Cambia a MediaType.IMAGE_PNG si es PNG
            headers.setContentLength(contenido.length);

            // Devuelve la respuesta con el contenido del archivo
            return new ResponseEntity<>(contenido, headers, HttpStatus.OK);
        } catch (IOException e) {
            // Si ocurre un error al leer el archivo, devuelve una respuesta de error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}