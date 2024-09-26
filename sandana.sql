-- Base de datos: `sandana`
--
CREATE DATABASE IF NOT EXISTS `sandana` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `sandana`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articles`
--

CREATE TABLE `articles` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `stok` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `articles`
--

INSERT INTO `articles` (`id`, `description`, `model`, `size`, `color`, `stock`, `stok`) VALUES
(1, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(2, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(3, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(4, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(5, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(6, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(7, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(8, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(9, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(10, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(11, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(12, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL),
(13, 'asdasda', 'asd', 'asd', 'asd', 'asd', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `media`
--

CREATE TABLE `media` (
  `id` bigint(20) NOT NULL,
  `source` varchar(255) DEFAULT NULL,
  `id-article` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `media`
--

INSERT INTO `media` (`id`, `source`, `id-article`) VALUES
(1, 'string', 1),
(2, 'string', 1),
(3, 'string', 1),
(4, 'string', 1),
(5, 'string', 1),
(6, 'string', 1),
(7, 'string', 1),
(8, 'string', 1),
(9, 'string', 1),
(10, 'string', 1),
(11, 'string', 1),
(12, 'string', 1),
(13, 'string', 1),
(14, 'string', 1),
(15, 'string', 1),
(16, 'string', 1),
(17, 'string', 1),
(18, 'string', 1),
(19, 'string', 1),
(20, 'string', 1),
(21, 'string', 1),
(22, 'string', 1),
(23, 'string', 1),
(24, 'string', 1),
(25, 'string', 1),
(26, 'string', 1),
(27, 'string', 1),
(28, 'string', 1),
(29, 'string', 1),
(30, 'string', 1),
(31, 'string', 1),
(32, 'string', 1),
(33, 'string', 1),
(34, 'string', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `email` varchar(255) NOT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`email`, `passwd`, `rol`) VALUES
('a2@a.com', '1234', 'employe'),
('a3@a.com', '1234', 'employe'),
('a4@a.com', '1234', 'employe'),
('a@a.com', '1234', 'employe'),
('string', 'string', 'string');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articles`
--
ALTER TABLE `articles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articles`
--
ALTER TABLE `articles`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `media`
--
ALTER TABLE `media`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;
--