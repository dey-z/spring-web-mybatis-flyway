SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE `M_PJ_Hoge`;
SET FOREIGN_KEY_CHECKS = 1;
INSERT INTO `M_PJ_Hoge` (`hoge_cls_id`, `hoge_phase`, `hoge_prefix`, `created_at`, `updated_at`)
VALUES ('1', 'ph7', 'test01test02', now(), now());
