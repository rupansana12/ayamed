-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Out-2020 às 11:21
-- Versão do servidor: 10.4.13-MariaDB
-- versão do PHP: 7.2.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `ayamed`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `analise`
--

CREATE TABLE `analise` (
  `id` int(11) NOT NULL,
  `designacao` varchar(150) NOT NULL,
  `tipo_analise_id` int(11) NOT NULL,
  `instituicao_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `categoria`
--

INSERT INTO `categoria` (`id`, `nome`) VALUES
(1, 'Médico(a)');

-- --------------------------------------------------------

--
-- Estrutura da tabela `especializacao`
--

CREATE TABLE `especializacao` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `especializacao`
--

INSERT INTO `especializacao` (`id`, `nome`) VALUES
(1, 'Medicina Interna'),
(2, 'Cardiologia'),
(3, 'Neurologia'),
(4, 'Reumatologia'),
(5, 'Nefrologia'),
(6, 'Gastroenterologista'),
(7, 'Imagiologista'),
(8, 'Dermatologia'),
(9, 'Cuidados intensivos'),
(10, 'Oncologia'),
(11, 'Medicina Legal'),
(12, 'Infecciologia'),
(13, 'Pediatria'),
(14, 'Neuropediatra'),
(15, 'Neonatologista'),
(16, 'Otorrinolaringologia'),
(17, 'Nefrologia'),
(18, 'Neurologia'),
(19, 'Ginecologia'),
(20, 'Medicina Geral e Familiar'),
(21, 'Ortopedia'),
(22, 'Urologia'),
(23, 'ORL'),
(24, 'Cirurgia Geral');

-- --------------------------------------------------------

--
-- Estrutura da tabela `exame`
--

CREATE TABLE `exame` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `especialidade_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `exame`
--

INSERT INTO `exame` (`id`, `nome`, `especialidade_id`) VALUES
(1, 'Cardiologia', 2),
(2, 'Medicina Nuclear', 1),
(3, 'Radiologia', 1),
(4, 'Urologia', 22),
(5, 'Neurofisiologia', NULL),
(6, 'Radiologia', NULL),
(7, 'EEG', NULL),
(8, 'ORL', 23);

-- --------------------------------------------------------

--
-- Estrutura da tabela `instituicao`
--

CREATE TABLE `instituicao` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `instituicao`
--

INSERT INTO `instituicao` (`id`, `nome`) VALUES
(1, 'AYA MEDICAL SOLUTIONS LDA'),
(2, 'EMPRESA MOÇAMBICANA DE SEGUROS, SA'),
(3, 'SEGURADORA INTERNACIONAL DE MOÇAMBIQUE, SA'),
(4, 'GLOBAL ALLIANCE SEGUROS, SA'),
(5, 'SANLAM MOÇAMBIQUE VIDA  COMPANHIA DE SEGUROS, SA'),
(6, 'TRANQUILIDADE MOÇAMBIQUE COMPANHIA DE SEGUROS, SA'),
(7, 'TRANQUILIDADE VIDA MOÇAMBIQUE COMPANHIA DE SEGUROS, SA'),
(8, 'FIDELIDADE VIDA COMPANHIA DE SEGUROS SA'),
(9, 'MEDIPLUS COMPANHIA DE SEGUROS, SA');

-- --------------------------------------------------------

--
-- Estrutura da tabela `marcar_consulta`
--

CREATE TABLE `marcar_consulta` (
  `id` int(11) NOT NULL,
  `especialidade_id` int(11) NOT NULL,
  `medico_id` int(11) NOT NULL,
  `nome_cliente` varchar(200) NOT NULL,
  `contacto_cliente` varchar(200) NOT NULL,
  `email_cliente` varchar(200) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `marcar_exame`
--

CREATE TABLE `marcar_exame` (
  `id` int(11) NOT NULL,
  `exame_id` int(11) DEFAULT NULL,
  `nome_cliente` varchar(150) NOT NULL,
  `contacto_cliente` varchar(200) NOT NULL,
  `email_cliente` varchar(200) NOT NULL,
  `data` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `marcar_hemodialise`
--

CREATE TABLE `marcar_hemodialise` (
  `id` int(11) NOT NULL,
  `nome_cliente` varchar(200) NOT NULL,
  `contacto_cliente` varchar(200) NOT NULL,
  `email_cliente` varchar(200) NOT NULL,
  `data` date NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL,
  `titulo` varchar(150) DEFAULT NULL,
  `sexo` varchar(100) DEFAULT NULL,
  `aplicacao` varchar(150) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `perfil_id` int(11) DEFAULT NULL,
  `especialidade_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`id`, `nome`, `titulo`, `sexo`, `aplicacao`, `categoria_id`, `perfil_id`, `especialidade_id`) VALUES
(1, 'Abdul Hamid Mussa', 'Dr.', 'Masculino', 'Teste', 1, 1, 22),
(2, 'Mahomed Dadá', 'Dr.', 'Masculino', 'Ambulatório', 1, 1, 16),
(3, 'Jeronimo Mufume', 'Dr.', 'Masculino', 'Ambulatório', 1, 2, 16),
(4, 'Vitoria Branco Neves', 'Prof.', 'Femenino', 'Ambulatório', 1, 2, 16),
(5, 'Awa Carimo', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, NULL),
(6, 'Milton Tatia', 'Dr.', 'Masculino', 'Ambulatório', 1, 2, NULL),
(7, 'Emilio', 'Dr.', 'Masculino', 'Ambulatório', 1, 2, NULL),
(8, 'Natacha Gemo', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 24),
(9, 'Atilio Morais', 'Dr.', 'Femenino', 'Ambulatório', 1, 2, NULL),
(10, 'Elsa', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 17),
(11, 'Glennys', 'Dra.', 'Femenina', 'Ambulatório', 1, 2, 18),
(12, 'Asha Alam', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 18),
(13, 'Elena Sotnikova', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 3),
(14, 'Ambulatório', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, NULL),
(15, 'Orlando Alvarez', 'Dr.', 'Masculino', 'Ambulatório', 1, 2, 19),
(16, 'Cristina Garcia', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 19),
(17, 'Nurja Majeed', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, NULL),
(18, 'Joyce Ventura Monteiro', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 13),
(19, 'Leila Monteiro', 'Dra.', 'Femenino', 'Ambulatório', 1, 2, 13),
(20, 'Barnabe', 'Dr.', 'Masculino', NULL, 1, 2, 21),
(21, 'Eunice Francisco', 'Dra.', 'Femenino', NULL, 1, 2, 20),
(22, 'Archa Hassane', 'Dra.', 'Femenino', NULL, 1, 2, 20),
(23, 'Marwa', 'Dra.', 'Femenino', NULL, 1, 2, 20);

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

CREATE TABLE `perfil` (
  `id` int(11) NOT NULL,
  `nome` varchar(150) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `perfil`
--

INSERT INTO `perfil` (`id`, `nome`) VALUES
(1, 'Coordenador(a) clínico(a)'),
(2, 'Médico(a)');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo_analise`
--

CREATE TABLE `tipo_analise` (
  `id` int(11) NOT NULL,
  `descricao` varchar(150) DEFAULT NULL,
  `especializacao_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `analise`
--
ALTER TABLE `analise`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `especializacao`
--
ALTER TABLE `especializacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `exame`
--
ALTER TABLE `exame`
  ADD PRIMARY KEY (`id`),
  ADD KEY `exame_especializacao_fk` (`especialidade_id`);

--
-- Índices para tabela `instituicao`
--
ALTER TABLE `instituicao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `marcar_consulta`
--
ALTER TABLE `marcar_consulta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `marcar_consulta_especializacao_fk` (`especialidade_id`),
  ADD KEY `marcar_consulta_medico_fk` (`medico_id`);

--
-- Índices para tabela `marcar_exame`
--
ALTER TABLE `marcar_exame`
  ADD PRIMARY KEY (`id`),
  ADD KEY `marcar_exame_exame_fk` (`exame_id`);

--
-- Índices para tabela `marcar_hemodialise`
--
ALTER TABLE `marcar_hemodialise`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `profissicional_especializacao_fk` (`especialidade_id`),
  ADD KEY `profissicional_perfil_fk` (`perfil_id`),
  ADD KEY `profissicional_categoria_fk` (`categoria_id`);

--
-- Índices para tabela `perfil`
--
ALTER TABLE `perfil`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tipo_analise`
--
ALTER TABLE `tipo_analise`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo_analise_fk` (`especializacao_id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `analise`
--
ALTER TABLE `analise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `especializacao`
--
ALTER TABLE `especializacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT de tabela `exame`
--
ALTER TABLE `exame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `instituicao`
--
ALTER TABLE `instituicao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `marcar_consulta`
--
ALTER TABLE `marcar_consulta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `marcar_exame`
--
ALTER TABLE `marcar_exame`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `marcar_hemodialise`
--
ALTER TABLE `marcar_hemodialise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `medico`
--
ALTER TABLE `medico`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de tabela `perfil`
--
ALTER TABLE `perfil`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tipo_analise`
--
ALTER TABLE `tipo_analise`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restrições para despejos de tabelas
--

--
-- Limitadores para a tabela `exame`
--
ALTER TABLE `exame`
  ADD CONSTRAINT `exame_especializacao_fk` FOREIGN KEY (`especialidade_id`) REFERENCES `especializacao` (`id`);

--
-- Limitadores para a tabela `marcar_consulta`
--
ALTER TABLE `marcar_consulta`
  ADD CONSTRAINT `marcar_consulta_especializacao_fk` FOREIGN KEY (`especialidade_id`) REFERENCES `especializacao` (`id`),
  ADD CONSTRAINT `marcar_consulta_medico_fk` FOREIGN KEY (`medico_id`) REFERENCES `medico` (`id`);

--
-- Limitadores para a tabela `marcar_exame`
--
ALTER TABLE `marcar_exame`
  ADD CONSTRAINT `marcar_exame_exame_fk` FOREIGN KEY (`exame_id`) REFERENCES `exame` (`id`);

--
-- Limitadores para a tabela `medico`
--
ALTER TABLE `medico`
  ADD CONSTRAINT `profissicional_categoria_fk` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `profissicional_especializacao_fk` FOREIGN KEY (`especialidade_id`) REFERENCES `especializacao` (`id`),
  ADD CONSTRAINT `profissicional_perfil_fk` FOREIGN KEY (`perfil_id`) REFERENCES `perfil` (`id`);

--
-- Limitadores para a tabela `tipo_analise`
--
ALTER TABLE `tipo_analise`
  ADD CONSTRAINT `tipo_analise_fk` FOREIGN KEY (`especializacao_id`) REFERENCES `especializacao` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
