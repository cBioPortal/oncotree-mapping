package org.mskcc.cmo.oncmap.resources;

import org.apache.commons.lang3.StringUtils;
import org.mskcc.cmo.oncmap.model.Constants;
import org.mskcc.cmo.oncmap.model.MSKConceptMappings;
import org.mskcc.cmo.oncmap.model.MappingsResponse;
import org.mskcc.cmo.oncmap.service.CVSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OncotreeMappingsResource{
	
	@Autowired
	private CVSService cvsService;
	
	private final static Logger LOG = LoggerFactory.getLogger(OncotreeMappingsResource.class);
	
	@RequestMapping("/crosswalk")
	public MappingsResponse getMappings(
										@RequestParam(value="vocabularyId", required=false) String vocabularyId,
										@RequestParam(value="conceptId", required=false) String conceptId,
										@RequestParam(value="histologyCode", required=false) String histologyCode,
										@RequestParam(value="siteCode", required=false) String siteCode
										) {
		
		if( !validateMappingParameters(vocabularyId,
									   conceptId,
									   histologyCode,
									   siteCode)
									  ){
    		throw new RuntimeException("Your query parameters, vocabularyId: " + vocabularyId +
    				", conceptId: " + conceptId + ", histologyCode: " + histologyCode +
    				", siteCode: " + siteCode + " are not valid. Please refer to the documentation");
		}
		
		MSKConceptMappings mappings = cvsService.getMappingsFromCVS(vocabularyId, conceptId, histologyCode, siteCode);
		
		return extractOncotreeMappings( mappings );
	}

	

	
	private static boolean validateMappingParameters(
													  String vocabularyId,
													  String conceptId,
													  String histologyCode,
													  String siteCode
													 ){
		// vocabularyId can't be null
		if(StringUtils.isEmpty(vocabularyId)){
			return false;
		}

		// if there's a conceptId, both histology and site must be null
		if(!StringUtils.isEmpty(conceptId)){
			if(!StringUtils.isEmpty(histologyCode) || !StringUtils.isEmpty(siteCode)){
				return false;
			}
		}

		// if there's no conceptId, both histology and site need to appear
		if(StringUtils.isEmpty(conceptId)){
			if(StringUtils.isEmpty(histologyCode) || StringUtils.isEmpty(siteCode)){
				return false;
			}
		}

		// otherwise validates
		return true;
	}	
	
	private MappingsResponse extractOncotreeMappings( MSKConceptMappings mappings ){
		MappingsResponse rsp = new MappingsResponse();
		
		if( mappings == null ){
			return rsp;
		}
		
		if( mappings.getCrosswalks() != null && mappings.getCrosswalks().size() > 0 ){
			
			if( mappings.getCrosswalks().containsKey( Constants.ONCOTREE_VOCAB_KEY )){
				LOG.info("Oncotree mappings found for concept id " + mappings.getConceptId().get(0));
				
				rsp.setOncotreeCode( mappings.getCrosswalks().get( Constants.ONCOTREE_VOCAB_KEY ) );
			}
		}
		
		else if(mappings.getOncotreeCode() != null && mappings.getOncotreeCode().size() > 0 ){
			LOG.info("Oncotree mappings found for concept id " + mappings.getOncotreeCode().toString());
			rsp.setOncotreeCode(mappings.getOncotreeCode());
		}
		return rsp;
	}
	
}
