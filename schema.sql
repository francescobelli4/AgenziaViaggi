/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database agenzia_viaggi
DROP DATABASE IF EXISTS `agenzia_viaggi`;
CREATE DATABASE IF NOT EXISTS `agenzia_viaggi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agenzia_viaggi`;

-- Dump della struttura di tabella agenzia_viaggi.albergo
DROP TABLE IF EXISTS `albergo`;
CREATE TABLE IF NOT EXISTS `albergo` (
                                         `Nome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Indirizzo` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Città` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Costo` int DEFAULT NULL,
                                         `Capienza` int DEFAULT NULL,
                                         `Referente` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Email` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Telefono` varchar(14) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Fax` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         PRIMARY KEY (`Nome`,`Città`,`Indirizzo`),
                                         KEY `Città` (`Città`),
                                         KEY `fk_albergo_referente` (`Referente`),
                                         CONSTRAINT `albergo_ibfk_1` FOREIGN KEY (`Città`) REFERENCES `tappa` (`Nome`) ON DELETE CASCADE,
                                         CONSTRAINT `fk_albergo_referente` FOREIGN KEY (`Referente`) REFERENCES `referente` (`CF`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.albergo: ~14 rows (circa)
INSERT INTO `albergo` (`Nome`, `Indirizzo`, `Città`, `Costo`, `Capienza`, `Referente`, `Email`, `Telefono`, `Fax`) VALUES
                                                                                                                       ('B&B Colosseum', 'Via dei Fori 10', 'Roma', 38, 15, 'BNCGNN85B02F205Z', 'colosseum@gmail.com', '067654321', NULL),
                                                                                                                       ('B&B Partenope', 'Via Chiaia 5', 'Napoli', 36, 20, 'ESPLGI92C03L219E', 'partenope@gmail.com', '081654321', NULL),
                                                                                                                       ('Bari Levante', 'Corso Cavour 15', 'Bari', 38, 20, 'VRDLGI90C03L219X', 'bari@albergo.it', '080123456', NULL),
                                                                                                                       ('Hotel Firenze Arno', 'Lungarno 5', 'Firenze', 42, 20, 'VRDLGI90C03L219X', 'arno@hotel.it', '055123456', NULL),
                                                                                                                       ('Hotel Roma Centrale', 'Via Nazionale 1', 'Roma', 45, 25, 'RSSMRA80A01H501A', 'info@romacentrale.it', '061234567', NULL),
                                                                                                                       ('Locanda San Marco', 'Piazza San Marco 2', 'Venezia', 44, 15, 'RROMRA82A01H501C', 'marco@locanda.it', '041654321', NULL),
                                                                                                                       ('Milano Business', 'Via Montenapoleone 1', 'Milano', 50, 25, 'BCKGNN78D04H501F', 'info@milanobusiness.it', '021234567', NULL),
                                                                                                                       ('Napoli Vesuvio Sky', 'Via Toledo 50', 'Napoli', 39, 30, 'FERSRA88B02F205D', 'vesuvio@napoli.it', '081123456', NULL),
                                                                                                                       ('Palermo Sole', 'Via Roma 100', 'Palermo', 35, 30, 'BNCGNN85B02F205Z', 'sole@palermo.it', '091123456', NULL),
                                                                                                                       ('Pensione Dante', 'Via Ghibellina 12', 'Firenze', 35, 18, 'GLLFNC75D04H501Q', 'dante@firenze.it', '055654321', NULL),
                                                                                                                       ('Siena Medievale', 'Via di Città 20', 'Siena', 40, 18, 'COLMRA72E05F205G', 'siena@albergo.it', '0577123456', NULL),
                                                                                                                       ('Torino Reale', 'Via Po 3', 'Torino', 44, 25, 'GLLFNC75D04H501Q', 'reale@torino.it', '011123456', NULL),
                                                                                                                       ('Venice Lagoon Hotel', 'Calle larga 101', 'Venezia', 48, 22, 'NERANT70E05F205B', 'info@venicelagoon.it', '041123456', NULL),
                                                                                                                       ('Verona Love Hotel', 'Via Stella 4', 'Verona', 43, 22, 'RSSMRA80A01H501A', 'info@veronalove.it', '045123456', NULL);

-- Dump della struttura di tabella agenzia_viaggi.autobus
DROP TABLE IF EXISTS `autobus`;
CREATE TABLE IF NOT EXISTS `autobus` (
                                         `Targa` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Capienza` int DEFAULT NULL,
                                         `Costo` int DEFAULT NULL,
                                         PRIMARY KEY (`Targa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.autobus: ~10 rows (circa)
INSERT INTO `autobus` (`Targa`, `Capienza`, `Costo`) VALUES
                                                         ('AA123BB', 50, 100),
                                                         ('BB234CC', 45, 95),
                                                         ('CC345DD', 55, 110),
                                                         ('DD456EE', 30, 80),
                                                         ('EE567FF', 50, 100),
                                                         ('FF678GG', 40, 90),
                                                         ('GG789HH', 60, 120),
                                                         ('HH890II', 50, 100),
                                                         ('II901JJ', 45, 95),
                                                         ('JJ012KK', 50, 100);

-- Dump della struttura di tabella agenzia_viaggi.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
                                         `CF` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Nome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Cognome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         PRIMARY KEY (`CF`),
                                         KEY `cliente_nominativo` (`Cognome`,`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.cliente: ~11 rows (circa)
INSERT INTO `cliente` (`CF`, `Nome`, `Cognome`) VALUES
                                                    ('BRNGRD90A01H501Q', 'Riccardo', 'Bruno'),
                                                    ('CRSRSO86I09L219Y', 'Rosa', 'Caruso'),
                                                    ('DLUFNC75F06L219V', 'Francesco', 'De Luca'),
                                                    ('GRSSTF82M11F205K', 'Stefania', 'Grassi'),
                                                    ('GTTBCP88D04H501T', 'Beatrice', 'Gatti'),
                                                    ('MNCEMA85C03L219S', 'Emanuele', 'Mancini'),
                                                    ('MRTMRA84H08F205X', 'Marco', 'Martini'),
                                                    ('PLMGNN80L10H501Z', 'Giovanni', 'Palumbo'),
                                                    ('RSSSRA90E05F205U', 'Sara', 'Rizzo'),
                                                    ('SNTLRA82G07H501W', 'Laura', 'Santoro'),
                                                    ('VLLVAL92B02F205R', 'Valeria', 'Villa');

-- Dump della struttura di tabella agenzia_viaggi.compone
DROP TABLE IF EXISTS `compone`;
CREATE TABLE IF NOT EXISTS `compone` (
                                         `Itinerario` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Ordine` int NOT NULL,
                                         `Tappa` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         PRIMARY KEY (`Itinerario`,`Ordine`),
                                         KEY `Tappa` (`Tappa`),
                                         CONSTRAINT `compone_ibfk_1` FOREIGN KEY (`Itinerario`) REFERENCES `itinerario` (`Nome`) ON DELETE CASCADE,
                                         CONSTRAINT `compone_ibfk_2` FOREIGN KEY (`Tappa`) REFERENCES `tappa` (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.compone: ~26 rows (circa)
INSERT INTO `compone` (`Itinerario`, `Ordine`, `Tappa`) VALUES
                                                            ('Capitali del Nord e Sud', 0, 'Torino'),
                                                            ('Capitali del Nord e Sud', 1, 'Mole Antonelliana'),
                                                            ('Capitali del Nord e Sud', 2, 'Milano'),
                                                            ('Capitali del Nord e Sud', 3, 'Duomo Milano'),
                                                            ('Capitali del Nord e Sud', 4, 'Napoli'),
                                                            ('Gran Tour d Italia', 0, 'Venezia'),
                                                            ('Gran Tour d Italia', 1, 'Piazza San Marco'),
                                                            ('Gran Tour d Italia', 2, 'Verona'),
                                                            ('Gran Tour d Italia', 3, 'Arena di Verona'),
                                                            ('Gran Tour d Italia', 4, 'Siena'),
                                                            ('Gran Tour d Italia', 5, 'Piazza del Campo'),
                                                            ('Gran Tour d Italia', 6, 'Firenze'),
                                                            ('Gran Tour d Italia', 7, 'Roma'),
                                                            ('Rotta del Sole', 0, 'Napoli'),
                                                            ('Rotta del Sole', 1, 'Pompei'),
                                                            ('Rotta del Sole', 2, 'Bari'),
                                                            ('Rotta del Sole', 3, 'Grotte di Castellana'),
                                                            ('Rotta del Sole', 4, 'Palermo'),
                                                            ('Rotta del Sole', 5, 'Valle dei Templi'),
                                                            ('Tour Arte e Storia', 0, 'Roma'),
                                                            ('Tour Arte e Storia', 1, 'Colosseo'),
                                                            ('Tour Arte e Storia', 2, 'Firenze'),
                                                            ('Tour Arte e Storia', 3, 'Uffizi'),
                                                            ('Tour Arte e Storia', 4, 'Roma'),
                                                            ('Tour Arte e Storia', 5, 'Napoli'),
                                                            ('Tour Arte e Storia', 6, 'Pompei');

-- Dump della struttura di procedura agenzia_viaggi.DisdiciPrenotazione
DROP PROCEDURE IF EXISTS `DisdiciPrenotazione`;
DELIMITER //
CREATE PROCEDURE `DisdiciPrenotazione`(IN var_codice_disdetta varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;

    SELECT 1 INTO var_exists FROM partecipa WHERE partecipa.CodiceDisdetta = var_codice_disdetta LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: codice disdetta non valido.';
    end if;

    DELETE FROM partecipa WHERE partecipa.CodiceDisdetta = var_codice_disdetta;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.EliminaAlbergo
DROP PROCEDURE IF EXISTS `EliminaAlbergo`;
DELIMITER //
CREATE PROCEDURE `EliminaAlbergo`(IN var_nome VARCHAR(64), IN var_citta VARCHAR(64), IN var_indirizzo VARCHAR(64))
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    DELETE FROM albergo WHERE Nome = var_nome AND Città = var_citta AND Indirizzo = var_indirizzo;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.EliminaAutobus
DROP PROCEDURE IF EXISTS `EliminaAutobus`;
DELIMITER //
CREATE PROCEDURE `EliminaAutobus`(IN var_targa VARCHAR(7))
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    DELETE FROM autobus WHERE Targa = var_targa;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.EliminaItinerario
DROP PROCEDURE IF EXISTS `EliminaItinerario`;
DELIMITER //
CREATE PROCEDURE `EliminaItinerario`(IN var_nome varchar(64))
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    DELETE FROM itinerario WHERE Nome = var_nome;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.EliminaTappa
DROP PROCEDURE IF EXISTS `EliminaTappa`;
DELIMITER //
CREATE PROCEDURE `EliminaTappa`(IN var_nome varchar(64))
BEGIN
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    DELETE FROM tappa WHERE Nome = var_nome;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.EliminaViaggio
DROP PROCEDURE IF EXISTS `EliminaViaggio`;
DELIMITER //
CREATE PROCEDURE `EliminaViaggio`(IN var_codice varchar(64))
BEGIN

    DECLARE var_data_partenza DATE;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    SELECT Partenza FROM viaggio WHERE Codice = var_codice;

    IF DATEDIFF(var_data_partenza, CURDATE()) < 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Non è possibile eliminare un viaggio passato!';
    END IF;

    DELETE FROM viaggio WHERE Codice = var_codice;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.GeneraReport
DROP PROCEDURE IF EXISTS `GeneraReport`;
DELIMITER //
CREATE PROCEDURE `GeneraReport`()
BEGIN


    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;

    SELECT * FROM report_guadagno_viaggi JOIN viaggio ON Codice = CodiceViaggio WHERE Partenza <= CURDATE();
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di tabella agenzia_viaggi.itinerario
DROP TABLE IF EXISTS `itinerario`;
CREATE TABLE IF NOT EXISTS `itinerario` (
                                            `Nome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                            `Costo` int DEFAULT NULL,
                                            PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.itinerario: ~4 rows (circa)
INSERT INTO `itinerario` (`Nome`, `Costo`) VALUES
                                               ('Capitali del Nord e Sud', 1200),
                                               ('Gran Tour d Italia', 1500),
                                               ('Rotta del Sole', 950),
                                               ('Tour Arte e Storia', 1100);

-- Dump della struttura di procedura agenzia_viaggi.ListaAlberghi
DROP PROCEDURE IF EXISTS `ListaAlberghi`;
DELIMITER //
CREATE PROCEDURE `ListaAlberghi`()
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    SELECT albergo.Nome as NomeAlbergo, Indirizzo, Città, Costo, Capienza, Email, Telefono, Fax, CF as CFReferente, referente.Nome as NomeReferente, Cognome as CognomeReferente  FROM albergo JOIN referente ON albergo.Referente = referente.CF ORDER BY Città;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaAlberghiPerCitta
DROP PROCEDURE IF EXISTS `ListaAlberghiPerCitta`;
DELIMITER //
CREATE PROCEDURE `ListaAlberghiPerCitta`(IN var_citta varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;
    DECLARE var_tipo ENUM('Citta', 'Luogo');

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;

    SELECT Tipo, 1 INTO var_tipo, var_exists FROM tappa WHERE Nome = var_citta LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Città non trovata.';
    ELSEIF var_tipo = 'Luogo' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: La tappa inserita non è una città.';
    END IF;

    SELECT a.Nome as NomeAlbergo, Indirizzo, Città, Costo, Capienza, Email, Telefono, Fax, CF as CFReferente, r.Nome as NomeReferente, Cognome as CognomeReferente FROM albergo a JOIN referente r ON a.Referente = r.CF WHERE a.Città = var_citta;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaAutobus
DROP PROCEDURE IF EXISTS `ListaAutobus`;
DELIMITER //
CREATE PROCEDURE `ListaAutobus`()
BEGIN

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    SELECT * FROM autobus;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaAutobusPerViaggio
DROP PROCEDURE IF EXISTS `ListaAutobusPerViaggio`;
DELIMITER //
CREATE PROCEDURE `ListaAutobusPerViaggio`(IN var_codice_viaggio varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;

    SELECT 1 INTO var_exists FROM viaggio WHERE Codice = var_codice_viaggio LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Viaggio non trovato.';
    END IF;

    SELECT u.Autobus, a.Costo, a.Capienza FROM viaggio v JOIN usa u ON v.Codice = u.Viaggio JOIN autobus a on u.Autobus = a.Targa WHERE v.Codice = var_codice_viaggio;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaClienti
DROP PROCEDURE IF EXISTS `ListaClienti`;
DELIMITER //
CREATE PROCEDURE `ListaClienti`()
BEGIN
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;
    SELECT * FROM cliente ORDER BY Nome,Cognome;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaItinerari
DROP PROCEDURE IF EXISTS `ListaItinerari`;
DELIMITER //
CREATE PROCEDURE `ListaItinerari`()
BEGIN
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;
    SELECT * FROM itinerario ;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaPernottamentiPerViaggio
DROP PROCEDURE IF EXISTS `ListaPernottamentiPerViaggio`;
DELIMITER //
CREATE PROCEDURE `ListaPernottamentiPerViaggio`(IN var_codice_viaggio varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;

    SELECT 1 INTO var_exists FROM viaggio WHERE Codice = var_codice_viaggio LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Viaggio non trovato.';
    END IF;

    SELECT p.NomeAlbergo, p.CittàAlbergo, p.IndirizzoAlbergo, p.Ordine FROM viaggio v JOIN pernottamento p ON v.Codice = p.Viaggio JOIN albergo a ON p.NomeAlbergo = a.Nome and p.CittàAlbergo = a.Città and p.IndirizzoAlbergo = a.Indirizzo WHERE v.Codice = var_codice_viaggio;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaPrenotazioniPerViaggio
DROP PROCEDURE IF EXISTS `ListaPrenotazioniPerViaggio`;
DELIMITER //
CREATE PROCEDURE `ListaPrenotazioniPerViaggio`(IN var_codice_viaggio varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;

    SELECT 1 INTO var_exists FROM viaggio WHERE Codice = var_codice_viaggio LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Viaggio non trovato.';
    END IF;

    SELECT p.Codice as CodicePrenotazione, pa.CodiceDisdetta, pa.Cliente, c.Nome, c.Cognome FROM viaggio v JOIN prenotazione p ON v.Codice = p.Viaggio JOIN partecipa pa ON p.Codice = pa.Prenotazione JOIN cliente c ON pa.Cliente = c.CF WHERE v.Codice = var_codice_viaggio;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaTappe
DROP PROCEDURE IF EXISTS `ListaTappe`;
DELIMITER //
CREATE PROCEDURE `ListaTappe`()
BEGIN
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;
    SELECT * FROM tappa;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaTappePerItinerario
DROP PROCEDURE IF EXISTS `ListaTappePerItinerario`;
DELIMITER //
CREATE PROCEDURE `ListaTappePerItinerario`(IN var_nome VARCHAR(64))
BEGIN

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    SELECT Tappa, Tipo FROM itinerario JOIN compone ON itinerario.Nome = compone.Itinerario JOIN tappa ON compone.Tappa = tappa.Nome WHERE itinerario.Nome = var_nome ORDER BY Ordine;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaViaggi
DROP PROCEDURE IF EXISTS `ListaViaggi`;
DELIMITER //
CREATE PROCEDURE `ListaViaggi`()
BEGIN
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;
    SELECT * FROM viaggio ORDER BY Partenza;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovaPrenotazione
DROP PROCEDURE IF EXISTS `NuovaPrenotazione`;
DELIMITER //
CREATE PROCEDURE `NuovaPrenotazione`(IN var_codice_viaggio varchar(64), IN var_lista_clienti longtext)
BEGIN

    DECLARE cf VARCHAR(16);
    DECLARE nome VARCHAR(64);
    DECLARE cognome VARCHAR(64);
    DECLARE codicePren VARCHAR(64);
    DECLARE numeroClienti INT;
    DECLARE i INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;

    SET codicePren = UUID();
    SET numeroClienti = JSON_LENGTH(var_lista_clienti);

    INSERT INTO prenotazione(Codice, Viaggio) VALUES (codicePren, var_codice_viaggio);

    while i < numeroClienti do

            SET cf = JSON_UNQUOTE(JSON_EXTRACT(var_lista_clienti, CONCAT('$[', i, '].cf')));
            SET nome = JSON_UNQUOTE(JSON_EXTRACT(var_lista_clienti, CONCAT('$[', i, '].nome')));
            SET cognome = JSON_UNQUOTE(JSON_EXTRACT(var_lista_clienti, CONCAT('$[', i, '].cognome')));

            INSERT IGNORE INTO cliente (CF, Nome, Cognome)VALUES (cf, nome, cognome);
            INSERT INTO partecipa (CodiceDisdetta, Prenotazione, Cliente) VALUES (UUID(), codicePren, cf);

            SET i = i + 1;
        end while;

    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovaTappa
DROP PROCEDURE IF EXISTS `NuovaTappa`;
DELIMITER //
CREATE PROCEDURE `NuovaTappa`(IN var_nome_tappa varchar(64),
                              IN var_tipo_tappa enum ('Citta', 'Luogo'))
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;
    INSERT INTO tappa(Nome, Tipo) VALUES (var_nome_tappa, var_tipo_tappa);
    SELECT * FROM tappa WHERE Nome = var_nome_tappa AND Tipo = var_tipo_tappa;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoAlbergo
DROP PROCEDURE IF EXISTS `NuovoAlbergo`;
DELIMITER //
CREATE PROCEDURE `NuovoAlbergo`(IN var_nome_albergo varchar(64),
                                IN var_indirizzo_albergo varchar(64),
                                IN var_citta_albergo varchar(64), IN var_costo_albergo int,
                                IN var_capienza_albergo int, IN var_cf_referente varchar(16),
                                IN var_nome_referente varchar(64),
                                IN var_cognome_referente varchar(64),
                                IN var_email_albergo varchar(64),
                                IN var_telefono_albergo varchar(64), IN var_fax_albergo varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    SELECT 1 INTO var_exists FROM tappa WHERE Nome = var_citta_albergo AND Tipo = 'Città' LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: città non trovata.';
    end if;

    INSERT INTO referente(CF, Nome, Cognome) VALUES (var_cf_referente, var_nome_referente, var_cognome_referente);
    INSERT INTO albergo(Nome, Indirizzo, Città, Costo, Capienza, Referente, Email, Telefono, Fax) VALUES (var_nome_albergo, var_indirizzo_albergo, var_citta_albergo, var_costo_albergo, var_capienza_albergo, var_cf_referente, var_email_albergo, var_telefono_albergo, var_fax_albergo);

    SELECT a.Nome as NomeAlbergo, Indirizzo, Città, Costo, Capienza, Email, Telefono, Fax, CF as CFReferente, r.Nome as NomeReferente, Cognome as CognomeReferente FROM albergo a JOIN referente r ON a.Referente = r.CF WHERE a.Nome = var_nome_albergo AND a.Indirizzo = var_indirizzo_albergo AND a.Città = var_citta_albergo;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoAutobus
DROP PROCEDURE IF EXISTS `NuovoAutobus`;
DELIMITER //
CREATE PROCEDURE `NuovoAutobus`(IN var_targa_autobus varchar(10), IN var_capienza_autobus int,
                                IN var_costo_autobus int)
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;

    INSERT INTO autobus(Targa, Capienza, Costo) VALUES (var_targa_autobus, var_capienza_autobus, var_costo_autobus);
    SELECT * FROM autobus WHERE Targa = var_targa_autobus;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoItinerario
DROP PROCEDURE IF EXISTS `NuovoItinerario`;
DELIMITER //
CREATE PROCEDURE `NuovoItinerario`(IN var_nome_itinerario varchar(64), IN var_costo_viaggio int,
                                   IN var_tappe longtext)
BEGIN

    DECLARE i INT DEFAULT 0;
    DECLARE var_numero_tappe INT;
    DECLARE var_nome_tappa VARCHAR(64);
    DECLARE var_tipo_tappa ENUM('Citta', 'Luogo');
    DECLARE var_exists INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;

    SET var_numero_tappe = JSON_LENGTH(var_tappe);
    IF var_numero_tappe = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Il numero di tappe deve essere maggiore di zero';
    END IF;

    INSERT INTO itinerario(Nome, Costo) VALUES (var_nome_itinerario, var_costo_viaggio);

    while i < var_numero_tappe do

            SET var_exists = 0;
            SET var_nome_tappa = JSON_UNQUOTE(JSON_EXTRACT(var_tappe, CONCAT('$[', i, '].nome')));

            SELECT Tipo, 1 INTO var_tipo_tappa, var_exists FROM tappa WHERE Nome = var_nome_tappa LIMIT 1;
            IF var_exists = 0 THEN
                SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Una delle tappe non esiste!';
            end if;

            if var_tipo_tappa = 'Citta' THEN

                SELECT 1 INTO var_exists FROM albergo WHERE Città = var_nome_tappa LIMIT 1;
                if var_exists = 0 then
                    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Una delle tappe non ha alcun albergo associato!';
                end if;
            END IF;

            INSERT IGNORE INTO compone(Itinerario, Ordine, Tappa) VALUES (var_nome_itinerario, i, var_nome_tappa);

            SET i = i + 1;
        end while;

    SELECT * FROM itinerario WHERE Nome = var_nome_itinerario;

    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoViaggio
DROP PROCEDURE IF EXISTS `NuovoViaggio`;
DELIMITER //
CREATE PROCEDURE `NuovoViaggio`(IN var_nome_itinerario varchar(64), IN var_data_partenza date,
                                IN var_data_ritorno date)
BEGIN

    DECLARE var_codice_viaggio VARCHAR(64);

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;

    SET var_codice_viaggio = UUID();

    INSERT INTO viaggio(Codice, Itinerario, Partenza, Ritorno) VALUES (var_codice_viaggio, var_nome_itinerario, var_data_partenza, var_data_ritorno);
    SELECT * FROM viaggio WHERE Codice = var_codice_viaggio;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di tabella agenzia_viaggi.partecipa
DROP TABLE IF EXISTS `partecipa`;
CREATE TABLE IF NOT EXISTS `partecipa` (
                                           `CodiceDisdetta` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                           `Prenotazione` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                           `Cliente` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                           PRIMARY KEY (`CodiceDisdetta`),
                                           UNIQUE KEY `uq_cliente_prenotazione` (`Prenotazione`,`Cliente`),
                                           KEY `Cliente` (`Cliente`),
                                           CONSTRAINT `partecipa_ibfk_1` FOREIGN KEY (`Prenotazione`) REFERENCES `prenotazione` (`Codice`),
                                           CONSTRAINT `partecipa_ibfk_2` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`CF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.partecipa: ~11 rows (circa)
INSERT INTO `partecipa` (`CodiceDisdetta`, `Prenotazione`, `Cliente`) VALUES
                                                                          ('d8472bf3-fe19-11f0-b010-0250a3bfb7b6', 'd846a0e3-fe19-11f0-b010-0250a3bfb7b6', 'BRNGRD90A01H501Q'),
                                                                          ('d8473f55-fe19-11f0-b010-0250a3bfb7b6', 'd846a0e3-fe19-11f0-b010-0250a3bfb7b6', 'VLLVAL92B02F205R'),
                                                                          ('d849b8c8-fe19-11f0-b010-0250a3bfb7b6', 'd849a2fb-fe19-11f0-b010-0250a3bfb7b6', 'MNCEMA85C03L219S'),
                                                                          ('d84bd9a4-fe19-11f0-b010-0250a3bfb7b6', 'd84bcd66-fe19-11f0-b010-0250a3bfb7b6', 'GTTBCP88D04H501T'),
                                                                          ('d84be254-fe19-11f0-b010-0250a3bfb7b6', 'd84bcd66-fe19-11f0-b010-0250a3bfb7b6', 'RSSSRA90E05F205U'),
                                                                          ('d84d4e9f-fe19-11f0-b010-0250a3bfb7b6', 'd84d4050-fe19-11f0-b010-0250a3bfb7b6', 'DLUFNC75F06L219V'),
                                                                          ('d84f1b6a-fe19-11f0-b010-0250a3bfb7b6', 'd84f0d45-fe19-11f0-b010-0250a3bfb7b6', 'SNTLRA82G07H501W'),
                                                                          ('d84f2420-fe19-11f0-b010-0250a3bfb7b6', 'd84f0d45-fe19-11f0-b010-0250a3bfb7b6', 'MRTMRA84H08F205X'),
                                                                          ('d84f2a1f-fe19-11f0-b010-0250a3bfb7b6', 'd84f0d45-fe19-11f0-b010-0250a3bfb7b6', 'CRSRSO86I09L219Y'),
                                                                          ('d85116ee-fe19-11f0-b010-0250a3bfb7b6', 'd85105ae-fe19-11f0-b010-0250a3bfb7b6', 'PLMGNN80L10H501Z'),
                                                                          ('d8511faa-fe19-11f0-b010-0250a3bfb7b6', 'd85105ae-fe19-11f0-b010-0250a3bfb7b6', 'GRSSTF82M11F205K');

-- Dump della struttura di procedura agenzia_viaggi.PerformLogin
DROP PROCEDURE IF EXISTS `PerformLogin`;
DELIMITER //
CREATE PROCEDURE `PerformLogin`(IN loginUsername varchar(45), IN loginPassword varchar(45),
                                OUT foundRole VARCHAR(16))
BEGIN

    DECLARE userRole ENUM('Amministratore', 'Booking');

    START TRANSACTION;

    SELECT Ruolo INTO foundRole FROM Utenti WHERE Username = loginUsername AND Password = md5(loginPassword);

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di tabella agenzia_viaggi.pernottamento
DROP TABLE IF EXISTS `pernottamento`;
CREATE TABLE IF NOT EXISTS `pernottamento` (
                                               `Viaggio` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `Ordine` int NOT NULL,
                                               `NomeAlbergo` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `IndirizzoAlbergo` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `CittàAlbergo` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                               PRIMARY KEY (`Viaggio`,`Ordine`),
                                               KEY `NomeAlbergo` (`NomeAlbergo`,`CittàAlbergo`,`IndirizzoAlbergo`),
                                               CONSTRAINT `pernottamento_ibfk_1` FOREIGN KEY (`Viaggio`) REFERENCES `viaggio` (`Codice`),
                                               CONSTRAINT `pernottamento_ibfk_2` FOREIGN KEY (`NomeAlbergo`, `CittàAlbergo`, `IndirizzoAlbergo`) REFERENCES `albergo` (`Nome`, `Città`, `Indirizzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.pernottamento: ~7 rows (circa)
INSERT INTO `pernottamento` (`Viaggio`, `Ordine`, `NomeAlbergo`, `IndirizzoAlbergo`, `CittàAlbergo`) VALUES
                                                                                                         ('a46e66dd-fe19-11f0-b010-0250a3bfb7b6', 0, 'B&B Colosseum', 'Via dei Fori 10', 'Roma'),
                                                                                                         ('a46e66dd-fe19-11f0-b010-0250a3bfb7b6', 2, 'Pensione Dante', 'Via Ghibellina 12', 'Firenze'),
                                                                                                         ('a46e66dd-fe19-11f0-b010-0250a3bfb7b6', 4, 'Hotel Roma Centrale', 'Via Nazionale 1', 'Roma'),
                                                                                                         ('a46e66dd-fe19-11f0-b010-0250a3bfb7b6', 5, 'Napoli Vesuvio Sky', 'Via Toledo 50', 'Napoli'),
                                                                                                         ('a47074c0-fe19-11f0-b010-0250a3bfb7b6', 0, 'B&B Partenope', 'Via Chiaia 5', 'Napoli'),
                                                                                                         ('a47074c0-fe19-11f0-b010-0250a3bfb7b6', 2, 'Bari Levante', 'Corso Cavour 15', 'Bari'),
                                                                                                         ('a47074c0-fe19-11f0-b010-0250a3bfb7b6', 4, 'Palermo Sole', 'Via Roma 100', 'Palermo');

-- Dump della struttura di tabella agenzia_viaggi.prenotazione
DROP TABLE IF EXISTS `prenotazione`;
CREATE TABLE IF NOT EXISTS `prenotazione` (
                                              `Codice` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                              `Viaggio` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                              PRIMARY KEY (`Codice`),
                                              KEY `Viaggio` (`Viaggio`),
                                              CONSTRAINT `prenotazione_ibfk_1` FOREIGN KEY (`Viaggio`) REFERENCES `viaggio` (`Codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.prenotazione: ~6 rows (circa)
INSERT INTO `prenotazione` (`Codice`, `Viaggio`) VALUES
                                                     ('d846a0e3-fe19-11f0-b010-0250a3bfb7b6', 'a46e66dd-fe19-11f0-b010-0250a3bfb7b6'),
                                                     ('d849a2fb-fe19-11f0-b010-0250a3bfb7b6', 'a47074c0-fe19-11f0-b010-0250a3bfb7b6'),
                                                     ('d84bcd66-fe19-11f0-b010-0250a3bfb7b6', 'a4726157-fe19-11f0-b010-0250a3bfb7b6'),
                                                     ('d84d4050-fe19-11f0-b010-0250a3bfb7b6', 'a47462b2-fe19-11f0-b010-0250a3bfb7b6'),
                                                     ('d84f0d45-fe19-11f0-b010-0250a3bfb7b6', 'a46e66dd-fe19-11f0-b010-0250a3bfb7b6'),
                                                     ('d85105ae-fe19-11f0-b010-0250a3bfb7b6', 'a47074c0-fe19-11f0-b010-0250a3bfb7b6');

-- Dump della struttura di tabella agenzia_viaggi.referente
DROP TABLE IF EXISTS `referente`;
CREATE TABLE IF NOT EXISTS `referente` (
                                           `CF` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                           `Nome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                           `Cognome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                           PRIMARY KEY (`CF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.referente: ~11 rows (circa)
INSERT INTO `referente` (`CF`, `Nome`, `Cognome`) VALUES
                                                      ('BCKGNN78D04H501F', 'Gianni', 'Bianchi'),
                                                      ('BNCGNN85B02F205Z', 'Giovanni', 'Bianchi'),
                                                      ('COLMRA72E05F205G', 'Marco', 'Colombo'),
                                                      ('ESPLGI92C03L219E', 'Luigi', 'Esposito'),
                                                      ('FERSRA88B02F205D', 'Sara', 'Ferrari'),
                                                      ('GLLFNC75D04H501Q', 'Francesco', 'Gialli'),
                                                      ('NERANT70E05F205B', 'Antonio', 'Neri'),
                                                      ('RROMRA82A01H501C', 'Maria', 'Russo'),
                                                      ('RSSMRA80A01H501A', 'Mario', 'Rossi'),
                                                      ('VRDLGI90C03L219X', 'Luigi', 'Verdi');

-- Dump della struttura di vista agenzia_viaggi.report_guadagno_viaggi
DROP VIEW IF EXISTS `report_guadagno_viaggi`;
-- Creazione di una tabella temporanea per risolvere gli errori di dipendenza della vista
CREATE TABLE `report_guadagno_viaggi` (
                                          `CodiceViaggio` VARCHAR(1) NULL COLLATE 'utf8mb4_unicode_ci',
                                          `NomeItinerario` VARCHAR(1) NOT NULL COLLATE 'utf8mb4_unicode_ci',
                                          `CostoItinerario` INT NULL,
                                          `Guadagno` DECIMAL(54,0) NULL,
                                          `Entrate` BIGINT NULL,
                                          `Uscite` DECIMAL(53,0) NULL,
                                          `UsciteAlberghi` DECIMAL(52,0) NULL,
                                          `UsciteAutobus` DECIMAL(51,0) NULL
);

-- Dump della struttura di procedura agenzia_viaggi.ScegliAlberghi
DROP PROCEDURE IF EXISTS `ScegliAlberghi`;
DELIMITER //
CREATE PROCEDURE `ScegliAlberghi`(IN var_codice_viaggio varchar(64), IN var_lista_alberghi longtext)
BEGIN

    DECLARE i INT DEFAULT 0;
    DECLARE var_numero_alberghi INT DEFAULT 0;
    DECLARE var_nome_albergo VARCHAR(64);
    DECLARE var_indirizzo_albergo VARCHAR(64);
    DECLARE var_citta_albergo VARCHAR(64);
    DECLARE var_ordine_pernottamento INT;
    DECLARE var_numero_citta INT DEFAULT 0;
    DECLARE var_nome_itinerario VARCHAR(64);

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    -- Considerando il tipo di dati che leggo (nel trigger), è ragionevole usare READ COMMITTED: ad esempio
    -- dati come viaggio.dataPartenza è estremamente improbabile che vengano modificati, così come è
    -- estremamente improbabile che le tappe di un itinerario su cui abbiamo programmato il viaggio cambino...
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION;

    DELETE FROM pernottamento WHERE Viaggio = var_codice_viaggio;

    SELECT Itinerario INTO var_nome_itinerario FROM viaggio WHERE Codice = var_codice_viaggio;
    SELECT COUNT(*) INTO var_numero_citta FROM compone JOIN tappa ON compone.Tappa = tappa.Nome WHERE Itinerario = var_nome_itinerario AND Tipo = 'Citta';

    SET var_numero_alberghi = JSON_LENGTH(var_lista_alberghi);
    IF var_numero_citta != var_numero_alberghi THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: il numero di citta non corrisponde al numero di alberghi selezionati.';
    end if;

    while i < var_numero_alberghi do

            SET var_nome_albergo = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].albergo.nome')));
            SET var_citta_albergo = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].albergo.citta')));
            SET var_indirizzo_albergo = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].albergo.indirizzo')));
            SET var_ordine_pernottamento = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].ordine')));

            -- Le regole aziendali vengono implementate dal trigger su pernottamento.
            INSERT INTO pernottamento(Viaggio, Ordine, NomeAlbergo, IndirizzoAlbergo, CittàAlbergo) VALUES (var_codice_viaggio, var_ordine_pernottamento, var_nome_albergo, var_indirizzo_albergo, var_citta_albergo);

            SET i = i + 1;
        end while;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ScegliAutobus
DROP PROCEDURE IF EXISTS `ScegliAutobus`;
DELIMITER //
CREATE PROCEDURE `ScegliAutobus`(IN var_codice_viaggio varchar(64), IN var_lista_autobus longtext)
BEGIN

    DECLARE var_exists INT DEFAULT 0;
    DECLARE i INT DEFAULT 0;
    DECLARE var_totale_capienza INT DEFAULT 0;
    DECLARE var_numero_autobus INT DEFAULT 0;
    DECLARE var_targa_autobus VARCHAR(7);
    DECLARE var_capienza_autobus INT DEFAULT 0;
    DECLARE var_numero_partecipanti INT DEFAULT 0;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    -- Tutti i dati che leggiamo sono generalmente stabili e vengono modificati raramente. E' ragionevole
    -- usare READ COMMITTED come isolation level.
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;

    DELETE FROM usa WHERE Viaggio = var_codice_viaggio;

    SELECT 1 INTO var_exists FROM viaggio WHERE Codice = var_codice_viaggio LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: viaggio non trovato.';
    end if;

    SET var_numero_autobus = JSON_LENGTH(var_lista_autobus);
    IF var_numero_autobus = 0 then
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Nessun autobus scelto!';
    end if;

    SELECT COUNT(*) INTO var_numero_partecipanti FROM partecipa JOIN prenotazione ON partecipa.Prenotazione = prenotazione.Codice WHERE Viaggio = var_codice_viaggio;

    while i < var_numero_autobus do

            SET var_targa_autobus = JSON_UNQUOTE(JSON_EXTRACT(var_lista_autobus, CONCAT('$[', i, '].targa')));

            INSERT INTO usa(Viaggio, Autobus) VALUES (var_codice_viaggio, var_targa_autobus);
            SELECT Capienza INTO var_capienza_autobus FROM autobus WHERE targa = var_targa_autobus;

            SET var_totale_capienza = var_totale_capienza + var_capienza_autobus;
            SET i = i + 1;
        end while;

    if var_totale_capienza < var_numero_partecipanti THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Questi autobus non bastano per ospitare tutti i partecipanti!';
    end if;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di tabella agenzia_viaggi.tappa
DROP TABLE IF EXISTS `tappa`;
CREATE TABLE IF NOT EXISTS `tappa` (
                                       `Nome` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `Tipo` enum('Città','Luogo') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.tappa: ~21 rows (circa)
INSERT INTO `tappa` (`Nome`, `Tipo`) VALUES
                                         ('Arena di Verona', 'Luogo'),
                                         ('Bari', 'Città'),
                                         ('Colosseo', 'Luogo'),
                                         ('Duomo Milano', 'Luogo'),
                                         ('Firenze', 'Città'),
                                         ('Grotte di Castellana', 'Luogo'),
                                         ('Milano', 'Città'),
                                         ('Mole Antonelliana', 'Luogo'),
                                         ('Napoli', 'Città'),
                                         ('Palermo', 'Città'),
                                         ('Piazza del Campo', 'Luogo'),
                                         ('Piazza San Marco', 'Luogo'),
                                         ('Pompei', 'Luogo'),
                                         ('Roma', 'Città'),
                                         ('Siena', 'Città'),
                                         ('Tor Vergata', 'Città'),
                                         ('Torino', 'Città'),
                                         ('Uffizi', 'Luogo'),
                                         ('Valle dei Templi', 'Luogo'),
                                         ('Venezia', 'Città'),
                                         ('Verona', 'Città');

-- Dump della struttura di tabella agenzia_viaggi.usa
DROP TABLE IF EXISTS `usa`;
CREATE TABLE IF NOT EXISTS `usa` (
                                     `Viaggio` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `Autobus` varchar(7) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                     PRIMARY KEY (`Viaggio`,`Autobus`),
                                     KEY `Autobus` (`Autobus`),
                                     CONSTRAINT `usa_ibfk_1` FOREIGN KEY (`Viaggio`) REFERENCES `viaggio` (`Codice`),
                                     CONSTRAINT `usa_ibfk_2` FOREIGN KEY (`Autobus`) REFERENCES `autobus` (`Targa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.usa: ~2 rows (circa)
INSERT INTO `usa` (`Viaggio`, `Autobus`) VALUES
                                             ('a46e66dd-fe19-11f0-b010-0250a3bfb7b6', 'AA123BB'),
                                             ('a47074c0-fe19-11f0-b010-0250a3bfb7b6', 'DD456EE');

-- Dump della struttura di tabella agenzia_viaggi.utenti
DROP TABLE IF EXISTS `utenti`;
CREATE TABLE IF NOT EXISTS `utenti` (
                                        `Username` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `Password` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `Ruolo` enum('Booking','Amministrazione') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.utenti: ~2 rows (circa)
INSERT INTO `utenti` (`Username`, `Password`, `Ruolo`) VALUES
                                                           ('giacomo', 'dcc4ed45e6d3fb1c13044163a464b44a', 'Amministrazione'),
                                                           ('mario', 'de2f15d014d40b93578d255e6221fd60', 'Booking');

-- Dump della struttura di tabella agenzia_viaggi.viaggio
DROP TABLE IF EXISTS `viaggio`;
CREATE TABLE IF NOT EXISTS `viaggio` (
                                         `Codice` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Itinerario` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Partenza` date DEFAULT NULL,
                                         `Ritorno` date DEFAULT NULL,
                                         PRIMARY KEY (`Codice`),
                                         KEY `Itinerario` (`Itinerario`),
                                         CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`Itinerario`) REFERENCES `itinerario` (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.viaggio: ~6 rows (circa)
INSERT INTO `viaggio` (`Codice`, `Itinerario`, `Partenza`, `Ritorno`) VALUES
                                                                          ('36214947-01d0-11f1-b010-0250a3bfb7b6', 'Gran Tour d Italia', '2026-02-27', '2026-03-04'),
                                                                          ('4a4b298f-01d0-11f1-b010-0250a3bfb7b6', 'Tour Arte e Storia', '2026-08-01', '2026-08-06'),
                                                                          ('a46e66dd-fe19-11f0-b010-0250a3bfb7b6', 'Tour Arte e Storia', '2026-01-10', '2026-01-12'),
                                                                          ('a47074c0-fe19-11f0-b010-0250a3bfb7b6', 'Rotta del Sole', '2026-01-20', '2026-01-22'),
                                                                          ('a4726157-fe19-11f0-b010-0250a3bfb7b6', 'Capitali del Nord e Sud', '2026-02-18', '2026-02-20'),
                                                                          ('a47462b2-fe19-11f0-b010-0250a3bfb7b6', 'Gran Tour d Italia', '2026-05-10', '2026-05-14');

-- Dump della struttura di trigger agenzia_viaggi.controllo_disdetta
DROP TRIGGER IF EXISTS `controllo_disdetta`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_disdetta` AFTER DELETE ON `partecipa` FOR EACH ROW begin
    DECLARE var_numero_partecipanti INT DEFAULT 0;
    DECLARE var_data_partenza DATE;

    -- Controllo se mancano meno di 20 giorni alla partenza
    SELECT v.Partenza INTO var_data_partenza FROM prenotazione p JOIN viaggio v ON p.Viaggio = v.Codice WHERE p.Codice = OLD.Prenotazione LIMIT 1;
    IF DATEDIFF(var_data_partenza, CURDATE()) < 20 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Non è possibile disdire una prenotazione a meno di 20 giorni dalla partenza!';
    END IF;

    -- Elimino la prenotazione se non è rimasto nessun prenotato associato ad essa
    SELECT COUNT(*) INTO var_numero_partecipanti FROM partecipa WHERE Prenotazione = OLD.Prenotazione;
    IF var_numero_partecipanti = 0 THEN
        DELETE FROM prenotazione WHERE Codice = OLD.Prenotazione;
    end if;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger agenzia_viaggi.controllo_partecipazione
DROP TRIGGER IF EXISTS `controllo_partecipazione`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_partecipazione` BEFORE INSERT ON `partecipa` FOR EACH ROW begin

    DECLARE var_exists INT DEFAULT 0;
    DECLARE var_error_msg VARCHAR(256);
    DECLARE var_codice_viaggio VARCHAR(64);

    -- Un cliente non può prenotarsi più di una volta per un singolo viaggio
    SELECT Viaggio INTO var_codice_viaggio FROM prenotazione WHERE Codice = NEW.Prenotazione;
    SELECT 1 INTO var_exists FROM partecipa JOIN prenotazione ON partecipa.Prenotazione = prenotazione.Codice WHERE partecipa.Cliente = NEW.Cliente AND prenotazione.Viaggio = var_codice_viaggio LIMIT 1;
    if var_exists > 0 then
        SET var_error_msg = CONCAT('Errore: Il cliente ', NEW.Cliente, ' risulta già prenotato per questo viaggio!');
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = var_error_msg;
    end if;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger agenzia_viaggi.controllo_pernottamento
DROP TRIGGER IF EXISTS `controllo_pernottamento`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_pernottamento` BEFORE INSERT ON `pernottamento` FOR EACH ROW begin
    DECLARE var_exists INT DEFAULT 0;
    DECLARE var_nome_itinerario VARCHAR(64);
    DECLARE var_numero_partecipanti INT;

    DECLARE var_data_partenza DATE;
    SELECT Partenza INTO var_data_partenza FROM viaggio WHERE Codice = NEW.Viaggio;
    IF DATEDIFF(var_data_partenza, CURDATE()) > 20 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Non è possibile scegliere gli alberghi per un viaggio prima del termine delle prenotazioni!';
    END IF;

    SELECT COUNT(*) INTO var_numero_partecipanti FROM partecipa JOIN prenotazione ON partecipa.Prenotazione = prenotazione.Codice WHERE Viaggio = NEW.Viaggio;

    SELECT Itinerario INTO var_nome_itinerario FROM viaggio WHERE Codice = NEW.Viaggio;
    SELECT 1 INTO var_exists FROM compone WHERE Itinerario = var_nome_itinerario AND Ordine = NEW.Ordine AND Tappa=NEW.CittàAlbergo LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Stai inserendo un pernottamento per una tappa non valida!';
    END IF;

    SET var_exists = 0;

    SELECT 1 INTO var_exists FROM albergo WHERE Nome = NEW.NomeAlbergo AND Indirizzo = NEW.IndirizzoAlbergo AND Città = NEW.CittàAlbergo AND Capienza >= var_numero_partecipanti LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Stai inserendo un albergo non valido o non sufficiente ad ospitare i partecipanti!';
    END IF;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger agenzia_viaggi.controllo_prenotazione
DROP TRIGGER IF EXISTS `controllo_prenotazione`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_prenotazione` BEFORE INSERT ON `prenotazione` FOR EACH ROW begin
    DECLARE var_data_partenza DATE;

    -- Le prenotazioni chiudono 20 giorni prima della partenza
    SELECT Partenza INTO var_data_partenza FROM viaggio WHERE Codice = NEW.Viaggio;
    IF DATEDIFF(var_data_partenza, CURDATE()) < 20 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Non è possibile prenotare a meno di 20 giorni dalla partenza!';
    END IF;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger agenzia_viaggi.controllo_usa_autobus
DROP TRIGGER IF EXISTS `controllo_usa_autobus`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_usa_autobus` BEFORE INSERT ON `usa` FOR EACH ROW begin
    DECLARE var_data_partenza DATE;
    SELECT Partenza INTO var_data_partenza FROM viaggio WHERE Codice = NEW.Viaggio;
    IF DATEDIFF(var_data_partenza, CURDATE()) > 20 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Non è possibile scegliere gli autobus per un viaggio prima del termine delle prenotazioni!';
    END IF;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dump della struttura di trigger agenzia_viaggi.controllo_viaggio
DROP TRIGGER IF EXISTS `controllo_viaggio`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_viaggio` BEFORE INSERT ON `viaggio` FOR EACH ROW begin
    IF DATEDIFF(NEW.Ritorno, NEW.Partenza) < 1 OR DATEDIFF(NEW.Ritorno, NEW.Partenza) > 7  THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Un viaggio deve durare da un giorno ad una settimana.';
    END IF;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

CREATE USER 'Login'@'localhost' IDENTIFIED BY 'login';
CREATE USER 'Amministrazione'@'localhost' IDENTIFIED BY 'amministrazione';
CREATE USER 'Booking'@'localhost' IDENTIFIED BY 'booking';

GRANT EXECUTE ON PROCEDURE agenzia_viaggi.PerformLogin TO 'Login'@'localhost';
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`disdiciprenotazione` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaalberghipercitta` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaautobusperviaggio` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaclienti` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaitinerari` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listapernottamentiperviaggio` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaprenotazioniperviaggio` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listatappe` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listatappeperitinerario` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaviaggi` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`nuovaprenotazione` TO `Booking`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`eliminaalbergo` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`eliminaautobus` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`eliminaitinerario` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`eliminatappa` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`eliminaviaggio` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`generareport` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaalberghi` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaalberghipercitta` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaautobus` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaautobusperviaggio` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaclienti` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaitinerari` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listapernottamentiperviaggio` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaprenotazioniperviaggio` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listatappe` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listatappeperitinerario` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`listaviaggi` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`nuovatappa` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`nuovoalbergo` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`nuovoautobus` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`nuovoitinerario` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`nuovoviaggio` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`sceglialberghi` TO `Amministrazione`@`localhost`;
GRANT EXECUTE ON PROCEDURE `agenzia_viaggi`.`scegliautobus` TO `Amministrazione`@`localhost`;

-- Rimozione temporanea di tabella e creazione della struttura finale della vista
DROP TABLE IF EXISTS `report_guadagno_viaggi`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `report_guadagno_viaggi` AS select `temp`.`CodiceViaggio` AS `CodiceViaggio`,`temp`.`NomeItinerario` AS `NomeItinerario`,`temp`.`CostoItinerario` AS `CostoItinerario`,((`temp`.`NumeroPartecipanti` * `temp`.`CostoItinerario`) - ((`temp`.`CostoTotaleAlberghi` * `temp`.`NumeroPartecipanti`) + (`temp`.`UsciteAutobus` * `temp`.`GiorniViaggio`))) AS `Guadagno`,(`temp`.`NumeroPartecipanti` * `temp`.`CostoItinerario`) AS `Entrate`,((`temp`.`CostoTotaleAlberghi` * `temp`.`NumeroPartecipanti`) + (`temp`.`UsciteAutobus` * `temp`.`GiorniViaggio`)) AS `Uscite`,(`temp`.`CostoTotaleAlberghi` * `temp`.`NumeroPartecipanti`) AS `UsciteAlberghi`,(`temp`.`UsciteAutobus` * `temp`.`GiorniViaggio`) AS `UsciteAutobus` from (select `v`.`Codice` AS `CodiceViaggio`,`i`.`Nome` AS `NomeItinerario`,`i`.`Costo` AS `CostoItinerario`,((to_days(`v`.`Ritorno`) - to_days(`v`.`Partenza`)) + 1) AS `GiorniViaggio`,(select count(0) from (`partecipa` `p` join `prenotazione` `pre` on((`p`.`Prenotazione` = `pre`.`Codice`))) where (`pre`.`Viaggio` = `v`.`Codice`)) AS `NumeroPartecipanti`,(select sum(`a`.`Costo`) from (`autobus` `a` join `usa` `u` on((`a`.`Targa` = `u`.`Autobus`))) where (`u`.`Viaggio` = `v`.`Codice`)) AS `UsciteAutobus`,(select sum(`alb`.`Costo`) from (`pernottamento` `per` join `albergo` `alb` on(((`per`.`NomeAlbergo` = `alb`.`Nome`) and (`per`.`CittàAlbergo` = `alb`.`Città`) and (`per`.`IndirizzoAlbergo` = `alb`.`Indirizzo`)))) where (`per`.`Viaggio` = `v`.`Codice`)) AS `CostoTotaleAlberghi` from (`viaggio` `v` join `itinerario` `i` on((`v`.`Itinerario` = `i`.`Nome`)))) `temp`
;

GRANT SELECT ON `agenzia_viaggi`.`report_guadagno_viaggi` TO `Amministrazione`@`localhost`;
/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
