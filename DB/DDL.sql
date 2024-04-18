DROP TABLE IF EXISTS `bookmark`;
CREATE TABLE `bookmark` (
  `bookmark_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '북마크 ID',
  `post_id` int(11) NOT NULL COMMENT '게시물 ID',
  `member_id` varchar(20) NOT NULL COMMENT '회원 ID',
  PRIMARY KEY (`bookmark_id`),
  KEY `bookmark_member_FK` (`member_id`),
  KEY `bookmark_post_FK` (`post_id`),
  CONSTRAINT `bookmark_member_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `bookmark_post_FK` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='북마크';

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL,
  `category_name` varchar(50) NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='카테고리';

DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '댓글 ID',
  `content` longtext NOT NULL COMMENT '내용',
  `posted_date` varchar(30) NOT NULL DEFAULT current_timestamp() COMMENT '작성날짜',
  `last_modified_date` varchar(30) NOT NULL DEFAULT current_timestamp() COMMENT '마지막 수정날짜',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '삭제여부',
  `post_id` int(11) NOT NULL COMMENT '게시글 ID',
  `member_id` varchar(20) NOT NULL COMMENT '회원 ID',
  PRIMARY KEY (`comment_id`),
  KEY `comment_member_FK` (`member_id`),
  KEY `comment_post_FK` (`post_id`),
  CONSTRAINT `comment_member_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `comment_post_FK` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='댓글';

DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `follow_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '팔로우 ID',
  `from_member_id` varchar(20) NOT NULL COMMENT '팔로우하는 회원 ID',
  `to_member_id` varchar(20) NOT NULL COMMENT '팔로우받는 회원 ID',
  PRIMARY KEY (`follow_id`)
) ENGINE=InnoDB AUTO_INCREMENT=129 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='팔로우';

DROP TABLE IF EXISTS `hotpost`;
CREATE TABLE `hotpost` (
  `hotpost_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '추천글 ID',
  `is_active` tinyint(4) DEFAULT NULL COMMENT '활성화 여부',
  `category_id` int(11) DEFAULT NULL COMMENT '카테고리 ID',
  `post_id` int(11) DEFAULT NULL COMMENT '게시글 ID',
  PRIMARY KEY (`hotpost_id`),
  KEY `hotpost_category_FK` (`category_id`),
  KEY `hotpost_post_FK` (`post_id`),
  CONSTRAINT `hotpost_category_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `hotpost_post_FK` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=765 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='추천글';

DROP TABLE IF EXISTS `language`;
CREATE TABLE `language` (
  `language` varchar(30) NOT NULL COMMENT '언어',
  PRIMARY KEY (`language`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='언어';

DROP TABLE IF EXISTS `letter`;
CREATE TABLE `letter` (
  `letter_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '쪽지 ID',
  `message` longtext NOT NULL COMMENT '내용',
  `event_time` varchar(30) NOT NULL DEFAULT 'current_timestamp()' COMMENT '발송 시각',
  `is_checked` tinyint(1) NOT NULL DEFAULT 0 COMMENT '수신 여부',
  `send_id` varchar(20) NOT NULL COMMENT '송신자 ID',
  `receive_id` varchar(20) NOT NULL COMMENT '수신자 ID',
  PRIMARY KEY (`letter_id`),
  KEY `letter_member_FK` (`send_id`),
  KEY `letter_member_FK_1` (`receive_id`),
  CONSTRAINT `letter_member_FK` FOREIGN KEY (`send_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `letter_member_FK_1` FOREIGN KEY (`receive_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='쪽지';

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `location` varchar(50) NOT NULL,
  PRIMARY KEY (`location_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='지역';

DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `member_id` varchar(20) NOT NULL COMMENT '회원 ID',
  `nickname` varchar(20) NOT NULL COMMENT '닉네임',
  `password` varchar(255) NOT NULL COMMENT '비밀번호',
  `email` varchar(40) DEFAULT NULL COMMENT '이메일',
  `sign_up_date` varchar(30) NOT NULL DEFAULT 'current_timestamp()' COMMENT '가입일',
  `is_withdraw` tinyint(1) NOT NULL COMMENT '탈퇴여부',
  `profile` longtext DEFAULT NULL COMMENT '자기소개',
  `nationality_id` varchar(10) NOT NULL COMMENT '국적 코드',
  `image` longtext DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `member_nationality_FK` (`nationality_id`) USING BTREE,
  CONSTRAINT `member_nationality_FK` FOREIGN KEY (`nationality_id`) REFERENCES `nationality` (`nationality_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='회원';

DROP TABLE IF EXISTS `nationality`;
CREATE TABLE `nationality` (
  `nationality_id` varchar(10) NOT NULL COMMENT '국적 코드',
  `language` varchar(30) NOT NULL COMMENT '언어',
  `country` varchar(100) NOT NULL COMMENT '국가',
  PRIMARY KEY (`nationality_id`),
  KEY `nationality_language_FK` (`language`),
  CONSTRAINT `nationality_language_FK` FOREIGN KEY (`language`) REFERENCES `language` (`language`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='국적';

DROP TABLE IF EXISTS `notification`;
CREATE TABLE `notification` (
  `notification_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '알림 ID',
  `message` longtext NOT NULL COMMENT '내용',
  `event_time` varchar(30) NOT NULL DEFAULT 'current_timestamp()' COMMENT '발생 시각',
  `member_id` varchar(20) NOT NULL COMMENT '회원 ID',
  `is_checked` tinyint(1) NOT NULL,
  `type` varchar(50) DEFAULT NULL,
  `url` longtext DEFAULT NULL,
  PRIMARY KEY (`notification_id`),
  KEY `notification_member_FK` (`member_id`),
  CONSTRAINT `notification_member_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='알림';

DROP TABLE IF EXISTS `post`;
CREATE TABLE `post` (
  `post_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `content` longtext NOT NULL,
  `posted_date` varchar(30) NOT NULL DEFAULT current_timestamp(),
  `hits` int(11) NOT NULL DEFAULT 0,
  `last_modified_date` varchar(30) NOT NULL DEFAULT current_timestamp(),
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  `category_id` int(11) NOT NULL,
  `member_id` varchar(20) NOT NULL,
  `image` longtext DEFAULT NULL,
  `language` varchar(30) NOT NULL,
  `location_id` int(11) NOT NULL,
  PRIMARY KEY (`post_id`),
  KEY `post_category_FK` (`category_id`),
  KEY `post_location_FK` (`location_id`),
  KEY `post_member_FK` (`member_id`),
  KEY `post_language_FK` (`language`),
  CONSTRAINT `post_category_FK` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  CONSTRAINT `post_language_FK` FOREIGN KEY (`language`) REFERENCES `language` (`language`),
  CONSTRAINT `post_location_FK` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`),
  CONSTRAINT `post_member_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='게시물';

DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `reply_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '대댓글 ID',
  `content` longtext NOT NULL COMMENT '내용',
  `posted_date` varchar(30) NOT NULL DEFAULT current_timestamp() COMMENT '작성날짜',
  `last_modified_date` varchar(30) NOT NULL DEFAULT current_timestamp() COMMENT '마지막 수정날짜',
  `is_deleted` tinyint(1) NOT NULL COMMENT '삭제여부',
  `comment_id` int(11) NOT NULL COMMENT '댓글 ID',
  `member_id` varchar(20) NOT NULL COMMENT '회원 ID',
  PRIMARY KEY (`reply_id`),
  KEY `reply_member_FK` (`member_id`),
  KEY `reply_comment_FK` (`comment_id`),
  CONSTRAINT `reply_comment_FK` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`comment_id`),
  CONSTRAINT `reply_member_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='대댓글';

DROP TABLE IF EXISTS `star`;
CREATE TABLE `star` (
  `star_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '좋아요',
  `status` tinyint(1) NOT NULL COMMENT '구분',
  `post_id` int(11) NOT NULL COMMENT '게시글 ID',
  `member_id` varchar(20) NOT NULL COMMENT '회원 ID',
  PRIMARY KEY (`star_id`),
  KEY `star_member_FK` (`member_id`),
  KEY `star_post_FK` (`post_id`),
  CONSTRAINT `star_member_FK` FOREIGN KEY (`member_id`) REFERENCES `member` (`member_id`),
  CONSTRAINT `star_post_FK` FOREIGN KEY (`post_id`) REFERENCES `post` (`post_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='좋아요';

DROP TABLE IF EXISTS `translation`;
CREATE TABLE `translation` (
  `translation_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '번역 ID',
  `post_id` int(11) NOT NULL COMMENT '게시글 ID',
  `content` longtext NOT NULL COMMENT '내용',
  `title` varchar(255) DEFAULT NULL COMMENT '제목',
  `language` varchar(30) NOT NULL COMMENT '언어',
  PRIMARY KEY (`translation_id`),
  KEY `translation_post_FK` (`post_id`),
  KEY `translation_language_FK` (`language`),
  CONSTRAINT `translation_language_FK` FOREIGN KEY (`language`) REFERENCES `language` (`language`)
) ENGINE=InnoDB AUTO_INCREMENT=682 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='번역';
