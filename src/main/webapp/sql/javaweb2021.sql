/*
 Navicat Premium Data Transfer

 Source Server         : MysqlDemo
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : localhost:3306
 Source Schema         : javaweb2021

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 22/01/2021 13:42:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tt_news
-- ----------------------------
DROP TABLE IF EXISTS `tt_news`;
CREATE TABLE `tt_news`  (
  `news_id` int(11) NOT NULL,
  `news_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `news_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`news_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_news
-- ----------------------------
INSERT INTO `tt_news` VALUES (1, '冲八万', 'images/1.jpg', '马化腾');
INSERT INTO `tt_news` VALUES (2, '公司投资年报', 'images/2.jpg', '马化腾');
INSERT INTO `tt_news` VALUES (3, '公司年收益', 'images/3.jpg', '马化腾');
INSERT INTO `tt_news` VALUES (4, '2021年经济预测', 'images/4.jpg', '马化腾');
INSERT INTO `tt_news` VALUES (5, '云计算发展史', 'images/5.jpg', '王坚');
INSERT INTO `tt_news` VALUES (6, '科技未来年', 'images/6.jpg', '王坚');
INSERT INTO `tt_news` VALUES (7, '2021年经济预测', 'images/7.jpg', '王坚');

-- ----------------------------
-- Table structure for tt_role
-- ----------------------------
DROP TABLE IF EXISTS `tt_role`;
CREATE TABLE `tt_role`  (
  `role_id` int(11) NOT NULL,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role_ablility` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`role_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_role
-- ----------------------------
INSERT INTO `tt_role` VALUES (1, '用户', '点击，点赞，搜索');
INSERT INTO `tt_role` VALUES (2, '管理员', '点击,写文,删文,搜索,点赞');

-- ----------------------------
-- Table structure for tt_user
-- ----------------------------
DROP TABLE IF EXISTS `tt_user`;
CREATE TABLE `tt_user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tt_user
-- ----------------------------
INSERT INTO `tt_user` VALUES (1, '熊大', '123456', 1);
INSERT INTO `tt_user` VALUES (2, '熊二', '123456', 1);
INSERT INTO `tt_user` VALUES (3, '光头强', '123456', 1);
INSERT INTO `tt_user` VALUES (4, '马化腾', '12345', 2);
INSERT INTO `tt_user` VALUES (5, '王坚', '12345', 2);
INSERT INTO `tt_user` VALUES (6, '管理员', '1234', 2);
INSERT INTO `tt_user` VALUES (7, '李三', '12345678', 1);
INSERT INTO `tt_user` VALUES (32, '袁俊扬', '123456789', 1);
INSERT INTO `tt_user` VALUES (33, 'zhou', '123456789', 1);
INSERT INTO `tt_user` VALUES (34, 'xu', '12345678', 1);
INSERT INTO `tt_user` VALUES (35, 'wang', '123456789', 1);
INSERT INTO `tt_user` VALUES (44, '光头', '12345678', 1);

SET FOREIGN_KEY_CHECKS = 1;
