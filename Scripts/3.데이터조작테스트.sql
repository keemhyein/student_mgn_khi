select user(), database();

select stdno, stdname, kor, eng, math from student;

select stdno, stdname, kor, eng, math from student where stdno = 1001;

insert into student values(1002, '김혜인', 90, 85, 80);

update student set kor = 90 where stdno = 1001;

delete from student where stdno = 1001;



insert into student values(1004, '이윤정', null, null, null);
