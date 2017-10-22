CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_num` varchar(31) NOT NULL,
  `name` varchar(31) NOT NULL,
  `age` int(11) NOT NULL,
  `interest` varchar(255) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_student_num` (`student_num`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
