/*
Navicat MySQL Data Transfer

Source Server         : efhelper
Source Server Version : 50554
Source Host           : localhost:3306
Source Database       : efhelper

Target Server Type    : MYSQL
Target Server Version : 50554
File Encoding         : 65001

Date: 2018-05-13 20:49:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_power_user
-- ----------------------------
DROP TABLE IF EXISTS `t_power_user`;
CREATE TABLE `t_power_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_user_id` bigint(20) DEFAULT '0' COMMENT '用户编号',
  `t_user_name` varchar(255) DEFAULT NULL COMMENT '用户名称',
  `t_user_phone` varchar(255) DEFAULT NULL COMMENT '联系方式',
  `t_power_line_id` bigint(20) DEFAULT NULL COMMENT '抄表段编号',
  `t_power_line_name` varchar(255) DEFAULT NULL COMMENT '抄表段名称',
  `t_meter_reading_day` int(11) DEFAULT NULL COMMENT '抄表例日',
  `t_meter_reader` varchar(255) DEFAULT NULL COMMENT '抄表员',
  `t_measurement_point_id` bigint(20) DEFAULT NULL COMMENT '计量点编号',
  `t_meter_reading_id` int(11) DEFAULT NULL COMMENT '抄表序号',
  `t_power_meter_id` varchar(255) DEFAULT NULL COMMENT '电能表编号',
  `t_power_value_type` varchar(255) DEFAULT NULL COMMENT '示数类型',
  `t_last_power_value` int(11) DEFAULT NULL COMMENT '上次示数',
  `t_current_power_value` int(11) DEFAULT NULL COMMENT '本次示数',
  `t_consume_power_value` int(11) DEFAULT NULL COMMENT '抄见电量',
  `t_comprehensive_ratio` int(11) DEFAULT NULL COMMENT '综合倍率',
  `t_meter_reading_number` double(10,1) DEFAULT NULL COMMENT '抄表位数',
  `t_exception_types` varchar(255) DEFAULT NULL COMMENT '异常类型',
  `t_meter_reading_status` varchar(255) DEFAULT NULL COMMENT '抄表状态',
  `t_power_supply_id` int(11) DEFAULT NULL COMMENT '供电单位',
  `t_power_supply_name` varchar(255) DEFAULT NULL COMMENT '供电所',
  `t_user_address` varchar(255) DEFAULT NULL COMMENT '用电地址',
  `t_ying_shou_sum` double(10,2) DEFAULT NULL,
  `t_shi_shou_sum` double(10,2) DEFAULT NULL,
  `t_qian_fei_sum` double(10,2) DEFAULT NULL,
  `t_create_time` datetime DEFAULT NULL,
  `t_update_time` datetime DEFAULT NULL,
  `t_remarks` varchar(255) DEFAULT NULL,
  `t_remark_id` mediumtext,
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM AUTO_INCREMENT=199 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `t_id` int(11) NOT NULL AUTO_INCREMENT,
  `t_name` varchar(255) DEFAULT NULL,
  `t_phone` varchar(255) DEFAULT NULL,
  `t_password` varchar(255) DEFAULT NULL,
  `t_age` int(11) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
