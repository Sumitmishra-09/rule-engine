package com.act21.rule.engine.dsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalExpressionLexer extends Lexer {
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

    public InternalExpressionLexer() {;} 
    public InternalExpressionLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalExpressionLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalExpression.g"; }

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:11:7: ( 'let' )
            // InternalExpression.g:11:9: 'let'
            {
            match("let"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:12:7: ( 'function' )
            // InternalExpression.g:12:9: 'function'
            {
            match("function"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:13:7: ( '(' )
            // InternalExpression.g:13:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:14:7: ( ',' )
            // InternalExpression.g:14:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:15:7: ( ')' )
            // InternalExpression.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:16:7: ( ':' )
            // InternalExpression.g:16:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:17:7: ( '{' )
            // InternalExpression.g:17:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:18:7: ( '}' )
            // InternalExpression.g:18:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:19:7: ( '<' )
            // InternalExpression.g:19:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:20:7: ( '>' )
            // InternalExpression.g:20:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:21:7: ( 'class' )
            // InternalExpression.g:21:9: 'class'
            {
            match("class"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:22:7: ( 'assign' )
            // InternalExpression.g:22:9: 'assign'
            {
            match("assign"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:23:7: ( '...' )
            // InternalExpression.g:23:9: '...'
            {
            match("..."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:24:7: ( 'if' )
            // InternalExpression.g:24:9: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:25:7: ( ']' )
            // InternalExpression.g:25:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:26:7: ( '[' )
            // InternalExpression.g:26:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:27:7: ( '-' )
            // InternalExpression.g:27:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:28:7: ( 'PASS' )
            // InternalExpression.g:28:9: 'PASS'
            {
            match("PASS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:29:7: ( 'ALL' )
            // InternalExpression.g:29:9: 'ALL'
            {
            match("ALL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:30:7: ( 'null' )
            // InternalExpression.g:30:9: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:31:7: ( '.' )
            // InternalExpression.g:31:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:32:7: ( '&&' )
            // InternalExpression.g:32:9: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:33:7: ( '||' )
            // InternalExpression.g:33:9: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:34:7: ( '!' )
            // InternalExpression.g:34:9: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:35:7: ( '<=' )
            // InternalExpression.g:35:9: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:36:7: ( '>=' )
            // InternalExpression.g:36:9: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:37:7: ( '==' )
            // InternalExpression.g:37:9: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:38:7: ( '!=' )
            // InternalExpression.g:38:9: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "T__42"
    public final void mT__42() throws RecognitionException {
        try {
            int _type = T__42;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:39:7: ( 'upto' )
            // InternalExpression.g:39:9: 'upto'
            {
            match("upto"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__42"

    // $ANTLR start "T__43"
    public final void mT__43() throws RecognitionException {
        try {
            int _type = T__43;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:40:7: ( '+' )
            // InternalExpression.g:40:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__43"

    // $ANTLR start "T__44"
    public final void mT__44() throws RecognitionException {
        try {
            int _type = T__44;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:41:7: ( '*' )
            // InternalExpression.g:41:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__44"

    // $ANTLR start "T__45"
    public final void mT__45() throws RecognitionException {
        try {
            int _type = T__45;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:42:7: ( '/' )
            // InternalExpression.g:42:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__45"

    // $ANTLR start "T__46"
    public final void mT__46() throws RecognitionException {
        try {
            int _type = T__46;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:43:7: ( '%' )
            // InternalExpression.g:43:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__46"

    // $ANTLR start "RULE_BIGINT"
    public final void mRULE_BIGINT() throws RecognitionException {
        try {
            int _type = RULE_BIGINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2948:13: ( ( '0' .. '9' )+ )
            // InternalExpression.g:2948:15: ( '0' .. '9' )+
            {
            // InternalExpression.g:2948:15: ( '0' .. '9' )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalExpression.g:2948:16: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BIGINT"

    // $ANTLR start "RULE_DATE"
    public final void mRULE_DATE() throws RecognitionException {
        try {
            int _type = RULE_DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2950:11: ( RULE_INT '/' RULE_INT '/' RULE_INT )
            // InternalExpression.g:2950:13: RULE_INT '/' RULE_INT '/' RULE_INT
            {
            mRULE_INT(); 
            match('/'); 
            mRULE_INT(); 
            match('/'); 
            mRULE_INT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_DATE"

    // $ANTLR start "RULE_BOOL"
    public final void mRULE_BOOL() throws RecognitionException {
        try {
            int _type = RULE_BOOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2952:11: ( ( 'true' | 'false' ) )
            // InternalExpression.g:2952:13: ( 'true' | 'false' )
            {
            // InternalExpression.g:2952:13: ( 'true' | 'false' )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='t') ) {
                alt2=1;
            }
            else if ( (LA2_0=='f') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalExpression.g:2952:14: 'true'
                    {
                    match("true"); 


                    }
                    break;
                case 2 :
                    // InternalExpression.g:2952:21: 'false'
                    {
                    match("false"); 


                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_BOOL"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2954:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalExpression.g:2954:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalExpression.g:2954:11: ( '^' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='^') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalExpression.g:2954:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalExpression.g:2954:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalExpression.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            // InternalExpression.g:2956:19: ( ( '0' .. '9' )+ )
            // InternalExpression.g:2956:21: ( '0' .. '9' )+
            {
            // InternalExpression.g:2956:21: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalExpression.g:2956:22: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

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
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2958:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalExpression.g:2958:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalExpression.g:2958:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\"') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\'') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // InternalExpression.g:2958:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalExpression.g:2958:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop6:
                    do {
                        int alt6=3;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0=='\\') ) {
                            alt6=1;
                        }
                        else if ( ((LA6_0>='\u0000' && LA6_0<='!')||(LA6_0>='#' && LA6_0<='[')||(LA6_0>=']' && LA6_0<='\uFFFF')) ) {
                            alt6=2;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalExpression.g:2958:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalExpression.g:2958:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalExpression.g:2958:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalExpression.g:2958:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop7:
                    do {
                        int alt7=3;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0=='\\') ) {
                            alt7=1;
                        }
                        else if ( ((LA7_0>='\u0000' && LA7_0<='&')||(LA7_0>='(' && LA7_0<='[')||(LA7_0>=']' && LA7_0<='\uFFFF')) ) {
                            alt7=2;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // InternalExpression.g:2958:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalExpression.g:2958:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2960:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalExpression.g:2960:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalExpression.g:2960:24: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='*') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='/') ) {
                        alt9=2;
                    }
                    else if ( ((LA9_1>='\u0000' && LA9_1<='.')||(LA9_1>='0' && LA9_1<='\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0>='\u0000' && LA9_0<=')')||(LA9_0>='+' && LA9_0<='\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalExpression.g:2960:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2962:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalExpression.g:2962:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalExpression.g:2962:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\u0000' && LA10_0<='\t')||(LA10_0>='\u000B' && LA10_0<='\f')||(LA10_0>='\u000E' && LA10_0<='\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalExpression.g:2962:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            // InternalExpression.g:2962:40: ( ( '\\r' )? '\\n' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\n'||LA12_0=='\r') ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalExpression.g:2962:41: ( '\\r' )? '\\n'
                    {
                    // InternalExpression.g:2962:41: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalExpression.g:2962:41: '\\r'
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2964:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalExpression.g:2964:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalExpression.g:2964:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>='\t' && LA13_0<='\n')||LA13_0=='\r'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalExpression.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalExpression.g:2966:16: ( . )
            // InternalExpression.g:2966:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalExpression.g:1:8: ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | RULE_BIGINT | RULE_DATE | RULE_BOOL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt14=42;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // InternalExpression.g:1:10: T__14
                {
                mT__14(); 

                }
                break;
            case 2 :
                // InternalExpression.g:1:16: T__15
                {
                mT__15(); 

                }
                break;
            case 3 :
                // InternalExpression.g:1:22: T__16
                {
                mT__16(); 

                }
                break;
            case 4 :
                // InternalExpression.g:1:28: T__17
                {
                mT__17(); 

                }
                break;
            case 5 :
                // InternalExpression.g:1:34: T__18
                {
                mT__18(); 

                }
                break;
            case 6 :
                // InternalExpression.g:1:40: T__19
                {
                mT__19(); 

                }
                break;
            case 7 :
                // InternalExpression.g:1:46: T__20
                {
                mT__20(); 

                }
                break;
            case 8 :
                // InternalExpression.g:1:52: T__21
                {
                mT__21(); 

                }
                break;
            case 9 :
                // InternalExpression.g:1:58: T__22
                {
                mT__22(); 

                }
                break;
            case 10 :
                // InternalExpression.g:1:64: T__23
                {
                mT__23(); 

                }
                break;
            case 11 :
                // InternalExpression.g:1:70: T__24
                {
                mT__24(); 

                }
                break;
            case 12 :
                // InternalExpression.g:1:76: T__25
                {
                mT__25(); 

                }
                break;
            case 13 :
                // InternalExpression.g:1:82: T__26
                {
                mT__26(); 

                }
                break;
            case 14 :
                // InternalExpression.g:1:88: T__27
                {
                mT__27(); 

                }
                break;
            case 15 :
                // InternalExpression.g:1:94: T__28
                {
                mT__28(); 

                }
                break;
            case 16 :
                // InternalExpression.g:1:100: T__29
                {
                mT__29(); 

                }
                break;
            case 17 :
                // InternalExpression.g:1:106: T__30
                {
                mT__30(); 

                }
                break;
            case 18 :
                // InternalExpression.g:1:112: T__31
                {
                mT__31(); 

                }
                break;
            case 19 :
                // InternalExpression.g:1:118: T__32
                {
                mT__32(); 

                }
                break;
            case 20 :
                // InternalExpression.g:1:124: T__33
                {
                mT__33(); 

                }
                break;
            case 21 :
                // InternalExpression.g:1:130: T__34
                {
                mT__34(); 

                }
                break;
            case 22 :
                // InternalExpression.g:1:136: T__35
                {
                mT__35(); 

                }
                break;
            case 23 :
                // InternalExpression.g:1:142: T__36
                {
                mT__36(); 

                }
                break;
            case 24 :
                // InternalExpression.g:1:148: T__37
                {
                mT__37(); 

                }
                break;
            case 25 :
                // InternalExpression.g:1:154: T__38
                {
                mT__38(); 

                }
                break;
            case 26 :
                // InternalExpression.g:1:160: T__39
                {
                mT__39(); 

                }
                break;
            case 27 :
                // InternalExpression.g:1:166: T__40
                {
                mT__40(); 

                }
                break;
            case 28 :
                // InternalExpression.g:1:172: T__41
                {
                mT__41(); 

                }
                break;
            case 29 :
                // InternalExpression.g:1:178: T__42
                {
                mT__42(); 

                }
                break;
            case 30 :
                // InternalExpression.g:1:184: T__43
                {
                mT__43(); 

                }
                break;
            case 31 :
                // InternalExpression.g:1:190: T__44
                {
                mT__44(); 

                }
                break;
            case 32 :
                // InternalExpression.g:1:196: T__45
                {
                mT__45(); 

                }
                break;
            case 33 :
                // InternalExpression.g:1:202: T__46
                {
                mT__46(); 

                }
                break;
            case 34 :
                // InternalExpression.g:1:208: RULE_BIGINT
                {
                mRULE_BIGINT(); 

                }
                break;
            case 35 :
                // InternalExpression.g:1:220: RULE_DATE
                {
                mRULE_DATE(); 

                }
                break;
            case 36 :
                // InternalExpression.g:1:230: RULE_BOOL
                {
                mRULE_BOOL(); 

                }
                break;
            case 37 :
                // InternalExpression.g:1:240: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 38 :
                // InternalExpression.g:1:248: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 39 :
                // InternalExpression.g:1:260: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 40 :
                // InternalExpression.g:1:276: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 41 :
                // InternalExpression.g:1:292: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 42 :
                // InternalExpression.g:1:300: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\1\uffff\2\47\6\uffff\1\61\1\63\2\47\1\67\1\47\3\uffff\3\47\2\45\1\102\1\45\1\47\2\uffff\1\111\1\uffff\1\113\1\47\1\45\1\uffff\2\45\2\uffff\1\47\1\uffff\2\47\12\uffff\2\47\2\uffff\1\126\3\uffff\3\47\5\uffff\1\47\7\uffff\1\113\1\uffff\1\47\2\uffff\1\134\4\47\1\uffff\1\47\1\142\3\47\1\uffff\4\47\1\152\1\uffff\1\153\1\154\1\155\1\47\1\155\1\157\1\47\4\uffff\1\47\1\uffff\1\162\1\47\1\uffff\1\164\1\uffff";
    static final String DFA14_eofS =
        "\165\uffff";
    static final String DFA14_minS =
        "\1\0\1\145\1\141\6\uffff\2\75\1\154\1\163\1\56\1\146\3\uffff\1\101\1\114\1\165\1\46\1\174\2\75\1\160\2\uffff\1\52\1\uffff\1\57\1\162\1\101\1\uffff\2\0\2\uffff\1\164\1\uffff\1\156\1\154\12\uffff\1\141\1\163\2\uffff\1\60\3\uffff\1\123\1\114\1\154\5\uffff\1\164\7\uffff\1\57\1\uffff\1\165\2\uffff\1\60\1\143\2\163\1\151\1\uffff\1\123\1\60\1\154\1\157\1\145\1\uffff\1\164\1\145\1\163\1\147\1\60\1\uffff\3\60\1\151\2\60\1\156\4\uffff\1\157\1\uffff\1\60\1\156\1\uffff\1\60\1\uffff";
    static final String DFA14_maxS =
        "\1\uffff\1\145\1\165\6\uffff\2\75\1\154\1\163\1\56\1\146\3\uffff\1\101\1\114\1\165\1\46\1\174\2\75\1\160\2\uffff\1\57\1\uffff\1\71\1\162\1\172\1\uffff\2\uffff\2\uffff\1\164\1\uffff\1\156\1\154\12\uffff\1\141\1\163\2\uffff\1\172\3\uffff\1\123\1\114\1\154\5\uffff\1\164\7\uffff\1\71\1\uffff\1\165\2\uffff\1\172\1\143\2\163\1\151\1\uffff\1\123\1\172\1\154\1\157\1\145\1\uffff\1\164\1\145\1\163\1\147\1\172\1\uffff\3\172\1\151\2\172\1\156\4\uffff\1\157\1\uffff\1\172\1\156\1\uffff\1\172\1\uffff";
    static final String DFA14_acceptS =
        "\3\uffff\1\3\1\4\1\5\1\6\1\7\1\10\6\uffff\1\17\1\20\1\21\10\uffff\1\36\1\37\1\uffff\1\41\3\uffff\1\45\2\uffff\1\51\1\52\1\uffff\1\45\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\31\1\11\1\32\1\12\2\uffff\1\15\1\25\1\uffff\1\17\1\20\1\21\3\uffff\1\26\1\27\1\34\1\30\1\33\1\uffff\1\36\1\37\1\47\1\50\1\40\1\41\1\42\1\uffff\1\43\1\uffff\1\46\1\51\5\uffff\1\16\5\uffff\1\1\5\uffff\1\23\7\uffff\1\22\1\24\1\35\1\44\1\uffff\1\13\2\uffff\1\14\1\uffff\1\2";
    static final String DFA14_specialS =
        "\1\0\41\uffff\1\2\1\1\121\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\45\2\44\2\45\1\44\22\45\1\44\1\27\1\42\2\45\1\35\1\25\1\43\1\3\1\5\1\33\1\32\1\4\1\21\1\15\1\34\12\36\1\6\1\45\1\11\1\30\1\12\2\45\1\23\16\41\1\22\12\41\1\20\1\45\1\17\1\40\1\41\1\45\1\14\1\41\1\13\2\41\1\2\2\41\1\16\2\41\1\1\1\41\1\24\5\41\1\37\1\31\5\41\1\7\1\26\1\10\uff82\45",
            "\1\46",
            "\1\51\23\uffff\1\50",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\60",
            "\1\62",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\70",
            "",
            "",
            "",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\103",
            "\1\104",
            "",
            "",
            "\1\107\4\uffff\1\110",
            "",
            "\1\115\12\114",
            "\1\116",
            "\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\0\117",
            "\0\117",
            "",
            "",
            "\1\121",
            "",
            "\1\122",
            "\1\123",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\124",
            "\1\125",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            "\1\127",
            "\1\130",
            "\1\131",
            "",
            "",
            "",
            "",
            "",
            "\1\132",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\115\12\114",
            "",
            "\1\133",
            "",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "",
            "\1\141",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\143",
            "\1\144",
            "\1\145",
            "",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\156",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\160",
            "",
            "",
            "",
            "",
            "\1\161",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\163",
            "",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | T__42 | T__43 | T__44 | T__45 | T__46 | RULE_BIGINT | RULE_DATE | RULE_BOOL | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0=='l') ) {s = 1;}

                        else if ( (LA14_0=='f') ) {s = 2;}

                        else if ( (LA14_0=='(') ) {s = 3;}

                        else if ( (LA14_0==',') ) {s = 4;}

                        else if ( (LA14_0==')') ) {s = 5;}

                        else if ( (LA14_0==':') ) {s = 6;}

                        else if ( (LA14_0=='{') ) {s = 7;}

                        else if ( (LA14_0=='}') ) {s = 8;}

                        else if ( (LA14_0=='<') ) {s = 9;}

                        else if ( (LA14_0=='>') ) {s = 10;}

                        else if ( (LA14_0=='c') ) {s = 11;}

                        else if ( (LA14_0=='a') ) {s = 12;}

                        else if ( (LA14_0=='.') ) {s = 13;}

                        else if ( (LA14_0=='i') ) {s = 14;}

                        else if ( (LA14_0==']') ) {s = 15;}

                        else if ( (LA14_0=='[') ) {s = 16;}

                        else if ( (LA14_0=='-') ) {s = 17;}

                        else if ( (LA14_0=='P') ) {s = 18;}

                        else if ( (LA14_0=='A') ) {s = 19;}

                        else if ( (LA14_0=='n') ) {s = 20;}

                        else if ( (LA14_0=='&') ) {s = 21;}

                        else if ( (LA14_0=='|') ) {s = 22;}

                        else if ( (LA14_0=='!') ) {s = 23;}

                        else if ( (LA14_0=='=') ) {s = 24;}

                        else if ( (LA14_0=='u') ) {s = 25;}

                        else if ( (LA14_0=='+') ) {s = 26;}

                        else if ( (LA14_0=='*') ) {s = 27;}

                        else if ( (LA14_0=='/') ) {s = 28;}

                        else if ( (LA14_0=='%') ) {s = 29;}

                        else if ( ((LA14_0>='0' && LA14_0<='9')) ) {s = 30;}

                        else if ( (LA14_0=='t') ) {s = 31;}

                        else if ( (LA14_0=='^') ) {s = 32;}

                        else if ( ((LA14_0>='B' && LA14_0<='O')||(LA14_0>='Q' && LA14_0<='Z')||LA14_0=='_'||LA14_0=='b'||(LA14_0>='d' && LA14_0<='e')||(LA14_0>='g' && LA14_0<='h')||(LA14_0>='j' && LA14_0<='k')||LA14_0=='m'||(LA14_0>='o' && LA14_0<='s')||(LA14_0>='v' && LA14_0<='z')) ) {s = 33;}

                        else if ( (LA14_0=='\"') ) {s = 34;}

                        else if ( (LA14_0=='\'') ) {s = 35;}

                        else if ( ((LA14_0>='\t' && LA14_0<='\n')||LA14_0=='\r'||LA14_0==' ') ) {s = 36;}

                        else if ( ((LA14_0>='\u0000' && LA14_0<='\b')||(LA14_0>='\u000B' && LA14_0<='\f')||(LA14_0>='\u000E' && LA14_0<='\u001F')||(LA14_0>='#' && LA14_0<='$')||LA14_0==';'||(LA14_0>='?' && LA14_0<='@')||LA14_0=='\\'||LA14_0=='`'||(LA14_0>='~' && LA14_0<='\uFFFF')) ) {s = 37;}

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA14_35 = input.LA(1);

                        s = -1;
                        if ( ((LA14_35>='\u0000' && LA14_35<='\uFFFF')) ) {s = 79;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA14_34 = input.LA(1);

                        s = -1;
                        if ( ((LA14_34>='\u0000' && LA14_34<='\uFFFF')) ) {s = 79;}

                        else s = 37;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}