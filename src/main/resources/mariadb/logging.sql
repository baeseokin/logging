-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        11.5.2-MariaDB - mariadb.org binary distribution
-- 서버 OS:                        Win64
-- HeidiSQL 버전:                  12.6.0.6765
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- logging 데이터베이스 구조 내보내기
CREATE DATABASE IF NOT EXISTS `logging` /*!40100 DEFAULT CHARACTER SET armscii8 COLLATE armscii8_bin */;
USE `logging`;

-- 테이블 logging.page_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `page_info` (
  `page_id` varchar(50) NOT NULL,
  `page_nm` varchar(100) DEFAULT NULL,
  `use_yn` char(1) NOT NULL,
  `block_yn` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;

-- 테이블 데이터 logging.page_info:~2 rows (대략적) 내보내기
INSERT INTO `page_info` (`page_id`, `page_nm`, `use_yn`, `block_yn`) VALUES
	('P00001', '테스트화면1', 'Y', 'N'),
	('P00002', '테스트화면2', 'Y', 'N');

-- 테이블 logging.page_service_mapping 구조 내보내기
CREATE TABLE IF NOT EXISTS `page_service_mapping` (
  `page_id` varchar(50) NOT NULL,
  `service_id` varchar(50) NOT NULL,
  `use_yn` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;

-- 테이블 데이터 logging.page_service_mapping:~4 rows (대략적) 내보내기
INSERT INTO `page_service_mapping` (`page_id`, `service_id`, `use_yn`) VALUES
	('P00001', 'S00001', 'Y'),
	('P00001', 'S00002', 'Y'),
	('P00002', 'S00003', 'Y'),
	('P00002', 'S00004', 'Y');

-- 테이블 logging.service_info 구조 내보내기
CREATE TABLE IF NOT EXISTS `service_info` (
  `service_id` varchar(50) NOT NULL,
  `service_nm` varchar(100) DEFAULT NULL,
  `use_yn` char(1) NOT NULL,
  `block_yn` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_uca1400_ai_ci;

-- 테이블 데이터 logging.service_info:~4 rows (대략적) 내보내기
INSERT INTO `service_info` (`service_id`, `service_nm`, `use_yn`, `block_yn`) VALUES
	('S00001', '테스트서비스1', 'Y', 'N'),
	('S00002', '테스트서비스2', 'Y', 'N'),
	('S00003', '테스트서비스3', 'Y', 'N'),
	('S00004', '테스트서비스4', 'Y', 'N');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
