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
DROP TABLE IF EXISTS `page_info`;
CREATE TABLE IF NOT EXISTS `page_info` (
  `page_id` varchar(50) NOT NULL,
  `page_nm` varchar(100) DEFAULT NULL,
  `use_yn` char(1) NOT NULL,
  `block_yn` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 테이블 데이터 logging.page_info:~2 rows (대략적) 내보내기
INSERT INTO `page_info` (`page_id`, `page_nm`, `use_yn`, `block_yn`) VALUES
	('PGEA0100001', '가입설계처리', 'Y', 'N'),
	('PGEB0100001', '계약조회', 'Y', 'N');

-- 테이블 logging.page_service_mapping 구조 내보내기
DROP TABLE IF EXISTS `page_service_mapping`;
CREATE TABLE IF NOT EXISTS `page_service_mapping` (
  `page_id` varchar(50) NOT NULL,
  `service_id` varchar(50) NOT NULL,
  `use_yn` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 테이블 데이터 logging.page_service_mapping:~4 rows (대략적) 내보내기
INSERT INTO `page_service_mapping` (`page_id`, `service_id`, `use_yn`) VALUES
	('PGEA0100001', 'RSTA0100001', 'Y'),
	('PGEA0100001', 'RSTA0100002', 'Y'),
	('PGEB0100001', 'RSTB0100001', 'Y'),
	('PGEB0100001', 'RSTB0100002', 'Y');

-- 테이블 logging.service_info 구조 내보내기
DROP TABLE IF EXISTS `service_info`;
CREATE TABLE IF NOT EXISTS `service_info` (
  `service_id` varchar(50) NOT NULL,
  `service_nm` varchar(100) DEFAULT NULL,
  `use_yn` char(1) NOT NULL,
  `block_yn` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 테이블 데이터 logging.service_info:~4 rows (대략적) 내보내기
INSERT INTO `service_info` (`service_id`, `service_nm`, `use_yn`, `block_yn`) VALUES
	('RSTA0100001', '기존가입설계내역조회', 'Y', 'N'),
	('RSTA0100002', '가입설계 생성', 'Y', 'N'),
	('RSTB0100001', '고객정보조회', 'Y', 'N'),
	('RSTB0100002', '계약정보조회', 'Y', 'N');

-- 테이블 logging.system_info 구조 내보내기
DROP TABLE IF EXISTS `system_info`;
CREATE TABLE IF NOT EXISTS `system_info` (
  `system_id` varchar(50) NOT NULL DEFAULT '',
  `system_nm` varchar(100) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;

-- 테이블 데이터 logging.system_info:~2 rows (대략적) 내보내기
INSERT INTO `system_info` (`system_id`, `system_nm`) VALUES
	('A01', '가입설계'),
	('B01', '계약관리');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
