CREATE TABLE `T_PJ_List` (
                             `project_id` varchar(255) NOT NULL,
                             `project_name` varchar(255) DEFAULT NULL,
                             `region` varchar(255) DEFAULT NULL,
                             `created_at` datetime DEFAULT NULL,
                             `updated_at` datetime DEFAULT NULL,
                             PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;