package org.mskcc.cmo.oncmap.model;

import java.util.HashMap;
import java.util.List;

public class MSKConceptMappings {
	
	private List<String> conceptId;
	
	private List<String> oncotreeCode;
	
	private List<String> preferredLabel;
	
	private List<String> alternativeLabel;
	
	private List<String> semanticTypes;
	
	private List<String> parents;
	
	private List<String> children;
	
	private HashMap<String, List<String>> semanticRelations;
	
	private HashMap<String, List<String>> crosswalks;
	
	public MSKConceptMappings(){
		
	}

	public synchronized List<String> getConceptId() {
		return conceptId;
	}
	
	public synchronized List<String> getOncotreeCode() {
		return oncotreeCode;
	}

	public synchronized List<String> getPreferredLabel() {
		return preferredLabel;
	}

	public synchronized List<String> getAlternativeLabel() {
		return alternativeLabel;
	}

	public synchronized List<String> getSemanticTypes() {
		return semanticTypes;
	}

	public synchronized HashMap<String, List<String>> getSemanticRelations() {
		return semanticRelations;
	}

	public synchronized HashMap<String, List<String>> getCrosswalks() {
		return crosswalks;
	}

	public synchronized void setConceptId(List<String> conceptId) {
		this.conceptId = conceptId;
	}
	
	public synchronized void setOncotreeCode(List<String> oncotreeCode) {
		this.oncotreeCode = oncotreeCode;
	}

	public synchronized void setPreferredLabel(List<String> preferredLabel) {
		this.preferredLabel = preferredLabel;
	}

	public synchronized void setAlternativeLabel(List<String> alternativeLabel) {
		this.alternativeLabel = alternativeLabel;
	}

	public synchronized void setSemanticTypes(List<String> semanticTypes) {
		this.semanticTypes = semanticTypes;
	}

	public synchronized void setSemanticRelations(HashMap<String, List<String>> semanticRelations) {
		this.semanticRelations = semanticRelations;
	}

	public synchronized void setCrosswalks(HashMap<String, List<String>> crosswalks) {
		this.crosswalks = crosswalks;
	}

	public synchronized List<String> getParents() {
		return parents;
	}

	public synchronized void setParents(List<String> parents) {
		this.parents = parents;
	}

	public synchronized List<String> getChildren() {
		return children;
	}

	public synchronized void setChildren(List<String> children) {
		this.children = children;
	}
	
	

}
