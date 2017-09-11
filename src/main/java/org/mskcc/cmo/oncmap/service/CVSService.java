package org.mskcc.cmo.oncmap.service;

import org.mskcc.cmo.oncmap.model.Constants;
import org.mskcc.cmo.oncmap.model.Env;
import org.mskcc.cmo.oncmap.model.Environment;
import org.mskcc.cmo.oncmap.model.MSKConceptMappings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CVSService {
	
	private final RestTemplate restTemplate;
	
	private String endpoint;
	
	private final static Logger LOG = LoggerFactory.getLogger(CVSService.class);
		
	public CVSService(RestTemplateBuilder restTemplateBuilder){
		this.restTemplate = restTemplateBuilder.build();
		configureEndpoint();
	}
	
	public MSKConceptMappings getMappingsFromCVS(String vocabularyId,
												 String conceptId,
												 String histologyCode,
												 String siteCode){
		
		MSKConceptMappings response = new MSKConceptMappings();
		try{
			response = this.restTemplate.getForObject(this.endpoint, MSKConceptMappings.class, vocabularyId, conceptId, histologyCode, siteCode);
		}catch(Exception e){
			LOG.error("Exception while getting data from CVS Service with: \n " +
					  "Endpoint: " + this.endpoint + "\n" +
					  "VocabularyId: " + vocabularyId + "\n" +
					  "conceptId: " + conceptId != null ? conceptId : new String() + "\n" +
					  "histologyCode: " + histologyCode != null ? histologyCode : new String() + "\n" +
					  "siteCode: " + siteCode  != null ? siteCode : new String() + "\n" , e);
			return response;
		}
		return response;
	}
	
	
	private void configureEndpoint(){
		Environment env = new Environment();
		env.initializeEnvironment();
		
		switch( env.getEnvironment() ){
		
		case LOCAL:
			this.endpoint = Constants.LOCAL_ENDPOINT;
			break;
			
		case DEV:
			this.endpoint = Constants.DEV_ENDPOINT;
			break;
			
		case PROD:
			this.endpoint = Constants.PROD_ENDPOINT;
			break;
			
		case EXTERNAL:
			this.endpoint = Constants.PROD_EXTERNAL_ENDPOINT;
			break;
		}
		
		LOG.info("Using mapping endpoint " + this.endpoint);
			
	}

}
