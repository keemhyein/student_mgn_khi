-- 학생관리_2
DROP SCHEMA IF EXISTS std_mgn_2;

-- 학생관리_2
CREATE SCHEMA std_mgn_2;

-- 학생
CREATE TABLE std_mgn_2.student (
	std_no   INTEGER      NOT NULL COMMENT '학생번호', -- 학생번호
	std_name VARCHAR(50)  NOT NULL COMMENT '학생명', -- 학생명
	std_dept VARCHAR(255) NULL     COMMENT '소속학과', -- 소속학과
	std_tel  CHAR(13)     NULL     COMMENT '연락처' -- 연락처
)
COMMENT '학생';

-- 학생
ALTER TABLE std_mgn_2.student
	ADD CONSTRAINT PK_student -- 학생 기본키
		PRIMARY KEY (
			std_no -- 학생번호
		);

-- 과목
CREATE TABLE std_mgn_2.subject (
	subj_code INTEGER     NOT NULL COMMENT '과목코드', -- 과목코드
	subj_name VARCHAR(50) NULL     COMMENT '과목명' -- 과목명
)
COMMENT '과목';

-- 과목
ALTER TABLE std_mgn_2.subject
	ADD CONSTRAINT PK_subject -- 과목 기본키
		PRIMARY KEY (
			subj_code -- 과목코드
		);

-- 수강과목
CREATE TABLE std_mgn_2.enroll (
	std_no    INTEGER NOT NULL COMMENT '학생번호', -- 학생번호
	subj_code INTEGER NOT NULL COMMENT '과목코드', -- 과목코드
	score     INTEGER NULL     COMMENT '성적' -- 성적
)
COMMENT '수강과목';

-- 수강과목
ALTER TABLE std_mgn_2.enroll
	ADD CONSTRAINT PK_enroll -- 수강과목 기본키
		PRIMARY KEY (
			std_no,    -- 학생번호
			subj_code  -- 과목코드
		);

-- 수강과목
ALTER TABLE std_mgn_2.enroll
	ADD CONSTRAINT FK_student_TO_enroll -- 학생 -> 수강과목
		FOREIGN KEY (
			std_no -- 학생번호
		)
		REFERENCES std_mgn_2.student ( -- 학생
			std_no -- 학생번호
		);

-- 수강과목
ALTER TABLE std_mgn_2.enroll
	ADD CONSTRAINT FK_subject_TO_enroll -- 과목 -> 수강과목
		FOREIGN KEY (
			subj_code -- 과목코드
		)
		REFERENCES std_mgn_2.subject ( -- 과목
			subj_code -- 과목코드
		);
		
	
-- 사용자 계정
drop user if exists 'user_std_mgn_2'@'localhost';

grant all privileges on std_mgn_2.* to 'user_std_mgn_2'@'localhost' IDENTIFIED BY 'rootroot';
	