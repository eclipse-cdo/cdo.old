package org.eclipse.net4j.tools.workingset.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.eclipse.net4j.tools.workingset.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_BOOLEAN", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'|'", "'||'", "'or'", "'^'", "'xor'", "'&'", "'&&'", "'and'", "'!'", "'not'", "'='", "'=='", "'!='", "'<>'", "'>'", "'>='", "'<'", "'<='", "'like'", "'~'", "'unlike'", "'!~'", "'starts'", "'ends'", "'contains'", "'file'", "'folder'", "'container'", "'project'", "'reference'", "'nature'", "'builder'", "'('", "')'", "'is'", "'has'", "'.'", "','", "'+'"
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
    public String getGrammarFileName() { return "../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g"; }


     
     	private DslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DslGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleBooleanExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:61:1: entryRuleBooleanExpression : ruleBooleanExpression EOF ;
    public final void entryRuleBooleanExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:62:1: ( ruleBooleanExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:63:1: ruleBooleanExpression EOF
            {
             before(grammarAccess.getBooleanExpressionRule()); 
            pushFollow(FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression61);
            ruleBooleanExpression();
            _fsp--;

             after(grammarAccess.getBooleanExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanExpression68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleBooleanExpression


    // $ANTLR start ruleBooleanExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:70:1: ruleBooleanExpression : ( ruleOrExpression ) ;
    public final void ruleBooleanExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:74:2: ( ( ruleOrExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:75:1: ( ruleOrExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:75:1: ( ruleOrExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:76:1: ruleOrExpression
            {
             before(grammarAccess.getBooleanExpressionAccess().getOrExpressionParserRuleCall()); 
            pushFollow(FOLLOW_ruleOrExpression_in_ruleBooleanExpression94);
            ruleOrExpression();
            _fsp--;

             after(grammarAccess.getBooleanExpressionAccess().getOrExpressionParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanExpression


    // $ANTLR start entryRuleOrExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:89:1: entryRuleOrExpression : ruleOrExpression EOF ;
    public final void entryRuleOrExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:90:1: ( ruleOrExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:91:1: ruleOrExpression EOF
            {
             before(grammarAccess.getOrExpressionRule()); 
            pushFollow(FOLLOW_ruleOrExpression_in_entryRuleOrExpression120);
            ruleOrExpression();
            _fsp--;

             after(grammarAccess.getOrExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrExpression127); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleOrExpression


    // $ANTLR start ruleOrExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:98:1: ruleOrExpression : ( ( rule__OrExpression__Group__0 ) ) ;
    public final void ruleOrExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:102:2: ( ( ( rule__OrExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:103:1: ( ( rule__OrExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:103:1: ( ( rule__OrExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:104:1: ( rule__OrExpression__Group__0 )
            {
             before(grammarAccess.getOrExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:105:1: ( rule__OrExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:105:2: rule__OrExpression__Group__0
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__0_in_ruleOrExpression153);
            rule__OrExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleOrExpression


    // $ANTLR start entryRuleXorExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:117:1: entryRuleXorExpression : ruleXorExpression EOF ;
    public final void entryRuleXorExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:118:1: ( ruleXorExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:119:1: ruleXorExpression EOF
            {
             before(grammarAccess.getXorExpressionRule()); 
            pushFollow(FOLLOW_ruleXorExpression_in_entryRuleXorExpression180);
            ruleXorExpression();
            _fsp--;

             after(grammarAccess.getXorExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXorExpression187); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleXorExpression


    // $ANTLR start ruleXorExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:126:1: ruleXorExpression : ( ( rule__XorExpression__Group__0 ) ) ;
    public final void ruleXorExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:130:2: ( ( ( rule__XorExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:131:1: ( ( rule__XorExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:131:1: ( ( rule__XorExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:132:1: ( rule__XorExpression__Group__0 )
            {
             before(grammarAccess.getXorExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:133:1: ( rule__XorExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:133:2: rule__XorExpression__Group__0
            {
            pushFollow(FOLLOW_rule__XorExpression__Group__0_in_ruleXorExpression213);
            rule__XorExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getXorExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleXorExpression


    // $ANTLR start entryRuleAndExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:145:1: entryRuleAndExpression : ruleAndExpression EOF ;
    public final void entryRuleAndExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:146:1: ( ruleAndExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:147:1: ruleAndExpression EOF
            {
             before(grammarAccess.getAndExpressionRule()); 
            pushFollow(FOLLOW_ruleAndExpression_in_entryRuleAndExpression240);
            ruleAndExpression();
            _fsp--;

             after(grammarAccess.getAndExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndExpression247); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleAndExpression


    // $ANTLR start ruleAndExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:154:1: ruleAndExpression : ( ( rule__AndExpression__Group__0 ) ) ;
    public final void ruleAndExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:158:2: ( ( ( rule__AndExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:159:1: ( ( rule__AndExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:159:1: ( ( rule__AndExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:160:1: ( rule__AndExpression__Group__0 )
            {
             before(grammarAccess.getAndExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:161:1: ( rule__AndExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:161:2: rule__AndExpression__Group__0
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression273);
            rule__AndExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAndExpression


    // $ANTLR start entryRuleComparisonExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:173:1: entryRuleComparisonExpression : ruleComparisonExpression EOF ;
    public final void entryRuleComparisonExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:174:1: ( ruleComparisonExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:175:1: ruleComparisonExpression EOF
            {
             before(grammarAccess.getComparisonExpressionRule()); 
            pushFollow(FOLLOW_ruleComparisonExpression_in_entryRuleComparisonExpression300);
            ruleComparisonExpression();
            _fsp--;

             after(grammarAccess.getComparisonExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleComparisonExpression307); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleComparisonExpression


    // $ANTLR start ruleComparisonExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:182:1: ruleComparisonExpression : ( ( rule__ComparisonExpression__Alternatives ) ) ;
    public final void ruleComparisonExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:186:2: ( ( ( rule__ComparisonExpression__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:187:1: ( ( rule__ComparisonExpression__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:187:1: ( ( rule__ComparisonExpression__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:188:1: ( rule__ComparisonExpression__Alternatives )
            {
             before(grammarAccess.getComparisonExpressionAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:189:1: ( rule__ComparisonExpression__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:189:2: rule__ComparisonExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Alternatives_in_ruleComparisonExpression333);
            rule__ComparisonExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleComparisonExpression


    // $ANTLR start entryRulePrimaryExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:201:1: entryRulePrimaryExpression : rulePrimaryExpression EOF ;
    public final void entryRulePrimaryExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:202:1: ( rulePrimaryExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:203:1: rulePrimaryExpression EOF
            {
             before(grammarAccess.getPrimaryExpressionRule()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression360);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpression367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRulePrimaryExpression


    // $ANTLR start rulePrimaryExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:210:1: rulePrimaryExpression : ( ( rule__PrimaryExpression__Alternatives ) ) ;
    public final void rulePrimaryExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:214:2: ( ( ( rule__PrimaryExpression__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:215:1: ( ( rule__PrimaryExpression__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:215:1: ( ( rule__PrimaryExpression__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:216:1: ( rule__PrimaryExpression__Alternatives )
            {
             before(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:217:1: ( rule__PrimaryExpression__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:217:2: rule__PrimaryExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression393);
            rule__PrimaryExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getPrimaryExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rulePrimaryExpression


    // $ANTLR start entryRuleBooleanLiteral
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:229:1: entryRuleBooleanLiteral : ruleBooleanLiteral EOF ;
    public final void entryRuleBooleanLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:230:1: ( ruleBooleanLiteral EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:231:1: ruleBooleanLiteral EOF
            {
             before(grammarAccess.getBooleanLiteralRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral420);
            ruleBooleanLiteral();
            _fsp--;

             after(grammarAccess.getBooleanLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteral427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleBooleanLiteral


    // $ANTLR start ruleBooleanLiteral
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:238:1: ruleBooleanLiteral : ( ( rule__BooleanLiteral__ValueAssignment ) ) ;
    public final void ruleBooleanLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:242:2: ( ( ( rule__BooleanLiteral__ValueAssignment ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:243:1: ( ( rule__BooleanLiteral__ValueAssignment ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:243:1: ( ( rule__BooleanLiteral__ValueAssignment ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:244:1: ( rule__BooleanLiteral__ValueAssignment )
            {
             before(grammarAccess.getBooleanLiteralAccess().getValueAssignment()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:245:1: ( rule__BooleanLiteral__ValueAssignment )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:245:2: rule__BooleanLiteral__ValueAssignment
            {
            pushFollow(FOLLOW_rule__BooleanLiteral__ValueAssignment_in_ruleBooleanLiteral453);
            rule__BooleanLiteral__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getBooleanLiteralAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleBooleanLiteral


    // $ANTLR start entryRuleNotExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:257:1: entryRuleNotExpression : ruleNotExpression EOF ;
    public final void entryRuleNotExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:258:1: ( ruleNotExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:259:1: ruleNotExpression EOF
            {
             before(grammarAccess.getNotExpressionRule()); 
            pushFollow(FOLLOW_ruleNotExpression_in_entryRuleNotExpression480);
            ruleNotExpression();
            _fsp--;

             after(grammarAccess.getNotExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotExpression487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleNotExpression


    // $ANTLR start ruleNotExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:266:1: ruleNotExpression : ( ( rule__NotExpression__Group__0 ) ) ;
    public final void ruleNotExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:270:2: ( ( ( rule__NotExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:271:1: ( ( rule__NotExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:271:1: ( ( rule__NotExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:272:1: ( rule__NotExpression__Group__0 )
            {
             before(grammarAccess.getNotExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:273:1: ( rule__NotExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:273:2: rule__NotExpression__Group__0
            {
            pushFollow(FOLLOW_rule__NotExpression__Group__0_in_ruleNotExpression513);
            rule__NotExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNotExpression


    // $ANTLR start entryRuleIsExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:285:1: entryRuleIsExpression : ruleIsExpression EOF ;
    public final void entryRuleIsExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:286:1: ( ruleIsExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:287:1: ruleIsExpression EOF
            {
             before(grammarAccess.getIsExpressionRule()); 
            pushFollow(FOLLOW_ruleIsExpression_in_entryRuleIsExpression540);
            ruleIsExpression();
            _fsp--;

             after(grammarAccess.getIsExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsExpression547); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleIsExpression


    // $ANTLR start ruleIsExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:294:1: ruleIsExpression : ( ( rule__IsExpression__Group__0 ) ) ;
    public final void ruleIsExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:298:2: ( ( ( rule__IsExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:299:1: ( ( rule__IsExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:299:1: ( ( rule__IsExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:300:1: ( rule__IsExpression__Group__0 )
            {
             before(grammarAccess.getIsExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:301:1: ( rule__IsExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:301:2: rule__IsExpression__Group__0
            {
            pushFollow(FOLLOW_rule__IsExpression__Group__0_in_ruleIsExpression573);
            rule__IsExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getIsExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleIsExpression


    // $ANTLR start entryRuleHasExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:313:1: entryRuleHasExpression : ruleHasExpression EOF ;
    public final void entryRuleHasExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:314:1: ( ruleHasExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:315:1: ruleHasExpression EOF
            {
             before(grammarAccess.getHasExpressionRule()); 
            pushFollow(FOLLOW_ruleHasExpression_in_entryRuleHasExpression600);
            ruleHasExpression();
            _fsp--;

             after(grammarAccess.getHasExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleHasExpression607); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleHasExpression


    // $ANTLR start ruleHasExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:322:1: ruleHasExpression : ( ( rule__HasExpression__Group__0 ) ) ;
    public final void ruleHasExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:326:2: ( ( ( rule__HasExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:327:1: ( ( rule__HasExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:327:1: ( ( rule__HasExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:328:1: ( rule__HasExpression__Group__0 )
            {
             before(grammarAccess.getHasExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:329:1: ( rule__HasExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:329:2: rule__HasExpression__Group__0
            {
            pushFollow(FOLLOW_rule__HasExpression__Group__0_in_ruleHasExpression633);
            rule__HasExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getHasExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleHasExpression


    // $ANTLR start entryRuleTestExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:341:1: entryRuleTestExpression : ruleTestExpression EOF ;
    public final void entryRuleTestExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:342:1: ( ruleTestExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:343:1: ruleTestExpression EOF
            {
             before(grammarAccess.getTestExpressionRule()); 
            pushFollow(FOLLOW_ruleTestExpression_in_entryRuleTestExpression660);
            ruleTestExpression();
            _fsp--;

             after(grammarAccess.getTestExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestExpression667); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleTestExpression


    // $ANTLR start ruleTestExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:350:1: ruleTestExpression : ( ( rule__TestExpression__Group__0 ) ) ;
    public final void ruleTestExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:354:2: ( ( ( rule__TestExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:355:1: ( ( rule__TestExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:355:1: ( ( rule__TestExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:356:1: ( rule__TestExpression__Group__0 )
            {
             before(grammarAccess.getTestExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:357:1: ( rule__TestExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:357:2: rule__TestExpression__Group__0
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__0_in_ruleTestExpression693);
            rule__TestExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getTestExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleTestExpression


    // $ANTLR start entryRuleConcatExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:369:1: entryRuleConcatExpression : ruleConcatExpression EOF ;
    public final void entryRuleConcatExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:370:1: ( ruleConcatExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:371:1: ruleConcatExpression EOF
            {
             before(grammarAccess.getConcatExpressionRule()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_entryRuleConcatExpression720);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getConcatExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConcatExpression727); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleConcatExpression


    // $ANTLR start ruleConcatExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:378:1: ruleConcatExpression : ( ( rule__ConcatExpression__Group__0 ) ) ;
    public final void ruleConcatExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:382:2: ( ( ( rule__ConcatExpression__Group__0 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:383:1: ( ( rule__ConcatExpression__Group__0 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:383:1: ( ( rule__ConcatExpression__Group__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:384:1: ( rule__ConcatExpression__Group__0 )
            {
             before(grammarAccess.getConcatExpressionAccess().getGroup()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:385:1: ( rule__ConcatExpression__Group__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:385:2: rule__ConcatExpression__Group__0
            {
            pushFollow(FOLLOW_rule__ConcatExpression__Group__0_in_ruleConcatExpression753);
            rule__ConcatExpression__Group__0();
            _fsp--;


            }

             after(grammarAccess.getConcatExpressionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleConcatExpression


    // $ANTLR start entryRuleStringExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:397:1: entryRuleStringExpression : ruleStringExpression EOF ;
    public final void entryRuleStringExpression() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:398:1: ( ruleStringExpression EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:399:1: ruleStringExpression EOF
            {
             before(grammarAccess.getStringExpressionRule()); 
            pushFollow(FOLLOW_ruleStringExpression_in_entryRuleStringExpression780);
            ruleStringExpression();
            _fsp--;

             after(grammarAccess.getStringExpressionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringExpression787); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleStringExpression


    // $ANTLR start ruleStringExpression
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:406:1: ruleStringExpression : ( ( rule__StringExpression__Alternatives ) ) ;
    public final void ruleStringExpression() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:410:2: ( ( ( rule__StringExpression__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:411:1: ( ( rule__StringExpression__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:411:1: ( ( rule__StringExpression__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:412:1: ( rule__StringExpression__Alternatives )
            {
             before(grammarAccess.getStringExpressionAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:413:1: ( rule__StringExpression__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:413:2: rule__StringExpression__Alternatives
            {
            pushFollow(FOLLOW_rule__StringExpression__Alternatives_in_ruleStringExpression813);
            rule__StringExpression__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStringExpressionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringExpression


    // $ANTLR start entryRuleStringLiteral
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:425:1: entryRuleStringLiteral : ruleStringLiteral EOF ;
    public final void entryRuleStringLiteral() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:426:1: ( ruleStringLiteral EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:427:1: ruleStringLiteral EOF
            {
             before(grammarAccess.getStringLiteralRule()); 
            pushFollow(FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral840);
            ruleStringLiteral();
            _fsp--;

             after(grammarAccess.getStringLiteralRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteral847); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleStringLiteral


    // $ANTLR start ruleStringLiteral
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:434:1: ruleStringLiteral : ( ( rule__StringLiteral__ValueAssignment ) ) ;
    public final void ruleStringLiteral() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:438:2: ( ( ( rule__StringLiteral__ValueAssignment ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:439:1: ( ( rule__StringLiteral__ValueAssignment ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:439:1: ( ( rule__StringLiteral__ValueAssignment ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:440:1: ( rule__StringLiteral__ValueAssignment )
            {
             before(grammarAccess.getStringLiteralAccess().getValueAssignment()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:441:1: ( rule__StringLiteral__ValueAssignment )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:441:2: rule__StringLiteral__ValueAssignment
            {
            pushFollow(FOLLOW_rule__StringLiteral__ValueAssignment_in_ruleStringLiteral873);
            rule__StringLiteral__ValueAssignment();
            _fsp--;


            }

             after(grammarAccess.getStringLiteralAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringLiteral


    // $ANTLR start entryRulePropertyAccess
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:453:1: entryRulePropertyAccess : rulePropertyAccess EOF ;
    public final void entryRulePropertyAccess() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:454:1: ( rulePropertyAccess EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:455:1: rulePropertyAccess EOF
            {
             before(grammarAccess.getPropertyAccessRule()); 
            pushFollow(FOLLOW_rulePropertyAccess_in_entryRulePropertyAccess900);
            rulePropertyAccess();
            _fsp--;

             after(grammarAccess.getPropertyAccessRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePropertyAccess907); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRulePropertyAccess


    // $ANTLR start rulePropertyAccess
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:462:1: rulePropertyAccess : ( ( rule__PropertyAccess__PropertyAssignment ) ) ;
    public final void rulePropertyAccess() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:466:2: ( ( ( rule__PropertyAccess__PropertyAssignment ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:467:1: ( ( rule__PropertyAccess__PropertyAssignment ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:467:1: ( ( rule__PropertyAccess__PropertyAssignment ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:468:1: ( rule__PropertyAccess__PropertyAssignment )
            {
             before(grammarAccess.getPropertyAccessAccess().getPropertyAssignment()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:469:1: ( rule__PropertyAccess__PropertyAssignment )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:469:2: rule__PropertyAccess__PropertyAssignment
            {
            pushFollow(FOLLOW_rule__PropertyAccess__PropertyAssignment_in_rulePropertyAccess933);
            rule__PropertyAccess__PropertyAssignment();
            _fsp--;


            }

             after(grammarAccess.getPropertyAccessAccess().getPropertyAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rulePropertyAccess


    // $ANTLR start entryRuleOrOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:481:1: entryRuleOrOperator : ruleOrOperator EOF ;
    public final void entryRuleOrOperator() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:482:1: ( ruleOrOperator EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:483:1: ruleOrOperator EOF
            {
             before(grammarAccess.getOrOperatorRule()); 
            pushFollow(FOLLOW_ruleOrOperator_in_entryRuleOrOperator960);
            ruleOrOperator();
            _fsp--;

             after(grammarAccess.getOrOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOrOperator967); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleOrOperator


    // $ANTLR start ruleOrOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:490:1: ruleOrOperator : ( ( rule__OrOperator__Alternatives ) ) ;
    public final void ruleOrOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:494:2: ( ( ( rule__OrOperator__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:495:1: ( ( rule__OrOperator__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:495:1: ( ( rule__OrOperator__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:496:1: ( rule__OrOperator__Alternatives )
            {
             before(grammarAccess.getOrOperatorAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:497:1: ( rule__OrOperator__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:497:2: rule__OrOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__OrOperator__Alternatives_in_ruleOrOperator993);
            rule__OrOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getOrOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleOrOperator


    // $ANTLR start entryRuleXorOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:509:1: entryRuleXorOperator : ruleXorOperator EOF ;
    public final void entryRuleXorOperator() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:510:1: ( ruleXorOperator EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:511:1: ruleXorOperator EOF
            {
             before(grammarAccess.getXorOperatorRule()); 
            pushFollow(FOLLOW_ruleXorOperator_in_entryRuleXorOperator1020);
            ruleXorOperator();
            _fsp--;

             after(grammarAccess.getXorOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleXorOperator1027); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleXorOperator


    // $ANTLR start ruleXorOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:518:1: ruleXorOperator : ( ( rule__XorOperator__Alternatives ) ) ;
    public final void ruleXorOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:522:2: ( ( ( rule__XorOperator__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:523:1: ( ( rule__XorOperator__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:523:1: ( ( rule__XorOperator__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:524:1: ( rule__XorOperator__Alternatives )
            {
             before(grammarAccess.getXorOperatorAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:525:1: ( rule__XorOperator__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:525:2: rule__XorOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__XorOperator__Alternatives_in_ruleXorOperator1053);
            rule__XorOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getXorOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleXorOperator


    // $ANTLR start entryRuleAndOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:537:1: entryRuleAndOperator : ruleAndOperator EOF ;
    public final void entryRuleAndOperator() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:538:1: ( ruleAndOperator EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:539:1: ruleAndOperator EOF
            {
             before(grammarAccess.getAndOperatorRule()); 
            pushFollow(FOLLOW_ruleAndOperator_in_entryRuleAndOperator1080);
            ruleAndOperator();
            _fsp--;

             after(grammarAccess.getAndOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAndOperator1087); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleAndOperator


    // $ANTLR start ruleAndOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:546:1: ruleAndOperator : ( ( rule__AndOperator__Alternatives ) ) ;
    public final void ruleAndOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:550:2: ( ( ( rule__AndOperator__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:551:1: ( ( rule__AndOperator__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:551:1: ( ( rule__AndOperator__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:552:1: ( rule__AndOperator__Alternatives )
            {
             before(grammarAccess.getAndOperatorAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:553:1: ( rule__AndOperator__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:553:2: rule__AndOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__AndOperator__Alternatives_in_ruleAndOperator1113);
            rule__AndOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getAndOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleAndOperator


    // $ANTLR start entryRuleNotOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:565:1: entryRuleNotOperator : ruleNotOperator EOF ;
    public final void entryRuleNotOperator() throws RecognitionException {
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:566:1: ( ruleNotOperator EOF )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:567:1: ruleNotOperator EOF
            {
             before(grammarAccess.getNotOperatorRule()); 
            pushFollow(FOLLOW_ruleNotOperator_in_entryRuleNotOperator1140);
            ruleNotOperator();
            _fsp--;

             after(grammarAccess.getNotOperatorRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNotOperator1147); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleNotOperator


    // $ANTLR start ruleNotOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:574:1: ruleNotOperator : ( ( rule__NotOperator__Alternatives ) ) ;
    public final void ruleNotOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:578:2: ( ( ( rule__NotOperator__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:579:1: ( ( rule__NotOperator__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:579:1: ( ( rule__NotOperator__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:580:1: ( rule__NotOperator__Alternatives )
            {
             before(grammarAccess.getNotOperatorAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:581:1: ( rule__NotOperator__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:581:2: rule__NotOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__NotOperator__Alternatives_in_ruleNotOperator1173);
            rule__NotOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getNotOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleNotOperator


    // $ANTLR start ruleComparisonOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:594:1: ruleComparisonOperator : ( ( rule__ComparisonOperator__Alternatives ) ) ;
    public final void ruleComparisonOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:598:1: ( ( ( rule__ComparisonOperator__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:599:1: ( ( rule__ComparisonOperator__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:599:1: ( ( rule__ComparisonOperator__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:600:1: ( rule__ComparisonOperator__Alternatives )
            {
             before(grammarAccess.getComparisonOperatorAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:601:1: ( rule__ComparisonOperator__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:601:2: rule__ComparisonOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__ComparisonOperator__Alternatives_in_ruleComparisonOperator1210);
            rule__ComparisonOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getComparisonOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleComparisonOperator


    // $ANTLR start ruleStringOperator
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:613:1: ruleStringOperator : ( ( rule__StringOperator__Alternatives ) ) ;
    public final void ruleStringOperator() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:617:1: ( ( ( rule__StringOperator__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:618:1: ( ( rule__StringOperator__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:618:1: ( ( rule__StringOperator__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:619:1: ( rule__StringOperator__Alternatives )
            {
             before(grammarAccess.getStringOperatorAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:620:1: ( rule__StringOperator__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:620:2: rule__StringOperator__Alternatives
            {
            pushFollow(FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1246);
            rule__StringOperator__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getStringOperatorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleStringOperator


    // $ANTLR start ruleType
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:632:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:636:1: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:637:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:637:1: ( ( rule__Type__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:638:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:639:1: ( rule__Type__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:639:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType1282);
            rule__Type__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleType


    // $ANTLR start ruleKind
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:651:1: ruleKind : ( ( rule__Kind__Alternatives ) ) ;
    public final void ruleKind() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:655:1: ( ( ( rule__Kind__Alternatives ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:656:1: ( ( rule__Kind__Alternatives ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:656:1: ( ( rule__Kind__Alternatives ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:657:1: ( rule__Kind__Alternatives )
            {
             before(grammarAccess.getKindAccess().getAlternatives()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:658:1: ( rule__Kind__Alternatives )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:658:2: rule__Kind__Alternatives
            {
            pushFollow(FOLLOW_rule__Kind__Alternatives_in_ruleKind1318);
            rule__Kind__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getKindAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleKind


    // $ANTLR start rule__ComparisonExpression__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:669:1: rule__ComparisonExpression__Alternatives : ( ( ( rule__ComparisonExpression__Group_0__0 ) ) | ( ( rule__ComparisonExpression__Group_1__0 ) ) );
    public final void rule__ComparisonExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:673:1: ( ( ( rule__ComparisonExpression__Group_0__0 ) ) | ( ( rule__ComparisonExpression__Group_1__0 ) ) )
            int alt1=2;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
            case 20:
            case 21:
            case 44:
            case 46:
            case 47:
                {
                alt1=1;
                }
                break;
            case RULE_ID:
                {
                int LA1_2 = input.LA(2);

                if ( ((LA1_2>=22 && LA1_2<=36)||LA1_2==50) ) {
                    alt1=2;
                }
                else if ( (LA1_2==44||LA1_2==48) ) {
                    alt1=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("669:1: rule__ComparisonExpression__Alternatives : ( ( ( rule__ComparisonExpression__Group_0__0 ) ) | ( ( rule__ComparisonExpression__Group_1__0 ) ) );", 1, 2, input);

                    throw nvae;
                }
                }
                break;
            case RULE_STRING:
                {
                alt1=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("669:1: rule__ComparisonExpression__Alternatives : ( ( ( rule__ComparisonExpression__Group_0__0 ) ) | ( ( rule__ComparisonExpression__Group_1__0 ) ) );", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:674:1: ( ( rule__ComparisonExpression__Group_0__0 ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:674:1: ( ( rule__ComparisonExpression__Group_0__0 ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:675:1: ( rule__ComparisonExpression__Group_0__0 )
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getGroup_0()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:676:1: ( rule__ComparisonExpression__Group_0__0 )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:676:2: rule__ComparisonExpression__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__ComparisonExpression__Group_0__0_in_rule__ComparisonExpression__Alternatives1353);
                    rule__ComparisonExpression__Group_0__0();
                    _fsp--;


                    }

                     after(grammarAccess.getComparisonExpressionAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:680:6: ( ( rule__ComparisonExpression__Group_1__0 ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:680:6: ( ( rule__ComparisonExpression__Group_1__0 ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:681:1: ( rule__ComparisonExpression__Group_1__0 )
                    {
                     before(grammarAccess.getComparisonExpressionAccess().getGroup_1()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:682:1: ( rule__ComparisonExpression__Group_1__0 )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:682:2: rule__ComparisonExpression__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__ComparisonExpression__Group_1__0_in_rule__ComparisonExpression__Alternatives1371);
                    rule__ComparisonExpression__Group_1__0();
                    _fsp--;


                    }

                     after(grammarAccess.getComparisonExpressionAccess().getGroup_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Alternatives


    // $ANTLR start rule__PrimaryExpression__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:691:1: rule__PrimaryExpression__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNotExpression ) | ( ruleIsExpression ) | ( ruleHasExpression ) | ( ruleTestExpression ) | ( ( rule__PrimaryExpression__Group_5__0 ) ) );
    public final void rule__PrimaryExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:695:1: ( ( ruleBooleanLiteral ) | ( ruleNotExpression ) | ( ruleIsExpression ) | ( ruleHasExpression ) | ( ruleTestExpression ) | ( ( rule__PrimaryExpression__Group_5__0 ) ) )
            int alt2=6;
            switch ( input.LA(1) ) {
            case RULE_BOOLEAN:
                {
                alt2=1;
                }
                break;
            case 20:
            case 21:
                {
                alt2=2;
                }
                break;
            case 46:
                {
                alt2=3;
                }
                break;
            case 47:
                {
                alt2=4;
                }
                break;
            case RULE_ID:
                {
                alt2=5;
                }
                break;
            case 44:
                {
                alt2=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("691:1: rule__PrimaryExpression__Alternatives : ( ( ruleBooleanLiteral ) | ( ruleNotExpression ) | ( ruleIsExpression ) | ( ruleHasExpression ) | ( ruleTestExpression ) | ( ( rule__PrimaryExpression__Group_5__0 ) ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:696:1: ( ruleBooleanLiteral )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:696:1: ( ruleBooleanLiteral )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:697:1: ruleBooleanLiteral
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleBooleanLiteral_in_rule__PrimaryExpression__Alternatives1404);
                    ruleBooleanLiteral();
                    _fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getBooleanLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:702:6: ( ruleNotExpression )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:702:6: ( ruleNotExpression )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:703:1: ruleNotExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getNotExpressionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleNotExpression_in_rule__PrimaryExpression__Alternatives1421);
                    ruleNotExpression();
                    _fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getNotExpressionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:708:6: ( ruleIsExpression )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:708:6: ( ruleIsExpression )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:709:1: ruleIsExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getIsExpressionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleIsExpression_in_rule__PrimaryExpression__Alternatives1438);
                    ruleIsExpression();
                    _fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getIsExpressionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:714:6: ( ruleHasExpression )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:714:6: ( ruleHasExpression )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:715:1: ruleHasExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getHasExpressionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleHasExpression_in_rule__PrimaryExpression__Alternatives1455);
                    ruleHasExpression();
                    _fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getHasExpressionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:720:6: ( ruleTestExpression )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:720:6: ( ruleTestExpression )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:721:1: ruleTestExpression
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getTestExpressionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleTestExpression_in_rule__PrimaryExpression__Alternatives1472);
                    ruleTestExpression();
                    _fsp--;

                     after(grammarAccess.getPrimaryExpressionAccess().getTestExpressionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:726:6: ( ( rule__PrimaryExpression__Group_5__0 ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:726:6: ( ( rule__PrimaryExpression__Group_5__0 ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:727:1: ( rule__PrimaryExpression__Group_5__0 )
                    {
                     before(grammarAccess.getPrimaryExpressionAccess().getGroup_5()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:728:1: ( rule__PrimaryExpression__Group_5__0 )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:728:2: rule__PrimaryExpression__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__PrimaryExpression__Group_5__0_in_rule__PrimaryExpression__Alternatives1489);
                    rule__PrimaryExpression__Group_5__0();
                    _fsp--;


                    }

                     after(grammarAccess.getPrimaryExpressionAccess().getGroup_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Alternatives


    // $ANTLR start rule__StringExpression__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:737:1: rule__StringExpression__Alternatives : ( ( ruleStringLiteral ) | ( rulePropertyAccess ) );
    public final void rule__StringExpression__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:741:1: ( ( ruleStringLiteral ) | ( rulePropertyAccess ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_STRING) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ID) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("737:1: rule__StringExpression__Alternatives : ( ( ruleStringLiteral ) | ( rulePropertyAccess ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:742:1: ( ruleStringLiteral )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:742:1: ( ruleStringLiteral )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:743:1: ruleStringLiteral
                    {
                     before(grammarAccess.getStringExpressionAccess().getStringLiteralParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringLiteral_in_rule__StringExpression__Alternatives1522);
                    ruleStringLiteral();
                    _fsp--;

                     after(grammarAccess.getStringExpressionAccess().getStringLiteralParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:748:6: ( rulePropertyAccess )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:748:6: ( rulePropertyAccess )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:749:1: rulePropertyAccess
                    {
                     before(grammarAccess.getStringExpressionAccess().getPropertyAccessParserRuleCall_1()); 
                    pushFollow(FOLLOW_rulePropertyAccess_in_rule__StringExpression__Alternatives1539);
                    rulePropertyAccess();
                    _fsp--;

                     after(grammarAccess.getStringExpressionAccess().getPropertyAccessParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringExpression__Alternatives


    // $ANTLR start rule__OrOperator__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:759:1: rule__OrOperator__Alternatives : ( ( '|' ) | ( '||' ) | ( 'or' ) );
    public final void rule__OrOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:763:1: ( ( '|' ) | ( '||' ) | ( 'or' ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 12:
                {
                alt4=1;
                }
                break;
            case 13:
                {
                alt4=2;
                }
                break;
            case 14:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("759:1: rule__OrOperator__Alternatives : ( ( '|' ) | ( '||' ) | ( 'or' ) );", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:764:1: ( '|' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:764:1: ( '|' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:765:1: '|'
                    {
                     before(grammarAccess.getOrOperatorAccess().getVerticalLineKeyword_0()); 
                    match(input,12,FOLLOW_12_in_rule__OrOperator__Alternatives1572); 
                     after(grammarAccess.getOrOperatorAccess().getVerticalLineKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:772:6: ( '||' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:772:6: ( '||' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:773:1: '||'
                    {
                     before(grammarAccess.getOrOperatorAccess().getVerticalLineVerticalLineKeyword_1()); 
                    match(input,13,FOLLOW_13_in_rule__OrOperator__Alternatives1592); 
                     after(grammarAccess.getOrOperatorAccess().getVerticalLineVerticalLineKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:780:6: ( 'or' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:780:6: ( 'or' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:781:1: 'or'
                    {
                     before(grammarAccess.getOrOperatorAccess().getOrKeyword_2()); 
                    match(input,14,FOLLOW_14_in_rule__OrOperator__Alternatives1612); 
                     after(grammarAccess.getOrOperatorAccess().getOrKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrOperator__Alternatives


    // $ANTLR start rule__XorOperator__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:793:1: rule__XorOperator__Alternatives : ( ( '^' ) | ( 'xor' ) );
    public final void rule__XorOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:797:1: ( ( '^' ) | ( 'xor' ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            else if ( (LA5_0==16) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("793:1: rule__XorOperator__Alternatives : ( ( '^' ) | ( 'xor' ) );", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:798:1: ( '^' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:798:1: ( '^' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:799:1: '^'
                    {
                     before(grammarAccess.getXorOperatorAccess().getCircumflexAccentKeyword_0()); 
                    match(input,15,FOLLOW_15_in_rule__XorOperator__Alternatives1647); 
                     after(grammarAccess.getXorOperatorAccess().getCircumflexAccentKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:806:6: ( 'xor' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:806:6: ( 'xor' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:807:1: 'xor'
                    {
                     before(grammarAccess.getXorOperatorAccess().getXorKeyword_1()); 
                    match(input,16,FOLLOW_16_in_rule__XorOperator__Alternatives1667); 
                     after(grammarAccess.getXorOperatorAccess().getXorKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorOperator__Alternatives


    // $ANTLR start rule__AndOperator__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:819:1: rule__AndOperator__Alternatives : ( ( '&' ) | ( '&&' ) | ( 'and' ) );
    public final void rule__AndOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:823:1: ( ( '&' ) | ( '&&' ) | ( 'and' ) )
            int alt6=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt6=1;
                }
                break;
            case 18:
                {
                alt6=2;
                }
                break;
            case 19:
                {
                alt6=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("819:1: rule__AndOperator__Alternatives : ( ( '&' ) | ( '&&' ) | ( 'and' ) );", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:824:1: ( '&' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:824:1: ( '&' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:825:1: '&'
                    {
                     before(grammarAccess.getAndOperatorAccess().getAmpersandKeyword_0()); 
                    match(input,17,FOLLOW_17_in_rule__AndOperator__Alternatives1702); 
                     after(grammarAccess.getAndOperatorAccess().getAmpersandKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:832:6: ( '&&' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:832:6: ( '&&' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:833:1: '&&'
                    {
                     before(grammarAccess.getAndOperatorAccess().getAmpersandAmpersandKeyword_1()); 
                    match(input,18,FOLLOW_18_in_rule__AndOperator__Alternatives1722); 
                     after(grammarAccess.getAndOperatorAccess().getAmpersandAmpersandKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:840:6: ( 'and' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:840:6: ( 'and' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:841:1: 'and'
                    {
                     before(grammarAccess.getAndOperatorAccess().getAndKeyword_2()); 
                    match(input,19,FOLLOW_19_in_rule__AndOperator__Alternatives1742); 
                     after(grammarAccess.getAndOperatorAccess().getAndKeyword_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndOperator__Alternatives


    // $ANTLR start rule__NotOperator__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:853:1: rule__NotOperator__Alternatives : ( ( '!' ) | ( 'not' ) );
    public final void rule__NotOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:857:1: ( ( '!' ) | ( 'not' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==20) ) {
                alt7=1;
            }
            else if ( (LA7_0==21) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("853:1: rule__NotOperator__Alternatives : ( ( '!' ) | ( 'not' ) );", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:858:1: ( '!' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:858:1: ( '!' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:859:1: '!'
                    {
                     before(grammarAccess.getNotOperatorAccess().getExclamationMarkKeyword_0()); 
                    match(input,20,FOLLOW_20_in_rule__NotOperator__Alternatives1777); 
                     after(grammarAccess.getNotOperatorAccess().getExclamationMarkKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:866:6: ( 'not' )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:866:6: ( 'not' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:867:1: 'not'
                    {
                     before(grammarAccess.getNotOperatorAccess().getNotKeyword_1()); 
                    match(input,21,FOLLOW_21_in_rule__NotOperator__Alternatives1797); 
                     after(grammarAccess.getNotOperatorAccess().getNotKeyword_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotOperator__Alternatives


    // $ANTLR start rule__ComparisonOperator__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:879:1: rule__ComparisonOperator__Alternatives : ( ( ( '=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<>' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );
    public final void rule__ComparisonOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:883:1: ( ( ( '=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<>' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) )
            int alt8=8;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt8=1;
                }
                break;
            case 23:
                {
                alt8=2;
                }
                break;
            case 24:
                {
                alt8=3;
                }
                break;
            case 25:
                {
                alt8=4;
                }
                break;
            case 26:
                {
                alt8=5;
                }
                break;
            case 27:
                {
                alt8=6;
                }
                break;
            case 28:
                {
                alt8=7;
                }
                break;
            case 29:
                {
                alt8=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("879:1: rule__ComparisonOperator__Alternatives : ( ( ( '=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<>' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) );", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:884:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:884:1: ( ( '=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:885:1: ( '=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:886:1: ( '=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:886:3: '='
                    {
                    match(input,22,FOLLOW_22_in_rule__ComparisonOperator__Alternatives1832); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getEQEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:891:6: ( ( '==' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:891:6: ( ( '==' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:892:1: ( '==' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getEQ2EnumLiteralDeclaration_1()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:893:1: ( '==' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:893:3: '=='
                    {
                    match(input,23,FOLLOW_23_in_rule__ComparisonOperator__Alternatives1853); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getEQ2EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:898:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:898:6: ( ( '!=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:899:1: ( '!=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getNEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:900:1: ( '!=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:900:3: '!='
                    {
                    match(input,24,FOLLOW_24_in_rule__ComparisonOperator__Alternatives1874); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getNEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:905:6: ( ( '<>' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:905:6: ( ( '<>' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:906:1: ( '<>' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getNE2EnumLiteralDeclaration_3()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:907:1: ( '<>' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:907:3: '<>'
                    {
                    match(input,25,FOLLOW_25_in_rule__ComparisonOperator__Alternatives1895); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getNE2EnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:912:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:912:6: ( ( '>' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:913:1: ( '>' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:914:1: ( '>' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:914:3: '>'
                    {
                    match(input,26,FOLLOW_26_in_rule__ComparisonOperator__Alternatives1916); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getGTEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:919:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:919:6: ( ( '>=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:920:1: ( '>=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:921:1: ( '>=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:921:3: '>='
                    {
                    match(input,27,FOLLOW_27_in_rule__ComparisonOperator__Alternatives1937); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getGEEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:926:6: ( ( '<' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:926:6: ( ( '<' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:927:1: ( '<' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_6()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:928:1: ( '<' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:928:3: '<'
                    {
                    match(input,28,FOLLOW_28_in_rule__ComparisonOperator__Alternatives1958); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getLTEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:933:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:933:6: ( ( '<=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:934:1: ( '<=' )
                    {
                     before(grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_7()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:935:1: ( '<=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:935:3: '<='
                    {
                    match(input,29,FOLLOW_29_in_rule__ComparisonOperator__Alternatives1979); 

                    }

                     after(grammarAccess.getComparisonOperatorAccess().getLEEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonOperator__Alternatives


    // $ANTLR start rule__StringOperator__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:945:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<>' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) | ( ( 'like' ) ) | ( ( '~' ) ) | ( ( 'unlike' ) ) | ( ( '!~' ) ) | ( ( 'starts' ) ) | ( ( 'ends' ) ) | ( ( 'contains' ) ) );
    public final void rule__StringOperator__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:949:1: ( ( ( '=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<>' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) | ( ( 'like' ) ) | ( ( '~' ) ) | ( ( 'unlike' ) ) | ( ( '!~' ) ) | ( ( 'starts' ) ) | ( ( 'ends' ) ) | ( ( 'contains' ) ) )
            int alt9=15;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt9=1;
                }
                break;
            case 23:
                {
                alt9=2;
                }
                break;
            case 24:
                {
                alt9=3;
                }
                break;
            case 25:
                {
                alt9=4;
                }
                break;
            case 26:
                {
                alt9=5;
                }
                break;
            case 27:
                {
                alt9=6;
                }
                break;
            case 28:
                {
                alt9=7;
                }
                break;
            case 29:
                {
                alt9=8;
                }
                break;
            case 30:
                {
                alt9=9;
                }
                break;
            case 31:
                {
                alt9=10;
                }
                break;
            case 32:
                {
                alt9=11;
                }
                break;
            case 33:
                {
                alt9=12;
                }
                break;
            case 34:
                {
                alt9=13;
                }
                break;
            case 35:
                {
                alt9=14;
                }
                break;
            case 36:
                {
                alt9=15;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("945:1: rule__StringOperator__Alternatives : ( ( ( '=' ) ) | ( ( '==' ) ) | ( ( '!=' ) ) | ( ( '<>' ) ) | ( ( '>' ) ) | ( ( '>=' ) ) | ( ( '<' ) ) | ( ( '<=' ) ) | ( ( 'like' ) ) | ( ( '~' ) ) | ( ( 'unlike' ) ) | ( ( '!~' ) ) | ( ( 'starts' ) ) | ( ( 'ends' ) ) | ( ( 'contains' ) ) );", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:950:1: ( ( '=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:950:1: ( ( '=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:951:1: ( '=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getEQEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:952:1: ( '=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:952:3: '='
                    {
                    match(input,22,FOLLOW_22_in_rule__StringOperator__Alternatives2015); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getEQEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:957:6: ( ( '==' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:957:6: ( ( '==' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:958:1: ( '==' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getEQ2EnumLiteralDeclaration_1()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:959:1: ( '==' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:959:3: '=='
                    {
                    match(input,23,FOLLOW_23_in_rule__StringOperator__Alternatives2036); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getEQ2EnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:964:6: ( ( '!=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:964:6: ( ( '!=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:965:1: ( '!=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNEEnumLiteralDeclaration_2()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:966:1: ( '!=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:966:3: '!='
                    {
                    match(input,24,FOLLOW_24_in_rule__StringOperator__Alternatives2057); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNEEnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:971:6: ( ( '<>' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:971:6: ( ( '<>' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:972:1: ( '<>' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getNE2EnumLiteralDeclaration_3()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:973:1: ( '<>' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:973:3: '<>'
                    {
                    match(input,25,FOLLOW_25_in_rule__StringOperator__Alternatives2078); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getNE2EnumLiteralDeclaration_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:978:6: ( ( '>' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:978:6: ( ( '>' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:979:1: ( '>' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getGTEnumLiteralDeclaration_4()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:980:1: ( '>' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:980:3: '>'
                    {
                    match(input,26,FOLLOW_26_in_rule__StringOperator__Alternatives2099); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getGTEnumLiteralDeclaration_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:985:6: ( ( '>=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:985:6: ( ( '>=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:986:1: ( '>=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getGEEnumLiteralDeclaration_5()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:987:1: ( '>=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:987:3: '>='
                    {
                    match(input,27,FOLLOW_27_in_rule__StringOperator__Alternatives2120); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getGEEnumLiteralDeclaration_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:992:6: ( ( '<' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:992:6: ( ( '<' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:993:1: ( '<' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLTEnumLiteralDeclaration_6()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:994:1: ( '<' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:994:3: '<'
                    {
                    match(input,28,FOLLOW_28_in_rule__StringOperator__Alternatives2141); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLTEnumLiteralDeclaration_6()); 

                    }


                    }
                    break;
                case 8 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:999:6: ( ( '<=' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:999:6: ( ( '<=' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1000:1: ( '<=' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLEEnumLiteralDeclaration_7()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1001:1: ( '<=' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1001:3: '<='
                    {
                    match(input,29,FOLLOW_29_in_rule__StringOperator__Alternatives2162); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLEEnumLiteralDeclaration_7()); 

                    }


                    }
                    break;
                case 9 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1006:6: ( ( 'like' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1006:6: ( ( 'like' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1007:1: ( 'like' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLIKEEnumLiteralDeclaration_8()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1008:1: ( 'like' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1008:3: 'like'
                    {
                    match(input,30,FOLLOW_30_in_rule__StringOperator__Alternatives2183); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLIKEEnumLiteralDeclaration_8()); 

                    }


                    }
                    break;
                case 10 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1013:6: ( ( '~' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1013:6: ( ( '~' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1014:1: ( '~' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getLIKE2EnumLiteralDeclaration_9()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1015:1: ( '~' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1015:3: '~'
                    {
                    match(input,31,FOLLOW_31_in_rule__StringOperator__Alternatives2204); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getLIKE2EnumLiteralDeclaration_9()); 

                    }


                    }
                    break;
                case 11 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1020:6: ( ( 'unlike' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1020:6: ( ( 'unlike' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1021:1: ( 'unlike' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getUNLIKEEnumLiteralDeclaration_10()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1022:1: ( 'unlike' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1022:3: 'unlike'
                    {
                    match(input,32,FOLLOW_32_in_rule__StringOperator__Alternatives2225); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getUNLIKEEnumLiteralDeclaration_10()); 

                    }


                    }
                    break;
                case 12 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1027:6: ( ( '!~' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1027:6: ( ( '!~' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1028:1: ( '!~' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getUNLIKE2EnumLiteralDeclaration_11()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1029:1: ( '!~' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1029:3: '!~'
                    {
                    match(input,33,FOLLOW_33_in_rule__StringOperator__Alternatives2246); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getUNLIKE2EnumLiteralDeclaration_11()); 

                    }


                    }
                    break;
                case 13 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1034:6: ( ( 'starts' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1034:6: ( ( 'starts' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1035:1: ( 'starts' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getSTARTSEnumLiteralDeclaration_12()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1036:1: ( 'starts' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1036:3: 'starts'
                    {
                    match(input,34,FOLLOW_34_in_rule__StringOperator__Alternatives2267); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getSTARTSEnumLiteralDeclaration_12()); 

                    }


                    }
                    break;
                case 14 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1041:6: ( ( 'ends' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1041:6: ( ( 'ends' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1042:1: ( 'ends' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getENDSEnumLiteralDeclaration_13()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1043:1: ( 'ends' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1043:3: 'ends'
                    {
                    match(input,35,FOLLOW_35_in_rule__StringOperator__Alternatives2288); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getENDSEnumLiteralDeclaration_13()); 

                    }


                    }
                    break;
                case 15 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1048:6: ( ( 'contains' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1048:6: ( ( 'contains' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1049:1: ( 'contains' )
                    {
                     before(grammarAccess.getStringOperatorAccess().getCONTAINSEnumLiteralDeclaration_14()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1050:1: ( 'contains' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1050:3: 'contains'
                    {
                    match(input,36,FOLLOW_36_in_rule__StringOperator__Alternatives2309); 

                    }

                     after(grammarAccess.getStringOperatorAccess().getCONTAINSEnumLiteralDeclaration_14()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringOperator__Alternatives


    // $ANTLR start rule__Type__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1060:1: rule__Type__Alternatives : ( ( ( 'file' ) ) | ( ( 'folder' ) ) | ( ( 'container' ) ) | ( ( 'project' ) ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1064:1: ( ( ( 'file' ) ) | ( ( 'folder' ) ) | ( ( 'container' ) ) | ( ( 'project' ) ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt10=1;
                }
                break;
            case 38:
                {
                alt10=2;
                }
                break;
            case 39:
                {
                alt10=3;
                }
                break;
            case 40:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1060:1: rule__Type__Alternatives : ( ( ( 'file' ) ) | ( ( 'folder' ) ) | ( ( 'container' ) ) | ( ( 'project' ) ) );", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1065:1: ( ( 'file' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1065:1: ( ( 'file' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1066:1: ( 'file' )
                    {
                     before(grammarAccess.getTypeAccess().getFILEEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1067:1: ( 'file' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1067:3: 'file'
                    {
                    match(input,37,FOLLOW_37_in_rule__Type__Alternatives2345); 

                    }

                     after(grammarAccess.getTypeAccess().getFILEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1072:6: ( ( 'folder' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1072:6: ( ( 'folder' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1073:1: ( 'folder' )
                    {
                     before(grammarAccess.getTypeAccess().getFOLDEREnumLiteralDeclaration_1()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1074:1: ( 'folder' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1074:3: 'folder'
                    {
                    match(input,38,FOLLOW_38_in_rule__Type__Alternatives2366); 

                    }

                     after(grammarAccess.getTypeAccess().getFOLDEREnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1079:6: ( ( 'container' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1079:6: ( ( 'container' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1080:1: ( 'container' )
                    {
                     before(grammarAccess.getTypeAccess().getCONTAINEREnumLiteralDeclaration_2()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1081:1: ( 'container' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1081:3: 'container'
                    {
                    match(input,39,FOLLOW_39_in_rule__Type__Alternatives2387); 

                    }

                     after(grammarAccess.getTypeAccess().getCONTAINEREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1086:6: ( ( 'project' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1086:6: ( ( 'project' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1087:1: ( 'project' )
                    {
                     before(grammarAccess.getTypeAccess().getPROJECTEnumLiteralDeclaration_3()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1088:1: ( 'project' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1088:3: 'project'
                    {
                    match(input,40,FOLLOW_40_in_rule__Type__Alternatives2408); 

                    }

                     after(grammarAccess.getTypeAccess().getPROJECTEnumLiteralDeclaration_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Type__Alternatives


    // $ANTLR start rule__Kind__Alternatives
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1098:1: rule__Kind__Alternatives : ( ( ( 'reference' ) ) | ( ( 'nature' ) ) | ( ( 'builder' ) ) );
    public final void rule__Kind__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1102:1: ( ( ( 'reference' ) ) | ( ( 'nature' ) ) | ( ( 'builder' ) ) )
            int alt11=3;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt11=1;
                }
                break;
            case 42:
                {
                alt11=2;
                }
                break;
            case 43:
                {
                alt11=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("1098:1: rule__Kind__Alternatives : ( ( ( 'reference' ) ) | ( ( 'nature' ) ) | ( ( 'builder' ) ) );", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1103:1: ( ( 'reference' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1103:1: ( ( 'reference' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1104:1: ( 'reference' )
                    {
                     before(grammarAccess.getKindAccess().getREFERENCEEnumLiteralDeclaration_0()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1105:1: ( 'reference' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1105:3: 'reference'
                    {
                    match(input,41,FOLLOW_41_in_rule__Kind__Alternatives2444); 

                    }

                     after(grammarAccess.getKindAccess().getREFERENCEEnumLiteralDeclaration_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1110:6: ( ( 'nature' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1110:6: ( ( 'nature' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1111:1: ( 'nature' )
                    {
                     before(grammarAccess.getKindAccess().getNATUREEnumLiteralDeclaration_1()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1112:1: ( 'nature' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1112:3: 'nature'
                    {
                    match(input,42,FOLLOW_42_in_rule__Kind__Alternatives2465); 

                    }

                     after(grammarAccess.getKindAccess().getNATUREEnumLiteralDeclaration_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1117:6: ( ( 'builder' ) )
                    {
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1117:6: ( ( 'builder' ) )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1118:1: ( 'builder' )
                    {
                     before(grammarAccess.getKindAccess().getBUILDEREnumLiteralDeclaration_2()); 
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1119:1: ( 'builder' )
                    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1119:3: 'builder'
                    {
                    match(input,43,FOLLOW_43_in_rule__Kind__Alternatives2486); 

                    }

                     after(grammarAccess.getKindAccess().getBUILDEREnumLiteralDeclaration_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Kind__Alternatives


    // $ANTLR start rule__OrExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1131:1: rule__OrExpression__Group__0 : rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 ;
    public final void rule__OrExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1135:1: ( rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1136:2: rule__OrExpression__Group__0__Impl rule__OrExpression__Group__1
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__0__Impl_in_rule__OrExpression__Group__02519);
            rule__OrExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group__1_in_rule__OrExpression__Group__02522);
            rule__OrExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group__0


    // $ANTLR start rule__OrExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1143:1: rule__OrExpression__Group__0__Impl : ( ruleXorExpression ) ;
    public final void rule__OrExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1147:1: ( ( ruleXorExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1148:1: ( ruleXorExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1148:1: ( ruleXorExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1149:1: ruleXorExpression
            {
             before(grammarAccess.getOrExpressionAccess().getXorExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleXorExpression_in_rule__OrExpression__Group__0__Impl2549);
            ruleXorExpression();
            _fsp--;

             after(grammarAccess.getOrExpressionAccess().getXorExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group__0__Impl


    // $ANTLR start rule__OrExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1160:1: rule__OrExpression__Group__1 : rule__OrExpression__Group__1__Impl ;
    public final void rule__OrExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1164:1: ( rule__OrExpression__Group__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1165:2: rule__OrExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__OrExpression__Group__1__Impl_in_rule__OrExpression__Group__12578);
            rule__OrExpression__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group__1


    // $ANTLR start rule__OrExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1171:1: rule__OrExpression__Group__1__Impl : ( ( rule__OrExpression__Group_1__0 )* ) ;
    public final void rule__OrExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1175:1: ( ( ( rule__OrExpression__Group_1__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1176:1: ( ( rule__OrExpression__Group_1__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1176:1: ( ( rule__OrExpression__Group_1__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1177:1: ( rule__OrExpression__Group_1__0 )*
            {
             before(grammarAccess.getOrExpressionAccess().getGroup_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1178:1: ( rule__OrExpression__Group_1__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=12 && LA12_0<=14)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1178:2: rule__OrExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__OrExpression__Group_1__0_in_rule__OrExpression__Group__1__Impl2605);
            	    rule__OrExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getOrExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group__1__Impl


    // $ANTLR start rule__OrExpression__Group_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1192:1: rule__OrExpression__Group_1__0 : rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 ;
    public final void rule__OrExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1196:1: ( rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1197:2: rule__OrExpression__Group_1__0__Impl rule__OrExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__0__Impl_in_rule__OrExpression__Group_1__02640);
            rule__OrExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group_1__1_in_rule__OrExpression__Group_1__02643);
            rule__OrExpression__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group_1__0


    // $ANTLR start rule__OrExpression__Group_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1204:1: rule__OrExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__OrExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1208:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1209:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1209:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1210:1: ()
            {
             before(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1211:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1213:1: 
            {
            }

             after(grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group_1__0__Impl


    // $ANTLR start rule__OrExpression__Group_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1223:1: rule__OrExpression__Group_1__1 : rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 ;
    public final void rule__OrExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1227:1: ( rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1228:2: rule__OrExpression__Group_1__1__Impl rule__OrExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__1__Impl_in_rule__OrExpression__Group_1__12701);
            rule__OrExpression__Group_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__OrExpression__Group_1__2_in_rule__OrExpression__Group_1__12704);
            rule__OrExpression__Group_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group_1__1


    // $ANTLR start rule__OrExpression__Group_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1235:1: rule__OrExpression__Group_1__1__Impl : ( ruleOrOperator ) ;
    public final void rule__OrExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1239:1: ( ( ruleOrOperator ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1240:1: ( ruleOrOperator )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1240:1: ( ruleOrOperator )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1241:1: ruleOrOperator
            {
             before(grammarAccess.getOrExpressionAccess().getOrOperatorParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleOrOperator_in_rule__OrExpression__Group_1__1__Impl2731);
            ruleOrOperator();
            _fsp--;

             after(grammarAccess.getOrExpressionAccess().getOrOperatorParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group_1__1__Impl


    // $ANTLR start rule__OrExpression__Group_1__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1252:1: rule__OrExpression__Group_1__2 : rule__OrExpression__Group_1__2__Impl ;
    public final void rule__OrExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1256:1: ( rule__OrExpression__Group_1__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1257:2: rule__OrExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__OrExpression__Group_1__2__Impl_in_rule__OrExpression__Group_1__22760);
            rule__OrExpression__Group_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group_1__2


    // $ANTLR start rule__OrExpression__Group_1__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1263:1: rule__OrExpression__Group_1__2__Impl : ( ( rule__OrExpression__RightAssignment_1_2 ) ) ;
    public final void rule__OrExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1267:1: ( ( ( rule__OrExpression__RightAssignment_1_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1268:1: ( ( rule__OrExpression__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1268:1: ( ( rule__OrExpression__RightAssignment_1_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1269:1: ( rule__OrExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1270:1: ( rule__OrExpression__RightAssignment_1_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1270:2: rule__OrExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__OrExpression__RightAssignment_1_2_in_rule__OrExpression__Group_1__2__Impl2787);
            rule__OrExpression__RightAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getOrExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__Group_1__2__Impl


    // $ANTLR start rule__XorExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1286:1: rule__XorExpression__Group__0 : rule__XorExpression__Group__0__Impl rule__XorExpression__Group__1 ;
    public final void rule__XorExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1290:1: ( rule__XorExpression__Group__0__Impl rule__XorExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1291:2: rule__XorExpression__Group__0__Impl rule__XorExpression__Group__1
            {
            pushFollow(FOLLOW_rule__XorExpression__Group__0__Impl_in_rule__XorExpression__Group__02823);
            rule__XorExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__XorExpression__Group__1_in_rule__XorExpression__Group__02826);
            rule__XorExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group__0


    // $ANTLR start rule__XorExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1298:1: rule__XorExpression__Group__0__Impl : ( ruleAndExpression ) ;
    public final void rule__XorExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1302:1: ( ( ruleAndExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1303:1: ( ruleAndExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1303:1: ( ruleAndExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1304:1: ruleAndExpression
            {
             before(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleAndExpression_in_rule__XorExpression__Group__0__Impl2853);
            ruleAndExpression();
            _fsp--;

             after(grammarAccess.getXorExpressionAccess().getAndExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group__0__Impl


    // $ANTLR start rule__XorExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1315:1: rule__XorExpression__Group__1 : rule__XorExpression__Group__1__Impl ;
    public final void rule__XorExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1319:1: ( rule__XorExpression__Group__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1320:2: rule__XorExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XorExpression__Group__1__Impl_in_rule__XorExpression__Group__12882);
            rule__XorExpression__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group__1


    // $ANTLR start rule__XorExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1326:1: rule__XorExpression__Group__1__Impl : ( ( rule__XorExpression__Group_1__0 )* ) ;
    public final void rule__XorExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1330:1: ( ( ( rule__XorExpression__Group_1__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1331:1: ( ( rule__XorExpression__Group_1__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1331:1: ( ( rule__XorExpression__Group_1__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1332:1: ( rule__XorExpression__Group_1__0 )*
            {
             before(grammarAccess.getXorExpressionAccess().getGroup_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1333:1: ( rule__XorExpression__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=15 && LA13_0<=16)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1333:2: rule__XorExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__XorExpression__Group_1__0_in_rule__XorExpression__Group__1__Impl2909);
            	    rule__XorExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getXorExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group__1__Impl


    // $ANTLR start rule__XorExpression__Group_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1347:1: rule__XorExpression__Group_1__0 : rule__XorExpression__Group_1__0__Impl rule__XorExpression__Group_1__1 ;
    public final void rule__XorExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1351:1: ( rule__XorExpression__Group_1__0__Impl rule__XorExpression__Group_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1352:2: rule__XorExpression__Group_1__0__Impl rule__XorExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__XorExpression__Group_1__0__Impl_in_rule__XorExpression__Group_1__02944);
            rule__XorExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__XorExpression__Group_1__1_in_rule__XorExpression__Group_1__02947);
            rule__XorExpression__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group_1__0


    // $ANTLR start rule__XorExpression__Group_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1359:1: rule__XorExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__XorExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1363:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1364:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1364:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1365:1: ()
            {
             before(grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1366:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1368:1: 
            {
            }

             after(grammarAccess.getXorExpressionAccess().getXorExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group_1__0__Impl


    // $ANTLR start rule__XorExpression__Group_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1378:1: rule__XorExpression__Group_1__1 : rule__XorExpression__Group_1__1__Impl rule__XorExpression__Group_1__2 ;
    public final void rule__XorExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1382:1: ( rule__XorExpression__Group_1__1__Impl rule__XorExpression__Group_1__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1383:2: rule__XorExpression__Group_1__1__Impl rule__XorExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__XorExpression__Group_1__1__Impl_in_rule__XorExpression__Group_1__13005);
            rule__XorExpression__Group_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__XorExpression__Group_1__2_in_rule__XorExpression__Group_1__13008);
            rule__XorExpression__Group_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group_1__1


    // $ANTLR start rule__XorExpression__Group_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1390:1: rule__XorExpression__Group_1__1__Impl : ( ruleXorOperator ) ;
    public final void rule__XorExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1394:1: ( ( ruleXorOperator ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1395:1: ( ruleXorOperator )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1395:1: ( ruleXorOperator )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1396:1: ruleXorOperator
            {
             before(grammarAccess.getXorExpressionAccess().getXorOperatorParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleXorOperator_in_rule__XorExpression__Group_1__1__Impl3035);
            ruleXorOperator();
            _fsp--;

             after(grammarAccess.getXorExpressionAccess().getXorOperatorParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group_1__1__Impl


    // $ANTLR start rule__XorExpression__Group_1__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1407:1: rule__XorExpression__Group_1__2 : rule__XorExpression__Group_1__2__Impl ;
    public final void rule__XorExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1411:1: ( rule__XorExpression__Group_1__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1412:2: rule__XorExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__XorExpression__Group_1__2__Impl_in_rule__XorExpression__Group_1__23064);
            rule__XorExpression__Group_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group_1__2


    // $ANTLR start rule__XorExpression__Group_1__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1418:1: rule__XorExpression__Group_1__2__Impl : ( ( rule__XorExpression__RightAssignment_1_2 ) ) ;
    public final void rule__XorExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1422:1: ( ( ( rule__XorExpression__RightAssignment_1_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1423:1: ( ( rule__XorExpression__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1423:1: ( ( rule__XorExpression__RightAssignment_1_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1424:1: ( rule__XorExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getXorExpressionAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1425:1: ( rule__XorExpression__RightAssignment_1_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1425:2: rule__XorExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__XorExpression__RightAssignment_1_2_in_rule__XorExpression__Group_1__2__Impl3091);
            rule__XorExpression__RightAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getXorExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__Group_1__2__Impl


    // $ANTLR start rule__AndExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1441:1: rule__AndExpression__Group__0 : rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 ;
    public final void rule__AndExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1445:1: ( rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1446:2: rule__AndExpression__Group__0__Impl rule__AndExpression__Group__1
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__03127);
            rule__AndExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__03130);
            rule__AndExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group__0


    // $ANTLR start rule__AndExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1453:1: rule__AndExpression__Group__0__Impl : ( ruleComparisonExpression ) ;
    public final void rule__AndExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1457:1: ( ( ruleComparisonExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1458:1: ( ruleComparisonExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1458:1: ( ruleComparisonExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1459:1: ruleComparisonExpression
            {
             before(grammarAccess.getAndExpressionAccess().getComparisonExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleComparisonExpression_in_rule__AndExpression__Group__0__Impl3157);
            ruleComparisonExpression();
            _fsp--;

             after(grammarAccess.getAndExpressionAccess().getComparisonExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group__0__Impl


    // $ANTLR start rule__AndExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1470:1: rule__AndExpression__Group__1 : rule__AndExpression__Group__1__Impl ;
    public final void rule__AndExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1474:1: ( rule__AndExpression__Group__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1475:2: rule__AndExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__13186);
            rule__AndExpression__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group__1


    // $ANTLR start rule__AndExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1481:1: rule__AndExpression__Group__1__Impl : ( ( rule__AndExpression__Group_1__0 )* ) ;
    public final void rule__AndExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1485:1: ( ( ( rule__AndExpression__Group_1__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1486:1: ( ( rule__AndExpression__Group_1__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1486:1: ( ( rule__AndExpression__Group_1__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1487:1: ( rule__AndExpression__Group_1__0 )*
            {
             before(grammarAccess.getAndExpressionAccess().getGroup_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1488:1: ( rule__AndExpression__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0>=17 && LA14_0<=19)) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1488:2: rule__AndExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__AndExpression__Group_1__0_in_rule__AndExpression__Group__1__Impl3213);
            	    rule__AndExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getAndExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group__1__Impl


    // $ANTLR start rule__AndExpression__Group_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1502:1: rule__AndExpression__Group_1__0 : rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 ;
    public final void rule__AndExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1506:1: ( rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1507:2: rule__AndExpression__Group_1__0__Impl rule__AndExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__0__Impl_in_rule__AndExpression__Group_1__03248);
            rule__AndExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group_1__1_in_rule__AndExpression__Group_1__03251);
            rule__AndExpression__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group_1__0


    // $ANTLR start rule__AndExpression__Group_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1514:1: rule__AndExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__AndExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1518:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1519:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1519:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1520:1: ()
            {
             before(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1521:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1523:1: 
            {
            }

             after(grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group_1__0__Impl


    // $ANTLR start rule__AndExpression__Group_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1533:1: rule__AndExpression__Group_1__1 : rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 ;
    public final void rule__AndExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1537:1: ( rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1538:2: rule__AndExpression__Group_1__1__Impl rule__AndExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__1__Impl_in_rule__AndExpression__Group_1__13309);
            rule__AndExpression__Group_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__AndExpression__Group_1__2_in_rule__AndExpression__Group_1__13312);
            rule__AndExpression__Group_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group_1__1


    // $ANTLR start rule__AndExpression__Group_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1545:1: rule__AndExpression__Group_1__1__Impl : ( ruleAndOperator ) ;
    public final void rule__AndExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1549:1: ( ( ruleAndOperator ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1550:1: ( ruleAndOperator )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1550:1: ( ruleAndOperator )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1551:1: ruleAndOperator
            {
             before(grammarAccess.getAndExpressionAccess().getAndOperatorParserRuleCall_1_1()); 
            pushFollow(FOLLOW_ruleAndOperator_in_rule__AndExpression__Group_1__1__Impl3339);
            ruleAndOperator();
            _fsp--;

             after(grammarAccess.getAndExpressionAccess().getAndOperatorParserRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group_1__1__Impl


    // $ANTLR start rule__AndExpression__Group_1__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1562:1: rule__AndExpression__Group_1__2 : rule__AndExpression__Group_1__2__Impl ;
    public final void rule__AndExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1566:1: ( rule__AndExpression__Group_1__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1567:2: rule__AndExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__AndExpression__Group_1__2__Impl_in_rule__AndExpression__Group_1__23368);
            rule__AndExpression__Group_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group_1__2


    // $ANTLR start rule__AndExpression__Group_1__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1573:1: rule__AndExpression__Group_1__2__Impl : ( ( rule__AndExpression__RightAssignment_1_2 ) ) ;
    public final void rule__AndExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1577:1: ( ( ( rule__AndExpression__RightAssignment_1_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1578:1: ( ( rule__AndExpression__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1578:1: ( ( rule__AndExpression__RightAssignment_1_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1579:1: ( rule__AndExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1580:1: ( rule__AndExpression__RightAssignment_1_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1580:2: rule__AndExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__AndExpression__RightAssignment_1_2_in_rule__AndExpression__Group_1__2__Impl3395);
            rule__AndExpression__RightAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getAndExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__Group_1__2__Impl


    // $ANTLR start rule__ComparisonExpression__Group_0__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1596:1: rule__ComparisonExpression__Group_0__0 : rule__ComparisonExpression__Group_0__0__Impl rule__ComparisonExpression__Group_0__1 ;
    public final void rule__ComparisonExpression__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1600:1: ( rule__ComparisonExpression__Group_0__0__Impl rule__ComparisonExpression__Group_0__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1601:2: rule__ComparisonExpression__Group_0__0__Impl rule__ComparisonExpression__Group_0__1
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0__0__Impl_in_rule__ComparisonExpression__Group_0__03431);
            rule__ComparisonExpression__Group_0__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0__1_in_rule__ComparisonExpression__Group_0__03434);
            rule__ComparisonExpression__Group_0__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0__0


    // $ANTLR start rule__ComparisonExpression__Group_0__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1608:1: rule__ComparisonExpression__Group_0__0__Impl : ( rulePrimaryExpression ) ;
    public final void rule__ComparisonExpression__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1612:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1613:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1613:1: ( rulePrimaryExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1614:1: rulePrimaryExpression
            {
             before(grammarAccess.getComparisonExpressionAccess().getPrimaryExpressionParserRuleCall_0_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__ComparisonExpression__Group_0__0__Impl3461);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getPrimaryExpressionParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0__0__Impl


    // $ANTLR start rule__ComparisonExpression__Group_0__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1625:1: rule__ComparisonExpression__Group_0__1 : rule__ComparisonExpression__Group_0__1__Impl ;
    public final void rule__ComparisonExpression__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1629:1: ( rule__ComparisonExpression__Group_0__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1630:2: rule__ComparisonExpression__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0__1__Impl_in_rule__ComparisonExpression__Group_0__13490);
            rule__ComparisonExpression__Group_0__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0__1


    // $ANTLR start rule__ComparisonExpression__Group_0__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1636:1: rule__ComparisonExpression__Group_0__1__Impl : ( ( rule__ComparisonExpression__Group_0_1__0 )* ) ;
    public final void rule__ComparisonExpression__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1640:1: ( ( ( rule__ComparisonExpression__Group_0_1__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1641:1: ( ( rule__ComparisonExpression__Group_0_1__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1641:1: ( ( rule__ComparisonExpression__Group_0_1__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1642:1: ( rule__ComparisonExpression__Group_0_1__0 )*
            {
             before(grammarAccess.getComparisonExpressionAccess().getGroup_0_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1643:1: ( rule__ComparisonExpression__Group_0_1__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0>=22 && LA15_0<=29)) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1643:2: rule__ComparisonExpression__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ComparisonExpression__Group_0_1__0_in_rule__ComparisonExpression__Group_0__1__Impl3517);
            	    rule__ComparisonExpression__Group_0_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getComparisonExpressionAccess().getGroup_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0__1__Impl


    // $ANTLR start rule__ComparisonExpression__Group_0_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1657:1: rule__ComparisonExpression__Group_0_1__0 : rule__ComparisonExpression__Group_0_1__0__Impl rule__ComparisonExpression__Group_0_1__1 ;
    public final void rule__ComparisonExpression__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1661:1: ( rule__ComparisonExpression__Group_0_1__0__Impl rule__ComparisonExpression__Group_0_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1662:2: rule__ComparisonExpression__Group_0_1__0__Impl rule__ComparisonExpression__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0_1__0__Impl_in_rule__ComparisonExpression__Group_0_1__03552);
            rule__ComparisonExpression__Group_0_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0_1__1_in_rule__ComparisonExpression__Group_0_1__03555);
            rule__ComparisonExpression__Group_0_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0_1__0


    // $ANTLR start rule__ComparisonExpression__Group_0_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1669:1: rule__ComparisonExpression__Group_0_1__0__Impl : ( () ) ;
    public final void rule__ComparisonExpression__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1673:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1674:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1674:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1675:1: ()
            {
             before(grammarAccess.getComparisonExpressionAccess().getBooleanComparisonLeftAction_0_1_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1676:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1678:1: 
            {
            }

             after(grammarAccess.getComparisonExpressionAccess().getBooleanComparisonLeftAction_0_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0_1__0__Impl


    // $ANTLR start rule__ComparisonExpression__Group_0_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1688:1: rule__ComparisonExpression__Group_0_1__1 : rule__ComparisonExpression__Group_0_1__1__Impl rule__ComparisonExpression__Group_0_1__2 ;
    public final void rule__ComparisonExpression__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1692:1: ( rule__ComparisonExpression__Group_0_1__1__Impl rule__ComparisonExpression__Group_0_1__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1693:2: rule__ComparisonExpression__Group_0_1__1__Impl rule__ComparisonExpression__Group_0_1__2
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0_1__1__Impl_in_rule__ComparisonExpression__Group_0_1__13613);
            rule__ComparisonExpression__Group_0_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0_1__2_in_rule__ComparisonExpression__Group_0_1__13616);
            rule__ComparisonExpression__Group_0_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0_1__1


    // $ANTLR start rule__ComparisonExpression__Group_0_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1700:1: rule__ComparisonExpression__Group_0_1__1__Impl : ( ( rule__ComparisonExpression__OperatorAssignment_0_1_1 ) ) ;
    public final void rule__ComparisonExpression__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1704:1: ( ( ( rule__ComparisonExpression__OperatorAssignment_0_1_1 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1705:1: ( ( rule__ComparisonExpression__OperatorAssignment_0_1_1 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1705:1: ( ( rule__ComparisonExpression__OperatorAssignment_0_1_1 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1706:1: ( rule__ComparisonExpression__OperatorAssignment_0_1_1 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getOperatorAssignment_0_1_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1707:1: ( rule__ComparisonExpression__OperatorAssignment_0_1_1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1707:2: rule__ComparisonExpression__OperatorAssignment_0_1_1
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__OperatorAssignment_0_1_1_in_rule__ComparisonExpression__Group_0_1__1__Impl3643);
            rule__ComparisonExpression__OperatorAssignment_0_1_1();
            _fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getOperatorAssignment_0_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0_1__1__Impl


    // $ANTLR start rule__ComparisonExpression__Group_0_1__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1717:1: rule__ComparisonExpression__Group_0_1__2 : rule__ComparisonExpression__Group_0_1__2__Impl ;
    public final void rule__ComparisonExpression__Group_0_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1721:1: ( rule__ComparisonExpression__Group_0_1__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1722:2: rule__ComparisonExpression__Group_0_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_0_1__2__Impl_in_rule__ComparisonExpression__Group_0_1__23673);
            rule__ComparisonExpression__Group_0_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0_1__2


    // $ANTLR start rule__ComparisonExpression__Group_0_1__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1728:1: rule__ComparisonExpression__Group_0_1__2__Impl : ( ( rule__ComparisonExpression__RightAssignment_0_1_2 ) ) ;
    public final void rule__ComparisonExpression__Group_0_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1732:1: ( ( ( rule__ComparisonExpression__RightAssignment_0_1_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1733:1: ( ( rule__ComparisonExpression__RightAssignment_0_1_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1733:1: ( ( rule__ComparisonExpression__RightAssignment_0_1_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1734:1: ( rule__ComparisonExpression__RightAssignment_0_1_2 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getRightAssignment_0_1_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1735:1: ( rule__ComparisonExpression__RightAssignment_0_1_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1735:2: rule__ComparisonExpression__RightAssignment_0_1_2
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__RightAssignment_0_1_2_in_rule__ComparisonExpression__Group_0_1__2__Impl3700);
            rule__ComparisonExpression__RightAssignment_0_1_2();
            _fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getRightAssignment_0_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_0_1__2__Impl


    // $ANTLR start rule__ComparisonExpression__Group_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1751:1: rule__ComparisonExpression__Group_1__0 : rule__ComparisonExpression__Group_1__0__Impl rule__ComparisonExpression__Group_1__1 ;
    public final void rule__ComparisonExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1755:1: ( rule__ComparisonExpression__Group_1__0__Impl rule__ComparisonExpression__Group_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1756:2: rule__ComparisonExpression__Group_1__0__Impl rule__ComparisonExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1__0__Impl_in_rule__ComparisonExpression__Group_1__03736);
            rule__ComparisonExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1__1_in_rule__ComparisonExpression__Group_1__03739);
            rule__ComparisonExpression__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1__0


    // $ANTLR start rule__ComparisonExpression__Group_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1763:1: rule__ComparisonExpression__Group_1__0__Impl : ( ruleConcatExpression ) ;
    public final void rule__ComparisonExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1767:1: ( ( ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1768:1: ( ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1768:1: ( ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1769:1: ruleConcatExpression
            {
             before(grammarAccess.getComparisonExpressionAccess().getConcatExpressionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_rule__ComparisonExpression__Group_1__0__Impl3766);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getConcatExpressionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1__0__Impl


    // $ANTLR start rule__ComparisonExpression__Group_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1780:1: rule__ComparisonExpression__Group_1__1 : rule__ComparisonExpression__Group_1__1__Impl ;
    public final void rule__ComparisonExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1784:1: ( rule__ComparisonExpression__Group_1__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1785:2: rule__ComparisonExpression__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1__1__Impl_in_rule__ComparisonExpression__Group_1__13795);
            rule__ComparisonExpression__Group_1__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1__1


    // $ANTLR start rule__ComparisonExpression__Group_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1791:1: rule__ComparisonExpression__Group_1__1__Impl : ( ( ( rule__ComparisonExpression__Group_1_1__0 ) ) ( ( rule__ComparisonExpression__Group_1_1__0 )* ) ) ;
    public final void rule__ComparisonExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1795:1: ( ( ( ( rule__ComparisonExpression__Group_1_1__0 ) ) ( ( rule__ComparisonExpression__Group_1_1__0 )* ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1796:1: ( ( ( rule__ComparisonExpression__Group_1_1__0 ) ) ( ( rule__ComparisonExpression__Group_1_1__0 )* ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1796:1: ( ( ( rule__ComparisonExpression__Group_1_1__0 ) ) ( ( rule__ComparisonExpression__Group_1_1__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1797:1: ( ( rule__ComparisonExpression__Group_1_1__0 ) ) ( ( rule__ComparisonExpression__Group_1_1__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1797:1: ( ( rule__ComparisonExpression__Group_1_1__0 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1798:1: ( rule__ComparisonExpression__Group_1_1__0 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getGroup_1_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1799:1: ( rule__ComparisonExpression__Group_1_1__0 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1799:2: rule__ComparisonExpression__Group_1_1__0
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__0_in_rule__ComparisonExpression__Group_1__1__Impl3824);
            rule__ComparisonExpression__Group_1_1__0();
            _fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getGroup_1_1()); 

            }

            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1802:1: ( ( rule__ComparisonExpression__Group_1_1__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1803:1: ( rule__ComparisonExpression__Group_1_1__0 )*
            {
             before(grammarAccess.getComparisonExpressionAccess().getGroup_1_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1804:1: ( rule__ComparisonExpression__Group_1_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=22 && LA16_0<=36)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1804:2: rule__ComparisonExpression__Group_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__0_in_rule__ComparisonExpression__Group_1__1__Impl3836);
            	    rule__ComparisonExpression__Group_1_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getComparisonExpressionAccess().getGroup_1_1()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1__1__Impl


    // $ANTLR start rule__ComparisonExpression__Group_1_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1819:1: rule__ComparisonExpression__Group_1_1__0 : rule__ComparisonExpression__Group_1_1__0__Impl rule__ComparisonExpression__Group_1_1__1 ;
    public final void rule__ComparisonExpression__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1823:1: ( rule__ComparisonExpression__Group_1_1__0__Impl rule__ComparisonExpression__Group_1_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1824:2: rule__ComparisonExpression__Group_1_1__0__Impl rule__ComparisonExpression__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__0__Impl_in_rule__ComparisonExpression__Group_1_1__03873);
            rule__ComparisonExpression__Group_1_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__1_in_rule__ComparisonExpression__Group_1_1__03876);
            rule__ComparisonExpression__Group_1_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1_1__0


    // $ANTLR start rule__ComparisonExpression__Group_1_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1831:1: rule__ComparisonExpression__Group_1_1__0__Impl : ( () ) ;
    public final void rule__ComparisonExpression__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1835:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1836:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1836:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1837:1: ()
            {
             before(grammarAccess.getComparisonExpressionAccess().getStringComparisonLeftAction_1_1_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1838:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1840:1: 
            {
            }

             after(grammarAccess.getComparisonExpressionAccess().getStringComparisonLeftAction_1_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1_1__0__Impl


    // $ANTLR start rule__ComparisonExpression__Group_1_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1850:1: rule__ComparisonExpression__Group_1_1__1 : rule__ComparisonExpression__Group_1_1__1__Impl rule__ComparisonExpression__Group_1_1__2 ;
    public final void rule__ComparisonExpression__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1854:1: ( rule__ComparisonExpression__Group_1_1__1__Impl rule__ComparisonExpression__Group_1_1__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1855:2: rule__ComparisonExpression__Group_1_1__1__Impl rule__ComparisonExpression__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__1__Impl_in_rule__ComparisonExpression__Group_1_1__13934);
            rule__ComparisonExpression__Group_1_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__2_in_rule__ComparisonExpression__Group_1_1__13937);
            rule__ComparisonExpression__Group_1_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1_1__1


    // $ANTLR start rule__ComparisonExpression__Group_1_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1862:1: rule__ComparisonExpression__Group_1_1__1__Impl : ( ( rule__ComparisonExpression__OperatorAssignment_1_1_1 ) ) ;
    public final void rule__ComparisonExpression__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1866:1: ( ( ( rule__ComparisonExpression__OperatorAssignment_1_1_1 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1867:1: ( ( rule__ComparisonExpression__OperatorAssignment_1_1_1 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1867:1: ( ( rule__ComparisonExpression__OperatorAssignment_1_1_1 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1868:1: ( rule__ComparisonExpression__OperatorAssignment_1_1_1 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getOperatorAssignment_1_1_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1869:1: ( rule__ComparisonExpression__OperatorAssignment_1_1_1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1869:2: rule__ComparisonExpression__OperatorAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__OperatorAssignment_1_1_1_in_rule__ComparisonExpression__Group_1_1__1__Impl3964);
            rule__ComparisonExpression__OperatorAssignment_1_1_1();
            _fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getOperatorAssignment_1_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1_1__1__Impl


    // $ANTLR start rule__ComparisonExpression__Group_1_1__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1879:1: rule__ComparisonExpression__Group_1_1__2 : rule__ComparisonExpression__Group_1_1__2__Impl ;
    public final void rule__ComparisonExpression__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1883:1: ( rule__ComparisonExpression__Group_1_1__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1884:2: rule__ComparisonExpression__Group_1_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__Group_1_1__2__Impl_in_rule__ComparisonExpression__Group_1_1__23994);
            rule__ComparisonExpression__Group_1_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1_1__2


    // $ANTLR start rule__ComparisonExpression__Group_1_1__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1890:1: rule__ComparisonExpression__Group_1_1__2__Impl : ( ( rule__ComparisonExpression__RightAssignment_1_1_2 ) ) ;
    public final void rule__ComparisonExpression__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1894:1: ( ( ( rule__ComparisonExpression__RightAssignment_1_1_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1895:1: ( ( rule__ComparisonExpression__RightAssignment_1_1_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1895:1: ( ( rule__ComparisonExpression__RightAssignment_1_1_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1896:1: ( rule__ComparisonExpression__RightAssignment_1_1_2 )
            {
             before(grammarAccess.getComparisonExpressionAccess().getRightAssignment_1_1_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1897:1: ( rule__ComparisonExpression__RightAssignment_1_1_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1897:2: rule__ComparisonExpression__RightAssignment_1_1_2
            {
            pushFollow(FOLLOW_rule__ComparisonExpression__RightAssignment_1_1_2_in_rule__ComparisonExpression__Group_1_1__2__Impl4021);
            rule__ComparisonExpression__RightAssignment_1_1_2();
            _fsp--;


            }

             after(grammarAccess.getComparisonExpressionAccess().getRightAssignment_1_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__Group_1_1__2__Impl


    // $ANTLR start rule__PrimaryExpression__Group_5__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1913:1: rule__PrimaryExpression__Group_5__0 : rule__PrimaryExpression__Group_5__0__Impl rule__PrimaryExpression__Group_5__1 ;
    public final void rule__PrimaryExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1917:1: ( rule__PrimaryExpression__Group_5__0__Impl rule__PrimaryExpression__Group_5__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1918:2: rule__PrimaryExpression__Group_5__0__Impl rule__PrimaryExpression__Group_5__1
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_5__0__Impl_in_rule__PrimaryExpression__Group_5__04057);
            rule__PrimaryExpression__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_5__1_in_rule__PrimaryExpression__Group_5__04060);
            rule__PrimaryExpression__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_5__0


    // $ANTLR start rule__PrimaryExpression__Group_5__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1925:1: rule__PrimaryExpression__Group_5__0__Impl : ( '(' ) ;
    public final void rule__PrimaryExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1929:1: ( ( '(' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1930:1: ( '(' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1930:1: ( '(' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1931:1: '('
            {
             before(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_5_0()); 
            match(input,44,FOLLOW_44_in_rule__PrimaryExpression__Group_5__0__Impl4088); 
             after(grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_5__0__Impl


    // $ANTLR start rule__PrimaryExpression__Group_5__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1944:1: rule__PrimaryExpression__Group_5__1 : rule__PrimaryExpression__Group_5__1__Impl rule__PrimaryExpression__Group_5__2 ;
    public final void rule__PrimaryExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1948:1: ( rule__PrimaryExpression__Group_5__1__Impl rule__PrimaryExpression__Group_5__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1949:2: rule__PrimaryExpression__Group_5__1__Impl rule__PrimaryExpression__Group_5__2
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_5__1__Impl_in_rule__PrimaryExpression__Group_5__14119);
            rule__PrimaryExpression__Group_5__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__PrimaryExpression__Group_5__2_in_rule__PrimaryExpression__Group_5__14122);
            rule__PrimaryExpression__Group_5__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_5__1


    // $ANTLR start rule__PrimaryExpression__Group_5__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1956:1: rule__PrimaryExpression__Group_5__1__Impl : ( ruleOrExpression ) ;
    public final void rule__PrimaryExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1960:1: ( ( ruleOrExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1961:1: ( ruleOrExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1961:1: ( ruleOrExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1962:1: ruleOrExpression
            {
             before(grammarAccess.getPrimaryExpressionAccess().getOrExpressionParserRuleCall_5_1()); 
            pushFollow(FOLLOW_ruleOrExpression_in_rule__PrimaryExpression__Group_5__1__Impl4149);
            ruleOrExpression();
            _fsp--;

             after(grammarAccess.getPrimaryExpressionAccess().getOrExpressionParserRuleCall_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_5__1__Impl


    // $ANTLR start rule__PrimaryExpression__Group_5__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1973:1: rule__PrimaryExpression__Group_5__2 : rule__PrimaryExpression__Group_5__2__Impl ;
    public final void rule__PrimaryExpression__Group_5__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1977:1: ( rule__PrimaryExpression__Group_5__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1978:2: rule__PrimaryExpression__Group_5__2__Impl
            {
            pushFollow(FOLLOW_rule__PrimaryExpression__Group_5__2__Impl_in_rule__PrimaryExpression__Group_5__24178);
            rule__PrimaryExpression__Group_5__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_5__2


    // $ANTLR start rule__PrimaryExpression__Group_5__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1984:1: rule__PrimaryExpression__Group_5__2__Impl : ( ')' ) ;
    public final void rule__PrimaryExpression__Group_5__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1988:1: ( ( ')' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1989:1: ( ')' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1989:1: ( ')' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:1990:1: ')'
            {
             before(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_5_2()); 
            match(input,45,FOLLOW_45_in_rule__PrimaryExpression__Group_5__2__Impl4206); 
             after(grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_5_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PrimaryExpression__Group_5__2__Impl


    // $ANTLR start rule__NotExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2009:1: rule__NotExpression__Group__0 : rule__NotExpression__Group__0__Impl rule__NotExpression__Group__1 ;
    public final void rule__NotExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2013:1: ( rule__NotExpression__Group__0__Impl rule__NotExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2014:2: rule__NotExpression__Group__0__Impl rule__NotExpression__Group__1
            {
            pushFollow(FOLLOW_rule__NotExpression__Group__0__Impl_in_rule__NotExpression__Group__04243);
            rule__NotExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NotExpression__Group__1_in_rule__NotExpression__Group__04246);
            rule__NotExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__Group__0


    // $ANTLR start rule__NotExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2021:1: rule__NotExpression__Group__0__Impl : ( () ) ;
    public final void rule__NotExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2025:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2026:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2026:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2027:1: ()
            {
             before(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2028:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2030:1: 
            {
            }

             after(grammarAccess.getNotExpressionAccess().getNotExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__Group__0__Impl


    // $ANTLR start rule__NotExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2040:1: rule__NotExpression__Group__1 : rule__NotExpression__Group__1__Impl rule__NotExpression__Group__2 ;
    public final void rule__NotExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2044:1: ( rule__NotExpression__Group__1__Impl rule__NotExpression__Group__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2045:2: rule__NotExpression__Group__1__Impl rule__NotExpression__Group__2
            {
            pushFollow(FOLLOW_rule__NotExpression__Group__1__Impl_in_rule__NotExpression__Group__14304);
            rule__NotExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__NotExpression__Group__2_in_rule__NotExpression__Group__14307);
            rule__NotExpression__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__Group__1


    // $ANTLR start rule__NotExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2052:1: rule__NotExpression__Group__1__Impl : ( ruleNotOperator ) ;
    public final void rule__NotExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2056:1: ( ( ruleNotOperator ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2057:1: ( ruleNotOperator )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2057:1: ( ruleNotOperator )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2058:1: ruleNotOperator
            {
             before(grammarAccess.getNotExpressionAccess().getNotOperatorParserRuleCall_1()); 
            pushFollow(FOLLOW_ruleNotOperator_in_rule__NotExpression__Group__1__Impl4334);
            ruleNotOperator();
            _fsp--;

             after(grammarAccess.getNotExpressionAccess().getNotOperatorParserRuleCall_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__Group__1__Impl


    // $ANTLR start rule__NotExpression__Group__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2069:1: rule__NotExpression__Group__2 : rule__NotExpression__Group__2__Impl ;
    public final void rule__NotExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2073:1: ( rule__NotExpression__Group__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2074:2: rule__NotExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NotExpression__Group__2__Impl_in_rule__NotExpression__Group__24363);
            rule__NotExpression__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__Group__2


    // $ANTLR start rule__NotExpression__Group__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2080:1: rule__NotExpression__Group__2__Impl : ( ( rule__NotExpression__RightAssignment_2 ) ) ;
    public final void rule__NotExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2084:1: ( ( ( rule__NotExpression__RightAssignment_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2085:1: ( ( rule__NotExpression__RightAssignment_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2085:1: ( ( rule__NotExpression__RightAssignment_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2086:1: ( rule__NotExpression__RightAssignment_2 )
            {
             before(grammarAccess.getNotExpressionAccess().getRightAssignment_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2087:1: ( rule__NotExpression__RightAssignment_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2087:2: rule__NotExpression__RightAssignment_2
            {
            pushFollow(FOLLOW_rule__NotExpression__RightAssignment_2_in_rule__NotExpression__Group__2__Impl4390);
            rule__NotExpression__RightAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getNotExpressionAccess().getRightAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__Group__2__Impl


    // $ANTLR start rule__IsExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2103:1: rule__IsExpression__Group__0 : rule__IsExpression__Group__0__Impl rule__IsExpression__Group__1 ;
    public final void rule__IsExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2107:1: ( rule__IsExpression__Group__0__Impl rule__IsExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2108:2: rule__IsExpression__Group__0__Impl rule__IsExpression__Group__1
            {
            pushFollow(FOLLOW_rule__IsExpression__Group__0__Impl_in_rule__IsExpression__Group__04426);
            rule__IsExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__IsExpression__Group__1_in_rule__IsExpression__Group__04429);
            rule__IsExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__Group__0


    // $ANTLR start rule__IsExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2115:1: rule__IsExpression__Group__0__Impl : ( () ) ;
    public final void rule__IsExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2119:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2120:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2120:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2121:1: ()
            {
             before(grammarAccess.getIsExpressionAccess().getIsExpressionAction_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2122:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2124:1: 
            {
            }

             after(grammarAccess.getIsExpressionAccess().getIsExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__Group__0__Impl


    // $ANTLR start rule__IsExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2134:1: rule__IsExpression__Group__1 : rule__IsExpression__Group__1__Impl rule__IsExpression__Group__2 ;
    public final void rule__IsExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2138:1: ( rule__IsExpression__Group__1__Impl rule__IsExpression__Group__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2139:2: rule__IsExpression__Group__1__Impl rule__IsExpression__Group__2
            {
            pushFollow(FOLLOW_rule__IsExpression__Group__1__Impl_in_rule__IsExpression__Group__14487);
            rule__IsExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__IsExpression__Group__2_in_rule__IsExpression__Group__14490);
            rule__IsExpression__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__Group__1


    // $ANTLR start rule__IsExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2146:1: rule__IsExpression__Group__1__Impl : ( 'is' ) ;
    public final void rule__IsExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2150:1: ( ( 'is' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2151:1: ( 'is' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2151:1: ( 'is' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2152:1: 'is'
            {
             before(grammarAccess.getIsExpressionAccess().getIsKeyword_1()); 
            match(input,46,FOLLOW_46_in_rule__IsExpression__Group__1__Impl4518); 
             after(grammarAccess.getIsExpressionAccess().getIsKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__Group__1__Impl


    // $ANTLR start rule__IsExpression__Group__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2165:1: rule__IsExpression__Group__2 : rule__IsExpression__Group__2__Impl ;
    public final void rule__IsExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2169:1: ( rule__IsExpression__Group__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2170:2: rule__IsExpression__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__IsExpression__Group__2__Impl_in_rule__IsExpression__Group__24549);
            rule__IsExpression__Group__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__Group__2


    // $ANTLR start rule__IsExpression__Group__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2176:1: rule__IsExpression__Group__2__Impl : ( ( rule__IsExpression__TypeAssignment_2 ) ) ;
    public final void rule__IsExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2180:1: ( ( ( rule__IsExpression__TypeAssignment_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2181:1: ( ( rule__IsExpression__TypeAssignment_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2181:1: ( ( rule__IsExpression__TypeAssignment_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2182:1: ( rule__IsExpression__TypeAssignment_2 )
            {
             before(grammarAccess.getIsExpressionAccess().getTypeAssignment_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2183:1: ( rule__IsExpression__TypeAssignment_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2183:2: rule__IsExpression__TypeAssignment_2
            {
            pushFollow(FOLLOW_rule__IsExpression__TypeAssignment_2_in_rule__IsExpression__Group__2__Impl4576);
            rule__IsExpression__TypeAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getIsExpressionAccess().getTypeAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__Group__2__Impl


    // $ANTLR start rule__HasExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2199:1: rule__HasExpression__Group__0 : rule__HasExpression__Group__0__Impl rule__HasExpression__Group__1 ;
    public final void rule__HasExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2203:1: ( rule__HasExpression__Group__0__Impl rule__HasExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2204:2: rule__HasExpression__Group__0__Impl rule__HasExpression__Group__1
            {
            pushFollow(FOLLOW_rule__HasExpression__Group__0__Impl_in_rule__HasExpression__Group__04612);
            rule__HasExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__HasExpression__Group__1_in_rule__HasExpression__Group__04615);
            rule__HasExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__0


    // $ANTLR start rule__HasExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2211:1: rule__HasExpression__Group__0__Impl : ( () ) ;
    public final void rule__HasExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2215:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2216:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2216:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2217:1: ()
            {
             before(grammarAccess.getHasExpressionAccess().getHasExpressionAction_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2218:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2220:1: 
            {
            }

             after(grammarAccess.getHasExpressionAccess().getHasExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__0__Impl


    // $ANTLR start rule__HasExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2230:1: rule__HasExpression__Group__1 : rule__HasExpression__Group__1__Impl rule__HasExpression__Group__2 ;
    public final void rule__HasExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2234:1: ( rule__HasExpression__Group__1__Impl rule__HasExpression__Group__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2235:2: rule__HasExpression__Group__1__Impl rule__HasExpression__Group__2
            {
            pushFollow(FOLLOW_rule__HasExpression__Group__1__Impl_in_rule__HasExpression__Group__14673);
            rule__HasExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__HasExpression__Group__2_in_rule__HasExpression__Group__14676);
            rule__HasExpression__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__1


    // $ANTLR start rule__HasExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2242:1: rule__HasExpression__Group__1__Impl : ( 'has' ) ;
    public final void rule__HasExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2246:1: ( ( 'has' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2247:1: ( 'has' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2247:1: ( 'has' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2248:1: 'has'
            {
             before(grammarAccess.getHasExpressionAccess().getHasKeyword_1()); 
            match(input,47,FOLLOW_47_in_rule__HasExpression__Group__1__Impl4704); 
             after(grammarAccess.getHasExpressionAccess().getHasKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__1__Impl


    // $ANTLR start rule__HasExpression__Group__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2261:1: rule__HasExpression__Group__2 : rule__HasExpression__Group__2__Impl rule__HasExpression__Group__3 ;
    public final void rule__HasExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2265:1: ( rule__HasExpression__Group__2__Impl rule__HasExpression__Group__3 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2266:2: rule__HasExpression__Group__2__Impl rule__HasExpression__Group__3
            {
            pushFollow(FOLLOW_rule__HasExpression__Group__2__Impl_in_rule__HasExpression__Group__24735);
            rule__HasExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__HasExpression__Group__3_in_rule__HasExpression__Group__24738);
            rule__HasExpression__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__2


    // $ANTLR start rule__HasExpression__Group__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2273:1: rule__HasExpression__Group__2__Impl : ( ( rule__HasExpression__KindAssignment_2 ) ) ;
    public final void rule__HasExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2277:1: ( ( ( rule__HasExpression__KindAssignment_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2278:1: ( ( rule__HasExpression__KindAssignment_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2278:1: ( ( rule__HasExpression__KindAssignment_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2279:1: ( rule__HasExpression__KindAssignment_2 )
            {
             before(grammarAccess.getHasExpressionAccess().getKindAssignment_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2280:1: ( rule__HasExpression__KindAssignment_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2280:2: rule__HasExpression__KindAssignment_2
            {
            pushFollow(FOLLOW_rule__HasExpression__KindAssignment_2_in_rule__HasExpression__Group__2__Impl4765);
            rule__HasExpression__KindAssignment_2();
            _fsp--;


            }

             after(grammarAccess.getHasExpressionAccess().getKindAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__2__Impl


    // $ANTLR start rule__HasExpression__Group__3
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2290:1: rule__HasExpression__Group__3 : rule__HasExpression__Group__3__Impl ;
    public final void rule__HasExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2294:1: ( rule__HasExpression__Group__3__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2295:2: rule__HasExpression__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__HasExpression__Group__3__Impl_in_rule__HasExpression__Group__34795);
            rule__HasExpression__Group__3__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__3


    // $ANTLR start rule__HasExpression__Group__3__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2301:1: rule__HasExpression__Group__3__Impl : ( ( rule__HasExpression__WhatAssignment_3 ) ) ;
    public final void rule__HasExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2305:1: ( ( ( rule__HasExpression__WhatAssignment_3 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2306:1: ( ( rule__HasExpression__WhatAssignment_3 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2306:1: ( ( rule__HasExpression__WhatAssignment_3 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2307:1: ( rule__HasExpression__WhatAssignment_3 )
            {
             before(grammarAccess.getHasExpressionAccess().getWhatAssignment_3()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2308:1: ( rule__HasExpression__WhatAssignment_3 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2308:2: rule__HasExpression__WhatAssignment_3
            {
            pushFollow(FOLLOW_rule__HasExpression__WhatAssignment_3_in_rule__HasExpression__Group__3__Impl4822);
            rule__HasExpression__WhatAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getHasExpressionAccess().getWhatAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__Group__3__Impl


    // $ANTLR start rule__TestExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2326:1: rule__TestExpression__Group__0 : rule__TestExpression__Group__0__Impl rule__TestExpression__Group__1 ;
    public final void rule__TestExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2330:1: ( rule__TestExpression__Group__0__Impl rule__TestExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2331:2: rule__TestExpression__Group__0__Impl rule__TestExpression__Group__1
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__0__Impl_in_rule__TestExpression__Group__04860);
            rule__TestExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__1_in_rule__TestExpression__Group__04863);
            rule__TestExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__0


    // $ANTLR start rule__TestExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2338:1: rule__TestExpression__Group__0__Impl : ( () ) ;
    public final void rule__TestExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2342:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2343:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2343:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2344:1: ()
            {
             before(grammarAccess.getTestExpressionAccess().getTestExpressionAction_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2345:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2347:1: 
            {
            }

             after(grammarAccess.getTestExpressionAccess().getTestExpressionAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__0__Impl


    // $ANTLR start rule__TestExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2357:1: rule__TestExpression__Group__1 : rule__TestExpression__Group__1__Impl rule__TestExpression__Group__2 ;
    public final void rule__TestExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2361:1: ( rule__TestExpression__Group__1__Impl rule__TestExpression__Group__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2362:2: rule__TestExpression__Group__1__Impl rule__TestExpression__Group__2
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__1__Impl_in_rule__TestExpression__Group__14921);
            rule__TestExpression__Group__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__2_in_rule__TestExpression__Group__14924);
            rule__TestExpression__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__1


    // $ANTLR start rule__TestExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2369:1: rule__TestExpression__Group__1__Impl : ( ( rule__TestExpression__PropertyAssignment_1 ) ) ;
    public final void rule__TestExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2373:1: ( ( ( rule__TestExpression__PropertyAssignment_1 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2374:1: ( ( rule__TestExpression__PropertyAssignment_1 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2374:1: ( ( rule__TestExpression__PropertyAssignment_1 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2375:1: ( rule__TestExpression__PropertyAssignment_1 )
            {
             before(grammarAccess.getTestExpressionAccess().getPropertyAssignment_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2376:1: ( rule__TestExpression__PropertyAssignment_1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2376:2: rule__TestExpression__PropertyAssignment_1
            {
            pushFollow(FOLLOW_rule__TestExpression__PropertyAssignment_1_in_rule__TestExpression__Group__1__Impl4951);
            rule__TestExpression__PropertyAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getTestExpressionAccess().getPropertyAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__1__Impl


    // $ANTLR start rule__TestExpression__Group__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2386:1: rule__TestExpression__Group__2 : rule__TestExpression__Group__2__Impl rule__TestExpression__Group__3 ;
    public final void rule__TestExpression__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2390:1: ( rule__TestExpression__Group__2__Impl rule__TestExpression__Group__3 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2391:2: rule__TestExpression__Group__2__Impl rule__TestExpression__Group__3
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__2__Impl_in_rule__TestExpression__Group__24981);
            rule__TestExpression__Group__2__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__3_in_rule__TestExpression__Group__24984);
            rule__TestExpression__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__2


    // $ANTLR start rule__TestExpression__Group__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2398:1: rule__TestExpression__Group__2__Impl : ( ( rule__TestExpression__Group_2__0 )* ) ;
    public final void rule__TestExpression__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2402:1: ( ( ( rule__TestExpression__Group_2__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2403:1: ( ( rule__TestExpression__Group_2__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2403:1: ( ( rule__TestExpression__Group_2__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2404:1: ( rule__TestExpression__Group_2__0 )*
            {
             before(grammarAccess.getTestExpressionAccess().getGroup_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2405:1: ( rule__TestExpression__Group_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==48) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2405:2: rule__TestExpression__Group_2__0
            	    {
            	    pushFollow(FOLLOW_rule__TestExpression__Group_2__0_in_rule__TestExpression__Group__2__Impl5011);
            	    rule__TestExpression__Group_2__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

             after(grammarAccess.getTestExpressionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__2__Impl


    // $ANTLR start rule__TestExpression__Group__3
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2415:1: rule__TestExpression__Group__3 : rule__TestExpression__Group__3__Impl rule__TestExpression__Group__4 ;
    public final void rule__TestExpression__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2419:1: ( rule__TestExpression__Group__3__Impl rule__TestExpression__Group__4 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2420:2: rule__TestExpression__Group__3__Impl rule__TestExpression__Group__4
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__3__Impl_in_rule__TestExpression__Group__35042);
            rule__TestExpression__Group__3__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__4_in_rule__TestExpression__Group__35045);
            rule__TestExpression__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__3


    // $ANTLR start rule__TestExpression__Group__3__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2427:1: rule__TestExpression__Group__3__Impl : ( '(' ) ;
    public final void rule__TestExpression__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2431:1: ( ( '(' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2432:1: ( '(' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2432:1: ( '(' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2433:1: '('
            {
             before(grammarAccess.getTestExpressionAccess().getLeftParenthesisKeyword_3()); 
            match(input,44,FOLLOW_44_in_rule__TestExpression__Group__3__Impl5073); 
             after(grammarAccess.getTestExpressionAccess().getLeftParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__3__Impl


    // $ANTLR start rule__TestExpression__Group__4
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2446:1: rule__TestExpression__Group__4 : rule__TestExpression__Group__4__Impl rule__TestExpression__Group__5 ;
    public final void rule__TestExpression__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2450:1: ( rule__TestExpression__Group__4__Impl rule__TestExpression__Group__5 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2451:2: rule__TestExpression__Group__4__Impl rule__TestExpression__Group__5
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__4__Impl_in_rule__TestExpression__Group__45104);
            rule__TestExpression__Group__4__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__5_in_rule__TestExpression__Group__45107);
            rule__TestExpression__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__4


    // $ANTLR start rule__TestExpression__Group__4__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2458:1: rule__TestExpression__Group__4__Impl : ( ( rule__TestExpression__ArgsAssignment_4 ) ) ;
    public final void rule__TestExpression__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2462:1: ( ( ( rule__TestExpression__ArgsAssignment_4 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2463:1: ( ( rule__TestExpression__ArgsAssignment_4 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2463:1: ( ( rule__TestExpression__ArgsAssignment_4 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2464:1: ( rule__TestExpression__ArgsAssignment_4 )
            {
             before(grammarAccess.getTestExpressionAccess().getArgsAssignment_4()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2465:1: ( rule__TestExpression__ArgsAssignment_4 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2465:2: rule__TestExpression__ArgsAssignment_4
            {
            pushFollow(FOLLOW_rule__TestExpression__ArgsAssignment_4_in_rule__TestExpression__Group__4__Impl5134);
            rule__TestExpression__ArgsAssignment_4();
            _fsp--;


            }

             after(grammarAccess.getTestExpressionAccess().getArgsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__4__Impl


    // $ANTLR start rule__TestExpression__Group__5
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2475:1: rule__TestExpression__Group__5 : rule__TestExpression__Group__5__Impl rule__TestExpression__Group__6 ;
    public final void rule__TestExpression__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2479:1: ( rule__TestExpression__Group__5__Impl rule__TestExpression__Group__6 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2480:2: rule__TestExpression__Group__5__Impl rule__TestExpression__Group__6
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__5__Impl_in_rule__TestExpression__Group__55164);
            rule__TestExpression__Group__5__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__6_in_rule__TestExpression__Group__55167);
            rule__TestExpression__Group__6();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__5


    // $ANTLR start rule__TestExpression__Group__5__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2487:1: rule__TestExpression__Group__5__Impl : ( ( rule__TestExpression__Group_5__0 )* ) ;
    public final void rule__TestExpression__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2491:1: ( ( ( rule__TestExpression__Group_5__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2492:1: ( ( rule__TestExpression__Group_5__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2492:1: ( ( rule__TestExpression__Group_5__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2493:1: ( rule__TestExpression__Group_5__0 )*
            {
             before(grammarAccess.getTestExpressionAccess().getGroup_5()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2494:1: ( rule__TestExpression__Group_5__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==49) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2494:2: rule__TestExpression__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__TestExpression__Group_5__0_in_rule__TestExpression__Group__5__Impl5194);
            	    rule__TestExpression__Group_5__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getTestExpressionAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__5__Impl


    // $ANTLR start rule__TestExpression__Group__6
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2504:1: rule__TestExpression__Group__6 : rule__TestExpression__Group__6__Impl rule__TestExpression__Group__7 ;
    public final void rule__TestExpression__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2508:1: ( rule__TestExpression__Group__6__Impl rule__TestExpression__Group__7 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2509:2: rule__TestExpression__Group__6__Impl rule__TestExpression__Group__7
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__6__Impl_in_rule__TestExpression__Group__65225);
            rule__TestExpression__Group__6__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__7_in_rule__TestExpression__Group__65228);
            rule__TestExpression__Group__7();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__6


    // $ANTLR start rule__TestExpression__Group__6__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2516:1: rule__TestExpression__Group__6__Impl : ( ')' ) ;
    public final void rule__TestExpression__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2520:1: ( ( ')' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2521:1: ( ')' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2521:1: ( ')' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2522:1: ')'
            {
             before(grammarAccess.getTestExpressionAccess().getRightParenthesisKeyword_6()); 
            match(input,45,FOLLOW_45_in_rule__TestExpression__Group__6__Impl5256); 
             after(grammarAccess.getTestExpressionAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__6__Impl


    // $ANTLR start rule__TestExpression__Group__7
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2535:1: rule__TestExpression__Group__7 : rule__TestExpression__Group__7__Impl rule__TestExpression__Group__8 ;
    public final void rule__TestExpression__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2539:1: ( rule__TestExpression__Group__7__Impl rule__TestExpression__Group__8 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2540:2: rule__TestExpression__Group__7__Impl rule__TestExpression__Group__8
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__7__Impl_in_rule__TestExpression__Group__75287);
            rule__TestExpression__Group__7__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group__8_in_rule__TestExpression__Group__75290);
            rule__TestExpression__Group__8();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__7


    // $ANTLR start rule__TestExpression__Group__7__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2547:1: rule__TestExpression__Group__7__Impl : ( 'is' ) ;
    public final void rule__TestExpression__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2551:1: ( ( 'is' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2552:1: ( 'is' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2552:1: ( 'is' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2553:1: 'is'
            {
             before(grammarAccess.getTestExpressionAccess().getIsKeyword_7()); 
            match(input,46,FOLLOW_46_in_rule__TestExpression__Group__7__Impl5318); 
             after(grammarAccess.getTestExpressionAccess().getIsKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__7__Impl


    // $ANTLR start rule__TestExpression__Group__8
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2566:1: rule__TestExpression__Group__8 : rule__TestExpression__Group__8__Impl ;
    public final void rule__TestExpression__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2570:1: ( rule__TestExpression__Group__8__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2571:2: rule__TestExpression__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__TestExpression__Group__8__Impl_in_rule__TestExpression__Group__85349);
            rule__TestExpression__Group__8__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__8


    // $ANTLR start rule__TestExpression__Group__8__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2577:1: rule__TestExpression__Group__8__Impl : ( ( rule__TestExpression__ExpectedAssignment_8 ) ) ;
    public final void rule__TestExpression__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2581:1: ( ( ( rule__TestExpression__ExpectedAssignment_8 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2582:1: ( ( rule__TestExpression__ExpectedAssignment_8 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2582:1: ( ( rule__TestExpression__ExpectedAssignment_8 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2583:1: ( rule__TestExpression__ExpectedAssignment_8 )
            {
             before(grammarAccess.getTestExpressionAccess().getExpectedAssignment_8()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2584:1: ( rule__TestExpression__ExpectedAssignment_8 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2584:2: rule__TestExpression__ExpectedAssignment_8
            {
            pushFollow(FOLLOW_rule__TestExpression__ExpectedAssignment_8_in_rule__TestExpression__Group__8__Impl5376);
            rule__TestExpression__ExpectedAssignment_8();
            _fsp--;


            }

             after(grammarAccess.getTestExpressionAccess().getExpectedAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group__8__Impl


    // $ANTLR start rule__TestExpression__Group_2__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2612:1: rule__TestExpression__Group_2__0 : rule__TestExpression__Group_2__0__Impl rule__TestExpression__Group_2__1 ;
    public final void rule__TestExpression__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2616:1: ( rule__TestExpression__Group_2__0__Impl rule__TestExpression__Group_2__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2617:2: rule__TestExpression__Group_2__0__Impl rule__TestExpression__Group_2__1
            {
            pushFollow(FOLLOW_rule__TestExpression__Group_2__0__Impl_in_rule__TestExpression__Group_2__05424);
            rule__TestExpression__Group_2__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group_2__1_in_rule__TestExpression__Group_2__05427);
            rule__TestExpression__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_2__0


    // $ANTLR start rule__TestExpression__Group_2__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2624:1: rule__TestExpression__Group_2__0__Impl : ( '.' ) ;
    public final void rule__TestExpression__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2628:1: ( ( '.' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2629:1: ( '.' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2629:1: ( '.' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2630:1: '.'
            {
             before(grammarAccess.getTestExpressionAccess().getFullStopKeyword_2_0()); 
            match(input,48,FOLLOW_48_in_rule__TestExpression__Group_2__0__Impl5455); 
             after(grammarAccess.getTestExpressionAccess().getFullStopKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_2__0__Impl


    // $ANTLR start rule__TestExpression__Group_2__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2643:1: rule__TestExpression__Group_2__1 : rule__TestExpression__Group_2__1__Impl ;
    public final void rule__TestExpression__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2647:1: ( rule__TestExpression__Group_2__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2648:2: rule__TestExpression__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__TestExpression__Group_2__1__Impl_in_rule__TestExpression__Group_2__15486);
            rule__TestExpression__Group_2__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_2__1


    // $ANTLR start rule__TestExpression__Group_2__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2654:1: rule__TestExpression__Group_2__1__Impl : ( ( rule__TestExpression__PropertyAssignment_2_1 ) ) ;
    public final void rule__TestExpression__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2658:1: ( ( ( rule__TestExpression__PropertyAssignment_2_1 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2659:1: ( ( rule__TestExpression__PropertyAssignment_2_1 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2659:1: ( ( rule__TestExpression__PropertyAssignment_2_1 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2660:1: ( rule__TestExpression__PropertyAssignment_2_1 )
            {
             before(grammarAccess.getTestExpressionAccess().getPropertyAssignment_2_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2661:1: ( rule__TestExpression__PropertyAssignment_2_1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2661:2: rule__TestExpression__PropertyAssignment_2_1
            {
            pushFollow(FOLLOW_rule__TestExpression__PropertyAssignment_2_1_in_rule__TestExpression__Group_2__1__Impl5513);
            rule__TestExpression__PropertyAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getTestExpressionAccess().getPropertyAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_2__1__Impl


    // $ANTLR start rule__TestExpression__Group_5__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2675:1: rule__TestExpression__Group_5__0 : rule__TestExpression__Group_5__0__Impl rule__TestExpression__Group_5__1 ;
    public final void rule__TestExpression__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2679:1: ( rule__TestExpression__Group_5__0__Impl rule__TestExpression__Group_5__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2680:2: rule__TestExpression__Group_5__0__Impl rule__TestExpression__Group_5__1
            {
            pushFollow(FOLLOW_rule__TestExpression__Group_5__0__Impl_in_rule__TestExpression__Group_5__05547);
            rule__TestExpression__Group_5__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__TestExpression__Group_5__1_in_rule__TestExpression__Group_5__05550);
            rule__TestExpression__Group_5__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_5__0


    // $ANTLR start rule__TestExpression__Group_5__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2687:1: rule__TestExpression__Group_5__0__Impl : ( ',' ) ;
    public final void rule__TestExpression__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2691:1: ( ( ',' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2692:1: ( ',' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2692:1: ( ',' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2693:1: ','
            {
             before(grammarAccess.getTestExpressionAccess().getCommaKeyword_5_0()); 
            match(input,49,FOLLOW_49_in_rule__TestExpression__Group_5__0__Impl5578); 
             after(grammarAccess.getTestExpressionAccess().getCommaKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_5__0__Impl


    // $ANTLR start rule__TestExpression__Group_5__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2706:1: rule__TestExpression__Group_5__1 : rule__TestExpression__Group_5__1__Impl ;
    public final void rule__TestExpression__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2710:1: ( rule__TestExpression__Group_5__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2711:2: rule__TestExpression__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__TestExpression__Group_5__1__Impl_in_rule__TestExpression__Group_5__15609);
            rule__TestExpression__Group_5__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_5__1


    // $ANTLR start rule__TestExpression__Group_5__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2717:1: rule__TestExpression__Group_5__1__Impl : ( ( rule__TestExpression__ArgsAssignment_5_1 ) ) ;
    public final void rule__TestExpression__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2721:1: ( ( ( rule__TestExpression__ArgsAssignment_5_1 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2722:1: ( ( rule__TestExpression__ArgsAssignment_5_1 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2722:1: ( ( rule__TestExpression__ArgsAssignment_5_1 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2723:1: ( rule__TestExpression__ArgsAssignment_5_1 )
            {
             before(grammarAccess.getTestExpressionAccess().getArgsAssignment_5_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2724:1: ( rule__TestExpression__ArgsAssignment_5_1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2724:2: rule__TestExpression__ArgsAssignment_5_1
            {
            pushFollow(FOLLOW_rule__TestExpression__ArgsAssignment_5_1_in_rule__TestExpression__Group_5__1__Impl5636);
            rule__TestExpression__ArgsAssignment_5_1();
            _fsp--;


            }

             after(grammarAccess.getTestExpressionAccess().getArgsAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__Group_5__1__Impl


    // $ANTLR start rule__ConcatExpression__Group__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2738:1: rule__ConcatExpression__Group__0 : rule__ConcatExpression__Group__0__Impl rule__ConcatExpression__Group__1 ;
    public final void rule__ConcatExpression__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2742:1: ( rule__ConcatExpression__Group__0__Impl rule__ConcatExpression__Group__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2743:2: rule__ConcatExpression__Group__0__Impl rule__ConcatExpression__Group__1
            {
            pushFollow(FOLLOW_rule__ConcatExpression__Group__0__Impl_in_rule__ConcatExpression__Group__05670);
            rule__ConcatExpression__Group__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConcatExpression__Group__1_in_rule__ConcatExpression__Group__05673);
            rule__ConcatExpression__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group__0


    // $ANTLR start rule__ConcatExpression__Group__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2750:1: rule__ConcatExpression__Group__0__Impl : ( ruleStringExpression ) ;
    public final void rule__ConcatExpression__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2754:1: ( ( ruleStringExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2755:1: ( ruleStringExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2755:1: ( ruleStringExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2756:1: ruleStringExpression
            {
             before(grammarAccess.getConcatExpressionAccess().getStringExpressionParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStringExpression_in_rule__ConcatExpression__Group__0__Impl5700);
            ruleStringExpression();
            _fsp--;

             after(grammarAccess.getConcatExpressionAccess().getStringExpressionParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group__0__Impl


    // $ANTLR start rule__ConcatExpression__Group__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2767:1: rule__ConcatExpression__Group__1 : rule__ConcatExpression__Group__1__Impl ;
    public final void rule__ConcatExpression__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2771:1: ( rule__ConcatExpression__Group__1__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2772:2: rule__ConcatExpression__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ConcatExpression__Group__1__Impl_in_rule__ConcatExpression__Group__15729);
            rule__ConcatExpression__Group__1__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group__1


    // $ANTLR start rule__ConcatExpression__Group__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2778:1: rule__ConcatExpression__Group__1__Impl : ( ( rule__ConcatExpression__Group_1__0 )* ) ;
    public final void rule__ConcatExpression__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2782:1: ( ( ( rule__ConcatExpression__Group_1__0 )* ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2783:1: ( ( rule__ConcatExpression__Group_1__0 )* )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2783:1: ( ( rule__ConcatExpression__Group_1__0 )* )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2784:1: ( rule__ConcatExpression__Group_1__0 )*
            {
             before(grammarAccess.getConcatExpressionAccess().getGroup_1()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2785:1: ( rule__ConcatExpression__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==50) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2785:2: rule__ConcatExpression__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ConcatExpression__Group_1__0_in_rule__ConcatExpression__Group__1__Impl5756);
            	    rule__ConcatExpression__Group_1__0();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getConcatExpressionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group__1__Impl


    // $ANTLR start rule__ConcatExpression__Group_1__0
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2799:1: rule__ConcatExpression__Group_1__0 : rule__ConcatExpression__Group_1__0__Impl rule__ConcatExpression__Group_1__1 ;
    public final void rule__ConcatExpression__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2803:1: ( rule__ConcatExpression__Group_1__0__Impl rule__ConcatExpression__Group_1__1 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2804:2: rule__ConcatExpression__Group_1__0__Impl rule__ConcatExpression__Group_1__1
            {
            pushFollow(FOLLOW_rule__ConcatExpression__Group_1__0__Impl_in_rule__ConcatExpression__Group_1__05791);
            rule__ConcatExpression__Group_1__0__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConcatExpression__Group_1__1_in_rule__ConcatExpression__Group_1__05794);
            rule__ConcatExpression__Group_1__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group_1__0


    // $ANTLR start rule__ConcatExpression__Group_1__0__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2811:1: rule__ConcatExpression__Group_1__0__Impl : ( () ) ;
    public final void rule__ConcatExpression__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2815:1: ( ( () ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2816:1: ( () )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2816:1: ( () )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2817:1: ()
            {
             before(grammarAccess.getConcatExpressionAccess().getConcatExpressionLeftAction_1_0()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2818:1: ()
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2820:1: 
            {
            }

             after(grammarAccess.getConcatExpressionAccess().getConcatExpressionLeftAction_1_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group_1__0__Impl


    // $ANTLR start rule__ConcatExpression__Group_1__1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2830:1: rule__ConcatExpression__Group_1__1 : rule__ConcatExpression__Group_1__1__Impl rule__ConcatExpression__Group_1__2 ;
    public final void rule__ConcatExpression__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2834:1: ( rule__ConcatExpression__Group_1__1__Impl rule__ConcatExpression__Group_1__2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2835:2: rule__ConcatExpression__Group_1__1__Impl rule__ConcatExpression__Group_1__2
            {
            pushFollow(FOLLOW_rule__ConcatExpression__Group_1__1__Impl_in_rule__ConcatExpression__Group_1__15852);
            rule__ConcatExpression__Group_1__1__Impl();
            _fsp--;

            pushFollow(FOLLOW_rule__ConcatExpression__Group_1__2_in_rule__ConcatExpression__Group_1__15855);
            rule__ConcatExpression__Group_1__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group_1__1


    // $ANTLR start rule__ConcatExpression__Group_1__1__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2842:1: rule__ConcatExpression__Group_1__1__Impl : ( '+' ) ;
    public final void rule__ConcatExpression__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2846:1: ( ( '+' ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2847:1: ( '+' )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2847:1: ( '+' )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2848:1: '+'
            {
             before(grammarAccess.getConcatExpressionAccess().getPlusSignKeyword_1_1()); 
            match(input,50,FOLLOW_50_in_rule__ConcatExpression__Group_1__1__Impl5883); 
             after(grammarAccess.getConcatExpressionAccess().getPlusSignKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group_1__1__Impl


    // $ANTLR start rule__ConcatExpression__Group_1__2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2861:1: rule__ConcatExpression__Group_1__2 : rule__ConcatExpression__Group_1__2__Impl ;
    public final void rule__ConcatExpression__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2865:1: ( rule__ConcatExpression__Group_1__2__Impl )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2866:2: rule__ConcatExpression__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__ConcatExpression__Group_1__2__Impl_in_rule__ConcatExpression__Group_1__25914);
            rule__ConcatExpression__Group_1__2__Impl();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group_1__2


    // $ANTLR start rule__ConcatExpression__Group_1__2__Impl
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2872:1: rule__ConcatExpression__Group_1__2__Impl : ( ( rule__ConcatExpression__RightAssignment_1_2 ) ) ;
    public final void rule__ConcatExpression__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2876:1: ( ( ( rule__ConcatExpression__RightAssignment_1_2 ) ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2877:1: ( ( rule__ConcatExpression__RightAssignment_1_2 ) )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2877:1: ( ( rule__ConcatExpression__RightAssignment_1_2 ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2878:1: ( rule__ConcatExpression__RightAssignment_1_2 )
            {
             before(grammarAccess.getConcatExpressionAccess().getRightAssignment_1_2()); 
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2879:1: ( rule__ConcatExpression__RightAssignment_1_2 )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2879:2: rule__ConcatExpression__RightAssignment_1_2
            {
            pushFollow(FOLLOW_rule__ConcatExpression__RightAssignment_1_2_in_rule__ConcatExpression__Group_1__2__Impl5941);
            rule__ConcatExpression__RightAssignment_1_2();
            _fsp--;


            }

             after(grammarAccess.getConcatExpressionAccess().getRightAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__Group_1__2__Impl


    // $ANTLR start rule__OrExpression__RightAssignment_1_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2896:1: rule__OrExpression__RightAssignment_1_2 : ( ruleXorExpression ) ;
    public final void rule__OrExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2900:1: ( ( ruleXorExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2901:1: ( ruleXorExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2901:1: ( ruleXorExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2902:1: ruleXorExpression
            {
             before(grammarAccess.getOrExpressionAccess().getRightXorExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleXorExpression_in_rule__OrExpression__RightAssignment_1_25982);
            ruleXorExpression();
            _fsp--;

             after(grammarAccess.getOrExpressionAccess().getRightXorExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__OrExpression__RightAssignment_1_2


    // $ANTLR start rule__XorExpression__RightAssignment_1_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2911:1: rule__XorExpression__RightAssignment_1_2 : ( ruleAndExpression ) ;
    public final void rule__XorExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2915:1: ( ( ruleAndExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2916:1: ( ruleAndExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2916:1: ( ruleAndExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2917:1: ruleAndExpression
            {
             before(grammarAccess.getXorExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleAndExpression_in_rule__XorExpression__RightAssignment_1_26013);
            ruleAndExpression();
            _fsp--;

             after(grammarAccess.getXorExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__XorExpression__RightAssignment_1_2


    // $ANTLR start rule__AndExpression__RightAssignment_1_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2926:1: rule__AndExpression__RightAssignment_1_2 : ( ruleComparisonExpression ) ;
    public final void rule__AndExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2930:1: ( ( ruleComparisonExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2931:1: ( ruleComparisonExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2931:1: ( ruleComparisonExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2932:1: ruleComparisonExpression
            {
             before(grammarAccess.getAndExpressionAccess().getRightComparisonExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleComparisonExpression_in_rule__AndExpression__RightAssignment_1_26044);
            ruleComparisonExpression();
            _fsp--;

             after(grammarAccess.getAndExpressionAccess().getRightComparisonExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__AndExpression__RightAssignment_1_2


    // $ANTLR start rule__ComparisonExpression__OperatorAssignment_0_1_1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2941:1: rule__ComparisonExpression__OperatorAssignment_0_1_1 : ( ruleComparisonOperator ) ;
    public final void rule__ComparisonExpression__OperatorAssignment_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2945:1: ( ( ruleComparisonOperator ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2946:1: ( ruleComparisonOperator )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2946:1: ( ruleComparisonOperator )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2947:1: ruleComparisonOperator
            {
             before(grammarAccess.getComparisonExpressionAccess().getOperatorComparisonOperatorEnumRuleCall_0_1_1_0()); 
            pushFollow(FOLLOW_ruleComparisonOperator_in_rule__ComparisonExpression__OperatorAssignment_0_1_16075);
            ruleComparisonOperator();
            _fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getOperatorComparisonOperatorEnumRuleCall_0_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__OperatorAssignment_0_1_1


    // $ANTLR start rule__ComparisonExpression__RightAssignment_0_1_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2956:1: rule__ComparisonExpression__RightAssignment_0_1_2 : ( rulePrimaryExpression ) ;
    public final void rule__ComparisonExpression__RightAssignment_0_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2960:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2961:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2961:1: ( rulePrimaryExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2962:1: rulePrimaryExpression
            {
             before(grammarAccess.getComparisonExpressionAccess().getRightPrimaryExpressionParserRuleCall_0_1_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__ComparisonExpression__RightAssignment_0_1_26106);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getRightPrimaryExpressionParserRuleCall_0_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__RightAssignment_0_1_2


    // $ANTLR start rule__ComparisonExpression__OperatorAssignment_1_1_1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2971:1: rule__ComparisonExpression__OperatorAssignment_1_1_1 : ( ruleStringOperator ) ;
    public final void rule__ComparisonExpression__OperatorAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2975:1: ( ( ruleStringOperator ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2976:1: ( ruleStringOperator )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2976:1: ( ruleStringOperator )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2977:1: ruleStringOperator
            {
             before(grammarAccess.getComparisonExpressionAccess().getOperatorStringOperatorEnumRuleCall_1_1_1_0()); 
            pushFollow(FOLLOW_ruleStringOperator_in_rule__ComparisonExpression__OperatorAssignment_1_1_16137);
            ruleStringOperator();
            _fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getOperatorStringOperatorEnumRuleCall_1_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__OperatorAssignment_1_1_1


    // $ANTLR start rule__ComparisonExpression__RightAssignment_1_1_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2986:1: rule__ComparisonExpression__RightAssignment_1_1_2 : ( ruleConcatExpression ) ;
    public final void rule__ComparisonExpression__RightAssignment_1_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2990:1: ( ( ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2991:1: ( ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2991:1: ( ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:2992:1: ruleConcatExpression
            {
             before(grammarAccess.getComparisonExpressionAccess().getRightConcatExpressionParserRuleCall_1_1_2_0()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_rule__ComparisonExpression__RightAssignment_1_1_26168);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getComparisonExpressionAccess().getRightConcatExpressionParserRuleCall_1_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ComparisonExpression__RightAssignment_1_1_2


    // $ANTLR start rule__BooleanLiteral__ValueAssignment
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3001:1: rule__BooleanLiteral__ValueAssignment : ( RULE_BOOLEAN ) ;
    public final void rule__BooleanLiteral__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3005:1: ( ( RULE_BOOLEAN ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3006:1: ( RULE_BOOLEAN )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3006:1: ( RULE_BOOLEAN )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3007:1: RULE_BOOLEAN
            {
             before(grammarAccess.getBooleanLiteralAccess().getValueBOOLEANTerminalRuleCall_0()); 
            match(input,RULE_BOOLEAN,FOLLOW_RULE_BOOLEAN_in_rule__BooleanLiteral__ValueAssignment6199); 
             after(grammarAccess.getBooleanLiteralAccess().getValueBOOLEANTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__BooleanLiteral__ValueAssignment


    // $ANTLR start rule__NotExpression__RightAssignment_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3016:1: rule__NotExpression__RightAssignment_2 : ( rulePrimaryExpression ) ;
    public final void rule__NotExpression__RightAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3020:1: ( ( rulePrimaryExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3021:1: ( rulePrimaryExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3021:1: ( rulePrimaryExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3022:1: rulePrimaryExpression
            {
             before(grammarAccess.getNotExpressionAccess().getRightPrimaryExpressionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_rulePrimaryExpression_in_rule__NotExpression__RightAssignment_26230);
            rulePrimaryExpression();
            _fsp--;

             after(grammarAccess.getNotExpressionAccess().getRightPrimaryExpressionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__NotExpression__RightAssignment_2


    // $ANTLR start rule__IsExpression__TypeAssignment_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3031:1: rule__IsExpression__TypeAssignment_2 : ( ruleType ) ;
    public final void rule__IsExpression__TypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3035:1: ( ( ruleType ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3036:1: ( ruleType )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3036:1: ( ruleType )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3037:1: ruleType
            {
             before(grammarAccess.getIsExpressionAccess().getTypeTypeEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__IsExpression__TypeAssignment_26261);
            ruleType();
            _fsp--;

             after(grammarAccess.getIsExpressionAccess().getTypeTypeEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__IsExpression__TypeAssignment_2


    // $ANTLR start rule__HasExpression__KindAssignment_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3046:1: rule__HasExpression__KindAssignment_2 : ( ruleKind ) ;
    public final void rule__HasExpression__KindAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3050:1: ( ( ruleKind ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3051:1: ( ruleKind )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3051:1: ( ruleKind )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3052:1: ruleKind
            {
             before(grammarAccess.getHasExpressionAccess().getKindKindEnumRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleKind_in_rule__HasExpression__KindAssignment_26292);
            ruleKind();
            _fsp--;

             after(grammarAccess.getHasExpressionAccess().getKindKindEnumRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__KindAssignment_2


    // $ANTLR start rule__HasExpression__WhatAssignment_3
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3061:1: rule__HasExpression__WhatAssignment_3 : ( ruleConcatExpression ) ;
    public final void rule__HasExpression__WhatAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3065:1: ( ( ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3066:1: ( ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3066:1: ( ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3067:1: ruleConcatExpression
            {
             before(grammarAccess.getHasExpressionAccess().getWhatConcatExpressionParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_rule__HasExpression__WhatAssignment_36323);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getHasExpressionAccess().getWhatConcatExpressionParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__HasExpression__WhatAssignment_3


    // $ANTLR start rule__TestExpression__PropertyAssignment_1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3076:1: rule__TestExpression__PropertyAssignment_1 : ( RULE_ID ) ;
    public final void rule__TestExpression__PropertyAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3080:1: ( ( RULE_ID ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3081:1: ( RULE_ID )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3081:1: ( RULE_ID )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3082:1: RULE_ID
            {
             before(grammarAccess.getTestExpressionAccess().getPropertyIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TestExpression__PropertyAssignment_16354); 
             after(grammarAccess.getTestExpressionAccess().getPropertyIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__PropertyAssignment_1


    // $ANTLR start rule__TestExpression__PropertyAssignment_2_1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3091:1: rule__TestExpression__PropertyAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__TestExpression__PropertyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3095:1: ( ( RULE_ID ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3096:1: ( RULE_ID )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3096:1: ( RULE_ID )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3097:1: RULE_ID
            {
             before(grammarAccess.getTestExpressionAccess().getPropertyIDTerminalRuleCall_2_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__TestExpression__PropertyAssignment_2_16385); 
             after(grammarAccess.getTestExpressionAccess().getPropertyIDTerminalRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__PropertyAssignment_2_1


    // $ANTLR start rule__TestExpression__ArgsAssignment_4
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3106:1: rule__TestExpression__ArgsAssignment_4 : ( ruleConcatExpression ) ;
    public final void rule__TestExpression__ArgsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3110:1: ( ( ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3111:1: ( ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3111:1: ( ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3112:1: ruleConcatExpression
            {
             before(grammarAccess.getTestExpressionAccess().getArgsConcatExpressionParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_rule__TestExpression__ArgsAssignment_46416);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getTestExpressionAccess().getArgsConcatExpressionParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__ArgsAssignment_4


    // $ANTLR start rule__TestExpression__ArgsAssignment_5_1
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3121:1: rule__TestExpression__ArgsAssignment_5_1 : ( ruleConcatExpression ) ;
    public final void rule__TestExpression__ArgsAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3125:1: ( ( ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3126:1: ( ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3126:1: ( ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3127:1: ruleConcatExpression
            {
             before(grammarAccess.getTestExpressionAccess().getArgsConcatExpressionParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_rule__TestExpression__ArgsAssignment_5_16447);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getTestExpressionAccess().getArgsConcatExpressionParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__ArgsAssignment_5_1


    // $ANTLR start rule__TestExpression__ExpectedAssignment_8
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3136:1: rule__TestExpression__ExpectedAssignment_8 : ( ruleConcatExpression ) ;
    public final void rule__TestExpression__ExpectedAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3140:1: ( ( ruleConcatExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3141:1: ( ruleConcatExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3141:1: ( ruleConcatExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3142:1: ruleConcatExpression
            {
             before(grammarAccess.getTestExpressionAccess().getExpectedConcatExpressionParserRuleCall_8_0()); 
            pushFollow(FOLLOW_ruleConcatExpression_in_rule__TestExpression__ExpectedAssignment_86478);
            ruleConcatExpression();
            _fsp--;

             after(grammarAccess.getTestExpressionAccess().getExpectedConcatExpressionParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__TestExpression__ExpectedAssignment_8


    // $ANTLR start rule__ConcatExpression__RightAssignment_1_2
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3151:1: rule__ConcatExpression__RightAssignment_1_2 : ( ruleStringExpression ) ;
    public final void rule__ConcatExpression__RightAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3155:1: ( ( ruleStringExpression ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3156:1: ( ruleStringExpression )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3156:1: ( ruleStringExpression )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3157:1: ruleStringExpression
            {
             before(grammarAccess.getConcatExpressionAccess().getRightStringExpressionParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruleStringExpression_in_rule__ConcatExpression__RightAssignment_1_26509);
            ruleStringExpression();
            _fsp--;

             after(grammarAccess.getConcatExpressionAccess().getRightStringExpressionParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__ConcatExpression__RightAssignment_1_2


    // $ANTLR start rule__StringLiteral__ValueAssignment
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3166:1: rule__StringLiteral__ValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringLiteral__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3170:1: ( ( RULE_STRING ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3171:1: ( RULE_STRING )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3171:1: ( RULE_STRING )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3172:1: RULE_STRING
            {
             before(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment6540); 
             after(grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__StringLiteral__ValueAssignment


    // $ANTLR start rule__PropertyAccess__PropertyAssignment
    // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3181:1: rule__PropertyAccess__PropertyAssignment : ( RULE_ID ) ;
    public final void rule__PropertyAccess__PropertyAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3185:1: ( ( RULE_ID ) )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3186:1: ( RULE_ID )
            {
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3186:1: ( RULE_ID )
            // ../org.eclipse.net4j.tools.workingset.ui/src-gen/org/eclipse/net4j/tools/workingset/ui/contentassist/antlr/internal/InternalDsl.g:3187:1: RULE_ID
            {
             before(grammarAccess.getPropertyAccessAccess().getPropertyIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__PropertyAccess__PropertyAssignment6571); 
             after(grammarAccess.getPropertyAccessAccess().getPropertyIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__PropertyAccess__PropertyAssignment


 

    public static final BitSet FOLLOW_ruleBooleanExpression_in_entryRuleBooleanExpression61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanExpression68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_ruleBooleanExpression94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_entryRuleOrExpression120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrExpression127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__0_in_ruleOrExpression153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorExpression_in_entryRuleXorExpression180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXorExpression187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group__0_in_ruleXorExpression213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_entryRuleAndExpression240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndExpression247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__0_in_ruleAndExpression273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonExpression_in_entryRuleComparisonExpression300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleComparisonExpression307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Alternatives_in_ruleComparisonExpression333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_entryRulePrimaryExpression360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpression367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Alternatives_in_rulePrimaryExpression393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_entryRuleBooleanLiteral420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteral427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanLiteral__ValueAssignment_in_ruleBooleanLiteral453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotExpression_in_entryRuleNotExpression480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotExpression487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotExpression__Group__0_in_ruleNotExpression513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsExpression_in_entryRuleIsExpression540 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsExpression547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IsExpression__Group__0_in_ruleIsExpression573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHasExpression_in_entryRuleHasExpression600 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleHasExpression607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__0_in_ruleHasExpression633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestExpression_in_entryRuleTestExpression660 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestExpression667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__0_in_ruleTestExpression693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_entryRuleConcatExpression720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConcatExpression727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group__0_in_ruleConcatExpression753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_entryRuleStringExpression780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringExpression787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringExpression__Alternatives_in_ruleStringExpression813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_entryRuleStringLiteral840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteral847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringLiteral__ValueAssignment_in_ruleStringLiteral873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAccess_in_entryRulePropertyAccess900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePropertyAccess907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PropertyAccess__PropertyAssignment_in_rulePropertyAccess933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperator_in_entryRuleOrOperator960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOrOperator967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrOperator__Alternatives_in_ruleOrOperator993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorOperator_in_entryRuleXorOperator1020 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXorOperator1027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorOperator__Alternatives_in_ruleXorOperator1053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperator_in_entryRuleAndOperator1080 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAndOperator1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndOperator__Alternatives_in_ruleAndOperator1113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperator_in_entryRuleNotOperator1140 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNotOperator1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotOperator__Alternatives_in_ruleNotOperator1173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonOperator__Alternatives_in_ruleComparisonOperator1210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringOperator__Alternatives_in_ruleStringOperator1246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType1282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Kind__Alternatives_in_ruleKind1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0__0_in_rule__ComparisonExpression__Alternatives1353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1__0_in_rule__ComparisonExpression__Alternatives1371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteral_in_rule__PrimaryExpression__Alternatives1404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotExpression_in_rule__PrimaryExpression__Alternatives1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsExpression_in_rule__PrimaryExpression__Alternatives1438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleHasExpression_in_rule__PrimaryExpression__Alternatives1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestExpression_in_rule__PrimaryExpression__Alternatives1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_5__0_in_rule__PrimaryExpression__Alternatives1489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteral_in_rule__StringExpression__Alternatives1522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePropertyAccess_in_rule__StringExpression__Alternatives1539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__OrOperator__Alternatives1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__OrOperator__Alternatives1592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__OrOperator__Alternatives1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XorOperator__Alternatives1647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__XorOperator__Alternatives1667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__AndOperator__Alternatives1702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__AndOperator__Alternatives1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__AndOperator__Alternatives1742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__NotOperator__Alternatives1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__NotOperator__Alternatives1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ComparisonOperator__Alternatives1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ComparisonOperator__Alternatives1853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ComparisonOperator__Alternatives1874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ComparisonOperator__Alternatives1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__ComparisonOperator__Alternatives1916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__ComparisonOperator__Alternatives1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ComparisonOperator__Alternatives1958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ComparisonOperator__Alternatives1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__StringOperator__Alternatives2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__StringOperator__Alternatives2036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__StringOperator__Alternatives2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__StringOperator__Alternatives2078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__StringOperator__Alternatives2099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__StringOperator__Alternatives2120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__StringOperator__Alternatives2141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__StringOperator__Alternatives2162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__StringOperator__Alternatives2183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__StringOperator__Alternatives2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__StringOperator__Alternatives2225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__StringOperator__Alternatives2246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__StringOperator__Alternatives2267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__StringOperator__Alternatives2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__StringOperator__Alternatives2309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Type__Alternatives2345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Type__Alternatives2366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Type__Alternatives2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Type__Alternatives2408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Kind__Alternatives2444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__Kind__Alternatives2465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__Kind__Alternatives2486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__0__Impl_in_rule__OrExpression__Group__02519 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__1_in_rule__OrExpression__Group__02522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorExpression_in_rule__OrExpression__Group__0__Impl2549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group__1__Impl_in_rule__OrExpression__Group__12578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__0_in_rule__OrExpression__Group__1__Impl2605 = new BitSet(new long[]{0x0000000000007002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__0__Impl_in_rule__OrExpression__Group_1__02640 = new BitSet(new long[]{0x0000000000007000L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__1_in_rule__OrExpression__Group_1__02643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__1__Impl_in_rule__OrExpression__Group_1__12701 = new BitSet(new long[]{0x0000D00000300070L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__2_in_rule__OrExpression__Group_1__12704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrOperator_in_rule__OrExpression__Group_1__1__Impl2731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__Group_1__2__Impl_in_rule__OrExpression__Group_1__22760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__OrExpression__RightAssignment_1_2_in_rule__OrExpression__Group_1__2__Impl2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group__0__Impl_in_rule__XorExpression__Group__02823 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group__1_in_rule__XorExpression__Group__02826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_rule__XorExpression__Group__0__Impl2853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group__1__Impl_in_rule__XorExpression__Group__12882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group_1__0_in_rule__XorExpression__Group__1__Impl2909 = new BitSet(new long[]{0x0000000000018002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group_1__0__Impl_in_rule__XorExpression__Group_1__02944 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__XorExpression__Group_1__1_in_rule__XorExpression__Group_1__02947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group_1__1__Impl_in_rule__XorExpression__Group_1__13005 = new BitSet(new long[]{0x0000D00000300070L});
    public static final BitSet FOLLOW_rule__XorExpression__Group_1__2_in_rule__XorExpression__Group_1__13008 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorOperator_in_rule__XorExpression__Group_1__1__Impl3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__Group_1__2__Impl_in_rule__XorExpression__Group_1__23064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XorExpression__RightAssignment_1_2_in_rule__XorExpression__Group_1__2__Impl3091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__0__Impl_in_rule__AndExpression__Group__03127 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__1_in_rule__AndExpression__Group__03130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonExpression_in_rule__AndExpression__Group__0__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group__1__Impl_in_rule__AndExpression__Group__13186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__0_in_rule__AndExpression__Group__1__Impl3213 = new BitSet(new long[]{0x00000000000E0002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__0__Impl_in_rule__AndExpression__Group_1__03248 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__1_in_rule__AndExpression__Group_1__03251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__1__Impl_in_rule__AndExpression__Group_1__13309 = new BitSet(new long[]{0x0000D00000300070L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__2_in_rule__AndExpression__Group_1__13312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndOperator_in_rule__AndExpression__Group_1__1__Impl3339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__Group_1__2__Impl_in_rule__AndExpression__Group_1__23368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AndExpression__RightAssignment_1_2_in_rule__AndExpression__Group_1__2__Impl3395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0__0__Impl_in_rule__ComparisonExpression__Group_0__03431 = new BitSet(new long[]{0x000000003FC00002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0__1_in_rule__ComparisonExpression__Group_0__03434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__ComparisonExpression__Group_0__0__Impl3461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0__1__Impl_in_rule__ComparisonExpression__Group_0__13490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0_1__0_in_rule__ComparisonExpression__Group_0__1__Impl3517 = new BitSet(new long[]{0x000000003FC00002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0_1__0__Impl_in_rule__ComparisonExpression__Group_0_1__03552 = new BitSet(new long[]{0x000000003FC00000L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0_1__1_in_rule__ComparisonExpression__Group_0_1__03555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0_1__1__Impl_in_rule__ComparisonExpression__Group_0_1__13613 = new BitSet(new long[]{0x0000D00000300030L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0_1__2_in_rule__ComparisonExpression__Group_0_1__13616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__OperatorAssignment_0_1_1_in_rule__ComparisonExpression__Group_0_1__1__Impl3643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_0_1__2__Impl_in_rule__ComparisonExpression__Group_0_1__23673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__RightAssignment_0_1_2_in_rule__ComparisonExpression__Group_0_1__2__Impl3700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1__0__Impl_in_rule__ComparisonExpression__Group_1__03736 = new BitSet(new long[]{0x0000001FFFC00000L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1__1_in_rule__ComparisonExpression__Group_1__03739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_rule__ComparisonExpression__Group_1__0__Impl3766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1__1__Impl_in_rule__ComparisonExpression__Group_1__13795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__0_in_rule__ComparisonExpression__Group_1__1__Impl3824 = new BitSet(new long[]{0x0000001FFFC00002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__0_in_rule__ComparisonExpression__Group_1__1__Impl3836 = new BitSet(new long[]{0x0000001FFFC00002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__0__Impl_in_rule__ComparisonExpression__Group_1_1__03873 = new BitSet(new long[]{0x0000001FFFC00000L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__1_in_rule__ComparisonExpression__Group_1_1__03876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__1__Impl_in_rule__ComparisonExpression__Group_1_1__13934 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__2_in_rule__ComparisonExpression__Group_1_1__13937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__OperatorAssignment_1_1_1_in_rule__ComparisonExpression__Group_1_1__1__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__Group_1_1__2__Impl_in_rule__ComparisonExpression__Group_1_1__23994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ComparisonExpression__RightAssignment_1_1_2_in_rule__ComparisonExpression__Group_1_1__2__Impl4021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_5__0__Impl_in_rule__PrimaryExpression__Group_5__04057 = new BitSet(new long[]{0x0000D00000300070L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_5__1_in_rule__PrimaryExpression__Group_5__04060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__PrimaryExpression__Group_5__0__Impl4088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_5__1__Impl_in_rule__PrimaryExpression__Group_5__14119 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_5__2_in_rule__PrimaryExpression__Group_5__14122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOrExpression_in_rule__PrimaryExpression__Group_5__1__Impl4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimaryExpression__Group_5__2__Impl_in_rule__PrimaryExpression__Group_5__24178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__PrimaryExpression__Group_5__2__Impl4206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotExpression__Group__0__Impl_in_rule__NotExpression__Group__04243 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_rule__NotExpression__Group__1_in_rule__NotExpression__Group__04246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotExpression__Group__1__Impl_in_rule__NotExpression__Group__14304 = new BitSet(new long[]{0x0000D00000300030L});
    public static final BitSet FOLLOW_rule__NotExpression__Group__2_in_rule__NotExpression__Group__14307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNotOperator_in_rule__NotExpression__Group__1__Impl4334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotExpression__Group__2__Impl_in_rule__NotExpression__Group__24363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NotExpression__RightAssignment_2_in_rule__NotExpression__Group__2__Impl4390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IsExpression__Group__0__Impl_in_rule__IsExpression__Group__04426 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__IsExpression__Group__1_in_rule__IsExpression__Group__04429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IsExpression__Group__1__Impl_in_rule__IsExpression__Group__14487 = new BitSet(new long[]{0x000001E000000000L});
    public static final BitSet FOLLOW_rule__IsExpression__Group__2_in_rule__IsExpression__Group__14490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__IsExpression__Group__1__Impl4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IsExpression__Group__2__Impl_in_rule__IsExpression__Group__24549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IsExpression__TypeAssignment_2_in_rule__IsExpression__Group__2__Impl4576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__0__Impl_in_rule__HasExpression__Group__04612 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__1_in_rule__HasExpression__Group__04615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__1__Impl_in_rule__HasExpression__Group__14673 = new BitSet(new long[]{0x00000E0000000000L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__2_in_rule__HasExpression__Group__14676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__HasExpression__Group__1__Impl4704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__2__Impl_in_rule__HasExpression__Group__24735 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__3_in_rule__HasExpression__Group__24738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__KindAssignment_2_in_rule__HasExpression__Group__2__Impl4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__Group__3__Impl_in_rule__HasExpression__Group__34795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__HasExpression__WhatAssignment_3_in_rule__HasExpression__Group__3__Impl4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__0__Impl_in_rule__TestExpression__Group__04860 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__1_in_rule__TestExpression__Group__04863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__1__Impl_in_rule__TestExpression__Group__14921 = new BitSet(new long[]{0x0001100000000000L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__2_in_rule__TestExpression__Group__14924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__PropertyAssignment_1_in_rule__TestExpression__Group__1__Impl4951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__2__Impl_in_rule__TestExpression__Group__24981 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__3_in_rule__TestExpression__Group__24984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_2__0_in_rule__TestExpression__Group__2__Impl5011 = new BitSet(new long[]{0x0001000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__3__Impl_in_rule__TestExpression__Group__35042 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__4_in_rule__TestExpression__Group__35045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__TestExpression__Group__3__Impl5073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__4__Impl_in_rule__TestExpression__Group__45104 = new BitSet(new long[]{0x0002200000000000L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__5_in_rule__TestExpression__Group__45107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__ArgsAssignment_4_in_rule__TestExpression__Group__4__Impl5134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__5__Impl_in_rule__TestExpression__Group__55164 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__6_in_rule__TestExpression__Group__55167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_5__0_in_rule__TestExpression__Group__5__Impl5194 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__6__Impl_in_rule__TestExpression__Group__65225 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__7_in_rule__TestExpression__Group__65228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__TestExpression__Group__6__Impl5256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__7__Impl_in_rule__TestExpression__Group__75287 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__8_in_rule__TestExpression__Group__75290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__TestExpression__Group__7__Impl5318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group__8__Impl_in_rule__TestExpression__Group__85349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__ExpectedAssignment_8_in_rule__TestExpression__Group__8__Impl5376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_2__0__Impl_in_rule__TestExpression__Group_2__05424 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_2__1_in_rule__TestExpression__Group_2__05427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__TestExpression__Group_2__0__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_2__1__Impl_in_rule__TestExpression__Group_2__15486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__PropertyAssignment_2_1_in_rule__TestExpression__Group_2__1__Impl5513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_5__0__Impl_in_rule__TestExpression__Group_5__05547 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_5__1_in_rule__TestExpression__Group_5__05550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rule__TestExpression__Group_5__0__Impl5578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__Group_5__1__Impl_in_rule__TestExpression__Group_5__15609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestExpression__ArgsAssignment_5_1_in_rule__TestExpression__Group_5__1__Impl5636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group__0__Impl_in_rule__ConcatExpression__Group__05670 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group__1_in_rule__ConcatExpression__Group__05673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_rule__ConcatExpression__Group__0__Impl5700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group__1__Impl_in_rule__ConcatExpression__Group__15729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group_1__0_in_rule__ConcatExpression__Group__1__Impl5756 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group_1__0__Impl_in_rule__ConcatExpression__Group_1__05791 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group_1__1_in_rule__ConcatExpression__Group_1__05794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group_1__1__Impl_in_rule__ConcatExpression__Group_1__15852 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group_1__2_in_rule__ConcatExpression__Group_1__15855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rule__ConcatExpression__Group_1__1__Impl5883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__Group_1__2__Impl_in_rule__ConcatExpression__Group_1__25914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConcatExpression__RightAssignment_1_2_in_rule__ConcatExpression__Group_1__2__Impl5941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXorExpression_in_rule__OrExpression__RightAssignment_1_25982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAndExpression_in_rule__XorExpression__RightAssignment_1_26013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonExpression_in_rule__AndExpression__RightAssignment_1_26044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleComparisonOperator_in_rule__ComparisonExpression__OperatorAssignment_0_1_16075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__ComparisonExpression__RightAssignment_0_1_26106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringOperator_in_rule__ComparisonExpression__OperatorAssignment_1_1_16137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_rule__ComparisonExpression__RightAssignment_1_1_26168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_in_rule__BooleanLiteral__ValueAssignment6199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpression_in_rule__NotExpression__RightAssignment_26230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__IsExpression__TypeAssignment_26261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKind_in_rule__HasExpression__KindAssignment_26292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_rule__HasExpression__WhatAssignment_36323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TestExpression__PropertyAssignment_16354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__TestExpression__PropertyAssignment_2_16385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_rule__TestExpression__ArgsAssignment_46416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_rule__TestExpression__ArgsAssignment_5_16447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConcatExpression_in_rule__TestExpression__ExpectedAssignment_86478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringExpression_in_rule__ConcatExpression__RightAssignment_1_26509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringLiteral__ValueAssignment6540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__PropertyAccess__PropertyAssignment6571 = new BitSet(new long[]{0x0000000000000002L});

}