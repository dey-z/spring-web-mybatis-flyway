CREATE TABLE `M_PJ_Hoge`
(
    `hoge_cls_id` varchar(255) NOT NULL,
    `hoge_phase`  varchar(255) DEFAULT NULL,
    `hoge_prefix` varchar(255) DEFAULT NULL,
    `created_at`  datetime     DEFAULT NULL,
    `updated_at`  datetime     DEFAULT NULL,
    PRIMARY KEY (`hoge_cls_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;
