
/* schema file for combat database
    authors: Lucas Burdell 
*/

DROP TABLE entitydata;
DROP TABLE insults;

CREATE TABLE entitydata (
    ENTITY_NAME VARCHAR(128) NOT NULL PRIMARY KEY,
    HEALTH INTEGER NOT NULL,
    MELEE_MODIFIER FLOAT NOT NULL,
    RANGED_MODIFIER FLOAT NOT NULL,
    VERBAL_MODIFIER FLOAT NOT NULL,
    INSULT_IMMUNITY BOOLEAN NOT NULL
);

CREATE TABLE insults (
    ID INT NOT NULL AUTO_INCREMENT,
    INSULT VARCHAR(128),
    PRIMARY KEY (ID)
);