/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     23/10/2017 22:49:19                          */
/*==============================================================*/

DROP TABLE IF EXISTS JOUEUR;

DROP TABLE IF EXISTS CATEGORIE;

DROP TABLE IF EXISTS EST_CAPABLE;

DROP TABLE IF EXISTS DIEU;

DROP TABLE IF EXISTS TALENT;

DROP TABLE IF EXISTS METIER;

DROP TABLE IF EXISTS POUVOIR;

DROP TABLE IF EXISTS RACE;



/*==============================================================*/
/* Table: CATEGORIE                                             */
/*==============================================================*/
CREATE TABLE CATEGORIE
(
   ID_CAT               INT NOT NULL AUTO_INCREMENT,
   NOM                  VARCHAR(30) NOT NULL,
   PRIMARY KEY (ID_CAT)
);


/*==============================================================*/
/* Table: DIEU                                                  */
/*==============================================================*/
CREATE TABLE DIEU
(
   ID_DIEU              INT NOT NULL AUTO_INCREMENT,
   POUVOIR_SECONDAIRE   INT NOT NULL,
   POUVOIR_PRINCIPAL    INT NOT NULL,
   NOM                  VARCHAR(50) NOT NULL,
   URL_IMG              VARCHAR(50),
   PRIMARY KEY (ID_DIEU)
);



/*==============================================================*/
/* Table: EST_CAPABLE                                           */
/*==============================================================*/
CREATE TABLE EST_CAPABLE
(
   ID_TALENT            INT NOT NULL AUTO_INCREMENT,
   ID_JOUEUR            INT NOT NULL,
   PRIMARY KEY (ID_TALENT, ID_JOUEUR)
);



/*==============================================================*/
/* Table: JOUEUR                                                */
/*==============================================================*/
CREATE TABLE JOUEUR
(
   ID_JOUEUR            INT NOT NULL AUTO_INCREMENT,
   ID_RACE              INT,
   ID_METIER            INT,
   ID_DIEU              INT,
   NOM                  VARCHAR(30) NOT NULL,
   TAILLE               INT NOT NULL,
   POIDS                INT NOT NULL,
   AGE                  INT NOT NULL,
   DESCRIPTION          TEXT,
   PRIMARY KEY (ID_JOUEUR)
);


/*==============================================================*/
/* Table: METIER                                                */
/*==============================================================*/
CREATE TABLE METIER
(
   ID_METIER            INT NOT NULL AUTO_INCREMENT,
   NOM                  VARCHAR(30) NOT NULL,
   PRIMARY KEY (ID_METIER)
);


/*==============================================================*/
/* Table: POUVOIR                                               */
/*==============================================================*/
CREATE TABLE POUVOIR
(
   ID_POUVOIR           INT NOT NULL AUTO_INCREMENT,
   NOM                  VARCHAR(80) NOT NULL,
   PRIMARY KEY (ID_POUVOIR)
);



/*==============================================================*/
/* Table: RACE                                                  */
/*==============================================================*/
CREATE TABLE RACE
(
   ID_RACE              INT NOT NULL AUTO_INCREMENT,
   NOM                  VARCHAR(30) NOT NULL,
   URL_IMG              VARCHAR(50),
   PRIMARY KEY (ID_RACE)
);



/*==============================================================*/
/* Table: TALENT                                                */
/*==============================================================*/
CREATE TABLE TALENT
(
   ID_TALENT            int NOT NULL AUTO_INCREMENT,
   ID_CAT               INT NOT NULL NOT NULL,
   NOM                  VARCHAR(40) NOT NULL,
   PRIMARY KEY (ID_TALENT)
);


ALTER TABLE DIEU ADD CONSTRAINT FK_POUVOIR_PRINCIPAL FOREIGN KEY (POUVOIR_PRINCIPAL)
      REFERENCES POUVOIR (ID_POUVOIR) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE DIEU ADD CONSTRAINT FK_POUVOIR_SECONDAIRE FOREIGN KEY (POUVOIR_SECONDAIRE)
      REFERENCES POUVOIR (ID_POUVOIR) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE EST_CAPABLE ADD CONSTRAINT FK_EST_CAPABLE1 FOREIGN KEY (ID_JOUEUR)
      REFERENCES JOUEUR (ID_JOUEUR) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE EST_CAPABLE ADD CONSTRAINT FK_EST_CAPABLE2 FOREIGN KEY (ID_TALENT)
      REFERENCES TALENT (ID_TALENT) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE JOUEUR ADD CONSTRAINT FK_A_POUR_PARENT FOREIGN KEY (ID_DIEU)
      REFERENCES DIEU (ID_DIEU) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE JOUEUR ADD CONSTRAINT FK_EST_UN FOREIGN KEY (ID_RACE)
      REFERENCES RACE (ID_RACE) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE JOUEUR ADD CONSTRAINT FK_EXERCE FOREIGN KEY (ID_METIER)
      REFERENCES METIER (ID_METIER) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE TALENT ADD CONSTRAINT FK_RELATIONSHIP_7 FOREIGN KEY (ID_CAT)
      REFERENCES CATEGORIE (ID_CAT) ON DELETE RESTRICT ON UPDATE RESTRICT;


