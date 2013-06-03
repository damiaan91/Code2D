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
}

RULES {
	Game ::= "Game" Name[] "{" (GameObjects | GameWorld)* "}";
	Player ::= "Player" Name[] "{" ("Texture" ":" Texture[])* "}";
	NPC ::= "NPC" Name[] (":" Extends[])* "{" ("Texture" ":" Texture[] ";" | "Behaviour" ":" Behaviour[FRIENDLY:"Friendly", NEUTRAL:"Neutral", HOSTILE:"Hostile"] ";")* "}";
	Item ::= "Item" Name[] "{" ("Texture" ":" Texture[] ";")* "}";
	World ::= "World" "{" ("Name" ":" Name['"','"'] | "WorldBlocks" ":" WorldBlocks | InstancePositions | WorldTriggers | WorldEvents)* "}";
	Terrain ::= CanStand["CanStand" : ""] CanHaveItem["CanHaveItem" : ""] "Terrain" "{" "}";
	Trap ::= "Trap" "{" ("Name" ":" Name['"','"'] | "Texture" ":" Texture['"','"'])* "}";
	Scenery ::= "Scenery" "{" ("Name" ":" Name['"','"'] | "Texture" ":" Texture['"','"'])* "}";
	ObjectInstance ::= ("AddObject:" Object[] (X1[INTEGER] "x" Y1[INTEGER])* ("<>" X2[INTEGER] "x" Y2[INTEGER])*)* ";";
	TerrainInstance ::= ("AddTerrain:" Terrain[] (X1[INTEGER] "x" Y1[INTEGER])* ("<>" X2[INTEGER] "x" Y2[INTEGER])*)* ";";
	Event ::= "Event" Name[] "on" EventTriggers[] ("," EventTriggers[]) "{" "}";
	Value ::= ((Negation["!" : ""])? Value[]);
	Trigger ::= "Trigger" Name[] "{" Conditions "}";
	Condition ::= (Left Operator[COLLIDES:"collides", AND:"&", OR:"|"] Right)*;
}