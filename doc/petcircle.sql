/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : petcircle

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-09-30 18:14:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '狗狗名字',
  `type` varchar(255) DEFAULT NULL COMMENT '狗狗类型',
  `typename` varchar(255) DEFAULT NULL,
  `header` varchar(255) DEFAULT NULL COMMENT '狗狗头像',
  `sex` varchar(255) DEFAULT NULL COMMENT '狗狗性别',
  `age` float(11,2) DEFAULT NULL COMMENT '狗狗年龄',
  `partner` varchar(255) DEFAULT NULL COMMENT '主人昵称',
  `partnerheader` varchar(255) DEFAULT NULL COMMENT '主人头像',
  `relationship` varchar(255) DEFAULT NULL COMMENT '关系',
  `desc` varchar(255) DEFAULT NULL COMMENT '描述',
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', '巴弟', '1', '金毛', null, '1', '2.00', '平行线', null, '兄弟', null, '2017-09-30 15:55:35');
INSERT INTO `account` VALUES ('2', '辛巴', '1', '金毛', null, '1', '1.00', '辛巴哥', null, '兄弟', null, '2017-09-30 16:00:49');
INSERT INTO `account` VALUES ('3', '秋秋', '1', '金毛', null, '2', '0.50', '秋秋妈', null, null, null, '2017-09-30 16:03:15');

-- ----------------------------
-- Table structure for contacts
-- ----------------------------
DROP TABLE IF EXISTS `contacts`;
CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_a_id` int(11) DEFAULT NULL,
  `user_b_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contacts
-- ----------------------------
INSERT INTO `contacts` VALUES ('3', '2', '3');
INSERT INTO `contacts` VALUES ('4', '1', '3');
INSERT INTO `contacts` VALUES ('5', '1', '2');
INSERT INTO `contacts` VALUES ('6', '2', '1');

-- ----------------------------
-- Table structure for dog
-- ----------------------------
DROP TABLE IF EXISTS `dog`;
CREATE TABLE `dog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `type` varchar(255) DEFAULT NULL COMMENT '分类',
  `header` varchar(255) DEFAULT NULL COMMENT '头像',
  `smart` int(11) DEFAULT NULL COMMENT '智力',
  `physique` varchar(255) DEFAULT NULL COMMENT '体型',
  `images` varchar(255) DEFAULT NULL COMMENT '图片',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dog
-- ----------------------------
INSERT INTO `dog` VALUES ('1', '金毛', '赛级金毛', null, '3', '大型犬', null);
