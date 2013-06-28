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
	"Trap" COLOR #7F0055, BOLD;
	"Scenery" COLOR #7F0055, BOLD;
	"x" COLOR #7F0055, BOLD;
	"Event" COLOR #7F0055, BOLD;
	"CollisionTrigger" COLOR #7F0055, BOLD;
	"AddToInventoryAction" COLOR #7F0055, BOLD;
	"on" COLOR #7F0055, BOLD;
	"Collide" COLOR #7F0055, BOLD;
	"Width" COLOR #7F0055, BOLD;
	"Height" COLOR #7F0055, BOLD;
	"AddPlayer" COLOR #7F0055, BOLD;
}

RULES {
	Game ::= "Game" Name[UPPER] "{" GameWorld Player GameObjects* "}";
	Player ::= "Player" Name[UPPER] "{" ("Width" ":" Width[INTEGER] ";")? ("Height" ":" Height[INTEGER] ";")? ("Inventory" ":" "{" ("AddItem" ":" InventoryItems[UPPER] ";")* "}")? ("Texture" ":" Texture[] ";")? "}";
	NPC ::= "NPC" Name[UPPER] (":" Extends[UPPER])? "{" ("Width" ":" Width[INTEGER] ";")? ("Height" ":" Height[INTEGER] ";")? ("Behaviour" ":" Behaviour[FRIENDLY:"Friendly", NEUTRAL:"Neutral", HOSTILE:"Hostile"] ";")? ("Texture" ":" Texture[] ";")? "}";
	Item ::= "Item" Name[UPPER] "{" ("Width" ":" Width[INTEGER] ";")? ("Height" ":" Height[INTEGER] ";")? ("Texture" ":" Texture[] ";")? "}";
	Terrain ::= "Terrain" Name[UPPER] "{" ("Width" ":" Width[INTEGER] ";")? ("Height" ":" Height[INTEGER] ";")? ("CanStandOn:" CanStand["True" : "False"] ";")? ("CanHaveItems:" CanHaveItem["True" : "False"] ";")? ("Texture" ":" Texture[] ";")? "}";
	Trap ::= "Trap"  Name[UPPER] "{" ("Width" ":" Width[INTEGER] ";")? ("Height" ":" Height[INTEGER] ";")? ("Texture" ":" Texture[] ";")? "}";
	Scenery ::= "Scenery"  Name[UPPER] "{" ("Width" ":" Width[INTEGER] ";")? ("Height" ":" Height[INTEGER] ";")? ("Texture" ":" Texture[] ";")? "}";
	World ::= "World" Name[UPPER] "{" PlayerInstance WorldInstances* WorldEvents* WorldTriggers* "}";
	PlayerInstance ::= "AddPlayer" ":" Player[UPPER] X1[INTEGER] "x" Y1[INTEGER] ";";
	ObjectInstance ::= "AddInstance" ":" Object[UPPER] X1[INTEGER] "x" Y1[INTEGER] ("<>" X2[INTEGER] "x" Y2[INTEGER])? ";";
	Event ::= "Event" Name[UPPER] "on" CollisionTrigger[UPPER] "{" (EventActions)+ "}";
	AddToInventoryAction ::= "AddToInventoryAction" ":" Item[UPPER] ";";
	BasicAction ::= Action[ENDGAME:"ENDGAME"] ";";
	CollisionTrigger ::= "CollisionTrigger" Name[UPPER] "{" "Collide" ":" Object1[UPPER] Object2[UPPER] ";" "}";
	
}

