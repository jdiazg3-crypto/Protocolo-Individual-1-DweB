CREATE DATABASE IF NOT EXISTS gestion_futbol;
USE gestion_futbol;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    clave VARCHAR(100) NOT NULL,
    rol VARCHAR(50) NOT NULL
);

CREATE TABLE equipo_futbol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    eslogan VARCHAR(200),
    tecnico VARCHAR(100),
    pais VARCHAR(100),
    ciudad VARCHAR(100),
    categoria VARCHAR(50),
    numGoles INT DEFAULT 0,
    numPartidosJugados INT DEFAULT 0,
    numPartidosGanados INT DEFAULT 0,
    numCampeonatos INT DEFAULT 0,
    numExpulsiones INT DEFAULT 0,
    numEmpates INT DEFAULT 0
);

-- Datos iniciales
INSERT INTO usuario (nombre, clave, rol) VALUES ('admin', 'admin123', 'ADMINISTRADOR');
INSERT INTO equipo_futbol (nombre, eslogan, tecnico, pais, ciudad, categoria, numGoles, numPartidosJugados, numPartidosGanados, numCampeonatos, numExpulsiones, numEmpates) 
VALUES ('Real Madrid', 'Hasta el final', 'Carlo Ancelotti', 'España', 'Madrid', 'Primera', 100, 38, 29, 36, 2, 5);
