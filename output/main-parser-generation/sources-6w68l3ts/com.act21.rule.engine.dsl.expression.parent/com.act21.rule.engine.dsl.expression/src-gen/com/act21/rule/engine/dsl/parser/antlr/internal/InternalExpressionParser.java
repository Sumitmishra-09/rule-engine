package com.act21.rule.engine.dsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import com.act21.rule.engine.dsl.services.ExpressionGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalExpressionParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_BOOL", "RULE_BIGINT", "RULE_DATE", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'let'", "'function'", "'('", "','", "')'", "':'", "'{'", "'}'", "'<'", "'>'", "'class'", "'assign'", "'...'", "'if'", "']'", "'['", "'-'", "'PASS'", "'ALL'", "'null'", "'.'", "'&&'", "'||'", "'!'", "'<='", "'>='", "'=='", "'!='", "'upto'", "'+'", "'*'", "'/'", "'%'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int RULE_DATE=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=9;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=10;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_BIGINT=6;
    public static final int RULE_STRING=8;
    public static final int RULE_SL_COMMENT=11;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=12;
    public static final int RULE_ANY_OTHER=13;
    public static final int RULE_BOOL=5;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalExpressionParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalExpressionParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalExpressionParser.tokenNames; }
    public String getGrammarFileName() { return "InternalExpression.g"; }



     	private ExpressionGrammarAccess grammarAccess;

        public InternalExpressionParser(TokenStream input, ExpressionGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected ExpressionGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalExpression.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalExpression.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalExpression.g:66:2: iv_ruleModel= ruleModel EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModelRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModel; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalExpression.g:72:1: ruleModel returns [EObject current=null] : ( (lv_statements_0_0= ruleStatement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:78:2: ( ( (lv_statements_0_0= ruleStatement ) )* )
            // InternalExpression.g:79:2: ( (lv_statements_0_0= ruleStatement ) )*
            {
            // InternalExpression.g:79:2: ( (lv_statements_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_ID||(LA1_0>=14 && LA1_0<=15)||(LA1_0>=24 && LA1_0<=27)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExpression.g:80:3: (lv_statements_0_0= ruleStatement )
            	    {
            	    // InternalExpression.g:80:3: (lv_statements_0_0= ruleStatement )
            	    // InternalExpression.g:81:4: lv_statements_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0());
            	      			
            	    }
            	    pushFollow(FOLLOW_3);
            	    lv_statements_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				if (current==null) {
            	      					current = createModelElementForParent(grammarAccess.getModelRule());
            	      				}
            	      				add(
            	      					current,
            	      					"statements",
            	      					lv_statements_0_0,
            	      					"com.act21.rule.engine.dsl.Expression.Statement");
            	      				afterParserOrEnumRuleCall();
            	      			
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleStatement"
    // InternalExpression.g:101:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalExpression.g:101:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalExpression.g:102:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalExpression.g:108:1: ruleStatement returns [EObject current=null] : (this_NamedElement_0= ruleNamedElement | this_Assign_1= ruleAssign | this_Decide_2= ruleDecide ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_NamedElement_0 = null;

        EObject this_Assign_1 = null;

        EObject this_Decide_2 = null;



        	enterRule();

        try {
            // InternalExpression.g:114:2: ( (this_NamedElement_0= ruleNamedElement | this_Assign_1= ruleAssign | this_Decide_2= ruleDecide ) )
            // InternalExpression.g:115:2: (this_NamedElement_0= ruleNamedElement | this_Assign_1= ruleAssign | this_Decide_2= ruleDecide )
            {
            // InternalExpression.g:115:2: (this_NamedElement_0= ruleNamedElement | this_Assign_1= ruleAssign | this_Decide_2= ruleDecide )
            int alt2=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
            case 14:
            case 15:
            case 24:
            case 26:
                {
                alt2=1;
                }
                break;
            case 25:
                {
                alt2=2;
                }
                break;
            case 27:
                {
                alt2=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalExpression.g:116:3: this_NamedElement_0= ruleNamedElement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getNamedElementParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NamedElement_0=ruleNamedElement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NamedElement_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:125:3: this_Assign_1= ruleAssign
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getAssignParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Assign_1=ruleAssign();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Assign_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:134:3: this_Decide_2= ruleDecide
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getDecideParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Decide_2=ruleDecide();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Decide_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleNamedElement"
    // InternalExpression.g:146:1: entryRuleNamedElement returns [EObject current=null] : iv_ruleNamedElement= ruleNamedElement EOF ;
    public final EObject entryRuleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedElement = null;


        try {
            // InternalExpression.g:146:53: (iv_ruleNamedElement= ruleNamedElement EOF )
            // InternalExpression.g:147:2: iv_ruleNamedElement= ruleNamedElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNamedElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNamedElement=ruleNamedElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNamedElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNamedElement"


    // $ANTLR start "ruleNamedElement"
    // InternalExpression.g:153:1: ruleNamedElement returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_FunctionDeclaration_1= ruleFunctionDeclaration | this_Class_2= ruleClass | this_Parameter_3= ruleParameter ) ;
    public final EObject ruleNamedElement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_FunctionDeclaration_1 = null;

        EObject this_Class_2 = null;

        EObject this_Parameter_3 = null;



        	enterRule();

        try {
            // InternalExpression.g:159:2: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_FunctionDeclaration_1= ruleFunctionDeclaration | this_Class_2= ruleClass | this_Parameter_3= ruleParameter ) )
            // InternalExpression.g:160:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_FunctionDeclaration_1= ruleFunctionDeclaration | this_Class_2= ruleClass | this_Parameter_3= ruleParameter )
            {
            // InternalExpression.g:160:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_FunctionDeclaration_1= ruleFunctionDeclaration | this_Class_2= ruleClass | this_Parameter_3= ruleParameter )
            int alt3=4;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt3=1;
                }
                break;
            case 15:
                {
                alt3=2;
                }
                break;
            case 24:
                {
                alt3=3;
                }
                break;
            case RULE_ID:
            case 26:
                {
                alt3=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalExpression.g:161:3: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamedElementAccess().getVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:170:3: this_FunctionDeclaration_1= ruleFunctionDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamedElementAccess().getFunctionDeclarationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionDeclaration_1=ruleFunctionDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionDeclaration_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:179:3: this_Class_2= ruleClass
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamedElementAccess().getClassParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Class_2=ruleClass();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Class_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:188:3: this_Parameter_3= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNamedElementAccess().getParameterParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Parameter_3=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Parameter_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNamedElement"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalExpression.g:200:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalExpression.g:200:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalExpression.g:201:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalExpression.g:207:1: ruleVariableDeclaration returns [EObject current=null] : (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleTypeReference ) ) ( (lv_values_3_0= ruleArrayExpression ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_type_2_0 = null;

        EObject lv_values_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:213:2: ( (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleTypeReference ) ) ( (lv_values_3_0= ruleArrayExpression ) ) ) )
            // InternalExpression.g:214:2: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleTypeReference ) ) ( (lv_values_3_0= ruleArrayExpression ) ) )
            {
            // InternalExpression.g:214:2: (otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleTypeReference ) ) ( (lv_values_3_0= ruleArrayExpression ) ) )
            // InternalExpression.g:215:3: otherlv_0= 'let' ( (lv_name_1_0= RULE_ID ) ) ( (lv_type_2_0= ruleTypeReference ) ) ( (lv_values_3_0= ruleArrayExpression ) )
            {
            otherlv_0=(Token)match(input,14,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVariableDeclarationAccess().getLetKeyword_0());
              		
            }
            // InternalExpression.g:219:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExpression.g:220:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExpression.g:220:4: (lv_name_1_0= RULE_ID )
            // InternalExpression.g:221:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalExpression.g:237:3: ( (lv_type_2_0= ruleTypeReference ) )
            // InternalExpression.g:238:4: (lv_type_2_0= ruleTypeReference )
            {
            // InternalExpression.g:238:4: (lv_type_2_0= ruleTypeReference )
            // InternalExpression.g:239:5: lv_type_2_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeReferenceParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_6);
            lv_type_2_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"com.act21.rule.engine.dsl.Expression.TypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:256:3: ( (lv_values_3_0= ruleArrayExpression ) )
            // InternalExpression.g:257:4: (lv_values_3_0= ruleArrayExpression )
            {
            // InternalExpression.g:257:4: (lv_values_3_0= ruleArrayExpression )
            // InternalExpression.g:258:5: lv_values_3_0= ruleArrayExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getValuesArrayExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_values_3_0=ruleArrayExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              					}
              					set(
              						current,
              						"values",
              						lv_values_3_0,
              						"com.act21.rule.engine.dsl.Expression.ArrayExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleFunctionDeclaration"
    // InternalExpression.g:279:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // InternalExpression.g:279:60: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // InternalExpression.g:280:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFunctionDeclaration"


    // $ANTLR start "ruleFunctionDeclaration"
    // InternalExpression.g:286:1: ruleFunctionDeclaration returns [EObject current=null] : (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnType_8_0= ruleQualifiedName ) ) otherlv_9= '{' ( (lv_elements_10_0= ruleStatement ) )* otherlv_11= '}' ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        AntlrDatatypeRuleToken lv_returnType_8_0 = null;

        EObject lv_elements_10_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:292:2: ( (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnType_8_0= ruleQualifiedName ) ) otherlv_9= '{' ( (lv_elements_10_0= ruleStatement ) )* otherlv_11= '}' ) )
            // InternalExpression.g:293:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnType_8_0= ruleQualifiedName ) ) otherlv_9= '{' ( (lv_elements_10_0= ruleStatement ) )* otherlv_11= '}' )
            {
            // InternalExpression.g:293:2: (otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnType_8_0= ruleQualifiedName ) ) otherlv_9= '{' ( (lv_elements_10_0= ruleStatement ) )* otherlv_11= '}' )
            // InternalExpression.g:294:3: otherlv_0= 'function' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' otherlv_7= ':' ( (lv_returnType_8_0= ruleQualifiedName ) ) otherlv_9= '{' ( (lv_elements_10_0= ruleStatement ) )* otherlv_11= '}'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getFunctionDeclarationAccess().getFunctionKeyword_0());
              		
            }
            // InternalExpression.g:298:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExpression.g:299:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExpression.g:299:4: (lv_name_1_0= RULE_ID )
            // InternalExpression.g:300:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionDeclarationAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionDeclarationAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalExpression.g:320:3: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID||LA5_0==26) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalExpression.g:321:4: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalExpression.g:321:4: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalExpression.g:322:5: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalExpression.g:322:5: (lv_parameters_3_0= ruleParameter )
                    // InternalExpression.g:323:6: lv_parameters_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersParameterParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_9);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_3_0,
                      							"com.act21.rule.engine.dsl.Expression.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExpression.g:340:4: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==17) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalExpression.g:341:5: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalExpression.g:345:5: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalExpression.g:346:6: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalExpression.g:346:6: (lv_parameters_5_0= ruleParameter )
                    	    // InternalExpression.g:347:7: lv_parameters_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersParameterParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_9);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_5_0,
                    	      								"com.act21.rule.engine.dsl.Expression.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,18,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionDeclarationAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_7=(Token)match(input,19,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionDeclarationAccess().getColonKeyword_5());
              		
            }
            // InternalExpression.g:374:3: ( (lv_returnType_8_0= ruleQualifiedName ) )
            // InternalExpression.g:375:4: (lv_returnType_8_0= ruleQualifiedName )
            {
            // InternalExpression.g:375:4: (lv_returnType_8_0= ruleQualifiedName )
            // InternalExpression.g:376:5: lv_returnType_8_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getReturnTypeQualifiedNameParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_11);
            lv_returnType_8_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_8_0,
              						"com.act21.rule.engine.dsl.Expression.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_9=(Token)match(input,20,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getFunctionDeclarationAccess().getLeftCurlyBracketKeyword_7());
              		
            }
            // InternalExpression.g:397:3: ( (lv_elements_10_0= ruleStatement ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||(LA6_0>=14 && LA6_0<=15)||(LA6_0>=24 && LA6_0<=27)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalExpression.g:398:4: (lv_elements_10_0= ruleStatement )
            	    {
            	    // InternalExpression.g:398:4: (lv_elements_10_0= ruleStatement )
            	    // InternalExpression.g:399:5: lv_elements_10_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getElementsStatementParserRuleCall_8_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_elements_10_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elements",
            	      						lv_elements_10_0,
            	      						"com.act21.rule.engine.dsl.Expression.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_11=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getFunctionDeclarationAccess().getRightCurlyBracketKeyword_9());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "entryRuleTypeReference"
    // InternalExpression.g:424:1: entryRuleTypeReference returns [EObject current=null] : iv_ruleTypeReference= ruleTypeReference EOF ;
    public final EObject entryRuleTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeReference = null;


        try {
            // InternalExpression.g:424:54: (iv_ruleTypeReference= ruleTypeReference EOF )
            // InternalExpression.g:425:2: iv_ruleTypeReference= ruleTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeReference=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeReference"


    // $ANTLR start "ruleTypeReference"
    // InternalExpression.g:431:1: ruleTypeReference returns [EObject current=null] : ( ( (lv_identifier_0_0= ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_identifier_0_0 = null;

        AntlrDatatypeRuleToken lv_typeArguments_2_0 = null;

        AntlrDatatypeRuleToken lv_typeArguments_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:437:2: ( ( ( (lv_identifier_0_0= ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>' )? ) )
            // InternalExpression.g:438:2: ( ( (lv_identifier_0_0= ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>' )? )
            {
            // InternalExpression.g:438:2: ( ( (lv_identifier_0_0= ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>' )? )
            // InternalExpression.g:439:3: ( (lv_identifier_0_0= ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>' )?
            {
            // InternalExpression.g:439:3: ( (lv_identifier_0_0= ruleQualifiedName ) )
            // InternalExpression.g:440:4: (lv_identifier_0_0= ruleQualifiedName )
            {
            // InternalExpression.g:440:4: (lv_identifier_0_0= ruleQualifiedName )
            // InternalExpression.g:441:5: lv_identifier_0_0= ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeReferenceAccess().getIdentifierQualifiedNameParserRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_identifier_0_0=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeReferenceRule());
              					}
              					set(
              						current,
              						"identifier",
              						lv_identifier_0_0,
              						"com.act21.rule.engine.dsl.Expression.QualifiedName");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:458:3: (otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>' )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalExpression.g:459:4: otherlv_1= '<' ( (lv_typeArguments_2_0= ruleQualifiedName ) ) (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeReferenceAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalExpression.g:463:4: ( (lv_typeArguments_2_0= ruleQualifiedName ) )
                    // InternalExpression.g:464:5: (lv_typeArguments_2_0= ruleQualifiedName )
                    {
                    // InternalExpression.g:464:5: (lv_typeArguments_2_0= ruleQualifiedName )
                    // InternalExpression.g:465:6: lv_typeArguments_2_0= ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeReferenceAccess().getTypeArgumentsQualifiedNameParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_14);
                    lv_typeArguments_2_0=ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTypeReferenceRule());
                      						}
                      						add(
                      							current,
                      							"typeArguments",
                      							lv_typeArguments_2_0,
                      							"com.act21.rule.engine.dsl.Expression.QualifiedName");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExpression.g:482:4: (otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==17) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalExpression.g:483:5: otherlv_3= ',' ( (lv_typeArguments_4_0= ruleQualifiedName ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_5); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalExpression.g:487:5: ( (lv_typeArguments_4_0= ruleQualifiedName ) )
                    	    // InternalExpression.g:488:6: (lv_typeArguments_4_0= ruleQualifiedName )
                    	    {
                    	    // InternalExpression.g:488:6: (lv_typeArguments_4_0= ruleQualifiedName )
                    	    // InternalExpression.g:489:7: lv_typeArguments_4_0= ruleQualifiedName
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTypeReferenceAccess().getTypeArgumentsQualifiedNameParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_14);
                    	    lv_typeArguments_4_0=ruleQualifiedName();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTypeReferenceRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeArguments",
                    	      								lv_typeArguments_4_0,
                    	      								"com.act21.rule.engine.dsl.Expression.QualifiedName");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleTypeReference"


    // $ANTLR start "entryRuleClass"
    // InternalExpression.g:516:1: entryRuleClass returns [EObject current=null] : iv_ruleClass= ruleClass EOF ;
    public final EObject entryRuleClass() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClass = null;


        try {
            // InternalExpression.g:516:46: (iv_ruleClass= ruleClass EOF )
            // InternalExpression.g:517:2: iv_ruleClass= ruleClass EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClassRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClass=ruleClass();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClass; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleClass"


    // $ANTLR start "ruleClass"
    // InternalExpression.g:523:1: ruleClass returns [EObject current=null] : (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleNamedElement ) )* otherlv_6= '}' ) ;
    public final EObject ruleClass() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_members_5_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:529:2: ( (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleNamedElement ) )* otherlv_6= '}' ) )
            // InternalExpression.g:530:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleNamedElement ) )* otherlv_6= '}' )
            {
            // InternalExpression.g:530:2: (otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleNamedElement ) )* otherlv_6= '}' )
            // InternalExpression.g:531:3: otherlv_0= 'class' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= '{' ( (lv_members_5_0= ruleNamedElement ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClassAccess().getClassKeyword_0());
              		
            }
            // InternalExpression.g:535:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalExpression.g:536:4: (lv_name_1_0= RULE_ID )
            {
            // InternalExpression.g:536:4: (lv_name_1_0= RULE_ID )
            // InternalExpression.g:537:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getClassAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getClassRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalExpression.g:553:3: (otherlv_2= '<' ( (otherlv_3= RULE_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalExpression.g:554:4: otherlv_2= '<' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,22,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getClassAccess().getLessThanSignKeyword_2_0());
                      			
                    }
                    // InternalExpression.g:558:4: ( (otherlv_3= RULE_ID ) )
                    // InternalExpression.g:559:5: (otherlv_3= RULE_ID )
                    {
                    // InternalExpression.g:559:5: (otherlv_3= RULE_ID )
                    // InternalExpression.g:560:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClassRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_11); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getClassAccess().getSuperClassClassCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,20,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getClassAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalExpression.g:576:3: ( (lv_members_5_0= ruleNamedElement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID||(LA10_0>=14 && LA10_0<=15)||LA10_0==24||LA10_0==26) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalExpression.g:577:4: (lv_members_5_0= ruleNamedElement )
            	    {
            	    // InternalExpression.g:577:4: (lv_members_5_0= ruleNamedElement )
            	    // InternalExpression.g:578:5: lv_members_5_0= ruleNamedElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getClassAccess().getMembersNamedElementParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_16);
            	    lv_members_5_0=ruleNamedElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getClassRule());
            	      					}
            	      					add(
            	      						current,
            	      						"members",
            	      						lv_members_5_0,
            	      						"com.act21.rule.engine.dsl.Expression.NamedElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_6=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getClassAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleClass"


    // $ANTLR start "entryRuleAssign"
    // InternalExpression.g:603:1: entryRuleAssign returns [EObject current=null] : iv_ruleAssign= ruleAssign EOF ;
    public final EObject entryRuleAssign() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssign = null;


        try {
            // InternalExpression.g:603:47: (iv_ruleAssign= ruleAssign EOF )
            // InternalExpression.g:604:2: iv_ruleAssign= ruleAssign EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssign=ruleAssign();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssign; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAssign"


    // $ANTLR start "ruleAssign"
    // InternalExpression.g:610:1: ruleAssign returns [EObject current=null] : (otherlv_0= 'assign' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )? ) ;
    public final EObject ruleAssign() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:616:2: ( (otherlv_0= 'assign' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )? ) )
            // InternalExpression.g:617:2: (otherlv_0= 'assign' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )? )
            {
            // InternalExpression.g:617:2: (otherlv_0= 'assign' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )? )
            // InternalExpression.g:618:3: otherlv_0= 'assign' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleExpression ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getAssignAccess().getAssignKeyword_0());
              		
            }
            // InternalExpression.g:622:3: ( (otherlv_1= RULE_ID ) )
            // InternalExpression.g:623:4: (otherlv_1= RULE_ID )
            {
            // InternalExpression.g:623:4: (otherlv_1= RULE_ID )
            // InternalExpression.g:624:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssignRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getAssignAccess().getNameVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAssignAccess().getColonKeyword_2());
              		
            }
            // InternalExpression.g:639:3: ( (lv_value_3_0= ruleExpression ) )?
            int alt11=2;
            alt11 = dfa11.predict(input);
            switch (alt11) {
                case 1 :
                    // InternalExpression.g:640:4: (lv_value_3_0= ruleExpression )
                    {
                    // InternalExpression.g:640:4: (lv_value_3_0= ruleExpression )
                    // InternalExpression.g:641:5: lv_value_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAssignAccess().getValueExpressionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAssignRule());
                      					}
                      					set(
                      						current,
                      						"value",
                      						lv_value_3_0,
                      						"com.act21.rule.engine.dsl.Expression.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAssign"


    // $ANTLR start "entryRuleParameter"
    // InternalExpression.g:662:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalExpression.g:662:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalExpression.g:663:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalExpression.g:669:1: ruleParameter returns [EObject current=null] : ( ( (lv_varArgs_0_0= '...' ) )? ( (lv_type_1_0= ruleTypeReference ) ) ( (lv_name_2_0= RULE_ID ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token lv_varArgs_0_0=null;
        Token lv_name_2_0=null;
        EObject lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:675:2: ( ( ( (lv_varArgs_0_0= '...' ) )? ( (lv_type_1_0= ruleTypeReference ) ) ( (lv_name_2_0= RULE_ID ) ) ) )
            // InternalExpression.g:676:2: ( ( (lv_varArgs_0_0= '...' ) )? ( (lv_type_1_0= ruleTypeReference ) ) ( (lv_name_2_0= RULE_ID ) ) )
            {
            // InternalExpression.g:676:2: ( ( (lv_varArgs_0_0= '...' ) )? ( (lv_type_1_0= ruleTypeReference ) ) ( (lv_name_2_0= RULE_ID ) ) )
            // InternalExpression.g:677:3: ( (lv_varArgs_0_0= '...' ) )? ( (lv_type_1_0= ruleTypeReference ) ) ( (lv_name_2_0= RULE_ID ) )
            {
            // InternalExpression.g:677:3: ( (lv_varArgs_0_0= '...' ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==26) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalExpression.g:678:4: (lv_varArgs_0_0= '...' )
                    {
                    // InternalExpression.g:678:4: (lv_varArgs_0_0= '...' )
                    // InternalExpression.g:679:5: lv_varArgs_0_0= '...'
                    {
                    lv_varArgs_0_0=(Token)match(input,26,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_varArgs_0_0, grammarAccess.getParameterAccess().getVarArgsFullStopFullStopFullStopKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getParameterRule());
                      					}
                      					setWithLastConsumed(current, "varArgs", lv_varArgs_0_0, "...");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExpression.g:691:3: ( (lv_type_1_0= ruleTypeReference ) )
            // InternalExpression.g:692:4: (lv_type_1_0= ruleTypeReference )
            {
            // InternalExpression.g:692:4: (lv_type_1_0= ruleTypeReference )
            // InternalExpression.g:693:5: lv_type_1_0= ruleTypeReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeTypeReferenceParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_4);
            lv_type_1_0=ruleTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"com.act21.rule.engine.dsl.Expression.TypeReference");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalExpression.g:710:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalExpression.g:711:4: (lv_name_2_0= RULE_ID )
            {
            // InternalExpression.g:711:4: (lv_name_2_0= RULE_ID )
            // InternalExpression.g:712:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleDecide"
    // InternalExpression.g:732:1: entryRuleDecide returns [EObject current=null] : iv_ruleDecide= ruleDecide EOF ;
    public final EObject entryRuleDecide() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecide = null;


        try {
            // InternalExpression.g:732:47: (iv_ruleDecide= ruleDecide EOF )
            // InternalExpression.g:733:2: iv_ruleDecide= ruleDecide EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecideRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDecide=ruleDecide();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecide; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDecide"


    // $ANTLR start "ruleDecide"
    // InternalExpression.g:739:1: ruleDecide returns [EObject current=null] : (otherlv_0= 'if' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleExpression ) )? ) ;
    public final EObject ruleDecide() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:745:2: ( (otherlv_0= 'if' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleExpression ) )? ) )
            // InternalExpression.g:746:2: (otherlv_0= 'if' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleExpression ) )? )
            {
            // InternalExpression.g:746:2: (otherlv_0= 'if' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleExpression ) )? )
            // InternalExpression.g:747:3: otherlv_0= 'if' ( (otherlv_1= RULE_ID ) ) otherlv_2= ':' ( (lv_condition_3_0= ruleExpression ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDecideAccess().getIfKeyword_0());
              		
            }
            // InternalExpression.g:751:3: ( (otherlv_1= RULE_ID ) )
            // InternalExpression.g:752:4: (otherlv_1= RULE_ID )
            {
            // InternalExpression.g:752:4: (otherlv_1= RULE_ID )
            // InternalExpression.g:753:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDecideRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getDecideAccess().getNameVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,19,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDecideAccess().getColonKeyword_2());
              		
            }
            // InternalExpression.g:768:3: ( (lv_condition_3_0= ruleExpression ) )?
            int alt13=2;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // InternalExpression.g:769:4: (lv_condition_3_0= ruleExpression )
                    {
                    // InternalExpression.g:769:4: (lv_condition_3_0= ruleExpression )
                    // InternalExpression.g:770:5: lv_condition_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getDecideAccess().getConditionExpressionParserRuleCall_3_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_condition_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getDecideRule());
                      					}
                      					set(
                      						current,
                      						"condition",
                      						lv_condition_3_0,
                      						"com.act21.rule.engine.dsl.Expression.Expression");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDecide"


    // $ANTLR start "entryRuleExpression"
    // InternalExpression.g:791:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalExpression.g:791:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalExpression.g:792:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalExpression.g:798:1: ruleExpression returns [EObject current=null] : this_LogicalOrExpression_0= ruleLogicalOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalOrExpression_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:804:2: (this_LogicalOrExpression_0= ruleLogicalOrExpression )
            // InternalExpression.g:805:2: this_LogicalOrExpression_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getLogicalOrExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_LogicalOrExpression_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_LogicalOrExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalExpression.g:816:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalExpression.g:816:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalExpression.g:817:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalExpression.g:823:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalAndExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:829:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalExpression.g:830:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalExpression.g:830:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalExpression.g:831:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_18);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:839:3: ( () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==36) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalExpression.g:840:4: () ruleLogicalOrOperator ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalExpression.g:840:4: ()
            	    // InternalExpression.g:841:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalOrOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_19);
            	    ruleLogicalOrOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalExpression.g:854:4: ( (lv_rightOperand_3_0= ruleLogicalAndExpression ) )
            	    // InternalExpression.g:855:5: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalExpression.g:855:5: (lv_rightOperand_3_0= ruleLogicalAndExpression )
            	    // InternalExpression.g:856:6: lv_rightOperand_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightOperandLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_18);
            	    lv_rightOperand_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"com.act21.rule.engine.dsl.Expression.LogicalAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalExpression.g:878:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalExpression.g:878:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalExpression.g:879:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalExpression.g:885:1: ruleLogicalAndExpression returns [EObject current=null] : (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalNotExpression_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:891:2: ( (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* ) )
            // InternalExpression.g:892:2: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            {
            // InternalExpression.g:892:2: (this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )* )
            // InternalExpression.g:893:3: this_LogicalNotExpression_0= ruleLogicalNotExpression ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalNotExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_20);
            this_LogicalNotExpression_0=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalNotExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:901:3: ( () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==35) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalExpression.g:902:4: () ruleLogicalAndOperator ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    {
            	    // InternalExpression.g:902:4: ()
            	    // InternalExpression.g:903:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftOperandAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    if ( state.backtracking==0 ) {

            	      				newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getLogicalAndOperatorParserRuleCall_1_1());
            	      			
            	    }
            	    pushFollow(FOLLOW_19);
            	    ruleLogicalAndOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				afterParserOrEnumRuleCall();
            	      			
            	    }
            	    // InternalExpression.g:916:4: ( (lv_rightOperand_3_0= ruleLogicalNotExpression ) )
            	    // InternalExpression.g:917:5: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    {
            	    // InternalExpression.g:917:5: (lv_rightOperand_3_0= ruleLogicalNotExpression )
            	    // InternalExpression.g:918:6: lv_rightOperand_3_0= ruleLogicalNotExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightOperandLogicalNotExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_20);
            	    lv_rightOperand_3_0=ruleLogicalNotExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"rightOperand",
            	      							lv_rightOperand_3_0,
            	      							"com.act21.rule.engine.dsl.Expression.LogicalNotExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalNotExpression"
    // InternalExpression.g:940:1: entryRuleLogicalNotExpression returns [EObject current=null] : iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF ;
    public final EObject entryRuleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalNotExpression = null;


        try {
            // InternalExpression.g:940:61: (iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF )
            // InternalExpression.g:941:2: iv_ruleLogicalNotExpression= ruleLogicalNotExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalNotExpression=ruleLogicalNotExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalNotExpression"


    // $ANTLR start "ruleLogicalNotExpression"
    // InternalExpression.g:947:1: ruleLogicalNotExpression returns [EObject current=null] : (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) ) ) ) ;
    public final EObject ruleLogicalNotExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LogicalRelationExpression_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:953:2: ( (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) ) ) ) )
            // InternalExpression.g:954:2: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) ) ) )
            {
            // InternalExpression.g:954:2: (this_LogicalRelationExpression_0= ruleLogicalRelationExpression | ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) ) ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_STRING)||LA16_0==16||(LA16_0>=22 && LA16_0<=23)||(LA16_0>=28 && LA16_0<=33)||(LA16_0>=38 && LA16_0<=43)) ) {
                alt16=1;
            }
            else if ( (LA16_0==37) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalExpression.g:955:3: this_LogicalRelationExpression_0= ruleLogicalRelationExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalRelationExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LogicalRelationExpression_0=ruleLogicalRelationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LogicalRelationExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:964:3: ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) ) )
                    {
                    // InternalExpression.g:964:3: ( () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) ) )
                    // InternalExpression.g:965:4: () ruleLogicalNotOperator ( (lv_operand_3_0= ruleLogicalNotExpression ) )
                    {
                    // InternalExpression.g:965:4: ()
                    // InternalExpression.g:966:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getLogicalNotExpressionAccess().getLogicalNotExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getLogicalNotOperatorParserRuleCall_1_1());
                      			
                    }
                    pushFollow(FOLLOW_19);
                    ruleLogicalNotOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalExpression.g:979:4: ( (lv_operand_3_0= ruleLogicalNotExpression ) )
                    // InternalExpression.g:980:5: (lv_operand_3_0= ruleLogicalNotExpression )
                    {
                    // InternalExpression.g:980:5: (lv_operand_3_0= ruleLogicalNotExpression )
                    // InternalExpression.g:981:6: lv_operand_3_0= ruleLogicalNotExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLogicalNotExpressionAccess().getOperandLogicalNotExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleLogicalNotExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLogicalNotExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"com.act21.rule.engine.dsl.Expression.LogicalNotExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalNotExpression"


    // $ANTLR start "entryRuleLogicalRelationExpression"
    // InternalExpression.g:1003:1: entryRuleLogicalRelationExpression returns [EObject current=null] : iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF ;
    public final EObject entryRuleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalRelationExpression = null;


        try {
            // InternalExpression.g:1003:66: (iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF )
            // InternalExpression.g:1004:2: iv_ruleLogicalRelationExpression= ruleLogicalRelationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalRelationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalRelationExpression=ruleLogicalRelationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalRelationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalRelationExpression"


    // $ANTLR start "ruleLogicalRelationExpression"
    // InternalExpression.g:1010:1: ruleLogicalRelationExpression returns [EObject current=null] : (this_RelationalUnaryExpression_0= ruleRelationalUnaryExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) ) )* ) ;
    public final EObject ruleLogicalRelationExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RelationalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1016:2: ( (this_RelationalUnaryExpression_0= ruleRelationalUnaryExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) ) )* ) )
            // InternalExpression.g:1017:2: (this_RelationalUnaryExpression_0= ruleRelationalUnaryExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) ) )* )
            {
            // InternalExpression.g:1017:2: (this_RelationalUnaryExpression_0= ruleRelationalUnaryExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) ) )* )
            // InternalExpression.g:1018:3: this_RelationalUnaryExpression_0= ruleRelationalUnaryExpression ( ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRelationalUnaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_21);
            this_RelationalUnaryExpression_0=ruleRelationalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_RelationalUnaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:1026:3: ( ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==22) && (synpred1_InternalExpression())) {
                    alt17=1;
                }
                else if ( (LA17_0==38) && (synpred1_InternalExpression())) {
                    alt17=1;
                }
                else if ( (LA17_0==23) && (synpred1_InternalExpression())) {
                    alt17=1;
                }
                else if ( (LA17_0==39) && (synpred1_InternalExpression())) {
                    alt17=1;
                }
                else if ( (LA17_0==40) && (synpred1_InternalExpression())) {
                    alt17=1;
                }
                else if ( (LA17_0==41) && (synpred1_InternalExpression())) {
                    alt17=1;
                }
                else if ( (LA17_0==42) && (synpred1_InternalExpression())) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalExpression.g:1027:4: ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) )
            	    {
            	    // InternalExpression.g:1042:4: ( () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) ) )
            	    // InternalExpression.g:1043:5: () ( (lv_operator_2_0= ruleRelationalOperator ) ) ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) )
            	    {
            	    // InternalExpression.g:1043:5: ()
            	    // InternalExpression.g:1044:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getLogicalRelationExpressionAccess().getLogicalRelationExpressionLeftOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:1050:5: ( (lv_operator_2_0= ruleRelationalOperator ) )
            	    // InternalExpression.g:1051:6: (lv_operator_2_0= ruleRelationalOperator )
            	    {
            	    // InternalExpression.g:1051:6: (lv_operator_2_0= ruleRelationalOperator )
            	    // InternalExpression.g:1052:7: lv_operator_2_0= ruleRelationalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getOperatorRelationalOperatorEnumRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_22);
            	    lv_operator_2_0=ruleRelationalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getLogicalRelationExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"operator",
            	      								lv_operator_2_0,
            	      								"com.act21.rule.engine.dsl.Expression.RelationalOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalExpression.g:1069:5: ( (lv_rightOperand_3_0= ruleRelationalUnaryExpression ) )
            	    // InternalExpression.g:1070:6: (lv_rightOperand_3_0= ruleRelationalUnaryExpression )
            	    {
            	    // InternalExpression.g:1070:6: (lv_rightOperand_3_0= ruleRelationalUnaryExpression )
            	    // InternalExpression.g:1071:7: lv_rightOperand_3_0= ruleRelationalUnaryExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getLogicalRelationExpressionAccess().getRightOperandRelationalUnaryExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_rightOperand_3_0=ruleRelationalUnaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getLogicalRelationExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rightOperand",
            	      								lv_rightOperand_3_0,
            	      								"com.act21.rule.engine.dsl.Expression.RelationalUnaryExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalRelationExpression"


    // $ANTLR start "entryRuleRelationalUnaryExpression"
    // InternalExpression.g:1094:1: entryRuleRelationalUnaryExpression returns [EObject current=null] : iv_ruleRelationalUnaryExpression= ruleRelationalUnaryExpression EOF ;
    public final EObject entryRuleRelationalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRelationalUnaryExpression = null;


        try {
            // InternalExpression.g:1094:66: (iv_ruleRelationalUnaryExpression= ruleRelationalUnaryExpression EOF )
            // InternalExpression.g:1095:2: iv_ruleRelationalUnaryExpression= ruleRelationalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRelationalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRelationalUnaryExpression=ruleRelationalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRelationalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRelationalUnaryExpression"


    // $ANTLR start "ruleRelationalUnaryExpression"
    // InternalExpression.g:1101:1: ruleRelationalUnaryExpression returns [EObject current=null] : (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression | ( () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) ) ) ) ;
    public final EObject ruleRelationalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalUnaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1107:2: ( (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression | ( () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) ) ) ) )
            // InternalExpression.g:1108:2: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression | ( () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) ) ) )
            {
            // InternalExpression.g:1108:2: (this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression | ( () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) ) ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_STRING)||LA18_0==16||(LA18_0>=28 && LA18_0<=33)||LA18_0==43) ) {
                alt18=1;
            }
            else if ( ((LA18_0>=22 && LA18_0<=23)||(LA18_0>=38 && LA18_0<=42)) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalExpression.g:1109:3: this_NumericalUnaryExpression_0= ruleNumericalUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getRelationalUnaryExpressionAccess().getNumericalUnaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumericalUnaryExpression_0=ruleNumericalUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumericalUnaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1118:3: ( () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) ) )
                    {
                    // InternalExpression.g:1118:3: ( () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) ) )
                    // InternalExpression.g:1119:4: () ( (lv_operator_2_0= ruleRelationalUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalUnaryExpression ) )
                    {
                    // InternalExpression.g:1119:4: ()
                    // InternalExpression.g:1120:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getRelationalUnaryExpressionAccess().getRelationalUnaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:1126:4: ( (lv_operator_2_0= ruleRelationalUnaryOperator ) )
                    // InternalExpression.g:1127:5: (lv_operator_2_0= ruleRelationalUnaryOperator )
                    {
                    // InternalExpression.g:1127:5: (lv_operator_2_0= ruleRelationalUnaryOperator )
                    // InternalExpression.g:1128:6: lv_operator_2_0= ruleRelationalUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalUnaryExpressionAccess().getOperatorRelationalUnaryOperatorEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_23);
                    lv_operator_2_0=ruleRelationalUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_2_0,
                      							"com.act21.rule.engine.dsl.Expression.RelationalUnaryOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExpression.g:1145:4: ( (lv_operand_3_0= ruleNumericalUnaryExpression ) )
                    // InternalExpression.g:1146:5: (lv_operand_3_0= ruleNumericalUnaryExpression )
                    {
                    // InternalExpression.g:1146:5: (lv_operand_3_0= ruleNumericalUnaryExpression )
                    // InternalExpression.g:1147:6: lv_operand_3_0= ruleNumericalUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getRelationalUnaryExpressionAccess().getOperandNumericalUnaryExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleNumericalUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getRelationalUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"com.act21.rule.engine.dsl.Expression.NumericalUnaryExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRelationalUnaryExpression"


    // $ANTLR start "entryRuleNumericalUnaryExpression"
    // InternalExpression.g:1169:1: entryRuleNumericalUnaryExpression returns [EObject current=null] : iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF ;
    public final EObject entryRuleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalUnaryExpression = null;


        try {
            // InternalExpression.g:1169:65: (iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF )
            // InternalExpression.g:1170:2: iv_ruleNumericalUnaryExpression= ruleNumericalUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericalUnaryExpression=ruleNumericalUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNumericalUnaryExpression"


    // $ANTLR start "ruleNumericalUnaryExpression"
    // InternalExpression.g:1176:1: ruleNumericalUnaryExpression returns [EObject current=null] : (this_NumericalExpression_0= ruleNumericalExpression | ( () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) ) ) ) ;
    public final EObject ruleNumericalUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_NumericalExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_operand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1182:2: ( (this_NumericalExpression_0= ruleNumericalExpression | ( () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) ) ) ) )
            // InternalExpression.g:1183:2: (this_NumericalExpression_0= ruleNumericalExpression | ( () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) ) ) )
            {
            // InternalExpression.g:1183:2: (this_NumericalExpression_0= ruleNumericalExpression | ( () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=RULE_ID && LA19_0<=RULE_STRING)||LA19_0==16||(LA19_0>=28 && LA19_0<=29)||(LA19_0>=31 && LA19_0<=33)) ) {
                alt19=1;
            }
            else if ( (LA19_0==30||LA19_0==43) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalExpression.g:1184:3: this_NumericalExpression_0= ruleNumericalExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getNumericalExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumericalExpression_0=ruleNumericalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumericalExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1193:3: ( () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) ) )
                    {
                    // InternalExpression.g:1193:3: ( () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) ) )
                    // InternalExpression.g:1194:4: () ( (lv_operator_2_0= ruleNumericUnaryOperator ) ) ( (lv_operand_3_0= ruleNumericalExpression ) )
                    {
                    // InternalExpression.g:1194:4: ()
                    // InternalExpression.g:1195:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getNumericalUnaryExpressionAccess().getNumericalUnaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalExpression.g:1201:4: ( (lv_operator_2_0= ruleNumericUnaryOperator ) )
                    // InternalExpression.g:1202:5: (lv_operator_2_0= ruleNumericUnaryOperator )
                    {
                    // InternalExpression.g:1202:5: (lv_operator_2_0= ruleNumericUnaryOperator )
                    // InternalExpression.g:1203:6: lv_operator_2_0= ruleNumericUnaryOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperatorNumericUnaryOperatorEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_24);
                    lv_operator_2_0=ruleNumericUnaryOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNumericalUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operator",
                      							lv_operator_2_0,
                      							"com.act21.rule.engine.dsl.Expression.NumericUnaryOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExpression.g:1220:4: ( (lv_operand_3_0= ruleNumericalExpression ) )
                    // InternalExpression.g:1221:5: (lv_operand_3_0= ruleNumericalExpression )
                    {
                    // InternalExpression.g:1221:5: (lv_operand_3_0= ruleNumericalExpression )
                    // InternalExpression.g:1222:6: lv_operand_3_0= ruleNumericalExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getNumericalUnaryExpressionAccess().getOperandNumericalExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_operand_3_0=ruleNumericalExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getNumericalUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"operand",
                      							lv_operand_3_0,
                      							"com.act21.rule.engine.dsl.Expression.NumericalExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNumericalUnaryExpression"


    // $ANTLR start "entryRuleNumericalExpression"
    // InternalExpression.g:1244:1: entryRuleNumericalExpression returns [EObject current=null] : iv_ruleNumericalExpression= ruleNumericalExpression EOF ;
    public final EObject entryRuleNumericalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumericalExpression = null;


        try {
            // InternalExpression.g:1244:60: (iv_ruleNumericalExpression= ruleNumericalExpression EOF )
            // InternalExpression.g:1245:2: iv_ruleNumericalExpression= ruleNumericalExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumericalExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumericalExpression=ruleNumericalExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumericalExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNumericalExpression"


    // $ANTLR start "ruleNumericalExpression"
    // InternalExpression.g:1251:1: ruleNumericalExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) ) )* ) ;
    public final EObject ruleNumericalExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        Enumerator lv_operator_2_0 = null;

        EObject lv_rightOperand_3_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1257:2: ( (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) ) )* ) )
            // InternalExpression.g:1258:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) ) )* )
            {
            // InternalExpression.g:1258:2: (this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) ) )* )
            // InternalExpression.g:1259:3: this_PrimaryExpression_0= rulePrimaryExpression ( ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getNumericalExpressionAccess().getPrimaryExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_25);
            this_PrimaryExpression_0=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_PrimaryExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:1267:3: ( ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==43) && (synpred2_InternalExpression())) {
                    alt20=1;
                }
                else if ( (LA20_0==30) && (synpred2_InternalExpression())) {
                    alt20=1;
                }
                else if ( (LA20_0==44) && (synpred2_InternalExpression())) {
                    alt20=1;
                }
                else if ( (LA20_0==45) && (synpred2_InternalExpression())) {
                    alt20=1;
                }
                else if ( (LA20_0==46) && (synpred2_InternalExpression())) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalExpression.g:1268:4: ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )=> ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) )
            	    {
            	    // InternalExpression.g:1283:4: ( () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) ) )
            	    // InternalExpression.g:1284:5: () ( (lv_operator_2_0= ruleNumericalOperator ) ) ( (lv_rightOperand_3_0= rulePrimaryExpression ) )
            	    {
            	    // InternalExpression.g:1284:5: ()
            	    // InternalExpression.g:1285:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getNumericalExpressionAccess().getNumericalExpressionLeftOperandAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    // InternalExpression.g:1291:5: ( (lv_operator_2_0= ruleNumericalOperator ) )
            	    // InternalExpression.g:1292:6: (lv_operator_2_0= ruleNumericalOperator )
            	    {
            	    // InternalExpression.g:1292:6: (lv_operator_2_0= ruleNumericalOperator )
            	    // InternalExpression.g:1293:7: lv_operator_2_0= ruleNumericalOperator
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalExpressionAccess().getOperatorNumericalOperatorEnumRuleCall_1_0_1_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_24);
            	    lv_operator_2_0=ruleNumericalOperator();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getNumericalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"operator",
            	      								lv_operator_2_0,
            	      								"com.act21.rule.engine.dsl.Expression.NumericalOperator");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }

            	    // InternalExpression.g:1310:5: ( (lv_rightOperand_3_0= rulePrimaryExpression ) )
            	    // InternalExpression.g:1311:6: (lv_rightOperand_3_0= rulePrimaryExpression )
            	    {
            	    // InternalExpression.g:1311:6: (lv_rightOperand_3_0= rulePrimaryExpression )
            	    // InternalExpression.g:1312:7: lv_rightOperand_3_0= rulePrimaryExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      							newCompositeNode(grammarAccess.getNumericalExpressionAccess().getRightOperandPrimaryExpressionParserRuleCall_1_0_2_0());
            	      						
            	    }
            	    pushFollow(FOLLOW_25);
            	    lv_rightOperand_3_0=rulePrimaryExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElementForParent(grammarAccess.getNumericalExpressionRule());
            	      							}
            	      							set(
            	      								current,
            	      								"rightOperand",
            	      								lv_rightOperand_3_0,
            	      								"com.act21.rule.engine.dsl.Expression.PrimaryExpression");
            	      							afterParserOrEnumRuleCall();
            	      						
            	    }

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNumericalExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalExpression.g:1335:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalExpression.g:1335:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalExpression.g:1336:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalExpression.g:1342:1: rulePrimaryExpression returns [EObject current=null] : (this_LiteralExpression_0= ruleLiteralExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_RangeExpression_3= ruleRangeExpression | this_ArrayExpression_4= ruleArrayExpression ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_LiteralExpression_0 = null;

        EObject this_FeatureCall_1 = null;

        EObject this_ParenthesizedExpression_2 = null;

        EObject this_RangeExpression_3 = null;

        EObject this_ArrayExpression_4 = null;



        	enterRule();

        try {
            // InternalExpression.g:1348:2: ( (this_LiteralExpression_0= ruleLiteralExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_RangeExpression_3= ruleRangeExpression | this_ArrayExpression_4= ruleArrayExpression ) )
            // InternalExpression.g:1349:2: (this_LiteralExpression_0= ruleLiteralExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_RangeExpression_3= ruleRangeExpression | this_ArrayExpression_4= ruleArrayExpression )
            {
            // InternalExpression.g:1349:2: (this_LiteralExpression_0= ruleLiteralExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_RangeExpression_3= ruleRangeExpression | this_ArrayExpression_4= ruleArrayExpression )
            int alt21=5;
            alt21 = dfa21.predict(input);
            switch (alt21) {
                case 1 :
                    // InternalExpression.g:1350:3: this_LiteralExpression_0= ruleLiteralExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getLiteralExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LiteralExpression_0=ruleLiteralExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LiteralExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1359:3: this_FeatureCall_1= ruleFeatureCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getFeatureCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCall_1=ruleFeatureCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:1368:3: this_ParenthesizedExpression_2= ruleParenthesizedExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getParenthesizedExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ParenthesizedExpression_2=ruleParenthesizedExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ParenthesizedExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:1377:3: this_RangeExpression_3= ruleRangeExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getRangeExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RangeExpression_3=ruleRangeExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RangeExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:1386:3: this_ArrayExpression_4= ruleArrayExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getArrayExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ArrayExpression_4=ruleArrayExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ArrayExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleRangeExpression"
    // InternalExpression.g:1398:1: entryRuleRangeExpression returns [EObject current=null] : iv_ruleRangeExpression= ruleRangeExpression EOF ;
    public final EObject entryRuleRangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRangeExpression = null;


        try {
            // InternalExpression.g:1398:56: (iv_ruleRangeExpression= ruleRangeExpression EOF )
            // InternalExpression.g:1399:2: iv_ruleRangeExpression= ruleRangeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRangeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRangeExpression=ruleRangeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRangeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleRangeExpression"


    // $ANTLR start "ruleRangeExpression"
    // InternalExpression.g:1405:1: ruleRangeExpression returns [EObject current=null] : ( () ( ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) ) ) ) ;
    public final EObject ruleRangeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_leftBracket_1_1=null;
        Token lv_leftBracket_1_2=null;
        Token otherlv_3=null;
        Token lv_rightBracket_5_1=null;
        Token lv_rightBracket_5_2=null;
        EObject lv_leftExpression_2_0 = null;

        EObject lv_rightExpression_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1411:2: ( ( () ( ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) ) ) ) )
            // InternalExpression.g:1412:2: ( () ( ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) ) ) )
            {
            // InternalExpression.g:1412:2: ( () ( ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) ) ) )
            // InternalExpression.g:1413:3: () ( ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) ) )
            {
            // InternalExpression.g:1413:3: ()
            // InternalExpression.g:1414:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRangeExpressionAccess().getRangeExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:1420:3: ( ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) ) )
            // InternalExpression.g:1421:4: ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) ) ( (lv_leftExpression_2_0= ruleLiteralExpression ) ) otherlv_3= '-' ( (lv_rightExpression_4_0= ruleLiteralExpression ) ) ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) )
            {
            // InternalExpression.g:1421:4: ( ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) ) )
            // InternalExpression.g:1422:5: ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) )
            {
            // InternalExpression.g:1422:5: ( (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' ) )
            // InternalExpression.g:1423:6: (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' )
            {
            // InternalExpression.g:1423:6: (lv_leftBracket_1_1= ']' | lv_leftBracket_1_2= '[' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==28) ) {
                alt22=1;
            }
            else if ( (LA22_0==29) ) {
                alt22=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalExpression.g:1424:7: lv_leftBracket_1_1= ']'
                    {
                    lv_leftBracket_1_1=(Token)match(input,28,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_leftBracket_1_1, grammarAccess.getRangeExpressionAccess().getLeftBracketRightSquareBracketKeyword_1_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRangeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "leftBracket", lv_leftBracket_1_1, null);
                      						
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1435:7: lv_leftBracket_1_2= '['
                    {
                    lv_leftBracket_1_2=(Token)match(input,29,FOLLOW_26); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_leftBracket_1_2, grammarAccess.getRangeExpressionAccess().getLeftBracketLeftSquareBracketKeyword_1_0_0_1());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRangeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "leftBracket", lv_leftBracket_1_2, null);
                      						
                    }

                    }
                    break;

            }


            }


            }

            // InternalExpression.g:1448:4: ( (lv_leftExpression_2_0= ruleLiteralExpression ) )
            // InternalExpression.g:1449:5: (lv_leftExpression_2_0= ruleLiteralExpression )
            {
            // InternalExpression.g:1449:5: (lv_leftExpression_2_0= ruleLiteralExpression )
            // InternalExpression.g:1450:6: lv_leftExpression_2_0= ruleLiteralExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getRangeExpressionAccess().getLeftExpressionLiteralExpressionParserRuleCall_1_1_0());
              					
            }
            pushFollow(FOLLOW_27);
            lv_leftExpression_2_0=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
              						}
              						set(
              							current,
              							"leftExpression",
              							lv_leftExpression_2_0,
              							"com.act21.rule.engine.dsl.Expression.LiteralExpression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            otherlv_3=(Token)match(input,30,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(otherlv_3, grammarAccess.getRangeExpressionAccess().getHyphenMinusKeyword_1_2());
              			
            }
            // InternalExpression.g:1471:4: ( (lv_rightExpression_4_0= ruleLiteralExpression ) )
            // InternalExpression.g:1472:5: (lv_rightExpression_4_0= ruleLiteralExpression )
            {
            // InternalExpression.g:1472:5: (lv_rightExpression_4_0= ruleLiteralExpression )
            // InternalExpression.g:1473:6: lv_rightExpression_4_0= ruleLiteralExpression
            {
            if ( state.backtracking==0 ) {

              						newCompositeNode(grammarAccess.getRangeExpressionAccess().getRightExpressionLiteralExpressionParserRuleCall_1_3_0());
              					
            }
            pushFollow(FOLLOW_28);
            lv_rightExpression_4_0=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElementForParent(grammarAccess.getRangeExpressionRule());
              						}
              						set(
              							current,
              							"rightExpression",
              							lv_rightExpression_4_0,
              							"com.act21.rule.engine.dsl.Expression.LiteralExpression");
              						afterParserOrEnumRuleCall();
              					
            }

            }


            }

            // InternalExpression.g:1490:4: ( ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) ) )
            // InternalExpression.g:1491:5: ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) )
            {
            // InternalExpression.g:1491:5: ( (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' ) )
            // InternalExpression.g:1492:6: (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' )
            {
            // InternalExpression.g:1492:6: (lv_rightBracket_5_1= '[' | lv_rightBracket_5_2= ']' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            else if ( (LA23_0==28) ) {
                alt23=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // InternalExpression.g:1493:7: lv_rightBracket_5_1= '['
                    {
                    lv_rightBracket_5_1=(Token)match(input,29,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_rightBracket_5_1, grammarAccess.getRangeExpressionAccess().getRightBracketLeftSquareBracketKeyword_1_4_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRangeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "rightBracket", lv_rightBracket_5_1, null);
                      						
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1504:7: lv_rightBracket_5_2= ']'
                    {
                    lv_rightBracket_5_2=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_rightBracket_5_2, grammarAccess.getRangeExpressionAccess().getRightBracketRightSquareBracketKeyword_1_4_0_1());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getRangeExpressionRule());
                      							}
                      							setWithLastConsumed(current, "rightBracket", lv_rightBracket_5_2, null);
                      						
                    }

                    }
                    break;

            }


            }


            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRangeExpression"


    // $ANTLR start "entryRuleLiteralExpression"
    // InternalExpression.g:1522:1: entryRuleLiteralExpression returns [EObject current=null] : iv_ruleLiteralExpression= ruleLiteralExpression EOF ;
    public final EObject entryRuleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteralExpression = null;


        try {
            // InternalExpression.g:1522:58: (iv_ruleLiteralExpression= ruleLiteralExpression EOF )
            // InternalExpression.g:1523:2: iv_ruleLiteralExpression= ruleLiteralExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteralExpression=ruleLiteralExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteralExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteralExpression"


    // $ANTLR start "ruleLiteralExpression"
    // InternalExpression.g:1529:1: ruleLiteralExpression returns [EObject current=null] : ( () ( (lv_value_1_0= ruleLiteral ) ) ) ;
    public final EObject ruleLiteralExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1535:2: ( ( () ( (lv_value_1_0= ruleLiteral ) ) ) )
            // InternalExpression.g:1536:2: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            {
            // InternalExpression.g:1536:2: ( () ( (lv_value_1_0= ruleLiteral ) ) )
            // InternalExpression.g:1537:3: () ( (lv_value_1_0= ruleLiteral ) )
            {
            // InternalExpression.g:1537:3: ()
            // InternalExpression.g:1538:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLiteralExpressionAccess().getLiteralExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:1544:3: ( (lv_value_1_0= ruleLiteral ) )
            // InternalExpression.g:1545:4: (lv_value_1_0= ruleLiteral )
            {
            // InternalExpression.g:1545:4: (lv_value_1_0= ruleLiteral )
            // InternalExpression.g:1546:5: lv_value_1_0= ruleLiteral
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLiteralExpressionAccess().getValueLiteralParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLiteralExpressionRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.act21.rule.engine.dsl.Expression.Literal");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteralExpression"


    // $ANTLR start "entryRuleParenthesizedExpression"
    // InternalExpression.g:1567:1: entryRuleParenthesizedExpression returns [EObject current=null] : iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF ;
    public final EObject entryRuleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParenthesizedExpression = null;


        try {
            // InternalExpression.g:1567:64: (iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF )
            // InternalExpression.g:1568:2: iv_ruleParenthesizedExpression= ruleParenthesizedExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParenthesizedExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParenthesizedExpression=ruleParenthesizedExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParenthesizedExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParenthesizedExpression"


    // $ANTLR start "ruleParenthesizedExpression"
    // InternalExpression.g:1574:1: ruleParenthesizedExpression returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) ;
    public final EObject ruleParenthesizedExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1580:2: ( ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' ) )
            // InternalExpression.g:1581:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            {
            // InternalExpression.g:1581:2: ( () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')' )
            // InternalExpression.g:1582:3: () otherlv_1= '(' ( (lv_expression_2_0= ruleExpression ) ) otherlv_3= ')'
            {
            // InternalExpression.g:1582:3: ()
            // InternalExpression.g:1583:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getParenthesizedExpressionAccess().getParenthesizedExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,16,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getParenthesizedExpressionAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalExpression.g:1593:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalExpression.g:1594:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalExpression.g:1594:4: (lv_expression_2_0= ruleExpression )
            // InternalExpression.g:1595:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParenthesizedExpressionAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParenthesizedExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"com.act21.rule.engine.dsl.Expression.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getParenthesizedExpressionAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleParenthesizedExpression"


    // $ANTLR start "entryRuleArrayExpression"
    // InternalExpression.g:1620:1: entryRuleArrayExpression returns [EObject current=null] : iv_ruleArrayExpression= ruleArrayExpression EOF ;
    public final EObject entryRuleArrayExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArrayExpression = null;


        try {
            // InternalExpression.g:1620:56: (iv_ruleArrayExpression= ruleArrayExpression EOF )
            // InternalExpression.g:1621:2: iv_ruleArrayExpression= ruleArrayExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArrayExpression=ruleArrayExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArrayExpression"


    // $ANTLR start "ruleArrayExpression"
    // InternalExpression.g:1627:1: ruleArrayExpression returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )* )? otherlv_5= ']' ) ;
    public final EObject ruleArrayExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_elements_2_0 = null;

        EObject lv_elements_4_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1633:2: ( ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )* )? otherlv_5= ']' ) )
            // InternalExpression.g:1634:2: ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )* )? otherlv_5= ']' )
            {
            // InternalExpression.g:1634:2: ( () otherlv_1= '[' ( ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )* )? otherlv_5= ']' )
            // InternalExpression.g:1635:3: () otherlv_1= '[' ( ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )* )? otherlv_5= ']'
            {
            // InternalExpression.g:1635:3: ()
            // InternalExpression.g:1636:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getArrayExpressionAccess().getArrayExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getArrayExpressionAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalExpression.g:1646:3: ( ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_STRING)||LA25_0==16||(LA25_0>=22 && LA25_0<=23)||(LA25_0>=29 && LA25_0<=33)||(LA25_0>=37 && LA25_0<=43)) ) {
                alt25=1;
            }
            else if ( (LA25_0==28) ) {
                int LA25_2 = input.LA(2);

                if ( ((LA25_2>=RULE_BOOL && LA25_2<=RULE_STRING)||(LA25_2>=31 && LA25_2<=33)) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalExpression.g:1647:4: ( (lv_elements_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )*
                    {
                    // InternalExpression.g:1647:4: ( (lv_elements_2_0= ruleExpression ) )
                    // InternalExpression.g:1648:5: (lv_elements_2_0= ruleExpression )
                    {
                    // InternalExpression.g:1648:5: (lv_elements_2_0= ruleExpression )
                    // InternalExpression.g:1649:6: lv_elements_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getArrayExpressionAccess().getElementsExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_30);
                    lv_elements_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getArrayExpressionRule());
                      						}
                      						add(
                      							current,
                      							"elements",
                      							lv_elements_2_0,
                      							"com.act21.rule.engine.dsl.Expression.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalExpression.g:1666:4: (otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==17) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalExpression.g:1667:5: otherlv_3= ',' ( (lv_elements_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getArrayExpressionAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalExpression.g:1671:5: ( (lv_elements_4_0= ruleExpression ) )
                    	    // InternalExpression.g:1672:6: (lv_elements_4_0= ruleExpression )
                    	    {
                    	    // InternalExpression.g:1672:6: (lv_elements_4_0= ruleExpression )
                    	    // InternalExpression.g:1673:7: lv_elements_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getArrayExpressionAccess().getElementsExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_30);
                    	    lv_elements_4_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getArrayExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"elements",
                    	      								lv_elements_4_0,
                    	      								"com.act21.rule.engine.dsl.Expression.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,28,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getArrayExpressionAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleArrayExpression"


    // $ANTLR start "entryRuleLiteral"
    // InternalExpression.g:1700:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


        try {
            // InternalExpression.g:1700:48: (iv_ruleLiteral= ruleLiteral EOF )
            // InternalExpression.g:1701:2: iv_ruleLiteral= ruleLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // InternalExpression.g:1707:1: ruleLiteral returns [EObject current=null] : (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_StringLiteral_3= ruleStringLiteral | this_NullLiteral_4= ruleNullLiteral | this_PassLiteral_5= rulePassLiteral | this_AllLiteral_6= ruleAllLiteral | this_DateLiteral_7= ruleDateLiteral ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        EObject this_BoolLiteral_0 = null;

        EObject this_IntLiteral_1 = null;

        EObject this_DecimalLiteral_2 = null;

        EObject this_StringLiteral_3 = null;

        EObject this_NullLiteral_4 = null;

        EObject this_PassLiteral_5 = null;

        EObject this_AllLiteral_6 = null;

        EObject this_DateLiteral_7 = null;



        	enterRule();

        try {
            // InternalExpression.g:1713:2: ( (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_StringLiteral_3= ruleStringLiteral | this_NullLiteral_4= ruleNullLiteral | this_PassLiteral_5= rulePassLiteral | this_AllLiteral_6= ruleAllLiteral | this_DateLiteral_7= ruleDateLiteral ) )
            // InternalExpression.g:1714:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_StringLiteral_3= ruleStringLiteral | this_NullLiteral_4= ruleNullLiteral | this_PassLiteral_5= rulePassLiteral | this_AllLiteral_6= ruleAllLiteral | this_DateLiteral_7= ruleDateLiteral )
            {
            // InternalExpression.g:1714:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_StringLiteral_3= ruleStringLiteral | this_NullLiteral_4= ruleNullLiteral | this_PassLiteral_5= rulePassLiteral | this_AllLiteral_6= ruleAllLiteral | this_DateLiteral_7= ruleDateLiteral )
            int alt26=8;
            alt26 = dfa26.predict(input);
            switch (alt26) {
                case 1 :
                    // InternalExpression.g:1715:3: this_BoolLiteral_0= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getBoolLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BoolLiteral_0=ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BoolLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalExpression.g:1724:3: this_IntLiteral_1= ruleIntLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getIntLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IntLiteral_1=ruleIntLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IntLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalExpression.g:1733:3: this_DecimalLiteral_2= ruleDecimalLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getDecimalLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DecimalLiteral_2=ruleDecimalLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DecimalLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalExpression.g:1742:3: this_StringLiteral_3= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getStringLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_3=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalExpression.g:1751:3: this_NullLiteral_4= ruleNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getNullLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NullLiteral_4=ruleNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NullLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalExpression.g:1760:3: this_PassLiteral_5= rulePassLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getPassLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PassLiteral_5=rulePassLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PassLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalExpression.g:1769:3: this_AllLiteral_6= ruleAllLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getAllLiteralParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AllLiteral_6=ruleAllLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AllLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalExpression.g:1778:3: this_DateLiteral_7= ruleDateLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getLiteralAccess().getDateLiteralParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DateLiteral_7=ruleDateLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DateLiteral_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRulePassLiteral"
    // InternalExpression.g:1790:1: entryRulePassLiteral returns [EObject current=null] : iv_rulePassLiteral= rulePassLiteral EOF ;
    public final EObject entryRulePassLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePassLiteral = null;


        try {
            // InternalExpression.g:1790:52: (iv_rulePassLiteral= rulePassLiteral EOF )
            // InternalExpression.g:1791:2: iv_rulePassLiteral= rulePassLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPassLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePassLiteral=rulePassLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePassLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRulePassLiteral"


    // $ANTLR start "rulePassLiteral"
    // InternalExpression.g:1797:1: rulePassLiteral returns [EObject current=null] : ( () otherlv_1= 'PASS' ) ;
    public final EObject rulePassLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExpression.g:1803:2: ( ( () otherlv_1= 'PASS' ) )
            // InternalExpression.g:1804:2: ( () otherlv_1= 'PASS' )
            {
            // InternalExpression.g:1804:2: ( () otherlv_1= 'PASS' )
            // InternalExpression.g:1805:3: () otherlv_1= 'PASS'
            {
            // InternalExpression.g:1805:3: ()
            // InternalExpression.g:1806:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPassLiteralAccess().getPassLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,31,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPassLiteralAccess().getPASSKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "rulePassLiteral"


    // $ANTLR start "entryRuleAllLiteral"
    // InternalExpression.g:1820:1: entryRuleAllLiteral returns [EObject current=null] : iv_ruleAllLiteral= ruleAllLiteral EOF ;
    public final EObject entryRuleAllLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllLiteral = null;


        try {
            // InternalExpression.g:1820:51: (iv_ruleAllLiteral= ruleAllLiteral EOF )
            // InternalExpression.g:1821:2: iv_ruleAllLiteral= ruleAllLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAllLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAllLiteral=ruleAllLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAllLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAllLiteral"


    // $ANTLR start "ruleAllLiteral"
    // InternalExpression.g:1827:1: ruleAllLiteral returns [EObject current=null] : ( () otherlv_1= 'ALL' ) ;
    public final EObject ruleAllLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExpression.g:1833:2: ( ( () otherlv_1= 'ALL' ) )
            // InternalExpression.g:1834:2: ( () otherlv_1= 'ALL' )
            {
            // InternalExpression.g:1834:2: ( () otherlv_1= 'ALL' )
            // InternalExpression.g:1835:3: () otherlv_1= 'ALL'
            {
            // InternalExpression.g:1835:3: ()
            // InternalExpression.g:1836:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAllLiteralAccess().getAllLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAllLiteralAccess().getALLKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleAllLiteral"


    // $ANTLR start "entryRuleBoolLiteral"
    // InternalExpression.g:1850:1: entryRuleBoolLiteral returns [EObject current=null] : iv_ruleBoolLiteral= ruleBoolLiteral EOF ;
    public final EObject entryRuleBoolLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolLiteral = null;


        try {
            // InternalExpression.g:1850:52: (iv_ruleBoolLiteral= ruleBoolLiteral EOF )
            // InternalExpression.g:1851:2: iv_ruleBoolLiteral= ruleBoolLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBoolLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBoolLiteral=ruleBoolLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBoolLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBoolLiteral"


    // $ANTLR start "ruleBoolLiteral"
    // InternalExpression.g:1857:1: ruleBoolLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BOOL ) ) ) ;
    public final EObject ruleBoolLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalExpression.g:1863:2: ( ( () ( (lv_value_1_0= RULE_BOOL ) ) ) )
            // InternalExpression.g:1864:2: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            {
            // InternalExpression.g:1864:2: ( () ( (lv_value_1_0= RULE_BOOL ) ) )
            // InternalExpression.g:1865:3: () ( (lv_value_1_0= RULE_BOOL ) )
            {
            // InternalExpression.g:1865:3: ()
            // InternalExpression.g:1866:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBoolLiteralAccess().getBoolLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:1872:3: ( (lv_value_1_0= RULE_BOOL ) )
            // InternalExpression.g:1873:4: (lv_value_1_0= RULE_BOOL )
            {
            // InternalExpression.g:1873:4: (lv_value_1_0= RULE_BOOL )
            // InternalExpression.g:1874:5: lv_value_1_0= RULE_BOOL
            {
            lv_value_1_0=(Token)match(input,RULE_BOOL,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getBoolLiteralAccess().getValueBOOLTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getBoolLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.act21.rule.engine.dsl.Expression.BOOL");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "entryRuleIntLiteral"
    // InternalExpression.g:1894:1: entryRuleIntLiteral returns [EObject current=null] : iv_ruleIntLiteral= ruleIntLiteral EOF ;
    public final EObject entryRuleIntLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntLiteral = null;


        try {
            // InternalExpression.g:1894:51: (iv_ruleIntLiteral= ruleIntLiteral EOF )
            // InternalExpression.g:1895:2: iv_ruleIntLiteral= ruleIntLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIntLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIntLiteral=ruleIntLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIntLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIntLiteral"


    // $ANTLR start "ruleIntLiteral"
    // InternalExpression.g:1901:1: ruleIntLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_BIGINT ) ) ) ;
    public final EObject ruleIntLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalExpression.g:1907:2: ( ( () ( (lv_value_1_0= RULE_BIGINT ) ) ) )
            // InternalExpression.g:1908:2: ( () ( (lv_value_1_0= RULE_BIGINT ) ) )
            {
            // InternalExpression.g:1908:2: ( () ( (lv_value_1_0= RULE_BIGINT ) ) )
            // InternalExpression.g:1909:3: () ( (lv_value_1_0= RULE_BIGINT ) )
            {
            // InternalExpression.g:1909:3: ()
            // InternalExpression.g:1910:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIntLiteralAccess().getIntLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:1916:3: ( (lv_value_1_0= RULE_BIGINT ) )
            // InternalExpression.g:1917:4: (lv_value_1_0= RULE_BIGINT )
            {
            // InternalExpression.g:1917:4: (lv_value_1_0= RULE_BIGINT )
            // InternalExpression.g:1918:5: lv_value_1_0= RULE_BIGINT
            {
            lv_value_1_0=(Token)match(input,RULE_BIGINT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getIntLiteralAccess().getValueBIGINTTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getIntLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.act21.rule.engine.dsl.Expression.BIGINT");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleIntLiteral"


    // $ANTLR start "entryRuleDecimalLiteral"
    // InternalExpression.g:1938:1: entryRuleDecimalLiteral returns [EObject current=null] : iv_ruleDecimalLiteral= ruleDecimalLiteral EOF ;
    public final EObject entryRuleDecimalLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalLiteral = null;


        try {
            // InternalExpression.g:1938:55: (iv_ruleDecimalLiteral= ruleDecimalLiteral EOF )
            // InternalExpression.g:1939:2: iv_ruleDecimalLiteral= ruleDecimalLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecimalLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDecimalLiteral=ruleDecimalLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecimalLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDecimalLiteral"


    // $ANTLR start "ruleDecimalLiteral"
    // InternalExpression.g:1945:1: ruleDecimalLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= ruleDecimal ) ) ) ;
    public final EObject ruleDecimalLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_1_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:1951:2: ( ( () ( (lv_value_1_0= ruleDecimal ) ) ) )
            // InternalExpression.g:1952:2: ( () ( (lv_value_1_0= ruleDecimal ) ) )
            {
            // InternalExpression.g:1952:2: ( () ( (lv_value_1_0= ruleDecimal ) ) )
            // InternalExpression.g:1953:3: () ( (lv_value_1_0= ruleDecimal ) )
            {
            // InternalExpression.g:1953:3: ()
            // InternalExpression.g:1954:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDecimalLiteralAccess().getDecimalLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:1960:3: ( (lv_value_1_0= ruleDecimal ) )
            // InternalExpression.g:1961:4: (lv_value_1_0= ruleDecimal )
            {
            // InternalExpression.g:1961:4: (lv_value_1_0= ruleDecimal )
            // InternalExpression.g:1962:5: lv_value_1_0= ruleDecimal
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDecimalLiteralAccess().getValueDecimalParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_1_0=ruleDecimal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getDecimalLiteralRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.act21.rule.engine.dsl.Expression.Decimal");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDecimalLiteral"


    // $ANTLR start "entryRuleDateLiteral"
    // InternalExpression.g:1983:1: entryRuleDateLiteral returns [EObject current=null] : iv_ruleDateLiteral= ruleDateLiteral EOF ;
    public final EObject entryRuleDateLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateLiteral = null;


        try {
            // InternalExpression.g:1983:52: (iv_ruleDateLiteral= ruleDateLiteral EOF )
            // InternalExpression.g:1984:2: iv_ruleDateLiteral= ruleDateLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDateLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDateLiteral=ruleDateLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDateLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDateLiteral"


    // $ANTLR start "ruleDateLiteral"
    // InternalExpression.g:1990:1: ruleDateLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_DATE ) ) ) ;
    public final EObject ruleDateLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalExpression.g:1996:2: ( ( () ( (lv_value_1_0= RULE_DATE ) ) ) )
            // InternalExpression.g:1997:2: ( () ( (lv_value_1_0= RULE_DATE ) ) )
            {
            // InternalExpression.g:1997:2: ( () ( (lv_value_1_0= RULE_DATE ) ) )
            // InternalExpression.g:1998:3: () ( (lv_value_1_0= RULE_DATE ) )
            {
            // InternalExpression.g:1998:3: ()
            // InternalExpression.g:1999:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getDateLiteralAccess().getDateLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:2005:3: ( (lv_value_1_0= RULE_DATE ) )
            // InternalExpression.g:2006:4: (lv_value_1_0= RULE_DATE )
            {
            // InternalExpression.g:2006:4: (lv_value_1_0= RULE_DATE )
            // InternalExpression.g:2007:5: lv_value_1_0= RULE_DATE
            {
            lv_value_1_0=(Token)match(input,RULE_DATE,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getDateLiteralAccess().getValueDATETerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDateLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"com.act21.rule.engine.dsl.Expression.DATE");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDateLiteral"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalExpression.g:2027:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalExpression.g:2027:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalExpression.g:2028:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalExpression.g:2034:1: ruleStringLiteral returns [EObject current=null] : ( () ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalExpression.g:2040:2: ( ( () ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalExpression.g:2041:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalExpression.g:2041:2: ( () ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalExpression.g:2042:3: () ( (lv_value_1_0= RULE_STRING ) )
            {
            // InternalExpression.g:2042:3: ()
            // InternalExpression.g:2043:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStringLiteralAccess().getStringLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:2049:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalExpression.g:2050:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalExpression.g:2050:4: (lv_value_1_0= RULE_STRING )
            // InternalExpression.g:2051:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStringLiteralRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"org.eclipse.xtext.common.Terminals.STRING");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleNullLiteral"
    // InternalExpression.g:2071:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // InternalExpression.g:2071:52: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // InternalExpression.g:2072:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteral=ruleNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleNullLiteral"


    // $ANTLR start "ruleNullLiteral"
    // InternalExpression.g:2078:1: ruleNullLiteral returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalExpression.g:2084:2: ( ( () otherlv_1= 'null' ) )
            // InternalExpression.g:2085:2: ( () otherlv_1= 'null' )
            {
            // InternalExpression.g:2085:2: ( () otherlv_1= 'null' )
            // InternalExpression.g:2086:3: () otherlv_1= 'null'
            {
            // InternalExpression.g:2086:3: ()
            // InternalExpression.g:2087:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getNullKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNullLiteral"


    // $ANTLR start "entryRuleFeatureCall"
    // InternalExpression.g:2101:1: entryRuleFeatureCall returns [EObject current=null] : iv_ruleFeatureCall= ruleFeatureCall EOF ;
    public final EObject entryRuleFeatureCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCall = null;


        try {
            // InternalExpression.g:2101:52: (iv_ruleFeatureCall= ruleFeatureCall EOF )
            // InternalExpression.g:2102:2: iv_ruleFeatureCall= ruleFeatureCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCall=ruleFeatureCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeatureCall"


    // $ANTLR start "ruleFeatureCall"
    // InternalExpression.g:2108:1: ruleFeatureCall returns [EObject current=null] : (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* ) ;
    public final EObject ruleFeatureCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_operationCall_4_0=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_arrayAccess_9_0=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        EObject this_ElementReferenceExpression_0 = null;

        EObject lv_arguments_5_0 = null;

        EObject lv_arguments_7_0 = null;

        EObject lv_arraySelector_10_0 = null;

        EObject lv_arraySelector_13_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2114:2: ( (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* ) )
            // InternalExpression.g:2115:2: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* )
            {
            // InternalExpression.g:2115:2: (this_ElementReferenceExpression_0= ruleElementReferenceExpression ( ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )* )
            // InternalExpression.g:2116:3: this_ElementReferenceExpression_0= ruleElementReferenceExpression ( ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getFeatureCallAccess().getElementReferenceExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_31);
            this_ElementReferenceExpression_0=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ElementReferenceExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalExpression.g:2124:3: ( ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )? )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==34) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalExpression.g:2125:4: ( () otherlv_2= '.' ) ( (otherlv_3= RULE_ID ) ) ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )?
            	    {
            	    // InternalExpression.g:2125:4: ( () otherlv_2= '.' )
            	    // InternalExpression.g:2126:5: () otherlv_2= '.'
            	    {
            	    // InternalExpression.g:2126:5: ()
            	    // InternalExpression.g:2127:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getFeatureCallAccess().getFeatureCallOwnerAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getFeatureCallAccess().getFullStopKeyword_1_0_1());
            	      				
            	    }

            	    }

            	    // InternalExpression.g:2138:4: ( (otherlv_3= RULE_ID ) )
            	    // InternalExpression.g:2139:5: (otherlv_3= RULE_ID )
            	    {
            	    // InternalExpression.g:2139:5: (otherlv_3= RULE_ID )
            	    // InternalExpression.g:2140:6: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getFeatureCallRule());
            	      						}
            	      					
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(otherlv_3, grammarAccess.getFeatureCallAccess().getFeatureNamedElementCrossReference_1_1_0());
            	      					
            	    }

            	    }


            	    }

            	    // InternalExpression.g:2151:4: ( ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* ) )?
            	    int alt30=3;
            	    int LA30_0 = input.LA(1);

            	    if ( (LA30_0==16) && (synpred3_InternalExpression())) {
            	        alt30=1;
            	    }
            	    else if ( (LA30_0==29) && (synpred4_InternalExpression())) {
            	        alt30=2;
            	    }
            	    switch (alt30) {
            	        case 1 :
            	            // InternalExpression.g:2152:5: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' )
            	            {
            	            // InternalExpression.g:2152:5: ( ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')' )
            	            // InternalExpression.g:2153:6: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) ) ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )? otherlv_8= ')'
            	            {
            	            // InternalExpression.g:2153:6: ( ( ( '(' ) )=> (lv_operationCall_4_0= '(' ) )
            	            // InternalExpression.g:2154:7: ( ( '(' ) )=> (lv_operationCall_4_0= '(' )
            	            {
            	            // InternalExpression.g:2158:7: (lv_operationCall_4_0= '(' )
            	            // InternalExpression.g:2159:8: lv_operationCall_4_0= '('
            	            {
            	            lv_operationCall_4_0=(Token)match(input,16,FOLLOW_33); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(lv_operationCall_4_0, grammarAccess.getFeatureCallAccess().getOperationCallLeftParenthesisKeyword_1_2_0_0_0());
            	              							
            	            }
            	            if ( state.backtracking==0 ) {

            	              								if (current==null) {
            	              									current = createModelElement(grammarAccess.getFeatureCallRule());
            	              								}
            	              								setWithLastConsumed(current, "operationCall", lv_operationCall_4_0 != null, "(");
            	              							
            	            }

            	            }


            	            }

            	            // InternalExpression.g:2171:6: ( ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )* )?
            	            int alt28=2;
            	            int LA28_0 = input.LA(1);

            	            if ( ((LA28_0>=RULE_ID && LA28_0<=RULE_STRING)||LA28_0==16||(LA28_0>=22 && LA28_0<=23)||(LA28_0>=28 && LA28_0<=33)||(LA28_0>=37 && LA28_0<=43)) ) {
            	                alt28=1;
            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // InternalExpression.g:2172:7: ( (lv_arguments_5_0= ruleArgument ) ) (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )*
            	                    {
            	                    // InternalExpression.g:2172:7: ( (lv_arguments_5_0= ruleArgument ) )
            	                    // InternalExpression.g:2173:8: (lv_arguments_5_0= ruleArgument )
            	                    {
            	                    // InternalExpression.g:2173:8: (lv_arguments_5_0= ruleArgument )
            	                    // InternalExpression.g:2174:9: lv_arguments_5_0= ruleArgument
            	                    {
            	                    if ( state.backtracking==0 ) {

            	                      									newCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsArgumentParserRuleCall_1_2_0_1_0_0());
            	                      								
            	                    }
            	                    pushFollow(FOLLOW_9);
            	                    lv_arguments_5_0=ruleArgument();

            	                    state._fsp--;
            	                    if (state.failed) return current;
            	                    if ( state.backtracking==0 ) {

            	                      									if (current==null) {
            	                      										current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	                      									}
            	                      									add(
            	                      										current,
            	                      										"arguments",
            	                      										lv_arguments_5_0,
            	                      										"com.act21.rule.engine.dsl.Expression.Argument");
            	                      									afterParserOrEnumRuleCall();
            	                      								
            	                    }

            	                    }


            	                    }

            	                    // InternalExpression.g:2191:7: (otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) ) )*
            	                    loop27:
            	                    do {
            	                        int alt27=2;
            	                        int LA27_0 = input.LA(1);

            	                        if ( (LA27_0==17) ) {
            	                            alt27=1;
            	                        }


            	                        switch (alt27) {
            	                    	case 1 :
            	                    	    // InternalExpression.g:2192:8: otherlv_6= ',' ( (lv_arguments_7_0= ruleArgument ) )
            	                    	    {
            	                    	    otherlv_6=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      								newLeafNode(otherlv_6, grammarAccess.getFeatureCallAccess().getCommaKeyword_1_2_0_1_1_0());
            	                    	      							
            	                    	    }
            	                    	    // InternalExpression.g:2196:8: ( (lv_arguments_7_0= ruleArgument ) )
            	                    	    // InternalExpression.g:2197:9: (lv_arguments_7_0= ruleArgument )
            	                    	    {
            	                    	    // InternalExpression.g:2197:9: (lv_arguments_7_0= ruleArgument )
            	                    	    // InternalExpression.g:2198:10: lv_arguments_7_0= ruleArgument
            	                    	    {
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										newCompositeNode(grammarAccess.getFeatureCallAccess().getArgumentsArgumentParserRuleCall_1_2_0_1_1_1_0());
            	                    	      									
            	                    	    }
            	                    	    pushFollow(FOLLOW_9);
            	                    	    lv_arguments_7_0=ruleArgument();

            	                    	    state._fsp--;
            	                    	    if (state.failed) return current;
            	                    	    if ( state.backtracking==0 ) {

            	                    	      										if (current==null) {
            	                    	      											current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	                    	      										}
            	                    	      										add(
            	                    	      											current,
            	                    	      											"arguments",
            	                    	      											lv_arguments_7_0,
            	                    	      											"com.act21.rule.engine.dsl.Expression.Argument");
            	                    	      										afterParserOrEnumRuleCall();
            	                    	      									
            	                    	    }

            	                    	    }


            	                    	    }


            	                    	    }
            	                    	    break;

            	                    	default :
            	                    	    break loop27;
            	                        }
            	                    } while (true);


            	                    }
            	                    break;

            	            }

            	            otherlv_8=(Token)match(input,18,FOLLOW_31); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              						newLeafNode(otherlv_8, grammarAccess.getFeatureCallAccess().getRightParenthesisKeyword_1_2_0_2());
            	              					
            	            }

            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalExpression.g:2223:5: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* )
            	            {
            	            // InternalExpression.g:2223:5: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )* )
            	            // InternalExpression.g:2224:6: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )*
            	            {
            	            // InternalExpression.g:2224:6: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' ) )
            	            // InternalExpression.g:2225:7: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' )
            	            {
            	            // InternalExpression.g:2239:7: ( ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']' )
            	            // InternalExpression.g:2240:8: ( (lv_arrayAccess_9_0= '[' ) ) ( (lv_arraySelector_10_0= ruleExpression ) ) otherlv_11= ']'
            	            {
            	            // InternalExpression.g:2240:8: ( (lv_arrayAccess_9_0= '[' ) )
            	            // InternalExpression.g:2241:9: (lv_arrayAccess_9_0= '[' )
            	            {
            	            // InternalExpression.g:2241:9: (lv_arrayAccess_9_0= '[' )
            	            // InternalExpression.g:2242:10: lv_arrayAccess_9_0= '['
            	            {
            	            lv_arrayAccess_9_0=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										newLeafNode(lv_arrayAccess_9_0, grammarAccess.getFeatureCallAccess().getArrayAccessLeftSquareBracketKeyword_1_2_1_0_0_0_0());
            	              									
            	            }
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElement(grammarAccess.getFeatureCallRule());
            	              										}
            	              										setWithLastConsumed(current, "arrayAccess", lv_arrayAccess_9_0 != null, "[");
            	              									
            	            }

            	            }


            	            }

            	            // InternalExpression.g:2254:8: ( (lv_arraySelector_10_0= ruleExpression ) )
            	            // InternalExpression.g:2255:9: (lv_arraySelector_10_0= ruleExpression )
            	            {
            	            // InternalExpression.g:2255:9: (lv_arraySelector_10_0= ruleExpression )
            	            // InternalExpression.g:2256:10: lv_arraySelector_10_0= ruleExpression
            	            {
            	            if ( state.backtracking==0 ) {

            	              										newCompositeNode(grammarAccess.getFeatureCallAccess().getArraySelectorExpressionParserRuleCall_1_2_1_0_0_1_0());
            	              									
            	            }
            	            pushFollow(FOLLOW_34);
            	            lv_arraySelector_10_0=ruleExpression();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              										if (current==null) {
            	              											current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	              										}
            	              										add(
            	              											current,
            	              											"arraySelector",
            	              											lv_arraySelector_10_0,
            	              											"com.act21.rule.engine.dsl.Expression.Expression");
            	              										afterParserOrEnumRuleCall();
            	              									
            	            }

            	            }


            	            }

            	            otherlv_11=(Token)match(input,28,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              								newLeafNode(otherlv_11, grammarAccess.getFeatureCallAccess().getRightSquareBracketKeyword_1_2_1_0_0_2());
            	              							
            	            }

            	            }


            	            }

            	            // InternalExpression.g:2279:6: ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' ) )*
            	            loop29:
            	            do {
            	                int alt29=2;
            	                int LA29_0 = input.LA(1);

            	                if ( (LA29_0==29) && (synpred5_InternalExpression())) {
            	                    alt29=1;
            	                }


            	                switch (alt29) {
            	            	case 1 :
            	            	    // InternalExpression.g:2280:7: ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' )
            	            	    {
            	            	    // InternalExpression.g:2290:7: (otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']' )
            	            	    // InternalExpression.g:2291:8: otherlv_12= '[' ( (lv_arraySelector_13_0= ruleExpression ) ) otherlv_14= ']'
            	            	    {
            	            	    otherlv_12=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      								newLeafNode(otherlv_12, grammarAccess.getFeatureCallAccess().getLeftSquareBracketKeyword_1_2_1_1_0_0());
            	            	      							
            	            	    }
            	            	    // InternalExpression.g:2295:8: ( (lv_arraySelector_13_0= ruleExpression ) )
            	            	    // InternalExpression.g:2296:9: (lv_arraySelector_13_0= ruleExpression )
            	            	    {
            	            	    // InternalExpression.g:2296:9: (lv_arraySelector_13_0= ruleExpression )
            	            	    // InternalExpression.g:2297:10: lv_arraySelector_13_0= ruleExpression
            	            	    {
            	            	    if ( state.backtracking==0 ) {

            	            	      										newCompositeNode(grammarAccess.getFeatureCallAccess().getArraySelectorExpressionParserRuleCall_1_2_1_1_0_1_0());
            	            	      									
            	            	    }
            	            	    pushFollow(FOLLOW_34);
            	            	    lv_arraySelector_13_0=ruleExpression();

            	            	    state._fsp--;
            	            	    if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      										if (current==null) {
            	            	      											current = createModelElementForParent(grammarAccess.getFeatureCallRule());
            	            	      										}
            	            	      										add(
            	            	      											current,
            	            	      											"arraySelector",
            	            	      											lv_arraySelector_13_0,
            	            	      											"com.act21.rule.engine.dsl.Expression.Expression");
            	            	      										afterParserOrEnumRuleCall();
            	            	      									
            	            	    }

            	            	    }


            	            	    }

            	            	    otherlv_14=(Token)match(input,28,FOLLOW_35); if (state.failed) return current;
            	            	    if ( state.backtracking==0 ) {

            	            	      								newLeafNode(otherlv_14, grammarAccess.getFeatureCallAccess().getRightSquareBracketKeyword_1_2_1_1_0_2());
            	            	      							
            	            	    }

            	            	    }


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop29;
            	                }
            	            } while (true);


            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleFeatureCall"


    // $ANTLR start "entryRuleElementReferenceExpression"
    // InternalExpression.g:2327:1: entryRuleElementReferenceExpression returns [EObject current=null] : iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF ;
    public final EObject entryRuleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementReferenceExpression = null;


        try {
            // InternalExpression.g:2327:67: (iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF )
            // InternalExpression.g:2328:2: iv_ruleElementReferenceExpression= ruleElementReferenceExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElementReferenceExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElementReferenceExpression=ruleElementReferenceExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElementReferenceExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleElementReferenceExpression"


    // $ANTLR start "ruleElementReferenceExpression"
    // InternalExpression.g:2334:1: ruleElementReferenceExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ( (lv_unresolvedText_2_0= RULE_STRING ) )? ( ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* ) )? ) ;
    public final EObject ruleElementReferenceExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_unresolvedText_2_0=null;
        Token lv_operationCall_3_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_arrayAccess_8_0=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        EObject lv_arguments_4_0 = null;

        EObject lv_arguments_6_0 = null;

        EObject lv_arraySelector_9_0 = null;

        EObject lv_arraySelector_12_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2340:2: ( ( () ( (otherlv_1= RULE_ID ) ) ( (lv_unresolvedText_2_0= RULE_STRING ) )? ( ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* ) )? ) )
            // InternalExpression.g:2341:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_unresolvedText_2_0= RULE_STRING ) )? ( ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* ) )? )
            {
            // InternalExpression.g:2341:2: ( () ( (otherlv_1= RULE_ID ) ) ( (lv_unresolvedText_2_0= RULE_STRING ) )? ( ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* ) )? )
            // InternalExpression.g:2342:3: () ( (otherlv_1= RULE_ID ) ) ( (lv_unresolvedText_2_0= RULE_STRING ) )? ( ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* ) )?
            {
            // InternalExpression.g:2342:3: ()
            // InternalExpression.g:2343:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getElementReferenceExpressionAccess().getElementReferenceExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalExpression.g:2349:3: ( (otherlv_1= RULE_ID ) )
            // InternalExpression.g:2350:4: (otherlv_1= RULE_ID )
            {
            // InternalExpression.g:2350:4: (otherlv_1= RULE_ID )
            // InternalExpression.g:2351:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getElementReferenceExpressionAccess().getReferenceNamedElementCrossReference_1_0());
              				
            }

            }


            }

            // InternalExpression.g:2362:3: ( (lv_unresolvedText_2_0= RULE_STRING ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==RULE_STRING) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalExpression.g:2363:4: (lv_unresolvedText_2_0= RULE_STRING )
                    {
                    // InternalExpression.g:2363:4: (lv_unresolvedText_2_0= RULE_STRING )
                    // InternalExpression.g:2364:5: lv_unresolvedText_2_0= RULE_STRING
                    {
                    lv_unresolvedText_2_0=(Token)match(input,RULE_STRING,FOLLOW_37); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_unresolvedText_2_0, grammarAccess.getElementReferenceExpressionAccess().getUnresolvedTextSTRINGTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"unresolvedText",
                      						lv_unresolvedText_2_0,
                      						"org.eclipse.xtext.common.Terminals.STRING");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalExpression.g:2380:3: ( ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' ) | ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* ) )?
            int alt36=3;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==16) && (synpred6_InternalExpression())) {
                alt36=1;
            }
            else if ( (LA36_0==29) && (synpred7_InternalExpression())) {
                alt36=2;
            }
            switch (alt36) {
                case 1 :
                    // InternalExpression.g:2381:4: ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' )
                    {
                    // InternalExpression.g:2381:4: ( ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')' )
                    // InternalExpression.g:2382:5: ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) ) ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )? otherlv_7= ')'
                    {
                    // InternalExpression.g:2382:5: ( ( ( '(' ) )=> (lv_operationCall_3_0= '(' ) )
                    // InternalExpression.g:2383:6: ( ( '(' ) )=> (lv_operationCall_3_0= '(' )
                    {
                    // InternalExpression.g:2387:6: (lv_operationCall_3_0= '(' )
                    // InternalExpression.g:2388:7: lv_operationCall_3_0= '('
                    {
                    lv_operationCall_3_0=(Token)match(input,16,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_operationCall_3_0, grammarAccess.getElementReferenceExpressionAccess().getOperationCallLeftParenthesisKeyword_3_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
                      							}
                      							setWithLastConsumed(current, "operationCall", lv_operationCall_3_0 != null, "(");
                      						
                    }

                    }


                    }

                    // InternalExpression.g:2400:5: ( ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )* )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=RULE_ID && LA34_0<=RULE_STRING)||LA34_0==16||(LA34_0>=22 && LA34_0<=23)||(LA34_0>=28 && LA34_0<=33)||(LA34_0>=37 && LA34_0<=43)) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // InternalExpression.g:2401:6: ( (lv_arguments_4_0= ruleArgument ) ) (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )*
                            {
                            // InternalExpression.g:2401:6: ( (lv_arguments_4_0= ruleArgument ) )
                            // InternalExpression.g:2402:7: (lv_arguments_4_0= ruleArgument )
                            {
                            // InternalExpression.g:2402:7: (lv_arguments_4_0= ruleArgument )
                            // InternalExpression.g:2403:8: lv_arguments_4_0= ruleArgument
                            {
                            if ( state.backtracking==0 ) {

                              								newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgumentsArgumentParserRuleCall_3_0_1_0_0());
                              							
                            }
                            pushFollow(FOLLOW_9);
                            lv_arguments_4_0=ruleArgument();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              								if (current==null) {
                              									current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                              								}
                              								add(
                              									current,
                              									"arguments",
                              									lv_arguments_4_0,
                              									"com.act21.rule.engine.dsl.Expression.Argument");
                              								afterParserOrEnumRuleCall();
                              							
                            }

                            }


                            }

                            // InternalExpression.g:2420:6: (otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) ) )*
                            loop33:
                            do {
                                int alt33=2;
                                int LA33_0 = input.LA(1);

                                if ( (LA33_0==17) ) {
                                    alt33=1;
                                }


                                switch (alt33) {
                            	case 1 :
                            	    // InternalExpression.g:2421:7: otherlv_5= ',' ( (lv_arguments_6_0= ruleArgument ) )
                            	    {
                            	    otherlv_5=(Token)match(input,17,FOLLOW_19); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							newLeafNode(otherlv_5, grammarAccess.getElementReferenceExpressionAccess().getCommaKeyword_3_0_1_1_0());
                            	      						
                            	    }
                            	    // InternalExpression.g:2425:7: ( (lv_arguments_6_0= ruleArgument ) )
                            	    // InternalExpression.g:2426:8: (lv_arguments_6_0= ruleArgument )
                            	    {
                            	    // InternalExpression.g:2426:8: (lv_arguments_6_0= ruleArgument )
                            	    // InternalExpression.g:2427:9: lv_arguments_6_0= ruleArgument
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArgumentsArgumentParserRuleCall_3_0_1_1_1_0());
                            	      								
                            	    }
                            	    pushFollow(FOLLOW_9);
                            	    lv_arguments_6_0=ruleArgument();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      									if (current==null) {
                            	      										current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                            	      									}
                            	      									add(
                            	      										current,
                            	      										"arguments",
                            	      										lv_arguments_6_0,
                            	      										"com.act21.rule.engine.dsl.Expression.Argument");
                            	      									afterParserOrEnumRuleCall();
                            	      								
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop33;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getElementReferenceExpressionAccess().getRightParenthesisKeyword_3_0_2());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2452:4: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* )
                    {
                    // InternalExpression.g:2452:4: ( ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )* )
                    // InternalExpression.g:2453:5: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) ) ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )*
                    {
                    // InternalExpression.g:2453:5: ( ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' ) )
                    // InternalExpression.g:2454:6: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )=> ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' )
                    {
                    // InternalExpression.g:2468:6: ( ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']' )
                    // InternalExpression.g:2469:7: ( (lv_arrayAccess_8_0= '[' ) ) ( (lv_arraySelector_9_0= ruleExpression ) ) otherlv_10= ']'
                    {
                    // InternalExpression.g:2469:7: ( (lv_arrayAccess_8_0= '[' ) )
                    // InternalExpression.g:2470:8: (lv_arrayAccess_8_0= '[' )
                    {
                    // InternalExpression.g:2470:8: (lv_arrayAccess_8_0= '[' )
                    // InternalExpression.g:2471:9: lv_arrayAccess_8_0= '['
                    {
                    lv_arrayAccess_8_0=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									newLeafNode(lv_arrayAccess_8_0, grammarAccess.getElementReferenceExpressionAccess().getArrayAccessLeftSquareBracketKeyword_3_1_0_0_0_0());
                      								
                    }
                    if ( state.backtracking==0 ) {

                      									if (current==null) {
                      										current = createModelElement(grammarAccess.getElementReferenceExpressionRule());
                      									}
                      									setWithLastConsumed(current, "arrayAccess", lv_arrayAccess_8_0 != null, "[");
                      								
                    }

                    }


                    }

                    // InternalExpression.g:2483:7: ( (lv_arraySelector_9_0= ruleExpression ) )
                    // InternalExpression.g:2484:8: (lv_arraySelector_9_0= ruleExpression )
                    {
                    // InternalExpression.g:2484:8: (lv_arraySelector_9_0= ruleExpression )
                    // InternalExpression.g:2485:9: lv_arraySelector_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArraySelectorExpressionParserRuleCall_3_1_0_0_1_0());
                      								
                    }
                    pushFollow(FOLLOW_34);
                    lv_arraySelector_9_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      									if (current==null) {
                      										current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                      									}
                      									add(
                      										current,
                      										"arraySelector",
                      										lv_arraySelector_9_0,
                      										"com.act21.rule.engine.dsl.Expression.Expression");
                      									afterParserOrEnumRuleCall();
                      								
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,28,FOLLOW_38); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_10, grammarAccess.getElementReferenceExpressionAccess().getRightSquareBracketKeyword_3_1_0_0_2());
                      						
                    }

                    }


                    }

                    // InternalExpression.g:2508:5: ( ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' ) )*
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==29) && (synpred8_InternalExpression())) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // InternalExpression.g:2509:6: ( ( '[' ( ( ruleExpression ) ) ']' ) )=> (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' )
                    	    {
                    	    // InternalExpression.g:2519:6: (otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']' )
                    	    // InternalExpression.g:2520:7: otherlv_11= '[' ( (lv_arraySelector_12_0= ruleExpression ) ) otherlv_13= ']'
                    	    {
                    	    otherlv_11=(Token)match(input,29,FOLLOW_19); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_11, grammarAccess.getElementReferenceExpressionAccess().getLeftSquareBracketKeyword_3_1_1_0_0());
                    	      						
                    	    }
                    	    // InternalExpression.g:2524:7: ( (lv_arraySelector_12_0= ruleExpression ) )
                    	    // InternalExpression.g:2525:8: (lv_arraySelector_12_0= ruleExpression )
                    	    {
                    	    // InternalExpression.g:2525:8: (lv_arraySelector_12_0= ruleExpression )
                    	    // InternalExpression.g:2526:9: lv_arraySelector_12_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      									newCompositeNode(grammarAccess.getElementReferenceExpressionAccess().getArraySelectorExpressionParserRuleCall_3_1_1_0_1_0());
                    	      								
                    	    }
                    	    pushFollow(FOLLOW_34);
                    	    lv_arraySelector_12_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      									if (current==null) {
                    	      										current = createModelElementForParent(grammarAccess.getElementReferenceExpressionRule());
                    	      									}
                    	      									add(
                    	      										current,
                    	      										"arraySelector",
                    	      										lv_arraySelector_12_0,
                    	      										"com.act21.rule.engine.dsl.Expression.Expression");
                    	      									afterParserOrEnumRuleCall();
                    	      								
                    	    }

                    	    }


                    	    }

                    	    otherlv_13=(Token)match(input,28,FOLLOW_38); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							newLeafNode(otherlv_13, grammarAccess.getElementReferenceExpressionAccess().getRightSquareBracketKeyword_3_1_1_0_2());
                    	      						
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop35;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleElementReferenceExpression"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalExpression.g:2555:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalExpression.g:2555:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalExpression.g:2556:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalExpression.g:2562:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalExpression.g:2568:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalExpression.g:2569:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalExpression.g:2569:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalExpression.g:2570:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalExpression.g:2577:3: (kw= '.' this_ID_2= RULE_ID )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==34) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // InternalExpression.g:2578:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,34,FOLLOW_4); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleArgument"
    // InternalExpression.g:2595:1: entryRuleArgument returns [EObject current=null] : iv_ruleArgument= ruleArgument EOF ;
    public final EObject entryRuleArgument() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArgument = null;


        try {
            // InternalExpression.g:2595:49: (iv_ruleArgument= ruleArgument EOF )
            // InternalExpression.g:2596:2: iv_ruleArgument= ruleArgument EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArgumentRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleArgument=ruleArgument();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArgument; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArgument"


    // $ANTLR start "ruleArgument"
    // InternalExpression.g:2602:1: ruleArgument returns [EObject current=null] : ( (lv_value_0_0= ruleExpression ) ) ;
    public final EObject ruleArgument() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalExpression.g:2608:2: ( ( (lv_value_0_0= ruleExpression ) ) )
            // InternalExpression.g:2609:2: ( (lv_value_0_0= ruleExpression ) )
            {
            // InternalExpression.g:2609:2: ( (lv_value_0_0= ruleExpression ) )
            // InternalExpression.g:2610:3: (lv_value_0_0= ruleExpression )
            {
            // InternalExpression.g:2610:3: (lv_value_0_0= ruleExpression )
            // InternalExpression.g:2611:4: lv_value_0_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getArgumentAccess().getValueExpressionParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getArgumentRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"com.act21.rule.engine.dsl.Expression.Expression");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleArgument"


    // $ANTLR start "entryRuleDecimal"
    // InternalExpression.g:2631:1: entryRuleDecimal returns [String current=null] : iv_ruleDecimal= ruleDecimal EOF ;
    public final String entryRuleDecimal() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleDecimal = null;


        try {
            // InternalExpression.g:2631:47: (iv_ruleDecimal= ruleDecimal EOF )
            // InternalExpression.g:2632:2: iv_ruleDecimal= ruleDecimal EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDecimalRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDecimal=ruleDecimal();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDecimal.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDecimal"


    // $ANTLR start "ruleDecimal"
    // InternalExpression.g:2638:1: ruleDecimal returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_BIGINT_0= RULE_BIGINT (kw= '.' this_BIGINT_2= RULE_BIGINT ) ) ;
    public final AntlrDatatypeRuleToken ruleDecimal() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_BIGINT_0=null;
        Token kw=null;
        Token this_BIGINT_2=null;


        	enterRule();

        try {
            // InternalExpression.g:2644:2: ( (this_BIGINT_0= RULE_BIGINT (kw= '.' this_BIGINT_2= RULE_BIGINT ) ) )
            // InternalExpression.g:2645:2: (this_BIGINT_0= RULE_BIGINT (kw= '.' this_BIGINT_2= RULE_BIGINT ) )
            {
            // InternalExpression.g:2645:2: (this_BIGINT_0= RULE_BIGINT (kw= '.' this_BIGINT_2= RULE_BIGINT ) )
            // InternalExpression.g:2646:3: this_BIGINT_0= RULE_BIGINT (kw= '.' this_BIGINT_2= RULE_BIGINT )
            {
            this_BIGINT_0=(Token)match(input,RULE_BIGINT,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_BIGINT_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BIGINT_0, grammarAccess.getDecimalAccess().getBIGINTTerminalRuleCall_0());
              		
            }
            // InternalExpression.g:2653:3: (kw= '.' this_BIGINT_2= RULE_BIGINT )
            // InternalExpression.g:2654:4: kw= '.' this_BIGINT_2= RULE_BIGINT
            {
            kw=(Token)match(input,34,FOLLOW_40); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				current.merge(kw);
              				newLeafNode(kw, grammarAccess.getDecimalAccess().getFullStopKeyword_1_0());
              			
            }
            this_BIGINT_2=(Token)match(input,RULE_BIGINT,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				current.merge(this_BIGINT_2);
              			
            }
            if ( state.backtracking==0 ) {

              				newLeafNode(this_BIGINT_2, grammarAccess.getDecimalAccess().getBIGINTTerminalRuleCall_1_1());
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleDecimal"


    // $ANTLR start "entryRuleLogicalAndOperator"
    // InternalExpression.g:2671:1: entryRuleLogicalAndOperator returns [String current=null] : iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF ;
    public final String entryRuleLogicalAndOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalAndOperator = null;


        try {
            // InternalExpression.g:2671:58: (iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF )
            // InternalExpression.g:2672:2: iv_ruleLogicalAndOperator= ruleLogicalAndOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndOperator=ruleLogicalAndOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalAndOperator"


    // $ANTLR start "ruleLogicalAndOperator"
    // InternalExpression.g:2678:1: ruleLogicalAndOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '&&' ;
    public final AntlrDatatypeRuleToken ruleLogicalAndOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExpression.g:2684:2: (kw= '&&' )
            // InternalExpression.g:2685:2: kw= '&&'
            {
            kw=(Token)match(input,35,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getLogicalAndOperatorAccess().getAmpersandAmpersandKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalAndOperator"


    // $ANTLR start "entryRuleLogicalOrOperator"
    // InternalExpression.g:2693:1: entryRuleLogicalOrOperator returns [String current=null] : iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF ;
    public final String entryRuleLogicalOrOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalOrOperator = null;


        try {
            // InternalExpression.g:2693:57: (iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF )
            // InternalExpression.g:2694:2: iv_ruleLogicalOrOperator= ruleLogicalOrOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrOperator=ruleLogicalOrOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalOrOperator"


    // $ANTLR start "ruleLogicalOrOperator"
    // InternalExpression.g:2700:1: ruleLogicalOrOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '||' ;
    public final AntlrDatatypeRuleToken ruleLogicalOrOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExpression.g:2706:2: (kw= '||' )
            // InternalExpression.g:2707:2: kw= '||'
            {
            kw=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getLogicalOrOperatorAccess().getVerticalLineVerticalLineKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalOrOperator"


    // $ANTLR start "entryRuleLogicalNotOperator"
    // InternalExpression.g:2715:1: entryRuleLogicalNotOperator returns [String current=null] : iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF ;
    public final String entryRuleLogicalNotOperator() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLogicalNotOperator = null;


        try {
            // InternalExpression.g:2715:58: (iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF )
            // InternalExpression.g:2716:2: iv_ruleLogicalNotOperator= ruleLogicalNotOperator EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalNotOperatorRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalNotOperator=ruleLogicalNotOperator();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalNotOperator.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLogicalNotOperator"


    // $ANTLR start "ruleLogicalNotOperator"
    // InternalExpression.g:2722:1: ruleLogicalNotOperator returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '!' ;
    public final AntlrDatatypeRuleToken ruleLogicalNotOperator() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalExpression.g:2728:2: (kw= '!' )
            // InternalExpression.g:2729:2: kw= '!'
            {
            kw=(Token)match(input,37,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(kw);
              		newLeafNode(kw, grammarAccess.getLogicalNotOperatorAccess().getExclamationMarkKeyword());
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleLogicalNotOperator"


    // $ANTLR start "ruleRelationalOperator"
    // InternalExpression.g:2737:1: ruleRelationalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) ) ;
    public final Enumerator ruleRelationalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalExpression.g:2743:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) ) )
            // InternalExpression.g:2744:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) )
            {
            // InternalExpression.g:2744:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) )
            int alt38=7;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt38=1;
                }
                break;
            case 38:
                {
                alt38=2;
                }
                break;
            case 23:
                {
                alt38=3;
                }
                break;
            case 39:
                {
                alt38=4;
                }
                break;
            case 40:
                {
                alt38=5;
                }
                break;
            case 41:
                {
                alt38=6;
                }
                break;
            case 42:
                {
                alt38=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalExpression.g:2745:3: (enumLiteral_0= '<' )
                    {
                    // InternalExpression.g:2745:3: (enumLiteral_0= '<' )
                    // InternalExpression.g:2746:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRelationalOperatorAccess().getSmallerEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2753:3: (enumLiteral_1= '<=' )
                    {
                    // InternalExpression.g:2753:3: (enumLiteral_1= '<=' )
                    // InternalExpression.g:2754:4: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRelationalOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExpression.g:2761:3: (enumLiteral_2= '>' )
                    {
                    // InternalExpression.g:2761:3: (enumLiteral_2= '>' )
                    // InternalExpression.g:2762:4: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRelationalOperatorAccess().getGreaterEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExpression.g:2769:3: (enumLiteral_3= '>=' )
                    {
                    // InternalExpression.g:2769:3: (enumLiteral_3= '>=' )
                    // InternalExpression.g:2770:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRelationalOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExpression.g:2777:3: (enumLiteral_4= '==' )
                    {
                    // InternalExpression.g:2777:3: (enumLiteral_4= '==' )
                    // InternalExpression.g:2778:4: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRelationalOperatorAccess().getEqualsEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExpression.g:2785:3: (enumLiteral_5= '!=' )
                    {
                    // InternalExpression.g:2785:3: (enumLiteral_5= '!=' )
                    // InternalExpression.g:2786:4: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRelationalOperatorAccess().getNotEqualsEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalExpression.g:2793:3: (enumLiteral_6= 'upto' )
                    {
                    // InternalExpression.g:2793:3: (enumLiteral_6= 'upto' )
                    // InternalExpression.g:2794:4: enumLiteral_6= 'upto'
                    {
                    enumLiteral_6=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalOperatorAccess().getUptoEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRelationalOperatorAccess().getUptoEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRelationalOperator"


    // $ANTLR start "ruleNumericalOperator"
    // InternalExpression.g:2804:1: ruleNumericalOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) ;
    public final Enumerator ruleNumericalOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalExpression.g:2810:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) ) )
            // InternalExpression.g:2811:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            {
            // InternalExpression.g:2811:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '*' ) | (enumLiteral_3= '/' ) | (enumLiteral_4= '%' ) )
            int alt39=5;
            switch ( input.LA(1) ) {
            case 43:
                {
                alt39=1;
                }
                break;
            case 30:
                {
                alt39=2;
                }
                break;
            case 44:
                {
                alt39=3;
                }
                break;
            case 45:
                {
                alt39=4;
                }
                break;
            case 46:
                {
                alt39=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalExpression.g:2812:3: (enumLiteral_0= '+' )
                    {
                    // InternalExpression.g:2812:3: (enumLiteral_0= '+' )
                    // InternalExpression.g:2813:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericalOperatorAccess().getPlusEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getNumericalOperatorAccess().getPlusEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2820:3: (enumLiteral_1= '-' )
                    {
                    // InternalExpression.g:2820:3: (enumLiteral_1= '-' )
                    // InternalExpression.g:2821:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericalOperatorAccess().getMinusEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getNumericalOperatorAccess().getMinusEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExpression.g:2828:3: (enumLiteral_2= '*' )
                    {
                    // InternalExpression.g:2828:3: (enumLiteral_2= '*' )
                    // InternalExpression.g:2829:4: enumLiteral_2= '*'
                    {
                    enumLiteral_2=(Token)match(input,44,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericalOperatorAccess().getMulEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getNumericalOperatorAccess().getMulEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExpression.g:2836:3: (enumLiteral_3= '/' )
                    {
                    // InternalExpression.g:2836:3: (enumLiteral_3= '/' )
                    // InternalExpression.g:2837:4: enumLiteral_3= '/'
                    {
                    enumLiteral_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericalOperatorAccess().getDivEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getNumericalOperatorAccess().getDivEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExpression.g:2844:3: (enumLiteral_4= '%' )
                    {
                    // InternalExpression.g:2844:3: (enumLiteral_4= '%' )
                    // InternalExpression.g:2845:4: enumLiteral_4= '%'
                    {
                    enumLiteral_4=(Token)match(input,46,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericalOperatorAccess().getModEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getNumericalOperatorAccess().getModEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNumericalOperator"


    // $ANTLR start "ruleNumericUnaryOperator"
    // InternalExpression.g:2855:1: ruleNumericUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleNumericUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalExpression.g:2861:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalExpression.g:2862:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalExpression.g:2862:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==43) ) {
                alt40=1;
            }
            else if ( (LA40_0==30) ) {
                alt40=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // InternalExpression.g:2863:3: (enumLiteral_0= '+' )
                    {
                    // InternalExpression.g:2863:3: (enumLiteral_0= '+' )
                    // InternalExpression.g:2864:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getNumericUnaryOperatorAccess().getPositiveEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2871:3: (enumLiteral_1= '-' )
                    {
                    // InternalExpression.g:2871:3: (enumLiteral_1= '-' )
                    // InternalExpression.g:2872:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getNumericUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getNumericUnaryOperatorAccess().getNegativeEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleNumericUnaryOperator"


    // $ANTLR start "ruleRelationalUnaryOperator"
    // InternalExpression.g:2882:1: ruleRelationalUnaryOperator returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) ) ;
    public final Enumerator ruleRelationalUnaryOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalExpression.g:2888:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) ) )
            // InternalExpression.g:2889:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) )
            {
            // InternalExpression.g:2889:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '<=' ) | (enumLiteral_2= '>' ) | (enumLiteral_3= '>=' ) | (enumLiteral_4= '==' ) | (enumLiteral_5= '!=' ) | (enumLiteral_6= 'upto' ) )
            int alt41=7;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt41=1;
                }
                break;
            case 38:
                {
                alt41=2;
                }
                break;
            case 23:
                {
                alt41=3;
                }
                break;
            case 39:
                {
                alt41=4;
                }
                break;
            case 40:
                {
                alt41=5;
                }
                break;
            case 41:
                {
                alt41=6;
                }
                break;
            case 42:
                {
                alt41=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // InternalExpression.g:2890:3: (enumLiteral_0= '<' )
                    {
                    // InternalExpression.g:2890:3: (enumLiteral_0= '<' )
                    // InternalExpression.g:2891:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getSmallerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRelationalUnaryOperatorAccess().getSmallerEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2898:3: (enumLiteral_1= '<=' )
                    {
                    // InternalExpression.g:2898:3: (enumLiteral_1= '<=' )
                    // InternalExpression.g:2899:4: enumLiteral_1= '<='
                    {
                    enumLiteral_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRelationalUnaryOperatorAccess().getSmallerEqualEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalExpression.g:2906:3: (enumLiteral_2= '>' )
                    {
                    // InternalExpression.g:2906:3: (enumLiteral_2= '>' )
                    // InternalExpression.g:2907:4: enumLiteral_2= '>'
                    {
                    enumLiteral_2=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getGreaterEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getRelationalUnaryOperatorAccess().getGreaterEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalExpression.g:2914:3: (enumLiteral_3= '>=' )
                    {
                    // InternalExpression.g:2914:3: (enumLiteral_3= '>=' )
                    // InternalExpression.g:2915:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,39,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getRelationalUnaryOperatorAccess().getGreaterEqualEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalExpression.g:2922:3: (enumLiteral_4= '==' )
                    {
                    // InternalExpression.g:2922:3: (enumLiteral_4= '==' )
                    // InternalExpression.g:2923:4: enumLiteral_4= '=='
                    {
                    enumLiteral_4=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getEqualsEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getRelationalUnaryOperatorAccess().getEqualsEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalExpression.g:2930:3: (enumLiteral_5= '!=' )
                    {
                    // InternalExpression.g:2930:3: (enumLiteral_5= '!=' )
                    // InternalExpression.g:2931:4: enumLiteral_5= '!='
                    {
                    enumLiteral_5=(Token)match(input,41,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getNotEqualsEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getRelationalUnaryOperatorAccess().getNotEqualsEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalExpression.g:2938:3: (enumLiteral_6= 'upto' )
                    {
                    // InternalExpression.g:2938:3: (enumLiteral_6= 'upto' )
                    // InternalExpression.g:2939:4: enumLiteral_6= 'upto'
                    {
                    enumLiteral_6=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRelationalUnaryOperatorAccess().getUptoEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getRelationalUnaryOperatorAccess().getUptoEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

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
    // $ANTLR end "ruleRelationalUnaryOperator"

    // $ANTLR start synpred1_InternalExpression
    public final void synpred1_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:1027:4: ( ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) ) )
        // InternalExpression.g:1027:5: ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) )
        {
        // InternalExpression.g:1027:5: ( () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) ) )
        // InternalExpression.g:1028:5: () ( ( ruleRelationalOperator ) ) ( ( ruleRelationalUnaryExpression ) )
        {
        // InternalExpression.g:1028:5: ()
        // InternalExpression.g:1029:5: 
        {
        }

        // InternalExpression.g:1030:5: ( ( ruleRelationalOperator ) )
        // InternalExpression.g:1031:6: ( ruleRelationalOperator )
        {
        // InternalExpression.g:1031:6: ( ruleRelationalOperator )
        // InternalExpression.g:1032:7: ruleRelationalOperator
        {
        pushFollow(FOLLOW_22);
        ruleRelationalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalExpression.g:1035:5: ( ( ruleRelationalUnaryExpression ) )
        // InternalExpression.g:1036:6: ( ruleRelationalUnaryExpression )
        {
        // InternalExpression.g:1036:6: ( ruleRelationalUnaryExpression )
        // InternalExpression.g:1037:7: ruleRelationalUnaryExpression
        {
        pushFollow(FOLLOW_2);
        ruleRelationalUnaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred1_InternalExpression

    // $ANTLR start synpred2_InternalExpression
    public final void synpred2_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:1268:4: ( ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) ) )
        // InternalExpression.g:1268:5: ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) )
        {
        // InternalExpression.g:1268:5: ( () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) ) )
        // InternalExpression.g:1269:5: () ( ( ruleNumericalOperator ) ) ( ( rulePrimaryExpression ) )
        {
        // InternalExpression.g:1269:5: ()
        // InternalExpression.g:1270:5: 
        {
        }

        // InternalExpression.g:1271:5: ( ( ruleNumericalOperator ) )
        // InternalExpression.g:1272:6: ( ruleNumericalOperator )
        {
        // InternalExpression.g:1272:6: ( ruleNumericalOperator )
        // InternalExpression.g:1273:7: ruleNumericalOperator
        {
        pushFollow(FOLLOW_24);
        ruleNumericalOperator();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalExpression.g:1276:5: ( ( rulePrimaryExpression ) )
        // InternalExpression.g:1277:6: ( rulePrimaryExpression )
        {
        // InternalExpression.g:1277:6: ( rulePrimaryExpression )
        // InternalExpression.g:1278:7: rulePrimaryExpression
        {
        pushFollow(FOLLOW_2);
        rulePrimaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalExpression

    // $ANTLR start synpred3_InternalExpression
    public final void synpred3_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:2154:7: ( ( '(' ) )
        // InternalExpression.g:2154:8: ( '(' )
        {
        // InternalExpression.g:2154:8: ( '(' )
        // InternalExpression.g:2155:8: '('
        {
        match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred3_InternalExpression

    // $ANTLR start synpred4_InternalExpression
    public final void synpred4_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:2225:7: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )
        // InternalExpression.g:2225:8: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        {
        // InternalExpression.g:2225:8: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        // InternalExpression.g:2226:8: ( ( '[' ) ) ( ( ruleExpression ) ) ']'
        {
        // InternalExpression.g:2226:8: ( ( '[' ) )
        // InternalExpression.g:2227:9: ( '[' )
        {
        // InternalExpression.g:2227:9: ( '[' )
        // InternalExpression.g:2228:10: '['
        {
        match(input,29,FOLLOW_19); if (state.failed) return ;

        }


        }

        // InternalExpression.g:2231:8: ( ( ruleExpression ) )
        // InternalExpression.g:2232:9: ( ruleExpression )
        {
        // InternalExpression.g:2232:9: ( ruleExpression )
        // InternalExpression.g:2233:10: ruleExpression
        {
        pushFollow(FOLLOW_34);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,28,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred4_InternalExpression

    // $ANTLR start synpred5_InternalExpression
    public final void synpred5_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:2280:7: ( ( '[' ( ( ruleExpression ) ) ']' ) )
        // InternalExpression.g:2280:8: ( '[' ( ( ruleExpression ) ) ']' )
        {
        // InternalExpression.g:2280:8: ( '[' ( ( ruleExpression ) ) ']' )
        // InternalExpression.g:2281:8: '[' ( ( ruleExpression ) ) ']'
        {
        match(input,29,FOLLOW_19); if (state.failed) return ;
        // InternalExpression.g:2282:8: ( ( ruleExpression ) )
        // InternalExpression.g:2283:9: ( ruleExpression )
        {
        // InternalExpression.g:2283:9: ( ruleExpression )
        // InternalExpression.g:2284:10: ruleExpression
        {
        pushFollow(FOLLOW_34);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,28,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred5_InternalExpression

    // $ANTLR start synpred6_InternalExpression
    public final void synpred6_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:2383:6: ( ( '(' ) )
        // InternalExpression.g:2383:7: ( '(' )
        {
        // InternalExpression.g:2383:7: ( '(' )
        // InternalExpression.g:2384:7: '('
        {
        match(input,16,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred6_InternalExpression

    // $ANTLR start synpred7_InternalExpression
    public final void synpred7_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:2454:6: ( ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' ) )
        // InternalExpression.g:2454:7: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        {
        // InternalExpression.g:2454:7: ( ( ( '[' ) ) ( ( ruleExpression ) ) ']' )
        // InternalExpression.g:2455:7: ( ( '[' ) ) ( ( ruleExpression ) ) ']'
        {
        // InternalExpression.g:2455:7: ( ( '[' ) )
        // InternalExpression.g:2456:8: ( '[' )
        {
        // InternalExpression.g:2456:8: ( '[' )
        // InternalExpression.g:2457:9: '['
        {
        match(input,29,FOLLOW_19); if (state.failed) return ;

        }


        }

        // InternalExpression.g:2460:7: ( ( ruleExpression ) )
        // InternalExpression.g:2461:8: ( ruleExpression )
        {
        // InternalExpression.g:2461:8: ( ruleExpression )
        // InternalExpression.g:2462:9: ruleExpression
        {
        pushFollow(FOLLOW_34);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,28,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred7_InternalExpression

    // $ANTLR start synpred8_InternalExpression
    public final void synpred8_InternalExpression_fragment() throws RecognitionException {   
        // InternalExpression.g:2509:6: ( ( '[' ( ( ruleExpression ) ) ']' ) )
        // InternalExpression.g:2509:7: ( '[' ( ( ruleExpression ) ) ']' )
        {
        // InternalExpression.g:2509:7: ( '[' ( ( ruleExpression ) ) ']' )
        // InternalExpression.g:2510:7: '[' ( ( ruleExpression ) ) ']'
        {
        match(input,29,FOLLOW_19); if (state.failed) return ;
        // InternalExpression.g:2511:7: ( ( ruleExpression ) )
        // InternalExpression.g:2512:8: ( ruleExpression )
        {
        // InternalExpression.g:2512:8: ( ruleExpression )
        // InternalExpression.g:2513:9: ruleExpression
        {
        pushFollow(FOLLOW_34);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,28,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred8_InternalExpression

    // Delegated rules

    public final boolean synpred8_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred8_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred6_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred6_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred7_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred7_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred3_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalExpression() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalExpression_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA11 dfa11 = new DFA11(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA26 dfa26 = new DFA26(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\3\1\uffff\1\1\3\uffff\1\3\3\1\2\uffff\1\15\1\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff\11\4\1\uffff";
    static final String dfa_4s = "\1\53\1\uffff\1\56\1\uffff\1\4\1\53\1\42\2\56\1\42\1\4\1\53\1\56\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2\11\uffff\1\1";
    static final String dfa_6s = "\16\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\4\1\5\uffff\2\3\1\1\4\uffff\1\3\2\1\4\3\6\1\3\uffff\7\1",
            "",
            "\1\6\3\uffff\1\1\5\uffff\3\1\4\uffff\1\1\1\5\5\1\1\uffff\2\1\3\uffff\1\4\2\1\1\uffff\11\1",
            "",
            "\1\7",
            "\1\10\4\1\7\uffff\1\1\5\uffff\2\1\4\uffff\6\1\4\uffff\6\1",
            "\1\11\11\uffff\2\3\5\uffff\1\3\1\1\1\uffff\4\3\6\uffff\1\1",
            "\1\6\11\uffff\3\1\4\uffff\1\1\1\5\5\1\1\uffff\2\1\3\uffff\1\4\2\1\1\uffff\11\1",
            "\1\1\3\uffff\1\1\5\uffff\3\1\1\3\3\uffff\2\1\1\13\4\1\1\uffff\2\1\3\uffff\1\12\2\1\1\uffff\11\1",
            "\1\6\11\uffff\2\1\5\uffff\1\1\1\3\1\uffff\4\1\6\uffff\1\3",
            "\1\14",
            "\1\15\4\1\7\uffff\1\15\5\uffff\2\15\4\uffff\3\15\3\1\4\uffff\6\15",
            "\1\15\11\uffff\3\15\1\3\3\uffff\2\15\1\13\4\15\1\uffff\2\15\3\uffff\1\12\2\15\1\uffff\11\15",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "639:3: ( (lv_value_3_0= ruleExpression ) )?";
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "768:3: ( (lv_condition_3_0= ruleExpression ) )?";
        }
    }
    static final String dfa_8s = "\33\uffff";
    static final String dfa_9s = "\1\4\4\uffff\1\4\7\21\1\uffff\1\4\1\6\10\21\1\uffff\1\6\1\21";
    static final String dfa_10s = "\1\41\4\uffff\1\53\7\56\1\uffff\1\41\1\6\10\56\1\uffff\1\6\1\56";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\10\uffff\1\5\12\uffff\1\4\2\uffff";
    static final String dfa_12s = "\33\uffff}>";
    static final String[] dfa_13s = {
            "\1\2\4\1\7\uffff\1\3\13\uffff\1\4\1\5\1\uffff\3\1",
            "",
            "",
            "",
            "",
            "\1\15\1\6\1\7\1\14\1\10\7\uffff\1\15\5\uffff\2\15\4\uffff\3\15\1\12\1\13\1\11\3\uffff\7\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\3\uffff\1\17\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "",
            "\1\15\1\20\1\21\1\26\1\22\7\uffff\1\15\13\uffff\2\15\1\uffff\1\24\1\25\1\23",
            "\1\27",
            "\1\15\4\uffff\2\15\4\uffff\1\30\1\4\1\15\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\3\uffff\1\31\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\4\uffff\2\15\1\uffff\11\15",
            "\1\15\4\uffff\2\15\4\uffff\1\15\1\uffff\1\16\4\uffff\2\15\1\uffff\11\15",
            "",
            "\1\32",
            "\1\15\4\uffff\2\15\4\uffff\2\30\1\15\4\uffff\2\15\1\uffff\11\15"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1349:2: (this_LiteralExpression_0= ruleLiteralExpression | this_FeatureCall_1= ruleFeatureCall | this_ParenthesizedExpression_2= ruleParenthesizedExpression | this_RangeExpression_3= ruleRangeExpression | this_ArrayExpression_4= ruleArrayExpression )";
        }
    }
    static final String dfa_14s = "\12\uffff";
    static final String dfa_15s = "\2\uffff\1\10\7\uffff";
    static final String dfa_16s = "\1\5\1\uffff\1\4\7\uffff";
    static final String dfa_17s = "\1\41\1\uffff\1\56\7\uffff";
    static final String dfa_18s = "\1\uffff\1\1\1\uffff\1\4\1\5\1\6\1\7\1\10\1\2\1\3";
    static final String dfa_19s = "\12\uffff}>";
    static final String[] dfa_20s = {
            "\1\1\1\2\1\7\1\3\26\uffff\1\5\1\6\1\4",
            "",
            "\1\10\11\uffff\2\10\1\uffff\2\10\2\uffff\12\10\3\uffff\1\11\2\10\1\uffff\11\10",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final short[][] dfa_20 = unpackEncodedStringArray(dfa_20s);

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = dfa_14;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_19;
            this.transition = dfa_20;
        }
        public String getDescription() {
            return "1714:2: (this_BoolLiteral_0= ruleBoolLiteral | this_IntLiteral_1= ruleIntLiteral | this_DecimalLiteral_2= ruleDecimalLiteral | this_StringLiteral_3= ruleStringLiteral | this_NullLiteral_4= ruleNullLiteral | this_PassLiteral_5= rulePassLiteral | this_AllLiteral_6= ruleAllLiteral | this_DateLiteral_7= ruleDateLiteral )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000000000F00C012L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x000000000500C010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000000000504C010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x000000000F20C010L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000820000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x000000000520C010L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000FE3F0C101F2L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000FE3F0C101F0L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x000007C000C00002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x00000FC3F0C101F0L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x00000803F00101F0L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00000003B00101F0L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000780040000002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00000003800001E0L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000010020000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000420010002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x00000FE3F0C501F0L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000420000002L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000020010102L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000020010002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000040L});

}