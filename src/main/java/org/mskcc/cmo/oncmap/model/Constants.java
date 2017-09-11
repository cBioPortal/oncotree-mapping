package org.mskcc.cmo.oncmap.model;

public class Constants {
	
	/** Key for Oncotree Vocabulary Id **/
	public final static String ONCOTREE_VOCAB_KEY = "ONCOTREE";
	
	/** Config file setting up the current environment **/
	public final static String ENV_FILE = "environment";
	
	/** Mappings endpoint for Local Environment **/
	public final static String LOCAL_ENDPOINT = "http://localhost:9999/concept/crosswalk?vocabularyId={vocabularyId}&conceptId={conceptId}&histologyCode={histologyCode}&siteCode={siteCode}";
	
	/** Mappings endpoint for Development Environment **/
	public final static String DEV_ENDPOINT = "http://datatest.mskcc.org/ontologies/api/concept/crosswalk?vocabularyId={vocabularyId}&conceptId={conceptId}&histologyCode={histologyCode}&siteCode={siteCode}";
	
	/** Mappings endpoint for Production INSIDE MSK Environment**/
	public final static String PROD_ENDPOINT = "http://data.mskcc.org/ontologies/api/concept/crosswalk?vocabularyId={vocabularyId}&conceptId={conceptId}&histologyCode={histologyCode}&siteCode={siteCode}";
	
	/** Mappings endpoint for Production Outside MSK **/
	public final static String PROD_EXTERNAL_ENDPOINT = "http://oncotree.mskcc.org/oncotree-mappings/crosswalk?vocabularyId={vocabularyId}&conceptId={conceptId}&histologyCode={histologyCode}&siteCode={siteCode}";

}
