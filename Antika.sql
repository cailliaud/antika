-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Dim 19 Novembre 2017 à 19:50
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `antika`
--
CREATE DATABASE IF NOT EXISTS `antika` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `antika`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

DROP TABLE IF EXISTS `categorie`;
CREATE TABLE `categorie` (
  `ID_CAT` int(11) NOT NULL,
  `NOM` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`ID_CAT`, `NOM`) VALUES
(1, 'SOMA'),
(2, 'SOPHOS'),
(3, 'SYMBIOSE');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `ID_UTI` int(11) NOT NULL,
  `LOGIN` varchar(30) NOT NULL,
  `PASSWORD` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `dieu`
--

DROP TABLE IF EXISTS `dieu`;
CREATE TABLE `dieu` (
  `ID_DIEU` int(11) NOT NULL,
  `POUVOIR_SECONDAIRE` int(11) NOT NULL,
  `POUVOIR_PRINCIPAL` int(11) NOT NULL,
  `NOM` varchar(50) NOT NULL,
  `URL_IMG` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `dieu`
--

INSERT INTO `dieu` (`ID_DIEU`, `POUVOIR_SECONDAIRE`, `POUVOIR_PRINCIPAL`, `NOM`, `URL_IMG`) VALUES
(1, 16, 11, 'Aphrodite', 'aphrodite.jpg'),
(2, 28, 43, 'Apollon', 'Apollon.png'),
(3, 37, 49, 'Arès', 'Arès.jpg'),
(4, 29, 18, 'Artémis', 'Artémis.jpg'),
(5, 25, 60, 'Athéna', 'Athéna.png'),
(6, 32, 84, 'Dionysos', 'Dionysos.jpg'),
(7, 52, 17, 'Hadès', 'Hadès.jpg'),
(8, 1, 53, 'Héphaïstos', 'Héphaïstos.jpg'),
(9, 83, 85, 'Hermès', 'Hermès.jpg'),
(10, 14, 65, 'Poséidon', 'Poséidon.jpg'),
(11, 36, 20, 'Zeus', 'Zeus.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `engendre`
--

DROP TABLE IF EXISTS `engendre`;
CREATE TABLE `engendre` (
  `ID_DIEU` int(11) NOT NULL,
  `ID_RACE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `engendre`
--

INSERT INTO `engendre` (`ID_DIEU`, `ID_RACE`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(5, 1),
(6, 1),
(7, 1),
(8, 1),
(9, 1),
(10, 1),
(11, 1),
(2, 2),
(4, 2),
(6, 2),
(9, 2),
(11, 2),
(2, 3),
(4, 3),
(10, 3),
(11, 3),
(6, 4),
(9, 4),
(11, 4),
(10, 5),
(11, 5);

-- --------------------------------------------------------

--
-- Structure de la table `est_capable`
--

DROP TABLE IF EXISTS `est_capable`;
CREATE TABLE `est_capable` (
  `ID_TALENT` int(11) NOT NULL,
  `ID_JOUEUR` int(11) NOT NULL,
  `POINTS` int(11) DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

DROP TABLE IF EXISTS `joueur`;
CREATE TABLE `joueur` (
  `ID_JOUEUR` int(11) NOT NULL,
  `ID_RACE` int(11) NOT NULL,
  `ID_RACE` int(11) DEFAULT NULL,
  `ID_METIER` int(11) DEFAULT NULL,
  `ID_DIEU` int(11) DEFAULT NULL,
  `NOM` varchar(30) NOT NULL,
  `TAILLE` int(11) NOT NULL,
  `POIDS` int(11) NOT NULL,
  `AGE` int(11) NOT NULL,
  `DESCRIPTION` text,
  `SEXE` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `metier`
--

DROP TABLE IF EXISTS `metier`;
CREATE TABLE `metier` (
  `ID_METIER` int(11) NOT NULL,
  `NOM` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `pouvoir`
--

DROP TABLE IF EXISTS `pouvoir`;
CREATE TABLE `pouvoir` (
  `ID_POUVOIR` int(11) NOT NULL,
  `NOM` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pouvoir`
--

INSERT INTO `pouvoir` (`ID_POUVOIR`, `NOM`) VALUES
(1, 'Affutâge d\'Héphaïstos'),
(2, 'Appel d\'Artémis'),
(3, 'Appel d\'une Nymphe'),
(4, 'Aura d\'Hélios'),
(5, 'Aveuglement d\'Hélios'),
(6, 'Baiser de Jalousie'),
(7, 'Bénédiction d\'Hécate'),
(8, 'Bouclier d\'Hécate'),
(9, 'Brume d\'Hadès'),
(10, 'Brume d\'Hypnos'),
(11, 'Changement de Sexe'),
(12, 'Chant des Limbes'),
(13, 'Chant des Sirènes'),
(14, 'Brouillard de Poséidon'),
(15, 'Chant d\'Orphée'),
(16, 'Charme d\'Aphrodite'),
(17, 'Ciseaux de Moires'),
(18, 'Colère d\'Apollon/ d\'Artémis'),
(19, 'Colère de Poséidon'),
(20, 'Colère de Zeus'),
(21, 'Cri de Déimos'),
(22, 'Croissance de Déméter'),
(23, 'Contrôle des Morts-Vivant'),
(24, 'Domination d\'Aphrodite'),
(25, 'Egide D\'athéna'),
(26, 'Etreinte de Morphée'),
(27, 'Explosion d\'Hélios'),
(28, 'Flèches d\'Apollon'),
(29, 'Flèche d\'Artémis'),
(30, 'Flèche empoisonnées d\'Artémis'),
(31, 'Flamme de Prométhée'),
(32, 'Folie de Dionysos'),
(33, 'Folie Furieuse de Phonoi'),
(34, 'Force d\'Atlas'),
(35, 'Force Herculéenne'),
(36, 'Foudre de Zeus'),
(37, 'Frénésie deBia'),
(38, 'Hiver de Déméter'),
(39, 'Illusion de Vie'),
(40, 'Inspiration d\'Ate'),
(41, 'Inspiration d\'Eros'),
(42, 'Invisibilité d\'Hadès'),
(43, 'Langage de Gaia'),
(44, 'Malédiction d\'Apollon'),
(45, 'Malédiction de Circé'),
(46, 'Masque de Dionysos'),
(47, 'Métamorphose'),
(48, 'Modification de taille'),
(49, 'Paralysie de Phobos'),
(50, 'Musique Lancinante de Pan'),
(51, 'Pestilence de Cerbère'),
(52, 'Plaie béante de Thanatos'),
(53, 'Pluie de Feu d\'Héphaïstos'),
(54, 'Poigne de Prométhée'),
(55, 'Prophétie d\'Apollon'),
(56, 'Protection élémentaire'),
(57, 'Purge d\'Asclédios'),
(58, 'Puissance divine'),
(59, 'Rappel d\'Hadès'),
(60, 'Regard de Méduse'),
(61, 'Résurrection d\'Asclépios'),
(62, 'Respiration de Poséidon'),
(63, 'Sablier de Kronos'),
(64, 'Sang de Nessos'),
(65, 'Séisme de Poséidon'),
(66, 'Serment d\'Horkos'),
(67, 'Serviteur d\'Hadès'),
(68, 'Serviteur d\'Hécate'),
(69, 'Souffle de Disnomya'),
(70, 'Souffle du Dragon'),
(71, 'Souffle d\'Eole'),
(72, 'Ténébres d\'Erebos'),
(73, 'Toile d\'Héphaïstos'),
(74, 'Toucher d\'Asclépios'),
(75, 'Toucher de Kronos'),
(76, 'Transmutation de Dionysos'),
(77, 'Transmutation de l\'eau du Styx'),
(78, 'Transmutation Pierre/Chair'),
(79, 'Voile d\'Harpocratès'),
(80, 'Vision d\'Hadès'),
(81, 'Vision de Krnonos'),
(82, 'Vision de Nyx'),
(83, 'Vitesse d\'Hermès'),
(84, 'Appel des Ménades'),
(85, 'Cambriolage Divin');

-- --------------------------------------------------------

--
-- Structure de la table `race`
--

DROP TABLE IF EXISTS `race`;
CREATE TABLE `race` (
  `ID_RACE` int(11) NOT NULL,
  `NOM` varchar(30) NOT NULL,
  `URL_IMG` varchar(50) DEFAULT NULL,
  `Information` varchar(360) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `race`
--

INSERT INTO `race` (`ID_RACE`, `NOM`, `URL_IMG`, `Information`) VALUES
(1, 'Humain', 'humain.gif', 'L\'humain a été fait à l\'image des dieux. Ils ne possèdent pas de talents spécifiques et sont capables de s\'adapter rapidement à une situation.'),
(2, 'Silène', 'silène.gif', 'Proche de son cousin le satyre, le silène est issu du mélange d\'un homme et d\'un âne. Il est très souvent tenté d\'aller courtiser les jeunes demoiselles.'),
(3, 'Centaure', 'centaure.gif', 'Fils d\'Apollon. Les centaures sont des  créatures mi-hommes, mi-chevaux. '),
(4, 'Satyre', 'satyre.gif', 'Les satyres sont le plus souvent des enfants de Dyonisos mais parfois la Déesse Hécate donne en ce bas monde un enfant ayant les traits des satyres.'),
(5, 'Ophidien', 'ophidien.gif', 'Homme à moitié humain et serpent. Ils ne sont pas très apprécié au sein des cités grecques. Cependant, ils possèdent une capacité à s\'adapter à des environnements climatiques diverses assez incroyable.');

-- --------------------------------------------------------

--
-- Structure de la table `talent`
--

DROP TABLE IF EXISTS `talent`;
CREATE TABLE `talent` (
  `ID_TALENT` int(11) NOT NULL,
  `ID_CAT` int(11) NOT NULL,
  `NOM` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `talent`
--

INSERT INTO `talent` (`ID_TALENT`, `ID_CAT`, `NOM`) VALUES
(52, 1, 'Arme tranchante'),
(53, 1, 'Arme perforante'),
(54, 1, 'Arme contondante'),
(55, 1, 'Arme ___________'),
(56, 1, 'Arme Arc'),
(57, 1, 'Arme Fronde'),
(58, 1, 'Arme de jet'),
(59, 1, 'Athléthisme'),
(60, 1, 'Bouclier'),
(61, 1, 'Cond. Attelage'),
(62, 1, 'Endurance'),
(63, 1, 'Equitation'),
(64, 1, 'Esquive'),
(65, 1, 'Grimper'),
(66, 1, 'Natation'),
(67, 1, 'Pugilat'),
(68, 1, 'Souplesse'),
(69, 1, 'Vol à la tire'),
(70, 2, 'Agriculture'),
(71, 2, 'Alchimie'),
(72, 2, 'Artisanat Forge'),
(73, 2, 'Artisanat Charpentier'),
(74, 2, 'Artisanat'),
(75, 2, 'Epos animaux'),
(76, 2, 'Epos plantes'),
(77, 2, 'Epos géographie'),
(78, 2, 'Epos mythologie'),
(79, 2, 'Epos créatures fabuleuses'),
(80, 2, 'Epos Us & coutumes'),
(81, 2, 'Gestion Patrimoine'),
(82, 2, 'Ingénieurie'),
(83, 2, 'Lire/écrire grec'),
(84, 2, 'Lire/écrire barbare'),
(85, 2, 'Lire/écrire Aegyptien'),
(86, 2, 'Médecine'),
(87, 2, 'Navigation'),
(88, 2, 'Occultisme'),
(89, 2, 'Pièges'),
(90, 2, 'Résistance'),
(91, 2, 'Stratégie'),
(92, 2, 'Survie'),
(93, 2, 'Théologie'),
(94, 3, 'Arts lyriques'),
(95, 3, 'Commandement'),
(96, 3, 'Comédie/Danse'),
(97, 3, 'Diplomatie'),
(98, 3, 'Discrétion'),
(99, 3, 'Divination'),
(100, 3, 'Dressage'),
(101, 3, 'Evaluation'),
(102, 3, 'Fouille'),
(103, 3, 'Intimidation'),
(104, 3, 'Marchandage'),
(105, 3, 'Parler grec'),
(106, 3, 'Parler aegyptien'),
(107, 3, 'Parler barbare'),
(108, 3, 'Perception'),
(109, 3, 'Persuasion'),
(110, 3, 'Pistage'),
(111, 3, 'Politique'),
(112, 3, 'Séducation'),
(113, 3, 'Sensibilité'),
(114, 3, 'Vigilance'),
(115, 3, 'Réseau');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`ID_CAT`);

  --
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur` ADD PRIMARY KEY(` ID_UTI `);
--
-- Index pour la table `dieu`
--
ALTER TABLE `dieu`
  ADD PRIMARY KEY (`ID_DIEU`),
  ADD KEY `FK_POUVOIR_PRINCIPAL` (`POUVOIR_PRINCIPAL`),
  ADD KEY `FK_POUVOIR_SECONDAIRE` (`POUVOIR_SECONDAIRE`);

--
-- Index pour la table `engendre`
--
ALTER TABLE `engendre`
  ADD PRIMARY KEY (`ID_DIEU`,`ID_RACE`),
  ADD KEY `FK_ENGENDRE1` (`ID_RACE`);

--
-- Index pour la table `est_capable`
--
ALTER TABLE `est_capable`
  ADD PRIMARY KEY (`ID_TALENT`,`ID_JOUEUR`),
  ADD KEY `FK_EST_CAPABLE1` (`ID_JOUEUR`);

--
-- Index pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`ID_JOUEUR`),
  ADD KEY `FK_A_POUR_PARENT` (`ID_DIEU`),
  ADD KEY `FK_EST_UN` (`ID_RACE`),
  ADD KEY `FK_EXERCE` (`ID_METIER`);

--
-- Index pour la table `metier`
--
ALTER TABLE `metier`
  ADD PRIMARY KEY (`ID_METIER`);

--
-- Index pour la table `pouvoir`
--
ALTER TABLE `pouvoir`
  ADD PRIMARY KEY (`ID_POUVOIR`);

--
-- Index pour la table `race`
--
ALTER TABLE `race`
  ADD PRIMARY KEY (`ID_RACE`);

--
-- Index pour la table `talent`
--
ALTER TABLE `talent`
  ADD PRIMARY KEY (`ID_TALENT`),
  ADD KEY `FK_RELATIONSHIP_7` (`ID_CAT`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `utilisateur`
  MODIFY `ID_UTI` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `ID_CAT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `dieu`
--
ALTER TABLE `dieu`
  MODIFY `ID_DIEU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `engendre`
--
ALTER TABLE `engendre`
  MODIFY `ID_DIEU` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `est_capable`
--
ALTER TABLE `est_capable`
  MODIFY `ID_TALENT` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `joueur`
--
ALTER TABLE `joueur`
  MODIFY `ID_JOUEUR` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `metier`
--
ALTER TABLE `metier`
  MODIFY `ID_METIER` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT pour la table `pouvoir`
--
ALTER TABLE `pouvoir`
  MODIFY `ID_POUVOIR` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=86;
--
-- AUTO_INCREMENT pour la table `race`
--
ALTER TABLE `race`
  MODIFY `ID_RACE` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT pour la table `talent`
--
ALTER TABLE `talent`
  MODIFY `ID_TALENT` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `dieu`
--
ALTER TABLE `dieu`
  ADD CONSTRAINT `FK_POUVOIR_PRINCIPAL` FOREIGN KEY (`POUVOIR_PRINCIPAL`) REFERENCES `pouvoir` (`ID_POUVOIR`),
  ADD CONSTRAINT `FK_POUVOIR_SECONDAIRE` FOREIGN KEY (`POUVOIR_SECONDAIRE`) REFERENCES `pouvoir` (`ID_POUVOIR`);

--
-- Contraintes pour la table `engendre`
--
ALTER TABLE `engendre`
  ADD CONSTRAINT `FK_ENGENDRE1` FOREIGN KEY (`ID_RACE`) REFERENCES `race` (`ID_RACE`),
  ADD CONSTRAINT `FK_ENGENDRE2` FOREIGN KEY (`ID_DIEU`) REFERENCES `dieu` (`ID_DIEU`);

--
-- Contraintes pour la table `est_capable`
--
ALTER TABLE `est_capable`
  ADD CONSTRAINT `FK_EST_CAPABLE1` FOREIGN KEY (`ID_JOUEUR`) REFERENCES `joueur` (`ID_JOUEUR`),
  ADD CONSTRAINT `FK_EST_CAPABLE2` FOREIGN KEY (`ID_TALENT`) REFERENCES `talent` (`ID_TALENT`);

--
-- Contraintes pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `FK_A_POUR_PARENT` FOREIGN KEY (`ID_DIEU`) REFERENCES `dieu` (`ID_DIEU`),
  ADD CONSTRAINT `FK_EST_UN` FOREIGN KEY (`ID_RACE`) REFERENCES `race` (`ID_RACE`),
  ADD CONSTRAINT `FK_EXERCE` FOREIGN KEY (`ID_METIER`) REFERENCES `metier` (`ID_METIER`),
  ADD CONSTRAINT `FK_UTILISATEUR` FOREIGN KEY (`ID_UTI`) REFERENCES `utilisateur` (`ID_UTI`);

--
-- Contraintes pour la table `talent`
--
ALTER TABLE `talent`
  ADD CONSTRAINT `FK_RELATIONSHIP_7` FOREIGN KEY (`ID_CAT`) REFERENCES `categorie` (`ID_CAT`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
