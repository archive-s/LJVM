package org.lucylang.ljvm.parser;

import beaver.*;
import java.util.ArrayList;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "grammar.beaver".
 */
public class Parser extends beaver.Parser {
	static public class Terminals {
		static public final short EOF = 0;
		static public final short FUNC = 1;
		static public final short ID = 2;
	}

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9nDZe4AW20GGwUPKa7Vx7#NhiqC6apSV787uCI2o8iDgwsKI7POsKaT48QT9BqJKPTI1wO" +
		"Us6IJktouho$P9fE#RkQ2dtYRqF#WCuufsWhv0Mp$5$S=");

	static final Action RETURN2 = new Action() {
		public Symbol reduce(Symbol[] _symbols, int offset) {
			return _symbols[offset + 2];
		}
	};

	private final Action[] actions;

	public Parser() {
		super(PARSING_TABLES);
		actions = new Action[] {
			Action.RETURN,	// [0] module = functions
			RETURN2,	// [1] functions = function functions; returns 'functions' although none is marked
			Action.NONE,  	// [2] functions = 
			RETURN2	// [3] function = FUNC ID; returns 'ID' although none is marked
		};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}
}