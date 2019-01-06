create table sell_details(
`id` INT(20) NOT NULL AUTO_INCREMENT,
 `sell_time` TIMESTAMP null  COMMENT '出售时间',
 `sn` VARCHAR(20) NULL DEFAULT NULL COMMENT '产品代码',
   `batch_number` VARCHAR(20) NULL DEFAULT NULL COMMENT '批次号',
   `quantity` int(10) NULL DEFAULT NULL COMMENT '数量',
   `price` Float(10,2) NULL DEFAULT NULL COMMENT '单价',
   `currency` VARCHAR(50) NULL DEFAULT NULL COMMENT '币种',
   `shop_code` VARCHAR(20) NULL DEFAULT NULL COMMENT '网点代码',
   `create_time` TIMESTAMP null DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
   PRIMARY KEY (`id`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;