package co.com.bancolombia._microservice.resolveEnigmaApi.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.bancolombia._microservice.resolveEnigmaApi.model.Error;
import co.com.bancolombia._microservice.resolveEnigmaApi.model.GetEnigmaStepRequest;
import co.com.bancolombia._microservice.resolveEnigmaApi.model.GetEnigmaStepResponse;
import co.com.bancolombia._microservice.resolveEnigmaApi.model.JsonApiBodyRequest;
import co.com.bancolombia._microservice.resolveEnigmaApi.model.JsonApiBodyResponseSucess;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-07-17T16:23:36.474-05:00[America/Bogota]")
@Controller
public class GetStepApiController implements GetStepApi {

    private static final Logger log = LoggerFactory.getLogger(GetStepApiController.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private static String ENIGMA_RESPONSE_STEP_ONE = "Open the regrigerator"; 
    private static String ENIGMA_RESPONSE_STEP_TWO = "Put the giraffe in regrigerator"; 
    private static String ENIGMA_RESPONSE_STEP_THREE = "Close the door"; 
    

    @org.springframework.beans.factory.annotation.Autowired
    public GetStepApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> getStep(@ApiParam(value = "Get one enigma step API" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {
        JsonApiBodyResponseSucess jsonResponseSucess = new JsonApiBodyResponseSucess();
        Error errorDetail = new Error();
        ResponseEntity<?> response = null;
        
        for (GetEnigmaStepRequest bodyRequest : body.getData()) {
        	
        	switch (bodyRequest.getStep()) {
			case "1":
				jsonResponseSucess = setDataSuscess(bodyRequest, ENIGMA_RESPONSE_STEP_ONE);
				response = new ResponseEntity<JsonApiBodyResponseSucess>(jsonResponseSucess, HttpStatus.OK);
				break;
				
			case "2":
				jsonResponseSucess = setDataSuscess(bodyRequest, ENIGMA_RESPONSE_STEP_TWO);
				response = new ResponseEntity<JsonApiBodyResponseSucess>(jsonResponseSucess, HttpStatus.OK);
				break;
				
			case "3":
				jsonResponseSucess = setDataSuscess(bodyRequest, ENIGMA_RESPONSE_STEP_THREE);
				response = new ResponseEntity<JsonApiBodyResponseSucess>(jsonResponseSucess, HttpStatus.OK);
				break;

			default:
				errorDetail = setDataError(bodyRequest);
				response = new ResponseEntity<Error>(errorDetail, HttpStatus.FAILED_DEPENDENCY);
				break;
			}
			
		}
    	
    	return response;
        
    }
    
    /*
     * Metodo encargado de setear los valores cuando hay error en el enigma
     */
    private Error setDataError(GetEnigmaStepRequest bodyRequest) {
		Error errorDetail = new Error();
		
		errorDetail.setCode("0001");
    	errorDetail.setDetail("Ivalid Step");
    	errorDetail.setId(bodyRequest.getHeader().getId());
    	errorDetail.setSource("/getStep");
    	errorDetail.setStatus(HttpStatus.FAILED_DEPENDENCY.toString());
    	errorDetail.setTitle("Invalid Step");
    	
    	return errorDetail;
    	
	}

	/*
     * Metodo encargado de setear los valores para resolver el enigma
     */
    private JsonApiBodyResponseSucess setDataSuscess(GetEnigmaStepRequest bodyRequest, String stepDesc) {
    	 JsonApiBodyResponseSucess jsonResponseSucess = new JsonApiBodyResponseSucess();
    	 GetEnigmaStepResponse enigmaStepResponse = new GetEnigmaStepResponse();
    	 
    	 enigmaStepResponse.setHeader(bodyRequest.getHeader());
    	 enigmaStepResponse.setStep(bodyRequest.getStep());
    	 enigmaStepResponse.setStepDescription(stepDesc);
    	 
    	 jsonResponseSucess.addDataItem(enigmaStepResponse);
    	
    	
		return jsonResponseSucess;
	}

	


}
