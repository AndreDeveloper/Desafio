-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.7.11-log - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para desafio
CREATE DATABASE IF NOT EXISTS `desafio` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `desafio`;


-- Copiando estrutura para tabela desafio.mercadoria
CREATE TABLE IF NOT EXISTS `mercadoria` (
  `codigo` int(11) NOT NULL,
  `tipo_mercadoria` varchar(50) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco` double NOT NULL,
  `tipo_negocio` varchar(50) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela desafio.mercadoria: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `mercadoria` DISABLE KEYS */;
INSERT INTO `mercadoria` (`codigo`, `tipo_mercadoria`, `nome`, `quantidade`, `preco`, `tipo_negocio`) VALUES
	(1, 'eletrodomestico', 'televisor sansung', 30, 2000, 'Venda'),
	(2, 'tecnologico', 'smartfone lg', 100, 500, 'Venda'),
	(3, 'utilitario', 'mesa de passar roupa', 1, 30, 'Compra'),
	(4, 'escritorio', 'impressora', 1, 1, 'Compra'),
	(5, 'livro', 'java 8', 5, 70, 'Compra');
/*!40000 ALTER TABLE `mercadoria` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
