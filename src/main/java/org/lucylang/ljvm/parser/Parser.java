package org.lucylang.ljvm.parser;

import org.lucylang.ljvm.node.*;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import beaver.*;
import org.apache.logging.log4j.LogManager;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "grammar.beaver".
 */
public class Parser extends beaver.Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short ID = 1;
		static public final short LPAREN = 2;
		static public final short NOT = 3;
		static public final short BOOL_LITERAL = 4;
		static public final short NUMBER_LITERAL = 5;
		static public final short STRING_LITERAL = 6;
		static public final short NONE_LITERAL = 7;
		static public final short PLUS = 8;
		static public final short MINUS = 9;
		static public final short TIMES = 10;
		static public final short DIV = 11;
		static public final short AND = 12;
		static public final short OR = 13;
		static public final short EQUAL = 14;
		static public final short NEQ = 15;
		static public final short GT = 16;
		static public final short LT = 17;
		static public final short GEQ = 18;
		static public final short LEQ = 19;
		static public final short STMT_TAIL = 20;
		static public final short SEMICOLON = 21;
		static public final short RPAREN = 22;
		static public final short LCURLY = 23;
		static public final short RCURLY = 24;
		static public final short FUNC = 25;
		static public final short COMMA = 26;
		static public final short ASSIGN = 27;
		static public final short VAR = 28;
		static public final short IF = 29;
		static public final short WHILE = 30;
		static public final short RETURN = 31;
		static public final short ELSE = 32;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9pTbkblb5KKnfztXhQMHK2qCnIiZBHGsw52AGKHGHOLsoeAobBB8WAIc9YOa9WOJOWc$W5" +
		"64usDI#87etnNumSJLt375LTmmnNt1K4z$juxP#hCs9baZ7nX9izvplREFVUUU#yxKhHRqz" +
		"IgDcNLePdgL9UwDK$pjI3uBomRxL6B5cfqXVZqYl5ZxJ#rA99IhJQeHcarQ98cguduYLgba" +
		"wZp4kfCgKuJL5yGppzzgKxMAJfTYyt8FOFSqtIPrgZ$NoDNQo$I1JfFlUhJHRguehMYYjpZ" +
		"mLfLj5O3Ea49RHponVqOhQqQiByq0lzwZRAdb1pgou2sQ0p#E6zSo1ghyTx7bVImdHxsQ0P" +
		"oeZPh2lgPmJChoDb1pWboRf1d1NbsaES4kIp8yuDS7kJbGQuDyWejjDyrCenthZQ5kfTurK" +
		"lLgAbyCqIQjLhhs85NwYeYjSfzcfbjFK#FmZU6FJgMEOmdQqBmDvIDPjYZKzd7$pL#hFsPe" +
		"aWhQz$6QShIXmxMVoRnJaNCFbTdAteRlVWddd#wDQnaEnrAU#vapd8JtIyTkLexOfSbsL4r" +
		"zAAkejLGHUxnOHMkLJEnQTpkUL$SZnIzRAQdiJ$Dcw6RqvJlIpFFn$uuBusL3bQ#ZxaUvkG" +
		"KLhQhoFD$IV7ByNW9pb$k7EMgRgJMY6yZaKdeBQ7Q5Y8JBNpmIjjsXgCPBKFqmvl0GpcVRa" +
		"PV0RQ3Ey1IpxqJB0ThmMhFlJ7cuK3EUd1FcTWZu3xmgDlt8vu4qy4U$#szpll02B2Vl0VXW" +
		"#0MS0Yx3$uPR057iPU01FhjS3qy28#37u1Jy2uVxp74u$2Wsqs8sN0Bl0ZEib27oytDw#ej" +
		"cCykmFEgSti#8kNwOiIQaldV2vvm$U5XrYSBEi4yZBwISLTwpWBdk8SzS44zwgzSUtHR6N#" +
		"lFtzrtiSw777VIESTdkjx85hdlD5vi$DMv#tErpXVwtoTyuwI#MqegETwvnkSRweqhp9psX" +
		"dlNTVPDz5ThjywJExT1VfWILtRSiJRLtPOGn$xDVO4xKVmftrlH#s8VMk7x1li0$QrVMLVs" +
		"XVeduE3zYdoO$0MU1Ey0Lu7hu6zu5Nm2dWPl0HU12$OFdixZC4fi0$0yy7QOxljENlMdh6d" +
		"xKDxtpwnpxoMZu9ypzwrT#mF#y6#u#JBE2lsY$raln6C$sd6zrXywX8W2ZT5Z6vkoba14RT" +
		"WBQZXT2H1V9FKW2JljcHulxLLm0n#jukyBlHsHojs5dI03ESw0yy9Y7Wh9dalHY317HSvab" +
		"KYuHnnInPZxjygQNHR");

    private final Logger logger = LogManager.getLogger(Parser.class.getName());

    public Module parseModule(beaver.Scanner source) throws IOException, Parser.Exception {
        return (Module) super.parse(source);
    }

    public Object parse(Scanner source, short alt_goal_marker_id) throws IOException, Parser.Exception {
        return (Module) super.parse(source, alt_goal_marker_id);
    }

    @Override
    protected void recoverFromError(Symbol token, TokenStream in) throws java.io.IOException, Exception {
        super.recoverFromError(new Symbol(0), in);
    }

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] maybe_tail = stmt_tails
			Action.NONE,  	// [1] maybe_tail = 
			new Action() {	// [2] stmt_tails = stmt_tails stmt_tail
				public Symbol reduce(Symbol[] _symbols, int offset) {
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2]); return _symbols[offset + 1];
				}
			},
			new Action() {	// [3] stmt_tails = stmt_tail
				public Symbol reduce(Symbol[] _symbols, int offset) {
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1]); return new Symbol(lst);
				}
			},
			Action.RETURN,	// [4] stmt_tail = STMT_TAIL
			Action.RETURN,	// [5] stmt_tail = SEMICOLON
			new Action() {	// [6] module = maybe_tail functions.fs maybe_tail
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_fs = _symbols[offset + 2];
					final SymbolList fs = (SymbolList) _symbol_fs.value;
					 Module module = new Module();
               for(int i=0; i<fs.size(); i++) {
                   module.addFunction((Function) fs.get(i));
               }
               return module;
				}
			},
			new Action() {	// [7] functions = functions.fs maybe_tail function.f
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_fs = _symbols[offset + 1];
					final SymbolList fs = (SymbolList) _symbol_fs.value;
					final Symbol _symbol_f = _symbols[offset + 3];
					final Function f = (Function) _symbol_f.value;
					 fs.add(f);
               return fs;
				}
			},
			new Action() {	// [8] functions = function.f
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_f = _symbols[offset + 1];
					final Function f = (Function) _symbol_f.value;
					 SymbolList list = new SymbolList();
               list.add(f);
               return list;
				}
			},
			new Action() {	// [9] function = FUNC ID.name LPAREN parameters.list RPAREN block_statements.stmts
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol name = _symbols[offset + 2];
					final Symbol _symbol_list = _symbols[offset + 4];
					final SymbolList list = (SymbolList) _symbol_list.value;
					final Symbol _symbol_stmts = _symbols[offset + 6];
					final SymbolList stmts = (SymbolList) _symbol_stmts.value;
					 Function function = new Function((String) name.value);
               logger.trace("Function " + name.value + " parameters size: " + list.size());
               for(int i=0; i<list.size(); i++) {
                   logger.trace(list.get(i));
                   function.addParameter((VarName) list.get(i));
               }
               for(int i=0; i<stmts.size(); i++) {
                   function.addStmt((IStmt)stmts.get(i));
               }
               return function;
				}
			},
			new Action() {	// [10] function = FUNC ID.name LPAREN RPAREN block_statements.stmts
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol name = _symbols[offset + 2];
					final Symbol _symbol_stmts = _symbols[offset + 5];
					final SymbolList stmts = (SymbolList) _symbol_stmts.value;
					 Function function = new Function((String) name.value);
               logger.trace("Function " + name.value + " parameters size: 0");
               for(int i=0; i<stmts.size(); i++) {
                   function.addStmt((IStmt)stmts.get(i));
               }
               return function;
				}
			},
			new Action() {	// [11] parameters = parameters.list COMMA ID.varName
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final SymbolList list = (SymbolList) _symbol_list.value;
					final Symbol varName = _symbols[offset + 3];
					 list.add(new VarName((String) varName.value));
               return list;
				}
			},
			new Action() {	// [12] parameters = ID.varName
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol varName = _symbols[offset + 1];
					 SymbolList list = new SymbolList();
               list.add(new VarName((String) varName.value));
               return list;
				}
			},
			new Action() {	// [13] block_statements = LCURLY maybe_tail statements.stmts maybe_tail RCURLY
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stmts = _symbols[offset + 3];
					final SymbolList stmts = (SymbolList) _symbol_stmts.value;
					 return stmts;
				}
			},
			new Action() {	// [14] block_statements = LCURLY maybe_tail RCURLY
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new SymbolList();
				}
			},
			new Action() {	// [15] statements = statements.stmts stmt_tails statement.stmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_stmts = _symbols[offset + 1];
					final SymbolList stmts = (SymbolList) _symbol_stmts.value;
					final Symbol stmt = _symbols[offset + 3];
					 if(stmt instanceof SymbolList) {
                   SymbolList list = (SymbolList) stmt;
                   for(int i=0; i<list.size(); i++) {
                       stmts.add(list.get(i));
                   }
               } else {
                   stmts.add(stmt);
               }
               return stmts;
				}
			},
			new Action() {	// [16] statements = statement.stmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol stmt = _symbols[offset + 1];
					 if(stmt instanceof SymbolList) {
                   return stmt;
               } else {
                   SymbolList list = new SymbolList();
                   list.add(stmt);
                   return list;
               }
				}
			},
			new Action() {	// [17] statement = var_statement.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol var = _symbols[offset + 1];
					 return var;
				}
			},
			new Action() {	// [18] statement = assign_statement.assign
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_assign = _symbols[offset + 1];
					final Assignment assign = (Assignment) _symbol_assign.value;
					 return assign;
				}
			},
			new Action() {	// [19] statement = if_statement.ifStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_ifStmt = _symbols[offset + 1];
					final IfElse ifStmt = (IfElse) _symbol_ifStmt.value;
					 return ifStmt;
				}
			},
			new Action() {	// [20] statement = if_else_statement.ifStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_ifStmt = _symbols[offset + 1];
					final IfElse ifStmt = (IfElse) _symbol_ifStmt.value;
					 return ifStmt;
				}
			},
			new Action() {	// [21] statement = while_statement.whileStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_whileStmt = _symbols[offset + 1];
					final While whileStmt = (While) _symbol_whileStmt.value;
					 return whileStmt;
				}
			},
			new Action() {	// [22] statement = call_statement.call
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_call = _symbols[offset + 1];
					final Call call = (Call) _symbol_call.value;
					 return call;
				}
			},
			new Action() {	// [23] statement = return_statement.returnStmt
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_returnStmt = _symbols[offset + 1];
					final Return returnStmt = (Return) _symbol_returnStmt.value;
					 return returnStmt;
				}
			},
			new Action() {	// [24] var_statement = VAR var_declarations.declarations
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_declarations = _symbols[offset + 2];
					final SymbolList declarations = (SymbolList) _symbol_declarations.value;
					 return declarations;
				}
			},
			new Action() {	// [25] var_declarations = var_declarations.declarations COMMA var_declaration.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_declarations = _symbols[offset + 1];
					final SymbolList declarations = (SymbolList) _symbol_declarations.value;
					final Symbol var = _symbols[offset + 3];
					 declarations.add(var);
               return declarations;
				}
			},
			new Action() {	// [26] var_declarations = var_declaration.var
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol var = _symbols[offset + 1];
					 SymbolList list = new SymbolList();
               list.add(var);
               return list;
				}
			},
			new Action() {	// [27] var_declaration = ID.varName
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol varName = _symbols[offset + 1];
					 return new Assignment(new VarName((String) varName.value), new NoneLiteral());
				}
			},
			new Action() {	// [28] var_declaration = assign_statement.assignment
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_assignment = _symbols[offset + 1];
					final Assignment assignment = (Assignment) _symbol_assignment.value;
					 return assignment;
				}
			},
			new Action() {	// [29] assign_statement = ID.varName ASSIGN expr.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol varName = _symbols[offset + 1];
					final Symbol _symbol_value = _symbols[offset + 3];
					final IValue value = (IValue) _symbol_value.value;
					 return new Assignment(new VarName((String) varName.value), value);
				}
			},
			new Action() {	// [30] if_statement = IF expr.value block_statements.statements
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 2];
					final IValue value = (IValue) _symbol_value.value;
					final Symbol _symbol_statements = _symbols[offset + 3];
					final SymbolList statements = (SymbolList) _symbol_statements.value;
					 IfElse ifElse = new IfElse(value);
               for(int i=0; i<statements.size(); i++)
                   ifElse.addStmtIf((IStmt) statements.get(i));
               return ifElse;
				}
			},
			new Action() {	// [31] if_else_statement = if_statement.ifElse ELSE block_statements.statements
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_ifElse = _symbols[offset + 1];
					final IfElse ifElse = (IfElse) _symbol_ifElse.value;
					final Symbol _symbol_statements = _symbols[offset + 3];
					final SymbolList statements = (SymbolList) _symbol_statements.value;
					 for(int i=0; i<statements.size(); i++)
                   ifElse.addStmtElse((IStmt) statements.get(i));
               return ifElse;
				}
			},
			new Action() {	// [32] call_statement = ID.name LPAREN exprs.list RPAREN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol name = _symbols[offset + 1];
					final Symbol _symbol_list = _symbols[offset + 3];
					final SymbolList list = (SymbolList) _symbol_list.value;
					 Call call = new Call(new VarName((String) name.value));
               for(int i=0; i<list.size(); i++) {
                   call.addParameter((IValue) list.get(i));
               }
               return call;
				}
			},
			new Action() {	// [33] call_statement = ID.name LPAREN RPAREN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol name = _symbols[offset + 1];
					  return new Call(new VarName((String) name.value));
				}
			},
			new Action() {	// [34] exprs = exprs.list COMMA expr.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_list = _symbols[offset + 1];
					final SymbolList list = (SymbolList) _symbol_list.value;
					final Symbol _symbol_value = _symbols[offset + 3];
					final IValue value = (IValue) _symbol_value.value;
					 list.add((Node) value);
               return list;
				}
			},
			new Action() {	// [35] exprs = expr.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 1];
					final IValue value = (IValue) _symbol_value.value;
					 SymbolList list = new SymbolList();
               list.add((Node) value);
               return list;
				}
			},
			new Action() {	// [36] while_statement = WHILE expr.value block_statements.statements
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 2];
					final IValue value = (IValue) _symbol_value.value;
					final Symbol _symbol_statements = _symbols[offset + 3];
					final SymbolList statements = (SymbolList) _symbol_statements.value;
					 While whileStmt = new While(value);
               for(int i=0; i<statements.size(); i++)
                   whileStmt.addStmt((IStmt) statements.get(i));
               return whileStmt;
				}
			},
			new Action() {	// [37] return_statement = RETURN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					 return new Return();
				}
			},
			new Action() {	// [38] return_statement = RETURN expr.value
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_value = _symbols[offset + 2];
					final IValue value = (IValue) _symbol_value.value;
					 return new Return(value);
				}
			},
			new Action() {	// [39] expr = literal_expr.literal
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol literal = _symbols[offset + 1];
					 return literal;
				}
			},
			new Action() {	// [40] expr = ID.id
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol id = _symbols[offset + 1];
					 String value = (String) id.value;
               return new VarName(value);
				}
			},
			new Action() {	// [41] expr = expr.left PLUS expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new AddExpr(left, right);
				}
			},
			new Action() {	// [42] expr = expr.left MINUS expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new SubExpr(left, right);
				}
			},
			new Action() {	// [43] expr = expr.left TIMES expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new MulExpr(left, right);
				}
			},
			new Action() {	// [44] expr = expr.left DIV expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new DivExpr(left, right);
				}
			},
			new Action() {	// [45] expr = expr.left AND expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new AndExpr(left, right);
				}
			},
			new Action() {	// [46] expr = expr.left OR expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new OrExpr(left, right);
				}
			},
			new Action() {	// [47] expr = expr.left EQUAL expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new EquExpr(left, right);
				}
			},
			new Action() {	// [48] expr = expr.left NEQ expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new NotExpr(new EquExpr(left, right));
				}
			},
			new Action() {	// [49] expr = expr.left GT expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new GreExpr(left, right);
				}
			},
			new Action() {	// [50] expr = expr.left LT expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new LesExpr(left, right);
				}
			},
			new Action() {	// [51] expr = expr.left GEQ expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new GeqExpr(left, right);
				}
			},
			new Action() {	// [52] expr = expr.left LEQ expr.right
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 1];
					final IValue left = (IValue) _symbol_left.value;
					final Symbol _symbol_right = _symbols[offset + 3];
					final IValue right = (IValue) _symbol_right.value;
					  return new LeqExpr(left, right);
				}
			},
			new Action() {	// [53] expr = NOT expr.left
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 2];
					final IValue left = (IValue) _symbol_left.value;
					  return new NotExpr(left);
				}
			},
			new Action() {	// [54] expr = LPAREN expr.left RPAREN
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_left = _symbols[offset + 2];
					final IValue left = (IValue) _symbol_left.value;
					  return (Node) left;
				}
			},
			new Action() {	// [55] expr = call_statement.call
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol _symbol_call = _symbols[offset + 1];
					final Call call = (Call) _symbol_call.value;
					  return (Node) call;
				}
			},
			new Action() {	// [56] literal_expr = BOOL_LITERAL.bool
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol bool = _symbols[offset + 1];
					 if(bool.value.equals("true")) {
                   return new BooleanLiteral(true);
               } else {
                   return new BooleanLiteral(false);
               }
				}
			},
			new Action() {	// [57] literal_expr = NUMBER_LITERAL.number
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol number = _symbols[offset + 1];
					 String value = (String) number.value;
               if(value.contains(".")) {
                   return new NumberLiteral(Double.parseDouble(value));
               } else {
                   return new NumberLiteral(Integer.parseInt(value));
               }
				}
			},
			new Action() {	// [58] literal_expr = STRING_LITERAL.string
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol string = _symbols[offset + 1];
					 String value = (String) string.value;
               return new StringLiteral(value);
				}
			},
			new Action() {	// [59] literal_expr = NONE_LITERAL.none
				public Symbol reduce(Symbol[] _symbols, int offset) {
					final Symbol none = _symbols[offset + 1];
					 return new NoneLiteral();
				}
			}
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}
