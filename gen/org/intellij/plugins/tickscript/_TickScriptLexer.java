/* The following code was generated by JFlex 1.7.0-1 tweaked for IntelliJ platform */

package org.intellij.plugins.tickscript;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static org.intellij.plugins.tickscript.TickScriptElementTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0-1
 * from the specification file <tt>_TickScriptLexer.flex</tt>
 */
public class _TickScriptLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [7, 7, 7]
   * Total runtime size is 1928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>14]|((ch>>7)&0x7f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 68 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\103\200");

  /* The ZZ_CMAP_Y table has 256 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\53\2\1\3\22\2\1\4\37\2\1\3\237\2");

  /* The ZZ_CMAP_A table has 640 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\3\1\2\2\1\1\2\22\0\1\3\1\32\1\21\1\5\1\0\1\35\1\0\1\17\1\22\1\23\1"+
    "\34\1\33\1\31\1\10\1\11\1\4\1\7\11\12\1\54\1\0\1\36\1\26\1\37\1\0\1\30\1\41"+
    "\2\6\1\43\1\57\1\60\5\6\1\61\1\6\1\42\1\44\2\6\1\45\1\62\1\55\1\56\5\6\1\24"+
    "\1\20\1\25\1\0\1\6\1\0\1\47\1\52\1\6\1\53\3\6\1\14\3\6\1\51\1\15\4\6\1\50"+
    "\1\16\1\6\1\14\1\46\1\14\3\6\1\0\1\27\1\0\1\40\6\0\1\1\32\0\1\3\24\0\1\13"+
    "\312\0\1\3\177\0\13\3\35\0\2\1\5\0\1\3\57\0\1\3\40\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\1\6\2\1\1\11\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\6\5\1\0\1\4\2\0\1\6\2\27\1\0"+
    "\1\30\3\0\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\5\1\40\4\5\1\41\1\30\1\0\1\42"+
    "\1\43\3\5\2\0\1\5\1\44\1\5\2\0\1\5"+
    "\1\45\1\0\1\46\1\5\1\46\1\47\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[80];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\63\0\146\0\231\0\314\0\377\0\u0132\0\u0165"+
    "\0\u0198\0\u01cb\0\u01fe\0\u0231\0\63\0\63\0\63\0\63"+
    "\0\u0264\0\63\0\63\0\63\0\u0297\0\63\0\63\0\63"+
    "\0\u02ca\0\u02fd\0\u0330\0\u0363\0\u0396\0\u03c9\0\u03fc\0\u042f"+
    "\0\u0462\0\u0495\0\u04c8\0\u0198\0\u0198\0\63\0\u04fb\0\u052e"+
    "\0\u0561\0\u0594\0\u0231\0\u05c7\0\63\0\63\0\63\0\63"+
    "\0\63\0\63\0\63\0\u05fa\0\377\0\u062d\0\u0660\0\u0693"+
    "\0\u06c6\0\u0462\0\63\0\u06f9\0\377\0\377\0\u072c\0\u075f"+
    "\0\u0792\0\u07c5\0\u07f8\0\u082b\0\377\0\u085e\0\u0891\0\u08c4"+
    "\0\u08f7\0\377\0\u092a\0\63\0\u095d\0\u0990\0\63\0\u08c4";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[80];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\3\3\1\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\2\3\6\1\13\1\2\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\2\1\33\2\6\1\34"+
    "\1\6\1\35\2\6\1\36\2\6\1\2\1\37\2\6"+
    "\1\40\2\6\64\0\3\3\57\0\2\41\1\0\1\41"+
    "\1\42\13\41\1\43\42\41\1\5\2\0\60\5\6\0"+
    "\2\6\2\0\1\6\1\0\3\6\22\0\13\6\1\0"+
    "\6\6\7\0\1\7\1\0\1\44\1\7\57\0\1\7"+
    "\2\0\1\7\57\0\1\45\2\0\1\45\57\0\1\12"+
    "\1\0\1\44\1\12\2\46\1\47\1\46\34\0\1\46"+
    "\7\0\17\50\1\51\1\52\42\50\2\53\1\0\15\53"+
    "\1\54\1\55\41\53\26\0\1\56\11\0\1\57\50\0"+
    "\1\60\11\0\1\61\50\0\1\62\62\0\1\63\42\0"+
    "\2\6\2\0\1\6\1\0\3\6\22\0\1\6\1\64"+
    "\11\6\1\0\6\6\6\0\2\6\2\0\1\6\1\0"+
    "\3\6\22\0\4\6\1\65\6\6\1\0\6\6\6\0"+
    "\2\6\2\0\1\6\1\0\3\6\22\0\6\6\1\66"+
    "\4\6\1\0\6\6\6\0\2\6\2\0\1\6\1\0"+
    "\3\6\22\0\6\6\1\67\4\6\1\0\6\6\6\0"+
    "\2\6\2\0\1\6\1\0\3\6\22\0\4\6\1\70"+
    "\6\6\1\0\6\6\6\0\2\6\2\0\1\6\1\0"+
    "\3\6\22\0\1\71\12\6\1\0\6\6\2\41\1\0"+
    "\1\41\1\72\13\41\1\43\42\41\1\42\1\41\1\0"+
    "\60\42\2\41\1\0\60\41\16\0\1\46\44\0\17\50"+
    "\1\73\1\52\42\50\17\0\1\74\43\0\1\50\2\0"+
    "\60\50\2\53\1\0\60\53\6\0\2\6\2\0\1\6"+
    "\1\0\3\6\22\0\2\6\1\75\10\6\1\0\6\6"+
    "\6\0\2\6\2\0\1\6\1\0\3\6\22\0\7\6"+
    "\1\76\3\6\1\0\6\6\6\0\2\6\2\0\1\6"+
    "\1\0\1\6\1\77\1\6\22\0\13\6\1\0\6\6"+
    "\6\0\2\6\2\0\1\6\1\0\3\6\22\0\13\6"+
    "\1\0\1\6\1\100\4\6\6\0\2\6\2\0\1\6"+
    "\1\0\3\6\22\0\13\6\1\0\4\6\1\101\1\6"+
    "\17\102\1\103\43\102\6\0\2\6\2\0\1\6\1\0"+
    "\3\6\22\0\11\6\1\104\1\6\1\0\6\6\6\0"+
    "\2\6\2\0\1\6\1\0\3\6\22\0\13\6\1\0"+
    "\2\6\1\105\3\6\6\0\2\6\2\0\1\6\1\0"+
    "\3\6\22\0\13\6\1\0\5\6\1\106\17\102\1\107"+
    "\43\102\17\0\1\110\51\0\2\6\2\0\1\6\1\0"+
    "\3\6\22\0\12\6\1\111\1\0\6\6\6\0\2\6"+
    "\2\0\1\6\1\0\3\6\22\0\13\6\1\0\2\6"+
    "\1\112\3\6\17\102\1\113\43\102\17\0\1\114\51\0"+
    "\2\6\2\0\1\6\1\0\3\6\22\0\6\6\1\115"+
    "\4\6\1\0\6\6\17\102\1\116\43\102\6\0\2\6"+
    "\2\0\1\6\1\0\3\6\22\0\13\6\1\117\6\6"+
    "\17\0\1\120\43\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2499];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\12\1\4\11\1\1\3\11\1\1\3\11"+
    "\10\1\1\0\1\1\2\0\1\1\1\11\1\1\1\0"+
    "\1\1\3\0\7\11\7\1\1\11\1\0\5\1\2\0"+
    "\3\1\2\0\2\1\1\0\1\11\2\1\1\11\1\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[80];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public _TickScriptLexer() {
    this((java.io.Reader)null);
  }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public _TickScriptLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position <tt>pos</tt> from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 40: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 41: break;
          case 3: 
            { return OP_DIV;
            } 
            // fall through
          case 42: break;
          case 4: 
            { return LINE_COMMENT;
            } 
            // fall through
          case 43: break;
          case 5: 
            { return ID;
            } 
            // fall through
          case 44: break;
          case 6: 
            { return NUMBER;
            } 
            // fall through
          case 45: break;
          case 7: 
            { return OP_MINUS;
            } 
            // fall through
          case 46: break;
          case 8: 
            { return DOT;
            } 
            // fall through
          case 47: break;
          case 9: 
            { return L_PAREN;
            } 
            // fall through
          case 48: break;
          case 10: 
            { return R_PAREN;
            } 
            // fall through
          case 49: break;
          case 11: 
            { return L_BRACKET;
            } 
            // fall through
          case 50: break;
          case 12: 
            { return R_BRACKET;
            } 
            // fall through
          case 51: break;
          case 13: 
            { return ASGN;
            } 
            // fall through
          case 52: break;
          case 14: 
            { return PIPE;
            } 
            // fall through
          case 53: break;
          case 15: 
            { return AT;
            } 
            // fall through
          case 54: break;
          case 16: 
            { return COMMA;
            } 
            // fall through
          case 55: break;
          case 17: 
            { return OP_NOT;
            } 
            // fall through
          case 56: break;
          case 18: 
            { return OP_PLUS;
            } 
            // fall through
          case 57: break;
          case 19: 
            { return OP_MULT;
            } 
            // fall through
          case 58: break;
          case 20: 
            { return OP_MOD;
            } 
            // fall through
          case 59: break;
          case 21: 
            { return OP_LESS;
            } 
            // fall through
          case 60: break;
          case 22: 
            { return OP_GREATER;
            } 
            // fall through
          case 61: break;
          case 23: 
            { return DURATION;
            } 
            // fall through
          case 62: break;
          case 24: 
            { return SINGLE_QUOTED_STRING;
            } 
            // fall through
          case 63: break;
          case 25: 
            { return REFERENCE_STRING;
            } 
            // fall through
          case 64: break;
          case 26: 
            { return OP_EQUAL;
            } 
            // fall through
          case 65: break;
          case 27: 
            { return OP_REGEXEQUAL;
            } 
            // fall through
          case 66: break;
          case 28: 
            { return OP_NOTEQUAL;
            } 
            // fall through
          case 67: break;
          case 29: 
            { return OP_REGEXNOTEQUAL;
            } 
            // fall through
          case 68: break;
          case 30: 
            { return OP_LESSEQUAL;
            } 
            // fall through
          case 69: break;
          case 31: 
            { return OP_GREATEREQUAL;
            } 
            // fall through
          case 70: break;
          case 32: 
            { return OP_OR;
            } 
            // fall through
          case 71: break;
          case 33: 
            { return REGEX_STRING;
            } 
            // fall through
          case 72: break;
          case 34: 
            { return OP_AND;
            } 
            // fall through
          case 73: break;
          case 35: 
            { return KW_VAR;
            } 
            // fall through
          case 74: break;
          case 36: 
            { return TRUE;
            } 
            // fall through
          case 75: break;
          case 37: 
            { return FALSE;
            } 
            // fall through
          case 76: break;
          case 38: 
            { return TRIPLE_QUOTED_STRING;
            } 
            // fall through
          case 77: break;
          case 39: 
            { return KW_LAMBDA;
            } 
            // fall through
          case 78: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
