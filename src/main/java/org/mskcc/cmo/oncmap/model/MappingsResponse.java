package org.mskcc.cmo.oncmap.model;

import java.util.ArrayList;
import java.util.List;

public class MappingsResponse {
	
	private List<String> oncotreeCode;
	
	public MappingsResponse(){
		oncotreeCode = new ArrayList<String>();
	}

	public List<String> getOncotreeCode() {
		return oncotreeCode;
	}

	public void setOncotreeCode(List<String> oncotreeCode) {
		this.oncotreeCode = oncotreeCode;
	}

	
}
