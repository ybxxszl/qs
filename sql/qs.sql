/*
Navicat MySQL Data Transfer

Source Server         : aliyun
Source Server Version : 50709
Source Host           : 127.0.0.1:3306
Source Database       : qs

Target Server Type    : MYSQL
Target Server Version : 50709
File Encoding         : 65001

Date: 2018-11-07 20:27:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `author_id` varchar(255) NOT NULL,
  `author_account` varchar(255) DEFAULT NULL,
  `author_password` varchar(255) DEFAULT NULL,
  `author_name` varchar(255) DEFAULT NULL,
  `author_sex` varchar(255) DEFAULT NULL,
  `author_birthday` date DEFAULT NULL,
  `author_phone` varchar(255) DEFAULT NULL,
  `author_email` varchar(255) DEFAULT NULL,
  `author_photo` varchar(255) DEFAULT NULL,
  `author_state` int(255) DEFAULT NULL,
  `open_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of author
-- ----------------------------
INSERT INTO `author` VALUES ('c5337055-7ae7-4227-b4f7-d65e94b45575', 'test', '0000', '王军岩', '男', '1950-01-01', '18743102774', '1062837400@qq.com', 'logo.jpg', '1', 'oQLFG46moWC10Z-EqMxWGp6lWdGc - test');

-- ----------------------------
-- Table structure for checkbox_answer_count
-- ----------------------------
DROP TABLE IF EXISTS `checkbox_answer_count`;
CREATE TABLE `checkbox_answer_count` (
  `checkbox_answer_count_id` varchar(255) NOT NULL,
  `checkbox_answer_count` int(255) DEFAULT NULL,
  `design_checkbox_option_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`checkbox_answer_count_id`),
  KEY `foreign key_design_checkbox_option_id` (`design_checkbox_option_id`),
  CONSTRAINT `foreign key_design_checkbox_option_id` FOREIGN KEY (`design_checkbox_option_id`) REFERENCES `design_checkbox_option` (`design_checkbox_option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of checkbox_answer_count
-- ----------------------------

-- ----------------------------
-- Table structure for design_checkbox
-- ----------------------------
DROP TABLE IF EXISTS `design_checkbox`;
CREATE TABLE `design_checkbox` (
  `design_checkbox_id` varchar(255) NOT NULL,
  `design_checkbox_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_checkbox_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_checkbox
-- ----------------------------
INSERT INTO `design_checkbox` VALUES ('1dd6ca21-4477-44ac-8baa-99c36204bfeb', '您最喜欢XX公众号的哪个功能？');
INSERT INTO `design_checkbox` VALUES ('1e21ef8e-72f0-445e-bfa2-e7d50c72d31a', '测试多选题');
INSERT INTO `design_checkbox` VALUES ('dd493e0b-a692-4703-a704-0961785ee3e0', '您最喜欢XX公众号哪些方面的消息推送？');

-- ----------------------------
-- Table structure for design_checkbox_option
-- ----------------------------
DROP TABLE IF EXISTS `design_checkbox_option`;
CREATE TABLE `design_checkbox_option` (
  `design_checkbox_option_id` varchar(255) NOT NULL,
  `design_checkbox_id` varchar(255) DEFAULT NULL,
  `design_checkbox_order` int(255) DEFAULT NULL,
  `design_checkbox_option_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_checkbox_option_id`),
  KEY `foreign key_design_checkbox_id` (`design_checkbox_id`),
  CONSTRAINT `foreign key_design_checkbox_id` FOREIGN KEY (`design_checkbox_id`) REFERENCES `design_checkbox` (`design_checkbox_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_checkbox_option
-- ----------------------------
INSERT INTO `design_checkbox_option` VALUES ('2ccbb77a-e271-41ae-a083-8316efc0b1cd', '1e21ef8e-72f0-445e-bfa2-e7d50c72d31a', '2', '2');
INSERT INTO `design_checkbox_option` VALUES ('2d171281-a7db-45fd-82f2-a8a71e3f2c1b', '1dd6ca21-4477-44ac-8baa-99c36204bfeb', '1', '查成绩');
INSERT INTO `design_checkbox_option` VALUES ('3502f400-404e-4f79-8154-fdb40681acc5', '1e21ef8e-72f0-445e-bfa2-e7d50c72d31a', '3', '3');
INSERT INTO `design_checkbox_option` VALUES ('4794ae18-e69e-41b6-90d2-8ec0be154e42', '1e21ef8e-72f0-445e-bfa2-e7d50c72d31a', '4', '4');
INSERT INTO `design_checkbox_option` VALUES ('4a763913-4993-4549-a4cb-7bf4a89c674b', 'dd493e0b-a692-4703-a704-0961785ee3e0', '3', '原创文章');
INSERT INTO `design_checkbox_option` VALUES ('579dba5b-f344-428f-9dec-b1c07feac058', '1e21ef8e-72f0-445e-bfa2-e7d50c72d31a', '1', '1');
INSERT INTO `design_checkbox_option` VALUES ('a3eb221e-e6fd-42cc-8ca2-1b5c7d941b31', 'dd493e0b-a692-4703-a704-0961785ee3e0', '1', '学校通知');
INSERT INTO `design_checkbox_option` VALUES ('b534362d-ba42-4bfe-9746-b4138d39825b', '1dd6ca21-4477-44ac-8baa-99c36204bfeb', '2', '校花校草');
INSERT INTO `design_checkbox_option` VALUES ('c0e50dfe-ea07-429d-bbdc-1e7fb6eb82ad', '1dd6ca21-4477-44ac-8baa-99c36204bfeb', '4', '校园街景');
INSERT INTO `design_checkbox_option` VALUES ('e4e9fec5-53c5-4646-9b40-832cab366113', '1dd6ca21-4477-44ac-8baa-99c36204bfeb', '3', '表白墙');
INSERT INTO `design_checkbox_option` VALUES ('fae0e4d5-e24f-4eae-ac92-38e7cf06d06d', 'dd493e0b-a692-4703-a704-0961785ee3e0', '2', '社团活动');

-- ----------------------------
-- Table structure for design_single
-- ----------------------------
DROP TABLE IF EXISTS `design_single`;
CREATE TABLE `design_single` (
  `design_single_id` varchar(255) NOT NULL,
  `design_single_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_single_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_single
-- ----------------------------
INSERT INTO `design_single` VALUES ('1a2cd3a6-a4fc-4798-86b3-01787cd2f767', '薛中然公众号粉丝调查');
INSERT INTO `design_single` VALUES ('2ed4ac51-3afc-48d4-b196-6425282fe225', '测试单选题');
INSERT INTO `design_single` VALUES ('4d1e0233-b57e-44ab-bbe4-13fadc0fbe20', '您关注了多少个公众号？');
INSERT INTO `design_single` VALUES ('7d3df5a3-6d27-4719-803f-d8024ae2de52', '您觉得XX公众号推送频率多少可以接受？');
INSERT INTO `design_single` VALUES ('a57085e5-7d7a-41d9-a664-4c797441d773', '您最喜欢什么形式的消息推送？');
INSERT INTO `design_single` VALUES ('f4eb0114-ebb4-4687-97e3-29474c6d74ae', '您一般在什么时间查看我们的推送内容？');

-- ----------------------------
-- Table structure for design_single_option
-- ----------------------------
DROP TABLE IF EXISTS `design_single_option`;
CREATE TABLE `design_single_option` (
  `design_single_option_id` varchar(255) NOT NULL,
  `design_single_id` varchar(255) DEFAULT NULL,
  `design_single_order` int(255) DEFAULT NULL,
  `design_single_option_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_single_option_id`),
  KEY `foreign key_design_single_id` (`design_single_id`),
  CONSTRAINT `foreign key_design_single_id` FOREIGN KEY (`design_single_id`) REFERENCES `design_single` (`design_single_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_single_option
-- ----------------------------
INSERT INTO `design_single_option` VALUES ('005e08b7-b9f4-4c39-8d7c-1885877091f0', '4d1e0233-b57e-44ab-bbe4-13fadc0fbe20', '1', '10个以内');
INSERT INTO `design_single_option` VALUES ('12cf368d-eb9f-49a7-8dff-81ab771d73b1', '7d3df5a3-6d27-4719-803f-d8024ae2de52', '3', '一周两次');
INSERT INTO `design_single_option` VALUES ('1711f637-6e33-4377-880e-40b49227ba72', 'f4eb0114-ebb4-4687-97e3-29474c6d74ae', '1', '早上起床后');
INSERT INTO `design_single_option` VALUES ('2676fd6e-959c-479b-9e2d-30416abe3486', '1a2cd3a6-a4fc-4798-86b3-01787cd2f767', '2', '相关文章');
INSERT INTO `design_single_option` VALUES ('3095e403-ed26-48d4-8de5-b586c6a7aca5', '7d3df5a3-6d27-4719-803f-d8024ae2de52', '1', '每天一次');
INSERT INTO `design_single_option` VALUES ('41749b03-b7c8-47dc-a034-93c346d956bc', 'a57085e5-7d7a-41d9-a664-4c797441d773', '3', '视频消息');
INSERT INTO `design_single_option` VALUES ('43166a6a-e0ba-43d2-ace4-9bf213b9228c', '1a2cd3a6-a4fc-4798-86b3-01787cd2f767', '3', '二维码扫描');
INSERT INTO `design_single_option` VALUES ('4e0a93e2-30e2-4687-9321-8c202da21c8d', 'a57085e5-7d7a-41d9-a664-4c797441d773', '2', '图文欣赏');
INSERT INTO `design_single_option` VALUES ('5d929e1d-b039-4ee8-b14a-454c00d7e54f', 'f4eb0114-ebb4-4687-97e3-29474c6d74ae', '4', '晚上睡觉前');
INSERT INTO `design_single_option` VALUES ('68583a39-192a-473a-aac9-c968c3a58bc1', '7d3df5a3-6d27-4719-803f-d8024ae2de52', '4', '一周一次');
INSERT INTO `design_single_option` VALUES ('70c27d53-5ccf-47cf-a353-9f3e747a6488', '2ed4ac51-3afc-48d4-b196-6425282fe225', '1', '1');
INSERT INTO `design_single_option` VALUES ('75fdcce6-3bf0-41aa-9374-95e9ffb5339f', '2ed4ac51-3afc-48d4-b196-6425282fe225', '4', '4');
INSERT INTO `design_single_option` VALUES ('84752eed-3d9b-4b47-9d91-c7679f138170', '7d3df5a3-6d27-4719-803f-d8024ae2de52', '2', '两天一次');
INSERT INTO `design_single_option` VALUES ('8e0d9c53-0a1a-4c79-a55c-7f93618dae26', '1a2cd3a6-a4fc-4798-86b3-01787cd2f767', '1', '朋友推荐');
INSERT INTO `design_single_option` VALUES ('98c57551-9fe4-4290-8e5c-7c475b878499', 'a57085e5-7d7a-41d9-a664-4c797441d773', '4', '语音消息');
INSERT INTO `design_single_option` VALUES ('a0299a61-6315-444e-88e9-04809af0d7eb', '2ed4ac51-3afc-48d4-b196-6425282fe225', '2', '2');
INSERT INTO `design_single_option` VALUES ('a5b3f76d-d38e-4b86-be18-045493907c0d', '2ed4ac51-3afc-48d4-b196-6425282fe225', '3', '3');
INSERT INTO `design_single_option` VALUES ('b98086eb-361d-4cb4-b98b-bbe47b4abc88', '1a2cd3a6-a4fc-4798-86b3-01787cd2f767', '4', '主动搜索');
INSERT INTO `design_single_option` VALUES ('cc34f0bb-ee6d-4e15-8465-6641ffbb6ee0', '4d1e0233-b57e-44ab-bbe4-13fadc0fbe20', '2', '10—20个');
INSERT INTO `design_single_option` VALUES ('cda18c7f-759a-4e7c-9d46-adc362859563', '4d1e0233-b57e-44ab-bbe4-13fadc0fbe20', '3', '太多了，没有数过');
INSERT INTO `design_single_option` VALUES ('d1f3224b-ff9b-4bda-8d5f-bd54be3c2b1f', 'a57085e5-7d7a-41d9-a664-4c797441d773', '1', '纯文字');
INSERT INTO `design_single_option` VALUES ('e1d91a27-e9f0-4fb1-85b6-125289ecfcd8', 'f4eb0114-ebb4-4687-97e3-29474c6d74ae', '2', '中午休息时');
INSERT INTO `design_single_option` VALUES ('faa8a920-a895-4684-81ab-5d3561b79683', 'f4eb0114-ebb4-4687-97e3-29474c6d74ae', '3', '上课时间');

-- ----------------------------
-- Table structure for design_templet
-- ----------------------------
DROP TABLE IF EXISTS `design_templet`;
CREATE TABLE `design_templet` (
  `design_templet_id` varchar(255) NOT NULL,
  `design_templet_name` varchar(255) DEFAULT NULL,
  `finish_time` datetime DEFAULT NULL,
  `start_recovery_time` datetime DEFAULT NULL,
  `end_recovery_time` datetime DEFAULT NULL,
  `state` int(255) DEFAULT NULL,
  `link` varchar(255) DEFAULT NULL,
  `author_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_templet_id`),
  KEY `foreign key_user_id` (`author_id`),
  CONSTRAINT `foreign key_user_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_templet
-- ----------------------------
INSERT INTO `design_templet` VALUES ('3681c296-7a0a-45fa-9724-09716438aa04', '薛中然公众号粉丝调查', '2018-05-08 18:04:43', null, null, '1', null, 'c5337055-7ae7-4227-b4f7-d65e94b45575');

-- ----------------------------
-- Table structure for design_templet_index
-- ----------------------------
DROP TABLE IF EXISTS `design_templet_index`;
CREATE TABLE `design_templet_index` (
  `design_templet_index_id` varchar(255) NOT NULL,
  `design_templet_index_sign` int(255) DEFAULT NULL,
  `design_templet_index_order` int(255) DEFAULT NULL,
  `design_exercise_id` varchar(255) DEFAULT NULL,
  `design_templet_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_templet_index_id`),
  KEY `foreign key_design_templet_id` (`design_templet_id`),
  CONSTRAINT `foreign key_design_templet_id` FOREIGN KEY (`design_templet_id`) REFERENCES `design_templet` (`design_templet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_templet_index
-- ----------------------------
INSERT INTO `design_templet_index` VALUES ('0799fc91-5228-47d7-9558-4813bf254788', '3', '4', '973f7fab-ac50-4b74-bd59-b10cf5988b20', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('09e2bee0-4b93-47af-b769-8a6a52a5c96b', '1', '2', 'f4eb0114-ebb4-4687-97e3-29474c6d74ae', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('2e06db82-44d1-427d-8a33-0ed2c6161964', '3', '5', '24ae05c9-0f56-45c0-9182-753d3b003fd0', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('3dcc83f8-245c-4eb7-908d-972f0d870827', '1', '4', '7d3df5a3-6d27-4719-803f-d8024ae2de52', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('49c90322-109e-4c5d-9bdd-9a0974efacbf', '3', '3', '3a8106de-c8a4-44fb-bede-a4cb680a5b85', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('50b64c22-eb07-4564-b5b8-fb3109b9acd4', '3', '1', '938d9d77-b035-419a-9379-28368d2386d9', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('5d0015ae-6441-4e94-bd0d-5da9c7dc523d', '1', '5', '4d1e0233-b57e-44ab-bbe4-13fadc0fbe20', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('6df6104a-00f8-451c-af3a-bef241b95980', '1', '6', '2ed4ac51-3afc-48d4-b196-6425282fe225', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('75e8a29c-d934-46cd-9a78-91a50d4aa915', '1', '1', '1a2cd3a6-a4fc-4798-86b3-01787cd2f767', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('921b674c-c096-40b9-ac32-de18d910d92b', '2', '3', '1e21ef8e-72f0-445e-bfa2-e7d50c72d31a', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('9b152448-f1ed-4f2a-a41b-6a42482a96dc', '2', '2', 'dd493e0b-a692-4703-a704-0961785ee3e0', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('bf56c3da-6aa0-4e4e-b948-12203f9d3e50', '1', '3', 'a57085e5-7d7a-41d9-a664-4c797441d773', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('e58674cf-e152-4840-91f7-8fb7974150c4', '3', '2', 'e3d51bd4-b9e5-40bb-a0ec-da5484ebeef8', '3681c296-7a0a-45fa-9724-09716438aa04');
INSERT INTO `design_templet_index` VALUES ('f56c0755-23dc-4eee-8322-bfdf52fd71e4', '2', '1', '1dd6ca21-4477-44ac-8baa-99c36204bfeb', '3681c296-7a0a-45fa-9724-09716438aa04');

-- ----------------------------
-- Table structure for design_text
-- ----------------------------
DROP TABLE IF EXISTS `design_text`;
CREATE TABLE `design_text` (
  `design_text_id` varchar(255) NOT NULL,
  `design_text_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`design_text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of design_text
-- ----------------------------
INSERT INTO `design_text` VALUES ('24ae05c9-0f56-45c0-9182-753d3b003fd0', '测试文本题');
INSERT INTO `design_text` VALUES ('3a8106de-c8a4-44fb-bede-a4cb680a5b85', '您的昵称是？');
INSERT INTO `design_text` VALUES ('938d9d77-b035-419a-9379-28368d2386d9', '您希望我们公众号新增什么板块/功能？');
INSERT INTO `design_text` VALUES ('973f7fab-ac50-4b74-bd59-b10cf5988b20', '您的联系方式（方便奖品发放）是？');
INSERT INTO `design_text` VALUES ('e3d51bd4-b9e5-40bb-a0ec-da5484ebeef8', '您对我们的公众号有什么意见或建议？');

-- ----------------------------
-- Table structure for single_answer_count
-- ----------------------------
DROP TABLE IF EXISTS `single_answer_count`;
CREATE TABLE `single_answer_count` (
  `single_answer_count_id` varchar(255) NOT NULL,
  `single_answer_count` int(255) DEFAULT NULL,
  `design_single_option_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`single_answer_count_id`),
  KEY `foreign key_design_single_option_id` (`design_single_option_id`),
  CONSTRAINT `foreign key_design_single_option_id` FOREIGN KEY (`design_single_option_id`) REFERENCES `design_single_option` (`design_single_option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of single_answer_count
-- ----------------------------

-- ----------------------------
-- Table structure for text_answer
-- ----------------------------
DROP TABLE IF EXISTS `text_answer`;
CREATE TABLE `text_answer` (
  `text_answer_id` varchar(255) NOT NULL,
  `design_text_id` varchar(255) DEFAULT NULL,
  `text_answer_content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`text_answer_id`),
  KEY `foreign key_text_answer_design_text_id` (`design_text_id`),
  CONSTRAINT `foreign key_text_answer_design_text_id` FOREIGN KEY (`design_text_id`) REFERENCES `design_text` (`design_text_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of text_answer
-- ----------------------------

-- ----------------------------
-- Table structure for wx_author
-- ----------------------------
DROP TABLE IF EXISTS `wx_author`;
CREATE TABLE `wx_author` (
  `wx_author_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `wx_author_email` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_nick_name` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_sex` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_country` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_province` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_city` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_avatar_url` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `wx_author_open_id` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`wx_author_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of wx_author
-- ----------------------------
INSERT INTO `wx_author` VALUES ('349f2b9b-5633-4ff0-8e2b-5183a2bc991b', '1062837400@qq.com', '一不小心睡着了', '男', '中国', '河北', '北京', 'https://wx.qlogo.cn/mmopen/vi_32/iaccJSlTtyOwa8WsISp0dp0oEknmlicicnn0Nck2zV0quXJQ8iciaQ0kCOQC7ARRsyqLzYiaqE3oYNUKIPibvDkaicFJHg/132', 'oQLFG46moWC10Z-EqMxWGp6lWdGc');
