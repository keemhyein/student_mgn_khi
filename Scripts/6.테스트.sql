-- 학생이 수강한 과목


create view vw_student_grade
    as
select std_no '학번'
	 , std_name '성명'
	 , sum(if(subj_code = 501, score, null)) '컴퓨터 개론'
	 , sum(if(subj_code = 502, score, null)) '프리토킹'
	 , sum(if(subj_code = 503, score, null)) '리스닝'
	 , sum(if(subj_code = 504, score, null)) '데이터 과학'
	 , sum(if(subj_code = 505, score, null)) '빅데이터'
	 , sum(score) 합계
	 , avg(score) 평균 
  from (select s.std_no, s.std_name, j.subj_name, j.subj_code, e.score
  from student s join enroll e
    on s.std_no = e.std_no
  join subject j
    on e.subj_code = j.subj_code) t
 group by std_no;


select 학번, 성명, `컴퓨터 개론`, 프리토킹, 리스닝, `데이터 과학`, 빅데이터, 합계, 평균 
  from vw_student_grade;
  
 
-- 101 학생이 수강한 과목을 알고자 할 경우
select s.std_no, s.std_name, e.subj_code, j.subj_name
  from student s join enroll e on s.std_no = e.std_no
  join subject j on e.subj_code = j.subj_code
 where s.std_no = 101;
 
-- '프리토킹' 과목을 수강한 학생
select s.subj_code, s.subj_name, std.std_no, std.std_name, std.std_dept
  from subject s join enroll e on s.subj_code = e.subj_code
  join student std on std.std_no = e.std_no
 where s.subj_code = 502;
 
 
 
 
 