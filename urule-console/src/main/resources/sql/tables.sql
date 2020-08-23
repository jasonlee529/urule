CREATE TABLE `NewTable` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT ,
`name`  varchar(200) NULL DEFAULT 文件名称 ,
`type`  varchar(64) NULL DEFAULT 文件类型 ,
`content`  longtext NULL COMMENT '文件内容' ,
`gmt_created`  datetime NULL DEFAULT current_timestamp ,
`gmt_modifiled`  datetime NULL DEFAULT current_timestamp ,
PRIMARY KEY (`id`)
)
;

