/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50721
 Source Host           : localhost:3306
 Source Schema         : openapi

 Target Server Type    : MySQL
 Target Server Version : 50721
 File Encoding         : 65001

 Date: 14/06/2020 01:22:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for s_saas_user
-- ----------------------------
DROP TABLE IF EXISTS `s_saas_user`;
CREATE TABLE `s_saas_user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工',
  `saas_user_role_id` bigint(20) NULL DEFAULT NULL COMMENT '员工角色id',
  `access_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开放平台的ak(开发者唯一标识)',
  `secret_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开放平台密钥(用于签名,即接口加密)',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开放平台app(用户唯一标识)',
  `app_key` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开放平台app密钥(用于加密,即接口加密)',
  `head_img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `addr` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `id_card` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证',
  `status` int(2) NULL DEFAULT 0 COMMENT '0正常状态1离职(冻结)',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `phone`(`phone`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 39 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_saas_user
-- ----------------------------
INSERT INTO `s_saas_user` VALUES (1, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '333', '18720733211', '98D2B646B2DE022DC7EC07866DE06699', '333', '333', '33', 0, '2019-05-18 08:53:29', '2019-06-18 10:30:37');
INSERT INTO `s_saas_user` VALUES (2, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '1111', '18720733212', '98D2B646B2DE022DC7EC07866DE06699', '1111', '1111', '1111', 1, '2019-05-18 08:57:53', '2019-05-18 10:53:24');
INSERT INTO `s_saas_user` VALUES (3, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '1111111111', '18720733213', '98D2B646B2DE022DC7EC07866DE06699', '111111111', '111111111111', '1111111111111111', 1, '2019-05-18 09:01:59', '2019-06-06 11:24:17');
INSERT INTO `s_saas_user` VALUES (5, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '222222', '18720733214', '98D2B646B2DE022DC7EC07866DE06699', '11', '11', '11', 1, '2019-05-18 09:04:23', '2019-06-06 11:24:12');
INSERT INTO `s_saas_user` VALUES (7, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '22', '18720733216', '98D2B646B2DE022DC7EC07866DE06699', '11', '11', '11', 0, '2019-05-18 09:13:37', '2019-05-23 11:25:03');
INSERT INTO `s_saas_user` VALUES (9, 3, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '员工2', '18720733333', '98D2B646B2DE022DC7EC07866DE06699', '2012293155@qq.com', '江西省赣州市崇义县文英乡茶子丘组', '360725199712103410', 0, '2019-05-24 09:48:20', '2019-06-24 10:17:44');
INSERT INTO `s_saas_user` VALUES (10, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '员工4', '18720733334', '98D2B646B2DE022DC7EC07866DE06699', '2012293155@qq.com', '江西省赣州市崇义县', '360725199712103410', 0, '2019-05-24 10:09:27', '2019-06-18 10:30:30');
INSERT INTO `s_saas_user` VALUES (11, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '员工3', '18720733335', '98D2B646B2DE022DC7EC07866DE06699', '2012293155@qq.com', '', '', 0, '2019-05-24 10:11:39', '2019-05-24 10:11:39');
INSERT INTO `s_saas_user` VALUES (12, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '员工5', '18720733215', '98D2B646B2DE022DC7EC07866DE06699', '2012293155@qq.com', '', '', 0, '2019-05-24 10:22:24', '2019-05-24 10:22:24');
INSERT INTO `s_saas_user` VALUES (13, 2, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '厂长(张佳)', '18720733219', '98D2B646B2DE022DC7EC07866DE06699', '123456', '', '', 0, NULL, '2019-06-18 10:29:44');
INSERT INTO `s_saas_user` VALUES (15, NULL, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', '', '员工6', '18720734565', '98D2B646B2DE022DC7EC07866DE06699', '2012293155@qq.com', '', '', 0, '2019-06-06 15:03:29', '2019-06-06 15:03:47');
INSERT INTO `s_saas_user` VALUES (29, 3, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', NULL, '小刘', '18166064217', '98D2B646B2DE022DC7EC07866DE06699', NULL, NULL, NULL, 0, '2020-04-20 22:08:37', '2020-04-20 22:08:37');
INSERT INTO `s_saas_user` VALUES (30, 3, '98D2B646B2DE022DC7EC07866DE06699', '98D2B646B2DE022DC7EC07866DE06699', NULL, '98D2B646B2DE022DC7EC07866DE06699', NULL, '小红ss', '18956585884', '0BE5D9BD6286E4DB6C2E5A5943F648DD', NULL, NULL, NULL, 0, '2020-04-21 00:41:00', '2020-04-21 00:41:07');

-- ----------------------------
-- Table structure for s_saas_user_permission_list
-- ----------------------------
DROP TABLE IF EXISTS `s_saas_user_permission_list`;
CREATE TABLE `s_saas_user_permission_list`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工权限表',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级权限id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `descript` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `request_path` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '请求路径',
  `icon_path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '图标路径',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 85 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_saas_user_permission_list
-- ----------------------------
INSERT INTO `s_saas_user_permission_list` VALUES (1, 0, '部门/职位', 'department/job', '', 'layui-icon iconfont iconbumen', 1, '2019-06-15 14:55:16', '2020-04-21 02:32:48');
INSERT INTO `s_saas_user_permission_list` VALUES (3, 0, '人员管理', 'employeeManage', '', 'layui-icon iconfont iconrenyuanguanli', 2, '2019-06-15 15:23:34', '2020-04-21 02:32:53');
INSERT INTO `s_saas_user_permission_list` VALUES (4, 0, '排班管理', 'arrangeManage', '', 'layui-icon iconfont iconpaibanguanli', 3, '2019-06-15 15:27:13', '2020-04-21 02:32:56');
INSERT INTO `s_saas_user_permission_list` VALUES (5, 0, '考勤管理', 'attendanceManage', '', 'layui-icon iconfont iconkaoqinguanli', 4, '2019-06-15 15:42:33', '2020-04-21 02:33:00');
INSERT INTO `s_saas_user_permission_list` VALUES (6, 0, '请假管理', 'leaveManage', '', 'layui-icon iconfont iconqingjiaguanli-', 5, '2019-06-15 15:42:55', '2020-04-21 02:33:04');
INSERT INTO `s_saas_user_permission_list` VALUES (7, 0, '后台权限管理', 'backPermissionManage', '', 'layui-icon iconfont iconquanxianguanli', 9, '2019-06-15 15:43:51', '2020-04-21 02:33:19');
INSERT INTO `s_saas_user_permission_list` VALUES (8, 1, '部门管理', 'departmentManage', NULL, NULL, NULL, '2019-06-15 16:22:12', '2019-06-18 17:10:46');
INSERT INTO `s_saas_user_permission_list` VALUES (9, 1, '职位管理', 'jobManage', NULL, NULL, NULL, '2019-06-15 16:32:53', '2019-06-15 16:32:53');
INSERT INTO `s_saas_user_permission_list` VALUES (10, 3, '在职人员', 'onEmployee', NULL, NULL, NULL, '2019-06-15 16:44:58', '2019-06-15 16:44:58');
INSERT INTO `s_saas_user_permission_list` VALUES (11, 3, '离职员工', 'offEmployee', NULL, NULL, NULL, '2019-06-15 16:45:18', '2019-06-15 17:04:32');
INSERT INTO `s_saas_user_permission_list` VALUES (13, 4, '排班时间', 'arrangeTime', NULL, NULL, NULL, '2019-06-15 17:05:32', '2019-06-15 17:05:32');
INSERT INTO `s_saas_user_permission_list` VALUES (14, 4, '员工排班', 'employeeArrange', NULL, NULL, NULL, '2019-06-15 17:06:06', '2019-06-15 17:06:06');
INSERT INTO `s_saas_user_permission_list` VALUES (15, 4, '干部排班', 'leaderArrange', NULL, NULL, NULL, '2019-06-15 17:06:26', '2019-06-17 15:44:03');
INSERT INTO `s_saas_user_permission_list` VALUES (16, 5, '假期管理', 'holidayManage', NULL, NULL, NULL, '2019-06-15 17:07:00', '2019-06-15 17:07:09');
INSERT INTO `s_saas_user_permission_list` VALUES (17, 5, '考勤规则', 'attendanceRules', NULL, NULL, NULL, '2019-06-15 17:08:10', '2019-06-15 17:08:16');
INSERT INTO `s_saas_user_permission_list` VALUES (18, 5, '打卡记录', 'punchCardRecord', NULL, NULL, NULL, '2019-06-15 17:08:43', '2019-06-15 17:09:13');
INSERT INTO `s_saas_user_permission_list` VALUES (19, 5, '考勤统计', 'attendanceStatistics', NULL, NULL, NULL, '2019-06-15 17:09:55', '2019-06-15 17:10:05');
INSERT INTO `s_saas_user_permission_list` VALUES (20, 0, '补卡管理', 'reissueCardManage', '', 'layui-icon iconfont iconbuka', 6, '2019-06-15 17:10:52', '2020-04-21 02:33:07');
INSERT INTO `s_saas_user_permission_list` VALUES (21, 20, '补卡申请', 'reissueCardReply', NULL, NULL, NULL, '2019-06-15 17:12:10', '2019-06-15 17:12:10');
INSERT INTO `s_saas_user_permission_list` VALUES (22, 20, '补卡通过', 'reissueCardPass', NULL, NULL, NULL, '2019-06-15 17:12:44', '2019-06-15 17:13:31');
INSERT INTO `s_saas_user_permission_list` VALUES (23, 20, '补卡不通过', 'reissueCardUnPass', NULL, NULL, NULL, '2019-06-15 17:15:21', '2019-06-15 17:21:56');
INSERT INTO `s_saas_user_permission_list` VALUES (24, 6, '请假类型', 'leaveType', NULL, NULL, NULL, '2019-06-15 17:18:53', '2019-06-15 17:19:29');
INSERT INTO `s_saas_user_permission_list` VALUES (25, 6, '请假设置', 'leaveSet', NULL, NULL, NULL, '2019-06-15 17:20:00', '2019-06-15 17:20:00');
INSERT INTO `s_saas_user_permission_list` VALUES (26, 6, '请假审核', 'leaveCheck', NULL, NULL, NULL, '2019-06-15 17:22:36', '2019-06-15 17:22:36');
INSERT INTO `s_saas_user_permission_list` VALUES (27, 6, '审核通过', 'leavePass', NULL, NULL, NULL, '2019-06-15 17:23:37', '2019-06-15 17:24:00');
INSERT INTO `s_saas_user_permission_list` VALUES (28, 6, '审核不通过', 'leaveUnPass', NULL, NULL, NULL, '2019-06-15 17:24:34', '2019-06-15 17:24:34');
INSERT INTO `s_saas_user_permission_list` VALUES (29, 7, '管理员管理', 'saasUserManage', '/saasUser/jumpPaging', '', 3, '2019-06-15 17:25:15', '2020-04-21 02:34:01');
INSERT INTO `s_saas_user_permission_list` VALUES (30, 7, '角色管理', 'saasUserRoleManage', '/saasUserRoleType/jumpPaging', '', 1, '2019-06-15 17:25:57', '2020-04-21 02:33:42');
INSERT INTO `s_saas_user_permission_list` VALUES (31, 7, '权限管理', 'saasUserPermissionManage', '/saasUserPermissionList/jumpPaging', '', 2, '2019-06-15 17:26:28', '2020-04-21 02:33:52');
INSERT INTO `s_saas_user_permission_list` VALUES (32, 8, '添加', 'departmentManageAdd', NULL, NULL, NULL, NULL, '2019-06-17 17:07:09');
INSERT INTO `s_saas_user_permission_list` VALUES (38, 8, '修改', 'departmentManageUpdate', NULL, NULL, NULL, '2019-06-17 17:08:08', '2019-06-17 17:08:15');
INSERT INTO `s_saas_user_permission_list` VALUES (39, 8, '删除', 'departmentManageDelete', NULL, NULL, NULL, '2019-06-17 17:11:30', '2019-06-17 17:11:30');
INSERT INTO `s_saas_user_permission_list` VALUES (40, 4, '排班记录', 'arrangeRecord', NULL, NULL, NULL, '2019-06-18 14:49:58', '2019-06-19 14:20:16');
INSERT INTO `s_saas_user_permission_list` VALUES (41, 9, '职位添加', 'jobManageAdd', NULL, NULL, NULL, '2019-06-19 14:10:23', '2019-06-19 14:10:23');
INSERT INTO `s_saas_user_permission_list` VALUES (42, 9, '职位修改', 'jobManageUpdate', NULL, NULL, NULL, '2019-06-19 14:10:38', '2019-06-19 14:10:38');
INSERT INTO `s_saas_user_permission_list` VALUES (43, 9, '职位删除', 'jobManageDelete', NULL, NULL, NULL, '2019-06-19 14:10:57', '2019-06-19 14:10:57');
INSERT INTO `s_saas_user_permission_list` VALUES (44, 10, '添加', 'employeeManageAdd', NULL, NULL, NULL, '2019-06-19 14:12:48', '2019-06-19 14:13:25');
INSERT INTO `s_saas_user_permission_list` VALUES (45, 10, '修改', 'employeeManageUpdate', NULL, NULL, NULL, '2019-06-19 14:13:13', '2019-06-19 14:13:13');
INSERT INTO `s_saas_user_permission_list` VALUES (46, 10, '冻结', 'employeeManageFrost', NULL, NULL, NULL, '2019-06-19 14:14:02', '2019-06-19 16:45:53');
INSERT INTO `s_saas_user_permission_list` VALUES (47, 10, '批量冻结', 'employeeManageBatchFrost', NULL, NULL, NULL, '2019-06-19 14:14:34', '2019-06-19 15:07:00');
INSERT INTO `s_saas_user_permission_list` VALUES (48, 11, '添加', 'employeeManageAdd', NULL, NULL, NULL, '2019-06-19 14:15:09', '2019-06-19 16:24:12');
INSERT INTO `s_saas_user_permission_list` VALUES (49, 11, '修改', 'employeeManageUpdate', NULL, NULL, NULL, '2019-06-19 14:15:31', '2019-06-19 16:24:24');
INSERT INTO `s_saas_user_permission_list` VALUES (50, 11, '删除', 'employeeManageDelete', NULL, NULL, NULL, '2019-06-19 14:15:58', '2019-06-19 16:24:33');
INSERT INTO `s_saas_user_permission_list` VALUES (51, 13, '添加', 'arrangeTimeAdd', NULL, NULL, NULL, '2019-06-19 14:18:33', '2019-06-19 16:26:13');
INSERT INTO `s_saas_user_permission_list` VALUES (53, 13, '修改', 'arrangeTimeUpdate', NULL, NULL, NULL, '2019-06-19 14:19:12', '2019-06-19 16:26:20');
INSERT INTO `s_saas_user_permission_list` VALUES (54, 13, '删除', 'arrangeTimeDelete', NULL, NULL, NULL, '2019-06-19 14:19:29', '2019-06-19 16:26:28');
INSERT INTO `s_saas_user_permission_list` VALUES (55, 14, '添加', 'employeeArrangeAdd', NULL, NULL, NULL, '2019-06-19 14:29:14', '2019-06-19 14:29:14');
INSERT INTO `s_saas_user_permission_list` VALUES (56, 14, '修改', 'employeeArrangeUpdate', NULL, NULL, NULL, '2019-06-19 14:29:22', '2019-06-19 14:29:31');
INSERT INTO `s_saas_user_permission_list` VALUES (57, 15, '添加', 'leaderArrangeAdd', NULL, NULL, NULL, '2019-06-19 14:31:28', '2019-06-19 14:31:28');
INSERT INTO `s_saas_user_permission_list` VALUES (58, 15, '修改', 'leaderArrangeUpdate', NULL, NULL, NULL, '2019-06-19 14:31:50', '2019-06-19 14:31:50');
INSERT INTO `s_saas_user_permission_list` VALUES (60, 16, '添加', 'holidayManageAdd', NULL, NULL, NULL, '2019-06-19 14:34:30', '2019-06-19 14:34:30');
INSERT INTO `s_saas_user_permission_list` VALUES (61, 16, '修改', 'holidayManageUpdate', NULL, NULL, NULL, '2019-06-19 14:34:48', '2019-06-19 14:34:48');
INSERT INTO `s_saas_user_permission_list` VALUES (62, 16, '删除', 'holidayManageDelete', NULL, NULL, NULL, '2019-06-19 14:35:03', '2019-06-19 14:35:03');
INSERT INTO `s_saas_user_permission_list` VALUES (63, 17, '添加', 'attendanceRulesAdd', NULL, NULL, NULL, '2019-06-19 14:37:42', '2019-06-19 14:37:42');
INSERT INTO `s_saas_user_permission_list` VALUES (64, 17, '编辑', 'attendanceRulesUpdate', NULL, NULL, NULL, '2019-06-19 14:37:55', '2019-06-19 14:37:55');
INSERT INTO `s_saas_user_permission_list` VALUES (65, 17, '删除', 'attendanceRulesDelete', NULL, NULL, NULL, '2019-06-19 14:38:10', '2019-06-19 14:38:10');
INSERT INTO `s_saas_user_permission_list` VALUES (66, 18, '添加', 'punchCardRecordAdd', NULL, NULL, NULL, '2019-06-19 14:39:53', '2019-06-19 14:39:53');
INSERT INTO `s_saas_user_permission_list` VALUES (67, 18, '修改', 'punchCardRecordUpdate', NULL, NULL, NULL, '2019-06-19 14:40:07', '2019-06-19 14:40:07');
INSERT INTO `s_saas_user_permission_list` VALUES (68, 18, '删除', 'punchCardRecordDelete', NULL, NULL, NULL, '2019-06-19 14:40:19', '2019-06-19 14:40:19');
INSERT INTO `s_saas_user_permission_list` VALUES (69, 24, '添加', 'leaveTypeAdd', NULL, NULL, NULL, '2019-06-19 14:41:13', '2019-06-19 14:41:13');
INSERT INTO `s_saas_user_permission_list` VALUES (70, 24, '修改', 'leaveTypeUpdate', NULL, NULL, NULL, '2019-06-19 14:41:29', '2019-06-19 14:41:29');
INSERT INTO `s_saas_user_permission_list` VALUES (71, 24, '删除', 'leaveTypeDelete', NULL, NULL, NULL, '2019-06-19 14:41:44', '2019-06-19 14:41:44');
INSERT INTO `s_saas_user_permission_list` VALUES (72, 25, '修改', 'leaveSetUpdate', NULL, NULL, NULL, '2019-06-19 14:42:56', '2019-06-19 14:42:56');
INSERT INTO `s_saas_user_permission_list` VALUES (73, 29, '添加', 'add_saasUser', NULL, NULL, NULL, '2019-06-19 14:53:33', '2020-04-21 00:38:51');
INSERT INTO `s_saas_user_permission_list` VALUES (74, 29, '编辑', 'update_saasUser', NULL, NULL, NULL, '2019-06-19 14:53:56', '2020-04-21 00:39:16');
INSERT INTO `s_saas_user_permission_list` VALUES (75, 29, '删除', 'delete_saasUser', NULL, NULL, NULL, '2019-06-19 14:54:18', '2020-04-21 00:39:06');
INSERT INTO `s_saas_user_permission_list` VALUES (76, 30, '添加', 'roleManageAdd', NULL, NULL, NULL, '2019-06-19 14:55:59', '2019-06-19 14:55:59');
INSERT INTO `s_saas_user_permission_list` VALUES (77, 30, '修改', 'roleManageUpdate', NULL, NULL, NULL, '2019-06-19 14:56:17', '2019-06-19 14:56:17');
INSERT INTO `s_saas_user_permission_list` VALUES (78, 30, '删除', 'roleManageDelete', NULL, NULL, NULL, '2019-06-19 14:56:24', '2019-06-19 14:56:32');
INSERT INTO `s_saas_user_permission_list` VALUES (79, 30, '设置权限', 'roleManageSetPermission', NULL, NULL, NULL, '2019-06-19 14:57:16', '2019-06-19 14:57:49');
INSERT INTO `s_saas_user_permission_list` VALUES (80, 31, '添加', 'permissionManageAdd', NULL, NULL, NULL, '2019-06-19 14:58:09', '2019-06-19 14:58:09');
INSERT INTO `s_saas_user_permission_list` VALUES (81, 31, '修改', 'permissionManageUpdate', NULL, NULL, NULL, '2019-06-19 14:58:20', '2019-06-19 14:58:20');
INSERT INTO `s_saas_user_permission_list` VALUES (82, 31, '删除', 'permissionManageDelete', NULL, NULL, NULL, '2019-06-19 14:58:34', '2019-06-19 14:58:34');
INSERT INTO `s_saas_user_permission_list` VALUES (83, 0, '调休管理', 'leaveInLieuManage', '', 'layui-icon iconfont icontiaoxiushenqing', 7, '2019-07-06 14:58:04', '2020-04-21 02:33:14');
INSERT INTO `s_saas_user_permission_list` VALUES (84, 83, '调休纪记录', 'leaveInLieuRecord', NULL, NULL, NULL, '2019-07-06 14:58:46', '2019-07-06 14:58:46');

-- ----------------------------
-- Table structure for s_saas_user_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `s_saas_user_role_permission`;
CREATE TABLE `s_saas_user_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '员工角色权限id',
  `saas_user_role_id` bigint(20) NULL DEFAULT NULL COMMENT '员工角色id',
  `saas_user_permission_id` bigint(20) NULL DEFAULT NULL COMMENT '员工权限id',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2908 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_saas_user_role_permission
-- ----------------------------
INSERT INTO `s_saas_user_role_permission` VALUES (1212, NULL, 1, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1213, NULL, 8, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1214, NULL, 32, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1215, NULL, 38, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1216, NULL, 39, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1217, NULL, 9, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1218, NULL, 41, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1219, NULL, 42, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1220, NULL, 43, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1221, NULL, 3, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1222, NULL, 10, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1223, NULL, 44, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1224, NULL, 45, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1225, NULL, 46, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1226, NULL, 47, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1227, NULL, 11, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1228, NULL, 48, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1229, NULL, 49, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1230, NULL, 50, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1231, NULL, 4, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1232, NULL, 13, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1233, NULL, 51, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1234, NULL, 53, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1235, NULL, 54, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1236, NULL, 14, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1237, NULL, 55, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1238, NULL, 56, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1239, NULL, 15, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1240, NULL, 57, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1241, NULL, 58, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1242, NULL, 40, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (1243, NULL, 5, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2758, 3, 1, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2759, 3, 8, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2760, 3, 32, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2761, 3, 38, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2762, 3, 39, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2763, 3, 9, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2764, 3, 41, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2765, 3, 42, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2766, 3, 43, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2767, 3, 3, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2768, 3, 10, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2769, 3, 44, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2770, 3, 45, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2771, 3, 46, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2772, 3, 47, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2773, 3, 11, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2774, 3, 48, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2775, 3, 49, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2776, 3, 50, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2777, 3, 4, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2778, 3, 13, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2779, 3, 51, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2780, 3, 53, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2781, 3, 54, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2782, 3, 14, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2783, 3, 55, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2784, 3, 56, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2785, 3, 15, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2786, 3, 57, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2787, 3, 58, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2788, 3, 40, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2789, 3, 5, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2790, 3, 16, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2791, 3, 60, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2792, 3, 61, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2793, 3, 62, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2794, 3, 17, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2795, 3, 63, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2796, 3, 64, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2797, 3, 65, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2798, 3, 18, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2799, 3, 66, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2800, 3, 67, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2801, 3, 68, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2802, 3, 19, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2803, 3, 6, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2804, 3, 24, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2805, 3, 69, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2806, 3, 70, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2807, 3, 71, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2808, 3, 25, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2809, 3, 72, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2810, 3, 26, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2811, 3, 27, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2812, 3, 28, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2813, 3, 7, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2814, 3, 29, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2815, 3, 73, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2816, 3, 74, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2817, 3, 75, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2818, 3, 30, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2819, 3, 76, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2820, 3, 77, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2821, 3, 78, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2822, 3, 79, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2823, 3, 31, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2824, 3, 80, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2825, 3, 81, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2826, 3, 82, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2827, 3, 20, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2828, 3, 21, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2829, 3, 22, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2830, 3, 23, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2831, 3, 83, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2832, 3, 84, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2833, 2, 1, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2834, 2, 8, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2835, 2, 32, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2836, 2, 38, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2837, 2, 39, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2838, 2, 9, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2839, 2, 41, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2840, 2, 42, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2841, 2, 43, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2842, 2, 3, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2843, 2, 10, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2844, 2, 44, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2845, 2, 45, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2846, 2, 46, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2847, 2, 47, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2848, 2, 11, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2849, 2, 48, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2850, 2, 49, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2851, 2, 50, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2852, 2, 4, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2853, 2, 13, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2854, 2, 51, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2855, 2, 53, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2856, 2, 54, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2857, 2, 14, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2858, 2, 55, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2859, 2, 56, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2860, 2, 15, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2861, 2, 57, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2862, 2, 58, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2863, 2, 40, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2864, 2, 5, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2865, 2, 16, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2866, 2, 60, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2867, 2, 61, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2868, 2, 62, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2869, 2, 17, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2870, 2, 63, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2871, 2, 64, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2872, 2, 65, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2873, 2, 18, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2874, 2, 66, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2875, 2, 67, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2876, 2, 68, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2877, 2, 19, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2878, 2, 6, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2879, 2, 24, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2880, 2, 69, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2881, 2, 70, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2882, 2, 71, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2883, 2, 25, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2884, 2, 72, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2885, 2, 26, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2886, 2, 27, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2887, 2, 28, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2888, 2, 7, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2889, 2, 29, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2890, 2, 73, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2891, 2, 74, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2892, 2, 75, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2893, 2, 30, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2894, 2, 76, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2895, 2, 77, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2896, 2, 78, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2897, 2, 79, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2898, 2, 31, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2899, 2, 80, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2900, 2, 81, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2901, 2, 82, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2902, 2, 20, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2903, 2, 21, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2904, 2, 22, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2905, 2, 23, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2906, 2, 83, NULL, NULL);
INSERT INTO `s_saas_user_role_permission` VALUES (2907, 2, 84, NULL, NULL);

-- ----------------------------
-- Table structure for s_saas_user_role_type
-- ----------------------------
DROP TABLE IF EXISTS `s_saas_user_role_type`;
CREATE TABLE `s_saas_user_role_type`  (
  `id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '员工角色id',
  `name` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `descript` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '添加时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of s_saas_user_role_type
-- ----------------------------
INSERT INTO `s_saas_user_role_type` VALUES (2, '厂长', NULL, '2019-06-15 17:56:00', '2019-06-15 17:56:00');
INSERT INTO `s_saas_user_role_type` VALUES (3, '人事', NULL, '2019-06-15 17:56:30', '2019-06-15 17:56:30');
INSERT INTO `s_saas_user_role_type` VALUES (4, '生产部部长', NULL, '2019-06-17 08:38:10', '2019-06-17 08:38:10');

SET FOREIGN_KEY_CHECKS = 1;
