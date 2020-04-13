/*
Navicat MySQL Data Transfer

Source Server         : 134.175.168.124_3306
Source Server Version : 50715
Source Host           : 134.175.168.124:3306
Source Database       : youqu

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2020-04-13 20:18:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_log`
-- ----------------------------
DROP TABLE IF EXISTS `sys_log`;
CREATE TABLE `sys_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一ID',
  `opt_id` int(11) DEFAULT NULL COMMENT '操作用户id',
  `opt_name` varchar(50) DEFAULT NULL COMMENT '操作用户名',
  `log_type` varchar(20) DEFAULT NULL COMMENT '日志类型',
  `log_message` varchar(255) DEFAULT NULL COMMENT '日志信息（具体方法名）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of sys_log
-- ----------------------------
INSERT INTO `sys_log` VALUES ('3', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-11 14:33:42');
INSERT INTO `sys_log` VALUES ('4', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-11 14:34:13');
INSERT INTO `sys_log` VALUES ('5', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-11 14:34:19');
INSERT INTO `sys_log` VALUES ('17', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:33:57');
INSERT INTO `sys_log` VALUES ('18', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:38:21');
INSERT INTO `sys_log` VALUES ('19', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:38:21');
INSERT INTO `sys_log` VALUES ('20', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:38:21');
INSERT INTO `sys_log` VALUES ('21', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:38:21');
INSERT INTO `sys_log` VALUES ('22', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:38:22');
INSERT INTO `sys_log` VALUES ('23', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:38:24');
INSERT INTO `sys_log` VALUES ('24', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:40:32');
INSERT INTO `sys_log` VALUES ('25', '9', '88888888@qq.com', '保存', 'cn.zdxh.user.controller.TUserController.updateUserInfoFront', '2020-04-12 22:42:39');
INSERT INTO `sys_log` VALUES ('26', '9', '88888888@qq.com', '保存', 'cn.zdxh.user.controller.TUserController.updateUserInfoFront', '2020-04-12 22:42:54');
INSERT INTO `sys_log` VALUES ('27', '9', '88888888@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:43:10');
INSERT INTO `sys_log` VALUES ('28', '8', '664650322@qq.com', '保存', 'cn.zdxh.user.controller.TUserController.updateUserInfoFront', '2020-04-12 22:44:01');
INSERT INTO `sys_log` VALUES ('29', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:52:00');
INSERT INTO `sys_log` VALUES ('30', '9', '88888888@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:52:37');
INSERT INTO `sys_log` VALUES ('31', '9', '88888888@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 22:55:41');
INSERT INTO `sys_log` VALUES ('32', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:40:23');
INSERT INTO `sys_log` VALUES ('33', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:35');
INSERT INTO `sys_log` VALUES ('34', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:36');
INSERT INTO `sys_log` VALUES ('35', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:36');
INSERT INTO `sys_log` VALUES ('36', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:36');
INSERT INTO `sys_log` VALUES ('37', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:36');
INSERT INTO `sys_log` VALUES ('38', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:36');
INSERT INTO `sys_log` VALUES ('39', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-12 23:44:38');
INSERT INTO `sys_log` VALUES ('40', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:00');
INSERT INTO `sys_log` VALUES ('41', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:00');
INSERT INTO `sys_log` VALUES ('42', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:00');
INSERT INTO `sys_log` VALUES ('43', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:00');
INSERT INTO `sys_log` VALUES ('44', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:01');
INSERT INTO `sys_log` VALUES ('45', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:04');
INSERT INTO `sys_log` VALUES ('46', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 00:22:05');
INSERT INTO `sys_log` VALUES ('47', null, null, '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 10:38:22');
INSERT INTO `sys_log` VALUES ('48', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 10:40:03');
INSERT INTO `sys_log` VALUES ('49', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 10:50:42');
INSERT INTO `sys_log` VALUES ('50', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 10:51:09');
INSERT INTO `sys_log` VALUES ('51', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 10:51:10');
INSERT INTO `sys_log` VALUES ('52', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 10:51:26');
INSERT INTO `sys_log` VALUES ('53', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 10:51:28');
INSERT INTO `sys_log` VALUES ('54', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 10:52:18');
INSERT INTO `sys_log` VALUES ('55', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TInvitationController.save', '2020-04-13 10:52:41');
INSERT INTO `sys_log` VALUES ('56', '8', '664650322@qq.com', '保存', 'cn.zdxh.user.controller.TUserController.updateUserInfoFront', '2020-04-13 10:53:00');
INSERT INTO `sys_log` VALUES ('57', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:00:58');
INSERT INTO `sys_log` VALUES ('58', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:03:14');
INSERT INTO `sys_log` VALUES ('59', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:03:39');
INSERT INTO `sys_log` VALUES ('60', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 11:03:42');
INSERT INTO `sys_log` VALUES ('61', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:04:03');
INSERT INTO `sys_log` VALUES ('62', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:04:03');
INSERT INTO `sys_log` VALUES ('63', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:04:04');
INSERT INTO `sys_log` VALUES ('64', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:04:06');
INSERT INTO `sys_log` VALUES ('65', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:04:09');
INSERT INTO `sys_log` VALUES ('66', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:05:42');
INSERT INTO `sys_log` VALUES ('67', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:05:54');
INSERT INTO `sys_log` VALUES ('68', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TInvitationController.save', '2020-04-13 11:06:23');
INSERT INTO `sys_log` VALUES ('69', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:10:10');
INSERT INTO `sys_log` VALUES ('70', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:15:38');
INSERT INTO `sys_log` VALUES ('71', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:16:04');
INSERT INTO `sys_log` VALUES ('72', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 11:16:08');
INSERT INTO `sys_log` VALUES ('73', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:16:17');
INSERT INTO `sys_log` VALUES ('74', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:16:22');
INSERT INTO `sys_log` VALUES ('75', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TInvitationController.save', '2020-04-13 11:17:30');
INSERT INTO `sys_log` VALUES ('76', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:22:37');
INSERT INTO `sys_log` VALUES ('77', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:24:29');
INSERT INTO `sys_log` VALUES ('78', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:26:23');
INSERT INTO `sys_log` VALUES ('79', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:27:08');
INSERT INTO `sys_log` VALUES ('80', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 11:27:12');
INSERT INTO `sys_log` VALUES ('81', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:27:19');
INSERT INTO `sys_log` VALUES ('82', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:27:21');
INSERT INTO `sys_log` VALUES ('83', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:30:25');
INSERT INTO `sys_log` VALUES ('84', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:31:10');
INSERT INTO `sys_log` VALUES ('85', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 11:31:12');
INSERT INTO `sys_log` VALUES ('86', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:31:17');
INSERT INTO `sys_log` VALUES ('87', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:31:19');
INSERT INTO `sys_log` VALUES ('88', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:33:31');
INSERT INTO `sys_log` VALUES ('89', '8', '664650322@qq.com', '登录', 'cn.zdxh.user.controller.TUserController.login', '2020-04-13 11:33:34');
INSERT INTO `sys_log` VALUES ('90', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:33:54');
INSERT INTO `sys_log` VALUES ('91', '8', '664650322@qq.com', '收藏', 'cn.zdxh.invitation.controller.TInvitationController.addCollect', '2020-04-13 11:33:56');
INSERT INTO `sys_log` VALUES ('92', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TCommentController.save', '2020-04-13 11:34:02');
INSERT INTO `sys_log` VALUES ('93', '8', '664650322@qq.com', '点赞', 'cn.zdxh.invitation.controller.TInvitationController.addLaud', '2020-04-13 11:34:03');
INSERT INTO `sys_log` VALUES ('94', '8', '664650322@qq.com', '保存', 'cn.zdxh.invitation.controller.TInvitationController.save', '2020-04-13 11:35:08');
INSERT INTO `sys_log` VALUES ('95', '8', '664650322@qq.com', '保存', 'cn.zdxh.user.controller.TUserController.updateUserInfoFront', '2020-04-13 11:36:56');
INSERT INTO `sys_log` VALUES ('96', '2', 'admin', '保存', 'cn.zdxh.invitation.controller.TInvitationController.save', '2020-04-13 12:06:40');

-- ----------------------------
-- Table structure for `t_comment`
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一主键',
  `com_content` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `com_image` varchar(255) DEFAULT NULL COMMENT '评论图片（可多张）',
  `com_laud` varchar(255) DEFAULT '0' COMMENT '点赞数',
  `inv_id` int(11) NOT NULL COMMENT '帖子id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COMMENT='评论表';

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES ('1', '巧了，今天我也去了华阳湖', 'http://www.gogle.com', '0', '1', '1', '2019-12-17 16:01:15');
INSERT INTO `t_comment` VALUES ('2', '我觉得这显示屏不好看！', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '0', '3', '1', '2019-12-17 16:01:18');
INSERT INTO `t_comment` VALUES ('4', '不错不错', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '0', '12', '1', '2020-02-02 15:08:04');
INSERT INTO `t_comment` VALUES ('5', '很好笑', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '0', '12', '1', '2020-02-02 15:08:31');
INSERT INTO `t_comment` VALUES ('7', '哇！偶像！', null, '0', '11', '9', '2020-02-02 18:33:59');
INSERT INTO `t_comment` VALUES ('8', '哎哟，不错哦！', null, '0', '6', '8', '2020-02-02 20:30:12');
INSERT INTO `t_comment` VALUES ('9', '哈哈哈，这小孩车技真的?啊', null, '0', '6', '8', '2020-02-02 20:36:11');
INSERT INTO `t_comment` VALUES ('10', '想学习学习', null, '0', '6', '8', '2020-02-02 20:45:09');
INSERT INTO `t_comment` VALUES ('11', '这手柄在哪里买的？ ', null, '0', '2', '8', '2020-02-02 20:48:44');
INSERT INTO `t_comment` VALUES ('12', '哎哟不错哦', null, '0', '23', '8', '2020-04-13 10:51:26');
INSERT INTO `t_comment` VALUES ('13', '哎哟不错哦哦哦', null, '0', '23', '8', '2020-04-13 11:03:52');
INSERT INTO `t_comment` VALUES ('14', '哎哟不错哦哦哦', null, '0', '23', '8', '2020-04-13 11:04:03');
INSERT INTO `t_comment` VALUES ('15', '哎哟不错哦哦哦', null, '0', '23', '8', '2020-04-13 11:03:54');
INSERT INTO `t_comment` VALUES ('16', '哎哟不错哦哦哦', null, '0', '23', '8', '2020-04-13 11:04:01');
INSERT INTO `t_comment` VALUES ('17', '噢噢噢', null, '0', '22', '8', '2020-04-13 11:05:54');
INSERT INTO `t_comment` VALUES ('18', '测试测试', null, '0', '23', '8', '2020-04-13 11:16:17');
INSERT INTO `t_comment` VALUES ('19', '测试测试', null, '0', '23', '8', '2020-04-13 11:27:19');
INSERT INTO `t_comment` VALUES ('20', '答辩', null, '0', '23', '8', '2020-04-13 11:31:17');
INSERT INTO `t_comment` VALUES ('21', '答辩测试', null, '0', '23', '8', '2020-04-13 11:34:02');

-- ----------------------------
-- Table structure for `t_focus_fans`
-- ----------------------------
DROP TABLE IF EXISTS `t_focus_fans`;
CREATE TABLE `t_focus_fans` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `friend_id` int(11) NOT NULL COMMENT '好友id',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '类型。1关注2粉丝',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='关注和粉丝表';

-- ----------------------------
-- Records of t_focus_fans
-- ----------------------------
INSERT INTO `t_focus_fans` VALUES ('3', '8', '2', '1', '2020-03-31 23:12:58');
INSERT INTO `t_focus_fans` VALUES ('4', '2', '8', '2', '2020-03-31 23:12:58');
INSERT INTO `t_focus_fans` VALUES ('5', '8', '1', '1', '2020-04-01 12:20:40');
INSERT INTO `t_focus_fans` VALUES ('6', '1', '8', '2', '2020-04-01 12:20:40');
INSERT INTO `t_focus_fans` VALUES ('7', '8', '9', '2', '2020-04-01 12:28:11');
INSERT INTO `t_focus_fans` VALUES ('8', '9', '8', '1', '2020-04-01 12:28:14');
INSERT INTO `t_focus_fans` VALUES ('15', '8', '9', '1', '2020-04-13 11:35:21');
INSERT INTO `t_focus_fans` VALUES ('16', '9', '8', '2', '2020-04-13 11:35:21');

-- ----------------------------
-- Table structure for `t_invitation`
-- ----------------------------
DROP TABLE IF EXISTS `t_invitation`;
CREATE TABLE `t_invitation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一id',
  `inv_content` varchar(255) DEFAULT NULL COMMENT '帖子内容',
  `inv_type` int(11) NOT NULL DEFAULT '1' COMMENT '帖子类型。图文1视频2',
  `inv_image` varchar(255) DEFAULT NULL COMMENT '帖子图片（可多张）',
  `inv_video` varchar(255) DEFAULT NULL COMMENT '帖子视频',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `top_id` int(11) NOT NULL COMMENT '话题id',
  `inv_laud` varchar(255) DEFAULT '0' COMMENT '点赞数',
  `inv_share` varchar(255) DEFAULT '0' COMMENT '分享数',
  `inv_collect` varchar(255) DEFAULT '0' COMMENT '收藏数',
  `inv_status` tinyint(4) DEFAULT '0' COMMENT '审核状态（0未审核/1审核通过/2审核未通过）',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COMMENT='帖子表';

-- ----------------------------
-- Records of t_invitation
-- ----------------------------
INSERT INTO `t_invitation` VALUES ('1', '今天的华阳湖真美！', '1', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '', '1', '3', '0', '0', '0', '1', '2019-12-17 15:52:15');
INSERT INTO `t_invitation` VALUES ('2', '强悍的游戏手柄！！！', '1', 'http://qiniu.ningxiaojian.top/e47a18ff-beb8-4f2e-a046-5c2ee6d29fce.png', '', '2', '1', '0', '0', '0', '1', '2019-12-17 15:53:15');
INSERT INTO `t_invitation` VALUES ('3', '完美的显示屏！！！', '1', 'http://qiniu.ningxiaojian.top/e47a18ff-beb8-4f2e-a046-5c2ee6d29fce.png,http://qiniu.ningxiaojian.top/e47a18ff-beb8-4f2e-a046-5c2ee6d29fce.png', '', '8', '1', '0', '0', '0', '1', '2019-12-17 15:44:46');
INSERT INTO `t_invitation` VALUES ('6', '无解的漂移！', '2', null, 'http://qiniu.ningxiaojian.top/219ac8f8-3eb4-4c5c-bfb6-a844ef5dc6e8.mp4', '9', '4', '0', '1', '0', '1', '2019-12-23 11:02:24');
INSERT INTO `t_invitation` VALUES ('11', '这是个帅哥吧', '1', 'http://qiniu.ningxiaojian.top/eed6732f-5a0a-4053-8cb6-903fc76db122.jpeg,http://qiniu.ningxiaojian.top/6cb15e6e-0f2d-43e3-a10b-ba2afbda7bae.jpg,http://qiniu.ningxiaojian.top/e47a18ff-beb8-4f2e-a046-5c2ee6d29fce.png', '', '2', '1', '0', '1', '0', '2', '2020-01-19 21:42:23');
INSERT INTO `t_invitation` VALUES ('12', '下午刚发现个搞笑视频，分享给你们哈哈', '2', '', 'http://qiniu.ningxiaojian.top/d9e581fe-8dc6-4c81-b42a-ae540e07ec62.mp4', '1', '1', '0', '1', '0', '1', '2020-01-19 21:47:56');
INSERT INTO `t_invitation` VALUES ('22', '测试视频1', '2', null, 'http://qiniu.ningxiaojian.top/3d9d0aea-c96f-4246-aa47-e39f1c40218d.mp4', '2', '2', '0', '0', '0', '1', '2020-04-08 19:56:01');
INSERT INTO `t_invitation` VALUES ('23', '测试图片', '1', 'http://qiniu.ningxiaojian.top/3357cb81-e658-4c92-8718-10156fbac582.jpg,http://qiniu.ningxiaojian.top/cca4c97f-255b-4fe9-b816-cd84c38c479b.jpg,http://qiniu.ningxiaojian.top/46cc6415-955b-400f-968d-911351f64265.jpg', null, '2', '1', '0', '0', '0', '1', '2020-04-08 20:15:40');
INSERT INTO `t_invitation` VALUES ('24', '测试视频2', '2', null, 'http://qiniu.ningxiaojian.top/2f3aa15a-457d-47fb-997a-abfef68a77ab.mp4', '2', '3', '0', '0', '0', '1', '2020-04-08 20:19:12');
INSERT INTO `t_invitation` VALUES ('33', '测试定时器', '1', 'http://qiniu.ningxiaojian.top/f2021d6b-7ce4-44ec-8305-c6123d8a560c.jpeg', '', '8', '1', '0', '0', '0', '1', '2020-04-08 22:49:11');
INSERT INTO `t_invitation` VALUES ('37', '测试测试', '1', 'http://qiniu.ningxiaojian.top/d7285080-7c5a-4386-a017-f9b2bb3c4e77.jpeg', '', '8', '7', '0', '0', '0', '1', '2020-04-13 11:35:08');

-- ----------------------------
-- Table structure for `t_topic`
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `top_name` varchar(30) NOT NULL COMMENT '话题名称',
  `top_note` varchar(255) DEFAULT NULL COMMENT '话题备注',
  `top_image` varchar(255) DEFAULT NULL COMMENT '话题图标',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='话题表';

-- ----------------------------
-- Records of t_topic
-- ----------------------------
INSERT INTO `t_topic` VALUES ('1', '宅男区', '宅男专属地带', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '2019-12-16 17:22:38');
INSERT INTO `t_topic` VALUES ('2', '声控区', '声控福利专区', 'http://qiniu.ningxiaojian.top/1.jpg', '2019-12-16 17:24:53');
INSERT INTO `t_topic` VALUES ('3', '风景区', '美丽的风景', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '2019-12-17 15:47:05');
INSERT INTO `t_topic` VALUES ('4', '高分影区', '高分电影推荐', 'http://qiniu.ningxiaojian.top/004ebc1f-6a38-4b32-b6a2-4673310aecdf.jpg', '2019-12-18 15:50:01');
INSERT INTO `t_topic` VALUES ('5', '搞笑视频', '一堆搞笑视频', 'http://qiniu.ningxiaojian.top/e47a18ff-beb8-4f2e-a046-5c2ee6d29fce.png', '2019-12-18 15:50:29');
INSERT INTO `t_topic` VALUES ('7', '搞笑图片', '一堆搞笑图片', null, '2019-12-18 19:11:07');
INSERT INTO `t_topic` VALUES ('8', '程序猿园区', '程序员日常分享', 'http://qiniu.ningxiaojian.top/d842cac4-977b-400a-9d9b-aa4e1b1d1531.png', '2019-12-18 19:13:33');
INSERT INTO `t_topic` VALUES ('9', '游戏日常', '吐槽游戏日常', 'http://qiniu.ningxiaojian.top/06e72940-14a1-4d95-946c-0b41556c927b.jpg', '2019-12-19 17:51:16');
INSERT INTO `t_topic` VALUES ('11', '追星狂热区', '妹纸最多的话题', null, '2019-12-19 17:51:47');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `username` varchar(30) NOT NULL COMMENT '登录名（手机号）',
  `password` varchar(255) NOT NULL COMMENT '密码（加密）',
  `nickname` varchar(30) DEFAULT '' COMMENT '昵称',
  `type` int(11) NOT NULL DEFAULT '2' COMMENT '类型。1管理员2普通用户',
  `image` varchar(255) DEFAULT '' COMMENT '用户头像',
  `sex` int(11) DEFAULT '1' COMMENT '性别。1男2女',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `signature` varchar(255) DEFAULT '' COMMENT '个性签名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '664650333@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '', '2', '', '2', '2019-11-12', '个人签名', '2019-11-12 00:57:00', '2019-11-12 00:57:00');
INSERT INTO `t_user` VALUES ('2', 'admin', 'e10adc3949ba59abbe56e057f20f883e', '友趣官方账号', '1', '', '1', '2019-12-19', '（密码是123456）', '2019-12-19 15:32:09', '2019-12-19 15:32:14');
INSERT INTO `t_user` VALUES ('8', '664650322@qq.com', 'e10adc3949ba59abbe56e057f20f883e', 'Justin', '2', 'http://qiniu.ningxiaojian.top/df81e887-71bb-4dc1-b409-f60f2c93d0a3.jpeg', '1', '2020-03-18', '有个性噢。', '2020-01-17 22:15:05', '2020-04-13 11:36:55');
INSERT INTO `t_user` VALUES ('9', '88888888@qq.com', 'e10adc3949ba59abbe56e057f20f883e', '广州吴彦祖', '2', 'http://qiniu.ningxiaojian.top/54f2de3e-ca4c-4dd8-ac10-61655c6b8c21.jpeg', '1', '2020-04-09', '哎呦不错哦', '2020-04-09 21:30:56', '2020-04-12 22:42:53');

-- ----------------------------
-- Table structure for `tb_chat_record`
-- ----------------------------
DROP TABLE IF EXISTS `tb_chat_record`;
CREATE TABLE `tb_chat_record` (
  `id` varchar(255) NOT NULL COMMENT 'id',
  `userid` varchar(255) DEFAULT NULL COMMENT '用户id',
  `friendid` varchar(255) DEFAULT NULL COMMENT '好友id',
  `has_read` int(1) DEFAULT NULL COMMENT '是否已读',
  `createtime` datetime DEFAULT NULL COMMENT '聊天时间',
  `has_delete` int(1) DEFAULT NULL COMMENT '是否删除',
  `message` varchar(1024) DEFAULT NULL COMMENT '消息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_chat_record
-- ----------------------------
INSERT INTO `tb_chat_record` VALUES ('1054702253123960832', '8', '9', '1', '2018-10-23 00:00:00', '0', '测试');
INSERT INTO `tb_chat_record` VALUES ('1054704666241269760', '9', '8', '1', '2018-10-23 00:00:00', '0', '1233');
INSERT INTO `tb_chat_record` VALUES ('1054704780280201216', '9', '8', '1', '2018-10-23 00:00:00', '0', '12333');
INSERT INTO `tb_chat_record` VALUES ('1197354236866723840', '8', '2', '1', '2019-11-21 00:23:00', '0', '111');
INSERT INTO `tb_chat_record` VALUES ('1197354281921937408', '2', '8', '1', '2019-11-06 00:00:00', '0', 'dddd');
INSERT INTO `tb_chat_record` VALUES ('1197354361508855808', '8', '2', '1', '2019-11-21 00:00:00', '0', '2222');
INSERT INTO `tb_chat_record` VALUES ('1197354878813339648', '8', '2', '1', '2019-11-21 00:00:00', '0', '111');
INSERT INTO `tb_chat_record` VALUES ('1199592949382381568', '1', '1', '1', '2019-11-27 00:00:00', '0', '6666');
INSERT INTO `tb_chat_record` VALUES ('1199593029615222784', '1', '1', '1', '2019-11-27 00:00:00', '0', '77777');
INSERT INTO `tb_chat_record` VALUES ('1200054597968723968', '1', '1', '1', '2019-11-28 00:00:00', '0', '你好啊');
INSERT INTO `tb_chat_record` VALUES ('1219469431009181696', '8', '2', '1', '2020-01-21 00:00:00', '0', '嗯？');
INSERT INTO `tb_chat_record` VALUES ('1219469870266056704', '8', '2', '1', '2020-01-21 00:00:00', '0', '3333');
INSERT INTO `tb_chat_record` VALUES ('1219474155661950976', '8', '2', '1', '2020-01-21 00:00:00', '0', '测试下');
INSERT INTO `tb_chat_record` VALUES ('1219475086180876288', '8', '2', '1', '2020-01-21 00:00:00', '0', '2222');
INSERT INTO `tb_chat_record` VALUES ('1219528634604191744', '8', '2', '1', '2020-01-21 00:00:00', '0', '试试');
INSERT INTO `tb_chat_record` VALUES ('1219530897196318720', '8', '2', '1', '2020-01-21 00:00:00', '0', '0');
INSERT INTO `tb_chat_record` VALUES ('1219531774015569920', '8', '2', '1', '2020-01-21 00:00:00', '0', '1');
INSERT INTO `tb_chat_record` VALUES ('1219537549429571584', '8', '2', '1', '2020-01-21 00:00:00', '0', '辣鸡');
INSERT INTO `tb_chat_record` VALUES ('1219539084045713408', '8', '2', '1', '2020-01-21 00:00:00', '0', '3');
INSERT INTO `tb_chat_record` VALUES ('1219539106476851200', '8', '2', '1', '2020-01-21 00:13:00', '0', '33');
INSERT INTO `tb_chat_record` VALUES ('1219543532767805440', '8', '2', '1', '2020-01-21 16:53:30', '0', '44');
INSERT INTO `tb_chat_record` VALUES ('1219544033311850496', '8', '2', '1', '2020-01-21 16:55:30', '0', '55');
INSERT INTO `tb_chat_record` VALUES ('1219545030893502464', '8', '2', '1', '2020-01-21 16:59:28', '0', '66');
INSERT INTO `tb_chat_record` VALUES ('1219552663704698880', '8', '2', '1', '2020-01-21 17:29:47', '0', '77');
INSERT INTO `tb_chat_record` VALUES ('1219556021836447744', '8', '2', '1', '2020-01-21 17:43:08', '0', '88');
INSERT INTO `tb_chat_record` VALUES ('1219557242433437696', '8', '2', '1', '2020-01-21 17:47:59', '0', '99');
INSERT INTO `tb_chat_record` VALUES ('1219560481233043456', '8', '2', '1', '2020-01-21 18:00:51', '0', '1');
INSERT INTO `tb_chat_record` VALUES ('1219561181786669056', '8', '2', '1', '2020-01-21 18:03:38', '0', '2');
INSERT INTO `tb_chat_record` VALUES ('1219561423256944640', '8', '2', '1', '2020-01-21 18:04:36', '0', '3');
INSERT INTO `tb_chat_record` VALUES ('1219561822017814528', '8', '2', '1', '2020-01-21 18:06:11', '0', '4');
INSERT INTO `tb_chat_record` VALUES ('1219579268762173440', '8', '2', '1', '2020-01-21 19:15:31', '0', '5');
INSERT INTO `tb_chat_record` VALUES ('1219582019760029696', '8', '2', '1', '2020-01-21 19:26:26', '0', '6');
INSERT INTO `tb_chat_record` VALUES ('1219582021781684224', '8', '2', '1', '2020-01-21 19:26:27', '0', '6');
INSERT INTO `tb_chat_record` VALUES ('1219582609265262592', '8', '2', '1', '2020-01-21 19:28:47', '0', '7');
INSERT INTO `tb_chat_record` VALUES ('1219584322919464960', '8', '2', '1', '2020-01-21 19:35:36', '0', '8');
INSERT INTO `tb_chat_record` VALUES ('1219592260534927360', '8', '2', '1', '2020-01-21 20:07:08', '0', '9');
INSERT INTO `tb_chat_record` VALUES ('1219596018769723392', '8', '2', '1', '2020-01-21 20:22:04', '0', '10');
INSERT INTO `tb_chat_record` VALUES ('1219596035161063424', '8', '2', '1', '2020-01-21 20:22:08', '0', '10');
INSERT INTO `tb_chat_record` VALUES ('1219598699483627520', '8', '2', '1', '2020-01-21 20:32:43', '0', '11');
INSERT INTO `tb_chat_record` VALUES ('1219608455325679616', '8', '2', '1', '2020-01-21 21:11:29', '0', '12');
INSERT INTO `tb_chat_record` VALUES ('1219609102414512128', '8', '2', '1', '2020-01-21 21:14:03', '0', '13');
INSERT INTO `tb_chat_record` VALUES ('1219609346569142272', '8', '2', '1', '2020-01-21 21:15:02', '0', '14');
INSERT INTO `tb_chat_record` VALUES ('1219610272382058496', '8', '2', '1', '2020-01-21 21:18:42', '0', '15');
INSERT INTO `tb_chat_record` VALUES ('1219610923103158272', '8', '2', '1', '2020-01-21 21:21:18', '0', '16');
INSERT INTO `tb_chat_record` VALUES ('1219610946595454976', '8', '2', '1', '2020-01-21 21:21:23', '0', '16');
INSERT INTO `tb_chat_record` VALUES ('1219612948742275072', '8', '2', '1', '2020-01-21 21:29:20', '0', '17');
INSERT INTO `tb_chat_record` VALUES ('1219613525383577600', '8', '2', '1', '2020-01-21 21:31:38', '0', '18');
INSERT INTO `tb_chat_record` VALUES ('1219614596063559680', '8', '2', '1', '2020-01-21 21:35:53', '0', '19');
INSERT INTO `tb_chat_record` VALUES ('1219615038185144320', '8', '2', '1', '2020-01-21 21:37:39', '0', '20');
INSERT INTO `tb_chat_record` VALUES ('1219615846691766272', '8', '2', '1', '2020-01-21 21:40:51', '0', '21');
INSERT INTO `tb_chat_record` VALUES ('1219623921821679616', '8', '2', '1', '2020-01-21 22:12:57', '0', '22');
INSERT INTO `tb_chat_record` VALUES ('1219626563419504640', '8', '2', '1', '2020-01-21 22:23:26', '0', '23');
INSERT INTO `tb_chat_record` VALUES ('1219626594570600448', '8', '2', '1', '2020-01-21 22:23:34', '0', '23');
INSERT INTO `tb_chat_record` VALUES ('1219630696474083328', '8', '2', '1', '2020-01-21 22:39:52', '0', '24');
INSERT INTO `tb_chat_record` VALUES ('1219632634888454144', '2', '8', '1', '2020-01-21 22:47:34', '0', '25');
INSERT INTO `tb_chat_record` VALUES ('1219642305980399616', '8', '2', '0', '2020-01-21 23:26:00', '0', '26');
INSERT INTO `tb_chat_record` VALUES ('1219651690580410368', '9', '8', '1', '2020-01-22 00:03:17', '0', '?');
INSERT INTO `tb_chat_record` VALUES ('1219654973441179648', '8', '9', '1', '2020-01-22 00:16:20', '0', '嗯？');
INSERT INTO `tb_chat_record` VALUES ('1219805752638570496', '8', '2', '0', '2020-01-22 10:15:28', '0', '27');
INSERT INTO `tb_chat_record` VALUES ('1219806965186691072', '8', '9', '1', '2020-01-22 10:20:18', '0', '9');
INSERT INTO `tb_chat_record` VALUES ('1219807180199297024', '8', '9', '1', '2020-01-22 10:21:09', '0', '什么');
INSERT INTO `tb_chat_record` VALUES ('1219807478603055104', '8', '9', '1', '2020-01-22 10:22:20', '0', '试试');
INSERT INTO `tb_chat_record` VALUES ('1219807653190959104', '8', '9', '1', '2020-01-22 10:23:02', '0', '试试2');
INSERT INTO `tb_chat_record` VALUES ('1219809652452098048', '9', '8', '1', '2020-01-22 10:30:58', '0', '99');
INSERT INTO `tb_chat_record` VALUES ('1219809802327162880', '9', '8', '1', '2020-01-22 10:31:34', '0', '10');
INSERT INTO `tb_chat_record` VALUES ('1219810625169915904', '9', '8', '1', '2020-01-22 10:34:50', '0', '11');
INSERT INTO `tb_chat_record` VALUES ('1219810691435724800', '9', '8', '1', '2020-01-22 10:35:06', '0', '12');
INSERT INTO `tb_chat_record` VALUES ('1219812331144347648', '9', '8', '1', '2020-01-22 10:41:37', '0', '13');
INSERT INTO `tb_chat_record` VALUES ('1219812391970144256', '9', '8', '1', '2020-01-22 10:41:51', '0', '14');
INSERT INTO `tb_chat_record` VALUES ('1219812458047209472', '9', '8', '1', '2020-01-22 10:42:07', '0', '15');
INSERT INTO `tb_chat_record` VALUES ('1219812520848523264', '9', '8', '1', '2020-01-22 10:42:22', '0', '16');
INSERT INTO `tb_chat_record` VALUES ('1219959627584634880', '8', '9', '1', '2020-01-22 20:26:55', '0', '111');
INSERT INTO `tb_chat_record` VALUES ('1219959729296506880', '9', '8', '1', '2020-01-22 20:27:19', '0', '222');
INSERT INTO `tb_chat_record` VALUES ('1219961794991226880', '8', '9', '1', '2020-01-22 20:35:32', '0', '333');
INSERT INTO `tb_chat_record` VALUES ('1219962008569380864', '9', '8', '1', '2020-01-22 20:36:23', '0', '444');
INSERT INTO `tb_chat_record` VALUES ('1219962430986125312', '8', '9', '1', '2020-01-22 20:38:04', '0', '555');
INSERT INTO `tb_chat_record` VALUES ('1219966167687364608', '9', '8', '1', '2020-01-22 20:52:54', '0', '666');
INSERT INTO `tb_chat_record` VALUES ('1219966271165038592', '8', '9', '1', '2020-01-22 20:53:19', '0', '777');
INSERT INTO `tb_chat_record` VALUES ('1219966543929016320', '9', '8', '1', '2020-01-22 20:54:24', '0', '888');
INSERT INTO `tb_chat_record` VALUES ('1219967825246945280', '8', '9', '1', '2020-01-22 20:59:30', '0', '999');
INSERT INTO `tb_chat_record` VALUES ('1219969116656369664', '8', '9', '1', '2020-01-22 21:04:37', '0', '111');
INSERT INTO `tb_chat_record` VALUES ('1219969653489532928', '8', '9', '1', '2020-01-22 21:06:45', '0', '222');
INSERT INTO `tb_chat_record` VALUES ('1219969735286849536', '9', '8', '1', '2020-01-22 21:07:05', '0', '333');
INSERT INTO `tb_chat_record` VALUES ('1219969764730863616', '9', '8', '1', '2020-01-22 21:07:12', '0', '444');
INSERT INTO `tb_chat_record` VALUES ('1219971564582207488', '8', '9', '1', '2020-01-22 21:14:21', '0', '555');
INSERT INTO `tb_chat_record` VALUES ('1219974878145282048', '8', '9', '1', '2020-01-22 21:27:31', '0', '嗯？');
INSERT INTO `tb_chat_record` VALUES ('1219975602480611328', '8', '9', '1', '2020-01-22 21:30:24', '0', '测试');
INSERT INTO `tb_chat_record` VALUES ('1219975786044325888', '8', '9', '1', '2020-01-22 21:31:08', '0', '发送');
INSERT INTO `tb_chat_record` VALUES ('1219976033415987200', '8', '9', '1', '2020-01-22 21:32:07', '0', '1');
INSERT INTO `tb_chat_record` VALUES ('1219976051602489344', '8', '9', '1', '2020-01-22 21:32:11', '0', '1');
INSERT INTO `tb_chat_record` VALUES ('1219976494625849344', '8', '9', '1', '2020-01-22 21:33:57', '0', '2');
INSERT INTO `tb_chat_record` VALUES ('1219976503148675072', '8', '9', '1', '2020-01-22 21:33:59', '0', '2');
INSERT INTO `tb_chat_record` VALUES ('1219976889477627904', '8', '9', '1', '2020-01-22 21:35:31', '0', '3');
INSERT INTO `tb_chat_record` VALUES ('1219976894942806016', '8', '9', '1', '2020-01-22 21:35:32', '0', '3');
INSERT INTO `tb_chat_record` VALUES ('1219977854993825792', '8', '9', '1', '2020-01-22 21:39:21', '0', '4');
INSERT INTO `tb_chat_record` VALUES ('1219977959452966912', '8', '9', '1', '2020-01-22 21:39:46', '0', '6');
INSERT INTO `tb_chat_record` VALUES ('1219977964016369664', '8', '9', '1', '2020-01-22 21:39:47', '0', '6');
INSERT INTO `tb_chat_record` VALUES ('1219979231509872640', '8', '9', '1', '2020-01-22 21:44:49', '0', '7');
INSERT INTO `tb_chat_record` VALUES ('1219979740056649728', '8', '9', '1', '2020-01-22 21:46:50', '0', '8');
INSERT INTO `tb_chat_record` VALUES ('1219979964254781440', '8', '9', '1', '2020-01-22 21:47:44', '0', '9');
INSERT INTO `tb_chat_record` VALUES ('1219980016016687104', '8', '9', '1', '2020-01-22 21:47:56', '0', '10');
INSERT INTO `tb_chat_record` VALUES ('1219984889714049024', '8', '9', '1', '2020-01-22 22:07:18', '0', '11');
INSERT INTO `tb_chat_record` VALUES ('1219985707271979008', '8', '9', '1', '2020-01-22 22:10:33', '0', '12');
INSERT INTO `tb_chat_record` VALUES ('1219986339093544960', '8', '9', '1', '2020-01-22 22:13:04', '0', '13');
INSERT INTO `tb_chat_record` VALUES ('1219986363328233472', '8', '9', '1', '2020-01-22 22:13:09', '0', '14');
INSERT INTO `tb_chat_record` VALUES ('1219986391492984832', '8', '9', '1', '2020-01-22 22:13:16', '0', '15');
INSERT INTO `tb_chat_record` VALUES ('1219994031455469568', '8', '9', '1', '2020-01-22 22:43:38', '0', '16');
INSERT INTO `tb_chat_record` VALUES ('1219994660060004352', '8', '9', '1', '2020-01-22 22:46:08', '0', '17');
INSERT INTO `tb_chat_record` VALUES ('1219994703882092544', '9', '8', '1', '2020-01-22 22:46:18', '0', '18');
INSERT INTO `tb_chat_record` VALUES ('1219995824524623872', '8', '9', '1', '2020-01-22 22:50:45', '0', '19');
INSERT INTO `tb_chat_record` VALUES ('1219995859723223040', '8', '9', '1', '2020-01-22 22:50:54', '0', '20');
INSERT INTO `tb_chat_record` VALUES ('1219996018716704768', '9', '8', '1', '2020-01-22 22:51:31', '0', '21');
INSERT INTO `tb_chat_record` VALUES ('1219998293845606400', '8', '9', '1', '2020-01-22 23:00:34', '0', '22');
INSERT INTO `tb_chat_record` VALUES ('1219998660822040576', '8', '9', '1', '2020-01-22 23:02:01', '0', '23');
INSERT INTO `tb_chat_record` VALUES ('1219998699933925376', '8', '9', '1', '2020-01-22 23:02:11', '0', '24');
INSERT INTO `tb_chat_record` VALUES ('1219999219243286528', '8', '9', '1', '2020-01-22 23:04:15', '0', '25');
INSERT INTO `tb_chat_record` VALUES ('1219999246162329600', '8', '9', '1', '2020-01-22 23:04:21', '0', '26');
INSERT INTO `tb_chat_record` VALUES ('1220001241875087360', '8', '9', '1', '2020-01-22 23:12:17', '0', '27');
INSERT INTO `tb_chat_record` VALUES ('1220001265241554944', '8', '9', '1', '2020-01-22 23:12:22', '0', '28');
INSERT INTO `tb_chat_record` VALUES ('1220001471848775680', '8', '1', '0', '2020-01-22 23:13:12', '0', '测试下');
INSERT INTO `tb_chat_record` VALUES ('1220007149472579584', '8', '9', '1', '2020-01-22 23:35:45', '0', '29');
INSERT INTO `tb_chat_record` VALUES ('1220007414745530368', '8', '9', '1', '2020-01-22 23:36:48', '0', '30');
INSERT INTO `tb_chat_record` VALUES ('1220007431703101440', '8', '9', '1', '2020-01-22 23:36:53', '0', '31');
INSERT INTO `tb_chat_record` VALUES ('1220008241044389888', '8', '9', '1', '2020-01-22 23:40:05', '0', '32');
INSERT INTO `tb_chat_record` VALUES ('1220008512172589056', '8', '9', '1', '2020-01-22 23:41:10', '0', '33');
INSERT INTO `tb_chat_record` VALUES ('1220008760555077632', '8', '9', '1', '2020-01-22 23:42:09', '0', '34');
INSERT INTO `tb_chat_record` VALUES ('1220009537755414528', '8', '9', '1', '2020-01-22 23:45:15', '0', '35');
INSERT INTO `tb_chat_record` VALUES ('1220010196487634944', '8', '9', '1', '2020-01-22 23:47:52', '0', '36');
INSERT INTO `tb_chat_record` VALUES ('1220010365065101312', '8', '9', '1', '2020-01-22 23:48:32', '0', '37');
INSERT INTO `tb_chat_record` VALUES ('1220010396358803456', '8', '9', '1', '2020-01-22 23:48:39', '0', '38');
INSERT INTO `tb_chat_record` VALUES ('1220011594130391040', '8', '9', '1', '2020-01-22 23:53:25', '0', '39');
INSERT INTO `tb_chat_record` VALUES ('1220011780508483584', '8', '9', '1', '2020-01-22 23:54:09', '0', '40');
INSERT INTO `tb_chat_record` VALUES ('1220012600146788352', '8', '9', '1', '2020-01-22 23:57:25', '0', '41');
INSERT INTO `tb_chat_record` VALUES ('1220013429956280320', '8', '9', '1', '2020-01-23 00:00:43', '0', '42');
INSERT INTO `tb_chat_record` VALUES ('1220013444342743040', '8', '9', '1', '2020-01-23 00:00:46', '0', '43');
INSERT INTO `tb_chat_record` VALUES ('1220013463225499648', '8', '9', '1', '2020-01-23 00:00:51', '0', '44');
INSERT INTO `tb_chat_record` VALUES ('1220016668902686720', '9', '8', '1', '2020-01-23 00:13:35', '0', '45');
INSERT INTO `tb_chat_record` VALUES ('1220016731628503040', '9', '8', '1', '2020-01-23 00:13:50', '0', '46');
INSERT INTO `tb_chat_record` VALUES ('1220018733645299712', '9', '8', '1', '2020-01-23 00:21:47', '0', '47');
INSERT INTO `tb_chat_record` VALUES ('1220018768646766592', '9', '8', '1', '2020-01-23 00:21:55', '0', '48');
INSERT INTO `tb_chat_record` VALUES ('1220148332349882368', '8', '9', '1', '2020-01-23 08:56:46', '0', '49');
INSERT INTO `tb_chat_record` VALUES ('1220148384980008960', '8', '9', '1', '2020-01-23 08:56:58', '0', '50');
INSERT INTO `tb_chat_record` VALUES ('1220148385407827968', '8', '9', '1', '2020-01-23 08:56:58', '0', '50');
INSERT INTO `tb_chat_record` VALUES ('1220148410137444352', '8', '9', '1', '2020-01-23 08:57:04', '0', '51');
INSERT INTO `tb_chat_record` VALUES ('1220148594481299456', '8', '9', '1', '2020-01-23 08:57:48', '0', '52');
INSERT INTO `tb_chat_record` VALUES ('1220149783696506880', '8', '9', '1', '2020-01-23 09:02:32', '0', '53');
INSERT INTO `tb_chat_record` VALUES ('1220149831666761728', '8', '9', '1', '2020-01-23 09:02:43', '0', '54');
INSERT INTO `tb_chat_record` VALUES ('1220149861022695424', '9', '8', '1', '2020-01-23 09:02:50', '0', '55');
INSERT INTO `tb_chat_record` VALUES ('1220149956497637376', '9', '8', '1', '2020-01-23 09:03:13', '0', '56');
INSERT INTO `tb_chat_record` VALUES ('1220150027976966144', '9', '8', '1', '2020-01-23 09:03:30', '0', '57');
INSERT INTO `tb_chat_record` VALUES ('1220150192439820288', '9', '8', '1', '2020-01-23 09:04:09', '0', '58');
INSERT INTO `tb_chat_record` VALUES ('1220150220537462784', '8', '9', '1', '2020-01-23 09:04:16', '0', '59');
INSERT INTO `tb_chat_record` VALUES ('1220151061910650880', '9', '8', '1', '2020-01-23 09:07:37', '0', '60');
INSERT INTO `tb_chat_record` VALUES ('1220151088418652160', '8', '9', '1', '2020-01-23 09:07:43', '0', '61');
INSERT INTO `tb_chat_record` VALUES ('1220155362678669312', '9', '8', '1', '2020-01-23 09:24:42', '0', '62');
INSERT INTO `tb_chat_record` VALUES ('1220155584901283840', '8', '9', '1', '2020-01-23 09:25:35', '0', '63');
INSERT INTO `tb_chat_record` VALUES ('1220192621687734272', '8', '9', '1', '2020-01-23 11:52:46', '0', '64');
INSERT INTO `tb_chat_record` VALUES ('1220226235322335232', '8', '9', '1', '2020-01-23 14:06:20', '0', '[img=http://qiniu.ningxiaojian.top/6c01bb8e-10c6-4834-8ce2-d9151e2f2dfb.jpg]');
INSERT INTO `tb_chat_record` VALUES ('1220226343518601216', '8', '9', '1', '2020-01-23 14:06:46', '0', '[img=http://qiniu.ningxiaojian.top/5615e0f4-dcce-4bad-b18c-93e5f4c751be.jpeg]');
INSERT INTO `tb_chat_record` VALUES ('1220313323552112640', '8', '9', '1', '2020-01-23 19:52:23', '0', '[video=http://qiniu.ningxiaojian.top/72fda783-ad87-4f87-b0da-43d67dee5fc2.mp4]');
INSERT INTO `tb_chat_record` VALUES ('1220313701190467584', '8', '9', '1', '2020-01-23 19:53:53', '0', 'Ttt');
INSERT INTO `tb_chat_record` VALUES ('1220315367390314496', '8', '9', '1', '2020-01-23 20:00:31', '0', '[img=http://qiniu.ningxiaojian.top/8f213e0e-a92b-4ffd-a5c3-481fe97c5a5e.jpg]');
INSERT INTO `tb_chat_record` VALUES ('1220315647863422976', '8', '9', '1', '2020-01-23 20:01:37', '0', '[video=http://qiniu.ningxiaojian.top/41ab0da4-bf33-4c09-b617-cf6fd332c520.mp4]');
INSERT INTO `tb_chat_record` VALUES ('1220317474788999168', '8', '9', '1', '2020-01-23 20:08:53', '0', 'rrr');
INSERT INTO `tb_chat_record` VALUES ('1220317496326750208', '8', '9', '1', '2020-01-23 20:08:58', '0', '1');
INSERT INTO `tb_chat_record` VALUES ('1220317508800610304', '8', '9', '1', '2020-01-23 20:09:01', '0', '2');
INSERT INTO `tb_chat_record` VALUES ('1220317546452877312', '8', '9', '1', '2020-01-23 20:09:10', '0', '3');
INSERT INTO `tb_chat_record` VALUES ('1220317556162691072', '8', '9', '1', '2020-01-23 20:09:12', '0', '4');
INSERT INTO `tb_chat_record` VALUES ('1220317570851143680', '8', '9', '1', '2020-01-23 20:09:16', '0', '5');
INSERT INTO `tb_chat_record` VALUES ('1220318682073268224', '8', '9', '1', '2020-01-23 20:13:41', '0', '\\emo15 ');
INSERT INTO `tb_chat_record` VALUES ('1220321769924067328', '8', '9', '1', '2020-01-23 20:25:57', '0', '[audio=http://qiniu.ningxiaojian.top/4bcd8377-0171-4c5b-b32d-ee7845d52a18.mp3]');
INSERT INTO `tb_chat_record` VALUES ('1220322135445078016', '8', '9', '1', '2020-01-23 20:27:24', '0', '[audio=http://qiniu.ningxiaojian.top/1f166a59-0b64-4f90-9f84-6a9e24a31cb4.mp3]');
INSERT INTO `tb_chat_record` VALUES ('1220333150912118784', '9', '8', '1', '2020-01-23 21:11:11', '0', '干嘛给我发语音');
INSERT INTO `tb_chat_record` VALUES ('1220333616840572928', '9', '8', '1', '2020-01-23 21:13:02', '0', '嗯？');
INSERT INTO `tb_chat_record` VALUES ('1220333766174572544', '8', '9', '1', '2020-01-23 21:13:37', '0', '[img=http://qiniu.ningxiaojian.top/8c756d0f-cfcb-4edf-a1f2-3d434b446dba.jpg]');
INSERT INTO `tb_chat_record` VALUES ('1220337926857031680', '8', '9', '1', '2020-01-23 21:30:09', '0', '[img=http://qiniu.ningxiaojian.top/f35ecaa2-3a8b-4fa1-84e7-3d481e538034.jpeg]');
INSERT INTO `tb_chat_record` VALUES ('1220338237545906176', '8', '9', '1', '2020-01-23 21:31:23', '0', '[img=http://qiniu.ningxiaojian.top/71b19995-945f-4976-8b4e-12ca81785735.jpg]');
INSERT INTO `tb_chat_record` VALUES ('1245562379006115840', '8', '1', '0', '2020-04-02 12:03:07', '0', '哈喽');
INSERT INTO `tb_chat_record` VALUES ('1249534661709791232', '8', '9', '1', '2020-04-13 11:07:33', '0', '你好啊吴彦祖');
INSERT INTO `tb_chat_record` VALUES ('1249537396052066304', '8', '9', '1', '2020-04-13 11:18:25', '0', '你好啊吴彦祖');
INSERT INTO `tb_chat_record` VALUES ('1249537642039607296', '9', '8', '1', '2020-04-13 11:19:24', '0', 'hi');
INSERT INTO `tb_chat_record` VALUES ('1249541865640820736', '8', '9', '1', '2020-04-13 11:36:11', '0', '你好啊吴彦祖');
INSERT INTO `tb_chat_record` VALUES ('1249541923354443776', '9', '8', '0', '2020-04-13 11:36:25', '0', '你好啊');
