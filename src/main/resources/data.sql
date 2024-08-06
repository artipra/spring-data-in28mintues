insert into course(id,name) values(10003, 'learn jpa with arti');
insert into course(id,name) values(10001, 'learn aws with arti');
insert into course(id,name) values(10002, 'learn gardening with arti');
insert into course(id,name) values(10004, 'learn content creation with arti');
insert into course(id,name) values(10005, 'learn cloud computing with arti');
insert into course(id,name) values(10006, 'learn health with arti');
insert into course(id,name) values(10007, 'learn yoga with arti');
insert into course(id,name) values(10008, 'learn docker with arti');
insert into course(id,name) values(10009, 'learn kubernetes with arti');


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'A123789');
insert into passport(id,number)
values(40003,'Z456789');


insert into student(id, name, passport_id)
values(20001,'Ranga',40001);
insert into student(id, name, passport_id)
values(20002,'Adam',40002);
insert into student(id, name, passport_id)
values(20003,'Jane',40003);

insert into review(id,rating,description,course_id)
values(50001,'5','great course',10002);
insert into review(id,rating,description,course_id)
values(50002,'4','good course',10002);
insert into review(id,rating,description,course_id)
values(50003,'3','course is like magic',10001);
insert into review(id,rating,description,course_id)
values(50004,'5','course is like magic',10003);

insert into STUDENT_COURSE(student_id,course_id)
values(20001,10001);
insert into STUDENT_COURSE(student_id,course_id)
values(20002,10001);
insert into STUDENT_COURSE(student_id,course_id)
values(20003,10001);
insert into STUDENT_COURSE(student_id,course_id)
values(20001,10003);

