/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : stq

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2016-06-06 10:39:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '用户的真实名称',
  `login_name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `create_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建日期',
  `is_manager` tinyint(2) NOT NULL COMMENT '是否为管理员：0：否，1：是',
  `is_deleted` tinyint(2) NOT NULL COMMENT '是否被删：0：否，1：是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
