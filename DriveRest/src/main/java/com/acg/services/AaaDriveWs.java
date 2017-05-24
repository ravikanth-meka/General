package com.acg.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acg.services.domain.AaaDriveRepository;
import com.acg.services.domain.AaaDriveRequest;
import com.acg.services.domain.AaaDriveResponse;


@RestController
public class AaaDriveWs {
	
	@Autowired
	private AaaDriveRepository aaaDriveRepository;

	/*@RequestMapping(value = "/rest/aaadrive", method = RequestMethod.GET)
    public ResponseEntity<AaaDriveResponse> getJourneysMiles(@RequestBody AaaDriveRequest request) {
		AaaDriveResponse response = new AaaDriveResponse();
		response.setAaaDriveType(aaaDriveRepository.getAaaDriveData(request));
    	return new ResponseEntity<AaaDriveResponse>(response, HttpStatus.OK);    
    }
	*/
	
	@RequestMapping(value = "/rest/aaadrive", method = RequestMethod.POST)
    public @ResponseBody AaaDriveResponse getJourneysMiles(@RequestBody AaaDriveRequest request) {
		AaaDriveResponse response = new AaaDriveResponse();
		response.setAaaDriveType(aaaDriveRepository.getAaaDriveData(request));
    	//return new ResponseEntity<AaaDriveResponse>(response, HttpStatus.OK);
		return response;
    }
}
/*
C - create - PUT 
R - Read - GET
U - Update - POST
D - Delete - DELETE
*/