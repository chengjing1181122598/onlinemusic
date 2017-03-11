/*
Navicat MySQL Data Transfer

Source Server         : practice
Source Server Version : 50548
Source Host           : localhost:3306
Source Database       : onlinemusic

Target Server Type    : MYSQL
Target Server Version : 50548
File Encoding         : 65001

Date: 2017-03-11 10:30:07
*/

/*==============================================================*/
/* 创建数据库                                       */
/*==============================================================*/
DROP DATABASE IF EXISTS onlinemusic;
CREATE DATABASE onlinemusic;
USE onlinemusic;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for album
-- ----------------------------
DROP TABLE IF EXISTS `album`;
CREATE TABLE `album` (
  `album_id` varchar(255) NOT NULL,
  `album_name` varchar(255) NOT NULL,
  `album_explain` longtext NOT NULL,
  `cover_relative_path` varchar(255) NOT NULL,
  `cover_absolute_path` varchar(255) NOT NULL,
  `singer_id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collect_album
-- ----------------------------
DROP TABLE IF EXISTS `collect_album`;
CREATE TABLE `collect_album` (
  `collect_id` varchar(255) NOT NULL,
  `collect_username` varchar(255) NOT NULL,
  `collect_album_id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`collect_id`),
  UNIQUE KEY `collect_username` (`collect_username`,`collect_album_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collect_singer
-- ----------------------------
DROP TABLE IF EXISTS `collect_singer`;
CREATE TABLE `collect_singer` (
  `collect_id` varchar(255) NOT NULL,
  `collect_username` varchar(255) NOT NULL,
  `collect_singer_id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`collect_id`),
  UNIQUE KEY `collect_username` (`collect_username`,`collect_singer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for collect_song
-- ----------------------------
DROP TABLE IF EXISTS `collect_song`;
CREATE TABLE `collect_song` (
  `collect_id` varchar(255) NOT NULL,
  `collect_username` varchar(255) NOT NULL,
  `collect_song_id` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`collect_id`),
  UNIQUE KEY `collect_username` (`collect_username`,`collect_song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for singer
-- ----------------------------
DROP TABLE IF EXISTS `singer`;
CREATE TABLE `singer` (
  `singer_id` varchar(255) NOT NULL,
  `singer_name` varchar(255) NOT NULL,
  `singer_explain` longtext NOT NULL,
  `photo_relative_path` varchar(255) NOT NULL,
  `photo_absolute_path` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`singer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for song
-- ----------------------------
DROP TABLE IF EXISTS `song`;
CREATE TABLE `song` (
  `song_id` varchar(255) NOT NULL,
  `song_name` varchar(255) NOT NULL,
  `lyric` longtext NOT NULL,
  `create_time` datetime NOT NULL,
  `singer_id` varchar(255) NOT NULL,
  `album_id` varchar(255) DEFAULT NULL,
  `audio_relative_path` varchar(255) NOT NULL,
  `audio_absolute_path` varchar(255) NOT NULL,
  PRIMARY KEY (`song_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `create_time` datetime NOT NULL,
  `image_relative_path` varchar(255) NOT NULL,
  `image_absolute_path` varchar(255) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
