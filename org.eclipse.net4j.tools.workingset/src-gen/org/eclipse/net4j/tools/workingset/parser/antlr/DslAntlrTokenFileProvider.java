/*
* generated by Xtext
*/
package org.eclipse.net4j.tools.workingset.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class DslAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.tokens");
	}
}
