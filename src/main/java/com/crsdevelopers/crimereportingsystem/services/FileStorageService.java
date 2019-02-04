package com.crsdevelopers.crimereportingsystem.services;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.crsdevelopers.crimereportingsystem.configurations.ApiConstants;
import com.crsdevelopers.crimereportingsystem.configurations.FileStorageConfigProperties;
import com.crsdevelopers.crimereportingsystem.exception.FileStorageException;
import com.crsdevelopers.crimereportingsystem.exception.MyFileNotFoundException;

@Service
public class FileStorageService {
	
	private final Path fileStorageLocation;
	@Autowired
	public FileStorageService(FileStorageConfigProperties fileStorageConfigProperties) {
		this.fileStorageLocation = Paths.get(fileStorageConfigProperties.getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		}
		catch(Exception ex){
			throw new FileStorageException(ApiConstants.FILE_STORAGE_EXCEPTION_PATH_NOT_FOUND,ex);
		}
	}
	
	public String storeFile(MultipartFile file) throws IOException{
		if(!(file.getOriginalFilename().endsWith(ApiConstants.PNG_FILE_FORMAT) || file.getOriginalFilename().endsWith(ApiConstants.JPEG_FILE_FORMAT) || file.getOriginalFilename().endsWith(ApiConstants.JPG_FILE_FORMAT))) {
			throw new FileStorageException(ApiConstants.INVALID_FILE_FORMAT);
		}
		
//		File f = new File(AppConstants.TEMP_DIR + file.getOriginalFilename());
//		
//		f.createNewFile();
//		FileOutputStream fout = new FileOutputStream(f);
//		fout.write(file.getBytes());
//		fout.close();
//		BufferedImage image = ImageIO.read(f);
//		int height = image.getHeight();
//		int width = image.getWidth();
//		// check the dimension of the image
//		if(width >300 || height >300) {
//			if(f.exists())
//				f.delete();
//			throw new FileStorageException(AppConstants.INVALID_FILE_DIMENSION);
//		}
//		if(f.exists())
//			f.delete();
//		
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		//check if the filename is valid
		try {
			if(fileName.contains(ApiConstants.INVALID_FILE_DELIMITER)) {
				throw new FileStorageException(ApiConstants.INVALID_FILE_PATH_NAME + fileName);
			}
			// give the file a new name
			String newFileName = System.currentTimeMillis() + ApiConstants.FILE_SEPARATOR + fileName; 
			Path targetLocation = this.fileStorageLocation.resolve(newFileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			return newFileName;
		}
		catch(IOException ex){
			throw new FileStorageException(String.format(ApiConstants.FILE_STORAGE_EXCEPTION, fileName),ex);
		}
		
	}
	public Resource loadFileAsResource(String fileName) {
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if(resource.exists()) {
				return resource;
			}
			else {
				throw new MyFileNotFoundException(ApiConstants.FILE_NOT_FOUND + fileName);
			
			}
			
		}
		catch(MalformedURLException ex){
			throw new MyFileNotFoundException(ApiConstants.FILE_NOT_FOUND + fileName ,ex);
		}
		
	}
	

}
