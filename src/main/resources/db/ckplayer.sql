/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : ckplayer

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-10-27 13:48:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for reps_barrage
-- ----------------------------
DROP TABLE IF EXISTS `reps_barrage`;
CREATE TABLE `reps_barrage` (
  `id` char(32) NOT NULL,
  `content` varchar(100) DEFAULT NULL COMMENT '弹幕内容',
  `nt` int(11) DEFAULT NULL,
  `video_id` varchar(32) DEFAULT NULL COMMENT '视频标识',
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `video_id` (`video_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
