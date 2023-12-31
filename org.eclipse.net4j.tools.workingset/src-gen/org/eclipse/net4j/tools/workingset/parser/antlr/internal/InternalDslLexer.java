package org.eclipse.net4j.tools.workingset.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslLexer extends Lexer {
    public static final int T14=14;
    public static final int T29=29;
    public static final int T36=36;
    public static final int RULE_STRING=6;
    public static final int T35=35;
    public static final int T45=45;
    public static final int T20=20;
    public static final int T34=34;
    public static final int T25=25;
    public static final int T18=18;
    public static final int T37=37;
    public static final int T26=26;
    public static final int RULE_INT=7;
    public static final int RULE_BOOLEAN=4;
    public static final int T32=32;
    public static final int T17=17;
    public static final int T46=46;
    public static final int T16=16;
    public static final int T38=38;
    public static final int T41=41;
    public static final int T24=24;
    public static final int T19=19;
    public static final int T39=39;
    public static final int T21=21;
    public static final int T44=44;
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int T33=33;
    public static final int T22=22;
    public static final int T50=50;
    public static final int T43=43;
    public static final int T12=12;
    public static final int T23=23;
    public static final int T28=28;
    public static final int T42=42;
    public static final int T40=40;
    public static final int T13=13;
    public static final int RULE_WS=10;
    public static final int T48=48;
    public static final int T15=15;
    public static final int EOF=-1;
    public static final int T47=47;
    public static final int Tokens=51;
    public static final int RULE_ANY_OTHER=11;
    public static final int T31=31;
    public static final int T49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int T27=27;
    public static final int T30=30;
    public InternalDslLexer() {;} 
    public InternalDslLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g"; }

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:10:5: ( '(' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:10:7: '('
            {
            match('('); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:11:5: ( ')' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:11:7: ')'
            {
            match(')'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:12:5: ( 'is' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:12:7: 'is'
            {
            match("is"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:13:5: ( 'has' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:13:7: 'has'
            {
            match("has"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:14:5: ( '.' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:14:7: '.'
            {
            match('.'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:15:5: ( ',' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:15:7: ','
            {
            match(','); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:16:5: ( '+' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:16:7: '+'
            {
            match('+'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:17:5: ( '|' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:17:7: '|'
            {
            match('|'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:18:5: ( '||' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:18:7: '||'
            {
            match("||"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:19:5: ( 'or' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:19:7: 'or'
            {
            match("or"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:20:5: ( '^' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:20:7: '^'
            {
            match('^'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:21:5: ( 'xor' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:21:7: 'xor'
            {
            match("xor"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:22:5: ( '&' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:22:7: '&'
            {
            match('&'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start T25
    public final void mT25() throws RecognitionException {
        try {
            int _type = T25;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:23:5: ( '&&' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:23:7: '&&'
            {
            match("&&"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T25

    // $ANTLR start T26
    public final void mT26() throws RecognitionException {
        try {
            int _type = T26;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:24:5: ( 'and' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:24:7: 'and'
            {
            match("and"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T26

    // $ANTLR start T27
    public final void mT27() throws RecognitionException {
        try {
            int _type = T27;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:25:5: ( '!' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:25:7: '!'
            {
            match('!'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T27

    // $ANTLR start T28
    public final void mT28() throws RecognitionException {
        try {
            int _type = T28;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:26:5: ( 'not' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:26:7: 'not'
            {
            match("not"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T28

    // $ANTLR start T29
    public final void mT29() throws RecognitionException {
        try {
            int _type = T29;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:27:5: ( '=' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:27:7: '='
            {
            match('='); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T29

    // $ANTLR start T30
    public final void mT30() throws RecognitionException {
        try {
            int _type = T30;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:28:5: ( '==' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:28:7: '=='
            {
            match("=="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T30

    // $ANTLR start T31
    public final void mT31() throws RecognitionException {
        try {
            int _type = T31;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:29:5: ( '!=' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:29:7: '!='
            {
            match("!="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T31

    // $ANTLR start T32
    public final void mT32() throws RecognitionException {
        try {
            int _type = T32;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:30:5: ( '<>' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:30:7: '<>'
            {
            match("<>"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T32

    // $ANTLR start T33
    public final void mT33() throws RecognitionException {
        try {
            int _type = T33;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:31:5: ( '>' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:31:7: '>'
            {
            match('>'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T33

    // $ANTLR start T34
    public final void mT34() throws RecognitionException {
        try {
            int _type = T34;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:32:5: ( '>=' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:32:7: '>='
            {
            match(">="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T34

    // $ANTLR start T35
    public final void mT35() throws RecognitionException {
        try {
            int _type = T35;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:33:5: ( '<' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:33:7: '<'
            {
            match('<'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T35

    // $ANTLR start T36
    public final void mT36() throws RecognitionException {
        try {
            int _type = T36;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:34:5: ( '<=' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:34:7: '<='
            {
            match("<="); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T36

    // $ANTLR start T37
    public final void mT37() throws RecognitionException {
        try {
            int _type = T37;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:35:5: ( 'like' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:35:7: 'like'
            {
            match("like"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T37

    // $ANTLR start T38
    public final void mT38() throws RecognitionException {
        try {
            int _type = T38;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:36:5: ( '~' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:36:7: '~'
            {
            match('~'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T38

    // $ANTLR start T39
    public final void mT39() throws RecognitionException {
        try {
            int _type = T39;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:37:5: ( 'unlike' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:37:7: 'unlike'
            {
            match("unlike"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T39

    // $ANTLR start T40
    public final void mT40() throws RecognitionException {
        try {
            int _type = T40;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:38:5: ( '!~' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:38:7: '!~'
            {
            match("!~"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T40

    // $ANTLR start T41
    public final void mT41() throws RecognitionException {
        try {
            int _type = T41;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:39:5: ( 'starts' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:39:7: 'starts'
            {
            match("starts"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T41

    // $ANTLR start T42
    public final void mT42() throws RecognitionException {
        try {
            int _type = T42;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:40:5: ( 'ends' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:40:7: 'ends'
            {
            match("ends"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T42

    // $ANTLR start T43
    public final void mT43() throws RecognitionException {
        try {
            int _type = T43;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:41:5: ( 'contains' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:41:7: 'contains'
            {
            match("contains"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T43

    // $ANTLR start T44
    public final void mT44() throws RecognitionException {
        try {
            int _type = T44;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:42:5: ( 'file' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:42:7: 'file'
            {
            match("file"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T44

    // $ANTLR start T45
    public final void mT45() throws RecognitionException {
        try {
            int _type = T45;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:43:5: ( 'folder' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:43:7: 'folder'
            {
            match("folder"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T45

    // $ANTLR start T46
    public final void mT46() throws RecognitionException {
        try {
            int _type = T46;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:44:5: ( 'container' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:44:7: 'container'
            {
            match("container"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T46

    // $ANTLR start T47
    public final void mT47() throws RecognitionException {
        try {
            int _type = T47;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:45:5: ( 'project' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:45:7: 'project'
            {
            match("project"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T47

    // $ANTLR start T48
    public final void mT48() throws RecognitionException {
        try {
            int _type = T48;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:46:5: ( 'reference' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:46:7: 'reference'
            {
            match("reference"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T48

    // $ANTLR start T49
    public final void mT49() throws RecognitionException {
        try {
            int _type = T49;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:47:5: ( 'nature' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:47:7: 'nature'
            {
            match("nature"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T49

    // $ANTLR start T50
    public final void mT50() throws RecognitionException {
        try {
            int _type = T50;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:48:5: ( 'builder' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:48:7: 'builder'
            {
            match("builder"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T50

    // $ANTLR start RULE_BOOLEAN
    public final void mRULE_BOOLEAN() throws RecognitionException {
        try {
            int _type = RULE_BOOLEAN;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1598:14: ( ( 'false' | 'true' ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1598:16: ( 'false' | 'true' )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1598:16: ( 'false' | 'true' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='f') ) {
                alt1=1;
            }
            else if ( (LA1_0=='t') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1598:16: ( 'false' | 'true' )", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1598:17: 'false'
                    {
                    match("false"); 


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1598:25: 'true'
                    {
                    match("true"); 


                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_BOOLEAN

    // $ANTLR start RULE_ID
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1600:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1600:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1600:11: ( '^' )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='^') ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1600:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1600:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ID

    // $ANTLR start RULE_INT
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1602:10: ( ( '0' .. '9' )+ )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1602:12: ( '0' .. '9' )+
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1602:12: ( '0' .. '9' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1602:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_INT

    // $ANTLR start RULE_STRING
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\"') ) {
                alt7=1;
            }
            else if ( (LA7_0=='\'') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1604:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='!')||(LA5_0>='#' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFE')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:62: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:82: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:87: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='&')||(LA6_0>='(' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFE')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:88: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||input.LA(1)=='t' ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1604:129: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFE') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse =
                    	            new MismatchedSetException(null,input);
                    	        recover(mse);    throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_STRING

    // $ANTLR start RULE_ML_COMMENT
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1606:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1606:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1606:24: ( options {greedy=false; } : . )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='*') ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1=='/') ) {
                        alt8=2;
                    }
                    else if ( ((LA8_1>='\u0000' && LA8_1<='.')||(LA8_1>='0' && LA8_1<='\uFFFE')) ) {
                        alt8=1;
                    }


                }
                else if ( ((LA8_0>='\u0000' && LA8_0<=')')||(LA8_0>='+' && LA8_0<='\uFFFE')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1606:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match("*/"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ML_COMMENT

    // $ANTLR start RULE_SL_COMMENT
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>='\u0000' && LA9_0<='\t')||(LA9_0>='\u000B' && LA9_0<='\f')||(LA9_0>='\u000E' && LA9_0<='\uFFFE')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:40: ( ( '\\r' )? '\\n' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\n'||LA11_0=='\r') ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:41: ( '\\r' )? '\\n'
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:41: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1608:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_SL_COMMENT

    // $ANTLR start RULE_WS
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1610:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1610:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1610:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_WS

    // $ANTLR start RULE_ANY_OTHER
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1612:16: ( . )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1612:18: .
            {
            matchAny(); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end RULE_ANY_OTHER

    public void mTokens() throws RecognitionException {
        // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:8: ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | RULE_BOOLEAN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt13=47;
        int LA13_0 = input.LA(1);

        if ( (LA13_0=='(') ) {
            alt13=1;
        }
        else if ( (LA13_0==')') ) {
            alt13=2;
        }
        else if ( (LA13_0=='i') ) {
            int LA13_3 = input.LA(2);

            if ( (LA13_3=='s') ) {
                int LA13_39 = input.LA(3);

                if ( ((LA13_39>='0' && LA13_39<='9')||(LA13_39>='A' && LA13_39<='Z')||LA13_39=='_'||(LA13_39>='a' && LA13_39<='z')) ) {
                    alt13=41;
                }
                else {
                    alt13=3;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='h') ) {
            int LA13_4 = input.LA(2);

            if ( (LA13_4=='a') ) {
                int LA13_41 = input.LA(3);

                if ( (LA13_41=='s') ) {
                    int LA13_84 = input.LA(4);

                    if ( ((LA13_84>='0' && LA13_84<='9')||(LA13_84>='A' && LA13_84<='Z')||LA13_84=='_'||(LA13_84>='a' && LA13_84<='z')) ) {
                        alt13=41;
                    }
                    else {
                        alt13=4;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='.') ) {
            alt13=5;
        }
        else if ( (LA13_0==',') ) {
            alt13=6;
        }
        else if ( (LA13_0=='+') ) {
            alt13=7;
        }
        else if ( (LA13_0=='|') ) {
            int LA13_8 = input.LA(2);

            if ( (LA13_8=='|') ) {
                alt13=9;
            }
            else {
                alt13=8;}
        }
        else if ( (LA13_0=='o') ) {
            int LA13_9 = input.LA(2);

            if ( (LA13_9=='r') ) {
                int LA13_47 = input.LA(3);

                if ( ((LA13_47>='0' && LA13_47<='9')||(LA13_47>='A' && LA13_47<='Z')||LA13_47=='_'||(LA13_47>='a' && LA13_47<='z')) ) {
                    alt13=41;
                }
                else {
                    alt13=10;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='^') ) {
            int LA13_10 = input.LA(2);

            if ( ((LA13_10>='A' && LA13_10<='Z')||LA13_10=='_'||(LA13_10>='a' && LA13_10<='z')) ) {
                alt13=41;
            }
            else {
                alt13=11;}
        }
        else if ( (LA13_0=='x') ) {
            int LA13_11 = input.LA(2);

            if ( (LA13_11=='o') ) {
                int LA13_49 = input.LA(3);

                if ( (LA13_49=='r') ) {
                    int LA13_86 = input.LA(4);

                    if ( ((LA13_86>='0' && LA13_86<='9')||(LA13_86>='A' && LA13_86<='Z')||LA13_86=='_'||(LA13_86>='a' && LA13_86<='z')) ) {
                        alt13=41;
                    }
                    else {
                        alt13=12;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='&') ) {
            int LA13_12 = input.LA(2);

            if ( (LA13_12=='&') ) {
                alt13=14;
            }
            else {
                alt13=13;}
        }
        else if ( (LA13_0=='a') ) {
            int LA13_13 = input.LA(2);

            if ( (LA13_13=='n') ) {
                int LA13_52 = input.LA(3);

                if ( (LA13_52=='d') ) {
                    int LA13_87 = input.LA(4);

                    if ( ((LA13_87>='0' && LA13_87<='9')||(LA13_87>='A' && LA13_87<='Z')||LA13_87=='_'||(LA13_87>='a' && LA13_87<='z')) ) {
                        alt13=41;
                    }
                    else {
                        alt13=15;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='!') ) {
            switch ( input.LA(2) ) {
            case '=':
                {
                alt13=20;
                }
                break;
            case '~':
                {
                alt13=29;
                }
                break;
            default:
                alt13=16;}

        }
        else if ( (LA13_0=='n') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA13_56 = input.LA(3);

                if ( (LA13_56=='t') ) {
                    int LA13_88 = input.LA(4);

                    if ( (LA13_88=='u') ) {
                        int LA13_105 = input.LA(5);

                        if ( (LA13_105=='r') ) {
                            int LA13_119 = input.LA(6);

                            if ( (LA13_119=='e') ) {
                                int LA13_132 = input.LA(7);

                                if ( ((LA13_132>='0' && LA13_132<='9')||(LA13_132>='A' && LA13_132<='Z')||LA13_132=='_'||(LA13_132>='a' && LA13_132<='z')) ) {
                                    alt13=41;
                                }
                                else {
                                    alt13=38;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
                }
                break;
            case 'o':
                {
                int LA13_57 = input.LA(3);

                if ( (LA13_57=='t') ) {
                    int LA13_89 = input.LA(4);

                    if ( ((LA13_89>='0' && LA13_89<='9')||(LA13_89>='A' && LA13_89<='Z')||LA13_89=='_'||(LA13_89>='a' && LA13_89<='z')) ) {
                        alt13=41;
                    }
                    else {
                        alt13=17;}
                }
                else {
                    alt13=41;}
                }
                break;
            default:
                alt13=41;}

        }
        else if ( (LA13_0=='=') ) {
            int LA13_16 = input.LA(2);

            if ( (LA13_16=='=') ) {
                alt13=19;
            }
            else {
                alt13=18;}
        }
        else if ( (LA13_0=='<') ) {
            switch ( input.LA(2) ) {
            case '>':
                {
                alt13=21;
                }
                break;
            case '=':
                {
                alt13=25;
                }
                break;
            default:
                alt13=24;}

        }
        else if ( (LA13_0=='>') ) {
            int LA13_18 = input.LA(2);

            if ( (LA13_18=='=') ) {
                alt13=23;
            }
            else {
                alt13=22;}
        }
        else if ( (LA13_0=='l') ) {
            int LA13_19 = input.LA(2);

            if ( (LA13_19=='i') ) {
                int LA13_65 = input.LA(3);

                if ( (LA13_65=='k') ) {
                    int LA13_90 = input.LA(4);

                    if ( (LA13_90=='e') ) {
                        int LA13_107 = input.LA(5);

                        if ( ((LA13_107>='0' && LA13_107<='9')||(LA13_107>='A' && LA13_107<='Z')||LA13_107=='_'||(LA13_107>='a' && LA13_107<='z')) ) {
                            alt13=41;
                        }
                        else {
                            alt13=26;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='~') ) {
            alt13=27;
        }
        else if ( (LA13_0=='u') ) {
            int LA13_21 = input.LA(2);

            if ( (LA13_21=='n') ) {
                int LA13_67 = input.LA(3);

                if ( (LA13_67=='l') ) {
                    int LA13_91 = input.LA(4);

                    if ( (LA13_91=='i') ) {
                        int LA13_108 = input.LA(5);

                        if ( (LA13_108=='k') ) {
                            int LA13_121 = input.LA(6);

                            if ( (LA13_121=='e') ) {
                                int LA13_133 = input.LA(7);

                                if ( ((LA13_133>='0' && LA13_133<='9')||(LA13_133>='A' && LA13_133<='Z')||LA13_133=='_'||(LA13_133>='a' && LA13_133<='z')) ) {
                                    alt13=41;
                                }
                                else {
                                    alt13=28;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='s') ) {
            int LA13_22 = input.LA(2);

            if ( (LA13_22=='t') ) {
                int LA13_68 = input.LA(3);

                if ( (LA13_68=='a') ) {
                    int LA13_92 = input.LA(4);

                    if ( (LA13_92=='r') ) {
                        int LA13_109 = input.LA(5);

                        if ( (LA13_109=='t') ) {
                            int LA13_122 = input.LA(6);

                            if ( (LA13_122=='s') ) {
                                int LA13_134 = input.LA(7);

                                if ( ((LA13_134>='0' && LA13_134<='9')||(LA13_134>='A' && LA13_134<='Z')||LA13_134=='_'||(LA13_134>='a' && LA13_134<='z')) ) {
                                    alt13=41;
                                }
                                else {
                                    alt13=30;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='e') ) {
            int LA13_23 = input.LA(2);

            if ( (LA13_23=='n') ) {
                int LA13_69 = input.LA(3);

                if ( (LA13_69=='d') ) {
                    int LA13_93 = input.LA(4);

                    if ( (LA13_93=='s') ) {
                        int LA13_110 = input.LA(5);

                        if ( ((LA13_110>='0' && LA13_110<='9')||(LA13_110>='A' && LA13_110<='Z')||LA13_110=='_'||(LA13_110>='a' && LA13_110<='z')) ) {
                            alt13=41;
                        }
                        else {
                            alt13=31;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='c') ) {
            int LA13_24 = input.LA(2);

            if ( (LA13_24=='o') ) {
                int LA13_70 = input.LA(3);

                if ( (LA13_70=='n') ) {
                    int LA13_94 = input.LA(4);

                    if ( (LA13_94=='t') ) {
                        int LA13_111 = input.LA(5);

                        if ( (LA13_111=='a') ) {
                            int LA13_124 = input.LA(6);

                            if ( (LA13_124=='i') ) {
                                int LA13_135 = input.LA(7);

                                if ( (LA13_135=='n') ) {
                                    switch ( input.LA(8) ) {
                                    case 'e':
                                        {
                                        int LA13_148 = input.LA(9);

                                        if ( (LA13_148=='r') ) {
                                            int LA13_153 = input.LA(10);

                                            if ( ((LA13_153>='0' && LA13_153<='9')||(LA13_153>='A' && LA13_153<='Z')||LA13_153=='_'||(LA13_153>='a' && LA13_153<='z')) ) {
                                                alt13=41;
                                            }
                                            else {
                                                alt13=35;}
                                        }
                                        else {
                                            alt13=41;}
                                        }
                                        break;
                                    case 's':
                                        {
                                        int LA13_149 = input.LA(9);

                                        if ( ((LA13_149>='0' && LA13_149<='9')||(LA13_149>='A' && LA13_149<='Z')||LA13_149=='_'||(LA13_149>='a' && LA13_149<='z')) ) {
                                            alt13=41;
                                        }
                                        else {
                                            alt13=32;}
                                        }
                                        break;
                                    default:
                                        alt13=41;}

                                }
                                else {
                                    alt13=41;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='f') ) {
            switch ( input.LA(2) ) {
            case 'a':
                {
                int LA13_71 = input.LA(3);

                if ( (LA13_71=='l') ) {
                    int LA13_95 = input.LA(4);

                    if ( (LA13_95=='s') ) {
                        int LA13_112 = input.LA(5);

                        if ( (LA13_112=='e') ) {
                            int LA13_125 = input.LA(6);

                            if ( ((LA13_125>='0' && LA13_125<='9')||(LA13_125>='A' && LA13_125<='Z')||LA13_125=='_'||(LA13_125>='a' && LA13_125<='z')) ) {
                                alt13=41;
                            }
                            else {
                                alt13=40;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
                }
                break;
            case 'o':
                {
                int LA13_72 = input.LA(3);

                if ( (LA13_72=='l') ) {
                    int LA13_96 = input.LA(4);

                    if ( (LA13_96=='d') ) {
                        int LA13_113 = input.LA(5);

                        if ( (LA13_113=='e') ) {
                            int LA13_126 = input.LA(6);

                            if ( (LA13_126=='r') ) {
                                int LA13_136 = input.LA(7);

                                if ( ((LA13_136>='0' && LA13_136<='9')||(LA13_136>='A' && LA13_136<='Z')||LA13_136=='_'||(LA13_136>='a' && LA13_136<='z')) ) {
                                    alt13=41;
                                }
                                else {
                                    alt13=34;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
                }
                break;
            case 'i':
                {
                int LA13_73 = input.LA(3);

                if ( (LA13_73=='l') ) {
                    int LA13_97 = input.LA(4);

                    if ( (LA13_97=='e') ) {
                        int LA13_114 = input.LA(5);

                        if ( ((LA13_114>='0' && LA13_114<='9')||(LA13_114>='A' && LA13_114<='Z')||LA13_114=='_'||(LA13_114>='a' && LA13_114<='z')) ) {
                            alt13=41;
                        }
                        else {
                            alt13=33;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
                }
                break;
            default:
                alt13=41;}

        }
        else if ( (LA13_0=='p') ) {
            int LA13_26 = input.LA(2);

            if ( (LA13_26=='r') ) {
                int LA13_74 = input.LA(3);

                if ( (LA13_74=='o') ) {
                    int LA13_98 = input.LA(4);

                    if ( (LA13_98=='j') ) {
                        int LA13_115 = input.LA(5);

                        if ( (LA13_115=='e') ) {
                            int LA13_128 = input.LA(6);

                            if ( (LA13_128=='c') ) {
                                int LA13_137 = input.LA(7);

                                if ( (LA13_137=='t') ) {
                                    int LA13_145 = input.LA(8);

                                    if ( ((LA13_145>='0' && LA13_145<='9')||(LA13_145>='A' && LA13_145<='Z')||LA13_145=='_'||(LA13_145>='a' && LA13_145<='z')) ) {
                                        alt13=41;
                                    }
                                    else {
                                        alt13=36;}
                                }
                                else {
                                    alt13=41;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='r') ) {
            int LA13_27 = input.LA(2);

            if ( (LA13_27=='e') ) {
                int LA13_75 = input.LA(3);

                if ( (LA13_75=='f') ) {
                    int LA13_99 = input.LA(4);

                    if ( (LA13_99=='e') ) {
                        int LA13_116 = input.LA(5);

                        if ( (LA13_116=='r') ) {
                            int LA13_129 = input.LA(6);

                            if ( (LA13_129=='e') ) {
                                int LA13_138 = input.LA(7);

                                if ( (LA13_138=='n') ) {
                                    int LA13_146 = input.LA(8);

                                    if ( (LA13_146=='c') ) {
                                        int LA13_151 = input.LA(9);

                                        if ( (LA13_151=='e') ) {
                                            int LA13_155 = input.LA(10);

                                            if ( ((LA13_155>='0' && LA13_155<='9')||(LA13_155>='A' && LA13_155<='Z')||LA13_155=='_'||(LA13_155>='a' && LA13_155<='z')) ) {
                                                alt13=41;
                                            }
                                            else {
                                                alt13=37;}
                                        }
                                        else {
                                            alt13=41;}
                                    }
                                    else {
                                        alt13=41;}
                                }
                                else {
                                    alt13=41;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='b') ) {
            int LA13_28 = input.LA(2);

            if ( (LA13_28=='u') ) {
                int LA13_76 = input.LA(3);

                if ( (LA13_76=='i') ) {
                    int LA13_100 = input.LA(4);

                    if ( (LA13_100=='l') ) {
                        int LA13_117 = input.LA(5);

                        if ( (LA13_117=='d') ) {
                            int LA13_130 = input.LA(6);

                            if ( (LA13_130=='e') ) {
                                int LA13_139 = input.LA(7);

                                if ( (LA13_139=='r') ) {
                                    int LA13_147 = input.LA(8);

                                    if ( ((LA13_147>='0' && LA13_147<='9')||(LA13_147>='A' && LA13_147<='Z')||LA13_147=='_'||(LA13_147>='a' && LA13_147<='z')) ) {
                                        alt13=41;
                                    }
                                    else {
                                        alt13=39;}
                                }
                                else {
                                    alt13=41;}
                            }
                            else {
                                alt13=41;}
                        }
                        else {
                            alt13=41;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( (LA13_0=='t') ) {
            int LA13_29 = input.LA(2);

            if ( (LA13_29=='r') ) {
                int LA13_77 = input.LA(3);

                if ( (LA13_77=='u') ) {
                    int LA13_101 = input.LA(4);

                    if ( (LA13_101=='e') ) {
                        int LA13_118 = input.LA(5);

                        if ( ((LA13_118>='0' && LA13_118<='9')||(LA13_118>='A' && LA13_118<='Z')||LA13_118=='_'||(LA13_118>='a' && LA13_118<='z')) ) {
                            alt13=41;
                        }
                        else {
                            alt13=40;}
                    }
                    else {
                        alt13=41;}
                }
                else {
                    alt13=41;}
            }
            else {
                alt13=41;}
        }
        else if ( ((LA13_0>='A' && LA13_0<='Z')||LA13_0=='_'||LA13_0=='d'||LA13_0=='g'||(LA13_0>='j' && LA13_0<='k')||LA13_0=='m'||LA13_0=='q'||(LA13_0>='v' && LA13_0<='w')||(LA13_0>='y' && LA13_0<='z')) ) {
            alt13=41;
        }
        else if ( ((LA13_0>='0' && LA13_0<='9')) ) {
            alt13=42;
        }
        else if ( (LA13_0=='\"') ) {
            int LA13_32 = input.LA(2);

            if ( ((LA13_32>='\u0000' && LA13_32<='\uFFFE')) ) {
                alt13=43;
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='\'') ) {
            int LA13_33 = input.LA(2);

            if ( ((LA13_33>='\u0000' && LA13_33<='\uFFFE')) ) {
                alt13=43;
            }
            else {
                alt13=47;}
        }
        else if ( (LA13_0=='/') ) {
            switch ( input.LA(2) ) {
            case '/':
                {
                alt13=45;
                }
                break;
            case '*':
                {
                alt13=44;
                }
                break;
            default:
                alt13=47;}

        }
        else if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
            alt13=46;
        }
        else if ( ((LA13_0>='\u0000' && LA13_0<='\b')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\u001F')||(LA13_0>='#' && LA13_0<='%')||LA13_0=='*'||LA13_0=='-'||(LA13_0>=':' && LA13_0<=';')||(LA13_0>='?' && LA13_0<='@')||(LA13_0>='[' && LA13_0<=']')||LA13_0=='`'||LA13_0=='{'||LA13_0=='}'||(LA13_0>='\u007F' && LA13_0<='\uFFFE')) ) {
            alt13=47;
        }
        else {
            NoViableAltException nvae =
                new NoViableAltException("1:1: Tokens : ( T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | T25 | T26 | T27 | T28 | T29 | T30 | T31 | T32 | T33 | T34 | T35 | T36 | T37 | T38 | T39 | T40 | T41 | T42 | T43 | T44 | T45 | T46 | T47 | T48 | T49 | T50 | RULE_BOOLEAN | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );", 13, 0, input);

            throw nvae;
        }
        switch (alt13) {
            case 1 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:10: T12
                {
                mT12(); 

                }
                break;
            case 2 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:14: T13
                {
                mT13(); 

                }
                break;
            case 3 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:18: T14
                {
                mT14(); 

                }
                break;
            case 4 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:22: T15
                {
                mT15(); 

                }
                break;
            case 5 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:26: T16
                {
                mT16(); 

                }
                break;
            case 6 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:30: T17
                {
                mT17(); 

                }
                break;
            case 7 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:34: T18
                {
                mT18(); 

                }
                break;
            case 8 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:38: T19
                {
                mT19(); 

                }
                break;
            case 9 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:42: T20
                {
                mT20(); 

                }
                break;
            case 10 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:46: T21
                {
                mT21(); 

                }
                break;
            case 11 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:50: T22
                {
                mT22(); 

                }
                break;
            case 12 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:54: T23
                {
                mT23(); 

                }
                break;
            case 13 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:58: T24
                {
                mT24(); 

                }
                break;
            case 14 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:62: T25
                {
                mT25(); 

                }
                break;
            case 15 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:66: T26
                {
                mT26(); 

                }
                break;
            case 16 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:70: T27
                {
                mT27(); 

                }
                break;
            case 17 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:74: T28
                {
                mT28(); 

                }
                break;
            case 18 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:78: T29
                {
                mT29(); 

                }
                break;
            case 19 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:82: T30
                {
                mT30(); 

                }
                break;
            case 20 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:86: T31
                {
                mT31(); 

                }
                break;
            case 21 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:90: T32
                {
                mT32(); 

                }
                break;
            case 22 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:94: T33
                {
                mT33(); 

                }
                break;
            case 23 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:98: T34
                {
                mT34(); 

                }
                break;
            case 24 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:102: T35
                {
                mT35(); 

                }
                break;
            case 25 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:106: T36
                {
                mT36(); 

                }
                break;
            case 26 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:110: T37
                {
                mT37(); 

                }
                break;
            case 27 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:114: T38
                {
                mT38(); 

                }
                break;
            case 28 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:118: T39
                {
                mT39(); 

                }
                break;
            case 29 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:122: T40
                {
                mT40(); 

                }
                break;
            case 30 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:126: T41
                {
                mT41(); 

                }
                break;
            case 31 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:130: T42
                {
                mT42(); 

                }
                break;
            case 32 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:134: T43
                {
                mT43(); 

                }
                break;
            case 33 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:138: T44
                {
                mT44(); 

                }
                break;
            case 34 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:142: T45
                {
                mT45(); 

                }
                break;
            case 35 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:146: T46
                {
                mT46(); 

                }
                break;
            case 36 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:150: T47
                {
                mT47(); 

                }
                break;
            case 37 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:154: T48
                {
                mT48(); 

                }
                break;
            case 38 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:158: T49
                {
                mT49(); 

                }
                break;
            case 39 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:162: T50
                {
                mT50(); 

                }
                break;
            case 40 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:166: RULE_BOOLEAN
                {
                mRULE_BOOLEAN(); 

                }
                break;
            case 41 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:179: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 42 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:187: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 43 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:196: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 44 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:208: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 45 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:224: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 46 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:240: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 47 :
                // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1:248: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


 

}