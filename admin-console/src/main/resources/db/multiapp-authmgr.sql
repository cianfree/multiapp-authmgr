
-- 接入的应用信息
CREATE TABLE IF NOT EXISTS `app` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  `app_id` int(11) NOT NULL COMMENT 'appId 唯一标识，由接入的时候指定',
  `name` varchar(255) NOT NULL COMMENT '应用名称',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态，是否启用，1-启用，0-禁用',
  `contact_names` varchar(255) DEFAULT NULL COMMENT '联系人姓名列表',
  `contact_mobiles` varchar(255) DEFAULT NULL COMMENT '联系人电话列表',
  `contact_emails` varchar(255) DEFAULT NULL COMMENT '联系人邮件列表',
  `contact_qqs` varchar(255) DEFAULT NULL COMMENT '联系人QQ列表',
  `contact_weixins` varchar(255) DEFAULT NULL COMMENT '联系人微信列表',
  `address` varchar(255) DEFAULT NULL COMMENT '应用访问地址入口',
  `weixin` varchar(255) DEFAULT NULL COMMENT '微信号',
  `remark` longtext COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend` longtext COMMENT '扩展信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_role_appid` (`app_id`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 用户信息
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  `app_id` int(11) NOT NULL COMMENT '所属APPID，和account构成唯一索引约束',
  `account` varchar(100) NOT NULL COMMENT '账号，和appId构成唯一索引约束',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态，是否启用，1-启用，0-禁用',
  `name` varchar(255) NOT NULL COMMENT '姓名',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件地址',
  `mobile` varchar(255) DEFAULT NULL COMMENT '手机号码',
  `qq` varchar(255) DEFAULT NULL COMMENT 'QQ号码',
  `weixin` varchar(255) DEFAULT NULL COMMENT '微信号',
  `remark` longtext COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend` longtext COMMENT '扩展信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_user_appid_account` (`app_id`,`account`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 角色信息
CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  `app_id` int(11) NOT NULL COMMENT '所属APPID，和code构成唯一键',
  `code` varchar(50) NOT NULL COMMENT '和 appId 构成唯一键',
  `name` varchar(255) NOT NULL COMMENT '应用名称',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态，是否启用，1-启用，0-禁用',
  `remark` longtext COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend` longtext COMMENT '扩展信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_appid_code` (`app_id`,`code`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 权限信息
CREATE TABLE IF NOT EXISTS `privilege` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  `app_id` int(11) NOT NULL COMMENT '所属APPID，和code构成唯一键',
  `code` varchar(50) NOT NULL COMMENT '权限代码，',
  `code_path` varchar(50) NOT NULL COMMENT '权限代码，和 appId 构成唯一键',
  `parent_code` varchar(50) NOT NULL COMMENT '上级权限代码',
  `show_menu` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否展示为菜单',
  `enabled` tinyint(1) NOT NULL DEFAULT 1 COMMENT '用户状态，是否启用，1-启用，0-禁用',
  `name` varchar(255) NOT NULL COMMENT '权限名称',
  `name_path` varchar(255) NOT NULL COMMENT '权限名称路径，包含上级名称，如: 用户管理/用户查询',
  `resources` text NOT NULL COMMENT '资源列表，如一个或多个 url，中间用英文逗号分隔',
  `remark` longtext COMMENT '备注信息',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `extend` longtext COMMENT '扩展信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_priv_appid_code` (`app_id`,`code`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 用户角色信息
CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  `app_id` int(11) NOT NULL COMMENT '所属APPID，和code构成唯一键',
  `user_account` varchar(100) NOT NULL COMMENT '用户账号',
  `role_code` varchar(50) NOT NULL COMMENT '角色代码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `extend` longtext COMMENT '扩展信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_ur_appid_acc_code` (`app_id`,`user_account`,`role_code`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 角色权限信息
CREATE TABLE IF NOT EXISTS `role_privilege` (
  `id` bigint(20) AUTO_INCREMENT NOT NULL COMMENT '自增主键ID',
  `app_id` int(11) NOT NULL COMMENT '所属APPID，和role_code,privilege_code构成唯一键',
  `role_code` varchar(50) NOT NULL COMMENT '角色代码',
  `privilege_code` varchar(50) NOT NULL COMMENT '权限代码',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `extend` longtext COMMENT '扩展信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_rp_appid_rc_pc` (`app_id`,`role_code`,`privilege_code`) USING BTREE COMMENT '唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

