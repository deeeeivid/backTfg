package com.urjc.tfg.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

public interface IUploadFileService {

    Resource cargar(String nombreFoto) throws MalformedURLException;

    String guardar(MultipartFile multipartFile) throws IOException;

    void eliminar(String nombreFoto);

    Path getPath(String nombreFoto);

}
