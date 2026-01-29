-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versione server:              8.0.44 - MySQL Community Server - GPL
-- S.O. server:                  Win64
-- HeidiSQL Versione:            12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dump della struttura del database agenzia_viaggi
CREATE DATABASE IF NOT EXISTS `agenzia_viaggi` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `agenzia_viaggi`;

-- Dump della struttura di tabella agenzia_viaggi.albergo
CREATE TABLE IF NOT EXISTS `albergo` (
                                         `Nome` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Indirizzo` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Città` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Costo` int DEFAULT NULL,
                                         `Capienza` int DEFAULT NULL,
                                         `Referente` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Email` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Telefono` varchar(14) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Fax` varchar(12) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         PRIMARY KEY (`Nome`,`Città`,`Indirizzo`),
                                         KEY `Città` (`Città`),
                                         KEY `fk_albergo_referente` (`Referente`),
                                         CONSTRAINT `albergo_ibfk_1` FOREIGN KEY (`Città`) REFERENCES `tappa` (`Nome`) ON DELETE CASCADE,
                                         CONSTRAINT `fk_albergo_referente` FOREIGN KEY (`Referente`) REFERENCES `referente` (`CF`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.albergo: ~2 rows (circa)
INSERT INTO `albergo` (`Nome`, `Indirizzo`, `Città`, `Costo`, `Capienza`, `Referente`, `Email`, `Telefono`, `Fax`) VALUES
                                                                                                                       ('aasddsa', 'fdffd', 'Milano', 20, 25, 'MM', 'dsdsasad', 'ffff', 'gggg'),
                                                                                                                       ('Mariani', 'Via Cave', 'Roma', 15, 25, 'MM', 'mm@gmail.com', '333333', '12313'),
                                                                                                                       ('NuovoAlbergo', 'sadada', 'Milano', 15, 13, 'dsadad', 'aaaa', '43224242', 'ffdsfdf');

-- Dump della struttura di tabella agenzia_viaggi.autobus
CREATE TABLE IF NOT EXISTS `autobus` (
                                         `Targa` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Capienza` int DEFAULT NULL,
                                         `Costo` int DEFAULT NULL,
                                         PRIMARY KEY (`Targa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.autobus: ~5 rows (circa)
INSERT INTO `autobus` (`Targa`, `Capienza`, `Costo`) VALUES
                                                         ('AK452UI', 10, 15),
                                                         ('IO131OI', 7, 10),
                                                         ('JR638OR', 10, 15),
                                                         ('YR423AO', 8, 13),
                                                         ('YY344AA', 3, 4);

-- Dump della struttura di tabella agenzia_viaggi.cliente
CREATE TABLE IF NOT EXISTS `cliente` (
                                         `CF` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Nome` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Cognome` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         PRIMARY KEY (`CF`),
                                         KEY `cliente_nominativo` (`Cognome`,`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.cliente: ~4 rows (circa)
INSERT INTO `cliente` (`CF`, `Nome`, `Cognome`) VALUES
                                                    ('DanieleCilia', 'Daniele', 'Cilia'),
                                                    ('PALLE', 'Pippo', 'Pluto'),
                                                    ('PaoloAnna', 'Paolo', 'Anna'),
                                                    ('TMOOOOOOO', 'Tiziano', 'Maggi');

-- Dump della struttura di tabella agenzia_viaggi.compone
CREATE TABLE IF NOT EXISTS `compone` (
                                         `Itinerario` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Ordine` int NOT NULL,
                                         `Tappa` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         PRIMARY KEY (`Itinerario`,`Ordine`),
                                         KEY `Tappa` (`Tappa`),
                                         CONSTRAINT `compone_ibfk_1` FOREIGN KEY (`Itinerario`) REFERENCES `itinerario` (`Nome`) ON DELETE CASCADE,
                                         CONSTRAINT `compone_ibfk_2` FOREIGN KEY (`Tappa`) REFERENCES `tappa` (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.compone: ~0 rows (circa)
INSERT INTO `compone` (`Itinerario`, `Ordine`, `Tappa`) VALUES
                                                            ('Viaggio Mariani', 0, 'Roma'),
                                                            ('Viaggio Mariani', 1, 'Milano'),
                                                            ('Viaggio Mariani', 2, 'Colosseo');

-- Dump della struttura di procedura agenzia_viaggi.DisdiciPrenotazione
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
DELIMITER //
CREATE PROCEDURE `EliminaTappa`(IN var_nome varchar(64))
BEGIN
    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    DELETE FROM tappa WHERE Nome = var_nome;
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.EliminaViaggio
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
DELIMITER //
CREATE PROCEDURE `GeneraReport`(IN var_codice_viaggio varchar(64))
BEGIN

    DECLARE var_exists INT DEFAULT 0;
    DECLARE var_data_partenza DATE;

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ ONLY;

    SELECT 1 INTO var_exists FROM viaggio WHERE Codice = var_codice_viaggio LIMIT 1;
    IF var_exists = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: viaggio non trovato.';
    end if;

    SELECT Partenza INTO var_data_partenza FROM viaggio WHERE Codice = var_codice_viaggio;
    IF DATEDIFF(var_data_partenza, CURDATE()) > 20 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Non è possibile generare un report per un viaggio con prenotazioni ancora aperte!';
    END IF;

    SELECT * FROM report_guadagno_viaggi WHERE report_guadagno_viaggi.CodiceViaggio = var_codice_viaggio;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di tabella agenzia_viaggi.itinerario
CREATE TABLE IF NOT EXISTS `itinerario` (
                                            `Nome` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                            `Costo` int DEFAULT NULL,
                                            PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.itinerario: ~1 rows (circa)
INSERT INTO `itinerario` (`Nome`, `Costo`) VALUES
    ('Viaggio Mariani', 1500);

-- Dump della struttura di procedura agenzia_viaggi.ListaAlberghi
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

    SELECT * FROM albergo a JOIN referente r ON a.Referente = r.CF WHERE a.Città = var_citta;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaAutobus
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

    SELECT v.Codice, u.Autobus, a.Costo, a.Capienza FROM viaggio v JOIN usa u ON v.Codice = u.Viaggio JOIN autobus a on u.Autobus = a.Targa WHERE v.Codice = var_codice_viaggio;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaClienti
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

    SELECT v.Codice, p.NomeAlbergo, p.CittàAlbergo, p.Ordine, a.Referente FROM viaggio v JOIN pernottamento p ON v.Codice = p.Viaggio JOIN albergo a ON p.NomeAlbergo = a.Nome and p.CittàAlbergo = a.Città and p.IndirizzoAlbergo = a.Indirizzo WHERE v.Codice = var_codice_viaggio;

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaPrenotazioniPerViaggio
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

    SELECT v.Codice, p.Codice as CodicePrenotazione, pa.Cliente, c.Nome, c.Cognome FROM viaggio v JOIN prenotazione p ON v.Codice = p.Viaggio JOIN partecipa pa ON p.Codice = pa.Prenotazione JOIN cliente c ON pa.Cliente = c.CF WHERE v.Codice = var_codice_viaggio;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ListaTappe
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
    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoAlbergo
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

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoAutobus
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

    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoItinerario
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

    COMMIT;
END//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.NuovoViaggio
DELIMITER //
CREATE PROCEDURE `NuovoViaggio`(IN var_nome_itinerario varchar(64), IN var_data_partenza date,
                                IN var_data_ritorno date)
BEGIN

    DECLARE exit handler for sqlexception
        BEGIN
            ROLLBACK;
            RESIGNAL;
        END;

    SET TRANSACTION ISOLATION LEVEL READ COMMITTED;
    START TRANSACTION READ WRITE;
    INSERT INTO viaggio(Codice, Itinerario, Partenza, Ritorno) VALUES (UUID(), var_nome_itinerario, var_data_partenza, var_data_ritorno);
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di tabella agenzia_viaggi.partecipa
CREATE TABLE IF NOT EXISTS `partecipa` (
                                           `CodiceDisdetta` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                           `Prenotazione` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                           `Cliente` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
                                           PRIMARY KEY (`CodiceDisdetta`),
                                           UNIQUE KEY `uq_cliente_prenotazione` (`Prenotazione`,`Cliente`),
                                           KEY `Cliente` (`Cliente`),
                                           CONSTRAINT `partecipa_ibfk_1` FOREIGN KEY (`Prenotazione`) REFERENCES `prenotazione` (`Codice`),
                                           CONSTRAINT `partecipa_ibfk_2` FOREIGN KEY (`Cliente`) REFERENCES `cliente` (`CF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.partecipa: ~2 rows (circa)
INSERT INTO `partecipa` (`CodiceDisdetta`, `Prenotazione`, `Cliente`) VALUES
                                                                          ('311964ce-ec95-11f0-8d1d-d20bbf9cd03f', '31192fb7-ec95-11f0-8d1d-d20bbf9cd03f', 'PALLE'),
                                                                          ('31197a2e-ec95-11f0-8d1d-d20bbf9cd03f', '31192fb7-ec95-11f0-8d1d-d20bbf9cd03f', 'TMOOOOOOO');

-- Dump della struttura di procedura agenzia_viaggi.PerformLogin
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
CREATE TABLE IF NOT EXISTS `pernottamento` (
                                               `Viaggio` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `Ordine` int NOT NULL,
                                               `NomeAlbergo` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `IndirizzoAlbergo` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               `CittàAlbergo` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                               PRIMARY KEY (`Viaggio`,`Ordine`),
                                               KEY `NomeAlbergo` (`NomeAlbergo`,`CittàAlbergo`,`IndirizzoAlbergo`),
                                               CONSTRAINT `pernottamento_ibfk_1` FOREIGN KEY (`Viaggio`) REFERENCES `viaggio` (`Codice`),
                                               CONSTRAINT `pernottamento_ibfk_2` FOREIGN KEY (`NomeAlbergo`, `CittàAlbergo`, `IndirizzoAlbergo`) REFERENCES `albergo` (`Nome`, `Città`, `Indirizzo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.pernottamento: ~2 rows (circa)
INSERT INTO `pernottamento` (`Viaggio`, `Ordine`, `NomeAlbergo`, `IndirizzoAlbergo`, `CittàAlbergo`) VALUES
                                                                                                         ('d9ad87f9-ec8a-11f0-8d1d-d20bbf9cd03f', 0, 'Mariani', 'Via Cave', 'Roma'),
                                                                                                         ('d9ad87f9-ec8a-11f0-8d1d-d20bbf9cd03f', 1, 'aasddsa', 'fdffd', 'Milano');

-- Dump della struttura di tabella agenzia_viaggi.prenotazione
CREATE TABLE IF NOT EXISTS `prenotazione` (
                                              `Codice` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                              `Viaggio` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                              PRIMARY KEY (`Codice`),
                                              KEY `Viaggio` (`Viaggio`),
                                              CONSTRAINT `prenotazione_ibfk_1` FOREIGN KEY (`Viaggio`) REFERENCES `viaggio` (`Codice`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.prenotazione: ~2 rows (circa)
INSERT INTO `prenotazione` (`Codice`, `Viaggio`) VALUES
    ('31192fb7-ec95-11f0-8d1d-d20bbf9cd03f', 'd9ad87f9-ec8a-11f0-8d1d-d20bbf9cd03f');

-- Dump della struttura di tabella agenzia_viaggi.referente
CREATE TABLE IF NOT EXISTS `referente` (
                                           `CF` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
                                           `Nome` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                           `Cognome` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                           PRIMARY KEY (`CF`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.referente: ~0 rows (circa)
INSERT INTO `referente` (`CF`, `Nome`, `Cognome`) VALUES
                                                      ('dsadad', 'adsdad', 'dadasd'),
                                                      ('feww', 'AAAAsd', 'ffffff'),
                                                      ('MM', 'Manuel', 'Mariani');

-- Dump della struttura di vista agenzia_viaggi.report_guadagno_viaggi
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
    START TRANSACTION READ WRITE;

    SELECT Itinerario INTO var_nome_itinerario FROM viaggio WHERE Codice = var_codice_viaggio;
    SELECT COUNT(*) INTO var_numero_citta FROM compone JOIN tappa ON compone.Tappa = tappa.Nome WHERE Itinerario = var_nome_itinerario AND Tipo = 'Citta';

    SET var_numero_alberghi = JSON_LENGTH(var_lista_alberghi);
    IF var_numero_citta != var_numero_alberghi THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: il numero di citta non corrisponde al numero di alberghi selezionati.';
    end if;

    while i < var_numero_alberghi do

            SET var_nome_albergo = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].nome')));
            SET var_citta_albergo = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].citta')));
            SET var_indirizzo_albergo = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].indirizzo')));
            SET var_ordine_pernottamento = JSON_UNQUOTE(JSON_EXTRACT(var_lista_alberghi, CONCAT('$[', i, '].ordine')));

            -- Le regole aziendali vengono implementate dal trigger su pernottamento.
            INSERT INTO pernottamento(Viaggio, Ordine, NomeAlbergo, IndirizzoAlbergo, CittàAlbergo) VALUES (var_codice_viaggio, var_ordine_pernottamento, var_nome_albergo, var_indirizzo_albergo, var_citta_albergo);

            SET i = i + 1;
        end while;
    COMMIT;
end//
DELIMITER ;

-- Dump della struttura di procedura agenzia_viaggi.ScegliAutobus
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
CREATE TABLE IF NOT EXISTS `tappa` (
                                       `Nome` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                       `Tipo` enum('Città','Luogo') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                       PRIMARY KEY (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.tappa: ~3 rows (circa)
INSERT INTO `tappa` (`Nome`, `Tipo`) VALUES
                                         ('Colosseo', 'Luogo'),
                                         ('Milano', 'Città'),
                                         ('Roma', 'Città');

-- Dump della struttura di tabella agenzia_viaggi.usa
CREATE TABLE IF NOT EXISTS `usa` (
                                     `Viaggio` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                     `Autobus` varchar(7) COLLATE utf8mb4_unicode_ci NOT NULL,
                                     PRIMARY KEY (`Viaggio`,`Autobus`),
                                     KEY `Autobus` (`Autobus`),
                                     CONSTRAINT `usa_ibfk_1` FOREIGN KEY (`Viaggio`) REFERENCES `viaggio` (`Codice`),
                                     CONSTRAINT `usa_ibfk_2` FOREIGN KEY (`Autobus`) REFERENCES `autobus` (`Targa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.usa: ~2 rows (circa)
INSERT INTO `usa` (`Viaggio`, `Autobus`) VALUES
                                             ('d9ad87f9-ec8a-11f0-8d1d-d20bbf9cd03f', 'JR638OR'),
                                             ('d9ad87f9-ec8a-11f0-8d1d-d20bbf9cd03f', 'YY344AA');

-- Dump della struttura di tabella agenzia_viaggi.utenti
CREATE TABLE IF NOT EXISTS `utenti` (
                                        `Username` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
                                        `Password` char(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        `Ruolo` enum('Booking','Amministrazione') COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                        PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.utenti: ~2 rows (circa)
INSERT INTO `utenti` (`Username`, `Password`, `Ruolo`) VALUES
                                                           ('giacomo', 'dcc4ed45e6d3fb1c13044163a464b44a', 'Amministrazione'),
                                                           ('mario', 'de2f15d014d40b93578d255e6221fd60', 'Booking');

-- Dump della struttura di tabella agenzia_viaggi.viaggio
CREATE TABLE IF NOT EXISTS `viaggio` (
                                         `Codice` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
                                         `Itinerario` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
                                         `Partenza` date DEFAULT NULL,
                                         `Ritorno` date DEFAULT NULL,
                                         PRIMARY KEY (`Codice`),
                                         KEY `Itinerario` (`Itinerario`),
                                         CONSTRAINT `viaggio_ibfk_1` FOREIGN KEY (`Itinerario`) REFERENCES `itinerario` (`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- Dump dei dati della tabella agenzia_viaggi.viaggio: ~2 rows (circa)
INSERT INTO `viaggio` (`Codice`, `Itinerario`, `Partenza`, `Ritorno`) VALUES
    ('d9ad87f9-ec8a-11f0-8d1d-d20bbf9cd03f', 'Viaggio Mariani', '2026-01-31', '2026-02-06');

-- Dump della struttura di trigger agenzia_viaggi.controllo_disdetta
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
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `controllo_viaggio` BEFORE INSERT ON `viaggio` FOR EACH ROW begin
    IF DATEDIFF(NEW.Ritorno, NEW.Partenza) < 1 OR DATEDIFF(NEW.Ritorno, NEW.Partenza) > 7  THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Errore: Un viaggio deve durare da un giorno ad una settimana.';
    END IF;
end//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Rimozione temporanea di tabella e creazione della struttura finale della vista
DROP TABLE IF EXISTS `report_guadagno_viaggi`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `report_guadagno_viaggi` AS select `temp`.`CodiceViaggio` AS `CodiceViaggio`,`temp`.`NomeItinerario` AS `NomeItinerario`,`temp`.`CostoItinerario` AS `CostoItinerario`,((`temp`.`NumeroPartecipanti` * `temp`.`CostoItinerario`) - ((`temp`.`CostoTotaleAlberghi` * `temp`.`NumeroPartecipanti`) + (`temp`.`UsciteAutobus` * `temp`.`GiorniViaggio`))) AS `Guadagno`,(`temp`.`NumeroPartecipanti` * `temp`.`CostoItinerario`) AS `Entrate`,((`temp`.`CostoTotaleAlberghi` * `temp`.`NumeroPartecipanti`) + (`temp`.`UsciteAutobus` * `temp`.`GiorniViaggio`)) AS `Uscite`,(`temp`.`CostoTotaleAlberghi` * `temp`.`NumeroPartecipanti`) AS `UsciteAlberghi`,(`temp`.`UsciteAutobus` * `temp`.`GiorniViaggio`) AS `UsciteAutobus` from (select `v`.`Codice` AS `CodiceViaggio`,`i`.`Nome` AS `NomeItinerario`,`i`.`Costo` AS `CostoItinerario`,((to_days(`v`.`Ritorno`) - to_days(`v`.`Partenza`)) + 1) AS `GiorniViaggio`,(select count(0) from (`partecipa` `p` join `prenotazione` `pre` on((`p`.`Prenotazione` = `pre`.`Codice`))) where (`pre`.`Viaggio` = `v`.`Codice`)) AS `NumeroPartecipanti`,(select sum(`a`.`Costo`) from (`autobus` `a` join `usa` `u` on((`a`.`Targa` = `u`.`Autobus`))) where (`u`.`Viaggio` = `v`.`Codice`)) AS `UsciteAutobus`,(select sum(`alb`.`Costo`) from (`pernottamento` `per` join `albergo` `alb` on(((`per`.`NomeAlbergo` = `alb`.`Nome`) and (`per`.`CittàAlbergo` = `alb`.`Città`) and (`per`.`IndirizzoAlbergo` = `alb`.`Indirizzo`)))) where (`per`.`Viaggio` = `v`.`Codice`)) AS `CostoTotaleAlberghi` from (`viaggio` `v` join `itinerario` `i` on((`v`.`Itinerario` = `i`.`Nome`)))) `temp`
;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
