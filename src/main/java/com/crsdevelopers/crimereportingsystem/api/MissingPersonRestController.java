package com.crsdevelopers.crimereportingsystem.api;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.core.io.Resource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.crsdevelopers.crimereportingsystem.domains.MissingPerson;
import com.crsdevelopers.crimereportingsystem.services.FileStorageService;
import com.crsdevelopers.crimereportingsystem.services.MissingPersonService;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/missingPerson", produces="application/json" )
public class MissingPersonRestController {
	@Autowired
	MissingPersonService missingPersonService;
	@Autowired
	FileStorageService fileStorageService;
	ObjectMapper objectMapper = new ObjectMapper();
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public MissingPerson createMissingPerson(
			@RequestParam(value="missingpersonJson", required = true ) String missingpersonJson,
			@RequestParam(required = true, value="file") MultipartFile file) 
			throws JsonParseException, JsonMappingException, IOException{
		String fileName = fileStorageService.storeFile(file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/missingPerson/downloadFile/").path(fileName).toUriString();
		MissingPerson missingPerson = objectMapper.readValue(missingpersonJson, MissingPerson.class);
		missingPerson.setPicturePath(fileDownloadUri);
		missingPersonService.save(missingPerson);
		
		return missingPerson;
		
	}
	@GetMapping
	public List<MissingPerson> getAllMissingPerson(){
		return missingPersonService.getAll();
	}
	@GetMapping("/{id}")
	public ResponseEntity<MissingPerson> getMissingPersonById(@PathVariable("id") Long id){
		MissingPerson missingPerson = missingPersonService.getById(id);
		if(missingPerson != null) {
			return new ResponseEntity<>(missingPerson,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteMissingPersonById(@PathVariable("id") Long id){
		try {
		missingPersonService.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			
		}
		
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
