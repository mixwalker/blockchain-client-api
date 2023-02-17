INSERT INTO students_address(add_id,add_houseno,add_village,add_street,add_subdis,add_district,add_province,add_postcode,add_oriprovince)
VALUES (1,'226/3','7','-','ไสไทย','เมืองกระบี่','กระบี่','81000','กระบี่');

INSERT INTO students(student_id,student_code,password,student_prefix,firstname,lastname,nation,reli,birthday,phone_no,student_regisyear,add_id,student_faculty,student_major,student_gpa,student_classyear,email,role) 
VALUES (2,'1162109050010','1234','นาย','สรวิชญ์','เจียวก๊ก','ไทย','พุทธ','2001-03-15','0622050811','2562',1,'วิทยาศาสตร์และเทคโนโลยี','วิทยาการคอมพิวเตอร์',3.99,'4','mixwalkerz@gmail.com','student');
INSERT INTO students(student_id,student_code,password,student_prefix,firstname,lastname,nation,reli,birthday,phone_no,student_regisyear,add_id,student_faculty,student_major,student_gpa,student_classyear,email,role) 
VALUES (3,'1162109050416','1234','นาย','อภิสิทธิ์','น้อยหลวงชัย','ไทย','พุทธ','2001-03-15','0622050811','2562',1,'วิทยาศาสตร์และเทคโนโลยี','วิทยาการคอมพิวเตอร์',3.99,'4','mixwalkerz@gmail.com','student');
INSERT INTO students(student_id,student_code,password,firstname,lastname,email,role) 
VALUES (1,'admin','admin1234','admin','Sorrawit','mixwalkerz@gmail.com','admin');

INSERT INTO election(elec_id,elec_name,elec_detail,elec_startdate,elec_enddate,elec_register)
VALUES (1,'การเลือกตั้งสมาชิกสโมสรนักศึกษา','การเลือกตั้งสมาชิกสโมสรนักศึกษาสำหรับคณะวิทยาศาสตร์และเทคโนโลยี ปีการศึกษา 2565',sysdate,sysdate,1);
INSERT INTO election(elec_id,elec_name,elec_detail,elec_startdate,elec_enddate,elec_register)
VALUES (2,'การเลือกตั้งนายกสโมสรนักศึกษา','การเลือกตั้งสมาชิกสโมสรนักศึกษาสำหรับคณะวิทยาศาสตร์และเทคโนโลยี ปีการศึกษา 2565',sysdate,sysdate,1);

INSERT INTO candidate(candidate_id,candi_no,candi_party,candi_regisdate)
VALUES (1,'007','ก้าวไกล','2023-02-06');

INSERT INTO candidate_exp(canexp_id,position,years,candidate_id)
VALUES (1,'Hello','24',1);
INSERT INTO candidate_exp(canexp_id,position,years,candidate_id)
VALUES (2,'kuy','24',1);
INSERT INTO candidate_exp(canexp_id,position,years,candidate_id)
VALUES (3,'kuyss','24',1);

INSERT INTO candidate(candidate_id,candi_no,candi_party,candi_status,candi_regisdate)
VALUES (2,'003','พลังประชารัฐ','1',sysdate);
INSERT INTO candidate(candidate_id,candi_no,candi_party,candi_status)
VALUES (3,'007','พลังประชารัฐ','1');
INSERT INTO candidate(candidate_id,candi_no,candi_party)
VALUES (4,'007','พลังประชารัฐ');
INSERT INTO candidate(candidate_id,candi_no,candi_party)
VALUES (5,'007','พลังประชารัฐ');

INSERT INTO election_student(es_id,elec_id,student_id)
VALUES (1,1,2);	
INSERT INTO election_student(es_id,elec_id,student_id)
VALUES (2,2,2);
INSERT INTO election_student(es_id,elec_id,student_id)
VALUES (3,1,3);
INSERT INTO election_student(es_id,elec_id,student_id)
VALUES (3,1,4);

INSERT INTO election_candidate(ec_id,elec_id,candidate_id)
VALUES (1,1,1);
INSERT INTO election_candidate(ec_id,elec_id,candidate_id)
VALUES (2,1,2);
INSERT INTO election_candidate(ec_id,elec_id,candidate_id)
VALUES (3,1,3);
INSERT INTO election_candidate(ec_id,elec_id,candidate_id)
VALUES (4,1,4);
INSERT INTO election_candidate(ec_id,elec_id,candidate_id)
VALUES (5,1,5);


INSERT INTO student_candidate(sc_id,student_id,candidate_id)
VALUES (1,2,2);
