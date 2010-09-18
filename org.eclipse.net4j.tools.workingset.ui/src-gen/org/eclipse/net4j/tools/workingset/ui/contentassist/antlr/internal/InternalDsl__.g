lexer grammar InternalDsl;
@header {
package org.eclipse.net4j.tools.workingset.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;
}

T12 : '|' ;
T13 : '||' ;
T14 : 'or' ;
T15 : '^' ;
T16 : 'xor' ;
T17 : '&' ;
T18 : '&&' ;
T19 : 'and' ;
T20 : '!' ;
T21 : 'not' ;
T22 : '=' ;
T23 : '==' ;
T24 : '!=' ;
T25 : '<>' ;
T26 : '>' ;
T27 : '>=' ;
T28 : '<' ;
T29 : '<=' ;
T30 : 'like' ;
T31 : '~' ;
T32 : 'unlike' ;
T33 : '!~' ;
T34 : 'starts' ;
T35 : 'ends' ;
T36 : 'contains' ;
T37 : 'file' ;
T38 : 'folder' ;
T39 : 'container' ;
T40 : 'project' ;
T41 : 'reference' ;
T42 : 'nature' ;
T43 : 'builder' ;
T44 : '(' ;
T45 : ')' ;
T46 : 'is' ;
T47 : 'has' ;
T48 : '.' ;
T49 : ',' ;
T50 : '+' ;

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3197
RULE_BOOLEAN : ('false'|'true');

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3199
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3201
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3203
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3205
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3207
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3209
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g" 3211
RULE_ANY_OTHER : .;


