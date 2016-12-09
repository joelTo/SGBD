-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 07 Décembre 2016 à 14:09
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `pizzeira`
--

-- --------------------------------------------------------

--
-- Structure de la table `clients`
--

CREATE TABLE `clients` (
  `id` int(11) NOT NULL,
  `nom` varchar(5000) NOT NULL,
  `prenom` varchar(5000) NOT NULL,
  `adresse` varchar(5000) NOT NULL,
  `telephone` varchar(14) NOT NULL,
  `date_naissance` date NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `clients`
--

INSERT INTO `clients` (`id`, `nom`, `prenom`, `adresse`, `telephone`, `date_naissance`) VALUES
(4, 'Martin', 'Jacques', '6 rue de rennes', '06-06-06-06-06', '1995-01-01'),
(3, 'L animal', 'Boris', '6 rue de nantes', '06-37-43-27-64', '1995-01-01'),
(2, 'Of stell', 'man', '6 bd de luthor', '06-05-04-03-02', '1995-01-02'),
(1, 'Super', 'man', 'avenue de Krypton', '06-06-06-06-06', '2014-05-01'),
(5, 'Dark', 'Vador', '5 rue de l étoile noir', '06-07-08-09-10', '1995-01-01'),
(6, 'Super', 'man', 'avenue de Krypton', '06-06-06-06-06', '2014-05-01'),
(7, 'AAAAAA', 'man', '6 bd de luthor', '06-05-04-03-02', '1995-01-02'),
(8, 'BBBBBB', 'Boris', '6 rue de nantes', '06-37-43-27-64', '1995-01-01'),
(9, 'CCCCCC', 'Jacques', '6 rue de rennes', '06-06-06-06-06', '1995-01-01'),
(10, 'DDDDD', 'Vador', '5 rue de l étoile noir', '06-07-08-09-10', '1995-01-01');

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` int(11) NOT NULL,
  `numero_commande` varchar(5000) NOT NULL,
  `date_commande` date NOT NULL,
  `client_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande`
--

INSERT INTO `commande` (`id`, `numero_commande`, `date_commande`, `client_id`) VALUES
(1, '1', '2016-12-04', 1),
(2, '2', '2016-12-05', 5);

-- --------------------------------------------------------

--
-- Structure de la table `commande_pizza`
--

CREATE TABLE `commande_pizza` (
  `commande_id` int(11) NOT NULL,
  `pizza_id` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `commande_pizza`
--

INSERT INTO `commande_pizza` (`commande_id`, `pizza_id`, `quantite`) VALUES
(1, 1, 2),
(2, 3, 15);

-- --------------------------------------------------------

--
-- Structure de la table `livreurs`
--

CREATE TABLE `livreurs` (
  `id` int(11) NOT NULL,
  `nom` varchar(5000) NOT NULL,
  `prenom` varchar(5000) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `livreurs`
--

INSERT INTO `livreurs` (`id`, `nom`, `prenom`) VALUES
(1, 'Mr', 'ROBOT'),
(2, 'Mr', 'ROBOT'),
(3, 'Mr', 'ROBOT2'),
(4, 'Mr', 'ROBOT3');

-- --------------------------------------------------------

--
-- Structure de la table `pizzas`
--

CREATE TABLE `pizzas` (
  `id` int(11) NOT NULL,
  `libelle` varchar(50) NOT NULL,
  `reference` varchar(50) NOT NULL,
  `prix` double NOT NULL,
  `url_image` varchar(5000) NOT NULL
  `categorie` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Contenu de la table `pizzas`
--

INSERT INTO `pizzas` (`id`, `libelle`, `reference`, `prix`, `url_image`,`categorie`) VALUES
(1, 'Oriental', 'ORI', 14.5, '/','VIANDE'),
(2, 'Oriental', 'ORI', 14.5, '/','VIANDE'),
(3, '4 Formages', 'FRO', 12.5, '/','VIANDE'),
(4, 'Cannibale', 'CAN', 13.5, '/','VIANDE'),
(5, 'Oriental', 'ORI', 14.5, '/','VIANDE');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `commande_pizza`
--
ALTER TABLE `commande_pizza`
  ADD PRIMARY KEY (`commande_id`,`pizza_id`);

--
-- Index pour la table `livreurs`
--
ALTER TABLE `livreurs`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pizzas`
--
ALTER TABLE `pizzas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `commande_pizza`
--
ALTER TABLE `commande_pizza`
  MODIFY `commande_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `livreurs`
--
ALTER TABLE `livreurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `pizzas`
--
ALTER TABLE `pizzas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
