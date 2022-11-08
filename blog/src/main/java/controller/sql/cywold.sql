drop database if exists Cywold;
create database Cywold;
use Cywold;


drop table if exists Cywold_signup;

-- 예은 회원 [ 선정 ] 
create table Cywold_signup(
cy_num int auto_increment primary key, -- 회원고유번호
cy_id varchar(20),			-- 20자 까지 입력가능 인스타 아이디나 페이스북처럼 
cy_password varchar(16),	-- 비밀번호 대소문자 문자 숫자 특수문자 포함 글자까지 허용
cy_name varchar(50),		-- 이름 외국인도 페이스북이나 인스타처럼 외국인도 가입하는데 이름이 길수 있으니 일단 넉넉하게
cy_phone varchar(30),		-- 외국인들 까지 포함을 시켜버리니 외국인들 전화번호가 몇자리인지..이건 확인해보고
cy_email varchar(50),		-- 이메일 대소문자 문자 숫자 포함 50자리 설마 50자리 넘는 이메일도 있을까?
cy_nickname varchar(30),	-- 이름도 가능하지만, 닉네임으로도 **의 미니홈피 이런식으로 꾸미면 괜찮을 것 같아서 일단 넣어봄!
cy_signuptime datetime default now(), -- 가입날짜 추가...10/30
cy_cash int default 0		-- 노래구매 및 스킨구매 용으로 도토리
);

select * from Cywold_signup;

DROP TABLE if exists category;
create table category( cno int auto_increment primary key , cname varchar(100)  );

DROP TABLE if exists board;
CREATE TABLE board(
	bno			int auto_increment,  -- 번호  	
    btitle		varchar(1000) NOT NULL, 		-- 제목 		
    bcontent	longtext NULL,			-- 내용	[ 썸머노트 이용해서 사진/영상 대용량 추가 ]
    bfile		longtext NULL,			-- 첨부파일 [ 게시물 1개당 첨부파일 1개 ]
    bdate 		datetime default now() NOT NULL	,	-- 작성일 : 기본값 현재 DB서버 시스템 날짜 
    bview		int default 0 NOT NULL ,				-- 조회수 : 기본값 0 
    cno			int ,									-- 카테고리번호 FK 
    cy_num 		int	,									-- 작성자 
	constraint bno_pk primary key (bno)  , 
    constraint bcno_fk foreign key (cno) references category(cno) on update cascade ,
    constraint bmno_fk foreign key (cy_num) references cywold_signup(cy_num) on delete cascade
);

-- 댓글 : 1.게시물번호 2.회원번호 3.내용 4.답글식별필드
drop table if exists reply;
create table reply(
	rno 		int  auto_increment, -- 댓글식별번호 
    rcontent 	varchar(1000) not null , -- 댓글내용
    rdate		datetime  default now(),  -- 댓글작성일
    rindex		int default 0 , -- 댓글 과 대댓글 식별 필드 [ 0:상위댓글 , 숫자:상위댓글번호 ] 
    mno			int not null,-- 작성자 회원번호
    cy_num			int not null,-- 게시물번호 
    constraint rno_pk primary key(rno) ,
    constraint rmno_fk foreign key (cy_num) references cywold_signup(cy_num) on delete cascade, -- 회원탈퇴시 댓글도 같이 삭제
    constraint rbno_fk foreign key (bno ) references board(bno) on delete cascade -- 게시물삭제시 댓글도 같이 삭제
);

--  다이어리 관련 --

-- 다이어리 
drop table if exists diary;
create table diary(
	di_no int auto_increment primary key,		-- 다이어리 식별번호
    di_date date default (current_date) ,		-- 다이어리 작성날짜(당일일기만 가능)
    di_content varchar(200) not null, 					-- 작성한 다이어리 내용
    emo_no int ,								-- 선택한 감정 번호
    cy_num int ,								-- 회원 식별번호
    constraint cy_num_di_fk foreign key (cy_num) references Cywold_signup (cy_num) 
);
select * from diary;
-- 감정
drop table if exists emotion;
create table emotion(
	emo_no int auto_increment primary key ,			-- 감정식별번호
    emotion varchar(20) ,							-- 감정설명	
    emo_img varchar(20) ,							-- 감정이미지이름	
	cy_num int ,
    constraint cy_num_em_fk foreign key (cy_num) references Cywold_signup (cy_num)
);
select * from emotion;

-- 다이어리 배경 이미지
drop table if exists backimg;
create table backimg(
	back_no int auto_increment primary key,						-- 다이어리 배경 이미지 식별번호
    back_img varchar(20) ,										-- 다이어리 배경 이미지 이름
	cy_num int ,
    constraint cy_num_ba_fk foreign key (cy_num) references Cywold_signup (cy_num)
);
select * from backimg;

-- js와 관련되어 추가해둡니다.
insert into backimg values( null , '배경1' , 1 );
insert into backimg values( null , '배경2' , 1 );
insert into backimg values( null , '배경3' , 1 );
insert into backimg values( null , '배경4' , 1 );
insert into backimg values( null , '배경5' , 1 );

-- js와 관련되어 추가해둡니다
insert into emotion value( null , '슬픈 날' , '하트1.gif' , 1);
insert into emotion value( null , '즐거운 날' , '하트2.gif' , 1);
insert into emotion value( null , '우울한 날' , '하트3.gif' , 1);
insert into emotion value( null , '화나는 날' , '하트4.gif' , 1);
insert into emotion value( null , '행복한 날' , '하트5.gif' , 1);