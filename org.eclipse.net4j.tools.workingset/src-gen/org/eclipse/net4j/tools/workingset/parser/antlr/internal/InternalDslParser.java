package org.eclipse.net4j.tools.workingset.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.net4j.tools.workingset.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_BOOLEAN", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'('", "')'", "'is'", "'has'", "'.'", "','", "'+'", "'|'", "'||'", "'or'", "'^'", "'xor'", "'&'", "'&&'", "'and'", "'!'", "'not'", "'='", "'=='", "'!='", "'<>'", "'>'", "'>='", "'<'", "'<='", "'like'", "'~'", "'unlike'", "'!~'", "'starts'", "'ends'", "'contains'", "'file'", "'folder'", "'container'", "'project'", "'reference'", "'nature'", "'builder'"
    };
    public static final int RULE_ML_COMMENT=8;
    public static final int RULE_ID=5;
    public static final int RULE_WS=10;
    public static final int EOF=-1;
    public static final int RULE_INT=7;
    public static final int RULE_BOOLEAN=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=11;
    public static final int RULE_SL_COMMENT=9;

        public InternalDslParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g"; }



     	private DslGrammarAccess grammarAccess;
     	
        public InternalDslParser(TokenStream input, IAstFactory factory, DslGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "BooleanExpression";	
       	}
       	
       	@Override
       	protected DslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start entryRuleBooleanExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:78:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:79:2: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:80:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression75);
            iv_ruleBooleanExpression=ruleBooleanExpression();
            _fsp--;

             current =iv_ruleBooleanExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanExpression


    // $ANTLR start ruleBooleanExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:87:1: ruleBooleanExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:92:6: (this_OrExpression_0= ruleOrExpression )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:94:5: this_OrExpression_0= ruleOrExpression
            {
             
                    currentNode=createCompositeNode(grammarAccess.getBooleanExpressionAccess().getOrExpressionParserRuleCall(), currentNode); 
                
            pushFollow(FOLLOW_ruleOrExpression_in_ruleBooleanExpression131);
            this_OrExpression_0=ruleOrExpression();
            _fsp--;

             
                    current = this_OrExpression_0; 
                    currentNode = currentNode.getParent();
                

            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanExpression


    // $ANTLR start entryRuleOrExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:110:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:111:2: (iv_ruleOrExpression= ruleOrExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:112:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOrExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression165);
            iv_ruleOrExpression=ruleOrExpression();
            _fsp--;

             current =iv_ruleOrExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression175); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOrExpression


    // $ANTLR start ruleOrExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:119:1: ruleOrExpression returns [EObject current=null] : (this_XorExpression_0= ruleXorExpression ( () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_XorExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:124:6: ( (this_XorExpression_0= ruleXorExpression ( () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) ) )* ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:125:1: (this_XorExpression_0= ruleXorExpression ( () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) ) )* )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:125:1: (this_XorExpression_0= ruleXorExpression ( () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) ) )* )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:126:5: this_XorExpression_0= ruleXorExpression ( () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getXorExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleXorExpression_in_ruleOrExpression222);
            this_XorExpression_0=ruleXorExpression();
            _fsp--;

             
                    current = this_XorExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:134:1: ( () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=19 && LA1_0<=21)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:134:2: () ruleOrOperator ( (lv_right_3_0= ruleXorExpression ) )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:134:2: ()
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:135:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    pushFollow(FOLLOW_ruleOrOperator_in_ruleOrExpression240);
            	    ruleOrOperator();
            	    _fsp--;

            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:150:16: ( (lv_right_3_0= ruleXorExpression ) )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:151:1: (lv_right_3_0= ruleXorExpression )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:151:1: (lv_right_3_0= ruleXorExpression )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:152:3: lv_right_3_0= ruleXorExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getOrExpressionAccess().getRightXorExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleXorExpression_in_ruleOrExpression253);
            	    lv_right_3_0=ruleXorExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getOrExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"XorExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOrExpression


    // $ANTLR start entryRuleXorExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:182:1: entryRuleXorExpression returns [EObject current=null] : iv_ruleXorExpression= ruleXorExpression EOF ;
    public final EObject entryRuleXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXorExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:183:2: (iv_ruleXorExpression= ruleXorExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:184:2: iv_ruleXorExpression= ruleXorExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getXorExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleXorExpression_in_entryRuleXorExpression291);
            iv_ruleXorExpression=ruleXorExpression();
            _fsp--;

             current =iv_ruleXorExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXorExpression301); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleXorExpression


    // $ANTLR start ruleXorExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:191:1: ruleXorExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleXorExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:196:6: ( (this_AndExpression_0= ruleAndExpression ( () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:197:1: (this_AndExpression_0= ruleAndExpression ( () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:197:1: (this_AndExpression_0= ruleAndExpression ( () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:198:5: this_AndExpression_0= ruleAndExpression ( () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleAndExpression_in_ruleXorExpression348);
            this_AndExpression_0=ruleAndExpression();
            _fsp--;

             
                    current = this_AndExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:206:1: ( () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=22 && LA2_0<=23)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:206:2: () ruleXorOperator ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:206:2: ()
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:207:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    pushFollow(FOLLOW_ruleXorOperator_in_ruleXorExpression366);
            	    ruleXorOperator();
            	    _fsp--;

            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:222:17: ( (lv_right_3_0= ruleAndExpression ) )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:223:1: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:223:1: (lv_right_3_0= ruleAndExpression )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:224:3: lv_right_3_0= ruleAndExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getXorExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleAndExpression_in_ruleXorExpression379);
            	    lv_right_3_0=ruleAndExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getXorExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"AndExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleXorExpression


    // $ANTLR start entryRuleAndExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:254:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:255:2: (iv_ruleAndExpression= ruleAndExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:256:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression417);
            iv_ruleAndExpression=ruleAndExpression();
            _fsp--;

             current =iv_ruleAndExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression427); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAndExpression


    // $ANTLR start ruleAndExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:263:1: ruleAndExpression returns [EObject current=null] : (this_ComparisonExpression_0= ruleComparisonExpression ( () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ComparisonExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:268:6: ( (this_ComparisonExpression_0= ruleComparisonExpression ( () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) ) )* ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:269:1: (this_ComparisonExpression_0= ruleComparisonExpression ( () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) ) )* )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:269:1: (this_ComparisonExpression_0= ruleComparisonExpression ( () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) ) )* )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:270:5: this_ComparisonExpression_0= ruleComparisonExpression ( () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getComparisonExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleComparisonExpression_in_ruleAndExpression474);
            this_ComparisonExpression_0=ruleComparisonExpression();
            _fsp--;

             
                    current = this_ComparisonExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:278:1: ( () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=24 && LA3_0<=26)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:278:2: () ruleAndOperator ( (lv_right_3_0= ruleComparisonExpression ) )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:278:2: ()
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:279:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    pushFollow(FOLLOW_ruleAndOperator_in_ruleAndExpression492);
            	    ruleAndOperator();
            	    _fsp--;

            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:294:17: ( (lv_right_3_0= ruleComparisonExpression ) )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:295:1: (lv_right_3_0= ruleComparisonExpression )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:295:1: (lv_right_3_0= ruleComparisonExpression )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:296:3: lv_right_3_0= ruleComparisonExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getAndExpressionAccess().getRightComparisonExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleComparisonExpression_in_ruleAndExpression505);
            	    lv_right_3_0=ruleComparisonExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getAndExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"ComparisonExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAndExpression


    // $ANTLR start entryRuleComparisonExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:326:1: entryRuleComparisonExpression returns [EObject current=null] : iv_ruleComparisonExpression= ruleComparisonExpression EOF ;
    public final EObject entryRuleComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:327:2: (iv_ruleComparisonExpression= ruleComparisonExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:328:2: iv_ruleComparisonExpression= ruleComparisonExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getComparisonExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleComparisonExpression_in_entryRuleComparisonExpression543);
            iv_ruleComparisonExpression=ruleComparisonExpression();
            _fsp--;

             current =iv_ruleComparisonExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparisonExpression553); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleComparisonExpression


    // $ANTLR start ruleComparisonExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:335:1: ruleComparisonExpression returns [EObject current=null] : ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* ) | (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ ) ) ;
    public final EObject ruleComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_right_3_0 = null;

        EObject this_ConcatExpression_4 = null;

        Enumerator lv_operator_6_0 = null;

        EObject lv_right_7_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:340:6: ( ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* ) | (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:341:1: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* ) | (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:341:1: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* ) | (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ ) )
            int alt6=2;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
            case 12:
            case 14:
            case 15:
            case 27:
            case 28:
                {
                alt6=1;
                }
                break;
            case RULE_ID:
                {
                int LA6_2 = input.LA(2);

                if ( (LA6_2==12||LA6_2==16) ) {
                    alt6=1;
                }
                else if ( (LA6_2==18||(LA6_2>=29 && LA6_2<=43)) ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("341:1: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* ) | (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ ) )", 6, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt6=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("341:1: ( (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* ) | (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ ) )", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:341:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:341:2: (this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )* )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:342:5: this_PrimaryExpression_0= rulePrimaryExpression ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )*
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getComparisonExpressionAccess().getPrimaryExpressionParserRuleCall_0_0(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleComparisonExpression601);
                    this_PrimaryExpression_0=rulePrimaryExpression();
                    _fsp--;

                     
                            current = this_PrimaryExpression_0; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:350:1: ( () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( ((LA4_0>=29 && LA4_0<=36)) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:350:2: () ( (lv_operator_2_0= ruleComparisonOperator ) ) ( (lv_right_3_0= rulePrimaryExpression ) )
                    	    {
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:350:2: ()
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:351:5: 
                    	    {
                    	     
                    	            temp=factory.create(grammarAccess.getComparisonExpressionAccess().getBooleanComparisonLeftAction_0_1_0().getType().getClassifier());
                    	            try {
                    	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                    	            } catch(ValueConverterException vce) {
                    	            	handleValueConverterException(vce);
                    	            }
                    	            current = temp; 
                    	            temp = null;
                    	            CompositeNode newNode = createCompositeNode(grammarAccess.getComparisonExpressionAccess().getBooleanComparisonLeftAction_0_1_0(), currentNode.getParent());
                    	        newNode.getChildren().add(currentNode);
                    	        moveLookaheadInfo(currentNode, newNode);
                    	        currentNode = newNode; 
                    	            associateNodeWithAstElement(currentNode, current); 
                    	        

                    	    }

                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:366:2: ( (lv_operator_2_0= ruleComparisonOperator ) )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:367:1: (lv_operator_2_0= ruleComparisonOperator )
                    	    {
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:367:1: (lv_operator_2_0= ruleComparisonOperator )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:368:3: lv_operator_2_0= ruleComparisonOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComparisonExpressionAccess().getOperatorComparisonOperatorEnumRuleCall_0_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleComparisonOperator_in_ruleComparisonExpression631);
                    	    lv_operator_2_0=ruleComparisonOperator();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getComparisonExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"operator",
                    	    	        		lv_operator_2_0, 
                    	    	        		"ComparisonOperator", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }

                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:390:2: ( (lv_right_3_0= rulePrimaryExpression ) )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:391:1: (lv_right_3_0= rulePrimaryExpression )
                    	    {
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:391:1: (lv_right_3_0= rulePrimaryExpression )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:392:3: lv_right_3_0= rulePrimaryExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComparisonExpressionAccess().getRightPrimaryExpressionParserRuleCall_0_1_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePrimaryExpression_in_ruleComparisonExpression652);
                    	    lv_right_3_0=rulePrimaryExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getComparisonExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"right",
                    	    	        		lv_right_3_0, 
                    	    	        		"PrimaryExpression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:415:6: (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:415:6: (this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+ )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:416:5: this_ConcatExpression_4= ruleConcatExpression ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getComparisonExpressionAccess().getConcatExpressionParserRuleCall_1_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleConcatExpression_in_ruleComparisonExpression684);
                    this_ConcatExpression_4=ruleConcatExpression();
                    _fsp--;

                     
                            current = this_ConcatExpression_4; 
                            currentNode = currentNode.getParent();
                        
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:424:1: ( () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) ) )+
                    int cnt5=0;
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( ((LA5_0>=29 && LA5_0<=43)) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:424:2: () ( (lv_operator_6_0= ruleStringOperator ) ) ( (lv_right_7_0= ruleConcatExpression ) )
                    	    {
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:424:2: ()
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:425:5: 
                    	    {
                    	     
                    	            temp=factory.create(grammarAccess.getComparisonExpressionAccess().getStringComparisonLeftAction_1_1_0().getType().getClassifier());
                    	            try {
                    	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
                    	            } catch(ValueConverterException vce) {
                    	            	handleValueConverterException(vce);
                    	            }
                    	            current = temp; 
                    	            temp = null;
                    	            CompositeNode newNode = createCompositeNode(grammarAccess.getComparisonExpressionAccess().getStringComparisonLeftAction_1_1_0(), currentNode.getParent());
                    	        newNode.getChildren().add(currentNode);
                    	        moveLookaheadInfo(currentNode, newNode);
                    	        currentNode = newNode; 
                    	            associateNodeWithAstElement(currentNode, current); 
                    	        

                    	    }

                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:440:2: ( (lv_operator_6_0= ruleStringOperator ) )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:441:1: (lv_operator_6_0= ruleStringOperator )
                    	    {
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:441:1: (lv_operator_6_0= ruleStringOperator )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:442:3: lv_operator_6_0= ruleStringOperator
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComparisonExpressionAccess().getOperatorStringOperatorEnumRuleCall_1_1_1_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleStringOperator_in_ruleComparisonExpression714);
                    	    lv_operator_6_0=ruleStringOperator();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getComparisonExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"operator",
                    	    	        		lv_operator_6_0, 
                    	    	        		"StringOperator", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }

                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:464:2: ( (lv_right_7_0= ruleConcatExpression ) )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:465:1: (lv_right_7_0= ruleConcatExpression )
                    	    {
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:465:1: (lv_right_7_0= ruleConcatExpression )
                    	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:466:3: lv_right_7_0= ruleConcatExpression
                    	    {
                    	     
                    	    	        currentNode=createCompositeNode(grammarAccess.getComparisonExpressionAccess().getRightConcatExpressionParserRuleCall_1_1_2_0(), currentNode); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleConcatExpression_in_ruleComparisonExpression735);
                    	    lv_right_7_0=ruleConcatExpression();
                    	    _fsp--;


                    	    	        if (current==null) {
                    	    	            current = factory.create(grammarAccess.getComparisonExpressionRule().getType().getClassifier());
                    	    	            associateNodeWithAstElement(currentNode.getParent(), current);
                    	    	        }
                    	    	        try {
                    	    	       		set(
                    	    	       			current, 
                    	    	       			"right",
                    	    	        		lv_right_7_0, 
                    	    	        		"ConcatExpression", 
                    	    	        		currentNode);
                    	    	        } catch (ValueConverterException vce) {
                    	    				handleValueConverterException(vce);
                    	    	        }
                    	    	        currentNode = currentNode.getParent();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt5 >= 1 ) break loop5;
                                EarlyExitException eee =
                                    new EarlyExitException(5, input);
                                throw eee;
                        }
                        cnt5++;
                    } while (true);


                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComparisonExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:496:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:497:2: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:498:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPrimaryExpressionRule(), currentNode); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression774);
            iv_rulePrimaryExpression=rulePrimaryExpression();
            _fsp--;

             current =iv_rulePrimaryExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression784); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:505:1: rulePrimaryExpression returns [EObject current=null] : (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotExpression_1= ruleNotExpression | this_IsExpression_2= ruleIsExpression | this_HasExpression_3= ruleHasExpression | this_TestExpression_4= ruleTestExpression | ( '(' this_OrExpression_6= ruleOrExpression ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_BooleanLiteral_0 = null;

        EObject this_NotExpression_1 = null;

        EObject this_IsExpression_2 = null;

        EObject this_HasExpression_3 = null;

        EObject this_TestExpression_4 = null;

        EObject this_OrExpression_6 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:510:6: ( (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotExpression_1= ruleNotExpression | this_IsExpression_2= ruleIsExpression | this_HasExpression_3= ruleHasExpression | this_TestExpression_4= ruleTestExpression | ( '(' this_OrExpression_6= ruleOrExpression ')' ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:511:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotExpression_1= ruleNotExpression | this_IsExpression_2= ruleIsExpression | this_HasExpression_3= ruleHasExpression | this_TestExpression_4= ruleTestExpression | ( '(' this_OrExpression_6= ruleOrExpression ')' ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:511:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotExpression_1= ruleNotExpression | this_IsExpression_2= ruleIsExpression | this_HasExpression_3= ruleHasExpression | this_TestExpression_4= ruleTestExpression | ( '(' this_OrExpression_6= ruleOrExpression ')' ) )
            int alt7=6;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt7=1;
                }
                break;
            case 27:
            case 28:
                {
                alt7=2;
                }
                break;
            case 14:
                {
                alt7=3;
                }
                break;
            case 15:
                {
                alt7=4;
                }
                break;
            case RULE_ID:
                {
                alt7=5;
                }
                break;
            case 12:
                {
                alt7=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("511:1: (this_BooleanLiteral_0= ruleBooleanLiteral | this_NotExpression_1= ruleNotExpression | this_IsExpression_2= ruleIsExpression | this_HasExpression_3= ruleHasExpression | this_TestExpression_4= ruleTestExpression | ( '(' this_OrExpression_6= ruleOrExpression ')' ) )", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:512:5: this_BooleanLiteral_0= ruleBooleanLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression831);
                    this_BooleanLiteral_0=ruleBooleanLiteral();
                    _fsp--;

                     
                            current = this_BooleanLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:522:5: this_NotExpression_1= ruleNotExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNotExpressionParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleNotExpression_in_rulePrimaryExpression858);
                    this_NotExpression_1=ruleNotExpression();
                    _fsp--;

                     
                            current = this_NotExpression_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:532:5: this_IsExpression_2= ruleIsExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getIsExpressionParserRuleCall_2(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleIsExpression_in_rulePrimaryExpression885);
                    this_IsExpression_2=ruleIsExpression();
                    _fsp--;

                     
                            current = this_IsExpression_2; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:542:5: this_HasExpression_3= ruleHasExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getHasExpressionParserRuleCall_3(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleHasExpression_in_rulePrimaryExpression912);
                    this_HasExpression_3=ruleHasExpression();
                    _fsp--;

                     
                            current = this_HasExpression_3; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 5 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:552:5: this_TestExpression_4= ruleTestExpression
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getTestExpressionParserRuleCall_4(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleTestExpression_in_rulePrimaryExpression939);
                    this_TestExpression_4=ruleTestExpression();
                    _fsp--;

                     
                            current = this_TestExpression_4; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 6 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:561:6: ( '(' this_OrExpression_6= ruleOrExpression ')' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:561:6: ( '(' this_OrExpression_6= ruleOrExpression ')' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:561:8: '(' this_OrExpression_6= ruleOrExpression ')'
                    {
                    match(input,12,FOLLOW_12_in_rulePrimaryExpression955); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_5_0(), null); 
                        
                     
                            currentNode=createCompositeNode(grammarAccess.getPrimaryExpressionAccess().getOrExpressionParserRuleCall_5_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleOrExpression_in_rulePrimaryExpression977);
                    this_OrExpression_6=ruleOrExpression();
                    _fsp--;

                     
                            current = this_OrExpression_6; 
                            currentNode = currentNode.getParent();
                        
                    match(input,13,FOLLOW_13_in_rulePrimaryExpression986); 

                            createLeafNode(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_5_2(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleBooleanLiteral
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:586:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:587:2: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:588:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getBooleanLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1023);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();
            _fsp--;

             current =iv_ruleBooleanLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral1033); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleBooleanLiteral


    // $ANTLR start ruleBooleanLiteral
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:595:1: ruleBooleanLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_BOOLEAN ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:600:6: ( ( (lv_value_0_0= RULE_BOOLEAN ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:601:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:601:1: ( (lv_value_0_0= RULE_BOOLEAN ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:602:1: (lv_value_0_0= RULE_BOOLEAN )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:602:1: (lv_value_0_0= RULE_BOOLEAN )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:603:3: lv_value_0_0= RULE_BOOLEAN
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_ruleBooleanLiteral1074); 

            			createLeafNode(grammarAccess.getBooleanLiteralAccess().getValueBOOLEANTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getBooleanLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"BOOLEAN", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleBooleanLiteral


    // $ANTLR start entryRuleNotExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:633:1: entryRuleNotExpression returns [EObject current=null] : iv_ruleNotExpression= ruleNotExpression EOF ;
    public final EObject entryRuleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNotExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:634:2: (iv_ruleNotExpression= ruleNotExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:635:2: iv_ruleNotExpression= ruleNotExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNotExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleNotExpression_in_entryRuleNotExpression1114);
            iv_ruleNotExpression=ruleNotExpression();
            _fsp--;

             current =iv_ruleNotExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotExpression1124); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNotExpression


    // $ANTLR start ruleNotExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:642:1: ruleNotExpression returns [EObject current=null] : ( () ruleNotOperator ( (lv_right_2_0= rulePrimaryExpression ) ) ) ;
    public final EObject ruleNotExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_right_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:647:6: ( ( () ruleNotOperator ( (lv_right_2_0= rulePrimaryExpression ) ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:648:1: ( () ruleNotOperator ( (lv_right_2_0= rulePrimaryExpression ) ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:648:1: ( () ruleNotOperator ( (lv_right_2_0= rulePrimaryExpression ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:648:2: () ruleNotOperator ( (lv_right_2_0= rulePrimaryExpression ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:648:2: ()
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:649:5: 
            {
             
                    temp=factory.create(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            pushFollow(FOLLOW_ruleNotOperator_in_ruleNotExpression1167);
            ruleNotOperator();
            _fsp--;

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:659:17: ( (lv_right_2_0= rulePrimaryExpression ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:660:1: (lv_right_2_0= rulePrimaryExpression )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:660:1: (lv_right_2_0= rulePrimaryExpression )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:661:3: lv_right_2_0= rulePrimaryExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getNotExpressionAccess().getRightPrimaryExpressionParserRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_rulePrimaryExpression_in_ruleNotExpression1180);
            lv_right_2_0=rulePrimaryExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getNotExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"right",
            	        		lv_right_2_0, 
            	        		"PrimaryExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNotExpression


    // $ANTLR start entryRuleIsExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:691:1: entryRuleIsExpression returns [EObject current=null] : iv_ruleIsExpression= ruleIsExpression EOF ;
    public final EObject entryRuleIsExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:692:2: (iv_ruleIsExpression= ruleIsExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:693:2: iv_ruleIsExpression= ruleIsExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getIsExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleIsExpression_in_entryRuleIsExpression1216);
            iv_ruleIsExpression=ruleIsExpression();
            _fsp--;

             current =iv_ruleIsExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsExpression1226); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleIsExpression


    // $ANTLR start ruleIsExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:700:1: ruleIsExpression returns [EObject current=null] : ( () 'is' ( (lv_type_2_0= ruleType ) ) ) ;
    public final EObject ruleIsExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_2_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:705:6: ( ( () 'is' ( (lv_type_2_0= ruleType ) ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:706:1: ( () 'is' ( (lv_type_2_0= ruleType ) ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:706:1: ( () 'is' ( (lv_type_2_0= ruleType ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:706:2: () 'is' ( (lv_type_2_0= ruleType ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:706:2: ()
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:707:5: 
            {
             
                    temp=factory.create(grammarAccess.getIsExpressionAccess().getIsExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getIsExpressionAccess().getIsExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,14,FOLLOW_14_in_ruleIsExpression1270); 

                    createLeafNode(grammarAccess.getIsExpressionAccess().getIsKeyword_1(), null); 
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:721:1: ( (lv_type_2_0= ruleType ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:722:1: (lv_type_2_0= ruleType )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:722:1: (lv_type_2_0= ruleType )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:723:3: lv_type_2_0= ruleType
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getIsExpressionAccess().getTypeTypeEnumRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleType_in_ruleIsExpression1291);
            lv_type_2_0=ruleType();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getIsExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"type",
            	        		lv_type_2_0, 
            	        		"Type", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleIsExpression


    // $ANTLR start entryRuleHasExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:753:1: entryRuleHasExpression returns [EObject current=null] : iv_ruleHasExpression= ruleHasExpression EOF ;
    public final EObject entryRuleHasExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleHasExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:754:2: (iv_ruleHasExpression= ruleHasExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:755:2: iv_ruleHasExpression= ruleHasExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getHasExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleHasExpression_in_entryRuleHasExpression1327);
            iv_ruleHasExpression=ruleHasExpression();
            _fsp--;

             current =iv_ruleHasExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHasExpression1337); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleHasExpression


    // $ANTLR start ruleHasExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:762:1: ruleHasExpression returns [EObject current=null] : ( () 'has' ( (lv_kind_2_0= ruleKind ) ) ( (lv_what_3_0= ruleConcatExpression ) ) ) ;
    public final EObject ruleHasExpression() throws RecognitionException {
        EObject current = null;

        Enumerator lv_kind_2_0 = null;

        EObject lv_what_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:767:6: ( ( () 'has' ( (lv_kind_2_0= ruleKind ) ) ( (lv_what_3_0= ruleConcatExpression ) ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:768:1: ( () 'has' ( (lv_kind_2_0= ruleKind ) ) ( (lv_what_3_0= ruleConcatExpression ) ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:768:1: ( () 'has' ( (lv_kind_2_0= ruleKind ) ) ( (lv_what_3_0= ruleConcatExpression ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:768:2: () 'has' ( (lv_kind_2_0= ruleKind ) ) ( (lv_what_3_0= ruleConcatExpression ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:768:2: ()
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:769:5: 
            {
             
                    temp=factory.create(grammarAccess.getHasExpressionAccess().getHasExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getHasExpressionAccess().getHasExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            match(input,15,FOLLOW_15_in_ruleHasExpression1381); 

                    createLeafNode(grammarAccess.getHasExpressionAccess().getHasKeyword_1(), null); 
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:783:1: ( (lv_kind_2_0= ruleKind ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:784:1: (lv_kind_2_0= ruleKind )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:784:1: (lv_kind_2_0= ruleKind )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:785:3: lv_kind_2_0= ruleKind
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getHasExpressionAccess().getKindKindEnumRuleCall_2_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleKind_in_ruleHasExpression1402);
            lv_kind_2_0=ruleKind();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getHasExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"kind",
            	        		lv_kind_2_0, 
            	        		"Kind", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:807:2: ( (lv_what_3_0= ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:808:1: (lv_what_3_0= ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:808:1: (lv_what_3_0= ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:809:3: lv_what_3_0= ruleConcatExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getHasExpressionAccess().getWhatConcatExpressionParserRuleCall_3_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConcatExpression_in_ruleHasExpression1423);
            lv_what_3_0=ruleConcatExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getHasExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"what",
            	        		lv_what_3_0, 
            	        		"ConcatExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleHasExpression


    // $ANTLR start entryRuleTestExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:839:1: entryRuleTestExpression returns [EObject current=null] : iv_ruleTestExpression= ruleTestExpression EOF ;
    public final EObject entryRuleTestExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:840:2: (iv_ruleTestExpression= ruleTestExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:841:2: iv_ruleTestExpression= ruleTestExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTestExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleTestExpression_in_entryRuleTestExpression1459);
            iv_ruleTestExpression=ruleTestExpression();
            _fsp--;

             current =iv_ruleTestExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestExpression1469); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleTestExpression


    // $ANTLR start ruleTestExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:848:1: ruleTestExpression returns [EObject current=null] : ( () ( (lv_property_1_0= RULE_ID ) ) ( '.' ( (lv_property_3_0= RULE_ID ) ) )* '(' ( (lv_args_5_0= ruleConcatExpression ) ) ( ',' ( (lv_args_7_0= ruleConcatExpression ) ) )* ')' 'is' ( (lv_expected_10_0= ruleConcatExpression ) ) ) ;
    public final EObject ruleTestExpression() throws RecognitionException {
        EObject current = null;

        Token lv_property_1_0=null;
        Token lv_property_3_0=null;
        EObject lv_args_5_0 = null;

        EObject lv_args_7_0 = null;

        EObject lv_expected_10_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:853:6: ( ( () ( (lv_property_1_0= RULE_ID ) ) ( '.' ( (lv_property_3_0= RULE_ID ) ) )* '(' ( (lv_args_5_0= ruleConcatExpression ) ) ( ',' ( (lv_args_7_0= ruleConcatExpression ) ) )* ')' 'is' ( (lv_expected_10_0= ruleConcatExpression ) ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:854:1: ( () ( (lv_property_1_0= RULE_ID ) ) ( '.' ( (lv_property_3_0= RULE_ID ) ) )* '(' ( (lv_args_5_0= ruleConcatExpression ) ) ( ',' ( (lv_args_7_0= ruleConcatExpression ) ) )* ')' 'is' ( (lv_expected_10_0= ruleConcatExpression ) ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:854:1: ( () ( (lv_property_1_0= RULE_ID ) ) ( '.' ( (lv_property_3_0= RULE_ID ) ) )* '(' ( (lv_args_5_0= ruleConcatExpression ) ) ( ',' ( (lv_args_7_0= ruleConcatExpression ) ) )* ')' 'is' ( (lv_expected_10_0= ruleConcatExpression ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:854:2: () ( (lv_property_1_0= RULE_ID ) ) ( '.' ( (lv_property_3_0= RULE_ID ) ) )* '(' ( (lv_args_5_0= ruleConcatExpression ) ) ( ',' ( (lv_args_7_0= ruleConcatExpression ) ) )* ')' 'is' ( (lv_expected_10_0= ruleConcatExpression ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:854:2: ()
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:855:5: 
            {
             
                    temp=factory.create(grammarAccess.getTestExpressionAccess().getTestExpressionAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getTestExpressionAccess().getTestExpressionAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:865:2: ( (lv_property_1_0= RULE_ID ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:866:1: (lv_property_1_0= RULE_ID )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:866:1: (lv_property_1_0= RULE_ID )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:867:3: lv_property_1_0= RULE_ID
            {
            lv_property_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTestExpression1520); 

            			createLeafNode(grammarAccess.getTestExpressionAccess().getPropertyIDTerminalRuleCall_1_0(), "property"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTestExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"property",
            	        		lv_property_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:889:2: ( '.' ( (lv_property_3_0= RULE_ID ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==16) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:889:4: '.' ( (lv_property_3_0= RULE_ID ) )
            	    {
            	    match(input,16,FOLLOW_16_in_ruleTestExpression1536); 

            	            createLeafNode(grammarAccess.getTestExpressionAccess().getFullStopKeyword_2_0(), null); 
            	        
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:893:1: ( (lv_property_3_0= RULE_ID ) )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:894:1: (lv_property_3_0= RULE_ID )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:894:1: (lv_property_3_0= RULE_ID )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:895:3: lv_property_3_0= RULE_ID
            	    {
            	    lv_property_3_0=(Token)input.LT(1);
            	    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTestExpression1553); 

            	    			createLeafNode(grammarAccess.getTestExpressionAccess().getPropertyIDTerminalRuleCall_2_1_0(), "property"); 
            	    		

            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode, current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"property",
            	    	        		lv_property_3_0, 
            	    	        		"ID", 
            	    	        		lastConsumedNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            match(input,12,FOLLOW_12_in_ruleTestExpression1570); 

                    createLeafNode(grammarAccess.getTestExpressionAccess().getLeftParenthesisKeyword_3(), null); 
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:921:1: ( (lv_args_5_0= ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:922:1: (lv_args_5_0= ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:922:1: (lv_args_5_0= ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:923:3: lv_args_5_0= ruleConcatExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTestExpressionAccess().getArgsConcatExpressionParserRuleCall_4_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConcatExpression_in_ruleTestExpression1591);
            lv_args_5_0=ruleConcatExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTestExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		add(
            	       			current, 
            	       			"args",
            	        		lv_args_5_0, 
            	        		"ConcatExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }

            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:945:2: ( ',' ( (lv_args_7_0= ruleConcatExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==17) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:945:4: ',' ( (lv_args_7_0= ruleConcatExpression ) )
            	    {
            	    match(input,17,FOLLOW_17_in_ruleTestExpression1602); 

            	            createLeafNode(grammarAccess.getTestExpressionAccess().getCommaKeyword_5_0(), null); 
            	        
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:949:1: ( (lv_args_7_0= ruleConcatExpression ) )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:950:1: (lv_args_7_0= ruleConcatExpression )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:950:1: (lv_args_7_0= ruleConcatExpression )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:951:3: lv_args_7_0= ruleConcatExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getTestExpressionAccess().getArgsConcatExpressionParserRuleCall_5_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleConcatExpression_in_ruleTestExpression1623);
            	    lv_args_7_0=ruleConcatExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getTestExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"args",
            	    	        		lv_args_7_0, 
            	    	        		"ConcatExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match(input,13,FOLLOW_13_in_ruleTestExpression1635); 

                    createLeafNode(grammarAccess.getTestExpressionAccess().getRightParenthesisKeyword_6(), null); 
                
            match(input,14,FOLLOW_14_in_ruleTestExpression1645); 

                    createLeafNode(grammarAccess.getTestExpressionAccess().getIsKeyword_7(), null); 
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:981:1: ( (lv_expected_10_0= ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:982:1: (lv_expected_10_0= ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:982:1: (lv_expected_10_0= ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:983:3: lv_expected_10_0= ruleConcatExpression
            {
             
            	        currentNode=createCompositeNode(grammarAccess.getTestExpressionAccess().getExpectedConcatExpressionParserRuleCall_8_0(), currentNode); 
            	    
            pushFollow(FOLLOW_ruleConcatExpression_in_ruleTestExpression1666);
            lv_expected_10_0=ruleConcatExpression();
            _fsp--;


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getTestExpressionRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode.getParent(), current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"expected",
            	        		lv_expected_10_0, 
            	        		"ConcatExpression", 
            	        		currentNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	        currentNode = currentNode.getParent();
            	    

            }


            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleTestExpression


    // $ANTLR start entryRuleConcatExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1013:1: entryRuleConcatExpression returns [EObject current=null] : iv_ruleConcatExpression= ruleConcatExpression EOF ;
    public final EObject entryRuleConcatExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1014:2: (iv_ruleConcatExpression= ruleConcatExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1015:2: iv_ruleConcatExpression= ruleConcatExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getConcatExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleConcatExpression_in_entryRuleConcatExpression1702);
            iv_ruleConcatExpression=ruleConcatExpression();
            _fsp--;

             current =iv_ruleConcatExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcatExpression1712); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleConcatExpression


    // $ANTLR start ruleConcatExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1022:1: ruleConcatExpression returns [EObject current=null] : (this_StringExpression_0= ruleStringExpression ( () '+' ( (lv_right_3_0= ruleStringExpression ) ) )* ) ;
    public final EObject ruleConcatExpression() throws RecognitionException {
        EObject current = null;

        EObject this_StringExpression_0 = null;

        EObject lv_right_3_0 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1027:6: ( (this_StringExpression_0= ruleStringExpression ( () '+' ( (lv_right_3_0= ruleStringExpression ) ) )* ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1028:1: (this_StringExpression_0= ruleStringExpression ( () '+' ( (lv_right_3_0= ruleStringExpression ) ) )* )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1028:1: (this_StringExpression_0= ruleStringExpression ( () '+' ( (lv_right_3_0= ruleStringExpression ) ) )* )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1029:5: this_StringExpression_0= ruleStringExpression ( () '+' ( (lv_right_3_0= ruleStringExpression ) ) )*
            {
             
                    currentNode=createCompositeNode(grammarAccess.getConcatExpressionAccess().getStringExpressionParserRuleCall_0(), currentNode); 
                
            pushFollow(FOLLOW_ruleStringExpression_in_ruleConcatExpression1759);
            this_StringExpression_0=ruleStringExpression();
            _fsp--;

             
                    current = this_StringExpression_0; 
                    currentNode = currentNode.getParent();
                
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1037:1: ( () '+' ( (lv_right_3_0= ruleStringExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==18) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1037:2: () '+' ( (lv_right_3_0= ruleStringExpression ) )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1037:2: ()
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1038:5: 
            	    {
            	     
            	            temp=factory.create(grammarAccess.getConcatExpressionAccess().getConcatExpressionLeftAction_1_0().getType().getClassifier());
            	            try {
            	            	factory.set(temp, "left", current, null /*ParserRule*/, currentNode);
            	            } catch(ValueConverterException vce) {
            	            	handleValueConverterException(vce);
            	            }
            	            current = temp; 
            	            temp = null;
            	            CompositeNode newNode = createCompositeNode(grammarAccess.getConcatExpressionAccess().getConcatExpressionLeftAction_1_0(), currentNode.getParent());
            	        newNode.getChildren().add(currentNode);
            	        moveLookaheadInfo(currentNode, newNode);
            	        currentNode = newNode; 
            	            associateNodeWithAstElement(currentNode, current); 
            	        

            	    }

            	    match(input,18,FOLLOW_18_in_ruleConcatExpression1778); 

            	            createLeafNode(grammarAccess.getConcatExpressionAccess().getPlusSignKeyword_1_1(), null); 
            	        
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1057:1: ( (lv_right_3_0= ruleStringExpression ) )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1058:1: (lv_right_3_0= ruleStringExpression )
            	    {
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1058:1: (lv_right_3_0= ruleStringExpression )
            	    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1059:3: lv_right_3_0= ruleStringExpression
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getConcatExpressionAccess().getRightStringExpressionParserRuleCall_1_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleStringExpression_in_ruleConcatExpression1799);
            	    lv_right_3_0=ruleStringExpression();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getConcatExpressionRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		set(
            	    	       			current, 
            	    	       			"right",
            	    	        		lv_right_3_0, 
            	    	        		"StringExpression", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleConcatExpression


    // $ANTLR start entryRuleStringExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1089:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1090:2: (iv_ruleStringExpression= ruleStringExpression EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1091:2: iv_ruleStringExpression= ruleStringExpression EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringExpressionRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression1837);
            iv_ruleStringExpression=ruleStringExpression();
            _fsp--;

             current =iv_ruleStringExpression; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression1847); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStringExpression


    // $ANTLR start ruleStringExpression
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1098:1: ruleStringExpression returns [EObject current=null] : (this_StringLiteral_0= ruleStringLiteral | this_PropertyAccess_1= rulePropertyAccess ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject this_StringLiteral_0 = null;

        EObject this_PropertyAccess_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1103:6: ( (this_StringLiteral_0= ruleStringLiteral | this_PropertyAccess_1= rulePropertyAccess ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1104:1: (this_StringLiteral_0= ruleStringLiteral | this_PropertyAccess_1= rulePropertyAccess )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1104:1: (this_StringLiteral_0= ruleStringLiteral | this_PropertyAccess_1= rulePropertyAccess )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            else if ( (LA11_0==RULE_ID) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1104:1: (this_StringLiteral_0= ruleStringLiteral | this_PropertyAccess_1= rulePropertyAccess )", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1105:5: this_StringLiteral_0= ruleStringLiteral
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStringExpressionAccess().getStringLiteralParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleStringLiteral_in_ruleStringExpression1894);
                    this_StringLiteral_0=ruleStringLiteral();
                    _fsp--;

                     
                            current = this_StringLiteral_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1115:5: this_PropertyAccess_1= rulePropertyAccess
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getStringExpressionAccess().getPropertyAccessParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_rulePropertyAccess_in_ruleStringExpression1921);
                    this_PropertyAccess_1=rulePropertyAccess();
                    _fsp--;

                     
                            current = this_PropertyAccess_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringExpression


    // $ANTLR start entryRuleStringLiteral
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1131:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1132:2: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1133:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
             currentNode = createCompositeNode(grammarAccess.getStringLiteralRule(), currentNode); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1956);
            iv_ruleStringLiteral=ruleStringLiteral();
            _fsp--;

             current =iv_ruleStringLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral1966); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleStringLiteral


    // $ANTLR start ruleStringLiteral
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1140:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1145:6: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1146:1: ( (lv_value_0_0= RULE_STRING ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1146:1: ( (lv_value_0_0= RULE_STRING ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1147:1: (lv_value_0_0= RULE_STRING )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1147:1: (lv_value_0_0= RULE_STRING )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1148:3: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringLiteral2007); 

            			createLeafNode(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0(), "value"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getStringLiteralRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"value",
            	        		lv_value_0_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringLiteral


    // $ANTLR start entryRulePropertyAccess
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1178:1: entryRulePropertyAccess returns [EObject current=null] : iv_rulePropertyAccess= rulePropertyAccess EOF ;
    public final EObject entryRulePropertyAccess() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePropertyAccess = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1179:2: (iv_rulePropertyAccess= rulePropertyAccess EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1180:2: iv_rulePropertyAccess= rulePropertyAccess EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyAccessRule(), currentNode); 
            pushFollow(FOLLOW_rulePropertyAccess_in_entryRulePropertyAccess2047);
            iv_rulePropertyAccess=rulePropertyAccess();
            _fsp--;

             current =iv_rulePropertyAccess; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAccess2057); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRulePropertyAccess


    // $ANTLR start rulePropertyAccess
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1187:1: rulePropertyAccess returns [EObject current=null] : ( (lv_property_0_0= RULE_ID ) ) ;
    public final EObject rulePropertyAccess() throws RecognitionException {
        EObject current = null;

        Token lv_property_0_0=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1192:6: ( ( (lv_property_0_0= RULE_ID ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1193:1: ( (lv_property_0_0= RULE_ID ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1193:1: ( (lv_property_0_0= RULE_ID ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1194:1: (lv_property_0_0= RULE_ID )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1194:1: (lv_property_0_0= RULE_ID )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1195:3: lv_property_0_0= RULE_ID
            {
            lv_property_0_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rulePropertyAccess2098); 

            			createLeafNode(grammarAccess.getPropertyAccessAccess().getPropertyIDTerminalRuleCall_0(), "property"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getPropertyAccessRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"property",
            	        		lv_property_0_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end rulePropertyAccess


    // $ANTLR start entryRuleOrOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1225:1: entryRuleOrOperator returns [String current=null] : iv_ruleOrOperator= ruleOrOperator EOF ;
    public final String entryRuleOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleOrOperator = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1226:2: (iv_ruleOrOperator= ruleOrOperator EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1227:2: iv_ruleOrOperator= ruleOrOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getOrOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleOrOperator_in_entryRuleOrOperator2139);
            iv_ruleOrOperator=ruleOrOperator();
            _fsp--;

             current =iv_ruleOrOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrOperator2150); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleOrOperator


    // $ANTLR start ruleOrOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1234:1: ruleOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '|' | kw= '||' | kw= 'or' ) ;
    public final AntlrDatatypeRuleToken ruleOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1239:6: ( (kw= '|' | kw= '||' | kw= 'or' ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1240:1: (kw= '|' | kw= '||' | kw= 'or' )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1240:1: (kw= '|' | kw= '||' | kw= 'or' )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt12=1;
                }
                break;
            case 20:
                {
                alt12=2;
                }
                break;
            case 21:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1240:1: (kw= '|' | kw= '||' | kw= 'or' )", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1241:2: kw= '|'
                    {
                    kw=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleOrOperator2188); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getOrOperatorAccess().getVerticalLineKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1248:2: kw= '||'
                    {
                    kw=(Token)input.LT(1);
                    match(input,20,FOLLOW_20_in_ruleOrOperator2207); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getOrOperatorAccess().getVerticalLineVerticalLineKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1255:2: kw= 'or'
                    {
                    kw=(Token)input.LT(1);
                    match(input,21,FOLLOW_21_in_ruleOrOperator2226); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getOrOperatorAccess().getOrKeyword_2(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleOrOperator


    // $ANTLR start entryRuleXorOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1268:1: entryRuleXorOperator returns [String current=null] : iv_ruleXorOperator= ruleXorOperator EOF ;
    public final String entryRuleXorOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleXorOperator = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1269:2: (iv_ruleXorOperator= ruleXorOperator EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1270:2: iv_ruleXorOperator= ruleXorOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getXorOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleXorOperator_in_entryRuleXorOperator2267);
            iv_ruleXorOperator=ruleXorOperator();
            _fsp--;

             current =iv_ruleXorOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXorOperator2278); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleXorOperator


    // $ANTLR start ruleXorOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1277:1: ruleXorOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '^' | kw= 'xor' ) ;
    public final AntlrDatatypeRuleToken ruleXorOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1282:6: ( (kw= '^' | kw= 'xor' ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1283:1: (kw= '^' | kw= 'xor' )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1283:1: (kw= '^' | kw= 'xor' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            else if ( (LA13_0==23) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1283:1: (kw= '^' | kw= 'xor' )", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1284:2: kw= '^'
                    {
                    kw=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleXorOperator2316); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getXorOperatorAccess().getCircumflexAccentKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1291:2: kw= 'xor'
                    {
                    kw=(Token)input.LT(1);
                    match(input,23,FOLLOW_23_in_ruleXorOperator2335); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getXorOperatorAccess().getXorKeyword_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleXorOperator


    // $ANTLR start entryRuleAndOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1304:1: entryRuleAndOperator returns [String current=null] : iv_ruleAndOperator= ruleAndOperator EOF ;
    public final String entryRuleAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAndOperator = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1305:2: (iv_ruleAndOperator= ruleAndOperator EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1306:2: iv_ruleAndOperator= ruleAndOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getAndOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleAndOperator_in_entryRuleAndOperator2376);
            iv_ruleAndOperator=ruleAndOperator();
            _fsp--;

             current =iv_ruleAndOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOperator2387); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleAndOperator


    // $ANTLR start ruleAndOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1313:1: ruleAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '&' | kw= '&&' | kw= 'and' ) ;
    public final AntlrDatatypeRuleToken ruleAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1318:6: ( (kw= '&' | kw= '&&' | kw= 'and' ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1319:1: (kw= '&' | kw= '&&' | kw= 'and' )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1319:1: (kw= '&' | kw= '&&' | kw= 'and' )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt14=1;
                }
                break;
            case 25:
                {
                alt14=2;
                }
                break;
            case 26:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1319:1: (kw= '&' | kw= '&&' | kw= 'and' )", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1320:2: kw= '&'
                    {
                    kw=(Token)input.LT(1);
                    match(input,24,FOLLOW_24_in_ruleAndOperator2425); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAndOperatorAccess().getAmpersandKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1327:2: kw= '&&'
                    {
                    kw=(Token)input.LT(1);
                    match(input,25,FOLLOW_25_in_ruleAndOperator2444); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAndOperatorAccess().getAmpersandAmpersandKeyword_1(), null); 
                        

                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1334:2: kw= 'and'
                    {
                    kw=(Token)input.LT(1);
                    match(input,26,FOLLOW_26_in_ruleAndOperator2463); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getAndOperatorAccess().getAndKeyword_2(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleAndOperator


    // $ANTLR start entryRuleNotOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1347:1: entryRuleNotOperator returns [String current=null] : iv_ruleNotOperator= ruleNotOperator EOF ;
    public final String entryRuleNotOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNotOperator = null;


        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1348:2: (iv_ruleNotOperator= ruleNotOperator EOF )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1349:2: iv_ruleNotOperator= ruleNotOperator EOF
            {
             currentNode = createCompositeNode(grammarAccess.getNotOperatorRule(), currentNode); 
            pushFollow(FOLLOW_ruleNotOperator_in_entryRuleNotOperator2504);
            iv_ruleNotOperator=ruleNotOperator();
            _fsp--;

             current =iv_ruleNotOperator.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOperator2515); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleNotOperator


    // $ANTLR start ruleNotOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1356:1: ruleNotOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '!' | kw= 'not' ) ;
    public final AntlrDatatypeRuleToken ruleNotOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1361:6: ( (kw= '!' | kw= 'not' ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1362:1: (kw= '!' | kw= 'not' )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1362:1: (kw= '!' | kw= 'not' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            else if ( (LA15_0==28) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("1362:1: (kw= '!' | kw= 'not' )", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1363:2: kw= '!'
                    {
                    kw=(Token)input.LT(1);
                    match(input,27,FOLLOW_27_in_ruleNotOperator2553); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNotOperatorAccess().getExclamationMarkKeyword_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1370:2: kw= 'not'
                    {
                    kw=(Token)input.LT(1);
                    match(input,28,FOLLOW_28_in_ruleNotOperator2572); 

                            current.merge(kw);
                            createLeafNode(grammarAccess.getNotOperatorAccess().getNotKeyword_1(), null); 
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
            	    lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleNotOperator


    // $ANTLR start ruleComparisonOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1383:1: ruleComparisonOperator returns [Enumerator current=null] : ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) ) ;
    public final Enumerator ruleComparisonOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1387:6: ( ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1388:1: ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1388:1: ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) )
            int alt16=8;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt16=1;
                }
                break;
            case 30:
                {
                alt16=2;
                }
                break;
            case 31:
                {
                alt16=3;
                }
                break;
            case 32:
                {
                alt16=4;
                }
                break;
            case 33:
                {
                alt16=5;
                }
                break;
            case 34:
                {
                alt16=6;
                }
                break;
            case 35:
                {
                alt16=7;
                }
                break;
            case 36:
                {
                alt16=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1388:1: ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) )", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1388:2: ( '=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1388:2: ( '=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1388:4: '='
                    {
                    match(input,29,FOLLOW_29_in_ruleComparisonOperator2624); 

                            current = grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1394:6: ( '==' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1394:6: ( '==' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1394:8: '=='
                    {
                    match(input,30,FOLLOW_30_in_ruleComparisonOperator2639); 

                            current = grammarAccess.getComparisonOperatorAccess().getEQ2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getEQ2EnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1400:6: ( '!=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1400:6: ( '!=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1400:8: '!='
                    {
                    match(input,31,FOLLOW_31_in_ruleComparisonOperator2654); 

                            current = grammarAccess.getComparisonOperatorAccess().getNEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getNEEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1406:6: ( '<>' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1406:6: ( '<>' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1406:8: '<>'
                    {
                    match(input,32,FOLLOW_32_in_ruleComparisonOperator2669); 

                            current = grammarAccess.getComparisonOperatorAccess().getNE2EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getNE2EnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1412:6: ( '>' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1412:6: ( '>' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1412:8: '>'
                    {
                    match(input,33,FOLLOW_33_in_ruleComparisonOperator2684); 

                            current = grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1418:6: ( '>=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1418:6: ( '>=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1418:8: '>='
                    {
                    match(input,34,FOLLOW_34_in_ruleComparisonOperator2699); 

                            current = grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1424:6: ( '<' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1424:6: ( '<' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1424:8: '<'
                    {
                    match(input,35,FOLLOW_35_in_ruleComparisonOperator2714); 

                            current = grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1430:6: ( '<=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1430:6: ( '<=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1430:8: '<='
                    {
                    match(input,36,FOLLOW_36_in_ruleComparisonOperator2729); 

                            current = grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleComparisonOperator


    // $ANTLR start ruleStringOperator
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1440:1: ruleStringOperator returns [Enumerator current=null] : ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( 'like' ) | ( '~' ) | ( 'unlike' ) | ( '!~' ) | ( 'starts' ) | ( 'ends' ) | ( 'contains' ) ) ;
    public final Enumerator ruleStringOperator() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1444:6: ( ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( 'like' ) | ( '~' ) | ( 'unlike' ) | ( '!~' ) | ( 'starts' ) | ( 'ends' ) | ( 'contains' ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1445:1: ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( 'like' ) | ( '~' ) | ( 'unlike' ) | ( '!~' ) | ( 'starts' ) | ( 'ends' ) | ( 'contains' ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1445:1: ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( 'like' ) | ( '~' ) | ( 'unlike' ) | ( '!~' ) | ( 'starts' ) | ( 'ends' ) | ( 'contains' ) )
            int alt17=15;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt17=1;
                }
                break;
            case 30:
                {
                alt17=2;
                }
                break;
            case 31:
                {
                alt17=3;
                }
                break;
            case 32:
                {
                alt17=4;
                }
                break;
            case 33:
                {
                alt17=5;
                }
                break;
            case 34:
                {
                alt17=6;
                }
                break;
            case 35:
                {
                alt17=7;
                }
                break;
            case 36:
                {
                alt17=8;
                }
                break;
            case 37:
                {
                alt17=9;
                }
                break;
            case 38:
                {
                alt17=10;
                }
                break;
            case 39:
                {
                alt17=11;
                }
                break;
            case 40:
                {
                alt17=12;
                }
                break;
            case 41:
                {
                alt17=13;
                }
                break;
            case 42:
                {
                alt17=14;
                }
                break;
            case 43:
                {
                alt17=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1445:1: ( ( '=' ) | ( '==' ) | ( '!=' ) | ( '<>' ) | ( '>' ) | ( '>=' ) | ( '<' ) | ( '<=' ) | ( 'like' ) | ( '~' ) | ( 'unlike' ) | ( '!~' ) | ( 'starts' ) | ( 'ends' ) | ( 'contains' ) )", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1445:2: ( '=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1445:2: ( '=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1445:4: '='
                    {
                    match(input,29,FOLLOW_29_in_ruleStringOperator2772); 

                            current = grammarAccess.getStringOperatorAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEQEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1451:6: ( '==' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1451:6: ( '==' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1451:8: '=='
                    {
                    match(input,30,FOLLOW_30_in_ruleStringOperator2787); 

                            current = grammarAccess.getStringOperatorAccess().getEQ2EnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getEQ2EnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1457:6: ( '!=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1457:6: ( '!=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1457:8: '!='
                    {
                    match(input,31,FOLLOW_31_in_ruleStringOperator2802); 

                            current = grammarAccess.getStringOperatorAccess().getNEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNEEnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1463:6: ( '<>' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1463:6: ( '<>' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1463:8: '<>'
                    {
                    match(input,32,FOLLOW_32_in_ruleStringOperator2817); 

                            current = grammarAccess.getStringOperatorAccess().getNE2EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getNE2EnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1469:6: ( '>' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1469:6: ( '>' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1469:8: '>'
                    {
                    match(input,33,FOLLOW_33_in_ruleStringOperator2832); 

                            current = grammarAccess.getStringOperatorAccess().getGTEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getGTEnumLiteralDeclaration_4(), null); 
                        

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1475:6: ( '>=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1475:6: ( '>=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1475:8: '>='
                    {
                    match(input,34,FOLLOW_34_in_ruleStringOperator2847); 

                            current = grammarAccess.getStringOperatorAccess().getGEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getGEEnumLiteralDeclaration_5(), null); 
                        

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1481:6: ( '<' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1481:6: ( '<' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1481:8: '<'
                    {
                    match(input,35,FOLLOW_35_in_ruleStringOperator2862); 

                            current = grammarAccess.getStringOperatorAccess().getLTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLTEnumLiteralDeclaration_6(), null); 
                        

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1487:6: ( '<=' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1487:6: ( '<=' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1487:8: '<='
                    {
                    match(input,36,FOLLOW_36_in_ruleStringOperator2877); 

                            current = grammarAccess.getStringOperatorAccess().getLEEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLEEnumLiteralDeclaration_7(), null); 
                        

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1493:6: ( 'like' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1493:6: ( 'like' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1493:8: 'like'
                    {
                    match(input,37,FOLLOW_37_in_ruleStringOperator2892); 

                            current = grammarAccess.getStringOperatorAccess().getLIKEEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLIKEEnumLiteralDeclaration_8(), null); 
                        

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1499:6: ( '~' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1499:6: ( '~' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1499:8: '~'
                    {
                    match(input,38,FOLLOW_38_in_ruleStringOperator2907); 

                            current = grammarAccess.getStringOperatorAccess().getLIKE2EnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getLIKE2EnumLiteralDeclaration_9(), null); 
                        

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1505:6: ( 'unlike' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1505:6: ( 'unlike' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1505:8: 'unlike'
                    {
                    match(input,39,FOLLOW_39_in_ruleStringOperator2922); 

                            current = grammarAccess.getStringOperatorAccess().getUNLIKEEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getUNLIKEEnumLiteralDeclaration_10(), null); 
                        

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1511:6: ( '!~' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1511:6: ( '!~' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1511:8: '!~'
                    {
                    match(input,40,FOLLOW_40_in_ruleStringOperator2937); 

                            current = grammarAccess.getStringOperatorAccess().getUNLIKE2EnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getUNLIKE2EnumLiteralDeclaration_11(), null); 
                        

                    }


                    }
                    break;
                case 13 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1517:6: ( 'starts' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1517:6: ( 'starts' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1517:8: 'starts'
                    {
                    match(input,41,FOLLOW_41_in_ruleStringOperator2952); 

                            current = grammarAccess.getStringOperatorAccess().getSTARTSEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getSTARTSEnumLiteralDeclaration_12(), null); 
                        

                    }


                    }
                    break;
                case 14 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1523:6: ( 'ends' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1523:6: ( 'ends' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1523:8: 'ends'
                    {
                    match(input,42,FOLLOW_42_in_ruleStringOperator2967); 

                            current = grammarAccess.getStringOperatorAccess().getENDSEnumLiteralDeclaration_13().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getENDSEnumLiteralDeclaration_13(), null); 
                        

                    }


                    }
                    break;
                case 15 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1529:6: ( 'contains' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1529:6: ( 'contains' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1529:8: 'contains'
                    {
                    match(input,43,FOLLOW_43_in_ruleStringOperator2982); 

                            current = grammarAccess.getStringOperatorAccess().getCONTAINSEnumLiteralDeclaration_14().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getStringOperatorAccess().getCONTAINSEnumLiteralDeclaration_14(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleStringOperator


    // $ANTLR start ruleType
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1539:1: ruleType returns [Enumerator current=null] : ( ( 'file' ) | ( 'folder' ) | ( 'container' ) | ( 'project' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1543:6: ( ( ( 'file' ) | ( 'folder' ) | ( 'container' ) | ( 'project' ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1544:1: ( ( 'file' ) | ( 'folder' ) | ( 'container' ) | ( 'project' ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1544:1: ( ( 'file' ) | ( 'folder' ) | ( 'container' ) | ( 'project' ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 44:
                {
                alt18=1;
                }
                break;
            case 45:
                {
                alt18=2;
                }
                break;
            case 46:
                {
                alt18=3;
                }
                break;
            case 47:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1544:1: ( ( 'file' ) | ( 'folder' ) | ( 'container' ) | ( 'project' ) )", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1544:2: ( 'file' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1544:2: ( 'file' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1544:4: 'file'
                    {
                    match(input,44,FOLLOW_44_in_ruleType3025); 

                            current = grammarAccess.getTypeAccess().getFILEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getFILEEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1550:6: ( 'folder' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1550:6: ( 'folder' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1550:8: 'folder'
                    {
                    match(input,45,FOLLOW_45_in_ruleType3040); 

                            current = grammarAccess.getTypeAccess().getFOLDEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getFOLDEREnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1556:6: ( 'container' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1556:6: ( 'container' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1556:8: 'container'
                    {
                    match(input,46,FOLLOW_46_in_ruleType3055); 

                            current = grammarAccess.getTypeAccess().getCONTAINEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getCONTAINEREnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1562:6: ( 'project' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1562:6: ( 'project' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1562:8: 'project'
                    {
                    match(input,47,FOLLOW_47_in_ruleType3070); 

                            current = grammarAccess.getTypeAccess().getPROJECTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getTypeAccess().getPROJECTEnumLiteralDeclaration_3(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleType


    // $ANTLR start ruleKind
    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1572:1: ruleKind returns [Enumerator current=null] : ( ( 'reference' ) | ( 'nature' ) | ( 'builder' ) ) ;
    public final Enumerator ruleKind() throws RecognitionException {
        Enumerator current = null;

         setCurrentLookahead(); resetLookahead(); 
        try {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1576:6: ( ( ( 'reference' ) | ( 'nature' ) | ( 'builder' ) ) )
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1577:1: ( ( 'reference' ) | ( 'nature' ) | ( 'builder' ) )
            {
            // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1577:1: ( ( 'reference' ) | ( 'nature' ) | ( 'builder' ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case 48:
                {
                alt19=1;
                }
                break;
            case 49:
                {
                alt19=2;
                }
                break;
            case 50:
                {
                alt19=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1577:1: ( ( 'reference' ) | ( 'nature' ) | ( 'builder' ) )", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1577:2: ( 'reference' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1577:2: ( 'reference' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1577:4: 'reference'
                    {
                    match(input,48,FOLLOW_48_in_ruleKind3113); 

                            current = grammarAccess.getKindAccess().getREFERENCEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getKindAccess().getREFERENCEEnumLiteralDeclaration_0(), null); 
                        

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1583:6: ( 'nature' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1583:6: ( 'nature' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1583:8: 'nature'
                    {
                    match(input,49,FOLLOW_49_in_ruleKind3128); 

                            current = grammarAccess.getKindAccess().getNATUREEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getKindAccess().getNATUREEnumLiteralDeclaration_1(), null); 
                        

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1589:6: ( 'builder' )
                    {
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1589:6: ( 'builder' )
                    // ../org.eclipse.net4j.tools.workingset/src-gen/org/eclipse/net4j/tools/workingset/parser/antlr/internal/InternalDsl.g:1589:8: 'builder'
                    {
                    match(input,50,FOLLOW_50_in_ruleKind3143); 

                            current = grammarAccess.getKindAccess().getBUILDEREnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                            createLeafNode(grammarAccess.getKindAccess().getBUILDEREnumLiteralDeclaration_2(), null); 
                        

                    }


                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleKind


 

    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleBooleanExpression131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorExpression_in_ruleOrExpression222 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_ruleOrOperator_in_ruleOrExpression240 = new BitSet(new long[]{0x000000001800D070L});
    public static final BitSet FOLLOW_ruleXorExpression_in_ruleOrExpression253 = new BitSet(new long[]{0x0000000000380002L});
    public static final BitSet FOLLOW_ruleXorExpression_in_entryRuleXorExpression291 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXorExpression301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleXorExpression348 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleXorOperator_in_ruleXorExpression366 = new BitSet(new long[]{0x000000001800D070L});
    public static final BitSet FOLLOW_ruleAndExpression_in_ruleXorExpression379 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression417 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonExpression_in_ruleAndExpression474 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_ruleAndOperator_in_ruleAndExpression492 = new BitSet(new long[]{0x000000001800D070L});
    public static final BitSet FOLLOW_ruleComparisonExpression_in_ruleAndExpression505 = new BitSet(new long[]{0x0000000007000002L});
    public static final BitSet FOLLOW_ruleComparisonExpression_in_entryRuleComparisonExpression543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparisonExpression553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleComparisonExpression601 = new BitSet(new long[]{0x0000001FE0000002L});
    public static final BitSet FOLLOW_ruleComparisonOperator_in_ruleComparisonExpression631 = new BitSet(new long[]{0x000000001800D030L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleComparisonExpression652 = new BitSet(new long[]{0x0000001FE0000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_ruleComparisonExpression684 = new BitSet(new long[]{0x00000FFFE0000000L});
    public static final BitSet FOLLOW_ruleStringOperator_in_ruleComparisonExpression714 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_ruleComparisonExpression735 = new BitSet(new long[]{0x00000FFFE0000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression774 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rulePrimaryExpression831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotExpression_in_rulePrimaryExpression858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsExpression_in_rulePrimaryExpression885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHasExpression_in_rulePrimaryExpression912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestExpression_in_rulePrimaryExpression939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rulePrimaryExpression955 = new BitSet(new long[]{0x000000001800D070L});
    public static final BitSet FOLLOW_ruleOrExpression_in_rulePrimaryExpression977 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_rulePrimaryExpression986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral1023 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_ruleBooleanLiteral1074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotExpression_in_entryRuleNotExpression1114 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotExpression1124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperator_in_ruleNotExpression1167 = new BitSet(new long[]{0x000000001800D030L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_ruleNotExpression1180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsExpression_in_entryRuleIsExpression1216 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsExpression1226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleIsExpression1270 = new BitSet(new long[]{0x0000F00000000000L});
    public static final BitSet FOLLOW_ruleType_in_ruleIsExpression1291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHasExpression_in_entryRuleHasExpression1327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHasExpression1337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleHasExpression1381 = new BitSet(new long[]{0x0007000000000000L});
    public static final BitSet FOLLOW_ruleKind_in_ruleHasExpression1402 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_ruleHasExpression1423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestExpression_in_entryRuleTestExpression1459 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestExpression1469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTestExpression1520 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_16_in_ruleTestExpression1536 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTestExpression1553 = new BitSet(new long[]{0x0000000000011000L});
    public static final BitSet FOLLOW_12_in_ruleTestExpression1570 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_ruleTestExpression1591 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleTestExpression1602 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_ruleTestExpression1623 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleTestExpression1635 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTestExpression1645 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_ruleTestExpression1666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_entryRuleConcatExpression1702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcatExpression1712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_ruleConcatExpression1759 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleConcatExpression1778 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_ruleStringExpression_in_ruleConcatExpression1799 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression1837 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression1847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_ruleStringExpression1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAccess_in_ruleStringExpression1921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral1956 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral1966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringLiteral2007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAccess_in_entryRulePropertyAccess2047 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAccess2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rulePropertyAccess2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperator_in_entryRuleOrOperator2139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrOperator2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleOrOperator2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleOrOperator2207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleOrOperator2226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorOperator_in_entryRuleXorOperator2267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXorOperator2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleXorOperator2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleXorOperator2335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperator_in_entryRuleAndOperator2376 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOperator2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleAndOperator2425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleAndOperator2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleAndOperator2463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperator_in_entryRuleNotOperator2504 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOperator2515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleNotOperator2553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleNotOperator2572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleComparisonOperator2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleComparisonOperator2639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleComparisonOperator2654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleComparisonOperator2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleComparisonOperator2684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleComparisonOperator2699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleComparisonOperator2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleComparisonOperator2729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleStringOperator2772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleStringOperator2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleStringOperator2802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleStringOperator2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleStringOperator2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleStringOperator2847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleStringOperator2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleStringOperator2877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleStringOperator2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleStringOperator2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleStringOperator2922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleStringOperator2937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleStringOperator2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleStringOperator2967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleStringOperator2982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleType3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleType3040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleType3055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_ruleType3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleKind3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleKind3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleKind3143 = new BitSet(new long[]{0x0000000000000002L});

}