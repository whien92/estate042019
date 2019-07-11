INSERT INTO `estate042019`.`building` (`id`, `name`, `numberofbasement`, `buildingarea`, `district`, `ward`, `street`, `costrent`, `costdescription`) VALUES ('4', 'Nam Giao Building', '2', '500', 'QUAN_1', 'Phường 2', '59 Phan Xích Long', '15', '15tr/tháng');
INSERT INTO `estate042019`.`building` (`id`, `name`, `numberofbasement`, `buildingarea`, `district`, `street`, `costrent`, `costdescription`) VALUES ('5', 'ACM Tower', '2', '650', 'QUAN_2', '96 Cao thắng', '18', '18tr/tháng');
INSERT INTO `estate042019`.`building` (`id`, `name`, `numberofbasement`, `buildingarea`, `district`, `street`, `costrent`, `costdescription`) VALUES ('6', 'Alpha 2 Building', '1', '200', 'QUAN_3', '153 Nguyễn Đình Chiểu', '20', '20tr/tháng');
INSERT INTO `estate042019`.`building` (`id`, `name`, `numberofbasement`, `buildingarea`, `district`, `street`, `costrent`, `costdescription`) VALUES ('7', 'IDO 1 Building', '1', '200', 'QUAN_3', '111 Lý Chính Thắng', '21', '21tr/tháng');


INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('100', '4');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('200', '4');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('200', '5');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('300', '5');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('400', '5 ');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('300', '6');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('400', '6');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('500', '6');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('500', '7');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('600', '7');
INSERT INTO `estate042019`.`rentarea` (`value`, `buildingid`) VALUES ('700', '7');
UPDATE `estate042019`.`building` SET `type` = 'TANG_TRET,NGUYEN_CAN' WHERE (`id` = '4');
UPDATE `estate042019`.`building` SET `type` = 'NGUYEN_CAN' WHERE (`id` = '5');
UPDATE `estate042019`.`building` SET `type` = 'NOI_THAT' WHERE (`id` = '6');
UPDATE `estate042019`.`building` SET `type` = 'TANG_TRET,NGUYEN_CAN,NOI_THAT' WHERE (`id` = '7');