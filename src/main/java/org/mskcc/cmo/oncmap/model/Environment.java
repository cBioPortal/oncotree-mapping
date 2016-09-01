package org.mskcc.cmo.oncmap.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Environment {
	
	private Env _env;
	
	private boolean _isEnvInClassPath;
	
	private String _envFileName;
	
	private final static Logger LOG  = LoggerFactory.getLogger(Environment.class);
	
	public Environment(){
		this._isEnvInClassPath = true;
		this._envFileName = Constants.ENV_FILE;
	}

	public Environment(String env){
		this._isEnvInClassPath = false;
		this._envFileName = env;
	}
	
	public void initializeEnvironment(){
		BufferedReader in = null;
		
		try{
			in = getEnvironmentReader();
			String strLine;
			while((strLine=in.readLine())!=null){
				if( !StringUtils.isEmpty(strLine) ){
					String env = strLine.trim();
					for( Env e : Env.values() ){
						if( e.name().equalsIgnoreCase(env) ){
							LOG.info("Setting up environment to " + e.name() + " from config value " + env);
							this._env = Env.valueOf(env.toUpperCase());
						}
					}
				}
			}
		}catch(IOException e){
			LOG.error("Exception while reading oncotree file " + _envFileName, e);
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){
					LOG.error("Exception while closing reader to environment file " + _envFileName, e);
				}
			}
		}
	}
	
	private BufferedReader getEnvironmentReader(){
		BufferedReader in = null;
		try{
			if(_isEnvInClassPath){
				InputStream is = this.getClass().getClassLoader().getResourceAsStream(_envFileName);
				if(is == null){
					LOG.error("Environment file cannot be loaded from class path resource at " + _envFileName);
					return in;
				}
				in = new BufferedReader(new InputStreamReader(is));
			}
			else{
				File oncotreeFile = new File(_envFileName);
				if(!oncotreeFile.exists()){
					LOG.error("Environment file " + _envFileName + " doesn't exist");
					return in;
				}
				in = new BufferedReader(new FileReader(_envFileName));
			}
		}catch(IOException e){
			LOG.error("Exception while reading environment file from " + _envFileName);
		}
		return in;
	}
	
	public Env getEnvironment(){
		return this._env;
	}
	
	public String getEnvironmentName(){
		return this._env.name();
	}
}
