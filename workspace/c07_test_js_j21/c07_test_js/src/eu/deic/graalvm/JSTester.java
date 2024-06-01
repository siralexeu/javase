package eu.deic.graalvm;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class JSTester {

	public static void main(String[] args) {
		ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
		ScriptEngine engine = scriptEngineManager.getEngineByName("js");
		//ScriptEngine engine = scriptEngineManager.getEngineByName("nashorn");
		
		try {
			CompiledScript script = 
					((Compilable) engine).compile("console.log('hello world');");
			script.eval();
			
			// world.js contents: print('World!\n');
		    Path p1 = Paths.get("./hworld.js");
		    engine.eval(new FileReader(p1.toString()));
		    
		    Path p2 = Paths.get("./pcallback.js");
		    engine.eval(new FileReader(p2.toString()));
		} catch (ScriptException | FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
