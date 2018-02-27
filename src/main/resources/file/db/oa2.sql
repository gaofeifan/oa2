/*
Navicat MySQL Data Transfer

Source Server         : 10.0.0.18_3306
Source Server Version : 50632
Source Host           : 10.0.0.18:3306
Source Database       : oa2

Target Server Type    : MYSQL
Target Server Version : 50632
File Encoding         : 65001

Date: 2018-02-27 14:29:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for auth_agency
-- ----------------------------
DROP TABLE IF EXISTS `auth_agency`;
CREATE TABLE `auth_agency` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL COMMENT '公司id',
  `demp_id` int(11) DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `isdelete` int(11) DEFAULT '0' COMMENT '是否已删除  0 否 1 是',
  `grade_name` varchar(32) DEFAULT NULL COMMENT '级别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=188 DEFAULT CHARSET=utf8 COMMENT='机构权限表';

-- ----------------------------
-- Records of auth_agency
-- ----------------------------
INSERT INTO `auth_agency` VALUES ('1', '88', null, '1', '1', '一级机构');
INSERT INTO `auth_agency` VALUES ('2', '88', '108', '2', '1', '二级机构');
INSERT INTO `auth_agency` VALUES ('3', '88', '386', '3', '1', '三级机构');
INSERT INTO `auth_agency` VALUES ('4', '88', '387', '4', '1', '四级机构');
INSERT INTO `auth_agency` VALUES ('5', '112', null, '4', '1', '四级机构');
INSERT INTO `auth_agency` VALUES ('42', '88', '273', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('43', '88', '388', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('44', '112', null, '4', '1', null);
INSERT INTO `auth_agency` VALUES ('45', '112', null, '4', '1', null);
INSERT INTO `auth_agency` VALUES ('46', '88', '389', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('47', '88', '272', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('48', '1', '96', '1', '0', null);
INSERT INTO `auth_agency` VALUES ('49', '88', '276', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('50', '1', '96', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('51', '142', '385', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('52', '91', '141', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('53', '88', '104', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('54', '88', '104', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('55', '88', '104', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('56', '1', '96', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('57', '88', '108', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('58', '90', '316', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('59', '1', '97', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('60', '92', '169', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('61', '1', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('62', '1', '96', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('63', '1', '96', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('64', '1', '101', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('65', '1', '261', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('66', '1', '261', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('69', '1', null, '4', '1', null);
INSERT INTO `auth_agency` VALUES ('70', '91', '120', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('71', '88', '276', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('72', '88', '108', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('73', '1', null, '1', '1', null);
INSERT INTO `auth_agency` VALUES ('74', '88', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('75', '1', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('76', '1', null, '1', '1', null);
INSERT INTO `auth_agency` VALUES ('77', '1', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('78', '88', null, '1', '1', null);
INSERT INTO `auth_agency` VALUES ('79', '88', '278', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('80', '1', '98', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('81', '1', '97', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('82', '88', null, '1', '1', null);
INSERT INTO `auth_agency` VALUES ('83', '112', '252', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('84', '111', '306', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('85', '1', '97', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('86', '89', '235', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('87', '88', '273', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('88', '89', '234', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('89', '92', null, '1', '1', null);
INSERT INTO `auth_agency` VALUES ('90', '88', '387', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('91', '88', '389', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('92', '88', '276', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('93', '88', '275', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('94', '1', '101', '1', '1', null);
INSERT INTO `auth_agency` VALUES ('95', '1', '101', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('96', '1', '260', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('97', '1', '261', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('98', '91', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('99', '91', '120', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('100', '91', '122', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('101', '91', '141', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('102', '106', '153', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('103', '111', '306', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('104', '111', '306', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('105', '112', '252', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('106', '105', '115', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('107', '91', '122', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('108', '91', '141', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('109', '91', '122', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('110', '91', '141', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('111', '92', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('112', '92', '174', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('113', '92', '396', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('114', '91', '113', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('115', '92', null, '2', '1', null);
INSERT INTO `auth_agency` VALUES ('116', '92', '174', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('117', '92', '396', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('118', '161', '400', '2', '0', null);
INSERT INTO `auth_agency` VALUES ('119', '161', null, '3', '1', null);
INSERT INTO `auth_agency` VALUES ('120', '1', '408', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('121', '161', '400', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('122', '1', null, '3', '1', null);
INSERT INTO `auth_agency` VALUES ('123', '1', '407', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('124', '1', null, '4', '1', null);
INSERT INTO `auth_agency` VALUES ('125', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('126', '1', '408', '5', '1', null);
INSERT INTO `auth_agency` VALUES ('127', '1', '407', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('128', '1', '409', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('129', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('130', '1', '408', '5', '1', null);
INSERT INTO `auth_agency` VALUES ('131', '1', null, '4', '1', null);
INSERT INTO `auth_agency` VALUES ('132', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('133', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('134', '1', '407', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('135', '161', '401', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('136', '161', null, '3', '1', null);
INSERT INTO `auth_agency` VALUES ('137', '1', '408', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('138', '1', null, '3', '1', null);
INSERT INTO `auth_agency` VALUES ('139', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('140', '161', '400', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('141', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('142', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('143', '1', '408', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('144', '161', '402', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('145', '1', '407', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('146', '161', '401', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('147', '1', '408', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('148', '1', '411', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('149', '1', '409', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('150', '1', '409', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('151', '161', '400', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('152', '1', null, '3', '1', null);
INSERT INTO `auth_agency` VALUES ('153', '1', null, '4', '1', null);
INSERT INTO `auth_agency` VALUES ('154', '1', '407', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('155', '1', '96', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('156', '1', '408', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('157', '161', '401', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('158', '1', '407', '4', '1', null);
INSERT INTO `auth_agency` VALUES ('159', '1', '96', '3', '1', null);
INSERT INTO `auth_agency` VALUES ('160', '1', '407', '1', '0', null);
INSERT INTO `auth_agency` VALUES ('161', '1', '408', '1', '0', null);
INSERT INTO `auth_agency` VALUES ('162', '1', '409', '1', '0', null);
INSERT INTO `auth_agency` VALUES ('163', '1', '410', '1', '0', null);
INSERT INTO `auth_agency` VALUES ('164', '1', '411', '1', '0', null);
INSERT INTO `auth_agency` VALUES ('165', '161', null, '1', '0', null);
INSERT INTO `auth_agency` VALUES ('166', '161', '401', '2', '0', null);
INSERT INTO `auth_agency` VALUES ('167', '161', '402', '2', '0', null);
INSERT INTO `auth_agency` VALUES ('168', '161', '404', '2', '0', null);
INSERT INTO `auth_agency` VALUES ('169', '161', '403', '2', '1', null);
INSERT INTO `auth_agency` VALUES ('170', '161', '405', '3', '0', null);
INSERT INTO `auth_agency` VALUES ('171', '161', '406', '3', '0', null);
INSERT INTO `auth_agency` VALUES ('172', '162', null, '2', '0', null);
INSERT INTO `auth_agency` VALUES ('173', '163', null, '2', '0', null);
INSERT INTO `auth_agency` VALUES ('174', '164', null, '2', '0', null);
INSERT INTO `auth_agency` VALUES ('175', '165', null, '3', '0', null);
INSERT INTO `auth_agency` VALUES ('176', '165', '412', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('177', '165', '413', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('178', '165', '414', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('179', '165', '415', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('180', '165', '416', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('181', '165', '417', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('182', '165', '418', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('183', '165', '419', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('184', '165', '420', '4', '0', null);
INSERT INTO `auth_agency` VALUES ('185', '162', null, '1', '1', null);
INSERT INTO `auth_agency` VALUES ('186', '161', '421', '2', '0', null);
INSERT INTO `auth_agency` VALUES ('187', '161', '403', '2', '0', null);

-- ----------------------------
-- Table structure for auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `auth_menu`;
CREATE TABLE `auth_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '菜单名称',
  `img` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `href` varchar(255) DEFAULT NULL COMMENT '跳转地址',
  `fid` int(11) DEFAULT NULL COMMENT '父节点菜单ID',
  `grade` int(11) DEFAULT NULL COMMENT '菜单等级',
  `auth` int(11) DEFAULT NULL COMMENT '是否需要设置权限0为不需要1为需要设置权限',
  `post` int(11) DEFAULT NULL COMMENT '是否需要岗位1为需要，0为不需要',
  `groupby` int(11) DEFAULT NULL,
  `default_auth` int(11) DEFAULT '0' COMMENT '默认权限（0：没有，1：有）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
-- Records of auth_menu
-- ----------------------------
INSERT INTO `auth_menu` VALUES ('1', '工作台', 'http://139.129.236.180:81/20170706151748800528/desk.png', '#/Mywork', null, '1', '0', '0', null, null);
INSERT INTO `auth_menu` VALUES ('2', '我的', 'http://139.129.236.180:81/20170706151810604695/approval.png', '#/Myapply', null, '1', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('3', '个人中心', 'http://139.129.236.180:81/20170706151830397288/center.png', '#/MyaccountSettings', null, '1', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('4', '待办管理', 'http://139.129.236.180:81/20170706151851946276/message.png', '#/Myrecruit-handle', null, '1', '1', '1', null, null);
INSERT INTO `auth_menu` VALUES ('5', '系统管理', 'http://139.129.236.180:81/20170706151914673927/administration1.png', '#/Mybusiness', null, '1', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('6', '权限管理', 'http://139.129.236.180:81/20170706151932335158/administration2.png', '#/agencyAuthority', null, '1', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('7', '我的申请', null, '#/Myapply', '2', '2', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('8', '我的审批', null, '#/Myapproval', '2', '2', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('9', '我的消息', null, '#/Mynews', '2', '2', '1', '0', null, '0');
INSERT INTO `auth_menu` VALUES ('10', '审批查询', null, '#/Myquery', '2', '2', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('11', '账号设置', null, '#/MyaccountSettings', '3', '2', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('12', '招聘待办', null, '#/Myrecruit-handle', '4', '2', '1', '1', null, null);
INSERT INTO `auth_menu` VALUES ('13', '建档待办', null, '#/Myfiling', '4', '2', '1', '1', null, null);
INSERT INTO `auth_menu` VALUES ('14', '企业管理', null, '#/Mybusiness', '5', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('15', '部门管理', null, '#/Mydepartment', '5', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('16', '岗位管理', null, '#/Mypost', '5', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('17', '职位管理', null, '#/Myjob', '5', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('18', '员工管理', null, '#/Mystaff', '5', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('19', '账号管理', null, '#/Myaccount', '5', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('20', '机构权限管理', null, '#/agencyAuthority', '6', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('21', '权限管理', null, '#/Myadmin', '6', '2', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('23', '新建招聘申请', null, null, '7', '3', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('25', '管理账号管理', null, null, '11', '3', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('27', '管理企业设置', null, null, '14', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('29', '管理部门设置', null, null, '15', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('31', '管理岗位设置', null, null, '16', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('33', '管理职位设置', null, null, '17', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('35', '管理员工设置', null, null, '18', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('37', '管理账号设置', null, null, '19', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('39', '管理机构设置', null, null, '20', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('41', '管理权限设置', null, null, '21', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('43', '管理招聘待办', null, null, '12', '3', '1', '1', null, null);
INSERT INTO `auth_menu` VALUES ('45', '管理建档待办', null, null, '13', '3', '1', '1', null, null);
INSERT INTO `auth_menu` VALUES ('46', '查看所有消息', null, null, '9', '3', '1', '0', null, null);
INSERT INTO `auth_menu` VALUES ('47', '查看我的审批', null, null, '8', '3', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('48', '查看我的消息', null, null, '9', '3', '1', '0', null, '1');
INSERT INTO `auth_menu` VALUES ('49', '查看审批查询', null, null, '10', '3', '1', '0', null, '1');

-- ----------------------------
-- Table structure for auth_user
-- ----------------------------
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户ID',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单ID',
  `companyid` int(11) DEFAULT NULL,
  `dempid` int(11) DEFAULT NULL,
  `postid` int(11) DEFAULT NULL COMMENT '岗位ID',
  `post_sign_num` varchar(200) DEFAULT NULL COMMENT '组合机构代码',
  `menuids` varchar(200) DEFAULT NULL COMMENT '菜单id(从第一级到第三级)',
  `type` varchar(20) DEFAULT NULL COMMENT '判断是菜单权限:menu还是岗位:post',
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `postid` (`postid`),
  CONSTRAINT `auth_user_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `t_user` (`id`),
  CONSTRAINT `auth_user_ibfk_2` FOREIGN KEY (`postid`) REFERENCES `t_post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77434 DEFAULT CHARSET=utf8 COMMENT='菜单权限表';

-- ----------------------------
-- Records of auth_user
-- ----------------------------
INSERT INTO `auth_user` VALUES ('73285', '388', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('73286', '388', '46', null, null, null, null, '2-9-46', 'menu');
INSERT INTO `auth_user` VALUES ('73287', '388', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('73288', '388', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('73290', '388', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('73291', '388', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('73292', '388', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('73293', '388', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('73294', '388', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('73295', '388', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('73472', '430', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('73473', '430', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('73475', '430', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('73479', '430', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('73480', '430', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('73500', '430', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('73501', '430', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('73502', '430', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('73503', '430', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('73504', '430', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('73505', '430', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('73512', '430', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('73513', '430', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('73522', '432', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('73523', '432', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('73525', '432', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('73526', '432', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('73527', '432', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('73534', '432', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('73535', '432', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('73536', '432', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('73537', '432', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('73538', '432', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('73539', '432', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('73540', '428', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('73541', '428', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('73542', '428', '46', null, null, null, null, '2-9-46', 'menu');
INSERT INTO `auth_user` VALUES ('73543', '428', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('73544', '428', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('73546', '428', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('73547', '428', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('73548', '428', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('73549', '428', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('73550', '428', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('73551', '428', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('73552', '388', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('73564', '397', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('73565', '397', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('73566', '397', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('73567', '397', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('73568', '397', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('73569', '397', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('73570', '397', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('73571', '397', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('73572', '399', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('73750', '388', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('73755', '433', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('74109', '457', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('74110', '457', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('74111', '457', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('74112', '457', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('74113', '457', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('74114', '457', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('74117', '475', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('74118', '475', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('74127', '485', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('74128', '485', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('74129', '485', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('74130', '485', '29', null, null, null, null, '5-15-29', 'menu');
INSERT INTO `auth_user` VALUES ('74131', '485', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('74132', '485', '33', null, null, null, null, '5-17-33', 'menu');
INSERT INTO `auth_user` VALUES ('74133', '485', '35', null, null, null, null, '5-18-35', 'menu');
INSERT INTO `auth_user` VALUES ('74134', '485', '37', null, null, null, null, '5-19-37', 'menu');
INSERT INTO `auth_user` VALUES ('74135', '486', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('74136', '486', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('74137', '477', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('74138', '477', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('74139', '421', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('74140', '421', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('74141', '421', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74339', '397', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74340', '397', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74341', '397', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74342', '397', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74343', '397', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74344', '398', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74345', '398', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74346', '398', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74347', '398', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74348', '398', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74349', '399', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74350', '399', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74351', '399', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74352', '399', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74353', '400', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74354', '400', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74355', '400', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74356', '400', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74357', '400', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74358', '401', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74359', '401', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74360', '401', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74361', '401', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74362', '401', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74363', '402', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74364', '402', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74365', '402', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74366', '402', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74367', '402', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74368', '403', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74369', '403', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74370', '403', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74371', '403', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74372', '403', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74373', '404', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74374', '404', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74375', '404', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74376', '404', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74377', '404', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74378', '405', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74379', '405', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74380', '405', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74381', '405', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74382', '405', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74383', '406', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74384', '406', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74385', '406', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74386', '406', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74387', '406', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74388', '407', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74389', '407', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74390', '407', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74391', '407', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74392', '407', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74393', '408', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74394', '408', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74395', '408', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74396', '408', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74397', '408', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74398', '409', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74399', '409', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74400', '409', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74401', '409', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74402', '409', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74403', '410', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74404', '410', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74405', '410', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74406', '410', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74407', '410', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74408', '411', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74409', '411', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74410', '411', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74411', '411', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74412', '411', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74413', '412', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74414', '412', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74415', '412', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74416', '412', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74417', '412', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74418', '413', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74419', '413', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74420', '413', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74421', '413', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74422', '413', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74423', '414', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74424', '414', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74425', '414', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74426', '414', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74427', '414', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74428', '415', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74429', '415', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74430', '415', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74431', '415', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74432', '415', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74433', '416', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74434', '416', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74435', '416', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74436', '416', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74437', '416', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74438', '417', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74439', '417', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74440', '417', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74441', '417', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74442', '417', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74443', '418', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74444', '418', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74445', '418', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74446', '418', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74447', '418', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74448', '419', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74449', '419', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74450', '419', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74451', '419', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74452', '419', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74453', '420', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74454', '420', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74455', '420', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74456', '420', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74457', '420', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74458', '421', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74459', '421', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74460', '421', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74461', '421', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74462', '422', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74463', '422', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74464', '422', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74465', '422', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74466', '422', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74467', '423', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74468', '423', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74469', '423', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74470', '423', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74471', '423', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74472', '424', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74473', '424', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74474', '424', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74475', '424', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74476', '424', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74477', '425', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74478', '425', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74479', '425', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74480', '425', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74481', '425', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74482', '426', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74483', '426', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74484', '426', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74485', '426', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74486', '426', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74487', '427', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74488', '427', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74489', '427', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74490', '427', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74491', '427', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74492', '429', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74493', '429', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74494', '429', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74495', '429', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74496', '429', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74497', '431', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74498', '431', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74499', '431', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74500', '431', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74501', '431', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74502', '433', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74503', '434', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74504', '434', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74505', '434', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74506', '434', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74507', '434', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74508', '435', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74509', '435', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74510', '435', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74511', '435', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74512', '435', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74513', '436', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74514', '436', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74515', '436', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74516', '436', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74517', '436', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74518', '437', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74519', '437', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74520', '437', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74521', '437', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74522', '437', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74523', '438', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74524', '438', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74525', '438', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74526', '438', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74527', '438', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74528', '439', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74529', '439', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74530', '439', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74531', '439', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74532', '439', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74533', '440', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74534', '440', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74535', '440', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74536', '440', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74537', '440', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74538', '441', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74539', '441', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74540', '441', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74541', '441', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74542', '441', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74543', '442', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74544', '442', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74545', '442', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74546', '442', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74547', '442', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74548', '443', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74549', '443', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74550', '443', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74551', '443', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74552', '443', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74553', '445', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74554', '445', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74555', '445', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74556', '445', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74557', '445', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74558', '446', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74559', '446', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74560', '446', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74561', '446', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74562', '446', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74563', '447', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74564', '447', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74565', '447', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74566', '447', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74567', '447', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74568', '448', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74569', '448', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74570', '448', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74571', '448', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74572', '448', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74573', '449', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74574', '449', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74575', '449', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74576', '449', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74577', '449', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74578', '450', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74579', '450', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74580', '450', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74581', '450', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74582', '450', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74583', '451', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74584', '451', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74585', '451', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74586', '451', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74587', '451', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74588', '452', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74589', '452', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74590', '452', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74591', '452', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74592', '452', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74593', '453', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74594', '453', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74595', '453', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74596', '453', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74597', '453', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74598', '454', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74599', '454', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74600', '454', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74601', '454', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74602', '454', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74603', '455', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74604', '455', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74605', '455', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74606', '455', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74607', '455', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74608', '456', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74609', '456', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74610', '456', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74611', '456', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74612', '456', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74613', '457', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74614', '457', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74615', '457', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74616', '457', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74617', '457', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74618', '458', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74619', '458', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74620', '458', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74621', '458', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74622', '458', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74623', '459', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74624', '459', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74625', '459', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74626', '459', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74627', '459', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74628', '460', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74629', '460', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74630', '460', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74631', '460', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74632', '460', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74633', '461', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74634', '461', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74635', '461', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74636', '461', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74637', '461', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74638', '462', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74639', '462', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74640', '462', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74641', '462', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74642', '462', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74643', '463', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74644', '463', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74645', '463', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74646', '463', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74647', '463', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74648', '464', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74649', '464', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74650', '464', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74651', '464', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74652', '464', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74653', '465', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74654', '465', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74655', '465', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74656', '465', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74657', '465', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74658', '466', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74659', '466', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74660', '466', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74661', '466', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74662', '466', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74663', '467', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74664', '467', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74665', '467', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74666', '467', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74667', '467', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74668', '468', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74669', '468', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74670', '468', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74671', '468', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74672', '468', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74673', '469', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74674', '469', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74675', '469', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74676', '469', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74677', '469', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74678', '470', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74679', '470', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74680', '470', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74681', '470', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74682', '470', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74683', '471', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74684', '471', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74685', '471', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74686', '471', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74687', '471', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74688', '473', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74689', '473', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74690', '473', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74691', '473', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74692', '473', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74693', '474', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74694', '474', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74695', '474', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74696', '474', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74697', '474', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74698', '475', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74699', '475', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74700', '475', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74701', '475', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74702', '475', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74703', '476', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74704', '476', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74705', '476', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74706', '476', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74707', '476', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74708', '477', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74709', '477', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74710', '477', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74711', '477', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74712', '477', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74713', '478', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74714', '478', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74715', '478', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74716', '478', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74717', '478', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74718', '479', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74719', '479', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74720', '479', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74721', '479', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74722', '479', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74723', '480', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74724', '480', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74725', '480', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74726', '480', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74727', '480', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74728', '481', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74729', '481', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74730', '481', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74731', '481', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74732', '481', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74733', '482', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74734', '482', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74735', '482', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74736', '482', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74737', '482', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74738', '483', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74739', '483', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74740', '483', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74741', '483', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74742', '483', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74743', '484', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74744', '484', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74745', '484', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74746', '484', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74747', '484', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74748', '485', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74749', '485', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74750', '485', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74751', '485', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74752', '485', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74753', '486', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74754', '486', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74755', '486', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74756', '486', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74757', '486', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74758', '487', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74759', '487', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74760', '487', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74761', '487', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74762', '487', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74763', '488', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74764', '488', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74765', '488', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74766', '488', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74767', '488', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74768', '489', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('74769', '489', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('74770', '489', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('74771', '489', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('74772', '489', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('74955', '489', '46', null, null, null, null, '2-9-46', 'menu');
INSERT INTO `auth_user` VALUES ('75670', '388', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('75671', '388', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('75672', '489', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('75673', '489', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('75674', '464', '39', null, null, null, null, '6-20-39', 'menu');
INSERT INTO `auth_user` VALUES ('75675', '464', '41', null, null, null, null, '6-21-41', 'menu');
INSERT INTO `auth_user` VALUES ('76554', '433', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('76555', '433', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('76557', '433', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('76558', '433', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('76777', '433', '31', null, null, null, null, '5-16-31', 'menu');
INSERT INTO `auth_user` VALUES ('76990', '428', '27', null, null, null, null, '5-14-27', 'menu');
INSERT INTO `auth_user` VALUES ('77057', '433', '43', '1', null, '11212', 'CO0001-ST0098', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77058', '433', '43', '1', null, '11213', 'CO0001-ST0099', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77059', '433', '43', '1', '96', '79', 'CO0001-DEMP0001-ST0031', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77060', '433', '43', '1', '96', '11215', 'CO0001-DEMP0001-ST0101', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77061', '433', '43', '1', '407', '11216', 'CO0001-DEMP0009-ST0102', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77062', '433', '43', '1', '408', '11214', 'CO0001-DEMP0010-ST0100', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77063', '433', '43', '1', '408', '11220', 'CO0001-DEMP0010-ST0106', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77064', '433', '43', '1', '408', '11221', 'CO0001-DEMP0010-ST0107', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77065', '433', '43', '1', '408', '11222', 'CO0001-DEMP0010-ST0108', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77066', '433', '43', '1', '408', '11223', 'CO0001-DEMP0010-ST0109', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77067', '433', '43', '1', '409', '11204', 'CO0001-DEMP0011-ST0090', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77068', '433', '43', '1', '409', '11205', 'CO0001-DEMP0011-ST0091', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77069', '433', '43', '1', '409', '11206', 'CO0001-DEMP0011-ST0092', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77070', '433', '43', '1', '409', '11207', 'CO0001-DEMP0011-ST0093', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77071', '433', '43', '1', '409', '11208', 'CO0001-DEMP0011-ST0094', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77072', '433', '43', '1', '409', '11209', 'CO0001-DEMP0011-ST0095', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77073', '433', '43', '1', '409', '11210', 'CO0001-DEMP0011-ST0096', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77074', '433', '43', '1', '409', '11211', 'CO0001-DEMP0011-ST0097', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77075', '433', '43', '1', '410', '11217', 'CO0001-DEMP0012-ST0103', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77076', '433', '43', '1', '410', '11218', 'CO0001-DEMP0012-ST0104', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77077', '433', '43', '1', '411', '11219', 'CO0001-DEMP0013-ST0105', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77078', '433', '43', '161', null, '11227', 'CO0001-CO0002-ST0113', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77079', '433', '43', '161', null, '11228', 'CO0001-CO0002-ST0114', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77080', '433', '43', '161', null, '11243', 'CO0001-CO0002-ST0129', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77081', '433', '43', '161', null, '11244', 'CO0001-CO0002-ST0130', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77082', '433', '43', '161', '400', '11170', 'CO0001-CO0002-DEMP0002-ST0056', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77083', '433', '43', '161', '400', '11175', 'CO0001-CO0002-DEMP0002-ST0061', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77084', '433', '43', '161', '405', '11181', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0067', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77085', '433', '43', '161', '406', '11176', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0062', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77086', '433', '43', '161', '406', '11177', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0063', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77087', '433', '43', '161', '406', '11178', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0064', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77088', '433', '43', '161', '406', '11179', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0065', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77089', '433', '43', '161', '406', '11180', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0066', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77090', '433', '43', '161', '401', '11186', 'CO0001-CO0002-DEMP0003-ST0072', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77091', '433', '43', '161', '401', '11187', 'CO0001-CO0002-DEMP0003-ST0073', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77092', '433', '43', '161', '401', '11188', 'CO0001-CO0002-DEMP0003-ST0074', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77093', '433', '43', '161', '401', '11189', 'CO0001-CO0002-DEMP0003-ST0075', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77094', '433', '43', '161', '401', '11190', 'CO0001-CO0002-DEMP0003-ST0076', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77095', '433', '43', '161', '401', '11191', 'CO0001-CO0002-DEMP0003-ST0077', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77096', '433', '43', '161', '401', '11192', 'CO0001-CO0002-DEMP0003-ST0078', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77097', '433', '43', '161', '401', '11193', 'CO0001-CO0002-DEMP0003-ST0079', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77098', '433', '43', '161', '401', '11194', 'CO0001-CO0002-DEMP0003-ST0080', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77099', '433', '43', '161', '402', '11195', 'CO0001-CO0002-DEMP0004-ST0081', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77100', '433', '43', '161', '402', '11196', 'CO0001-CO0002-DEMP0004-ST0082', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77101', '433', '43', '161', '402', '11197', 'CO0001-CO0002-DEMP0004-ST0083', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77102', '433', '43', '161', '403', '11198', 'CO0001-CO0002-DEMP0005-ST0084', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77103', '433', '43', '161', '403', '11199', 'CO0001-CO0002-DEMP0005-ST0085', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77104', '433', '43', '161', '403', '11238', 'CO0001-CO0002-DEMP0005-ST0124', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77105', '433', '43', '161', '404', '11200', 'CO0001-CO0002-DEMP0006-ST0086', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77106', '433', '43', '161', '404', '11201', 'CO0001-CO0002-DEMP0006-ST0087', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77107', '433', '43', '161', '404', '11202', 'CO0001-CO0002-DEMP0006-ST0088', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77108', '433', '43', '161', '404', '11203', 'CO0001-CO0002-DEMP0006-ST0089', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77109', '433', '43', '161', '421', '11242', 'CO0001-CO0002-DEMP0023-ST0128', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77110', '433', '43', '161', '421', '11245', 'CO0001-CO0002-DEMP0023-ST0131', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77111', '433', '43', '162', null, '11146', 'CO0001-CO0002-CO0003-ST0032', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77112', '433', '43', '165', null, '11147', 'CO0001-CO0002-CO0003-CO0006-ST0033', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77113', '433', '43', '165', null, '11148', 'CO0001-CO0002-CO0003-CO0006-ST0034', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77114', '433', '43', '165', null, '11235', 'CO0001-CO0002-CO0003-CO0006-ST0121', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77115', '433', '43', '165', '412', '11149', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0035', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77116', '433', '43', '165', '412', '11150', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0036', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77117', '433', '43', '165', '412', '11151', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0037', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77118', '433', '43', '165', '412', '11152', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0038', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77119', '433', '43', '165', '412', '11239', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0125', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77120', '433', '43', '165', '412', '11240', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0126', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77121', '433', '43', '165', '412', '11241', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0127', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77122', '433', '43', '165', '413', '11156', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0042', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77123', '433', '43', '165', '413', '11157', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0043', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77124', '433', '43', '165', '413', '11158', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0044', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77125', '433', '43', '165', '414', '11159', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0045', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77126', '433', '43', '165', '414', '11160', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0046', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77127', '433', '43', '165', '414', '11236', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0122', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77128', '433', '43', '165', '415', '11161', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0047', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77129', '433', '43', '165', '415', '11224', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0110', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77130', '433', '43', '165', '415', '11225', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0111', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77131', '433', '43', '165', '416', '11162', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0048', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77132', '433', '43', '165', '416', '11163', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0049', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77133', '433', '43', '165', '416', '11164', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0050', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77134', '433', '43', '165', '416', '11237', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0123', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77135', '433', '43', '165', '417', '11165', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0051', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77136', '433', '43', '165', '417', '11166', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0052', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77137', '433', '43', '165', '418', '11167', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0053', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77138', '433', '43', '165', '418', '11168', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0054', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77139', '433', '43', '165', '418', '11169', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0055', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77140', '433', '43', '165', '419', '11226', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0112', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77141', '433', '43', '165', '419', '11232', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0118', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77142', '433', '43', '165', '419', '11233', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0119', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77143', '433', '43', '165', '419', '11234', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0120', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77144', '433', '43', '165', '420', '11153', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0039', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77145', '433', '43', '165', '420', '11154', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0040', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77146', '433', '43', '165', '420', '11155', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0041', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77147', '432', '45', '1', '96', '79', 'CO0001-DEMP0001-ST0031', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77148', '432', '45', '162', null, '11146', 'CO0001-CO0002-CO0003-ST0032', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77149', '432', '45', '165', null, '11147', 'CO0001-CO0002-CO0003-CO0006-ST0033', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77150', '432', '45', '165', null, '11148', 'CO0001-CO0002-CO0003-CO0006-ST0034', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77151', '432', '45', '165', '412', '11149', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0035', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77152', '432', '45', '165', '412', '11150', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0036', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77153', '432', '45', '165', '412', '11151', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0037', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77154', '432', '45', '165', '412', '11152', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0038', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77155', '432', '45', '165', '420', '11153', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0039', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77156', '432', '45', '165', '420', '11154', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0040', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77157', '432', '45', '165', '420', '11155', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0041', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77158', '432', '45', '165', '413', '11156', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0042', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77159', '432', '45', '165', '413', '11157', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0043', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77160', '432', '45', '165', '413', '11158', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0044', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77161', '432', '45', '165', '414', '11159', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0045', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77162', '432', '45', '165', '414', '11160', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0046', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77163', '432', '45', '165', '415', '11161', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0047', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77164', '432', '45', '165', '416', '11162', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0048', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77165', '432', '45', '165', '416', '11163', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0049', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77166', '432', '45', '165', '416', '11164', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0050', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77167', '432', '45', '165', '417', '11165', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0051', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77168', '432', '45', '165', '417', '11166', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0052', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77169', '432', '45', '165', '418', '11167', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0053', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77170', '432', '45', '165', '418', '11168', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0054', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77171', '432', '45', '165', '418', '11169', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0055', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77172', '432', '45', '161', '400', '11170', 'CO0001-CO0002-DEMP0002-ST0056', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77173', '432', '45', '161', '400', '11175', 'CO0001-CO0002-DEMP0002-ST0061', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77174', '432', '45', '161', '406', '11176', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0062', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77175', '432', '45', '161', '406', '11177', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0063', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77176', '432', '45', '161', '406', '11178', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0064', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77177', '432', '45', '161', '406', '11179', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0065', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77178', '432', '45', '161', '406', '11180', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0066', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77179', '432', '45', '161', '405', '11181', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0067', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77180', '432', '45', '161', '401', '11186', 'CO0001-CO0002-DEMP0003-ST0072', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77181', '432', '45', '161', '401', '11187', 'CO0001-CO0002-DEMP0003-ST0073', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77182', '432', '45', '161', '401', '11188', 'CO0001-CO0002-DEMP0003-ST0074', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77183', '432', '45', '161', '401', '11189', 'CO0001-CO0002-DEMP0003-ST0075', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77184', '432', '45', '161', '401', '11190', 'CO0001-CO0002-DEMP0003-ST0076', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77185', '432', '45', '161', '401', '11191', 'CO0001-CO0002-DEMP0003-ST0077', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77186', '432', '45', '161', '401', '11192', 'CO0001-CO0002-DEMP0003-ST0078', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77187', '432', '45', '161', '401', '11193', 'CO0001-CO0002-DEMP0003-ST0079', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77188', '432', '45', '161', '401', '11194', 'CO0001-CO0002-DEMP0003-ST0080', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77189', '432', '45', '161', '402', '11195', 'CO0001-CO0002-DEMP0004-ST0081', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77190', '432', '45', '161', '402', '11196', 'CO0001-CO0002-DEMP0004-ST0082', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77191', '432', '45', '161', '402', '11197', 'CO0001-CO0002-DEMP0004-ST0083', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77192', '432', '45', '161', '403', '11198', 'CO0001-CO0002-DEMP0005-ST0084', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77193', '432', '45', '161', '403', '11199', 'CO0001-CO0002-DEMP0005-ST0085', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77194', '432', '45', '161', '404', '11200', 'CO0001-CO0002-DEMP0006-ST0086', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77195', '432', '45', '161', '404', '11201', 'CO0001-CO0002-DEMP0006-ST0087', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77196', '432', '45', '161', '404', '11202', 'CO0001-CO0002-DEMP0006-ST0088', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77197', '432', '45', '161', '404', '11203', 'CO0001-CO0002-DEMP0006-ST0089', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77198', '432', '45', '1', '409', '11204', 'CO0001-DEMP0011-ST0090', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77199', '432', '45', '1', '409', '11205', 'CO0001-DEMP0011-ST0091', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77200', '432', '45', '1', '409', '11206', 'CO0001-DEMP0011-ST0092', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77201', '432', '45', '1', '409', '11207', 'CO0001-DEMP0011-ST0093', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77202', '432', '45', '1', '409', '11208', 'CO0001-DEMP0011-ST0094', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77203', '432', '45', '1', '409', '11209', 'CO0001-DEMP0011-ST0095', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77204', '432', '45', '1', '409', '11210', 'CO0001-DEMP0011-ST0096', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77205', '432', '45', '1', '409', '11211', 'CO0001-DEMP0011-ST0097', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77206', '432', '45', '1', null, '11212', 'CO0001-ST0098', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77207', '432', '45', '1', null, '11213', 'CO0001-ST0099', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77208', '432', '45', '1', '408', '11214', 'CO0001-DEMP0010-ST0100', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77209', '432', '45', '1', '96', '11215', 'CO0001-DEMP0001-ST0101', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77210', '432', '45', '1', '407', '11216', 'CO0001-DEMP0009-ST0102', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77211', '432', '45', '1', '410', '11217', 'CO0001-DEMP0012-ST0103', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77212', '432', '45', '1', '410', '11218', 'CO0001-DEMP0012-ST0104', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77213', '432', '45', '1', '411', '11219', 'CO0001-DEMP0013-ST0105', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77214', '432', '45', '1', '408', '11220', 'CO0001-DEMP0010-ST0106', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77215', '432', '45', '1', '408', '11221', 'CO0001-DEMP0010-ST0107', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77216', '432', '45', '1', '408', '11222', 'CO0001-DEMP0010-ST0108', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77217', '432', '45', '1', '408', '11223', 'CO0001-DEMP0010-ST0109', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77218', '432', '45', '165', '415', '11224', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0110', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77219', '432', '45', '165', '415', '11225', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0111', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77220', '432', '45', '165', '419', '11226', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0112', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77221', '432', '45', '161', null, '11227', 'CO0001-CO0002-ST0113', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77222', '432', '45', '161', null, '11228', 'CO0001-CO0002-ST0114', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77223', '432', '45', '165', '419', '11232', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0118', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77224', '432', '45', '165', '419', '11233', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0119', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77225', '432', '45', '165', '419', '11234', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0120', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77226', '432', '45', '165', null, '11235', 'CO0001-CO0002-CO0003-CO0006-ST0121', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77227', '432', '45', '165', '414', '11236', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0122', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77228', '432', '45', '165', '416', '11237', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0123', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77229', '432', '45', '161', '403', '11238', 'CO0001-CO0002-DEMP0005-ST0124', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77230', '432', '45', '165', '412', '11239', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0125', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77231', '432', '45', '165', '412', '11240', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0126', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77232', '432', '45', '165', '412', '11241', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0127', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77233', '432', '45', '161', '421', '11242', 'CO0001-CO0002-DEMP0023-ST0128', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77234', '432', '45', '161', null, '11243', 'CO0001-CO0002-ST0129', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77235', '432', '45', '161', null, '11244', 'CO0001-CO0002-ST0130', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77236', '432', '45', '161', '421', '11245', 'CO0001-CO0002-DEMP0023-ST0131', '4-13-45', 'post');
INSERT INTO `auth_user` VALUES ('77237', '808', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('77238', '808', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('77239', '808', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('77240', '808', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('77241', '808', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('77242', '809', '23', null, null, null, null, '2-7-23', 'menu');
INSERT INTO `auth_user` VALUES ('77243', '809', '25', null, null, null, null, '3-11-25', 'menu');
INSERT INTO `auth_user` VALUES ('77244', '809', '47', null, null, null, null, '2-8-47', 'menu');
INSERT INTO `auth_user` VALUES ('77245', '809', '48', null, null, null, null, '2-9-48', 'menu');
INSERT INTO `auth_user` VALUES ('77246', '809', '49', null, null, null, null, '2-10-49', 'menu');
INSERT INTO `auth_user` VALUES ('77250', '388', '39', '1', '96', '79', 'CO0001-DEMP0001-ST0031', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77251', '388', '39', '162', null, '11146', 'CO0001-CO0002-CO0003-ST0032', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77252', '388', '39', '165', null, '11147', 'CO0001-CO0002-CO0003-CO0006-ST0033', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77253', '388', '39', '165', null, '11148', 'CO0001-CO0002-CO0003-CO0006-ST0034', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77254', '388', '39', '165', '412', '11149', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0035', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77255', '388', '39', '165', '412', '11150', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0036', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77256', '388', '39', '165', '412', '11151', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0037', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77257', '388', '39', '165', '412', '11152', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0038', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77258', '388', '39', '165', '420', '11153', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0039', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77259', '388', '39', '165', '420', '11154', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0040', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77260', '388', '39', '165', '420', '11155', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0041', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77261', '388', '39', '165', '413', '11156', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0042', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77262', '388', '39', '165', '413', '11157', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0043', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77263', '388', '39', '165', '413', '11158', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0044', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77264', '388', '39', '165', '414', '11159', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0045', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77265', '388', '39', '165', '414', '11160', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0046', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77266', '388', '39', '165', '415', '11161', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0047', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77267', '388', '39', '165', '416', '11162', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0048', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77268', '388', '39', '165', '416', '11163', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0049', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77269', '388', '39', '165', '416', '11164', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0050', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77270', '388', '39', '165', '417', '11165', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0051', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77271', '388', '39', '165', '417', '11166', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0052', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77272', '388', '39', '165', '418', '11167', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0053', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77273', '388', '39', '165', '418', '11168', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0054', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77274', '388', '39', '165', '418', '11169', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0055', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77275', '388', '39', '161', '400', '11170', 'CO0001-CO0002-DEMP0002-ST0056', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77276', '388', '39', '161', '400', '11175', 'CO0001-CO0002-DEMP0002-ST0061', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77277', '388', '39', '161', '406', '11176', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0062', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77278', '388', '39', '161', '406', '11177', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0063', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77279', '388', '39', '161', '406', '11178', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0064', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77280', '388', '39', '161', '406', '11179', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0065', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77281', '388', '39', '161', '406', '11180', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0066', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77282', '388', '39', '161', '405', '11181', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0067', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77283', '388', '39', '161', '401', '11186', 'CO0001-CO0002-DEMP0003-ST0072', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77284', '388', '39', '161', '401', '11187', 'CO0001-CO0002-DEMP0003-ST0073', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77285', '388', '39', '161', '401', '11188', 'CO0001-CO0002-DEMP0003-ST0074', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77286', '388', '39', '161', '401', '11189', 'CO0001-CO0002-DEMP0003-ST0075', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77287', '388', '39', '161', '401', '11190', 'CO0001-CO0002-DEMP0003-ST0076', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77288', '388', '39', '161', '401', '11191', 'CO0001-CO0002-DEMP0003-ST0077', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77289', '388', '39', '161', '401', '11192', 'CO0001-CO0002-DEMP0003-ST0078', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77290', '388', '39', '161', '401', '11193', 'CO0001-CO0002-DEMP0003-ST0079', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77291', '388', '39', '161', '401', '11194', 'CO0001-CO0002-DEMP0003-ST0080', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77292', '388', '39', '161', '402', '11195', 'CO0001-CO0002-DEMP0004-ST0081', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77293', '388', '39', '161', '402', '11196', 'CO0001-CO0002-DEMP0004-ST0082', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77294', '388', '39', '161', '402', '11197', 'CO0001-CO0002-DEMP0004-ST0083', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77295', '388', '39', '161', '403', '11198', 'CO0001-CO0002-DEMP0005-ST0084', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77296', '388', '39', '161', '403', '11199', 'CO0001-CO0002-DEMP0005-ST0085', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77297', '388', '39', '161', '404', '11200', 'CO0001-CO0002-DEMP0006-ST0086', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77298', '388', '39', '161', '404', '11201', 'CO0001-CO0002-DEMP0006-ST0087', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77299', '388', '39', '161', '404', '11202', 'CO0001-CO0002-DEMP0006-ST0088', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77300', '388', '39', '161', '404', '11203', 'CO0001-CO0002-DEMP0006-ST0089', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77301', '388', '39', '1', '409', '11204', 'CO0001-DEMP0011-ST0090', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77302', '388', '39', '1', '409', '11205', 'CO0001-DEMP0011-ST0091', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77303', '388', '39', '1', '409', '11206', 'CO0001-DEMP0011-ST0092', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77304', '388', '39', '1', '409', '11207', 'CO0001-DEMP0011-ST0093', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77305', '388', '39', '1', '409', '11208', 'CO0001-DEMP0011-ST0094', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77306', '388', '39', '1', '409', '11209', 'CO0001-DEMP0011-ST0095', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77307', '388', '39', '1', '409', '11210', 'CO0001-DEMP0011-ST0096', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77308', '388', '39', '1', '409', '11211', 'CO0001-DEMP0011-ST0097', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77309', '388', '39', '1', null, '11212', 'CO0001-ST0098', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77310', '388', '39', '1', null, '11213', 'CO0001-ST0099', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77311', '388', '39', '1', '408', '11214', 'CO0001-DEMP0010-ST0100', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77312', '388', '39', '1', '96', '11215', 'CO0001-DEMP0001-ST0101', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77313', '388', '39', '1', '407', '11216', 'CO0001-DEMP0009-ST0102', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77314', '388', '39', '1', '410', '11217', 'CO0001-DEMP0012-ST0103', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77315', '388', '39', '1', '410', '11218', 'CO0001-DEMP0012-ST0104', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77316', '388', '39', '1', '411', '11219', 'CO0001-DEMP0013-ST0105', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77317', '388', '39', '1', '408', '11220', 'CO0001-DEMP0010-ST0106', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77318', '388', '39', '1', '408', '11221', 'CO0001-DEMP0010-ST0107', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77319', '388', '39', '1', '408', '11222', 'CO0001-DEMP0010-ST0108', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77320', '388', '39', '1', '408', '11223', 'CO0001-DEMP0010-ST0109', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77321', '388', '39', '165', '415', '11224', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0110', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77322', '388', '39', '165', '415', '11225', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0111', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77323', '388', '39', '165', '419', '11226', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0112', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77324', '388', '39', '161', null, '11227', 'CO0001-CO0002-ST0113', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77325', '388', '39', '161', null, '11228', 'CO0001-CO0002-ST0114', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77326', '388', '39', '165', '419', '11232', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0118', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77327', '388', '39', '165', '419', '11233', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0119', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77328', '388', '39', '165', '419', '11234', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0120', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77329', '388', '39', '165', null, '11235', 'CO0001-CO0002-CO0003-CO0006-ST0121', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77330', '388', '39', '165', '414', '11236', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0122', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77331', '388', '39', '165', '416', '11237', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0123', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77332', '388', '39', '161', '403', '11238', 'CO0001-CO0002-DEMP0005-ST0124', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77333', '388', '39', '165', '412', '11239', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0125', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77334', '388', '39', '165', '412', '11240', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0126', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77335', '388', '39', '165', '412', '11241', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0127', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77336', '388', '39', '161', '421', '11242', 'CO0001-CO0002-DEMP0023-ST0128', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77337', '388', '39', '161', null, '11243', 'CO0001-CO0002-ST0129', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77338', '388', '39', '161', null, '11244', 'CO0001-CO0002-ST0130', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77339', '388', '39', '161', '421', '11245', 'CO0001-CO0002-DEMP0023-ST0131', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77340', '388', '39', '1', '410', '11247', 'CO0001-DEMP0012-ST0133', '6-20-39', 'post');
INSERT INTO `auth_user` VALUES ('77341', '388', '41', '1', '96', '79', 'CO0001-DEMP0001-ST0031', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77342', '388', '41', '162', null, '11146', 'CO0001-CO0002-CO0003-ST0032', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77343', '388', '41', '165', null, '11147', 'CO0001-CO0002-CO0003-CO0006-ST0033', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77344', '388', '41', '165', null, '11148', 'CO0001-CO0002-CO0003-CO0006-ST0034', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77345', '388', '41', '165', '412', '11149', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0035', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77346', '388', '41', '165', '412', '11150', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0036', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77347', '388', '41', '165', '412', '11151', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0037', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77348', '388', '41', '165', '412', '11152', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0038', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77349', '388', '41', '165', '420', '11153', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0039', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77350', '388', '41', '165', '420', '11154', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0040', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77351', '388', '41', '165', '420', '11155', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0041', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77352', '388', '41', '165', '413', '11156', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0042', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77353', '388', '41', '165', '413', '11157', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0043', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77354', '388', '41', '165', '413', '11158', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0044', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77355', '388', '41', '165', '414', '11159', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0045', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77356', '388', '41', '165', '414', '11160', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0046', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77357', '388', '41', '165', '415', '11161', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0047', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77358', '388', '41', '165', '416', '11162', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0048', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77359', '388', '41', '165', '416', '11163', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0049', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77360', '388', '41', '165', '416', '11164', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0050', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77361', '388', '41', '165', '417', '11165', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0051', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77362', '388', '41', '165', '417', '11166', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0052', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77363', '388', '41', '165', '418', '11167', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0053', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77364', '388', '41', '165', '418', '11168', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0054', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77365', '388', '41', '165', '418', '11169', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0055', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77366', '388', '41', '161', '400', '11170', 'CO0001-CO0002-DEMP0002-ST0056', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77367', '388', '41', '161', '400', '11175', 'CO0001-CO0002-DEMP0002-ST0061', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77368', '388', '41', '161', '406', '11176', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0062', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77369', '388', '41', '161', '406', '11177', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0063', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77370', '388', '41', '161', '406', '11178', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0064', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77371', '388', '41', '161', '406', '11179', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0065', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77372', '388', '41', '161', '406', '11180', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0066', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77373', '388', '41', '161', '405', '11181', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0067', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77374', '388', '41', '161', '401', '11186', 'CO0001-CO0002-DEMP0003-ST0072', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77375', '388', '41', '161', '401', '11187', 'CO0001-CO0002-DEMP0003-ST0073', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77376', '388', '41', '161', '401', '11188', 'CO0001-CO0002-DEMP0003-ST0074', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77377', '388', '41', '161', '401', '11189', 'CO0001-CO0002-DEMP0003-ST0075', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77378', '388', '41', '161', '401', '11190', 'CO0001-CO0002-DEMP0003-ST0076', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77379', '388', '41', '161', '401', '11191', 'CO0001-CO0002-DEMP0003-ST0077', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77380', '388', '41', '161', '401', '11192', 'CO0001-CO0002-DEMP0003-ST0078', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77381', '388', '41', '161', '401', '11193', 'CO0001-CO0002-DEMP0003-ST0079', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77382', '388', '41', '161', '401', '11194', 'CO0001-CO0002-DEMP0003-ST0080', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77383', '388', '41', '161', '402', '11195', 'CO0001-CO0002-DEMP0004-ST0081', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77384', '388', '41', '161', '402', '11196', 'CO0001-CO0002-DEMP0004-ST0082', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77385', '388', '41', '161', '402', '11197', 'CO0001-CO0002-DEMP0004-ST0083', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77386', '388', '41', '161', '403', '11198', 'CO0001-CO0002-DEMP0005-ST0084', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77387', '388', '41', '161', '403', '11199', 'CO0001-CO0002-DEMP0005-ST0085', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77388', '388', '41', '161', '404', '11200', 'CO0001-CO0002-DEMP0006-ST0086', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77389', '388', '41', '161', '404', '11201', 'CO0001-CO0002-DEMP0006-ST0087', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77390', '388', '41', '161', '404', '11202', 'CO0001-CO0002-DEMP0006-ST0088', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77391', '388', '41', '161', '404', '11203', 'CO0001-CO0002-DEMP0006-ST0089', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77392', '388', '41', '1', '409', '11204', 'CO0001-DEMP0011-ST0090', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77393', '388', '41', '1', '409', '11205', 'CO0001-DEMP0011-ST0091', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77394', '388', '41', '1', '409', '11206', 'CO0001-DEMP0011-ST0092', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77395', '388', '41', '1', '409', '11207', 'CO0001-DEMP0011-ST0093', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77396', '388', '41', '1', '409', '11208', 'CO0001-DEMP0011-ST0094', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77397', '388', '41', '1', '409', '11209', 'CO0001-DEMP0011-ST0095', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77398', '388', '41', '1', '409', '11210', 'CO0001-DEMP0011-ST0096', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77399', '388', '41', '1', '409', '11211', 'CO0001-DEMP0011-ST0097', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77400', '388', '41', '1', null, '11212', 'CO0001-ST0098', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77401', '388', '41', '1', null, '11213', 'CO0001-ST0099', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77402', '388', '41', '1', '408', '11214', 'CO0001-DEMP0010-ST0100', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77403', '388', '41', '1', '96', '11215', 'CO0001-DEMP0001-ST0101', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77404', '388', '41', '1', '407', '11216', 'CO0001-DEMP0009-ST0102', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77405', '388', '41', '1', '410', '11217', 'CO0001-DEMP0012-ST0103', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77406', '388', '41', '1', '410', '11218', 'CO0001-DEMP0012-ST0104', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77407', '388', '41', '1', '411', '11219', 'CO0001-DEMP0013-ST0105', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77408', '388', '41', '1', '408', '11220', 'CO0001-DEMP0010-ST0106', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77409', '388', '41', '1', '408', '11221', 'CO0001-DEMP0010-ST0107', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77410', '388', '41', '1', '408', '11222', 'CO0001-DEMP0010-ST0108', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77411', '388', '41', '1', '408', '11223', 'CO0001-DEMP0010-ST0109', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77412', '388', '41', '165', '415', '11224', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0110', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77413', '388', '41', '165', '415', '11225', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0111', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77414', '388', '41', '165', '419', '11226', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0112', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77415', '388', '41', '161', null, '11227', 'CO0001-CO0002-ST0113', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77416', '388', '41', '161', null, '11228', 'CO0001-CO0002-ST0114', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77417', '388', '41', '165', '419', '11232', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0118', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77418', '388', '41', '165', '419', '11233', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0119', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77419', '388', '41', '165', '419', '11234', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0120', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77420', '388', '41', '165', null, '11235', 'CO0001-CO0002-CO0003-CO0006-ST0121', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77421', '388', '41', '165', '414', '11236', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0122', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77422', '388', '41', '165', '416', '11237', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0123', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77423', '388', '41', '161', '403', '11238', 'CO0001-CO0002-DEMP0005-ST0124', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77424', '388', '41', '165', '412', '11239', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0125', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77425', '388', '41', '165', '412', '11240', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0126', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77426', '388', '41', '165', '412', '11241', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0127', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77427', '388', '41', '161', '421', '11242', 'CO0001-CO0002-DEMP0023-ST0128', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77428', '388', '41', '161', null, '11243', 'CO0001-CO0002-ST0129', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77429', '388', '41', '161', null, '11244', 'CO0001-CO0002-ST0130', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77430', '388', '41', '161', '421', '11245', 'CO0001-CO0002-DEMP0023-ST0131', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77431', '388', '41', '1', '410', '11247', 'CO0001-DEMP0012-ST0133', '6-21-41', 'post');
INSERT INTO `auth_user` VALUES ('77432', '388', '43', '1', '410', '11247', 'CO0001-DEMP0012-ST0133', '4-12-43', 'post');
INSERT INTO `auth_user` VALUES ('77433', '388', '45', '1', '410', '11247', 'CO0001-DEMP0012-ST0133', '4-13-45', 'post');

-- ----------------------------
-- Table structure for flow_action_log
-- ----------------------------
DROP TABLE IF EXISTS `flow_action_log`;
CREATE TABLE `flow_action_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status` varchar(32) DEFAULT NULL COMMENT '操作',
  `operate_time` datetime DEFAULT NULL COMMENT '操作时间',
  `recruit_id` int(11) DEFAULT NULL COMMENT '招聘表id',
  `entry_id` int(11) DEFAULT NULL COMMENT '入职表id',
  `operater` varchar(12) DEFAULT NULL COMMENT '操作人员',
  `opinion` varchar(128) DEFAULT NULL COMMENT '处理意见',
  PRIMARY KEY (`id`),
  KEY `recruit_id` (`recruit_id`),
  KEY `entry_id` (`entry_id`),
  CONSTRAINT `flow_action_log_ibfk_1` FOREIGN KEY (`recruit_id`) REFERENCES `flow_recruit` (`id`),
  CONSTRAINT `flow_action_log_ibfk_2` FOREIGN KEY (`entry_id`) REFERENCES `flow_entry` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1849 DEFAULT CHARSET=utf8 COMMENT='操作日志(记录招聘的动作)';

-- ----------------------------
-- Records of flow_action_log
-- ----------------------------
INSERT INTO `flow_action_log` VALUES ('1840', '提出入职申请', '2017-08-21 17:14:38', '792', '574', '李理', null);
INSERT INTO `flow_action_log` VALUES ('1841', '提出入职申请', '2017-08-21 17:22:03', '766', '575', '李理', null);
INSERT INTO `flow_action_log` VALUES ('1842', '', '2017-08-21 17:24:36', '792', '574', '李理', null);
INSERT INTO `flow_action_log` VALUES ('1843', '', '2017-08-21 17:25:03', '792', '574', '李理', null);
INSERT INTO `flow_action_log` VALUES ('1844', '提出入职申请', '2017-08-21 17:27:39', '792', '576', '李理', null);
INSERT INTO `flow_action_log` VALUES ('1845', '发送offer', '2017-08-21 17:36:26', '792', '576', null, '李理');
INSERT INTO `flow_action_log` VALUES ('1846', '发送offer', '2017-08-21 17:40:11', '766', '575', null, '李理');
INSERT INTO `flow_action_log` VALUES ('1847', '员工建档', '2017-08-21 18:20:16', '766', '575', null, null);
INSERT INTO `flow_action_log` VALUES ('1848', '员工建档', '2017-08-21 18:52:34', '792', '576', null, null);

-- ----------------------------
-- Table structure for flow_application_type
-- ----------------------------
DROP TABLE IF EXISTS `flow_application_type`;
CREATE TABLE `flow_application_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='申请类型';

-- ----------------------------
-- Records of flow_application_type
-- ----------------------------

-- ----------------------------
-- Table structure for flow_approve
-- ----------------------------
DROP TABLE IF EXISTS `flow_approve`;
CREATE TABLE `flow_approve` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recordid` int(11) DEFAULT NULL COMMENT '查看详情表  是否被查看过',
  `userid` int(11) DEFAULT NULL COMMENT '审核人',
  `positionid` int(11) DEFAULT NULL COMMENT '审批人职位',
  `handledate` datetime DEFAULT NULL COMMENT '审批时间',
  `handleidea` varchar(1024) DEFAULT NULL COMMENT '意见',
  `checkstatus` int(11) DEFAULT '0' COMMENT '0、审批中 1、不同意 2、同意',
  `apply_id` int(11) DEFAULT NULL COMMENT '申请关系表id(关联flow_user_application)',
  `is_approve` int(11) DEFAULT '1' COMMENT '是否可审批  0 可审批  1 不可审批，默认1',
  `start_time` date DEFAULT NULL COMMENT '任务流转过来时时间',
  `is_messaging` int(11) DEFAULT '0' COMMENT '是否发送消息 0 未 1以发送',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_52` (`recordid`),
  KEY `apply_id` (`apply_id`),
  CONSTRAINT `FK_Reference_52` FOREIGN KEY (`recordid`) REFERENCES `tp_findrecord` (`id`),
  CONSTRAINT `flow_approve_ibfk_1` FOREIGN KEY (`apply_id`) REFERENCES `flow_user_application` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=135002 DEFAULT CHARSET=utf8 COMMENT='审批详情表';

-- ----------------------------
-- Records of flow_approve
-- ----------------------------
INSERT INTO `flow_approve` VALUES ('134982', null, '424', '3', '2017-08-11 11:19:44', '工资高了', '1', '79667', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134984', null, '424', '3', '2017-08-11 11:19:30', '工资高了', '1', '79668', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134986', null, '424', '3', '2017-08-11 11:13:54', '工资太高', '1', '79669', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134988', null, '424', '3', '2017-08-11 16:25:30', '', '2', '79670', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134989', null, '423', '2', '2017-08-11 16:27:59', '', '2', '79670', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134990', null, '398', '2', '2017-08-11 16:45:51', '', '2', '79670', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134991', null, '424', '3', '2017-08-11 16:25:26', '', '2', '79671', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134992', null, '423', '2', '2017-08-11 16:27:56', '', '2', '79671', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134993', null, '398', '2', '2017-08-11 16:45:47', '', '2', '79671', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134994', null, '424', '3', '2017-08-11 16:25:21', '', '2', '79672', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134995', null, '423', '2', '2017-08-11 16:27:51', '', '2', '79672', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134996', null, '398', '2', '2017-08-11 16:45:43', '', '2', '79672', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134997', null, '398', '2', '2017-08-21 15:55:19', '', '2', '79673', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134998', null, '398', '2', '2017-08-21 15:55:25', '', '2', '79699', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('134999', null, '398', '2', '2017-08-21 17:24:08', '不同意', '1', '79700', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('135000', null, '398', '2', '2017-08-21 17:23:32', '', '2', '79701', '1', null, '0');
INSERT INTO `flow_approve` VALUES ('135001', null, '398', '2', '2017-08-21 17:28:08', '', '2', '79702', '1', null, '0');

-- ----------------------------
-- Table structure for flow_entry
-- ----------------------------
DROP TABLE IF EXISTS `flow_entry`;
CREATE TABLE `flow_entry` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_id` int(11) DEFAULT NULL COMMENT '申请人id',
  `username` varchar(32) DEFAULT NULL COMMENT '申请人姓名',
  `name` varchar(20) DEFAULT NULL COMMENT '入职人姓名',
  `sex` int(11) DEFAULT NULL COMMENT '性别',
  `phone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `entry_date` date DEFAULT NULL COMMENT '入职日期',
  `probation` varchar(10) DEFAULT NULL COMMENT '试用期',
  `service_years` varchar(10) DEFAULT NULL COMMENT '服务年限',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `check_url` varchar(100) DEFAULT NULL COMMENT '背景调查表url',
  `resume_url` varchar(100) DEFAULT NULL COMMENT '简历url',
  `register_url` varchar(100) DEFAULT NULL COMMENT '登记表url',
  `state` int(20) DEFAULT NULL COMMENT '申请状态',
  `result` int(20) DEFAULT '0' COMMENT '入职结果',
  `status` int(11) DEFAULT NULL COMMENT '删除状态（1:已删除，0:未删除）',
  `number` varchar(32) DEFAULT NULL COMMENT '单号',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `recruit_id` int(11) DEFAULT NULL COMMENT '招聘id',
  `hour` varchar(11) DEFAULT NULL COMMENT 'offer中的时',
  `people_who_copied` varchar(568) DEFAULT NULL COMMENT '抄送人',
  `is_send_offer` int(11) DEFAULT '0' COMMENT '是否发送offer 0 否 1是',
  `is_bookbuilding` int(11) DEFAULT '0' COMMENT '是否建档 0 否 1是',
  `recipients_email` varchar(100) DEFAULT NULL COMMENT '个人邮箱',
  PRIMARY KEY (`id`),
  KEY `recruit_id` (`recruit_id`),
  CONSTRAINT `flow_entry_ibfk_1` FOREIGN KEY (`recruit_id`) REFERENCES `flow_recruit` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=577 DEFAULT CHARSET=utf8 COMMENT='入职表';

-- ----------------------------
-- Records of flow_entry
-- ----------------------------
INSERT INTO `flow_entry` VALUES ('574', '433', '李理', '于虹', '2', '15321151805', 'yuhong20170801@163.com', '2017-09-04', '3', '3', null, '', '', 'http://139.129.236.180:81/20170821171433582588/应聘人员登记表模板.docx', '2', '2', '0', null, '2017-08-21 17:14:38', '792', null, null, '0', '0', null);
INSERT INTO `flow_entry` VALUES ('575', '433', '李理', '蔡羽佳', '2', '13811624071', '174932152@qq.com', '2017-08-21', '3', '3', null, '', '', 'http://139.129.236.180:81/20170821172159887306/应聘人员登记表模板.docx', '4', '3', '0', null, '2017-08-21 17:22:03', '766', '9点30', null, '1', '1', 'lili@pj-l.com');
INSERT INTO `flow_entry` VALUES ('576', '433', '李理', '于虹', '2', '15321151805', 'yuhong20170801@163.com', '2017-09-04', '3', '3', null, '', '', 'http://139.129.236.180:81/20170821172737400515/应聘人员登记表模板.docx', '4', '3', '0', null, '2017-08-21 17:27:39', '792', '9:30', null, '1', '1', 'lili@pj-l.com');

-- ----------------------------
-- Table structure for flow_menu_user
-- ----------------------------
DROP TABLE IF EXISTS `flow_menu_user`;
CREATE TABLE `flow_menu_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `type` varchar(20) DEFAULT NULL COMMENT '招聘待办:recruit,建档待办:entry',
  `menuid` int(11) DEFAULT NULL COMMENT '菜单id',
  `isread` int(11) DEFAULT NULL COMMENT '待办用--是否已读（1：已读，0：未读）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='待办人员菜单关系表';

-- ----------------------------
-- Records of flow_menu_user
-- ----------------------------

-- ----------------------------
-- Table structure for flow_recruit
-- ----------------------------
DROP TABLE IF EXISTS `flow_recruit`;
CREATE TABLE `flow_recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apply_id` int(11) DEFAULT NULL COMMENT '申请人id',
  `username` varchar(50) DEFAULT NULL COMMENT '申请人姓名',
  `apply_date` datetime DEFAULT NULL COMMENT '申请时间',
  `company_id` int(11) DEFAULT NULL COMMENT '被招聘人所属公司',
  `post_id` int(11) DEFAULT NULL COMMENT '岗位',
  `demp_id` int(11) DEFAULT NULL COMMENT '部门',
  `position_id` int(11) DEFAULT NULL COMMENT '职位',
  `is_demp_leader` int(11) DEFAULT '0' COMMENT '是否部门负责人(0:否，1:是)',
  `is_company_leader` int(11) DEFAULT '0' COMMENT '是否公司负责人(0:否，1:是)',
  `need_num` int(11) DEFAULT NULL COMMENT '招聘人数',
  `entry_num` int(11) DEFAULT '0' COMMENT '入职人数',
  `work_address` varchar(200) DEFAULT NULL COMMENT '工作地址',
  `apply_reason_type` int(11) DEFAULT NULL COMMENT '岗位申请原因类型',
  `apply_reason_child_type` int(11) DEFAULT NULL COMMENT '岗位申请原因子类型',
  `apply_reason` varchar(500) DEFAULT NULL COMMENT '岗位申请原因',
  `replace_id` int(11) DEFAULT NULL COMMENT '替代人员id',
  `channel` int(11) DEFAULT NULL COMMENT '岗位招聘渠道 1 外部招聘 2 内部竞聘 3 内部推荐 4 猎头',
  `sex` int(11) DEFAULT NULL COMMENT '性别（1：男，2：女，0：不限）',
  `age` varchar(20) DEFAULT NULL COMMENT '年龄范围',
  `education` varchar(20) DEFAULT NULL COMMENT '学历',
  `duty` varchar(1000) DEFAULT NULL COMMENT '岗位职责',
  `technology` varchar(1000) DEFAULT NULL COMMENT '技术资格',
  `knowledge` varchar(1000) DEFAULT NULL COMMENT '专业知识',
  `business_ability` varchar(1000) DEFAULT NULL COMMENT '业务能力',
  `special_ability` varchar(1000) DEFAULT NULL COMMENT '特殊能力',
  `experience` varchar(1000) DEFAULT NULL COMMENT '工作经历',
  `other_demand` varchar(1000) DEFAULT NULL COMMENT '其他需求',
  `state` int(20) DEFAULT '1' COMMENT '申请状态',
  `result` int(20) DEFAULT '0' COMMENT '申请结果',
  `leader_id` int(11) DEFAULT NULL COMMENT '直属领导id',
  `offer_range` varchar(50) DEFAULT NULL COMMENT '薪资范围',
  `is_check` int(11) DEFAULT '0' COMMENT '是否背景调查(0:否，1:是)',
  `status` int(11) DEFAULT '0' COMMENT '删除状态（1:已删除，0:未删除）',
  PRIMARY KEY (`id`),
  KEY `apply_id` (`apply_id`),
  KEY `post_id` (`post_id`),
  KEY `demp_id` (`demp_id`),
  KEY `replace_id` (`replace_id`),
  KEY `leader_id` (`leader_id`),
  CONSTRAINT `flow_recruit_ibfk_2` FOREIGN KEY (`post_id`) REFERENCES `t_post` (`id`),
  CONSTRAINT `flow_recruit_ibfk_3` FOREIGN KEY (`demp_id`) REFERENCES `t_demp` (`id`),
  CONSTRAINT `flow_recruit_ibfk_4` FOREIGN KEY (`replace_id`) REFERENCES `t_user` (`id`),
  CONSTRAINT `flow_recruit_ibfk_5` FOREIGN KEY (`leader_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=793 DEFAULT CHARSET=utf8 COMMENT='招聘申请';

-- ----------------------------
-- Records of flow_recruit
-- ----------------------------
INSERT INTO `flow_recruit` VALUES ('760', '433', '李理', '2017-08-10 19:03:16', '161', '11178', '406', '4', '0', '0', '3', '0', '北京', '2', '23', '新增岗位', null, '1', '0', '22-40', '2', '处理海运业务中文件工作\n具体如舱单、报关单、提单等相关文件整理核对提交等', '', '', '', '', '有海运相关经验优先。', '勤奋踏实，品行端正；\n性别不限，22-40岁，专科以上学历', '2', '2', '424', '3500-5000', '0', '0');
INSERT INTO `flow_recruit` VALUES ('761', '433', '李理', '2017-08-10 19:10:24', '161', '11177', '406', '4', '0', '0', '3', '0', '北京市朝阳区来广营诚盈中心A座9层', '2', '23', '新增岗位', null, '1', '0', '22-40', '2', '接受客户的委托业务，合理、及时安排报关、运输等各项日常操作；及时、有效地处理客户诉求，服务过程中随时与客户保持良好沟通，保证客户对服务的满意情况；遇到特殊事件有应变能力并做出正确的判断和操作方式', '', '', '可以处理英文邮件往来', '', '有海运相关经验优先。', '勤奋踏实，品行端正\n性别不限，专科以上学历', '2', '2', '424', '4000-6500', '0', '0');
INSERT INTO `flow_recruit` VALUES ('762', '433', '李理', '2017-08-10 19:18:02', '161', '11180', '406', '4', '0', '0', '3', '0', '北京市朝阳区来广营诚盈中心A座9层', '2', '23', '新增岗位', null, '1', '0', '22-40', '2', '配合部门需求进行成本收集整理工作，商务报价等工作', '', '', '', '', '有海运相关经验优先。', '勤奋踏实，品行端正\n	性别不限，22-40岁，专科以上学历', '2', '2', '424', '3500-8000', '0', '0');
INSERT INTO `flow_recruit` VALUES ('763', '433', '李理', '2017-08-11 11:51:30', '161', '11178', '406', '4', '0', '0', '3', '0', '北京市朝阳区来广营诚盈中心A座9层', '2', '23', '新增岗位', null, '1', '0', '22-40', '2', '处理海运业务中文件工作\n具体如舱单、报关单、提单等相关文件整理核对提交等', '', '', '', '', '有海运相关经验优先。', '勤奋踏实，品行端正\n性别不限，22-40岁，专科以上学历', '2', '1', '424', '3000-4000', '0', '0');
INSERT INTO `flow_recruit` VALUES ('764', '433', '李理', '2017-08-11 11:53:37', '161', '11177', '406', '4', '0', '0', '3', '0', '北京市朝阳区来广营诚盈中心A座9层', '2', '23', '新增岗位', null, '1', '0', '22-40', '2', '接受客户的委托业务，合理、及时安排报关、运输等各项日常操作；及时、有效地处理客户诉求，服务过程中随时与客户保持良好沟通，保证客户对服务的满意情况；遇到特殊事件有应变能力并做出正确的判断和操作方式', '', '', '', '', '可以处理英文邮件往来，有海运相关经验优先。', '勤奋踏实，品行端正\n	性别不限，专科以上学历', '2', '1', '424', '3000-4000', '0', '0');
INSERT INTO `flow_recruit` VALUES ('765', '433', '李理', '2017-08-11 11:55:39', '161', '11180', '406', '4', '0', '0', '3', '0', '北京市朝阳区来广营诚盈中心A座9层', '2', '23', '新增职位', null, '1', '0', '22-40', '2', '配合部门需求进行成本收集整理工作，商务报价等工作', '', '', '', '', '有海运相关经验优先。', '勤奋踏实，品行端正\n性别不限，22-40岁，专科以上学历', '2', '1', '424', '3000-4000', '0', '0');
INSERT INTO `flow_recruit` VALUES ('766', '433', '李理', '2017-08-21 14:25:35', '161', '11243', null, '4', '0', '0', '1', '1', '北京市朝阳区来广营诚盈中心A座9层', '2', '22', '', null, '1', '2', '30岁以内', '3', '负责协助总经理处理日常文字工作，协助完成例会准备及会议记录，协助完成相关数据的收集，日常的工作汇报。', '英语六级', '', '', '', '至少1年秘书类经验', '', '6', '7', null, '3000-5000', '0', '0');
INSERT INTO `flow_recruit` VALUES ('792', '433', '李理', '2017-08-21 14:41:13', '161', '11242', '421', '3', '0', '0', '1', '1', '北京市朝阳区来广营诚盈中心A座9层', '2', '22', '', null, '1', '0', '28-40岁', '2', '1、负责根据总部制度流程，和所辖业务区的情况制定区域人力资源规划并组织实施；\n2、完善部门职责、岗位职责，并组织制定各部门绩效实施细则，并组织实施；\n3、负责所辖区域薪资福利的运营工作，保证总部制度流程有效落地；\n4、负责区域内员工关系、劳动关系、入离调转手续的合规性操作实施；\n5、负责所辖区域各类培训、文化活动的落地组织工作；\n6、负责区域HR&行政中心的人员管理工作。', '', '具备国际物流或国际货运代理行业人力资源工作背景优先', '具备2年以上团队管理能力', '', '5年以上人力资源资源管理经验，熟悉招聘、培训、员工关系模块', '具备良好的沟通协调能力，责任心和亲和力', '6', '7', null, '3000-5000', '1', '0');

-- ----------------------------
-- Table structure for flow_recruit_todo
-- ----------------------------
DROP TABLE IF EXISTS `flow_recruit_todo`;
CREATE TABLE `flow_recruit_todo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `recruit_id` int(11) DEFAULT NULL COMMENT '招聘id',
  `entry_id` int(11) DEFAULT NULL COMMENT '入职id',
  `state` int(10) DEFAULT NULL COMMENT '待办状态（0:已终止 1:招聘中,2:已提交,3:已暂停,4:已审批）',
  `need_num` int(11) DEFAULT NULL COMMENT '需要招聘个数',
  `number` int(11) DEFAULT NULL COMMENT '招聘中的个数',
  `reason` varchar(1000) DEFAULT NULL COMMENT '暂停/开始/终止理由',
  `status` int(11) DEFAULT NULL COMMENT '1:已删除，0:未删除',
  PRIMARY KEY (`id`),
  KEY `recruit_id` (`recruit_id`),
  KEY `entry_id` (`entry_id`),
  CONSTRAINT `flow_recruit_todo_ibfk_1` FOREIGN KEY (`recruit_id`) REFERENCES `flow_recruit` (`id`),
  CONSTRAINT `flow_recruit_todo_ibfk_2` FOREIGN KEY (`entry_id`) REFERENCES `flow_entry` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=563 DEFAULT CHARSET=utf8 COMMENT='招聘待办';

-- ----------------------------
-- Records of flow_recruit_todo
-- ----------------------------
INSERT INTO `flow_recruit_todo` VALUES ('560', '765', null, '1', '3', '3', null, '0');
INSERT INTO `flow_recruit_todo` VALUES ('561', '764', null, '1', '3', '3', null, '0');
INSERT INTO `flow_recruit_todo` VALUES ('562', '763', null, '1', '3', '3', null, '0');

-- ----------------------------
-- Table structure for flow_user_application
-- ----------------------------
DROP TABLE IF EXISTS `flow_user_application`;
CREATE TABLE `flow_user_application` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '申请人id',
  `form_id` int(11) DEFAULT NULL COMMENT '申请表id',
  `apply_type` varchar(32) DEFAULT NULL COMMENT '申请类型(招聘:recruit 入职:entry，转正:regular ，异动:change，离职:dimission，请假:leave，其他:other)',
  `apply_name` varchar(32) DEFAULT NULL COMMENT '申请人姓名',
  `apply_demp_name` varchar(100) DEFAULT NULL COMMENT '申请人部门',
  `apply_time` datetime DEFAULT NULL COMMENT '申请时间',
  `apply_company_name` varchar(50) DEFAULT NULL COMMENT '公司名称',
  `username` varchar(32) DEFAULT NULL COMMENT '表单中具体的人员',
  PRIMARY KEY (`id`),
  KEY `userid` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=79703 DEFAULT CHARSET=utf8 COMMENT='申请人申请表中间表';

-- ----------------------------
-- Records of flow_user_application
-- ----------------------------
INSERT INTO `flow_user_application` VALUES ('79667', '433', '760', 'recruit', '李理', '海运事业部-海运操作部', '2017-08-10 19:03:16', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79668', '433', '761', 'recruit', '李理', '海运事业部-海运操作部', '2017-08-10 19:10:24', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79669', '433', '762', 'recruit', '李理', '海运事业部-海运操作部', '2017-08-10 19:18:02', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79670', '433', '763', 'recruit', '李理', '海运事业部-海运操作部', '2017-08-11 11:51:30', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79671', '433', '764', 'recruit', '李理', '海运事业部-海运操作部', '2017-08-11 11:53:37', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79672', '433', '765', 'recruit', '李理', '海运事业部-海运操作部', '2017-08-11 11:55:39', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79673', '433', '766', 'recruit', '李理', '', '2017-08-21 14:25:35', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79699', '433', '792', 'recruit', '李理', '人力行政部', '2017-08-21 14:41:13', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79700', '433', '574', 'entry', '李理', '人力行政部', '2017-08-21 17:14:38', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79701', '433', '575', 'entry', '李理', '', '2017-08-21 17:22:03', '中亚宝丰国际物流有限公司', null);
INSERT INTO `flow_user_application` VALUES ('79702', '433', '576', 'entry', '李理', '人力行政部', '2017-08-21 17:27:39', '中亚宝丰国际物流有限公司', null);

-- ----------------------------
-- Table structure for message_content
-- ----------------------------
DROP TABLE IF EXISTS `message_content`;
CREATE TABLE `message_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(12) DEFAULT NULL COMMENT '通知类型(1,入职，2，转正，3，异动，4，离职，5，续签)',
  `apply_form_id` int(11) DEFAULT NULL COMMENT '申请表id',
  `title` varchar(200) DEFAULT NULL COMMENT '通知标题',
  `apply_time` datetime DEFAULT NULL COMMENT '发送时间',
  `applicat_id` int(11) DEFAULT NULL COMMENT '申请人员id',
  `applicat_name` varchar(32) DEFAULT NULL COMMENT '申请人名称',
  `applicat_position` varchar(32) DEFAULT NULL COMMENT '申请人职位',
  `applicat_demp` varchar(256) DEFAULT NULL COMMENT '申请人部门',
  `notification_type` int(11) DEFAULT NULL COMMENT '通知类型   0 发起通知  1 审批通知',
  `result` varchar(32) DEFAULT NULL COMMENT '结果',
  `state` varchar(32) DEFAULT NULL COMMENT '意见',
  `company_name` varchar(32) DEFAULT NULL COMMENT '公司名称',
  `post_name` varchar(32) DEFAULT NULL COMMENT '岗位名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=869 DEFAULT CHARSET=utf8 COMMENT='消息内容表';

-- ----------------------------
-- Records of message_content
-- ----------------------------
INSERT INTO `message_content` VALUES ('858', '1', null, '招聘申请', '2017-08-10 19:18:02', '762', '李理', '主管及以下', '海运事业部-海运操作部', null, '招聘不同意', '招聘已审批', '中亚宝丰国际物流有限公司', '销售顾问');
INSERT INTO `message_content` VALUES ('859', '1', null, '招聘申请', '2017-08-10 19:10:24', '761', '李理', '主管及以下', '海运事业部-海运操作部', null, '招聘不同意', '招聘已审批', '中亚宝丰国际物流有限公司', '客服专员');
INSERT INTO `message_content` VALUES ('860', '1', null, '招聘申请', '2017-08-10 19:03:16', '760', '李理', '主管及以下', '海运事业部-海运操作部', null, '招聘不同意', '招聘已审批', '中亚宝丰国际物流有限公司', '单证员');
INSERT INTO `message_content` VALUES ('861', '1', null, '招聘申请', '2017-08-11 11:55:39', '765', '李理', '主管及以下', '海运事业部-海运操作部', null, '招聘同意', '招聘已审批', '中亚宝丰国际物流有限公司', '销售顾问');
INSERT INTO `message_content` VALUES ('862', '1', null, '招聘申请', '2017-08-11 11:53:37', '764', '李理', '主管及以下', '海运事业部-海运操作部', null, '招聘同意', '招聘已审批', '中亚宝丰国际物流有限公司', '客服专员');
INSERT INTO `message_content` VALUES ('863', '1', null, '招聘申请', '2017-08-11 11:51:30', '763', '李理', '主管及以下', '海运事业部-海运操作部', null, '招聘同意', '招聘已审批', '中亚宝丰国际物流有限公司', '单证员');
INSERT INTO `message_content` VALUES ('864', '1', null, '招聘申请', '2017-08-21 14:25:35', '766', '李理', '主管及以下', null, null, '招聘同意', '招聘已审批', '中亚宝丰国际物流有限公司', '总经理助理');
INSERT INTO `message_content` VALUES ('865', '1', null, '招聘申请', '2017-08-21 14:41:13', '792', '李理', '经理', '人力行政部', null, '招聘同意', '招聘已审批', '中亚宝丰国际物流有限公司', 'HRBP head(华北区)');
INSERT INTO `message_content` VALUES ('866', '2', null, '入职申请', '2017-08-21 17:22:03', '575', '李理', '主管及以下', '', null, '入职同意', '入职已审批', '中亚宝丰国际物流有限公司', '总经理助理');
INSERT INTO `message_content` VALUES ('867', '2', null, '入职申请', '2017-08-21 17:14:38', '574', '李理', '经理', '人力行政部', null, '入职不同意', '入职已审批', '中亚宝丰国际物流有限公司', 'HRBP head(华北区)');
INSERT INTO `message_content` VALUES ('868', '2', null, '入职申请', '2017-08-21 17:27:39', '576', '李理', '经理', '人力行政部', null, '入职同意', '入职已审批', '中亚宝丰国际物流有限公司', 'HRBP head(华北区)');

-- ----------------------------
-- Table structure for message_content_user
-- ----------------------------
DROP TABLE IF EXISTS `message_content_user`;
CREATE TABLE `message_content_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '要通知的人的id',
  `message_id` int(11) DEFAULT NULL COMMENT '消息id',
  `is_find` int(11) DEFAULT '0' COMMENT '是否可查看  0 否 1 是',
  `post_id` int(11) DEFAULT NULL COMMENT '招聘的岗位（对照权限表负责的岗位id）',
  PRIMARY KEY (`id`),
  KEY `userids` (`user_id`) USING BTREE,
  KEY `message_id` (`message_id`) USING BTREE,
  CONSTRAINT `message_id` FOREIGN KEY (`message_id`) REFERENCES `message_content` (`id`),
  CONSTRAINT `userids` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6274 DEFAULT CHARSET=utf8 COMMENT='消息内容和消息接收用户中间表';

-- ----------------------------
-- Records of message_content_user
-- ----------------------------
INSERT INTO `message_content_user` VALUES ('6230', '433', '858', '1', null);
INSERT INTO `message_content_user` VALUES ('6231', '388', '858', '1', null);
INSERT INTO `message_content_user` VALUES ('6232', '489', '858', '0', null);
INSERT INTO `message_content_user` VALUES ('6233', '428', '858', '0', null);
INSERT INTO `message_content_user` VALUES ('6234', '433', '859', '1', null);
INSERT INTO `message_content_user` VALUES ('6235', '388', '859', '1', null);
INSERT INTO `message_content_user` VALUES ('6236', '489', '859', '0', null);
INSERT INTO `message_content_user` VALUES ('6237', '428', '859', '0', null);
INSERT INTO `message_content_user` VALUES ('6238', '433', '860', '1', null);
INSERT INTO `message_content_user` VALUES ('6239', '388', '860', '1', null);
INSERT INTO `message_content_user` VALUES ('6240', '489', '860', '0', null);
INSERT INTO `message_content_user` VALUES ('6241', '428', '860', '0', null);
INSERT INTO `message_content_user` VALUES ('6242', '433', '861', '1', null);
INSERT INTO `message_content_user` VALUES ('6243', '388', '861', '1', null);
INSERT INTO `message_content_user` VALUES ('6244', '489', '861', '0', null);
INSERT INTO `message_content_user` VALUES ('6245', '428', '861', '0', null);
INSERT INTO `message_content_user` VALUES ('6246', '433', '862', '1', null);
INSERT INTO `message_content_user` VALUES ('6247', '388', '862', '1', null);
INSERT INTO `message_content_user` VALUES ('6248', '489', '862', '0', null);
INSERT INTO `message_content_user` VALUES ('6249', '428', '862', '0', null);
INSERT INTO `message_content_user` VALUES ('6250', '433', '863', '1', null);
INSERT INTO `message_content_user` VALUES ('6251', '388', '863', '1', null);
INSERT INTO `message_content_user` VALUES ('6252', '489', '863', '0', null);
INSERT INTO `message_content_user` VALUES ('6253', '428', '863', '0', null);
INSERT INTO `message_content_user` VALUES ('6254', '433', '864', '1', null);
INSERT INTO `message_content_user` VALUES ('6255', '388', '864', '0', null);
INSERT INTO `message_content_user` VALUES ('6256', '489', '864', '0', null);
INSERT INTO `message_content_user` VALUES ('6257', '428', '864', '0', null);
INSERT INTO `message_content_user` VALUES ('6258', '433', '865', '1', null);
INSERT INTO `message_content_user` VALUES ('6259', '388', '865', '0', null);
INSERT INTO `message_content_user` VALUES ('6260', '489', '865', '0', null);
INSERT INTO `message_content_user` VALUES ('6261', '428', '865', '0', null);
INSERT INTO `message_content_user` VALUES ('6262', '433', '866', '0', null);
INSERT INTO `message_content_user` VALUES ('6263', '388', '866', '0', null);
INSERT INTO `message_content_user` VALUES ('6264', '489', '866', '0', null);
INSERT INTO `message_content_user` VALUES ('6265', '428', '866', '0', null);
INSERT INTO `message_content_user` VALUES ('6266', '433', '867', '0', null);
INSERT INTO `message_content_user` VALUES ('6267', '388', '867', '0', null);
INSERT INTO `message_content_user` VALUES ('6268', '489', '867', '0', null);
INSERT INTO `message_content_user` VALUES ('6269', '428', '867', '0', null);
INSERT INTO `message_content_user` VALUES ('6270', '433', '868', '0', null);
INSERT INTO `message_content_user` VALUES ('6271', '388', '868', '0', null);
INSERT INTO `message_content_user` VALUES ('6272', '489', '868', '0', null);
INSERT INTO `message_content_user` VALUES ('6273', '428', '868', '0', null);

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(32) DEFAULT NULL COMMENT '公司编号',
  `name` varchar(32) DEFAULT NULL COMMENT '名称',
  `address` varchar(32) DEFAULT NULL COMMENT '地址',
  `contact` varchar(32) DEFAULT NULL COMMENT '联系方式',
  `pId` int(11) DEFAULT NULL,
  `isdelete` int(11) DEFAULT '0' COMMENT '是否删除 0未删除  1已删除',
  `hierarchy` int(11) DEFAULT NULL COMMENT '层级',
  PRIMARY KEY (`id`),
  KEY `company_comp` (`pId`),
  CONSTRAINT `company_comp` FOREIGN KEY (`pId`) REFERENCES `t_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8 COMMENT='企业表';

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('1', 'CO0001', '贵州盘江物流有限公司', '北京市朝阳区来广营西路诚盈中心A座9层', 'lili@pj-l.com', null, '0', null);
INSERT INTO `t_company` VALUES ('161', 'CO0002', '中亚宝丰国际物流有限公司', '北京市朝阳区望京来广营西路诚盈中心A座9层', 'lili@pj-l.com', '1', '0', null);
INSERT INTO `t_company` VALUES ('162', 'CO0003', '中亚宝丰国际物流有限公司华北区', '北京市顺义区顺平路580号航城广场B座902室', 'lili@pj-l.com', '161', '0', null);
INSERT INTO `t_company` VALUES ('163', 'CO0004', '中亚宝丰国际物流有限公司华东区', '上海市虹口区欧阳路85号金陵国际大厦25F', 'hanxiaojun@pj-l.com', '161', '0', null);
INSERT INTO `t_company` VALUES ('164', 'CO0005', '中亚宝丰国际物流有限公司华南区', '广东省深圳市罗湖区深南东路2001号鸿昌广场3803室', 'lili@pj-l.com', '161', '0', null);
INSERT INTO `t_company` VALUES ('165', 'CO0006', '中亚宝丰国际物流有限公司北京分公司', '北京市顺义区顺平路580号航城广场B座902室', 'lili@pj-l.com', '162', '0', null);

-- ----------------------------
-- Table structure for t_demp
-- ----------------------------
DROP TABLE IF EXISTS `t_demp`;
CREATE TABLE `t_demp` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `frontrank` int(11) DEFAULT NULL COMMENT '上级部门',
  `companyid` int(11) DEFAULT NULL COMMENT '企业id',
  `number` varchar(32) DEFAULT NULL COMMENT '部门编号',
  `pId` int(11) DEFAULT NULL COMMENT '父节点',
  `isdelete` int(11) DEFAULT '0' COMMENT '是否删除 0未删除  1已删除',
  `hierarchy` int(11) DEFAULT NULL COMMENT '层级',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_33` (`companyid`),
  KEY `FK_Reference_57` (`pId`),
  CONSTRAINT `FK_Reference_33` FOREIGN KEY (`companyid`) REFERENCES `t_company` (`id`),
  CONSTRAINT `FK_Reference_57` FOREIGN KEY (`pId`) REFERENCES `t_demp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=423 DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of t_demp
-- ----------------------------
INSERT INTO `t_demp` VALUES ('96', '总裁办', null, '1', 'DEMP0001', null, '0', null);
INSERT INTO `t_demp` VALUES ('400', '海运事业部', null, '161', 'DEMP0002', null, '0', null);
INSERT INTO `t_demp` VALUES ('401', '工程物流事业部', null, '161', 'DEMP0003', null, '0', null);
INSERT INTO `t_demp` VALUES ('402', '市场部', null, '161', 'DEMP0004', null, '0', null);
INSERT INTO `t_demp` VALUES ('403', '海外事业部', null, '161', 'DEMP0005', null, '0', null);
INSERT INTO `t_demp` VALUES ('404', '财务部', null, '161', 'DEMP0006', null, '0', null);
INSERT INTO `t_demp` VALUES ('405', '海运集运部', null, '161', 'DEMP0007', '400', '0', null);
INSERT INTO `t_demp` VALUES ('406', '海运操作部', null, '161', 'DEMP0008', '400', '0', null);
INSERT INTO `t_demp` VALUES ('407', '研发中心', null, '1', 'DEMP0009', null, '0', null);
INSERT INTO `t_demp` VALUES ('408', '计划财务中心', null, '1', 'DEMP0010', null, '0', null);
INSERT INTO `t_demp` VALUES ('409', '人力行政中心', null, '1', 'DEMP0011', null, '0', null);
INSERT INTO `t_demp` VALUES ('410', '流程管理中心', null, '1', 'DEMP0012', null, '0', null);
INSERT INTO `t_demp` VALUES ('411', '品牌中心', null, '1', 'DEMP0013', null, '0', null);
INSERT INTO `t_demp` VALUES ('412', '财务部', null, '165', 'DEMP0014', null, '0', null);
INSERT INTO `t_demp` VALUES ('413', '大客户部', null, '165', 'DEMP0015', null, '0', null);
INSERT INTO `t_demp` VALUES ('414', '航线部', null, '165', 'DEMP0016', null, '0', null);
INSERT INTO `t_demp` VALUES ('415', '进口部', null, '165', 'DEMP0017', null, '0', null);
INSERT INTO `t_demp` VALUES ('416', '销售部', null, '165', 'DEMP0018', null, '0', null);
INSERT INTO `t_demp` VALUES ('417', '操作部', null, '165', 'DEMP0019', null, '0', null);
INSERT INTO `t_demp` VALUES ('418', '行政部', null, '165', 'DEMP0020', null, '0', null);
INSERT INTO `t_demp` VALUES ('419', '业务结算部', null, '165', 'DEMP0021', null, '0', null);
INSERT INTO `t_demp` VALUES ('420', '单证部', null, '165', 'DEMP0022', null, '0', null);
INSERT INTO `t_demp` VALUES ('421', '人力行政部', null, '161', 'DEMP0023', null, '0', null);
INSERT INTO `t_demp` VALUES ('422', '测试部门', null, '161', 'DEMP0024', null, '1', null);

-- ----------------------------
-- Table structure for t_education
-- ----------------------------
DROP TABLE IF EXISTS `t_education`;
CREATE TABLE `t_education` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `learning_time` varchar(128) DEFAULT NULL COMMENT '学习时间',
  `campus` varchar(64) DEFAULT NULL COMMENT '院校',
  `specialty` varchar(64) DEFAULT NULL COMMENT '专业',
  `education` varchar(64) DEFAULT NULL COMMENT '学历',
  `is_full_time` varchar(11) DEFAULT NULL COMMENT '是否为全日制 否  是',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=255 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_education
-- ----------------------------
INSERT INTO `t_education` VALUES ('219', '', '', '', '', '', '433');
INSERT INTO `t_education` VALUES ('220', '', '', '', '', '', '433');
INSERT INTO `t_education` VALUES ('221', '', '', '', '', '', '433');
INSERT INTO `t_education` VALUES ('222', '', '', '', '', '', '433');
INSERT INTO `t_education` VALUES ('223', '', '', '', '', '', '425');
INSERT INTO `t_education` VALUES ('224', '', '', '', '', '', '425');
INSERT INTO `t_education` VALUES ('225', '', '', '', '', '', '425');
INSERT INTO `t_education` VALUES ('226', '', '', '', '', '', '425');
INSERT INTO `t_education` VALUES ('227', '', '', '', '', '', '423');
INSERT INTO `t_education` VALUES ('228', '', '', '', '', '', '423');
INSERT INTO `t_education` VALUES ('229', '', '', '', '', '', '423');
INSERT INTO `t_education` VALUES ('230', '', '', '', '', '', '423');
INSERT INTO `t_education` VALUES ('231', '', '', '', '', '', '397');
INSERT INTO `t_education` VALUES ('232', '', '', '', '', '', '397');
INSERT INTO `t_education` VALUES ('233', '', '', '', '', '', '397');
INSERT INTO `t_education` VALUES ('234', '', '', '', '', '', '397');
INSERT INTO `t_education` VALUES ('235', '', '', '', '', '', '398');
INSERT INTO `t_education` VALUES ('236', '', '', '', '', '', '398');
INSERT INTO `t_education` VALUES ('237', '', '', '', '', '', '398');
INSERT INTO `t_education` VALUES ('238', '', '', '', '', '', '398');
INSERT INTO `t_education` VALUES ('239', '', '', '', '', '', '488');
INSERT INTO `t_education` VALUES ('240', '', '', '', '', '', '488');
INSERT INTO `t_education` VALUES ('241', '', '', '', '', '', '488');
INSERT INTO `t_education` VALUES ('242', '', '', '', '', '', '488');
INSERT INTO `t_education` VALUES ('243', '', '', '', '', '', '808');
INSERT INTO `t_education` VALUES ('244', '', '', '', '', '', '808');
INSERT INTO `t_education` VALUES ('245', '', '', '', '', '', '808');
INSERT INTO `t_education` VALUES ('246', '', '', '', '', '', '808');
INSERT INTO `t_education` VALUES ('247', '2006年9月至2010年7月', '东北林业大学', '室内与家具', '本科', '是', '809');
INSERT INTO `t_education` VALUES ('248', '', '', '', '', '', '809');
INSERT INTO `t_education` VALUES ('249', '', '', '', '', '', '809');
INSERT INTO `t_education` VALUES ('250', '', '', '', '', '', '809');
INSERT INTO `t_education` VALUES ('251', '', '', '', '', '', '388');
INSERT INTO `t_education` VALUES ('252', '', '', '', '', '', '388');
INSERT INTO `t_education` VALUES ('253', '', '', '', '', '', '388');
INSERT INTO `t_education` VALUES ('254', '', '', '', '', '', '388');

-- ----------------------------
-- Table structure for t_family_member
-- ----------------------------
DROP TABLE IF EXISTS `t_family_member`;
CREATE TABLE `t_family_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(32) DEFAULT NULL COMMENT '家庭成员名称',
  `work_unit` varchar(127) DEFAULT NULL COMMENT '工作单位',
  `duty` varchar(32) DEFAULT NULL COMMENT '职务',
  `phone` varchar(32) DEFAULT NULL COMMENT '联系电话',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `relation` varchar(32) DEFAULT NULL COMMENT '关系',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=251 DEFAULT CHARSET=utf8 COMMENT='家庭成员';

-- ----------------------------
-- Records of t_family_member
-- ----------------------------
INSERT INTO `t_family_member` VALUES ('215', '', '', '', '', '433', '');
INSERT INTO `t_family_member` VALUES ('216', '', '', '', '', '433', '');
INSERT INTO `t_family_member` VALUES ('217', '', '', '', '', '433', '');
INSERT INTO `t_family_member` VALUES ('218', '', '', '', '', '433', '');
INSERT INTO `t_family_member` VALUES ('219', '', '', '', '', '425', '');
INSERT INTO `t_family_member` VALUES ('220', '', '', '', '', '425', '');
INSERT INTO `t_family_member` VALUES ('221', '', '', '', '', '425', '');
INSERT INTO `t_family_member` VALUES ('222', '', '', '', '', '425', '');
INSERT INTO `t_family_member` VALUES ('223', '', '', '', '', '423', '');
INSERT INTO `t_family_member` VALUES ('224', '', '', '', '', '423', '');
INSERT INTO `t_family_member` VALUES ('225', '', '', '', '', '423', '');
INSERT INTO `t_family_member` VALUES ('226', '', '', '', '', '423', '');
INSERT INTO `t_family_member` VALUES ('227', '', '', '', '', '397', '');
INSERT INTO `t_family_member` VALUES ('228', '', '', '', '', '397', '');
INSERT INTO `t_family_member` VALUES ('229', '', '', '', '', '397', '');
INSERT INTO `t_family_member` VALUES ('230', '', '', '', '', '397', '');
INSERT INTO `t_family_member` VALUES ('231', '', '', '', '', '398', '');
INSERT INTO `t_family_member` VALUES ('232', '', '', '', '', '398', '');
INSERT INTO `t_family_member` VALUES ('233', '', '', '', '', '398', '');
INSERT INTO `t_family_member` VALUES ('234', '', '', '', '', '398', '');
INSERT INTO `t_family_member` VALUES ('235', '', '', '', '', '488', '');
INSERT INTO `t_family_member` VALUES ('236', '', '', '', '', '488', '');
INSERT INTO `t_family_member` VALUES ('237', '', '', '', '', '488', '');
INSERT INTO `t_family_member` VALUES ('238', '', '', '', '', '488', '');
INSERT INTO `t_family_member` VALUES ('239', '蔡小龙', '北京京剧院', '导演', '13801379871', '808', '父女');
INSERT INTO `t_family_member` VALUES ('240', '翟英', '中国农业银行', '退休', '13911092353', '808', '母女');
INSERT INTO `t_family_member` VALUES ('241', '', '', '', '', '808', '');
INSERT INTO `t_family_member` VALUES ('242', '', '', '', '', '808', '');
INSERT INTO `t_family_member` VALUES ('243', '郝鑫', '紫光集团', '投资经理', '15201216852', '809', '夫妻');
INSERT INTO `t_family_member` VALUES ('244', '', '', '', '', '809', '');
INSERT INTO `t_family_member` VALUES ('245', '', '', '', '', '809', '');
INSERT INTO `t_family_member` VALUES ('246', '', '', '', '', '809', '');
INSERT INTO `t_family_member` VALUES ('247', '', '', '', '', '388', '');
INSERT INTO `t_family_member` VALUES ('248', '', '', '', '', '388', '');
INSERT INTO `t_family_member` VALUES ('249', '', '', '', '', '388', '');
INSERT INTO `t_family_member` VALUES ('250', '', '', '', '', '388', '');

-- ----------------------------
-- Table structure for t_festival
-- ----------------------------
DROP TABLE IF EXISTS `t_festival`;
CREATE TABLE `t_festival` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `holiday_name` varchar(16) DEFAULT NULL COMMENT '假日名城',
  `holiday_data` date DEFAULT NULL COMMENT '假日时间',
  `year` varchar(16) DEFAULT NULL COMMENT '所属年份',
  `month` varchar(16) DEFAULT NULL COMMENT '所属月份',
  `isHoliday` tinyint(4) DEFAULT NULL COMMENT 'true节假日  false节后补班',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_festival
-- ----------------------------
INSERT INTO `t_festival` VALUES ('1', '元旦假日', '2017-01-01', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('2', '元旦(补休)', '2017-01-02', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('3', '春节假日', '2017-01-27', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('4', '春节假日', '2017-01-28', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('5', '春节假日', '2017-01-29', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('6', '春节假日', '2017-01-30', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('7', '春节假日', '2017-01-31', '2017', '1', '1');
INSERT INTO `t_festival` VALUES ('8', '春节假日', '2017-02-01', '2017', '2', '1');
INSERT INTO `t_festival` VALUES ('9', '春节假日', '2017-02-02', '2017', '2', '1');
INSERT INTO `t_festival` VALUES ('10', '清明节假日', '2017-04-02', '2017', '4', '1');
INSERT INTO `t_festival` VALUES ('11', '清明节假日', '2017-04-03', '2017', '4', '1');
INSERT INTO `t_festival` VALUES ('12', '清明节假日', '2017-04-04', '2017', '4', '1');
INSERT INTO `t_festival` VALUES ('13', '劳动节假日', '2017-04-29', '2017', '4', '1');
INSERT INTO `t_festival` VALUES ('14', '劳动节假日', '2017-04-30', '2017', '4', '1');
INSERT INTO `t_festival` VALUES ('15', '劳动节假日', '2017-05-01', '2017', '5', '1');
INSERT INTO `t_festival` VALUES ('16', '端午节假日', '2017-05-28', '2017', '5', '1');
INSERT INTO `t_festival` VALUES ('17', '端午节假日', '2017-05-29', '2017', '5', '1');
INSERT INTO `t_festival` VALUES ('18', '端午节假日', '2017-05-30', '2017', '5', '1');
INSERT INTO `t_festival` VALUES ('19', '国庆节(中秋节)假日', '2017-10-01', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('20', '国庆节(中秋节)假日', '2017-10-02', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('21', '国庆节(中秋节)假日', '2017-10-03', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('22', '国庆节(中秋节)假日', '2017-10-04', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('23', '国庆节(中秋节)假日', '2017-10-05', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('24', '国庆节(中秋节)假日', '2017-10-06', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('25', '国庆节(中秋节)假日', '2017-10-07', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('26', '国庆节(中秋节)假日', '2017-10-08', '2017', '10', '1');
INSERT INTO `t_festival` VALUES ('27', '春节前补班', '2017-01-22', '2017', '1', '0');
INSERT INTO `t_festival` VALUES ('28', '春节后补班', '2017-02-04', '2017', '2', '0');
INSERT INTO `t_festival` VALUES ('29', '清明节前补班', '2017-04-01', '2017', '4', '0');
INSERT INTO `t_festival` VALUES ('30', '劳动节前补班', '2017-05-27', '2017', '5', '0');
INSERT INTO `t_festival` VALUES ('31', '国庆节(中秋节)前补班', '2017-09-30', '2017', '9', '0');

-- ----------------------------
-- Table structure for t_position
-- ----------------------------
DROP TABLE IF EXISTS `t_position`;
CREATE TABLE `t_position` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '职位id',
  `number` varchar(32) DEFAULT NULL COMMENT '职位编号',
  `name` varchar(32) DEFAULT NULL COMMENT '职位名称',
  `description` varchar(64) DEFAULT NULL COMMENT '描述',
  `isdelete` int(11) DEFAULT '0' COMMENT '是否删除 0未删除  1已删除',
  `pId` int(11) DEFAULT NULL COMMENT '父节点',
  `grade` int(11) DEFAULT NULL COMMENT '等级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='职位表';

-- ----------------------------
-- Records of t_position
-- ----------------------------
INSERT INTO `t_position` VALUES ('1', 'PO0001', '总裁', '', '0', null, '1');
INSERT INTO `t_position` VALUES ('2', 'PO0002', '总监及以上', '', '0', null, '2');
INSERT INTO `t_position` VALUES ('3', 'PO0003', '经理', '', '0', null, '3');
INSERT INTO `t_position` VALUES ('4', 'PO0004', '主管及以下', '', '0', null, '4');

-- ----------------------------
-- Table structure for t_post
-- ----------------------------
DROP TABLE IF EXISTS `t_post`;
CREATE TABLE `t_post` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '岗位序号',
  `number` varchar(32) DEFAULT NULL COMMENT '岗位编号',
  `name` varchar(32) DEFAULT NULL COMMENT '岗位名称',
  `description` varchar(64) DEFAULT NULL COMMENT '描述',
  `isdelete` int(11) DEFAULT '0' COMMENT '是否删除 0未删除  1已删除',
  `demp_id` int(11) DEFAULT NULL COMMENT '部门id',
  `company_id` int(11) DEFAULT NULL COMMENT '公司id',
  `sign_num` varchar(200) DEFAULT NULL COMMENT '机构记录编码',
  PRIMARY KEY (`id`),
  KEY `FK_DempId` (`demp_id`),
  CONSTRAINT `t_post_ibfk_1` FOREIGN KEY (`demp_id`) REFERENCES `t_demp` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11248 DEFAULT CHARSET=utf8 COMMENT='岗位';

-- ----------------------------
-- Records of t_post
-- ----------------------------
INSERT INTO `t_post` VALUES ('79', 'ST0031', '总裁助理', '', '0', '96', '1', 'CO0001-DEMP0001-ST0031');
INSERT INTO `t_post` VALUES ('11146', 'ST0032', '华北区总经理', '', '0', null, '162', 'CO0001-CO0002-CO0003-ST0032');
INSERT INTO `t_post` VALUES ('11147', 'ST0033', '北京分公司总经理', '', '0', null, '165', 'CO0001-CO0002-CO0003-CO0006-ST0033');
INSERT INTO `t_post` VALUES ('11148', 'ST0034', '副总经理', '', '0', null, '165', 'CO0001-CO0002-CO0003-CO0006-ST0034');
INSERT INTO `t_post` VALUES ('11149', 'ST0035', '财务经理', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0035');
INSERT INTO `t_post` VALUES ('11150', 'ST0036', '财务主管', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0036');
INSERT INTO `t_post` VALUES ('11151', 'ST0037', '会计', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0037');
INSERT INTO `t_post` VALUES ('11152', 'ST0038', '出纳', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0038');
INSERT INTO `t_post` VALUES ('11153', 'ST0039', '制单员', '', '0', '420', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0039');
INSERT INTO `t_post` VALUES ('11154', 'ST0040', '报关员', '', '0', '420', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0040');
INSERT INTO `t_post` VALUES ('11155', 'ST0041', '制单主管', '', '0', '420', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0022-ST0041');
INSERT INTO `t_post` VALUES ('11156', 'ST0042', '经理', '', '0', '413', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0042');
INSERT INTO `t_post` VALUES ('11157', 'ST0043', '客服专员', '', '0', '413', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0043');
INSERT INTO `t_post` VALUES ('11158', 'ST0044', '客服主管', '', '0', '413', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0015-ST0044');
INSERT INTO `t_post` VALUES ('11159', 'ST0045', '经理', '', '0', '414', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0045');
INSERT INTO `t_post` VALUES ('11160', 'ST0046', '航线主管', '', '0', '414', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0046');
INSERT INTO `t_post` VALUES ('11161', 'ST0047', '经理', '', '0', '415', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0047');
INSERT INTO `t_post` VALUES ('11162', 'ST0048', '经理', '', '0', '416', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0048');
INSERT INTO `t_post` VALUES ('11163', 'ST0049', '客服专员', '', '0', '416', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0049');
INSERT INTO `t_post` VALUES ('11164', 'ST0050', '销售顾问', '', '0', '416', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0050');
INSERT INTO `t_post` VALUES ('11165', 'ST0051', '现场操作', '', '0', '417', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0051');
INSERT INTO `t_post` VALUES ('11166', 'ST0052', '跑单员', '', '0', '417', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0019-ST0052');
INSERT INTO `t_post` VALUES ('11167', 'ST0053', '行政专员', '', '0', '418', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0053');
INSERT INTO `t_post` VALUES ('11168', 'ST0054', '行政前台', '', '0', '418', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0054');
INSERT INTO `t_post` VALUES ('11169', 'ST0055', '司机', '', '0', '418', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0020-ST0055');
INSERT INTO `t_post` VALUES ('11170', 'ST0056', '总经理', '', '0', '400', '161', 'CO0001-CO0002-DEMP0002-ST0056');
INSERT INTO `t_post` VALUES ('11171', 'ST0057', '经理', '', '1', '400', '161', 'CO0001-CO0002-DEMP0002-ST0057');
INSERT INTO `t_post` VALUES ('11172', 'ST0058', '客服专员', '', '1', '400', '161', 'CO0001-CO0002-DEMP0002-ST0058');
INSERT INTO `t_post` VALUES ('11173', 'ST0059', '单证员', '', '1', '400', '161', 'CO0001-CO0002-DEMP0002-ST0059');
INSERT INTO `t_post` VALUES ('11174', 'ST0060', '操作专员', '', '1', '400', '161', 'CO0001-CO0002-DEMP0002-ST0060');
INSERT INTO `t_post` VALUES ('11175', 'ST0061', '销售顾问', '', '0', '400', '161', 'CO0001-CO0002-DEMP0002-ST0061');
INSERT INTO `t_post` VALUES ('11176', 'ST0062', '操作经理', '', '0', '406', '161', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0062');
INSERT INTO `t_post` VALUES ('11177', 'ST0063', '客服专员', '', '0', '406', '161', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0063');
INSERT INTO `t_post` VALUES ('11178', 'ST0064', '单证员', '', '0', '406', '161', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0064');
INSERT INTO `t_post` VALUES ('11179', 'ST0065', '操作专员', '', '0', '406', '161', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0065');
INSERT INTO `t_post` VALUES ('11180', 'ST0066', '销售顾问', '', '0', '406', '161', 'CO0001-CO0002-DEMP0002-DEMP0008-ST0066');
INSERT INTO `t_post` VALUES ('11181', 'ST0067', '经理', '', '0', '405', '161', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0067');
INSERT INTO `t_post` VALUES ('11182', 'ST0068', '客服专员', '', '1', '405', '161', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0068');
INSERT INTO `t_post` VALUES ('11183', 'ST0069', '单证员', '', '1', '405', '161', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0069');
INSERT INTO `t_post` VALUES ('11184', 'ST0070', '操作专员', '', '1', '405', '161', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0070');
INSERT INTO `t_post` VALUES ('11185', 'ST0071', '销售顾问', '', '1', '405', '161', 'CO0001-CO0002-DEMP0002-DEMP0007-ST0071');
INSERT INTO `t_post` VALUES ('11186', 'ST0072', '总经理', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0072');
INSERT INTO `t_post` VALUES ('11187', 'ST0073', '经理', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0073');
INSERT INTO `t_post` VALUES ('11188', 'ST0074', '副经理', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0074');
INSERT INTO `t_post` VALUES ('11189', 'ST0075', '操作经理', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0075');
INSERT INTO `t_post` VALUES ('11190', 'ST0076', '项目经理', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0076');
INSERT INTO `t_post` VALUES ('11191', 'ST0077', '客服专员', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0077');
INSERT INTO `t_post` VALUES ('11192', 'ST0078', '单证员', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0078');
INSERT INTO `t_post` VALUES ('11193', 'ST0079', '操作专员', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0079');
INSERT INTO `t_post` VALUES ('11194', 'ST0080', '销售顾问', '', '0', '401', '161', 'CO0001-CO0002-DEMP0003-ST0080');
INSERT INTO `t_post` VALUES ('11195', 'ST0081', '经理', '', '0', '402', '161', 'CO0001-CO0002-DEMP0004-ST0081');
INSERT INTO `t_post` VALUES ('11196', 'ST0082', '副经理', '', '0', '402', '161', 'CO0001-CO0002-DEMP0004-ST0082');
INSERT INTO `t_post` VALUES ('11197', 'ST0083', '市场调研主管', '', '0', '402', '161', 'CO0001-CO0002-DEMP0004-ST0083');
INSERT INTO `t_post` VALUES ('11198', 'ST0084', '经理', '', '0', '403', '161', 'CO0001-CO0002-DEMP0005-ST0084');
INSERT INTO `t_post` VALUES ('11199', 'ST0085', '客服主管', '', '0', '403', '161', 'CO0001-CO0002-DEMP0005-ST0085');
INSERT INTO `t_post` VALUES ('11200', 'ST0086', '财务经理', '', '0', '404', '161', 'CO0001-CO0002-DEMP0006-ST0086');
INSERT INTO `t_post` VALUES ('11201', 'ST0087', '财务主管', '', '0', '404', '161', 'CO0001-CO0002-DEMP0006-ST0087');
INSERT INTO `t_post` VALUES ('11202', 'ST0088', '会计', '', '0', '404', '161', 'CO0001-CO0002-DEMP0006-ST0088');
INSERT INTO `t_post` VALUES ('11203', 'ST0089', '出纳', '', '0', '404', '161', 'CO0001-CO0002-DEMP0006-ST0089');
INSERT INTO `t_post` VALUES ('11204', 'ST0090', 'CHO', '', '0', '409', '1', 'CO0001-DEMP0011-ST0090');
INSERT INTO `t_post` VALUES ('11205', 'ST0091', '薪酬福利经理', '', '0', '409', '1', 'CO0001-DEMP0011-ST0091');
INSERT INTO `t_post` VALUES ('11206', 'ST0092', '招聘主管', '', '0', '409', '1', 'CO0001-DEMP0011-ST0092');
INSERT INTO `t_post` VALUES ('11207', 'ST0093', 'HRBP', '', '0', '409', '1', 'CO0001-DEMP0011-ST0093');
INSERT INTO `t_post` VALUES ('11208', 'ST0094', '行政经理', '', '0', '409', '1', 'CO0001-DEMP0011-ST0094');
INSERT INTO `t_post` VALUES ('11209', 'ST0095', '行政助理', '', '0', '409', '1', 'CO0001-DEMP0011-ST0095');
INSERT INTO `t_post` VALUES ('11210', 'ST0096', '行政前台', '', '0', '409', '1', 'CO0001-DEMP0011-ST0096');
INSERT INTO `t_post` VALUES ('11211', 'ST0097', '司机', '', '0', '409', '1', 'CO0001-DEMP0011-ST0097');
INSERT INTO `t_post` VALUES ('11212', 'ST0098', '总裁', '', '0', null, '1', 'CO0001-ST0098');
INSERT INTO `t_post` VALUES ('11213', 'ST0099', '副总裁', '', '0', null, '1', 'CO0001-ST0099');
INSERT INTO `t_post` VALUES ('11214', 'ST0100', '总会计师', '', '0', '408', '1', 'CO0001-DEMP0010-ST0100');
INSERT INTO `t_post` VALUES ('11215', 'ST0101', '总裁助理', '', '0', '96', '1', 'CO0001-DEMP0001-ST0101');
INSERT INTO `t_post` VALUES ('11216', 'ST0102', 'CTO', '', '0', '407', '1', 'CO0001-DEMP0009-ST0102');
INSERT INTO `t_post` VALUES ('11217', 'ST0103', 'CPO', '', '0', '410', '1', 'CO0001-DEMP0012-ST0103');
INSERT INTO `t_post` VALUES ('11218', 'ST0104', '内控合规', '', '0', '410', '1', 'CO0001-DEMP0012-ST0104');
INSERT INTO `t_post` VALUES ('11219', 'ST0105', 'CMO', '', '0', '411', '1', 'CO0001-DEMP0013-ST0105');
INSERT INTO `t_post` VALUES ('11220', 'ST0106', '副总会计师', '', '0', '408', '1', 'CO0001-DEMP0010-ST0106');
INSERT INTO `t_post` VALUES ('11221', 'ST0107', '财务经理', '', '0', '408', '1', 'CO0001-DEMP0010-ST0107');
INSERT INTO `t_post` VALUES ('11222', 'ST0108', '会计', '', '0', '408', '1', 'CO0001-DEMP0010-ST0108');
INSERT INTO `t_post` VALUES ('11223', 'ST0109', '出纳', '', '0', '408', '1', 'CO0001-DEMP0010-ST0109');
INSERT INTO `t_post` VALUES ('11224', 'ST0110', '客服经理', '', '0', '415', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0110');
INSERT INTO `t_post` VALUES ('11225', 'ST0111', '客服员', '', '0', '415', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0017-ST0111');
INSERT INTO `t_post` VALUES ('11226', 'ST0112', '结算', '', '0', '419', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0112');
INSERT INTO `t_post` VALUES ('11227', 'ST0113', '总经理', '', '0', null, '161', 'CO0001-CO0002-ST0113');
INSERT INTO `t_post` VALUES ('11228', 'ST0114', '副总经理', '', '0', null, '161', 'CO0001-CO0002-ST0114');
INSERT INTO `t_post` VALUES ('11229', 'ST0115', '总裁', '', '1', null, '1', 'CO0001-ST0115');
INSERT INTO `t_post` VALUES ('11230', 'ST0116', '副总裁', '', '1', null, '1', 'CO0001-ST0116');
INSERT INTO `t_post` VALUES ('11231', 'ST0117', '总经理', '', '1', '400', '161', 'CO0001-CO0002-DEMP0002-ST0117');
INSERT INTO `t_post` VALUES ('11232', 'ST0118', '应收专员', '', '0', '419', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0118');
INSERT INTO `t_post` VALUES ('11233', 'ST0119', '应付专员', '', '0', '419', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0119');
INSERT INTO `t_post` VALUES ('11234', 'ST0120', '结算主管', '', '0', '419', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0021-ST0120');
INSERT INTO `t_post` VALUES ('11235', 'ST0121', '经理', '', '0', null, '165', 'CO0001-CO0002-CO0003-CO0006-ST0121');
INSERT INTO `t_post` VALUES ('11236', 'ST0122', '经理', '', '0', '414', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0016-ST0122');
INSERT INTO `t_post` VALUES ('11237', 'ST0123', '操作专员', '', '0', '416', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0018-ST0123');
INSERT INTO `t_post` VALUES ('11238', 'ST0124', '客服专员', '', '0', '403', '161', 'CO0001-CO0002-DEMP0005-ST0124');
INSERT INTO `t_post` VALUES ('11239', 'ST0125', '结算主管', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0125');
INSERT INTO `t_post` VALUES ('11240', 'ST0126', '应付专员', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0126');
INSERT INTO `t_post` VALUES ('11241', 'ST0127', '应收专员', '', '0', '412', '165', 'CO0001-CO0002-CO0003-CO0006-DEMP0014-ST0127');
INSERT INTO `t_post` VALUES ('11242', 'ST0128', 'HRBP head(华北区)', '', '0', '421', '161', 'CO0001-CO0002-DEMP0023-ST0128');
INSERT INTO `t_post` VALUES ('11243', 'ST0129', '总经理助理', '', '0', null, '161', 'CO0001-CO0002-ST0129');
INSERT INTO `t_post` VALUES ('11244', 'ST0130', '总经理助理', '', '0', null, '161', 'CO0001-CO0002-ST0130');
INSERT INTO `t_post` VALUES ('11245', 'ST0131', '人力行政经理（华北区）', '', '0', '421', '161', 'CO0001-CO0002-DEMP0023-ST0131');
INSERT INTO `t_post` VALUES ('11246', 'ST0132', '测试', '', '1', '422', '161', 'CO0001-CO0002-DEMP0024-ST0132');
INSERT INTO `t_post` VALUES ('11247', 'ST0133', '文件管理员', '', '0', '410', '1', 'CO0001-DEMP0012-ST0133');

-- ----------------------------
-- Table structure for t_rank
-- ----------------------------
DROP TABLE IF EXISTS `t_rank`;
CREATE TABLE `t_rank` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(32) DEFAULT NULL,
  `name` varchar(32) DEFAULT NULL,
  `isdelete` int(11) DEFAULT '0' COMMENT '是否删除 0未删除  1已删除',
  `hierarchy` int(11) DEFAULT NULL COMMENT '层级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rank
-- ----------------------------
INSERT INTO `t_rank` VALUES ('36', 'LE0001', 'T1', '0', null);
INSERT INTO `t_rank` VALUES ('37', 'LE0002', 'T2', '0', null);
INSERT INTO `t_rank` VALUES ('38', 'LE0003', 'T3', '0', null);
INSERT INTO `t_rank` VALUES ('39', 'LE0004', 'T4', '0', null);
INSERT INTO `t_rank` VALUES ('40', 'LE0005', '12123', '1', null);
INSERT INTO `t_rank` VALUES ('41', 'LE0007', '444555', '1', null);
INSERT INTO `t_rank` VALUES ('42', 'LE0008', '666', '1', null);
INSERT INTO `t_rank` VALUES ('43', 'LE0009', '777888', '1', null);
INSERT INTO `t_rank` VALUES ('44', 'LE00010', '999', '1', null);

-- ----------------------------
-- Table structure for t_salary
-- ----------------------------
DROP TABLE IF EXISTS `t_salary`;
CREATE TABLE `t_salary` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `total_salary` varchar(32) DEFAULT NULL COMMENT '总额',
  `reimbursement` varchar(32) DEFAULT NULL COMMENT '报销金额',
  `base_salary` varchar(32) DEFAULT NULL COMMENT '基本工资',
  `post_salary` varchar(32) DEFAULT NULL COMMENT '岗位工资',
  `performance_salary` varchar(32) DEFAULT NULL COMMENT '绩效工资',
  `lunch_allowance` varchar(32) DEFAULT NULL COMMENT '午餐补贴',
  `communication_allowance` varchar(32) DEFAULT NULL COMMENT '通讯补贴',
  `full_hours` varchar(32) DEFAULT NULL COMMENT '全勤',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `entry_id` int(11) DEFAULT NULL COMMENT '入职申请单id',
  `salary_type` int(11) DEFAULT NULL COMMENT '薪资类型    1 实习 2 试用  3转正',
  PRIMARY KEY (`id`),
  KEY `entry_id` (`entry_id`),
  CONSTRAINT `t_salary_ibfk_1` FOREIGN KEY (`entry_id`) REFERENCES `flow_entry` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1960 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_salary
-- ----------------------------
INSERT INTO `t_salary` VALUES ('1675', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '397', null, '2');
INSERT INTO `t_salary` VALUES ('1676', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '398', null, '2');
INSERT INTO `t_salary` VALUES ('1677', '1c8f49ab2212b3d17a12c547a83db6ba', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '399', null, '3');
INSERT INTO `t_salary` VALUES ('1678', '2a53cd52b22861c8e4dffd3878baae18', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '400', null, '3');
INSERT INTO `t_salary` VALUES ('1679', '3ea05d90aeb9258f5610d25d3919f0ef', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '401', null, '3');
INSERT INTO `t_salary` VALUES ('1680', '74a27c835527a7cff32cc71830c121c9', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '402', null, '3');
INSERT INTO `t_salary` VALUES ('1681', '74a27c835527a7cff32cc71830c121c1', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '403', null, '3');
INSERT INTO `t_salary` VALUES ('1682', '2514804a6c74b283a46396d3dc537541', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '404', null, '3');
INSERT INTO `t_salary` VALUES ('1683', '86d307d6f657f7e0700fd359e5d4be3a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '405', null, '3');
INSERT INTO `t_salary` VALUES ('1684', '4e59a796cb389023d4d8691607e7736b', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '406', null, '3');
INSERT INTO `t_salary` VALUES ('1685', '931da9c9e293b16bde4386c88bcd8f38', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '407', null, '3');
INSERT INTO `t_salary` VALUES ('1686', '637224cc232df475b68486541c1313f9', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '408', null, '3');
INSERT INTO `t_salary` VALUES ('1687', '6c2b6d8928c7eba622cefa371613a181', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '409', null, '3');
INSERT INTO `t_salary` VALUES ('1688', '746778deb4a9ddc103d0ea562b71b03b', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '410', null, '3');
INSERT INTO `t_salary` VALUES ('1689', '1c8f49ab2212b3d17a12c547a83db6ba', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '411', null, '3');
INSERT INTO `t_salary` VALUES ('1690', 'a06f27ddc2722324177c86a30d7b6119', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '412', null, '3');
INSERT INTO `t_salary` VALUES ('1691', '2a53cd52b22861c8e4dffd3878baae18', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '413', null, '3');
INSERT INTO `t_salary` VALUES ('1692', '637224cc232df475b68486541c1313f9', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '414', null, '3');
INSERT INTO `t_salary` VALUES ('1693', 'ff00e4b7da3eb7325cf5af4e8870225f', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '415', null, '3');
INSERT INTO `t_salary` VALUES ('1694', '3b896bc5b51acab6b585f0901aff4b74', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '416', null, '3');
INSERT INTO `t_salary` VALUES ('1695', '82196a370bf96e36aa74660d464c7608', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '417', null, '3');
INSERT INTO `t_salary` VALUES ('1696', '3789df4b3bb1548f5cec1407de6b96c9', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '418', null, '3');
INSERT INTO `t_salary` VALUES ('1697', '65e58718baaeb357a484ccbd9339230e', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '419', null, '3');
INSERT INTO `t_salary` VALUES ('1698', '65e58718baaeb357a484ccbd9339230e', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '420', null, '3');
INSERT INTO `t_salary` VALUES ('1699', 'ef7a75cadf8c532d2b0ac2b2ece187db', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '421', null, '3');
INSERT INTO `t_salary` VALUES ('1700', 'cff0cd0e6146e2ff0d9dcbc5c5079e7a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '422', null, '3');
INSERT INTO `t_salary` VALUES ('1701', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '423', null, '2');
INSERT INTO `t_salary` VALUES ('1702', '3ecb3a7825edf232b6f9dffa53c8155a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '424', null, '3');
INSERT INTO `t_salary` VALUES ('1703', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '425', null, '2');
INSERT INTO `t_salary` VALUES ('1704', '0db7b3853a8cb612a8344b5606547d10', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '426', null, '3');
INSERT INTO `t_salary` VALUES ('1705', '8d6ae826472df58dacc92e7858571373', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '427', null, '3');
INSERT INTO `t_salary` VALUES ('1706', '637224cc232df475b68486541c1313f9', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '428', null, '3');
INSERT INTO `t_salary` VALUES ('1707', '43b5f48341dfdc608e6e5ad97c45058b', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '429', null, '3');
INSERT INTO `t_salary` VALUES ('1708', 'dce2e3f0587d34fa4f6658f03b29abda', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '430', null, '3');
INSERT INTO `t_salary` VALUES ('1709', '43b5f48341dfdc608e6e5ad97c45058b', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '431', null, '3');
INSERT INTO `t_salary` VALUES ('1710', 'd9b853b9516efc196f13416718c962fa', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '432', null, '3');
INSERT INTO `t_salary` VALUES ('1711', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '433', null, '2');
INSERT INTO `t_salary` VALUES ('1712', 'c61e96e7179ea3007c04c4190b79d824', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '434', null, '3');
INSERT INTO `t_salary` VALUES ('1713', 'efb334fb5754516c4d91adce2d846848', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '435', null, '3');
INSERT INTO `t_salary` VALUES ('1714', '86fd5ab7f9414b0bcca103351583235b', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '436', null, '3');
INSERT INTO `t_salary` VALUES ('1715', 'dbba4536bb2ecfe52d8b387cb2674d76', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '437', null, '3');
INSERT INTO `t_salary` VALUES ('1716', '7c2401e88b9124779e881b70820551fd', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '438', null, '3');
INSERT INTO `t_salary` VALUES ('1717', 'a4bcd8420aa4ebf5357bdcffb582024a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '439', null, '3');
INSERT INTO `t_salary` VALUES ('1718', '9d3f2fdb341a73f132a2adc9f8fa0365', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '440', null, '3');
INSERT INTO `t_salary` VALUES ('1719', 'a6eaa18d2f59398d7573e414d1f12ba4', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '441', null, '3');
INSERT INTO `t_salary` VALUES ('1720', 'f551882c9454823c2a267cd5c996613e', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '442', null, '3');
INSERT INTO `t_salary` VALUES ('1721', 'c13b9aa0d72782b72621ce9889b9181c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '443', null, '3');
INSERT INTO `t_salary` VALUES ('1722', '322beacbf7f0ef08202d448d877a053a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '445', null, '3');
INSERT INTO `t_salary` VALUES ('1723', 'eaeb2e55ba2a6e74c9f1abae6fdee7e9', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '446', null, '3');
INSERT INTO `t_salary` VALUES ('1724', 'a6eaa18d2f59398d7573e414d1f12ba4', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '447', null, '3');
INSERT INTO `t_salary` VALUES ('1725', 'ec8cd37acc7097ac683bbc8bcae34547', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '448', null, '3');
INSERT INTO `t_salary` VALUES ('1726', '9f85cefdbfd92767671e08f8c43b3fff', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '449', null, '3');
INSERT INTO `t_salary` VALUES ('1727', 'efb334fb5754516c4d91adce2d846848', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '450', null, '3');
INSERT INTO `t_salary` VALUES ('1728', 'aab21c0df82ec5453e8eaa8eb6897494', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '451', null, '3');
INSERT INTO `t_salary` VALUES ('1729', 'dbba4536bb2ecfe52d8b387cb2674d76', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '452', null, '3');
INSERT INTO `t_salary` VALUES ('1730', '4abf8db088a9f3c45a6af327eb8211dd', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '453', null, '3');
INSERT INTO `t_salary` VALUES ('1731', '956ef93a44a828575ae679f530977e22', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '454', null, '3');
INSERT INTO `t_salary` VALUES ('1732', 'd08551860c61f133e4b11aa7a867367a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '455', null, '3');
INSERT INTO `t_salary` VALUES ('1733', '193d6125cb0dcca5d2a661f046a1d03d', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '456', null, '3');
INSERT INTO `t_salary` VALUES ('1734', 'b50f2c446ccf63197249b29cf21fd791', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '457', null, '3');
INSERT INTO `t_salary` VALUES ('1735', '7bc8ada998c5021c396f55f698c7f227', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '458', null, '3');
INSERT INTO `t_salary` VALUES ('1736', 'a1f338b2139faf6c83ec22947882ad87', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '459', null, '3');
INSERT INTO `t_salary` VALUES ('1737', '5768f7c501ee00de7239c2de1b39bc0c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '460', null, '3');
INSERT INTO `t_salary` VALUES ('1738', 'ebf0689609e5ff21bbb14ce2018583c1', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '461', null, '3');
INSERT INTO `t_salary` VALUES ('1739', 'b2699b7e2a1c2fda418b14d3d2d64c18', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '462', null, '3');
INSERT INTO `t_salary` VALUES ('1740', 'c497e082a0d773e8fa9e6ee6309bd325', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '463', null, '3');
INSERT INTO `t_salary` VALUES ('1741', 'fe45f59918b6254f1521ba309b81443f', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '464', null, '3');
INSERT INTO `t_salary` VALUES ('1742', '7c2401e88b9124779e881b70820551fd', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '465', null, '3');
INSERT INTO `t_salary` VALUES ('1743', '3008db2cb59899e73b6c04c1065a23fa', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '466', null, '3');
INSERT INTO `t_salary` VALUES ('1744', 'a7e4cb7a1ee14134e1a16109a0773d04', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '467', null, '3');
INSERT INTO `t_salary` VALUES ('1745', '6bb2fcebf0fd3fc7a4e54b68924b93e4', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '468', null, '3');
INSERT INTO `t_salary` VALUES ('1746', '322beacbf7f0ef08202d448d877a053a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '469', null, '3');
INSERT INTO `t_salary` VALUES ('1747', 'c13b9aa0d72782b72621ce9889b9181c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '470', null, '3');
INSERT INTO `t_salary` VALUES ('1748', '17da4e1747c6537a4fa5a6b04ece57d2', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '471', null, '3');
INSERT INTO `t_salary` VALUES ('1749', '482b512224858fa0a04bd1964ccdb11c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '473', null, '3');
INSERT INTO `t_salary` VALUES ('1750', '17dd62ed32eb67a6fe527ac1c908d924', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '474', null, '3');
INSERT INTO `t_salary` VALUES ('1751', 'b21d2b7f70fca63fc01076dd629fedff', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '475', null, '3');
INSERT INTO `t_salary` VALUES ('1752', '47c21f9435fc0c363478814164eb457f', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '476', null, '3');
INSERT INTO `t_salary` VALUES ('1753', '976c5f3036c5bfdacfb6ce38f5d8f672', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '477', null, '3');
INSERT INTO `t_salary` VALUES ('1754', '24c7574a4677f58ca2acd75b12c156fe', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '478', null, '3');
INSERT INTO `t_salary` VALUES ('1755', '3a9f669a3332d1758cbce5554689107b', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '479', null, '3');
INSERT INTO `t_salary` VALUES ('1756', 'ec8cd37acc7097ac683bbc8bcae34547', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '480', null, '3');
INSERT INTO `t_salary` VALUES ('1757', 'e63cc3c5041af8de228efc7bcda51afc', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '481', null, '3');
INSERT INTO `t_salary` VALUES ('1758', 'a2a2a33852f5a442a60fbccc34616409', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '482', null, '3');
INSERT INTO `t_salary` VALUES ('1759', '550947ef252eefbec1f3bab7ad265423', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '483', null, '3');
INSERT INTO `t_salary` VALUES ('1760', '550947ef252eefbec1f3bab7ad265423', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '484', null, '3');
INSERT INTO `t_salary` VALUES ('1761', '074ffedc0762e6461aa3e585975772a4', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '485', null, '3');
INSERT INTO `t_salary` VALUES ('1762', 'a8f1147e947da83ccad6ce8df9fd41dc', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '486', null, '3');
INSERT INTO `t_salary` VALUES ('1763', '7f1161a33b72411488931c2404c85e7f', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '487', null, '3');
INSERT INTO `t_salary` VALUES ('1764', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '488', null, '2');
INSERT INTO `t_salary` VALUES ('1765', '895f2eba666e7813a088b62dc95383dd', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '489', null, '3');
INSERT INTO `t_salary` VALUES ('1766', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '397', null, '1');
INSERT INTO `t_salary` VALUES ('1767', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '398', null, '1');
INSERT INTO `t_salary` VALUES ('1768', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '399', null, '2');
INSERT INTO `t_salary` VALUES ('1769', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '400', null, '2');
INSERT INTO `t_salary` VALUES ('1770', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '401', null, '2');
INSERT INTO `t_salary` VALUES ('1771', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '402', null, '2');
INSERT INTO `t_salary` VALUES ('1772', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '403', null, '2');
INSERT INTO `t_salary` VALUES ('1773', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '404', null, '2');
INSERT INTO `t_salary` VALUES ('1774', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '405', null, '2');
INSERT INTO `t_salary` VALUES ('1775', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '406', null, '2');
INSERT INTO `t_salary` VALUES ('1776', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '407', null, '2');
INSERT INTO `t_salary` VALUES ('1777', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '408', null, '2');
INSERT INTO `t_salary` VALUES ('1778', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '409', null, '2');
INSERT INTO `t_salary` VALUES ('1779', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '410', null, '2');
INSERT INTO `t_salary` VALUES ('1780', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '411', null, '2');
INSERT INTO `t_salary` VALUES ('1781', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '412', null, '2');
INSERT INTO `t_salary` VALUES ('1782', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '413', null, '2');
INSERT INTO `t_salary` VALUES ('1783', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '414', null, '2');
INSERT INTO `t_salary` VALUES ('1784', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '415', null, '2');
INSERT INTO `t_salary` VALUES ('1785', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '416', null, '2');
INSERT INTO `t_salary` VALUES ('1786', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '417', null, '2');
INSERT INTO `t_salary` VALUES ('1787', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '418', null, '2');
INSERT INTO `t_salary` VALUES ('1788', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '419', null, '2');
INSERT INTO `t_salary` VALUES ('1789', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '420', null, '2');
INSERT INTO `t_salary` VALUES ('1790', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '421', null, '2');
INSERT INTO `t_salary` VALUES ('1791', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '422', null, '2');
INSERT INTO `t_salary` VALUES ('1792', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '423', null, '1');
INSERT INTO `t_salary` VALUES ('1793', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '424', null, '2');
INSERT INTO `t_salary` VALUES ('1794', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '425', null, '1');
INSERT INTO `t_salary` VALUES ('1795', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '426', null, '2');
INSERT INTO `t_salary` VALUES ('1796', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '427', null, '2');
INSERT INTO `t_salary` VALUES ('1797', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '428', null, '2');
INSERT INTO `t_salary` VALUES ('1798', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '429', null, '2');
INSERT INTO `t_salary` VALUES ('1799', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '430', null, '2');
INSERT INTO `t_salary` VALUES ('1800', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '431', null, '2');
INSERT INTO `t_salary` VALUES ('1801', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '432', null, '2');
INSERT INTO `t_salary` VALUES ('1802', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '433', null, '1');
INSERT INTO `t_salary` VALUES ('1803', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '434', null, '2');
INSERT INTO `t_salary` VALUES ('1804', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '435', null, '2');
INSERT INTO `t_salary` VALUES ('1805', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '436', null, '2');
INSERT INTO `t_salary` VALUES ('1806', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '437', null, '2');
INSERT INTO `t_salary` VALUES ('1807', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '438', null, '2');
INSERT INTO `t_salary` VALUES ('1808', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '439', null, '2');
INSERT INTO `t_salary` VALUES ('1809', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '440', null, '2');
INSERT INTO `t_salary` VALUES ('1810', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '441', null, '2');
INSERT INTO `t_salary` VALUES ('1811', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '442', null, '2');
INSERT INTO `t_salary` VALUES ('1812', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '443', null, '2');
INSERT INTO `t_salary` VALUES ('1813', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '445', null, '2');
INSERT INTO `t_salary` VALUES ('1814', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '446', null, '2');
INSERT INTO `t_salary` VALUES ('1815', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '447', null, '2');
INSERT INTO `t_salary` VALUES ('1816', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '448', null, '2');
INSERT INTO `t_salary` VALUES ('1817', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '449', null, '2');
INSERT INTO `t_salary` VALUES ('1818', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '450', null, '2');
INSERT INTO `t_salary` VALUES ('1819', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '451', null, '2');
INSERT INTO `t_salary` VALUES ('1820', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '452', null, '2');
INSERT INTO `t_salary` VALUES ('1821', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '453', null, '2');
INSERT INTO `t_salary` VALUES ('1822', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '454', null, '2');
INSERT INTO `t_salary` VALUES ('1823', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '455', null, '2');
INSERT INTO `t_salary` VALUES ('1824', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '456', null, '2');
INSERT INTO `t_salary` VALUES ('1825', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '457', null, '2');
INSERT INTO `t_salary` VALUES ('1826', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '458', null, '2');
INSERT INTO `t_salary` VALUES ('1827', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '459', null, '2');
INSERT INTO `t_salary` VALUES ('1828', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '460', null, '2');
INSERT INTO `t_salary` VALUES ('1829', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '461', null, '2');
INSERT INTO `t_salary` VALUES ('1830', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '462', null, '2');
INSERT INTO `t_salary` VALUES ('1831', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '463', null, '2');
INSERT INTO `t_salary` VALUES ('1832', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '464', null, '2');
INSERT INTO `t_salary` VALUES ('1833', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '465', null, '2');
INSERT INTO `t_salary` VALUES ('1834', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '466', null, '2');
INSERT INTO `t_salary` VALUES ('1835', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '467', null, '2');
INSERT INTO `t_salary` VALUES ('1836', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '468', null, '2');
INSERT INTO `t_salary` VALUES ('1837', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '469', null, '2');
INSERT INTO `t_salary` VALUES ('1838', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '470', null, '2');
INSERT INTO `t_salary` VALUES ('1839', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '471', null, '2');
INSERT INTO `t_salary` VALUES ('1840', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '473', null, '2');
INSERT INTO `t_salary` VALUES ('1841', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '474', null, '2');
INSERT INTO `t_salary` VALUES ('1842', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '475', null, '2');
INSERT INTO `t_salary` VALUES ('1843', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '476', null, '2');
INSERT INTO `t_salary` VALUES ('1844', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '477', null, '2');
INSERT INTO `t_salary` VALUES ('1845', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '478', null, '2');
INSERT INTO `t_salary` VALUES ('1846', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '479', null, '2');
INSERT INTO `t_salary` VALUES ('1847', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '480', null, '2');
INSERT INTO `t_salary` VALUES ('1848', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '481', null, '2');
INSERT INTO `t_salary` VALUES ('1849', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '482', null, '2');
INSERT INTO `t_salary` VALUES ('1850', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '483', null, '2');
INSERT INTO `t_salary` VALUES ('1851', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '484', null, '2');
INSERT INTO `t_salary` VALUES ('1852', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '485', null, '2');
INSERT INTO `t_salary` VALUES ('1853', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '486', null, '2');
INSERT INTO `t_salary` VALUES ('1854', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '487', null, '2');
INSERT INTO `t_salary` VALUES ('1855', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '488', null, '1');
INSERT INTO `t_salary` VALUES ('1856', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '489', null, '2');
INSERT INTO `t_salary` VALUES ('1857', '10f70f3da9ec86238bbd8ea1a8755ff3', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '397', null, '3');
INSERT INTO `t_salary` VALUES ('1858', 'd72ba8fb2c4072d120454221db2a815f', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '398', null, '3');
INSERT INTO `t_salary` VALUES ('1859', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '399', null, '1');
INSERT INTO `t_salary` VALUES ('1860', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '400', null, '1');
INSERT INTO `t_salary` VALUES ('1861', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '401', null, '1');
INSERT INTO `t_salary` VALUES ('1862', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '402', null, '1');
INSERT INTO `t_salary` VALUES ('1863', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '403', null, '1');
INSERT INTO `t_salary` VALUES ('1864', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '404', null, '1');
INSERT INTO `t_salary` VALUES ('1865', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '405', null, '1');
INSERT INTO `t_salary` VALUES ('1866', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '406', null, '1');
INSERT INTO `t_salary` VALUES ('1867', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '407', null, '1');
INSERT INTO `t_salary` VALUES ('1868', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '408', null, '1');
INSERT INTO `t_salary` VALUES ('1869', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '409', null, '1');
INSERT INTO `t_salary` VALUES ('1870', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '410', null, '1');
INSERT INTO `t_salary` VALUES ('1871', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '411', null, '1');
INSERT INTO `t_salary` VALUES ('1872', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '412', null, '1');
INSERT INTO `t_salary` VALUES ('1873', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '413', null, '1');
INSERT INTO `t_salary` VALUES ('1874', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '414', null, '1');
INSERT INTO `t_salary` VALUES ('1875', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '415', null, '1');
INSERT INTO `t_salary` VALUES ('1876', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '416', null, '1');
INSERT INTO `t_salary` VALUES ('1877', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '417', null, '1');
INSERT INTO `t_salary` VALUES ('1878', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '418', null, '1');
INSERT INTO `t_salary` VALUES ('1879', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '419', null, '1');
INSERT INTO `t_salary` VALUES ('1880', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '420', null, '1');
INSERT INTO `t_salary` VALUES ('1881', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '421', null, '1');
INSERT INTO `t_salary` VALUES ('1882', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '422', null, '1');
INSERT INTO `t_salary` VALUES ('1883', '6c6bd6f219d8254bb6a35444769d929c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '423', null, '3');
INSERT INTO `t_salary` VALUES ('1884', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '424', null, '1');
INSERT INTO `t_salary` VALUES ('1885', 'f26a7bd9c837072aac944e37df4999b6', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '425', null, '3');
INSERT INTO `t_salary` VALUES ('1886', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '426', null, '1');
INSERT INTO `t_salary` VALUES ('1887', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '427', null, '1');
INSERT INTO `t_salary` VALUES ('1888', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '428', null, '1');
INSERT INTO `t_salary` VALUES ('1889', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '429', null, '1');
INSERT INTO `t_salary` VALUES ('1890', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '430', null, '1');
INSERT INTO `t_salary` VALUES ('1891', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '431', null, '1');
INSERT INTO `t_salary` VALUES ('1892', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '432', null, '1');
INSERT INTO `t_salary` VALUES ('1893', 'b259e54bfdfd47e5a26a7a964d4b1ee3', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '433', null, '3');
INSERT INTO `t_salary` VALUES ('1894', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '434', null, '1');
INSERT INTO `t_salary` VALUES ('1895', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '435', null, '1');
INSERT INTO `t_salary` VALUES ('1896', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '436', null, '1');
INSERT INTO `t_salary` VALUES ('1897', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '437', null, '1');
INSERT INTO `t_salary` VALUES ('1898', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '438', null, '1');
INSERT INTO `t_salary` VALUES ('1899', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '439', null, '1');
INSERT INTO `t_salary` VALUES ('1900', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '440', null, '1');
INSERT INTO `t_salary` VALUES ('1901', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '441', null, '1');
INSERT INTO `t_salary` VALUES ('1902', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '442', null, '1');
INSERT INTO `t_salary` VALUES ('1903', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '443', null, '1');
INSERT INTO `t_salary` VALUES ('1904', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '445', null, '1');
INSERT INTO `t_salary` VALUES ('1905', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '446', null, '1');
INSERT INTO `t_salary` VALUES ('1906', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '447', null, '1');
INSERT INTO `t_salary` VALUES ('1907', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '448', null, '1');
INSERT INTO `t_salary` VALUES ('1908', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '449', null, '1');
INSERT INTO `t_salary` VALUES ('1909', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '450', null, '1');
INSERT INTO `t_salary` VALUES ('1910', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '451', null, '1');
INSERT INTO `t_salary` VALUES ('1911', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '452', null, '1');
INSERT INTO `t_salary` VALUES ('1912', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '453', null, '1');
INSERT INTO `t_salary` VALUES ('1913', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '454', null, '1');
INSERT INTO `t_salary` VALUES ('1914', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '455', null, '1');
INSERT INTO `t_salary` VALUES ('1915', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '456', null, '1');
INSERT INTO `t_salary` VALUES ('1916', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '457', null, '1');
INSERT INTO `t_salary` VALUES ('1917', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '458', null, '1');
INSERT INTO `t_salary` VALUES ('1918', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '459', null, '1');
INSERT INTO `t_salary` VALUES ('1919', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '460', null, '1');
INSERT INTO `t_salary` VALUES ('1920', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '461', null, '1');
INSERT INTO `t_salary` VALUES ('1921', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '462', null, '1');
INSERT INTO `t_salary` VALUES ('1922', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '463', null, '1');
INSERT INTO `t_salary` VALUES ('1923', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '464', null, '1');
INSERT INTO `t_salary` VALUES ('1924', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '465', null, '1');
INSERT INTO `t_salary` VALUES ('1925', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '466', null, '1');
INSERT INTO `t_salary` VALUES ('1926', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '467', null, '1');
INSERT INTO `t_salary` VALUES ('1927', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '468', null, '1');
INSERT INTO `t_salary` VALUES ('1928', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '469', null, '1');
INSERT INTO `t_salary` VALUES ('1929', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '470', null, '1');
INSERT INTO `t_salary` VALUES ('1930', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '471', null, '1');
INSERT INTO `t_salary` VALUES ('1931', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '473', null, '1');
INSERT INTO `t_salary` VALUES ('1932', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '474', null, '1');
INSERT INTO `t_salary` VALUES ('1933', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '475', null, '1');
INSERT INTO `t_salary` VALUES ('1934', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '476', null, '1');
INSERT INTO `t_salary` VALUES ('1935', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '477', null, '1');
INSERT INTO `t_salary` VALUES ('1936', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '478', null, '1');
INSERT INTO `t_salary` VALUES ('1937', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '479', null, '1');
INSERT INTO `t_salary` VALUES ('1938', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '480', null, '1');
INSERT INTO `t_salary` VALUES ('1939', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '481', null, '1');
INSERT INTO `t_salary` VALUES ('1940', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '482', null, '1');
INSERT INTO `t_salary` VALUES ('1941', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '483', null, '1');
INSERT INTO `t_salary` VALUES ('1942', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '484', null, '1');
INSERT INTO `t_salary` VALUES ('1943', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '485', null, '1');
INSERT INTO `t_salary` VALUES ('1944', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '486', null, '1');
INSERT INTO `t_salary` VALUES ('1945', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '487', null, '1');
INSERT INTO `t_salary` VALUES ('1946', '6c2b6d8928c7eba622cefa371613a181', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '488', null, '3');
INSERT INTO `t_salary` VALUES ('1947', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '489', null, '1');
INSERT INTO `t_salary` VALUES ('1948', 'd1095085f8da0c13089ff4a2779c7a96', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '86d8dc9a088db5b0ad817224264d8d04', 'ae78dcedf6e01d05c5bb8200b9abba9e', '9d1ba8278f7ad144575e4497735702d3', '1fd08957851b0e443b5e61abaf79445d', '2c26b1502429e94652eb54cd50a126b7', '126278bd1461c7044d72712b4eca0b7a', null, '574', '2');
INSERT INTO `t_salary` VALUES ('1949', 'd1095085f8da0c13089ff4a2779c7a96', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '86d8dc9a088db5b0ad817224264d8d04', 'ae78dcedf6e01d05c5bb8200b9abba9e', '9d1ba8278f7ad144575e4497735702d3', '1fd08957851b0e443b5e61abaf79445d', '2c26b1502429e94652eb54cd50a126b7', '126278bd1461c7044d72712b4eca0b7a', null, '574', '3');
INSERT INTO `t_salary` VALUES ('1950', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', null, '574', '1');
INSERT INTO `t_salary` VALUES ('1951', 'a4bcd8420aa4ebf5357bdcffb582024a', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '86d8dc9a088db5b0ad817224264d8d04', '9d1ba8278f7ad144575e4497735702d3', '0e86b9551059858c92d291a1df39edda', '1fd08957851b0e443b5e61abaf79445d', '2c26b1502429e94652eb54cd50a126b7', '8761257222b3ef545ad370432ef9a90c', '808', '575', '2');
INSERT INTO `t_salary` VALUES ('1952', 'd1095085f8da0c13089ff4a2779c7a96', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '86d8dc9a088db5b0ad817224264d8d04', '9d1ba8278f7ad144575e4497735702d3', '9d1ba8278f7ad144575e4497735702d3', '1fd08957851b0e443b5e61abaf79445d', '2c26b1502429e94652eb54cd50a126b7', '8761257222b3ef545ad370432ef9a90c', '808', '575', '3');
INSERT INTO `t_salary` VALUES ('1953', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '808', '575', '1');
INSERT INTO `t_salary` VALUES ('1954', 'd1095085f8da0c13089ff4a2779c7a96', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '86d8dc9a088db5b0ad817224264d8d04', '9d1ba8278f7ad144575e4497735702d3', '9d1ba8278f7ad144575e4497735702d3', '1fd08957851b0e443b5e61abaf79445d', '2c26b1502429e94652eb54cd50a126b7', '8761257222b3ef545ad370432ef9a90c', '809', '576', '3');
INSERT INTO `t_salary` VALUES ('1955', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '809', '576', '1');
INSERT INTO `t_salary` VALUES ('1956', 'd1095085f8da0c13089ff4a2779c7a96', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '86d8dc9a088db5b0ad817224264d8d04', '9d1ba8278f7ad144575e4497735702d3', '9d1ba8278f7ad144575e4497735702d3', '1fd08957851b0e443b5e61abaf79445d', '2c26b1502429e94652eb54cd50a126b7', '8761257222b3ef545ad370432ef9a90c', '809', '576', '2');
INSERT INTO `t_salary` VALUES ('1957', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '388', null, '2');
INSERT INTO `t_salary` VALUES ('1958', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '388', null, '3');
INSERT INTO `t_salary` VALUES ('1959', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', 'b0cc8a7cafdf6bce5a6554e5beb22f7c', '388', null, '1');

-- ----------------------------
-- Table structure for t_system_role
-- ----------------------------
DROP TABLE IF EXISTS `t_system_role`;
CREATE TABLE `t_system_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL COMMENT '角色',
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  `terrace` varchar(16) DEFAULT NULL COMMENT '所属平台',
  `role_name` varchar(32) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=105 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_system_role
-- ----------------------------
INSERT INTO `t_system_role` VALUES ('93', '1', '52', 'quotation', '可维护');
INSERT INTO `t_system_role` VALUES ('101', '2', '18', 'quotation', '可维护');
INSERT INTO `t_system_role` VALUES ('102', '2', '5', 'quotation', '可维护');
INSERT INTO `t_system_role` VALUES ('104', '2', '22', 'quotation', '可维护');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `company_email` varchar(128) DEFAULT NULL,
  `companyid` int(11) DEFAULT NULL COMMENT '公司id',
  `dempid` int(11) DEFAULT NULL COMMENT '部门id',
  `positionid` int(11) DEFAULT NULL COMMENT '职位id',
  `postid` int(11) DEFAULT NULL COMMENT '岗位序号',
  `username` varchar(32) DEFAULT NULL COMMENT '用户名',
  `sex` varchar(11) DEFAULT NULL COMMENT '性别 ',
  `nation` varchar(12) DEFAULT NULL COMMENT '民族',
  `filenumber` varchar(32) DEFAULT NULL COMMENT '工号',
  `work_address` varchar(256) DEFAULT NULL COMMENT '工作地址',
  `pid` int(11) DEFAULT NULL COMMENT '所属上级',
  `identityproof` varchar(32) DEFAULT NULL COMMENT '身份证',
  `identityproof_address` varchar(32) DEFAULT NULL COMMENT '身份证地址',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `residential_address` varchar(1024) DEFAULT NULL COMMENT '居住地址',
  `i_email` varchar(128) DEFAULT NULL COMMENT '个人邮箱',
  `is_ding_talk` int(11) DEFAULT '0' COMMENT '是否开通今钉钉 1是 0否',
  `is_status` int(11) DEFAULT '1' COMMENT '激活状态  1已激活 0停用',
  `contract_type` int(11) DEFAULT NULL COMMENT '合同类型 0劳动合同  1实习合同  2劳务合同',
  `hiredate` date DEFAULT NULL COMMENT '入职时间',
  `contract_period` varchar(11) DEFAULT NULL COMMENT '合同期限',
  `leavedate` date DEFAULT NULL COMMENT '离职时间',
  `probation` varchar(11) DEFAULT NULL COMMENT '试用期',
  `regulardate` date DEFAULT NULL COMMENT '转正时间',
  `apply_regular_date` date DEFAULT NULL COMMENT '申请转正时间',
  `contract_start_time` date DEFAULT NULL COMMENT '合同开始日期',
  `contract_stop_time` date DEFAULT NULL COMMENT '合同终止时间',
  `contacts` varchar(256) DEFAULT NULL COMMENT '紧急联系人及电话',
  `marital_status` int(11) DEFAULT NULL COMMENT '婚姻状况 0 未 1 已 2离异  3 未知',
  `child_status` int(11) DEFAULT '2' COMMENT '子女状况 0 未 1 已 2未知',
  `education` int(11) DEFAULT NULL COMMENT '学历',
  `school` varchar(64) DEFAULT NULL COMMENT '学校',
  `is_fulltime` int(11) DEFAULT '2' COMMENT '是否全日制 1是0否 2 未知',
  `is_new_ginseng` int(11) DEFAULT '2' COMMENT '是否为新参保 1 是 0否  2未知',
  `is_social_security_cards` int(11) DEFAULT '2' COMMENT '是否有社保卡   1 是 0否 2未知',
  `is_accumulation_fund` int(11) DEFAULT '2' COMMENT '是否有公积金 1是 0否 2未知',
  `alnature` varchar(12) DEFAULT '2' COMMENT '户口性质 1 农业 0 城镇  2未知',
  `social_security_cardinal_number` varchar(128) DEFAULT NULL COMMENT '社保基数',
  `accumulation_fund_cardinal_number` varchar(128) DEFAULT NULL COMMENT '公积金基数',
  `social_security_payment_address` varchar(1024) DEFAULT NULL COMMENT '社保缴纳地址',
  `deposit_bank` varchar(256) DEFAULT NULL COMMENT '开户银行信息',
  `bankcard` varchar(256) DEFAULT NULL COMMENT '银行卡',
  `isdelete` int(11) DEFAULT '0' COMMENT '是否删除 1 是 0否',
  `open_id` varchar(64) DEFAULT NULL COMMENT '微信编号',
  `sso_id` int(11) DEFAULT NULL,
  `is_department_head` int(11) DEFAULT NULL COMMENT '是否为部门负责人 1 是 0 否',
  `is_company_boss` int(11) DEFAULT NULL COMMENT '是否为公司负责人 1 是  0 否',
  `we_chat_name` varchar(32) DEFAULT NULL COMMENT '微信昵称',
  `access_token` varchar(64) DEFAULT NULL COMMENT '微信token',
  `company_email_password` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`company_email`),
  UNIQUE KEY `email_2` (`company_email`),
  KEY `FK_Reference_22` (`dempid`),
  KEY `FK_Reference_28` (`positionid`),
  KEY `FK_Reference_35` (`postid`),
  CONSTRAINT `FK_Reference_22` FOREIGN KEY (`dempid`) REFERENCES `t_demp` (`id`),
  CONSTRAINT `FK_Reference_28` FOREIGN KEY (`positionid`) REFERENCES `t_position` (`id`),
  CONSTRAINT `FK_Reference_35` FOREIGN KEY (`postid`) REFERENCES `t_post` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=816 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('388', 'liyang@medilink.com.cn', '1', '410', '4', '11247', '李阳', '2', '汉', '20170715', '11', null, '123456789012345678', '佛挡杀佛', '13691204195', '', '', '0', '1', '1', '2017-07-23', '3', null, '3', null, null, '2017-08-07', '2020-10-22', '', '3', '2', '0', null, '2', '2', '2', '2', '2', '2000', '2000', '北京', '工商银行', '666666666666666666', '0', null, '8733', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('397', 'mikezhang@pj-l.com', '1', null, '1', '11212', '张晨阳', '1', '', '20000101', '北京', null, '110105196807142131', '', '13911813357', '', '', '0', '1', '0', '2000-01-01', '3', null, '3', null, null, '2000-01-01', '2017-09-09', '', '3', '2', '0', null, '2', '0', '2', '2', '2', '1', '2', '3', '4', '5', '0', null, '8632', '0', '1', null, null, null);
INSERT INTO `t_user` VALUES ('398', 'gabinwang@medilink.com.cn', '161', null, '2', '11227', '王学辉', '1', '', '20000102', '北京', null, '110102197201020055', '', '13801018899', '', '', '0', '1', '0', '2000-01-02', '3', null, '3', null, null, '2000-01-02', '2017-09-09', '', '3', '2', '0', null, '2', '0', '2', '2', '2', '11', '22', '33', '44', '55', '0', null, '8637', '0', '1', null, null, null);
INSERT INTO `t_user` VALUES ('399', 'y.z.wang@medilink.com.cn', '161', '406', '4', '11177', '王英芝', '2', '汉', '20160721', '北京', '424', '513822199010217621', null, '18210215099', '北京市朝阳区双井九龙花园2号楼206室', null, '0', '1', '0', '2016-07-01', '3', null, '3', null, null, '2016-07-01', null, null, null, '2', '2', null, '1', '1', '0', '2', '0', null, null, null, null, null, '0', null, '8638', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('400', 'paulli@medilink.com.cn', '161', '405', '3', '11181', '李涛', '1', null, '20161213', '北京', '423', '150202197910212714', null, '15103246448', null, null, '0', '1', '0', '2016-12-01', '3', null, '3', null, null, '2016-12-01', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8639', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('401', 'sunhuifang@medilink.com.cn', '161', '406', '4', '11174', '孙慧芳', '2', null, '20170329', '北京', '424', '120222199410012029', null, '18202213632', null, null, '0', '1', '0', '2017-03-08', '3', null, '3', null, null, '2017-03-08', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8640', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('402', 'sunhongqin@medilink.com.cn', '161', '406', '4', '11173', '孙红琴', '2', null, '20170330', '北京', '424', '142431199011223323', null, '18210030544', null, null, '0', '1', '0', '2017-03-13', '3', null, '3', null, null, '2017-03-13', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8641', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('403', 'zhangxiaoli@medilink.com.cn', '161', '406', '4', '11174', '张晓黎', '2', null, '20170428', '北京', '424', '142724199503182348', null, '18322056059', null, null, '0', '1', '0', '2017-04-05', '3', null, '3', null, null, '2017-04-05', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8642', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('404', 'liuchunxue@medilink.com.cn', '161', '406', '4', '11174', '刘春雪', '2', null, '20170429', '北京', '424', '110111198908123024', null, '15101175985', null, null, '0', '1', '0', '2017-04-05', '3', null, '3', null, null, '2017-04-05', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8643', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('405', 'caomeiying@medilink.com.cn ', '161', '406', '4', '11174', '曹美盈', '2', '汉', '20170614', '北京', '424', '110228198901190024', null, '17710876805', '北京市朝阳区亮马桥路56号院', null, '0', '1', '0', '2017-06-26', '3', null, '3', null, null, '2017-06-26', null, null, null, '2', '2', null, '1', '2', '2', '2', '0', null, null, null, null, null, '0', null, '8644', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('406', 'nelsonsun@medilink.com.cn', '161', '401', '2', '11186', '孙建', '1', '汉', '20160511', '北京', '398', '110103197510140014', null, '13601366855', '北京市朝阳区常营中路万象新天2区231楼2-1305', null, '0', '1', '0', '2016-05-21', '3', null, '3', null, null, '2016-05-21', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8645', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('407', 'h.y.wang@medilink.com.cn', '161', '401', '3', '11190', '王海月', '1', '汉', '20160512', '北京', '406', '110223198603066373', null, '13811057980', '通州区梨园孙王场小区27号楼3单元203', null, '0', '1', '0', '2016-05-21', '3', null, '3', null, null, '2016-05-21', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8646', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('408', 'Moeshi@medilink.com.cn', '161', '401', '3', '11189', '史薪枫', '2', '汉', '20160918', '北京', '406', '411102198211263540', null, '17310750930', '北京市朝阳区望京新城424号楼D单元1710', null, '0', '1', '0', '2016-09-18', '3', null, '3', null, null, '2016-09-18', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8647', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('409', 'h.du@medilink.com.cn', '161', '402', '3', '11195', '杜华', '1', '汉', '20160513', '北京', '489', '110108197311285730', null, '13601026072', '北京市海淀区西三环北路19号21楼3门601号', null, '0', '1', '0', '2016-05-21', '3', null, '3', null, null, '2016-05-21', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8648', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('410', 'f.he@medilink.com.cn', '161', '402', '3', '11196', '何飞', '1', '汉', '20160651', '北京', '409', '110105198102107132', null, '18614071130', '北京市首都机场蓝天苑4#3单元201', null, '0', '1', '0', '2016-06-01', '3', null, '3', null, null, '2016-06-01', null, null, null, '2', '2', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8649', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('411', 'reneege@medilink.com.cn', '161', '402', '4', '11197', '葛常丽', '2', '汉', '20161021', '北京', '409', '150425198801126665', null, '13823529326', '昌平天通苑北二区22号楼8单元0801', null, '0', '1', '0', '2016-10-08', '3', null, '3', null, null, '2016-10-08', null, null, null, '2', '3', null, '1', '1', '0', '2', '1', null, null, null, null, null, '0', null, '8650', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('412', 'eric.wang@medilink.com.cn\n', '161', '403', '3', '11198', '王良喜', '1', null, '20160625', '上海', '488', '护照号码：307260611', null, '13681759975', null, null, '0', '1', '4', '2016-06-01', '3', null, '3', null, null, '2016-06-01', null, null, null, '2', '0', null, '2', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8651', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('413', 'leonwang@medilink.com.cn', '161', '403', '4', null, '王彦伟', '1', '汉', '20160626', '上海', '412', '310104198112107276', null, '13917312989', '徐汇区凌云路梅陇五村43号601室', null, '0', '1', '0', '2016-06-01', '3', null, '3', null, null, '2016-06-01', null, null, null, '2', '2', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8652', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('414', 'endingzhang@medilink.com.cn', '161', '403', '4', '11199', '张慧瑾', '2', '汉', '20160627', '上海', '412', '310101198610031527', null, '13917275874', '黄浦区红庄弄16号', null, '0', '1', '0', '2016-06-01', '3', null, '3', null, null, '2016-06-01', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8653', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('415', 'pek.yexu@medilink.com.cn', '161', '404', '3', '11200', '叶旭', '1', '汉', '20040701', '北京', '398', '110105197202180038', null, '13901177235', '北京市朝阳区建国路4楼1单元301号', null, '0', '1', '0', '2004-07-13', '3', null, '3', null, null, '2004-07-13', null, null, null, '2', '0', null, '2', '2', '1', '2', '2', null, null, null, null, null, '0', null, '8655', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('416', 'pek.marryma@medilink.com.cn', '161', '404', '4', '11203', '马艳梅', '2', null, '20100801', '北京', '415', '110108197104190026', null, '13611388009', null, null, '0', '1', '0', '2010-08-03', '3', null, '3', null, null, '2010-08-03', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8656', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('417', 'pek.weijianhua@medilink.com.cn', '161', '404', '4', '11201', '魏建华', '2', '汉', '20120403', '北京', '415', '130733198602012000', null, '15810631233', '北京市朝阳区酒仙桥十二街坊2单元501', null, '0', '1', '0', '2012-04-24', '3', null, '3', null, null, '2012-04-24', null, null, null, '2', '0', null, '2', '2', '1', '2', '2', null, null, null, null, null, '0', null, '8657', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('418', 'pek.lilyxu@medilink.com.cn', '161', '404', '4', '11201', '徐丽苹', '2', '汉', '20160829', '北京', '415', '110222198005102921', null, '13581860253', '北京顺义', null, '0', '1', '0', '2016-08-15', '3', null, '3', null, null, '2016-08-15', null, null, null, '2', '3', null, '2', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8658', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('419', 'lihui@medilink.com.cn', '161', '404', '4', '11202', '李慧', '2', '汉', '20160937', '北京', '415', '372923199101022365', null, '18801314036', '北京市昌平区天通苑北东三旗村', null, '0', '1', '0', '2016-09-12', '3', null, '3', null, null, '2016-09-12', null, null, null, '2', '2', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8659', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('420', 'zhanghongjuan@ddn-global.com', '161', '404', '4', '11202', '张红娟', '2', '汉', '20161214', '北京', '415', '130726198608137121', null, '18911245212', '朝阳区清河营东路5号院1号楼404', null, '0', '1', '0', '2016-12-26', '3', null, '3', null, null, '2016-12-26', null, null, null, '2', '2', null, '0', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8660', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('421', 'fumin@medilink.com.cn', '161', '404', '4', '11202', '付敏', '2', '汉', '20170218', '北京', '415', '13070519920120182X', null, '18513049029', '北京市朝阳区孙河乡沙子营村', null, '0', '1', '0', '2017-02-20', '3', null, '3', null, null, '2017-02-20', null, null, null, '2', '2', null, '1', '1', '1', '2', '0', null, null, null, null, null, '0', null, '8661', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('422', 'pek.ninazhng@medilink.com.cn', '161', '406', '4', '11180', '张颖', '2', '汉', '20070301', '北京', '423', '110103196809110923', null, '13901025824', '朝阳区利泽西园601号1002', null, '0', '1', '0', '2007-03-28', '3', null, '3', null, null, '2007-03-28', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8662', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('423', 'pek.tanyong@medilink.com.cn', '161', '400', '2', '11170', '谭勇', '1', '汉', '20110701', '北京', null, '210204198211230992', '', '13701080632', '北京市朝阳区青年路华纺易城', '', '0', '1', '0', '2011-07-01', '3', null, '3', null, null, '2011-07-01', '2019-08-11', '', '3', '2', '4', null, '1', '0', '1', '2', '2', '1', '1', '1', '1', '1', '0', null, '8663', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('424', 'pek.jeanzhang@medilink.com.cn', '161', '406', '3', '11176', '张晶', '2', '汉', '20130602', '北京', '423', '110102197910212000', null, '13661107599', '北京市朝阳区双桥双柳新居19号楼6-501', null, '0', '1', '0', '2013-06-01', '3', null, '3', null, null, '2013-06-01', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8664', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('425', 'pek.zhouxin@medilink.com.cn', '161', '406', '4', '11177', '周鑫', '2', '汉', '20150401', '北京', null, '210881199209175728', '', '15711393532', '北京市朝阳区安贞桥东胜古家园', '', '0', '1', '0', '2015-04-21', '3', null, '3', null, null, '2015-04-21', '2018-08-16', '', '3', '2', '3', null, '1', '0', '1', '2', '1', '1', '1', '1', '1', '1', '0', null, '8665', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('426', 'pek.liujiayin@medilink.com.cn', '1', '405', '4', '11177', '刘佳音', '2', '汉', '20150704', '北京', '424', '150428199207250000', null, '15010718450', '北京市朝阳区十八里店乡张家店289号', null, '0', '1', '0', '2015-07-13', '3', null, '3', null, null, '2015-07-13', null, null, null, '2', '2', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8666', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('427', 'chenxi@pj-l.com', '1', '409', '3', '11208', '陈希', '2', '蒙', '20160902', '北京', '430', '110103198009021868', null, '18701220141', '北京市海淀区梅园甲3-3-301', null, '0', '1', '0', '2016-09-06', '3', null, '3', null, null, '2016-09-06', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8667', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('428', 'xiehua@pj-l.com', '1', '409', '4', '11205', '解华', '2', '汉', '20161016', '北京', '430', '110108197005057123', null, '13501108642', '北京市海淀区中关村南大街12号农科院高层4号楼707', null, '0', '1', '0', '2016-10-27', '3', null, '3', null, null, '2016-10-27', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8668', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('429', 'lijingrong@pj-l.com', '1', '409', '4', '11209', '李敬荣', '2', '汉', '20161117', '北京', '427', '370828196910280621', null, '13811056356', '北京市昌平区回龙观龙跃苑四区', null, '0', '1', '0', '2016-11-09', '3', null, '3', null, null, '2016-11-09', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8669', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('430', 'leonzhang@pj-l.com', '1', '409', '2', '11204', '张潇鸣', '1', null, '20170418', '北京', '397', '110105197707158130', null, '13910326157', '北京市朝阳区安慧里三区12号楼1902号', null, '0', '1', '0', '2017-04-12', '3', null, '3', null, null, '2017-04-12', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8670', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('431', 'zhangyue@pj-l.com', '1', '409', '4', '11210', '张悦', '2', null, '20170420', '北京', '427', '130633199309144724', null, '', null, null, '0', '1', '0', '2017-04-25', '3', null, '3', null, null, '2017-04-25', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8672', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('432', 'songna@pj-l.com', '1', '409', '4', '11207', '宋娜', '2', '汉', '20170508', '北京', '430', '412827198206205780', null, '', '北京市西城区新安南里6号楼5门602室', null, '0', '1', '0', '2017-05-15', '3', null, '3', null, null, '2017-05-15', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8673', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('433', 'lili@pj-l.com', '1', '409', '4', '11206', '李理', '2', '汉', '20170509', '北京', null, '110101198607151029', '', '', '北京市朝阳区花家地13号楼4单元102号', '', '0', '1', '0', '2017-05-15', '3', null, '3', null, null, '2017-05-15', '2020-12-24', '', '3', '2', '3', null, '0', '0', '1', '2', '0', '1', '1', '1', '1', '1', '0', null, '8674', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('434', 'wangxiaowei@pj-l.com', '165', '409', '4', '11207', '王小伟', '1', '汉', '20170611', '杭州', '430', '340602198706171611', null, '15821038042', '杭州萧山区油树下青年众创社区', null, '0', '1', '0', '2017-06-19', '3', null, '3', null, null, '2017-06-19', null, null, null, '2', '3', null, '1', '0', '2', '2', '0', null, null, null, null, null, '0', null, '8675', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('435', 'pek.liwei@medilink.com.cn', '165', '412', '3', '11149', '李巍', '2', '汉', '20110301', '北京', '415', '110222198704130040', null, '13811918126', '北京市顺义区杨镇地区小店村新街49号', null, '0', '1', '0', '2011-03-16', '3', null, '3', null, null, '2011-03-16', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8676', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('436', 'pek.lijiayin@medilink.com.cn', '165', '412', '4', '11152', '李佳音', '2', '汉', '20130601', '北京', '435', '110222198311050322', null, '15011501550', '北京市顺义区金汉绿港三区3-2-1202', null, '0', '1', '0', '2013-06-24', '3', null, '3', null, null, '2013-06-24', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8677', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('437', 'pek.s.zhang@medilink.com.cn', '165', '412', '4', null, '张爽', '2', '汉', '20160503', '北京', '435', '11022219940206082X', null, '15810017183', '北京市顺义区王珂四季花', null, '0', '1', '0', '2016-05-30', '3', null, '3', null, null, '2016-05-30', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8678', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('438', 'pek.yuexuemei@medilink.com.cn', '165', '412', '4', '11151', '岳雪梅', '2', '汉', '20161109', '北京', '435', '110222197912075723', null, '13681419975', '北京市顺义区石园北区56号楼2单元101室', null, '0', '1', '0', '2016-11-14', '3', null, '3', null, null, '2016-11-14', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8679', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('439', 'pek.liuzixin@medilink.com.cn', '165', '412', '4', null, '刘志新', '2', '汉', '20170702', '北京', '435', '372323199102052141', null, '18810593969', '山东省阳信县翟王镇翟王村157号', null, '0', '1', '0', '2017-07-03', '3', null, '3', null, null, '2017-07-03', null, null, null, '2', '2', null, '1', '0', '2', '2', '1', null, null, null, null, null, '0', null, '8680', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('440', 'pek wangyongkang@medilink.com.cn', '165', '412', '4', null, '王永康', '1', '汉', '20170715', '北京', '435', '110222199302091653', null, '13718696185', '北京市顺义区赵全营镇马家堡村陈衙路17号', null, '0', '1', '0', '2017-07-18', '3', null, '3', null, null, '2017-07-18', null, null, null, '2', '3', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8681', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('441', 'pek.jicheng@medilink.com.cn', '165', '413', '4', '11157', '冀澄', '2', '汉', '20120401', '北京', '458', '110103198612030929', null, '13269104296', '北京市通州区帅府园小区42号楼151', null, '0', '1', '0', '2012-04-01', '3', null, '3', null, null, '2012-04-01', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8682', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('442', 'pek.wangyu@medilink.com.cn', '165', '413', '4', '11157', '王宇', '2', '汉', '20120402', '北京', '458', '110222198803140826', null, '15010079243', '北京市顺义区石园北区12号楼3门102', null, '0', '1', '0', '2012-04-01', '3', null, '3', null, null, '2012-04-01', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8683', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('443', 'pek.huqiang@medilink.com.cn', '165', '413', '4', '11157', '刘学', '1', '汉', '20140302', '北京', '486', '110223198807180637', null, '13718796069', '北京市通州区怡乐中街99号', null, '0', '1', '0', '2014-03-24', '3', null, '3', null, null, '2014-03-24', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8684', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('445', 'pek.raymondjia@medilink.com.cn', '165', '413', '4', '11157', '贾海浩', '1', '汉', '20150701', '北京', '467', '412728198907184952', null, '18210123002', '北京市是顺义区恒华西街1号院13号楼304室', null, '0', '1', '0', '2015-07-20', '3', null, '3', null, null, '2015-07-20', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8685', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('446', 'pek.ericshi@medilink.com.cn', '165', '413', '4', '11157', '史耀轩', '1', '汉', '20150702', '北京', '467', '370305199307056213', null, '15120037316', '北京市顺义区绿港家园四区6号楼3单元2002', null, '0', '1', '0', '2015-07-20', '3', null, '3', null, null, '2015-07-20', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8686', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('447', 'pek.liuhuiting@medilink.com.cn', '165', '413', '4', '11157', '刘慧婷', '2', '汉', '20150703', '北京', '460', '230207199111230423', null, '18710080107', '北京市顺义区东亚首航国际2号楼801', null, '0', '1', '0', '2015-07-21', '3', null, '3', null, null, '2015-07-21', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8687', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('448', 'pek.lydiayan2medilink.com.cn', '165', '413', '4', '11157', '闫立月', '2', '汉', '20150802', '北京', '467', '131023199304302821', null, '15801330054', '北京市顺义区南法信镇北法信村村委会', null, '0', '1', '0', '2015-08-20', '3', null, '3', null, null, '2015-08-20', null, null, null, '2', '2', null, '0', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8688', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('449', 'pek.jinyingjie@medilink.com.cn', '165', '413', '4', '11157', '金英杰', '2', '汉', '20161001', '北京', '467', '110222199309303524', null, '18614093827', '北京市顺义区李桥镇沙浮村', null, '0', '1', '0', '2016-10-08', '3', null, '3', null, null, '2016-10-08', null, null, null, '2', '2', null, '0', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8689', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('450', 'pek.zhangguoliang@medilink.com.cn', '165', '414', '4', '11160', '张国良', '1', '汉', '20120801', '北京', '487', '120225198607275572', null, '15010183211', '北京市朝阳区东坎乡', null, '0', '1', '0', '2012-08-01', '3', null, '3', null, null, '2012-08-01', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8690', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('451', 'pek.wanghongliang@medilink.com.cn', '165', '414', '4', '11160', '王红亮', '1', '汉', '20130401', '北京', '487', '220382198902201679', null, '15201205456', '北京市顺义区澜西园二区32号楼4单元601', null, '0', '1', '0', '2013-04-01', '3', null, '3', null, null, '2013-04-01', null, null, null, '2', '2', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8691', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('452', 'pek.jinlei@medilink.com.cn', '165', '414', '4', '11160', '金磊', '1', '汉', '20130801', '北京', '487', '110101198108112578', null, '13801160807', '北京市顺义区机场东路6号院6号楼3单元101', null, '0', '1', '0', '2013-08-06', '3', null, '3', null, null, '2013-08-06', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8692', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('453', 'pek.zhouchen@medilink.com.cn', '165', '414', '4', '11160', '周晨', '2', '汉', '20140301', '北京', '487', '110102198205271921', null, '15810676711', '北京市顺义区后沙峪裕祥花园2号楼3门301', null, '0', '1', '0', '2014-03-10', '3', null, '3', null, null, '2014-03-10', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8693', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('454', 'pek.maqiang@medilink.com.cn', '165', '414', '4', '11160', '马强', '1', '汉', '20141001', '北京', '487', '110222198810112233', null, '13520972958', '北京市顺义区后沙峪', null, '0', '1', '0', '2014-10-08', '3', null, '3', null, null, '2014-10-08', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8694', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('455', 'pek.fenghailin@medilink.com.cn', '165', '415', '3', '11224', '冯海林', '1', '汉', '20170303', '北京', '456', '110102197308062714', null, '', '北京市朝阳区望京南湖', null, '0', '1', '0', '2017-03-01', '3', null, '3', null, null, '2017-03-01', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8695', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('456', 'pek.lvhaitao@medilink.com.cn', '165', '415', '3', '11161', '吕海涛', '1', '汉', '20170304', '北京', '486', '110105197105086117', null, '', '北京市海淀区小南庄', null, '0', '1', '0', '2017-03-01', '3', null, '3', null, null, '2017-03-01', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8696', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('457', 'pek.xubowen@medilink.com.cn', '165', '415', '4', '11225', '徐博文', '1', '汉', '20170514', '北京', '456', '130804198307300011', null, '', '北京市顺义区后沙峪', null, '0', '1', '0', '2017-05-02', '3', null, '3', null, null, '2017-05-02', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8697', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('458', 'pek.antoniazhou@medilink.com.cn', '165', '416', '3', '11162', '周立平', '2', '满', '20040901', '北京', '486', '110101198010131543', null, '13810339133', '北京市顺义区后沙峪十中路田园牧歌1号楼2单元302', null, '0', '1', '0', '2004-09-20', '3', null, '3', null, null, '2004-09-20', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8698', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('459', 'pek.dylansun@medilink.com.cn', '165', '416', '4', '11164', '孙炜', '1', '汉', '20110201', '北京', '460', '110101197909302019', null, '13801307875', '双桥东路东一时区3-1-402', null, '0', '1', '0', '2011-02-17', '3', null, '3', null, null, '2011-02-17', null, null, null, '2', '1', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8699', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('460', 'pek.liuzhinan@medilink.com.cn', '165', '416', '3', '11162', '刘志南', '1', '汉', '20110501', '北京', '486', '110106198608122758', null, '13910056887', '北京市丰台区王佐乡南岗洼大队水牛坊63号', null, '0', '1', '0', '2011-05-03', '3', null, '3', null, null, '2011-05-03', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8700', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('461', 'pek.zhangquan@medilink.com.cn', '165', '416', '4', '11164', '张荃', '1', '汉', '20121101', '北京', '460', '110103199011141513', null, '15010700757', '北京市顺义区宏城花园14号楼二单元302室', null, '0', '1', '0', '2012-11-26', '3', null, '3', null, null, '2012-11-26', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8701', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('462', 'pek.zhangyu@medilink.com.cn', '165', '416', '4', '11164', '张宇', '1', '汉', '20130402', '北京', '460', '110106199107084815', null, '15010245935', '北京市丰台区蒲黄榆3号楼7-203', null, '0', '1', '0', '2013-04-01', '3', null, '3', null, null, '2013-04-01', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8702', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('463', 'pek.xuxinxing@medilink.com.cn', '165', '416', '4', '11163', '徐新星', '2', '汉', '20140303', '北京', '460', '341125199305154880', null, '15201364408', '北京市顺义区澜西园二区32号楼4单元601', null, '0', '1', '0', '2014-03-27', '3', null, '3', null, null, '2014-03-27', null, null, null, '2', '2', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8703', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('464', 'pek.tianyuling@medilink.com.cn', '165', '416', '4', '11163', '田玉玲', '2', '汉', '20130301', '北京', '458', '131002198812262866', null, '13552860642', '北京市顺义区大孙各庄镇东华山村', null, '0', '1', '0', '2013-03-18', '3', null, '3', null, null, '2013-03-18', null, null, null, '2', '3', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8704', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('465', 'pek.gengzishuang@medilink.com.cn', '165', '416', '4', '11163', '耿子双', '2', '汉', '20141002', '北京', '458', '110226198709271120', null, '15810680998', '北京市顺义区澜西园二区32#-1-601', null, '0', '1', '0', '2014-10-10', '3', null, '3', null, null, '2014-10-10', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8705', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('466', 'pek.anhaiyan@medilink.com.cn', '165', '416', '4', '11163', '安海燕', '2', '汉', '20141101', '北京', '458', '211421198203280461', null, '13716350150', '北京市通州区西马庄园56号楼163', null, '0', '1', '0', '2014-11-24', '3', null, '3', null, null, '2014-11-24', null, null, null, '2', '3', null, '0', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8706', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('467', 'pek.Riomao@medilink.com.cn', '165', '416', '3', '11162', '毛连彬', '1', '汉', '20150601', '北京', '486', '230421198310111818', null, '18610154692', '北京市是顺义区恒华西街3号院', null, '0', '1', '0', '2015-06-15', '3', null, '3', null, null, '2015-06-15', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8707', '1', '0', null, null, null);
INSERT INTO `t_user` VALUES ('468', 'pek.yutingya@medilink.com.cn', '165', '416', '4', '11163', '于婷雅', '2', '汉', '20150803', '北京', '460', '230506198911071120', null, '17772051009', '北京市顺义区东亚首航国际5号楼712', null, '0', '1', '0', '2015-08-24', '3', null, '3', null, null, '2015-08-24', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8708', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('469', 'pek.wangxiaosong@medilink.com.cn', '165', '416', '4', '11164', '王晓松', '1', '汉', '20151101', '北京', '460', '110104198304021218', null, '13911968807', '北京市朝阳区华威南路11门401号', null, '0', '1', '0', '2015-11-02', '3', null, '3', null, null, '2015-11-02', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8709', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('470', 'pek.marshallsun@medilink.com.cn', '165', '416', '4', '11163', '孙家京', '1', '汉', '20160804', '北京', '460', '232103198703170213', null, '13691238500', '北京市昌平区北七家镇西湖新村小区二号楼一单元301', null, '0', '1', '0', '2016-08-01', '3', null, '3', null, null, '2016-08-01', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8710', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('471', 'pek.liusai@medilink.com.cn', '165', '416', '4', '11163', '李莉', '2', '汉', '20160923', '北京', '460', '110222198806013320', null, '13488665805', '北京市顺义区五里屯', null, '0', '1', '0', '2016-09-22', '3', null, '3', null, null, '2016-09-22', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8711', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('473', 'pek.wutao@medilink.com.cn', '165', '416', '4', '11237', '吴涛', '1', '汉', '20170515', '北京', '460', '142601199612036315', null, '', '北京市顺义区建新南区19号楼4单元202', null, '0', '1', '0', '2017-05-02', '3', null, '3', null, null, '2017-05-02', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8712', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('474', 'pek.lijingan@medilink.com.cn', '165', '417', '4', '11165', '李静安', '1', '汉', '20050501', '北京', '486', '110222195707213315', null, '13911100929', '北京市顺义区李桥镇临清村', null, '0', '1', '0', '2005-05-25', '3', null, '3', null, null, '2005-05-25', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8713', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('475', 'pek.xiaozongqiang@medilink.com.cn', '165', '417', '4', '11166', '肖宗强', '1', '汉', '20160101', '北京', '482', '110222196310034110', null, '13716663436', '北京市顺义区南彩镇杜刘庄', null, '0', '1', '0', '2016-01-13', '3', null, '3', null, null, '2016-01-13', null, null, null, '2', '0', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8714', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('476', 'pek.wangfang@medilink.com.cn', '165', '418', '4', '11167', '王芳', '2', '汉', '20001001', '北京', '486', '110105196501120829', null, '13011176996', '朝阳区垂杨柳东里四楼', null, '0', '1', '2', '2000-10-08', '3', null, '3', null, null, '2000-10-08', null, null, null, '2', '1', null, '1', '1', '1', '2', '0', null, null, null, null, null, '0', null, '8715', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('477', 'pek.luyatong@medilink.com.cn', '165', '418', '4', null, '卢雅桐', '2', '汉', '20170103', '北京', '476', '110226199511105025', null, '18401531142', '北京市朝阳区花家地爽秋路六号', null, '0', '1', '0', '2017-07-01', '3', null, '3', null, null, '2017-07-01', null, null, null, '2', '3', null, '1', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8716', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('478', 'pek.huyifei@medilink.com.cn', '165', '419', '4', '11226', '胡一菲', '2', '汉', '20160802', '北京', '486', '110222199105284341', null, '15011319710', '北京顺义澜西园', null, '0', '1', '0', '2016-08-23', '3', null, '3', null, null, '2016-08-23', null, null, null, '2', '3', null, '0', '0', '1', '2', '1', null, null, null, null, null, '0', null, '8717', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('479', 'pek.yanhan@medilink.com.cn', '165', '419', '4', '11226', '阎晗', '1', '汉', '20170405', '北京', '486', '110101198501033016', null, '', '北京市昌平区北七家王府温馨公寓', null, '0', '1', '0', '2017-04-06', '3', null, '3', null, null, '2017-04-06', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8718', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('480', 'pek.y.xu@medilink.com.cn', '165', '420', '4', '11155', '徐艳', '2', '汉', '20150801', '北京', '443', '420621199005282726', null, '18600731466', '河北三河燕郊经济开发区', null, '0', '1', '0', '2015-08-10', '3', null, '3', null, null, '2015-08-10', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8719', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('481', 'pek.x.x.zhou@medilink.com.cn', '165', '420', '4', '11153', '周鑫鑫', '2', '汉', '20160301', '北京', '482', '230405199407280428', null, '18311035850', '北京市顺义区五里屯', null, '0', '1', '0', '2016-03-30', '3', null, '3', null, null, '2016-03-30', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8720', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('482', 'pek.docn@medilink.com.cn', '165', '420', '4', '11153', '吕海滨', '1', '汉', '20160502', '北京', '486', '110222198907302412', null, '15210075945', '北京市顺义区牛山镇下坡屯小区二区6-3-602', null, '0', '1', '0', '2016-05-03', '3', null, '3', null, null, '2016-05-03', null, null, null, '2', '3', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8721', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('483', 'pek.panlili@medilink.com.cn', '165', '420', '4', '11153', '潘丽莉', '2', '汉', '20170305', '北京', '482', '23023019870625022X', null, '', '北京市顺义区西辛南区', null, '0', '1', '0', '2017-03-01', '3', null, '3', null, null, '2017-03-01', null, null, null, '2', '2', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8722', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('484', 'pek.kongxianglong@medilink.com.cn', '162', '420', '4', '11153', '李金萍', '2', '汉', '20170306', '北京', '482', '23212719911025082X', null, '', '北京市顺义区杨镇沙子营', null, '0', '1', '0', '2017-03-13', '3', null, '3', null, null, '2017-03-13', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8723', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('485', 'pek.hening@medilink.com.cn', '165', null, '2', null, '何宁', '1', '汉', '20150101', '北京', '486', '110105197205177112', null, '13501100686', '北京市朝阳区首都机场南平里', null, '0', '1', '0', '2015-01-04', '3', null, '3', null, null, '2015-01-04', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8724', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('486', 'pek.zhangyang@medilink.com.cn', '161', null, '2', null, '张扬', '1', '回', '20060301', '北京', '398', '110105198101301136', null, '15117973773', '北京市东城区天天家园', null, '0', '1', '0', '2006-03-01', '3', null, '3', null, null, '2006-03-01', null, null, null, '2', '2', null, '1', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8725', '0', '1', null, null, null);
INSERT INTO `t_user` VALUES ('487', 'pek.baowenbo@medilink.com.cn', '161', '414', '3', '11236', '包文博', '1', '满', '20120601', '北京', '486', '110101198204103014', null, '13810005288', '北京市昌平区长滩壹号20-4-602', null, '0', '1', '0', '2012-06-04', '3', null, '3', null, null, '2012-06-04', null, null, null, '2', '3', null, '0', '0', '1', '2', '0', null, null, null, null, null, '0', null, '8726', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('488', 'kathychen@medilink.com.cn', '161', null, '2', '11228', '陈淼（北京）', '2', '回', '20160722', '北京', null, '110103197203300620', '', '13901079390', '朝阳区望京东园一区103-2601', '', '0', '1', '0', '2016-07-01', '3', null, '3', null, null, '2016-07-01', '2017-09-09', '', '3', '2', '3', null, '2', '0', '1', '2', '0', '1', '2', '3', '4', '5', '0', null, '8727', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('489', 'eddyge@medilink.com.cn', null, null, '2', '11228', '葛震', '1', null, '20170432', '北京', '398', '110105196508077114', null, '13801163007', null, null, '0', '1', '0', '2017-04-10', '3', null, '3', null, null, '2017-04-10', null, null, null, '2', '0', null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, '8728', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('808', ' caiyujia@medilink.com.cn', '161', null, '4', '11243', '蔡羽佳', '2', '汉', '20170801', '北京市朝阳区来广营诚盈中心A座9层', null, '110108198806155721', '北京市海淀区民院南路19号3号楼1102室', '13811624071', '北京市丰台区中海御鑫阁2号楼1111', '174932152@qq.com', '1', '1', '1', '2017-08-21', '3', null, '3', null, null, '2017-08-21', '2020-08-20', '15201216252', '3', '0', '0', null, '1', '2', '2', '2', '2', '3082', '2148', '北京', '工商银行', '6212260200137584401', '0', null, '8731', '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('809', 'yuhong@medilink.com.cn', '161', '421', '3', '11242', '于虹', '2', '汉', '20170901', '北京市朝阳区来广营诚盈中心A座9层', null, '370785198705085529', '', '15321151805', '北京市朝阳区麦子店街', 'yuhong20170801@163.com', '1', '1', '1', '2017-09-04', '3', null, '3', null, null, '2017-09-04', '2020-09-03', '15201216252', '1', '1', '3', null, '1', '0', '1', '2', '0', '3082', '2148', '北京', '工商银行', '6222020200109054714', '0', null, null, '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('810', 'shihuayong@pj-l.com', '165', '416', '4', '11162', '时华勇', null, null, null, null, null, null, null, '13810005288', null, null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, null, '0', '0', null, null, null);
INSERT INTO `t_user` VALUES ('811', 'gaofeifan@pj-l.com', '165', '416', '4', '11162', '高非凡', '2', '汉', null, null, null, null, null, '13901079390', null, null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('812', 'nimengru@pj-l.com', '165', '416', '4', '11162', '倪梦茹', null, null, null, null, null, null, null, '13801163007', null, null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('813', 'limengyun@pj-l.com', '161', '404', '4', '11203', '李梦云', '2', '汉', null, null, null, null, null, '13811624071', null, null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('814', 'liuzizhe@pj-l.com', '161', '404', '4', '11203', '刘自哲', '2', '汉', null, null, null, null, null, '15321151805', null, null, '0', '1', null, null, null, null, null, null, null, null, null, null, null, '2', null, null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, null, null, null, null, null, null);
INSERT INTO `t_user` VALUES ('815', 'ryanshi@pj-l.com', '1', '96', '2', '11215', '石磊', '1', '汉', null, null, null, null, null, null, null, null, '0', '1', null, '2017-09-04', null, null, null, null, null, null, null, null, null, '2', null, null, '2', '2', '2', '2', '2', null, null, null, null, null, '0', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_work_experience
-- ----------------------------
DROP TABLE IF EXISTS `t_work_experience`;
CREATE TABLE `t_work_experience` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `work_time` varchar(256) DEFAULT NULL COMMENT '工作时间',
  `duty` varchar(32) DEFAULT NULL COMMENT '职务',
  `gross_wage` varchar(128) DEFAULT NULL COMMENT '税前薪资',
  `reason_leave` varchar(528) DEFAULT NULL COMMENT '离职原因',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `certifier_and_phone` varchar(528) DEFAULT NULL COMMENT '证明人及电话',
  `work_unit` varchar(528) DEFAULT NULL COMMENT '工作单位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8 COMMENT='工作经历';

-- ----------------------------
-- Records of t_work_experience
-- ----------------------------
INSERT INTO `t_work_experience` VALUES ('189', '', '', '', '', '433', '', '');
INSERT INTO `t_work_experience` VALUES ('190', '', '', '', '', '433', '', '');
INSERT INTO `t_work_experience` VALUES ('191', '', '', '', '', '433', '', '');
INSERT INTO `t_work_experience` VALUES ('192', '', '', '', '', '433', '', '');
INSERT INTO `t_work_experience` VALUES ('193', '', '', '', '', '425', '', '');
INSERT INTO `t_work_experience` VALUES ('194', '', '', '', '', '425', '', '');
INSERT INTO `t_work_experience` VALUES ('195', '', '', '', '', '425', '', '');
INSERT INTO `t_work_experience` VALUES ('196', '', '', '', '', '425', '', '');
INSERT INTO `t_work_experience` VALUES ('197', '', '', '', '', '423', '', '');
INSERT INTO `t_work_experience` VALUES ('198', '', '', '', '', '423', '', '');
INSERT INTO `t_work_experience` VALUES ('199', '', '', '', '', '423', '', '');
INSERT INTO `t_work_experience` VALUES ('200', '', '', '', '', '423', '', '');
INSERT INTO `t_work_experience` VALUES ('201', '', '', '', '', '397', '', '');
INSERT INTO `t_work_experience` VALUES ('202', '', '', '', '', '397', '', '');
INSERT INTO `t_work_experience` VALUES ('203', '', '', '', '', '397', '', '');
INSERT INTO `t_work_experience` VALUES ('204', '', '', '', '', '397', '', '');
INSERT INTO `t_work_experience` VALUES ('205', '', '', '', '', '398', '', '');
INSERT INTO `t_work_experience` VALUES ('206', '', '', '', '', '398', '', '');
INSERT INTO `t_work_experience` VALUES ('207', '', '', '', '', '398', '', '');
INSERT INTO `t_work_experience` VALUES ('208', '', '', '', '', '398', '', '');
INSERT INTO `t_work_experience` VALUES ('209', '', '', '', '', '488', '', '');
INSERT INTO `t_work_experience` VALUES ('210', '', '', '', '', '488', '', '');
INSERT INTO `t_work_experience` VALUES ('211', '', '', '', '', '488', '', '');
INSERT INTO `t_work_experience` VALUES ('212', '', '', '', '', '488', '', '');
INSERT INTO `t_work_experience` VALUES ('213', '', '', '', '', '808', '', '');
INSERT INTO `t_work_experience` VALUES ('214', '', '', '', '', '808', '', '');
INSERT INTO `t_work_experience` VALUES ('215', '', '', '', '', '808', '', '');
INSERT INTO `t_work_experience` VALUES ('216', '', '', '', '', '808', '', '');
INSERT INTO `t_work_experience` VALUES ('217', '2010年9月至2012年7月', '客服经理', '5000', '个人原因', '809', '', '北京兴源房地产开发有限公司');
INSERT INTO `t_work_experience` VALUES ('218', '2012年7月至2017年8月', '人事行政经理', '15000', '个人原因', '809', '', '北京民航鹏运航空服务公司');
INSERT INTO `t_work_experience` VALUES ('219', '', '', '', '', '809', '', '');
INSERT INTO `t_work_experience` VALUES ('220', '', '', '', '', '809', '', '');
INSERT INTO `t_work_experience` VALUES ('221', '', '', '', '', '388', '', '');
INSERT INTO `t_work_experience` VALUES ('222', '', '', '', '', '388', '', '');
INSERT INTO `t_work_experience` VALUES ('223', '', '', '', '', '388', '', '');
INSERT INTO `t_work_experience` VALUES ('224', '', '', '', '', '388', '', '');

-- ----------------------------
-- Table structure for tp_entry_status
-- ----------------------------
DROP TABLE IF EXISTS `tp_entry_status`;
CREATE TABLE `tp_entry_status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `entry_id` int(11) DEFAULT NULL COMMENT '入职申请单id',
  `status` int(11) DEFAULT NULL COMMENT '执行状态',
  `opinion` varchar(255) DEFAULT NULL COMMENT '意见',
  `operation_time` date DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tp_entry_status
-- ----------------------------

-- ----------------------------
-- Table structure for tp_findrecord
-- ----------------------------
DROP TABLE IF EXISTS `tp_findrecord`;
CREATE TABLE `tp_findrecord` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='查看记录表';

-- ----------------------------
-- Records of tp_findrecord
-- ----------------------------

-- ----------------------------
-- Function structure for getChildLst
-- ----------------------------
DROP FUNCTION IF EXISTS `getChildLst`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getChildLst`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN 
   DECLARE sTemp VARCHAR(1000); 
   DECLARE sTempChd VARCHAR(1000); 
 
   SET sTemp = '$'; 
   SET sTempChd =cast(rootId as CHAR); 
 
   WHILE sTempChd is not null DO 
     SET sTemp = concat(sTemp,',',sTempChd); 
     SELECT group_concat(id) INTO sTempChd FROM t_demp where FIND_IN_SET(pId,sTempChd)>0; 
   END WHILE; 
   RETURN sTemp; 
		END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for getCompanyChildList
-- ----------------------------
DROP FUNCTION IF EXISTS `getCompanyChildList`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `getCompanyChildList`(rootId INT) RETURNS varchar(1000) CHARSET utf8
BEGIN 
   DECLARE sTemp VARCHAR(1000); 
   DECLARE sTempChd VARCHAR(1000); 
 
   SET sTemp = '$'; 
   SET sTempChd =CAST(rootId AS CHAR); 
 
   WHILE sTempChd IS NOT NULL DO 
     SET sTemp = CONCAT(sTemp,',',sTempChd); 
     SELECT GROUP_CONCAT(id) INTO sTempChd FROM t_company WHERE FIND_IN_SET(pId,sTempChd)>0; 
   END WHILE; 
   RETURN sTemp; 
		END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for getCompanyParentList
-- ----------------------------
DROP FUNCTION IF EXISTS `getCompanyParentList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getCompanyParentList`(rootId VARCHAR(100)) RETURNS varchar(1000) CHARSET utf8
BEGIN   
DECLARE fid VARCHAR(100) DEFAULT '';   
DECLARE str VARCHAR(1000) DEFAULT rootId;   
  
WHILE rootId IS NOT NULL  DO   
    SET fid =(SELECT pId FROM t_company WHERE id = rootId);   
    IF fid IS NOT NULL THEN   
        SET str = CONCAT(str, ',', fid);   
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;   
    END IF;   
END WHILE;   
RETURN str;  
END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for getParentList
-- ----------------------------
DROP FUNCTION IF EXISTS `getParentList`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `getParentList`(rootId varchar(100)) RETURNS varchar(1000) CHARSET utf8
BEGIN   
DECLARE fid varchar(100) default '';   
DECLARE str varchar(1000) default rootId;   
  
WHILE rootId is not null  do   
    SET fid =(SELECT pId FROM t_demp WHERE id = rootId);   
    IF fid is not null THEN   
        SET str = concat(str, ',', fid);   
        SET rootId = fid;   
    ELSE   
        SET rootId = fid;   
    END IF;   
END WHILE;   
return str;  
END
;;
DELIMITER ;
