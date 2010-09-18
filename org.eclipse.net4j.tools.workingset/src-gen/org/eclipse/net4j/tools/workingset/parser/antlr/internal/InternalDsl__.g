lexer grammar InternalDsl;
@header {
package org.eclipse.net4j.tools.workingset.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T12 : '(' ;
T13 : ')' ;
T14 : 'is' ;
T15 : 'has' ;
T16 : '.' ;
T17 : ',' ;
T18 : '+' ;
T19 : '|' ;
T20 : '||' ;
T21 : 'or' ;
T22 : '^' ;
T23 : 'xor' ;
T24 : '&' ;
T25 : '&&' ;
T26 : 'and' ;
T27 : '!' ;
T28 : 'not' ;
T29 : '=' ;
T30 : '==' ;
T31 : '!=' ;
T32 : '<>' ;
T33 : '>' ;
T34 : '>=' ;
T35 : '<' ;
T36 : '<=' ;
T37 : 'like' ;
T38 : '~' ;
T39 : 'unlike' ;
T40 : '!~' ;
T41 : 'starts' ;
T42 : 'ends' ;
T43 : 'contains' ;
T44 : 'file' ;
T45 : 'folder' ;
T46 : 'container' ;
T47 : 'project' ;
T48 : 'reference' ;
T49 : 'nature' ;
T50 : 'builder' ;

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1630
RULE_BOOLEAN : ('false'|'true');

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1632
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1634
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1636
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1638
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1640
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1642
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g" 1644
RULE_ANY_OTHER : .;


