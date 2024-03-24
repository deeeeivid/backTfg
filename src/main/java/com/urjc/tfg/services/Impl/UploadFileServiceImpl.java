package com.urjc.tfg.services.Impl;

import com.urjc.tfg.services.IUploadFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class UploadFileServiceImpl implements IUploadFileService {

    private final Logger log = LoggerFactory.getLogger(UploadFileServiceImpl.class);
    private final static String PATH_UPLOADS = "C:\\Users\\david\\IdeaProjects\\spring\\backTfg\\src\\main\\resources\\uploads";
    private final static String PATH_IMAGES = "C:\\Users\\david\\IdeaProjects\\spring\\backTfg\\src\\main\\resources\\static\\images";

    @Override
    public Resource cargar(String nombreFoto) throws MalformedURLException {
        Path rutaArchivo = getPath(nombreFoto);
        log.info(rutaArchivo.toString());

        Resource recurso = new UrlResource(rutaArchivo.toUri());

        if (!recurso.exists() && !recurso.isReadable()) {
            rutaArchivo = Paths.get(PATH_IMAGES).resolve("avatar_man_icon.png").toAbsolutePath();
            recurso = new UrlResource(rutaArchivo.toUri());
            log.error("Error no se pudo cargar la imagen " + nombreFoto);
        }
        return recurso;
    }

    @Override
    public String guardar(MultipartFile archivo) throws IOException {
        String nombreArchivo = UUID.randomUUID() + "_" + archivo.getOriginalFilename().replace(" ", "");

        Path rutaArchivo = getPath(nombreArchivo);
        log.info(rutaArchivo.toString());

        Files.copy(archivo.getInputStream(), rutaArchivo);

        return nombreArchivo;
    }

    @Override
    public void eliminar(String nombreFoto) {
        if (nombreFoto != null && !nombreFoto.isEmpty()) {
            Path rutaFotoAnterior = Paths.get(PATH_UPLOADS).resolve(nombreFoto).toAbsolutePath();
            File archivoFotoAnterior = rutaFotoAnterior.toFile();
            if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
                archivoFotoAnterior.delete();
            }
        }
    }

    @Override
    public Path getPath(String nombreFoto) {
        return Paths.get(PATH_UPLOADS).resolve(nombreFoto).toAbsolutePath();
    }
}
