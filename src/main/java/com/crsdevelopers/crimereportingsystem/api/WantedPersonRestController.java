package com.crsdevelopers.crimereportingsystem.api;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crsdevelopers.crimereportingsystem.domains.ApiResponse;
import com.crsdevelopers.crimereportingsystem.domains.WantedPerson;
import com.crsdevelopers.crimereportingsystem.services.FileStorageService;
import com.crsdevelopers.crimereportingsystem.services.WantedPersonService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@CrossOrigin
@RestController
@RequestMapping(path = "/api/wantedPerson", produces="application/json" )
public class WantedPersonRestController {
	@Autowired
	WantedPersonService wantedPersonService;
	@Autowired
	FileStorageService fileStorageService;
	ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ApiResponse createWantedPerson(
			@RequestParam(value="wantedpersonJson", required = true ) String wantedpersonJson,
			@RequestParam(required = true, value="file") MultipartFile file) 
			throws JsonParseException, JsonMappingException, IOException{
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/wantedPerson/downloadFile/").path(fileName).toUriString();
		WantedPerson wantedPerson = objectMapper.readValue(wantedpersonJson, WantedPerson.class);
		wantedPerson.setPicturePath(fileDownloadUri);
		wantedPersonService.save(wantedPerson);
		
		return new ApiResponse("EMP-200","wanted person created sucessfully");
		
	}
	@GetMapping
	public List<WantedPerson> getAllWantedPerson(){
		return wantedPersonService.getAll();
	}
	
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request){
		Resource resource  = fileStorageService.loadFileAsResource(fileName);
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		if(contentType == null) {
			contentType = "application/octet-stream";
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, String.format("attachment;filename=\"%s\"", resource.getFilename()))
				.body(resource);
		
	}

}
