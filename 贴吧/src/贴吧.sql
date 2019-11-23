/*
 Navicat Premium Data Transfer

 Source Server         : LocalHost
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost:3306
 Source Schema         : my_database

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : 65001

 Date: 23/11/2019 16:34:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_reply
-- ----------------------------
DROP TABLE IF EXISTS `sys_reply`;
CREATE TABLE `sys_reply`  (
  `replyid` int(10) NOT NULL AUTO_INCREMENT,
  `topicid` int(10) NOT NULL,
  `author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(1028) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`replyid`) USING BTREE,
  INDEX `FK_Reference_1`(`topicid`) USING BTREE,
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`topicid`) REFERENCES `sys_topic` (`topicid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_reply
-- ----------------------------
INSERT INTO `sys_reply` VALUES (1, 1, 'MMM', '好！', '2019-11-18 19:02:43');
INSERT INTO `sys_reply` VALUES (2, 2, 'XXX', '还不错', '2019-11-18 19:03:03');
INSERT INTO `sys_reply` VALUES (3, 1, 'LLL', '有用！', '2019-11-18 19:03:28');
INSERT INTO `sys_reply` VALUES (4, 3, 'HHH', '哈哈哈！', '2019-11-18 19:03:40');
INSERT INTO `sys_reply` VALUES (6, 1, 'hh', '试一下', '2019-11-18 21:23:31');
INSERT INTO `sys_reply` VALUES (7, 1, 'wsh', '学习！', '2019-11-18 21:38:38');
INSERT INTO `sys_reply` VALUES (9, 1, 'hhh', '好', '2019-11-19 09:08:30');
INSERT INTO `sys_reply` VALUES (10, 13, 'hjx', '真好！', '2019-11-19 19:34:47');

-- ----------------------------
-- Table structure for sys_topic
-- ----------------------------
DROP TABLE IF EXISTS `sys_topic`;
CREATE TABLE `sys_topic`  (
  `topicid` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` varchar(2056) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `author` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `createdate` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `clickamount` int(10) DEFAULT 0,
  PRIMARY KEY (`topicid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_topic
-- ----------------------------
INSERT INTO `sys_topic` VALUES (1, '选择排序', '选择排序就是重复“从待排序的数据中寻找最小值，将其与序列最左边的数字进行交换”这一操作的算法。在序列中寻找最小值时使用的是线性查找。', '郝健祥', '2019-11-18 18:59:40', 27);
INSERT INTO `sys_topic` VALUES (2, '冒泡排序', '冒泡排序就是重复“从序列右边开始比较相邻两个数字的大小，再根据结果交换两个数字的位置”这一操作的算法。在这个过程中，数字会像泡泡一样，慢慢从右往左“浮”到序列的顶端，所以这个算法才被称为“冒泡排序”。', '郝健祥', '2019-11-18 19:00:12', 0);
INSERT INTO `sys_topic` VALUES (3, '插入排序', '插入排序是一种从序列左端开始依次对数据进行排序的算法。在排序过程中，左侧的数据陆续归位，而右侧留下的就是还未被排序的数据。插入排序的思路就是从右侧的未排序区域内取出一个数据，然后将它插入到已排序区域内合适的位置上。', '郝健祥', '2019-11-18 19:00:55', 0);
INSERT INTO `sys_topic` VALUES (4, '堆排序', '堆排序的特点是利用了数据结构中的堆。', '郝健祥', '2019-11-18 19:01:13', 0);
INSERT INTO `sys_topic` VALUES (5, '归并排序', '归并排序算法会把序列分成长度相同的两个子序列，当无法继续往下分时（也就是每个子序列中只有一个数据时），就对子序列进行归并。归并指的是把两个排好序的子序列合并成一个有序序列。该操作会一直重复执行，直到所有子序列都归并为一个整体为止。', '郝健祥', '2019-11-18 19:01:33', 0);
INSERT INTO `sys_topic` VALUES (6, '快速排序', '快速排序算法首先会在序列中随机选择一个基准值（pivot），然后将除了基准值以外的数分\r\n为“比基准值小的数”和“比基准值大的数”这两个类别，再将其排列成以下形式。\r\n[ 比基准值小的数 ] 基准值 [ 比基准值大的数 ]\r\n接着，对两个“[ ]”中的数据进行排序之后，整体的排序便完成了。对“[ ]”里面的数据\r\n进行排序时同样也会使用快速排序。', '郝健祥', '2019-11-18 19:02:05', 0);
INSERT INTO `sys_topic` VALUES (7, 'hellooo', 'asdfasf', 'hhhhhh', '2019-11-18 19:52:52', 0);
INSERT INTO `sys_topic` VALUES (8, 'hhhhhhh', 'asfdasf', 'ssssss', '2019-11-18 19:57:52', 0);
INSERT INTO `sys_topic` VALUES (9, 'dddddd', 'asdfad', 'dddddd', '2019-11-18 20:53:13', 0);
INSERT INTO `sys_topic` VALUES (10, 'hhhhhhhh', 'lkhljl;kjas;djas;da;sdh;lfs;', 'cccccc', '2019-11-18 21:40:12', 1);
INSERT INTO `sys_topic` VALUES (12, '222', '阿斯顿发大水发的说法归属感方面，', '222', '2019-11-19 08:51:13', 0);
INSERT INTO `sys_topic` VALUES (13, '我是一个帖子', '红红火火恍恍惚惚红红火火恍恍惚惚红红火火恍恍惚惚', 'hjx', '2019-11-19 19:34:15', 2);

SET FOREIGN_KEY_CHECKS = 1;
