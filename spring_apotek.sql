/*
SQLyog Community v13.1.8 (64 bit)
MySQL - 10.4.14-MariaDB : Database - spring_apotek
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`spring_apotek` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `spring_apotek`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id_adm` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_adm`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

/*Data for the table `admin` */

insert  into `admin`(`id_adm`,`email`,`nama`,`password`) values 
(1,'zyoler@gmail.com','admin','admin');

/*Table structure for table `kategori` */

DROP TABLE IF EXISTS `kategori`;

CREATE TABLE `kategori` (
  `id_kat` int(11) NOT NULL AUTO_INCREMENT,
  `keterangan` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_kat`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4;

/*Data for the table `kategori` */

insert  into `kategori`(`id_kat`,`keterangan`,`nama`) values 
(1,'Mencegah penuaan dini','Antioksidan'),
(2,'Mengurangi depresi','Anti Depresan'),
(3,'Suplemen','Vitamin'),
(4,'Menstimulasi hewan','Stimulan'),
(5,'Bakteriostatik','Antibiotik'),
(6,'Menghentikan pendarahan','Hemolitika'),
(7,'Jenis Penurun Panas dan Demam','Paracetamol'),
(8,'Untuk masalah penyakit kulit','Anti Derma'),
(9,'Mengatasi masalah peradangan','Anti Radang');

/*Table structure for table `obat` */

DROP TABLE IF EXISTS `obat`;

CREATE TABLE `obat` (
  `id_obat` int(11) NOT NULL AUTO_INCREMENT,
  `hargabeli` int(11) DEFAULT NULL,
  `hargajual` int(11) DEFAULT NULL,
  `kategori` varchar(255) DEFAULT NULL,
  `kedaluwarsa` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `pemasok` varchar(255) DEFAULT NULL,
  `stok` int(11) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_obat`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

/*Data for the table `obat` */

insert  into `obat`(`id_obat`,`hargabeli`,`hargajual`,`kategori`,`kedaluwarsa`,`nama`,`pemasok`,`stok`,`unit`) values 
(1,1000,1200,'Hemolitika','2023-04-25','Asam Mefenamat','Titani Farma',120,'Kaplet'),
(2,2000,2500,'Stimulan','2023-03-21','Salbutamol','Titani Farma',40,'Sirup'),
(3,2000,2500,'Hemolitika','2022-04-27','Calpanax','Titani Farma',3,'Tablet'),
(4,1500,2000,'Anti Depresan','2022-10-26','Paramex','Samsu Farmasi',0,'Tablet'),
(5,2000,2300,'Anti Depresan','2022-07-20','Panadol','Bina Jaya Apotek',3,'Tablet'),
(6,5000,6000,'Vitamin','2022-04-09','Comb','Bina Jaya Apotek',75,'Tablet');

/*Table structure for table `pegawai` */

DROP TABLE IF EXISTS `pegawai`;

CREATE TABLE `pegawai` (
  `id_peg` int(11) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `jk` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_peg`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pegawai` */

insert  into `pegawai`(`id_peg`,`alamat`,`email`,`jk`,`nama`,`nohp`,`password`,`status`) values 
(1,'Pekanbaru','drh19213@gmail.com','Laki-laki','Dani Hidayat','081234567890','123456','Pegawai'),
(2,'Purwakarta','haikal.nuari99@gmail.com','Laki-laki','Haikal Nuari','0890251289323','123456','Pegawai'),
(3,'Lampung','melisa_fit9989@gmail.com','Perempuan','Melisa Fitriani','085657290879','123456','Pegawai');

/*Table structure for table `pelanggan` */

DROP TABLE IF EXISTS `pelanggan`;

CREATE TABLE `pelanggan` (
  `id_peg` int(11) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `jk` varchar(255) DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  `riwayat` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_peg`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pelanggan` */

insert  into `pelanggan`(`id_peg`,`alamat`,`email`,`jk`,`level`,`nama`,`nohp`,`riwayat`) values 
(1,'Bandung','sepasepsep9@gmail.com','Laki-laki','Gold','Asep sep','082589301234',75),
(2,'Ciamis','asheup900@gmail.com','Perempuan','Silver','Asheup','081235125121',10),
(3,'Cimahi','pororoporo90@gmail.com','Laki-laki','Classic','Pororo','085854987654',4),
(4,'Telaga','londokampungers@gmail.com','Laki-laki','Silver','Londo Kampung','087700223344',22);

/*Table structure for table `pemasok` */

DROP TABLE IF EXISTS `pemasok`;

CREATE TABLE `pemasok` (
  `id_peg` int(11) NOT NULL AUTO_INCREMENT,
  `alamat` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `nohp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_peg`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

/*Data for the table `pemasok` */

insert  into `pemasok`(`id_peg`,`alamat`,`email`,`nama`,`nohp`) values 
(1,'Cimahi','kimia_farmaofficial@gmail.com','Kimia Farma','089912312514'),
(2,'Cibereum','binajayaapotekkk@gmail.com','Bina Jaya Apotek','081231212332'),
(3,'Cicendo','farmatitani@gmail.com','Titani Farma','0891231231255'),
(4,'Cai','kenanganpotek@gmail.com','Kenangan Apotek','0891231251212'),
(5,'Cireng','farsamsusi@gmail.com','Samsu Farmasi','0813123125125');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
