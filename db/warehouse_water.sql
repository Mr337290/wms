DROP TABLE IF EXISTS `warehouse_water`;
create table warehouse_water(
  `id` INT(20) NOT NULL AUTO_INCREMENT,
  `warehouse_id` INT(20) NULL DEFAULT NULL COMMENT '库存ID',
   `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
   `status` int(10) NULL DEFAULT NULL COMMENT '操作类型',
   `operator` VARCHAR(50) NULL DEFAULT NULL COMMENT '操作人',
   `operand` VARCHAR(50) NULL DEFAULT NULL COMMENT '操作对象',
   
   `create_time` TIMESTAMP null DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
	PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;