

<sql>
CREATE TABLE `users` (
`user_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
`pass_word` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
`user_sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
`id` int(10) unsigned NOT NULL AUTO_INCREMENT,
`nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
</sql>