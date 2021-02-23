-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 23 fév. 2021 à 08:14
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `lycee_java`
--
CREATE DATABASE IF NOT EXISTS `lycee_java` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `lycee_java`;

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(30) NOT NULL,
  `id_prof_principal` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_prof_prin` (`id_prof_principal`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`id`, `libelle`, `id_prof_principal`) VALUES
(1, 'BTS SIO SLAM', 2);

-- --------------------------------------------------------

--
-- Structure de la table `eleve`
--

DROP TABLE IF EXISTS `eleve`;
CREATE TABLE IF NOT EXISTS `eleve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `id_classe` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_classe` (`id_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `eleve` (`id`, `nom`, `prenom, id_classe`) VALUES
(1, 'LIGNANI', 'Quentin', 1),
(2, 'BERNARD', 'Jean', 1);
-- --------------------------------------------------------

--
-- Structure de la table `grille_horaire`
--

DROP TABLE IF EXISTS `grille_horaire`;
CREATE TABLE IF NOT EXISTS `grille_horaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_jour` int(11) NOT NULL,
  `id_heure` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_jour` (`id_jour`),
  KEY `fk_heure` (`id_heure`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `grille_horaire`
--

INSERT INTO `grille_horaire` (`id`, `id_jour`, `id_heure`) VALUES
(1, 1, 3),
(2, 1, 7);

-- --------------------------------------------------------

--
-- Structure de la table `heure`
--

DROP TABLE IF EXISTS `heure`;
CREATE TABLE IF NOT EXISTS `heure` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `heure`
--

INSERT INTO `heure` (`id`, `libelle`) VALUES
(1, '8h'),
(2, '9h'),
(3, '10h'),
(4, '11h'),
(5, '12h'),
(6, '14h'),
(7, '15h'),
(8, '16h'),
(9, '17h');

-- --------------------------------------------------------

--
-- Structure de la table `jour`
--

DROP TABLE IF EXISTS `jour`;
CREATE TABLE IF NOT EXISTS `jour` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `jour`
--

INSERT INTO `jour` (`id`, `libelle`) VALUES
(1, 'Lundi'),
(2, 'Mardi'),
(3, 'Mercredi'),
(4, 'Jeudi'),
(5, 'Vendredi');

-- --------------------------------------------------------

--
-- Structure de la table `planning`
--

DROP TABLE IF EXISTS `planning`;
CREATE TABLE IF NOT EXISTS `planning` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_grille` int(11) NOT NULL,
  `id_classe` int(11) NOT NULL,
  `id_professeur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_grille` (`id_grille`),
  KEY `fk_prof` (`id_professeur`),
  KEY `fk_classe2` (`id_classe`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `planning`
--

INSERT INTO `planning` (`id`, `id_grille`, `id_classe`, `id_professeur`) VALUES
(1, 1, 1, 2),
(2, 2, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(40) NOT NULL,
  `identifiant` varchar(30) NOT NULL,
  `mdp` varchar(100) NOT NULL,
  `matiere` varchar(30) DEFAULT NULL,
  `role` varchar(10) NOT NULL DEFAULT 'professeur',
  PRIMARY KEY (`id`),
  UNIQUE KEY `identifiant` (`identifiant`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `email`, `identifiant`, `mdp`, `matiere`, `role`) VALUES
(1, 'Admin', 'Admin', 'Admin@Admin', 'Admin', 'Admin', NULL, 'Admin'),
(2, 'Bertrand', 'Olivier', 'Oli@oli', 'test', 'test', 'Mathématique', 'professeur');

-- --------------------------------------------------------

--
-- Structure de la table `vie_scolaire`
--

DROP TABLE IF EXISTS `vie_scolaire`;
CREATE TABLE IF NOT EXISTS `vie_scolaire` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_eleve` int(11) NOT NULL,
  `type` varchar(30) NOT NULL,
  `date` date NOT NULL,
  `justification` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_eleve` (`id_eleve`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `fk_prof_prin` FOREIGN KEY (`id_prof_principal`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `eleve`
--
ALTER TABLE `eleve`
  ADD CONSTRAINT `fk_classe` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`);

--
-- Contraintes pour la table `grille_horaire`
--
ALTER TABLE `grille_horaire`
  ADD CONSTRAINT `fk_heure` FOREIGN KEY (`id_heure`) REFERENCES `heure` (`id`),
  ADD CONSTRAINT `fk_jour` FOREIGN KEY (`id_jour`) REFERENCES `jour` (`id`);

--
-- Contraintes pour la table `planning`
--
ALTER TABLE `planning`
  ADD CONSTRAINT `fk_classe2` FOREIGN KEY (`id_classe`) REFERENCES `classe` (`id`),
  ADD CONSTRAINT `fk_grille` FOREIGN KEY (`id_grille`) REFERENCES `grille_horaire` (`id`),
  ADD CONSTRAINT `fk_prof` FOREIGN KEY (`id_professeur`) REFERENCES `utilisateur` (`id`);

--
-- Contraintes pour la table `vie_scolaire`
--
ALTER TABLE `vie_scolaire`
  ADD CONSTRAINT `fk_eleve` FOREIGN KEY (`id_eleve`) REFERENCES `eleve` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
