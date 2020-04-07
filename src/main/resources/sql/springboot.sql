

-- createdBy: devils
-- createDate: 2018年12月8日
-- build database springboot shell

echo 'shell starting';
drop database if exists springboot;
create database springboot;
-- change to springboot
use springboot;

echo 'database springboot has build success, starting build tables';
create table sys_user(
  id BIGINT PRIMARY KEY  AUTO_INCREMENT COMMENT '',
  name varchar(40) COMMENT '用户名',
  password VARCHAR(40) COMMENT '密码（MD5 大写）',
  email VARCHAR(20) COMMENT '邮箱',
  telephone VARCHAR(20) COMMENT '电话',
  wx_union_id VARCHAR(60) COMMENT '微信unionID',
  qq_number VARCHAR(60) COMMENT 'qq账号',
  alipay_account VARCHAR(60) COMMENT '支付宝账号',
  create_date VARCHAR(20) COMMENT '创建日期',
  last_login VARCHAR(20) COMMENT '最后登录',
  status INT(2) COMMENT '账号状态，0正常；1封存'
);

create table sys_permission(
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '权限ID',
  user_id BIGINT COMMENT '用户ID',
  permission VARCHAR(20) COMMENT '权限',
  create_date VARCHAR(20) COMMENT '添加时间'
);

create table sys_role (
  id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '角色ID',
  user_id BIGINT COMMENT '用户ID',
  role VARCHAR(20) COMMENT '角色',
  create_date VARCHAR(20) COMMENT '创建时间'
);