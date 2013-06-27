SYNTAXDEF Code2D
FOR <http://www.utwente.nl/apc/Code2D>
START Game

OPTIONS {
	overrideBuilder = "false";
}

TOKENS {
	DEFINE UPPER $('A'..'Z')('a'..'z'|'A'..'Z'|'0'..'9'|'.')*$;
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
	"Behaviour" COLOR #7F0055, BOLD;
	"Terrain" COLOR #7F0055, BOLD;
	"WorldBlocks" COLOR #7F0055, BOLD;
	"Trap" COLOR #7F0055, BOLD;
	"Scenery" COLOR #7F0055, BOLD;
	"Name" COLOR #7F0055, BOLD;
	"ObjectInstance" COLOR #7F0055, BOLD;
	"Object" COLOR #7F0055, BOLD;
	"X1" COLOR #7F0055, BOLD;
	"X2" COLOR #7F0055, BOLD;
	"Y1" COLOR #7F0055, BOLD;
	"Y2" COLOR #7F0055, BOLD;
	"x" COLOR #7F0055, BOLD;
	"TerrainInstance" COLOR #7F0055, BOLD;
	"Event" COLOR #7F0055, BOLD;
	"EventTriggers" COLOR #7F0055, BOLD;
	"Trigger" COLOR #7F0055, BOLD;
	"Conditions" COLOR #7F0055, BOLD;
	"Value" COLOR #7F0055, BOLD;
	"Condition" COLOR #7F0055, BOLD;
	"Left" COLOR #7F0055, BOLD;
	"Right" COLOR #7F0055, BOLD;
	"Operator" COLOR #7F0055, BOLD;
	"CollisionTrigger" COLOR #7F0055, BOLD;
	"EventActions" COLOR #7F0055, BOLD;
	"AddToInventoryAction" COLOR #7F0055, BOLD;
	"EReference0" COLOR #7F0055, BOLD;
	"BasicAction" COLOR #7F0055, BOLD;
	"Action" COLOR #7F0055, BOLD;
	"Object1" COLOR #7F0055, BOLD;
	"Object2" COLOR #7F0055, BOLD;
	"on" COLOR #7F0055, BOLD;
	"Collide" COLOR #7F0055, BOLD;
}

RULES {
	Game ::= "Game" Name[UPPER] "{" GameWorld GameObjects*  "}";
	Player ::= "Player" Name[UPPER] "{" ("Texture" ":" Texture[] ";")? "}";
	NPC ::= "NPC" Name[UPPER] (":" Extends[UPPER])? "{" ("Behaviour" ":" Behaviour[FRIENDLY:"Friendly", NEUTRAL:"Neutral", HOSTILE:"Hostile"] ";")? ("Texture" ":" Texture[] ";")? "}";
	Item ::= "Item" Name[UPPER] "{" ("Texture" ":" Texture[] ";")? "}";
	World ::= "World" Name[UPPER] "{" ((WorldInstances ";") | WorldEvents | WorldTriggers )*"}";
	Terrain ::= "Terrain" Name[UPPER] "{" ("CanStandOn:" CanStand["True" : "False"] ";")? ("CanHaveItems:" CanHaveItem["True" : "False"] ";")? ("Texture" ":" Texture[] ";")? "}";
	Trap ::= "Trap"  Name[UPPER] "{" ("Texture" ":" Texture[] ";")? "}";
	Scenery ::= "Scenery"  Name[UPPER] "{" ("Texture" ":" Texture[] ";")* "}";
	Instance ::= "AddInstance:" Object[UPPER] (X1[INTEGER] "x" Y1[INTEGER]) ("<>" X2[INTEGER] "x" Y2[INTEGER])?;
	Event ::= "Event" Name[UPPER] "on" CollisionTrigger[UPPER] "{" (EventActions ";")+ "}";
	AddToInventoryAction ::= "AddToInventoryAction" ":" Item[UPPER];
	BasicAction ::= Action[ENDGAME:"ENDGAME"];
	CollisionTrigger ::= "CollisionTrigger" Name[UPPER] "{" "Collide" ":" Object1[UPPER] Object2[UPPER] ";" "}";
}

