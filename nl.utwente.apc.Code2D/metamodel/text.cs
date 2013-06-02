SYNTAXDEF Code2D
FOR <http://www.utwente.nl/apc/Code2D>
START Game

TOKENS {
	DEFINE COMMENT $'//'(~('\n'|'\r'|'\uffff'))*$;
	DEFINE INTEGER $('-')?('1'..'9')('0'..'9')*|'0'$;
	DEFINE FLOAT $('-')?(('1'..'9') ('0'..'9')* | '0') '.' ('0'..'9')+ $;
}


TOKENSTYLES {
	"Game" COLOR #7F0055, BOLD;
	"World" COLOR #7F0055, BOLD;
	"Player" COLOR #7F0055, BOLD;
	"Texture" COLOR #7F0055, BOLD;
	"NPC" COLOR #7F0055, BOLD;
	"Item" COLOR #7F0055, BOLD;
}

RULES {
	Game ::= "Game" Name[] "{" (GameWorld | GameObjects)* "}";
	World ::= "World" Name[] "{" ("Other things;")* "}";
	Player ::= "Player" Name[] "{" ("Texture" ":" Texture['/0', ';'])* "}";
	NPC ::= "NPC" Name[] (":" Extends[])* "{" ("Texture" ":" Texture[] ";" | "Behaviour" ":" Behaviour[Friendly:"Friendly", Neutral:"Neutral", Hostile:"Hostile"] ";")* "}";
	Item ::= "Item" Name[] "{" ("Texture" ":" Texture[] ";")* "}";
}