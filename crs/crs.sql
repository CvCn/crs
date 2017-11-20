/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50525
Source Host           : localhost:3306
Source Database       : crs

Target Server Type    : MYSQL
Target Server Version : 50525
File Encoding         : 65001

Date: 2017-11-20 10:47:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cars`
-- ----------------------------
DROP TABLE IF EXISTS `cars`;
CREATE TABLE `cars` (
  `carnumber` varchar(20) NOT NULL COMMENT '车号',
  `cartype` varchar(20) NOT NULL COMMENT '型号',
  `color` varchar(20) NOT NULL COMMENT '颜色',
  `price` double NOT NULL COMMENT '价值',
  `rentprice` double NOT NULL COMMENT '租金',
  `deposit` double NOT NULL COMMENT '押金',
  `isrenting` varchar(20) NOT NULL COMMENT '租用情况',
  `description` varchar(2000) NOT NULL COMMENT '简介',
  `imgpath` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`carnumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='汽车信息表';

-- ----------------------------
-- Records of cars
-- ----------------------------
INSERT INTO `cars` VALUES ('京BA2222', '凯迪拉克XLR', '橘黄', '1000000', '200', '100', '1', 'text', '京BA2222.gif');
INSERT INTO `cars` VALUES ('京BB0000', '凯迪拉克XLR', '橘黄', '1000000', '200', '100', '0', 'text', '京BB0000.gif');
INSERT INTO `cars` VALUES ('京BB1111', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB1233', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB1234', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB12345', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB2222', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB3333', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB4444', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB5555', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB6666', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB7777', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB8888', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BB9999', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF0000', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF1111', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF1233', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF1234', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF12345', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF2222', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF3333', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF4444', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF5555', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF6666', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');
INSERT INTO `cars` VALUES ('京BF8888', '123', '123', '3', '3', '3', '1', '13', '京BF8888.jpg');
INSERT INTO `cars` VALUES ('京BF9999', '凯迪拉克XLR', '枣红', '1000000', '200', '100', '0', 'text', '');

-- ----------------------------
-- Table structure for `checktable`
-- ----------------------------
DROP TABLE IF EXISTS `checktable`;
CREATE TABLE `checktable` (
  `checkid` bigint(20) NOT NULL,
  `checkdate` date NOT NULL,
  `field` varchar(100) DEFAULT NULL,
  `problem` varchar(100) DEFAULT NULL,
  `paying` double(10,2) DEFAULT NULL,
  `checkuser` varchar(20) NOT NULL,
  `rentid` bigint(20) NOT NULL,
  PRIMARY KEY (`checkid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checktable
-- ----------------------------
INSERT INTO `checktable` VALUES ('6257201711171511913', '2017-11-17', '', '', null, 'dome01', '2497201711171511490');

-- ----------------------------
-- Table structure for `customers`
-- ----------------------------
DROP TABLE IF EXISTS `customers`;
CREATE TABLE `customers` (
  `identity` varchar(20) NOT NULL COMMENT '身份证',
  `custname` varchar(10) NOT NULL COMMENT '姓名',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  `address` varchar(100) NOT NULL COMMENT '地址',
  `phone` varchar(20) NOT NULL COMMENT '电话',
  `career` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`identity`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of customers
-- ----------------------------
INSERT INTO `customers` VALUES ('1', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('11', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('111', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('12', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('121', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('13', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('130625193910243430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('1306251939211023430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('13062519392110243430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('130625199211023430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('130625199310243430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('1306251993211023430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('13062519932110243430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('130625319921143430', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('131', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('14', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('141', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('15', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('151', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('16', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('161', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('17', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('171', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('18', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('181', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('19', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('191', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('2', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('3', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('4', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('5', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('6', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('7', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('8', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');
INSERT INTO `customers` VALUES ('9', '王大柱', '男', '北京市海淀区幸福街道阳光小区3栋303', '15567865456', '流氓');

-- ----------------------------
-- Table structure for `funs`
-- ----------------------------
DROP TABLE IF EXISTS `funs`;
CREATE TABLE `funs` (
  `funid` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `uri` varchar(100) NOT NULL,
  `menuid` int(10) NOT NULL,
  PRIMARY KEY (`funid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of funs
-- ----------------------------
INSERT INTO `funs` VALUES ('111', '添加用户', 'addUser', '11');
INSERT INTO `funs` VALUES ('121', '查询用户', 'findUser', '12');
INSERT INTO `funs` VALUES ('122', '编辑用户', 'transUser', '12');
INSERT INTO `funs` VALUES ('123', '更新用户', 'updateUser', '12');
INSERT INTO `funs` VALUES ('124', '删除用户', 'deleteUser', '12');
INSERT INTO `funs` VALUES ('125', '更改用户密码', 'changePwd', '12');
INSERT INTO `funs` VALUES ('211', '添加客户', 'addCust', '21');
INSERT INTO `funs` VALUES ('221', '查询客户', 'findCust', '22');
INSERT INTO `funs` VALUES ('222', '更新客户', 'updateCust', '22');
INSERT INTO `funs` VALUES ('223', '删除客户', 'deleteCust', '22');
INSERT INTO `funs` VALUES ('224', '编辑客户', 'transCust', '22');
INSERT INTO `funs` VALUES ('311', '添加汽车', 'addCar', '31');
INSERT INTO `funs` VALUES ('321', '查询汽车', 'findCar', '32');
INSERT INTO `funs` VALUES ('322', '更新汽车', 'updateCar', '32');
INSERT INTO `funs` VALUES ('323', '删除汽车', 'deleteCar', '32');
INSERT INTO `funs` VALUES ('324', '编辑汽车', 'transCar', '32');
INSERT INTO `funs` VALUES ('411', '展示汽车', 'showCar', '41');
INSERT INTO `funs` VALUES ('412', '生成出租单', 'preCreateRentCarTable', '41');
INSERT INTO `funs` VALUES ('413', '创建出租单', 'createRentCarTable', '41');
INSERT INTO `funs` VALUES ('421', '还车(查询出租单,创建检查单)', 'findRenttable', '42');
INSERT INTO `funs` VALUES ('422', '创建检查单', 'createCheckTable', '42');
INSERT INTO `funs` VALUES ('431', '查询出租单', 'findRenttableBy', '43');
INSERT INTO `funs` VALUES ('432', '编辑出租单', 'transRenttable', '43');
INSERT INTO `funs` VALUES ('433', '更新出租单', 'updateRenttable', '43');
INSERT INTO `funs` VALUES ('441', '查询检查单', 'findChecktableBy', '44');
INSERT INTO `funs` VALUES ('442', '编辑检查单', 'transCheckid', '44');
INSERT INTO `funs` VALUES ('443', '更新检查单', 'updateChecktable', '44');
INSERT INTO `funs` VALUES ('511', '查询当月应还汽车', 'monthReturnCar', '51');
INSERT INTO `funs` VALUES ('512', '当月应还汽车详情', 'transTableid', '51');
INSERT INTO `funs` VALUES ('611', '查询角色', 'findRoleBy', '61');
INSERT INTO `funs` VALUES ('612', '编辑角色', 'transRole', '61');
INSERT INTO `funs` VALUES ('613', '更新角色', 'updateRole', '61');
INSERT INTO `funs` VALUES ('614', '删除角色', 'deleteRole', '62');
INSERT INTO `funs` VALUES ('621', '添加角色', 'addRole', '62');
INSERT INTO `funs` VALUES ('631', '查询操作日志', 'findOperationLogs', '63');
INSERT INTO `funs` VALUES ('641', '查询登陆日志', 'findLoginLogs', '64');

-- ----------------------------
-- Table structure for `loginlogs`
-- ----------------------------
DROP TABLE IF EXISTS `loginlogs`;
CREATE TABLE `loginlogs` (
  `loginlogid` int(10) NOT NULL AUTO_INCREMENT,
  `loginname` varchar(20) DEFAULT NULL,
  `loginip` varchar(100) DEFAULT NULL,
  `logintime` datetime DEFAULT NULL,
  PRIMARY KEY (`loginlogid`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of loginlogs
-- ----------------------------
INSERT INTO `loginlogs` VALUES ('63', 'dome01', '0:0:0:0:0:0:0:1', '2017-11-20 10:45:55');

-- ----------------------------
-- Table structure for `menus`
-- ----------------------------
DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus` (
  `menuid` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `uri` varchar(100) NOT NULL,
  `fatherid` int(10) NOT NULL,
  PRIMARY KEY (`menuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menus
-- ----------------------------
INSERT INTO `menus` VALUES ('1', '用户管理', '1', '0');
INSERT INTO `menus` VALUES ('2', '客户管理', '1', '0');
INSERT INTO `menus` VALUES ('3', '汽车管理', '1', '0');
INSERT INTO `menus` VALUES ('4', '业务管理', '1', '0');
INSERT INTO `menus` VALUES ('5', '业务统计', '1', '0');
INSERT INTO `menus` VALUES ('6', '系统管理', '1', '0');
INSERT INTO `menus` VALUES ('11', '添加用户', 'user/userManager/addUser', '1');
INSERT INTO `menus` VALUES ('12', '查询用户', 'user/userManager/findUser', '1');
INSERT INTO `menus` VALUES ('21', '添加客户信息', 'cust/custManager/addCustomers', '2');
INSERT INTO `menus` VALUES ('22', '查询客户信息', 'cust/custManager/findCustomers', '2');
INSERT INTO `menus` VALUES ('31', '添加汽车信息', 'car/carManager/addCar', '3');
INSERT INTO `menus` VALUES ('32', '查询汽车信息', 'car/carManager/findCar', '3');
INSERT INTO `menus` VALUES ('41', '汽车出租', 'operator/operatorManager/rentCar', '4');
INSERT INTO `menus` VALUES ('42', '汽车入库', 'operator/operatorManager/returnCar', '4');
INSERT INTO `menus` VALUES ('43', '出租单管理', 'operator/operatorManager/rentManager', '4');
INSERT INTO `menus` VALUES ('44', '检查单管理', 'operator/operatorManager/checkManager', '4');
INSERT INTO `menus` VALUES ('51', '当月应还汽车', 'monthReturnCar', '5');
INSERT INTO `menus` VALUES ('61', '角色管理', 'system/systemManager/roleManager', '6');
INSERT INTO `menus` VALUES ('62', '角色添加', 'system/systemManager/addRole', '6');
INSERT INTO `menus` VALUES ('63', '操作管理', 'system/systemManager/findLog', '6');
INSERT INTO `menus` VALUES ('64', '登陆管理', 'system/systemManager/findLoginInfo', '6');

-- ----------------------------
-- Table structure for `operation_logs`
-- ----------------------------
DROP TABLE IF EXISTS `operation_logs`;
CREATE TABLE `operation_logs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `action` varchar(100) DEFAULT NULL,
  `actiontime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of operation_logs
-- ----------------------------
INSERT INTO `operation_logs` VALUES ('1', 'dome01', '查询登陆日志', '2017-11-20 10:46:02');
INSERT INTO `operation_logs` VALUES ('2', 'dome01', '查询操作日志', '2017-11-20 10:46:10');
INSERT INTO `operation_logs` VALUES ('3', 'dome01', '查询操作日志', '2017-11-20 10:46:16');
INSERT INTO `operation_logs` VALUES ('4', 'dome01', '查询角色', '2017-11-20 10:46:31');
INSERT INTO `operation_logs` VALUES ('5', 'dome01', '查询操作日志', '2017-11-20 10:46:45');

-- ----------------------------
-- Table structure for `renttable`
-- ----------------------------
DROP TABLE IF EXISTS `renttable`;
CREATE TABLE `renttable` (
  `tableid` bigint(20) NOT NULL,
  `imprest` double(10,2) NOT NULL COMMENT '预付金',
  `shouldpayprice` double(10,2) NOT NULL COMMENT '应付金',
  `price` double(10,2) NOT NULL COMMENT '实际交付金额',
  `begindate` date NOT NULL COMMENT '起租日期',
  `shouldreturndate` date NOT NULL COMMENT '应归还日期',
  `returndate` date DEFAULT NULL COMMENT '归还日期',
  `rentflag` varchar(20) NOT NULL,
  `custid` varchar(20) NOT NULL,
  `carid` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`tableid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of renttable
-- ----------------------------
INSERT INTO `renttable` VALUES ('2497201711171511490', '2900.00', '2800.00', '2800.00', '2017-11-17', '2017-11-30', '2017-11-17', '1', '11', '京BA2222', 'dome01');
INSERT INTO `renttable` VALUES ('4807201711171611675', '500.00', '400.00', '111.00', '2017-11-17', '2017-11-18', null, '0', '1', '京BA2222', 'dome01');

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `roleid` int(10) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `uk_roles_rolename` (`rolename`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('2', '普通用户');
INSERT INTO `roles` VALUES ('1', '普通管理员');
INSERT INTO `roles` VALUES ('0', '系统管理员');
INSERT INTO `roles` VALUES ('3', '超级管理员');

-- ----------------------------
-- Table structure for `roles_funs`
-- ----------------------------
DROP TABLE IF EXISTS `roles_funs`;
CREATE TABLE `roles_funs` (
  `rmid` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) NOT NULL,
  `funid` int(10) NOT NULL,
  PRIMARY KEY (`rmid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_funs
-- ----------------------------

-- ----------------------------
-- Table structure for `roles_menus`
-- ----------------------------
DROP TABLE IF EXISTS `roles_menus`;
CREATE TABLE `roles_menus` (
  `rmid` int(10) NOT NULL AUTO_INCREMENT,
  `roleid` int(10) NOT NULL,
  `menuid` int(10) NOT NULL,
  PRIMARY KEY (`rmid`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_menus
-- ----------------------------
INSERT INTO `roles_menus` VALUES ('1', '0', '1');
INSERT INTO `roles_menus` VALUES ('2', '0', '2');
INSERT INTO `roles_menus` VALUES ('3', '0', '3');
INSERT INTO `roles_menus` VALUES ('4', '0', '4');
INSERT INTO `roles_menus` VALUES ('5', '0', '5');
INSERT INTO `roles_menus` VALUES ('6', '0', '6');
INSERT INTO `roles_menus` VALUES ('7', '0', '11');
INSERT INTO `roles_menus` VALUES ('8', '0', '12');
INSERT INTO `roles_menus` VALUES ('9', '0', '21');
INSERT INTO `roles_menus` VALUES ('10', '0', '22');
INSERT INTO `roles_menus` VALUES ('11', '0', '31');
INSERT INTO `roles_menus` VALUES ('12', '0', '32');
INSERT INTO `roles_menus` VALUES ('13', '0', '41');
INSERT INTO `roles_menus` VALUES ('14', '0', '42');
INSERT INTO `roles_menus` VALUES ('15', '0', '43');
INSERT INTO `roles_menus` VALUES ('16', '0', '44');
INSERT INTO `roles_menus` VALUES ('17', '0', '51');
INSERT INTO `roles_menus` VALUES ('18', '0', '61');
INSERT INTO `roles_menus` VALUES ('19', '0', '62');
INSERT INTO `roles_menus` VALUES ('20', '1', '1');
INSERT INTO `roles_menus` VALUES ('21', '1', '2');
INSERT INTO `roles_menus` VALUES ('22', '1', '3');
INSERT INTO `roles_menus` VALUES ('23', '1', '4');
INSERT INTO `roles_menus` VALUES ('24', '1', '5');
INSERT INTO `roles_menus` VALUES ('26', '1', '11');
INSERT INTO `roles_menus` VALUES ('27', '1', '12');
INSERT INTO `roles_menus` VALUES ('28', '1', '21');
INSERT INTO `roles_menus` VALUES ('29', '1', '22');
INSERT INTO `roles_menus` VALUES ('30', '1', '31');
INSERT INTO `roles_menus` VALUES ('31', '1', '32');
INSERT INTO `roles_menus` VALUES ('32', '1', '41');
INSERT INTO `roles_menus` VALUES ('33', '1', '42');
INSERT INTO `roles_menus` VALUES ('34', '1', '43');
INSERT INTO `roles_menus` VALUES ('35', '1', '44');
INSERT INTO `roles_menus` VALUES ('36', '1', '51');
INSERT INTO `roles_menus` VALUES ('39', '2', '1');
INSERT INTO `roles_menus` VALUES ('40', '2', '2');
INSERT INTO `roles_menus` VALUES ('42', '2', '11');
INSERT INTO `roles_menus` VALUES ('43', '2', '12');
INSERT INTO `roles_menus` VALUES ('44', '2', '21');
INSERT INTO `roles_menus` VALUES ('45', '2', '22');
INSERT INTO `roles_menus` VALUES ('46', '3', '1');
INSERT INTO `roles_menus` VALUES ('47', '3', '11');
INSERT INTO `roles_menus` VALUES ('48', '3', '12');
INSERT INTO `roles_menus` VALUES ('49', '3', '2');
INSERT INTO `roles_menus` VALUES ('50', '3', '21');
INSERT INTO `roles_menus` VALUES ('51', '3', '22');
INSERT INTO `roles_menus` VALUES ('52', '3', '3');
INSERT INTO `roles_menus` VALUES ('53', '3', '31');
INSERT INTO `roles_menus` VALUES ('54', '3', '32');
INSERT INTO `roles_menus` VALUES ('55', '3', '4');
INSERT INTO `roles_menus` VALUES ('56', '3', '41');
INSERT INTO `roles_menus` VALUES ('57', '3', '42');
INSERT INTO `roles_menus` VALUES ('58', '3', '43');
INSERT INTO `roles_menus` VALUES ('59', '3', '44');
INSERT INTO `roles_menus` VALUES ('60', '3', '5');
INSERT INTO `roles_menus` VALUES ('61', '3', '51');
INSERT INTO `roles_menus` VALUES ('62', '0', '63');
INSERT INTO `roles_menus` VALUES ('63', '0', '64');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(20) NOT NULL,
  `identity` varchar(20) NOT NULL,
  `fullname` varchar(20) NOT NULL,
  `sex` varchar(2) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `roleid` int(10) NOT NULL,
  `userpwd` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `uk_users` (`identity`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('dome01', '13948175133849577', 'dome01', '男', '北京市大兴区赛迪国际4楼', '15567876543', '0', '123123', '董事长');
INSERT INTO `users` VALUES ('dome02', '157876452736485', 'dome02', '女', '北京市海淀区', '17878655643', '0', '123123', '总监');
INSERT INTO `users` VALUES ('dome03', '18898975784', 'dome03', '男', '天津市和平区', '19876543211', '3', '123123', '业务总监');
INSERT INTO `users` VALUES ('dome05', '139481751338495774', 'dome01', '男', '北京市大兴区赛迪国际4楼', '15567876543', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome06', '1578764527364854', 'dome02', '女', '北京市海淀区', '17878655643', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome07', '188989757844', 'dome03', '男', '天津市和平区', '19876543211', '1', '123123', '业务总监');
INSERT INTO `users` VALUES ('dome08', '1150103948419283943', 'dome04', '男', '天津市南开区', '19898768987', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome11', '139481751338249577', 'dome11', '男', '北京市大兴区赛迪国际4楼', '15567876543', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome12', '1578726452736485', 'dome12', '女', '北京市海淀区', '17878655643', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome13', '188298975784', 'dome13', '男', '天津市和平区', '19876543211', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome14', '1125010394819283943', 'dome14', '男', '天津市南开区', '19898768987', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome21', '1394817513338249577', 'dome21', '男', '北京市大兴区赛迪国际4楼', '15567876543', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome22', '15787264532736485', 'dome22', '女', '北京市海淀区', '17878655643', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome23', '1882983975784', 'dome23', '男', '天津市和平区', '19876543211', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome24', '11250103394819283943', 'dome24', '男', '天津市南开区', '19898768987', '2', '123123', '业务');
INSERT INTO `users` VALUES ('dome31', '134817513338249577', 'dome31', '男', '北京市大兴区赛迪国际4楼', '15567876543', '2', '123123', '业务');
