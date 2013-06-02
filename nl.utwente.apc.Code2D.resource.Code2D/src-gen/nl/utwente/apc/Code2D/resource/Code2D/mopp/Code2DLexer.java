// $ANTLR 3.4

	package nl.utwente.apc.Code2D.resource.Code2D.mopp;


import org.antlr.runtime3_4_0.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class Code2DLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__11=11;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int COMMENT=4;
    public static final int FLOAT=5;
    public static final int INTEGER=6;
    public static final int LINEBREAK=7;
    public static final int QUOTED_4748_59=8;
    public static final int TEXT=9;
    public static final int WHITESPACE=10;

    	public java.util.List<org.antlr.runtime3_4_0.RecognitionException> lexerExceptions  = new java.util.ArrayList<org.antlr.runtime3_4_0.RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition = new java.util.ArrayList<Integer>();
    	
    	public void reportError(org.antlr.runtime3_4_0.RecognitionException e) {
    		lexerExceptions.add(e);
    		lexerExceptionsPosition.add(((org.antlr.runtime3_4_0.ANTLRStringStream) input).index());
    	}


    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public Code2DLexer() {} 
    public Code2DLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public Code2DLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "Code2D.g"; }

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:15:7: ( ':' )
            // Code2D.g:15:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:16:7: ( ';' )
            // Code2D.g:16:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:17:7: ( 'Behaviour' )
            // Code2D.g:17:9: 'Behaviour'
            {
            match("Behaviour"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:18:7: ( 'Friendly' )
            // Code2D.g:18:9: 'Friendly'
            {
            match("Friendly"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:19:7: ( 'Game' )
            // Code2D.g:19:9: 'Game'
            {
            match("Game"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:20:7: ( 'Hostile' )
            // Code2D.g:20:9: 'Hostile'
            {
            match("Hostile"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:21:7: ( 'Item' )
            // Code2D.g:21:9: 'Item'
            {
            match("Item"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:22:7: ( 'NPC' )
            // Code2D.g:22:9: 'NPC'
            {
            match("NPC"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:23:7: ( 'Neutral' )
            // Code2D.g:23:9: 'Neutral'
            {
            match("Neutral"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:24:7: ( 'Other things;' )
            // Code2D.g:24:9: 'Other things;'
            {
            match("Other things;"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:25:7: ( 'Player' )
            // Code2D.g:25:9: 'Player'
            {
            match("Player"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:26:7: ( 'Texture' )
            // Code2D.g:26:9: 'Texture'
            {
            match("Texture"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:27:7: ( 'World' )
            // Code2D.g:27:9: 'World'
            {
            match("World"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:28:7: ( '{' )
            // Code2D.g:28:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:29:7: ( '}' )
            // Code2D.g:29:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1492:8: ( ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* ) )
            // Code2D.g:1493:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            {
            // Code2D.g:1493:2: ( '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )* )
            // Code2D.g:1493:3: '//' (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            {
            match("//"); 



            // Code2D.g:1493:7: (~ ( '\\n' | '\\r' | '\\uffff' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Code2D.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFE') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1496:8: ( ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) )
            // Code2D.g:1497:2: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            {
            // Code2D.g:1497:2: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0 >= '1' && LA4_0 <= '9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='0') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // Code2D.g:1497:3: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // Code2D.g:1497:3: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // Code2D.g:1497:4: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }


                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Code2D.g:1497:19: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // Code2D.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Code2D.g:1497:31: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1500:6: ( ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ ) )
            // Code2D.g:1501:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            {
            // Code2D.g:1501:2: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // Code2D.g:1501:3: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // Code2D.g:1501:3: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // Code2D.g:1501:4: '-'
                    {
                    match('-'); 

                    }
                    break;

            }


            // Code2D.g:1501:9: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0 >= '1' && LA7_0 <= '9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='0') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // Code2D.g:1501:10: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    if ( (input.LA(1) >= '1' && input.LA(1) <= '9') ) {
                        input.consume();
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;
                    }


                    // Code2D.g:1501:21: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0 >= '0' && LA6_0 <= '9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // Code2D.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // Code2D.g:1501:35: '0'
                    {
                    match('0'); 

                    }
                    break;

            }


            match('.'); 

            // Code2D.g:1501:44: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // Code2D.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "TEXT"
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1504:5: ( ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ ) )
            // Code2D.g:1505:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            {
            // Code2D.g:1505:2: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // Code2D.g:1505:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // Code2D.g:1505:3: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='-'||(LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // Code2D.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "TEXT"

    // $ANTLR start "WHITESPACE"
    public final void mWHITESPACE() throws RecognitionException {
        try {
            int _type = WHITESPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1507:11: ( ( ( ' ' | '\\t' | '\\f' ) ) )
            // Code2D.g:1508:2: ( ( ' ' | '\\t' | '\\f' ) )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WHITESPACE"

    // $ANTLR start "LINEBREAK"
    public final void mLINEBREAK() throws RecognitionException {
        try {
            int _type = LINEBREAK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1511:10: ( ( ( '\\r\\n' | '\\r' | '\\n' ) ) )
            // Code2D.g:1512:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            {
            // Code2D.g:1512:2: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // Code2D.g:1512:3: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // Code2D.g:1512:3: ( '\\r\\n' | '\\r' | '\\n' )
            int alt10=3;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\r') ) {
                int LA10_1 = input.LA(2);

                if ( (LA10_1=='\n') ) {
                    alt10=1;
                }
                else {
                    alt10=2;
                }
            }
            else if ( (LA10_0=='\n') ) {
                alt10=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // Code2D.g:1512:4: '\\r\\n'
                    {
                    match("\r\n"); 



                    }
                    break;
                case 2 :
                    // Code2D.g:1512:13: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // Code2D.g:1512:20: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }


            }


             _channel = 99; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LINEBREAK"

    // $ANTLR start "QUOTED_4748_59"
    public final void mQUOTED_4748_59() throws RecognitionException {
        try {
            int _type = QUOTED_4748_59;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // Code2D.g:1515:15: ( ( ( '/0' ) (~ ( ';' ) )* ( ';' ) ) )
            // Code2D.g:1516:2: ( ( '/0' ) (~ ( ';' ) )* ( ';' ) )
            {
            // Code2D.g:1516:2: ( ( '/0' ) (~ ( ';' ) )* ( ';' ) )
            // Code2D.g:1516:3: ( '/0' ) (~ ( ';' ) )* ( ';' )
            {
            // Code2D.g:1516:3: ( '/0' )
            // Code2D.g:1516:4: '/0'
            {
            match("/0"); 



            }


            // Code2D.g:1516:9: (~ ( ';' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= ':')||(LA11_0 >= '<' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // Code2D.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            // Code2D.g:1516:18: ( ';' )
            // Code2D.g:1516:19: ';'
            {
            match(';'); 

            }


            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QUOTED_4748_59"

    public void mTokens() throws RecognitionException {
        // Code2D.g:1:8: ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_4748_59 )
        int alt12=22;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // Code2D.g:1:10: T__11
                {
                mT__11(); 


                }
                break;
            case 2 :
                // Code2D.g:1:16: T__12
                {
                mT__12(); 


                }
                break;
            case 3 :
                // Code2D.g:1:22: T__13
                {
                mT__13(); 


                }
                break;
            case 4 :
                // Code2D.g:1:28: T__14
                {
                mT__14(); 


                }
                break;
            case 5 :
                // Code2D.g:1:34: T__15
                {
                mT__15(); 


                }
                break;
            case 6 :
                // Code2D.g:1:40: T__16
                {
                mT__16(); 


                }
                break;
            case 7 :
                // Code2D.g:1:46: T__17
                {
                mT__17(); 


                }
                break;
            case 8 :
                // Code2D.g:1:52: T__18
                {
                mT__18(); 


                }
                break;
            case 9 :
                // Code2D.g:1:58: T__19
                {
                mT__19(); 


                }
                break;
            case 10 :
                // Code2D.g:1:64: T__20
                {
                mT__20(); 


                }
                break;
            case 11 :
                // Code2D.g:1:70: T__21
                {
                mT__21(); 


                }
                break;
            case 12 :
                // Code2D.g:1:76: T__22
                {
                mT__22(); 


                }
                break;
            case 13 :
                // Code2D.g:1:82: T__23
                {
                mT__23(); 


                }
                break;
            case 14 :
                // Code2D.g:1:88: T__24
                {
                mT__24(); 


                }
                break;
            case 15 :
                // Code2D.g:1:94: T__25
                {
                mT__25(); 


                }
                break;
            case 16 :
                // Code2D.g:1:100: COMMENT
                {
                mCOMMENT(); 


                }
                break;
            case 17 :
                // Code2D.g:1:108: INTEGER
                {
                mINTEGER(); 


                }
                break;
            case 18 :
                // Code2D.g:1:116: FLOAT
                {
                mFLOAT(); 


                }
                break;
            case 19 :
                // Code2D.g:1:122: TEXT
                {
                mTEXT(); 


                }
                break;
            case 20 :
                // Code2D.g:1:127: WHITESPACE
                {
                mWHITESPACE(); 


                }
                break;
            case 21 :
                // Code2D.g:1:138: LINEBREAK
                {
                mLINEBREAK(); 


                }
                break;
            case 22 :
                // Code2D.g:1:148: QUOTED_4748_59
                {
                mQUOTED_4748_59(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\3\uffff\12\23\3\uffff\1\23\2\45\3\uffff\13\23\2\uffff\1\23\1\45"+
        "\2\uffff\5\23\1\67\7\23\1\77\1\23\1\101\1\uffff\7\23\1\uffff\1\23"+
        "\1\uffff\4\23\1\116\4\23\1\uffff\1\123\1\23\1\uffff\2\23\1\127\1"+
        "\130\1\uffff\1\131\1\23\1\133\3\uffff\1\134\2\uffff";
    static final String DFA12_eofS =
        "\135\uffff";
    static final String DFA12_minS =
        "\1\11\2\uffff\1\145\1\162\1\141\1\157\1\164\1\120\1\164\1\154\1"+
        "\145\1\157\2\uffff\1\57\1\60\2\55\3\uffff\1\150\1\151\1\155\1\163"+
        "\1\145\1\103\1\165\1\150\1\141\1\170\1\162\2\uffff\1\56\1\55\2\uffff"+
        "\1\141\2\145\1\164\1\155\1\55\1\164\1\145\1\171\1\164\1\154\1\166"+
        "\1\156\1\55\1\151\1\55\1\uffff\2\162\1\145\1\165\1\144\1\151\1\144"+
        "\1\uffff\1\154\1\uffff\1\141\1\40\2\162\1\55\1\157\1\154\1\145\1"+
        "\154\1\uffff\1\55\1\145\1\uffff\1\165\1\171\2\55\1\uffff\1\55\1"+
        "\162\1\55\3\uffff\1\55\2\uffff";
    static final String DFA12_maxS =
        "\1\175\2\uffff\1\145\1\162\1\141\1\157\1\164\1\145\1\164\1\154\1"+
        "\145\1\157\2\uffff\1\60\1\71\2\172\3\uffff\1\150\1\151\1\155\1\163"+
        "\1\145\1\103\1\165\1\150\1\141\1\170\1\162\2\uffff\1\56\1\172\2"+
        "\uffff\1\141\2\145\1\164\1\155\1\172\1\164\1\145\1\171\1\164\1\154"+
        "\1\166\1\156\1\172\1\151\1\172\1\uffff\2\162\1\145\1\165\1\144\1"+
        "\151\1\144\1\uffff\1\154\1\uffff\1\141\1\40\2\162\1\172\1\157\1"+
        "\154\1\145\1\154\1\uffff\1\172\1\145\1\uffff\1\165\1\171\2\172\1"+
        "\uffff\1\172\1\162\1\172\3\uffff\1\172\2\uffff";
    static final String DFA12_acceptS =
        "\1\uffff\1\1\1\2\12\uffff\1\16\1\17\4\uffff\1\23\1\24\1\25\13\uffff"+
        "\1\20\1\26\2\uffff\1\21\1\22\20\uffff\1\10\7\uffff\1\5\1\uffff\1"+
        "\7\11\uffff\1\12\2\uffff\1\15\4\uffff\1\13\3\uffff\1\6\1\11\1\14"+
        "\1\uffff\1\4\1\3";
    static final String DFA12_specialS =
        "\135\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\24\1\25\1\uffff\1\24\1\25\22\uffff\1\24\14\uffff\1\20\1\uffff"+
            "\1\17\1\22\11\21\1\1\1\2\5\uffff\1\23\1\3\3\23\1\4\1\5\1\6\1"+
            "\7\4\23\1\10\1\11\1\12\3\23\1\13\2\23\1\14\3\23\4\uffff\1\23"+
            "\1\uffff\32\23\1\15\1\uffff\1\16",
            "",
            "",
            "\1\26",
            "\1\27",
            "\1\30",
            "\1\31",
            "\1\32",
            "\1\33\24\uffff\1\34",
            "\1\35",
            "\1\36",
            "\1\37",
            "\1\40",
            "",
            "",
            "\1\41\1\42",
            "\1\43\11\21",
            "\1\23\1\46\1\uffff\12\44\7\uffff\32\23\4\uffff\1\23\1\uffff"+
            "\32\23",
            "\1\23\1\46\1\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff"+
            "\32\23",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "",
            "",
            "\1\46",
            "\1\23\1\46\1\uffff\12\44\7\uffff\32\23\4\uffff\1\23\1\uffff"+
            "\32\23",
            "",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\100",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "",
            "\1\111",
            "",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "\1\132",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            "",
            "",
            "\1\23\2\uffff\12\23\7\uffff\32\23\4\uffff\1\23\1\uffff\32\23",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | COMMENT | INTEGER | FLOAT | TEXT | WHITESPACE | LINEBREAK | QUOTED_4748_59 );";
        }
    }
 

}