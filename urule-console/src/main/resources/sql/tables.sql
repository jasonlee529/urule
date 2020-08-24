 CREATE TABLE `urule_xml` (
	`id` BIGINT ( 20 ) NOT NULL AUTO_INCREMENT COMMENT'id',
	`name` VARCHAR ( 200 ) NULL COMMENT '文件名称',
	`type` VARCHAR ( 64 ) NULL COMMENT '文件类型',
	`content` LONGTEXT NULL COMMENT '文件内容',
	`gmt_created` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`gmt_modifiled` datetime NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '修改时间',
PRIMARY KEY ( `id` ) 
);