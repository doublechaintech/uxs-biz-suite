-- BUILD WITH MODEL TIME 190215T1733
drop database  if exists uxs;
create database uxs;
alter  database uxs  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use uxs;

drop table  if exists platform_data;
create table platform_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(92)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists product_data;
create table product_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(64)                              comment 'Name',
	platform            	varchar(48)                              comment 'Platform',
	avarage_score       	numeric(3,1)                             comment 'Avarage Score',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists banner_data;
create table banner_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(116)                             comment 'Name',
	image_path          	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Image Path',
	last_update         	datetime                                 comment 'Last Update',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists profile_data;
create table profile_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(72)                              comment 'Name',
	platform            	varchar(48)                              comment 'Platform',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists target_data;
create table target_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(56)                              comment 'Name',
	profile             	varchar(48)                              comment 'Profile',
	banner              	varchar(48)                              comment 'Banner',
	location            	varchar(16)                              comment 'Location',
	last_update         	datetime                                 comment 'Last Update',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists rating_data;
create table rating_data (
	id                  	varchar(64)          not null            comment 'Id',
	user                	varchar(48)                              comment 'User',
	product             	varchar(48)                              comment 'Product',
	score               	int                                      comment 'Score',
	update_time         	datetime                                 comment 'Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists review_data;
create table review_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(44)                              comment 'Title',
	content             	longtext                                 comment 'Content',
	user                	varchar(48)                              comment 'User',
	product             	varchar(48)                              comment 'Product',
	update_time         	datetime                                 comment 'Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists blog_data;
create table blog_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(64)                              comment 'Title',
	content             	longtext                                 comment 'Content',
	user                	varchar(48)                              comment 'User',
	product             	varchar(48)                              comment 'Product',
	update_time         	datetime                                 comment 'Update Time',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_domain_data;
create table user_domain_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(16)                              comment 'Name',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                  	varchar(64)          not null            comment 'Id',
	user_identity       	varchar(40)                              comment 'User Identity',
	user_special_functions	varchar(200)                             comment 'User Special Functions',
	domain              	varchar(48)                              comment 'Domain',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_data;
create table sec_user_data (
	id                  	varchar(64)          not null            comment 'Id',
	login               	varchar(20)                              comment 'Login',
	mobile              	varchar(11)                              comment 'Mobile',
	email               	varchar(76)                              comment 'Email',
	pwd                 	varchar(64)                              comment 'Pwd',
	verification_code   	int                                      comment 'Verification Code',
	verification_code_expire	datetime                                 comment 'Verification Code Expire',
	last_login_time     	datetime                                 comment 'Last Login Time',
	domain              	varchar(48)                              comment 'Domain',
	blocking            	varchar(48)                              comment 'Blocking',
	current_status      	varchar(28)                              comment 'Current Status',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                  	varchar(64)          not null            comment 'Id',
	who                 	varchar(52)                              comment 'Who',
	block_time          	datetime                                 comment 'Block Time',
	comments            	varchar(96)                              comment 'Comments',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists user_app_data;
create table user_app_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(300)                             comment 'Title',
	sec_user            	varchar(48)                              comment 'Sec User',
	app_icon            	varchar(36)                              comment 'App Icon',
	full_access         	tinyint                                  comment 'Full Access',
	permission          	varchar(16)                              comment 'Permission',
	object_type         	varchar(108)                             comment 'Object Type',
	object_id           	varchar(40)                              comment 'Object Id',
	location            	varchar(48)                              comment 'Location',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists list_access_data;
create table list_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(200)                             comment 'Name',
	internal_name       	varchar(200)                             comment 'Internal Name',
	read_permission     	tinyint                                  comment 'Read Permission',
	create_permission   	tinyint                                  comment 'Create Permission',
	delete_permission   	tinyint                                  comment 'Delete Permission',
	update_permission   	tinyint                                  comment 'Update Permission',
	execution_permission	tinyint                                  comment 'Execution Permission',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists object_access_data;
create table object_access_data (
	id                  	varchar(64)          not null            comment 'Id',
	name                	varchar(28)                              comment 'Name',
	object_type         	varchar(112)                             comment 'Object Type',
	list1               	varchar(80)                              comment 'List1',
	list2               	varchar(80)                              comment 'List2',
	list3               	varchar(80)                              comment 'List3',
	list4               	varchar(80)                              comment 'List4',
	list5               	varchar(80)                              comment 'List5',
	list6               	varchar(80)                              comment 'List6',
	list7               	varchar(80)                              comment 'List7',
	list8               	varchar(80)                              comment 'List8',
	list9               	varchar(80)                              comment 'List9',
	app                 	varchar(48)                              comment 'App',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists login_history_data;
create table login_history_data (
	id                  	varchar(64)          not null            comment 'Id',
	login_time          	datetime                                 comment 'Login Time',
	from_ip             	varchar(44)                              comment 'From Ip',
	description         	varchar(16)                              comment 'Description',
	sec_user            	varchar(48)                              comment 'Sec User',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists generic_form_data;
create table generic_form_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(20)                              comment 'Title',
	description         	varchar(48)                              comment 'Description',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_message_data;
create table form_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(24)                              comment 'Title',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                  	varchar(64)          not null            comment 'Id',
	title               	varchar(16)                              comment 'Title',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	form                	varchar(48)                              comment 'Form',
	level               	varchar(28)                              comment 'Level',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_field_data;
create table form_field_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(12)                              comment 'Label',
	locale_key          	varchar(44)                              comment 'Locale Key',
	parameter_name      	varchar(16)                              comment 'Parameter Name',
	type                	varchar(36)                              comment 'Type',
	form                	varchar(48)                              comment 'Form',
	placeholder         	varchar(48)                              comment 'Placeholder',
	default_value       	varchar(12)                              comment 'Default Value',
	description         	varchar(48)                              comment 'Description',
	field_group         	varchar(16)                              comment 'Field Group',
	minimum_value       	varchar(60)                              comment 'Minimum Value',
	maximum_value       	varchar(72)                              comment 'Maximum Value',
	required            	tinyint                                  comment 'Required',
	disabled            	tinyint                                  comment 'Disabled',
	custom_rendering    	tinyint                                  comment 'Custom Rendering',
	candidate_values    	varchar(12)                              comment 'Candidate Values',
	suggest_values      	varchar(12)                              comment 'Suggest Values',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;

drop table  if exists form_action_data;
create table form_action_data (
	id                  	varchar(64)          not null            comment 'Id',
	label               	varchar(8)                               comment 'Label',
	locale_key          	varchar(16)                              comment 'Locale Key',
	action_key          	varchar(24)                              comment 'Action Key',
	level               	varchar(28)                              comment 'Level',
	url                 	varchar(168)                             comment 'Url',
	form                	varchar(48)                              comment 'Form',
	version             	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci ;






	
insert into platform_data values ('P000001','Chain eComerce Platform','1');

	
insert into product_data values ('P000001','A beautiful jean','P000001','4.00','1');
insert into product_data values ('P000002','A beautiful jean0002','P000001','3.34','1');

	
insert into banner_data values ('B000001','2.14 Valentines Day Promotion','https://demo.doublechaintech.com/demodata/imageManager/genImage/ValDay00/800/600/RED/','2019-02-04 01:36:49','P000001','1');
insert into banner_data values ('B000002','2.14 Valentines Day Promotion0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/ValDay00/800/600/RED/','2019-02-09 01:58:55','P000001','1');

	
insert into profile_data values ('P000001','Philip Zhang','P000001','1');
insert into profile_data values ('P000002','Naveen Kumar R ','P000001','1');
insert into profile_data values ('P000003','VENKATESH GADUPUTI','P000001','1');

	
insert into target_data values ('T000001','valentines day','P000001','B000001','HOME','2019-02-13 06:53:52','1');
insert into target_data values ('T000002','valentines day0002','P000001','B000001','HOME0002','2019-02-10 08:44:29','1');
insert into target_data values ('T000003','valentines day0003','P000002','B000002','HOME0003','2019-01-26 12:23:50','1');
insert into target_data values ('T000004','valentines day0004','P000003','B000002','HOME0004','2019-02-05 22:05:13','1');

	
insert into rating_data values ('R000001','P000001','P000001','1','2019-02-10 14:15:59','1');
insert into rating_data values ('R000002','P000001','P000001','2','2019-02-02 13:45:02','1');
insert into rating_data values ('R000003','P000002','P000002','3','2019-02-05 06:36:34','1');
insert into rating_data values ('R000004','P000003','P000002','4','2019-02-04 06:08:51','1');

	
insert into review_data values ('R000001','Credit Card','    一段样例文字。
可以分段。

可以空行。

','P000001','P000001','2019-02-11 08:06:26','1');
insert into review_data values ('R000002','GiftCard','    一段样例文字。
可以分段。

可以空行。

','P000001','P000001','2019-02-13 03:41:07','1');
insert into review_data values ('R000003','Credit Card','    一段样例文字。
可以分段。

可以空行。

','P000002','P000002','2019-02-05 09:12:11','1');
insert into review_data values ('R000004','GiftCard','    一段样例文字。
可以分段。

可以空行。

','P000003','P000002','2019-02-07 05:29:17','1');

	
insert into blog_data values ('B000001','a consumer order','    一段样例文字。
可以分段。

可以空行。

','P000001','P000001','2019-02-01 18:42:41','1');
insert into blog_data values ('B000002','a consumer order0002','    一段样例文字。
可以分段。

可以空行。

','P000001','P000001','2019-02-10 11:10:25','1');
insert into blog_data values ('B000003','a consumer order0003','    一段样例文字。
可以分段。

可以空行。

','P000002','P000002','2019-02-11 14:20:20','1');
insert into blog_data values ('B000004','a consumer order0004','    一段样例文字。
可以分段。

可以空行。

','P000003','P000002','2019-02-07 05:36:36','1');

	
insert into user_domain_data values ('UD000001','用户区域','1');

	
insert into user_white_list_data values ('UWL000001','clariones','tester;ios-spokesperson','UD000001','1');
insert into user_white_list_data values ('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

	
insert into sec_user_data values ('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','0','2019-02-01 10:39:23','2019-01-25 13:55:51','UD000001',NULL,'BLOCKED','1');
insert into sec_user_data values ('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','9999999','2019-02-12 12:16:54','2019-01-31 11:33:27','UD000001',NULL,'BLOCKED0002','1');

	
insert into sec_user_blocking_data values ('SUB000001','currentUser()','2019-01-25 03:54:16','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

	
insert into user_app_data values ('UA000001','审车平台','SU000001','users',1,'MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1');
insert into user_app_data values ('UA000002','账户管理','SU000001','bank',1,'MXWR','UserDomain','UD000001','/link/to/app0002','1');
insert into user_app_data values ('UA000003','接车公司','SU000001','wechat',1,'MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1');
insert into user_app_data values ('UA000004','审车公司','SU000002','bar-chart',1,'MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1');
insert into user_app_data values ('UA000005','维修公司','SU000002','user',1,'MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1');
insert into user_app_data values ('UA000006','顾客','SU000002','users',1,'MXWR','CustomerInfo','CI000001','/link/to/app0006','1');

	
insert into list_access_data values ('LA000001','列表','levelOneCategoryList',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000002','列表0002','levelOneCategoryList0002',1,1,1,1,1,'UA000001','1');
insert into list_access_data values ('LA000003','列表0003','levelOneCategoryList0003',1,1,1,1,1,'UA000002','1');
insert into list_access_data values ('LA000004','列表0004','levelOneCategoryList0004',1,1,1,1,1,'UA000003','1');
insert into list_access_data values ('LA000005','列表0005','levelOneCategoryList0005',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000006','列表0006','levelOneCategoryList0006',1,1,1,1,1,'UA000004','1');
insert into list_access_data values ('LA000007','列表0007','levelOneCategoryList0007',1,1,1,1,1,'UA000005','1');
insert into list_access_data values ('LA000008','列表0008','levelOneCategoryList0008',1,1,1,1,1,'UA000006','1');

	
insert into object_access_data values ('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1');
insert into object_access_data values ('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1');
insert into object_access_data values ('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1');
insert into object_access_data values ('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1');
insert into object_access_data values ('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1');
insert into object_access_data values ('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1');
insert into object_access_data values ('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1');
insert into object_access_data values ('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');

	
insert into login_history_data values ('LH000001','2019-01-26 23:20:38','192.168.1.1','登陆成功','SU000001','1');
insert into login_history_data values ('LH000002','2019-01-25 17:48:05','192.168.1.2','登陆成功0002','SU000001','1');
insert into login_history_data values ('LH000003','2019-01-28 17:24:48','192.168.1.1','登陆成功0003','SU000002','1');
insert into login_history_data values ('LH000004','2019-01-25 21:02:03','192.168.1.2','登陆成功0004','SU000002','1');

	
insert into generic_form_data values ('GF000001','登记输入单','姓名就是你身份证上的名字','1');

	
insert into form_message_data values ('FM000001','字段组合错误','GF000001','success','1');
insert into form_message_data values ('FM000002','字段组合错误0002','GF000001','info','1');

	
insert into form_field_message_data values ('FFM000001','输入错误','name','GF000001','success','1');
insert into form_field_message_data values ('FFM000002','输入错误0002','name0002','GF000001','info','1');

	
insert into form_field_data values ('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression',true,true,0,'','','1');
insert into form_field_data values ('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002',false,false,0,'','','1');
insert into form_field_data values ('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003',true,true,0,'','','1');
insert into form_field_data values ('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004',false,false,0,'男,女','男,女','1');

	
insert into form_action_data values ('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1');
insert into form_action_data values ('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');

/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_platform_version on platform_data(id, version);

create unique index idx_product_version on product_data(id, version);

alter table product_data add constraint product4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_banner_version on banner_data(id, version);

alter table banner_data add constraint banner4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_profile_version on profile_data(id, version);

alter table profile_data add constraint profile4platform_fk
	foreign key(platform) references platform_data(id) on delete cascade on update cascade;
create unique index idx_target_version on target_data(id, version);

alter table target_data add constraint target4profile_fk
	foreign key(profile) references profile_data(id) on delete cascade on update cascade;
alter table target_data add constraint target4banner_fk
	foreign key(banner) references banner_data(id) on delete cascade on update cascade;
create unique index idx_rating_version on rating_data(id, version);

alter table rating_data add constraint rating4user_fk
	foreign key(user) references profile_data(id) on delete cascade on update cascade;
alter table rating_data add constraint rating4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_review_version on review_data(id, version);

alter table review_data add constraint review4user_fk
	foreign key(user) references profile_data(id) on delete cascade on update cascade;
alter table review_data add constraint review4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_blog_version on blog_data(id, version);

alter table blog_data add constraint blog4user_fk
	foreign key(user) references profile_data(id) on delete cascade on update cascade;
alter table blog_data add constraint blog4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index platform4version_idx on platform_data(version);
create index product4avarage_score_idx on product_data(avarage_score);
create index product4version_idx on product_data(version);
create index banner4last_update_idx on banner_data(last_update);
create index banner4version_idx on banner_data(version);
create index profile4version_idx on profile_data(version);
create index target4last_update_idx on target_data(last_update);
create index target4version_idx on target_data(version);
create index rating4score_idx on rating_data(score);
create index rating4update_time_idx on rating_data(update_time);
create index rating4version_idx on rating_data(version);
create index review4update_time_idx on review_data(update_time);
create index review4version_idx on review_data(version);
create index blog4update_time_idx on blog_data(update_time);
create index blog4version_idx on blog_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);










delete from sec_user_data;
delete from user_app_data;

/*
+--------------------------+-------------+------+-----+---------+-------+
| Field                    | Type        | Null | Key | Default | Extra |
+--------------------------+-------------+------+-----+---------+-------+
| id                       | varchar(64) | NO   | PRI | NULL    |       |
| login                    | varchar(20) | YES  |     | NULL    |       |
| mobile                   | varchar(11) | YES  | MUL | NULL    |       |
| email                    | varchar(76) | YES  |     | NULL    |       |
| pwd                      | varchar(64) | YES  |     | NULL    |       |
| verification_code        | int(11)     | YES  | MUL | NULL    |       |
| verification_code_expire | datetime    | YES  | MUL | NULL    |       |
| last_login_time          | datetime    | YES  | MUL | NULL    |       |
| domain                   | varchar(48) | YES  | MUL | NULL    |       |
| blocking                 | varchar(48) | YES  | MUL | NULL    |       |
| current_status           | varchar(28) | YES  |     | NULL    |       |
| version                  | int(11)     | YES  | MUL | NULL    |       |
+--------------------------+-------------+------+-----+---------+-------+


*/

insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','258D9BB89BBC1F2A6CDDD3A4CB300E6CD9B83F3FC9984619DF1A59F6051F1F44','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Platform','SU000001','at',1,'MXWR','Platform','P000001','/link/to/app','1'); -- REFER COUNT: 3
insert into user_app_data values('UA000002','My Account','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1'); -- REFER COUNT: 3
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','7FEABCC19D638787655F9FFC2C22755D5771184D85D000147D643D22F6617F7B','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','Profile','SU000002','file',1,'MXWR','Profile','P000001','/link/to/app','1'); -- REFER COUNT: 4
insert into user_app_data values('UA000004','My Account','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1'); -- REFER COUNT: 4
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','8169C17063461B0B0CC210CE5EF682E9517A19170F7DCA3C76170229D765DE7A','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','User Domain','SU000003','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1'); -- REFER COUNT: 2
insert into user_app_data values('UA000006','My Account','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1'); -- REFER COUNT: 2
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','025745F4A4EA0C11059911E40714470F323C42836B1137D66AD3F85210A725CF','9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','Sec User Blocking','SU000004','user',1,'MXWR','SecUserBlocking','SUB000001','/link/to/app','1'); -- REFER COUNT: 1
insert into user_app_data values('UA000008','My Account','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1'); -- REFER COUNT: 1




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Platform|13900000001|DoubleChain!y1|
|Profile|13900000002|DoubleChain!y1|
|User Domain|13900000003|DoubleChain!y1|
|Sec User Blocking|13900000004|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/uxs.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

