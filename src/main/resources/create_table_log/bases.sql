-- 插入数据到Permit
insert into Permit(permit_id,permit_name,url) value(10000,'学生管理','/home/m_student');
insert into Permit(permit_id,permit_name,url) value(10001,'教师管理','/home/m_teacher');
insert into Permit(permit_id,permit_name,url) value(10002,'权限管理','/home/m_permit');
insert into Permit(permit_id,permit_name,url) value(10003,'课程管理','/home/m_course');
insert into Permit(permit_id,permit_name,url) value(10004,'选课情况','/home/select_status');
insert into Permit(permit_id,permit_name,url) value(10005,'选课','/home/select_course');
insert into Permit(permit_id,permit_name,url) value(10006,'退课','/home/delete_course');
insert into Permit(permit_id,permit_name,url) value(10007,'课表查询','/home/course_table');
insert into Permit(permit_id,permit_name,url) value(10008,'用户管理','/home/m_user');


-- 插入数据到 Role
insert into Role(role_id,role_name) value(1,'admin');
insert into Role(role_id,role_name) value(2,'教师');
insert into Role(role_id,role_name) value(3,'学生');

--插入数据到User
insert into User(user_id,user_name,password) value(80808080,'adminstrator',md5('Asd123456'));
insert into User(user_id,user_name,password) value(14122260,'袁子华',md5('123456'));


--插入数据到 user_role
insert into user_role(user_id,role_id) value(80808080,1);
insert into user_role(user_id,role_id) value(14122260,3);


--插入数据到 role_permit
insert into role_permit(role_id,permit_id) value(1,10000);
insert into role_permit(role_id,permit_id) value(1,10001);
insert into role_permit(role_id,permit_id) value(1,10002);
insert into role_permit(role_id,permit_id) value(1,10003);
insert into role_permit(role_id,permit_id) value(1,10008);
insert into role_permit(role_id,permit_id) value(3,10005);
insert into role_permit(role_id,permit_id) value(3,10006);
insert into role_permit(role_id,permit_id) value(3,10007);
insert into role_permit(role_id,permit_id) value(2,10003);
insert into role_permit(role_id,permit_id) value(2,10004);


--插入数据到Course
insert into Course(course_id,course_name,credit,start,end,week) value(20170000,'高数',5,1,4,2);
insert into Course(course_id,course_name,credit,start,end,week) value(20170001,'线代',5,1,4,1);
insert into Course(course_id,course_name,credit,start,end,week) value(20170002,'c++',4,1,4,3);
insert into Course(course_id,course_name,credit,start,end,week) value(20170003,'java',4,1,4,4);
insert into Course(course_id,course_name,credit,start,end,week) value(20170004,'python',4,7,9,1);
insert into Course(course_id,course_name,credit,start,end,week) value(20170005,'操作系统',6,8,11,5);
insert into Course(course_id,course_name,credit,start,end,week) value(20170006,'玄学',2,5,6,2);
insert into Course(course_id,course_name,credit,start,end,week) value(20170007,'JavaScript',5,7,10,2);
insert into Course(course_id,course_name,credit,start,end,week) value(20170008,'php',3,3,4,1);
insert into Course(course_id,course_name,credit,start,end,week) value(20170009,'佛学',3,3,4,2);
insert into Course(course_id,course_name,credit,start,end,week) value(20170010,'ruby',3,5,6,4);
insert into Course(course_id,course_name,credit,start,end,week) value(20170011,'钱伟长为什么行',2,5,6,3);

--插入数据到
insert into open_course(teacher_id,course_id) value(70700000,2);




