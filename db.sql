-- DROP database abc_lab_db1;
-- DROP user lab_user;
--
 CREATE user lab_user WITH password  'password';

CREATE  database abc_lab_db1 WITH  TEMPLATE = template0 owner =lab_user;
\c  abc_lab_db1;
--
-- ALTER DEFAULT PRIVILEGES GRANT ALL ON TABLES TO lab_user;
-- ALTER DEFAULT PRIVILEGES GRANT ALL ON SEQUENCES TO lab_user;

-- tables
--  user / appointment /  recode

CREATE TABLE "user"(
    user_id INTEGER PRIMARY KEY NOT NULL,
    first_name VARCHAR(20)  NOT NULL,
    last_name VARCHAR(20) NOT NULL,
    email VARCHAR(30) NOT NULL ,
    password    TEXT  NOT NULL,
    age INTEGER NOT NULL ,
    is_staff  BOOLEAN DEFAULT false NOT NULL
);

CREATE TABLE  "test"(
     test_id INTEGER PRIMARY KEY  NOT NULL,
     user_id INTEGER NOT NULL,
     is_urgent BOOLEAN DEFAULT false,
     description    TEXT  NOT NULL,
     test_result text NOT NULL,
     is_progress BOOLEAN DEFAULT false,
     is_finished BOOLEAN DEFAULT false,
     test_created_time TIMESTAMP NOT NULL

);

ALTER TABLE test ADD CONSTRAINT te_user_fk
FOREIGN KEY (user_id) REFERENCES "user"(user_id);


CREATE TABLE  "appointment"(
        appointment_id INTEGER UNIQUE  NOT NULL,
        user_id INTEGER NOT NULL,
        test_id INTEGER NOT NULL,
        description    TEXT  NOT NULL,
        appointment_time TIMESTAMP NOT NULL,
        next_appointment TIMESTAMP
);

ALTER TABLE appointment ADD CONSTRAINT a_user_fk
    FOREIGN KEY (user_id) REFERENCES "user"(user_id);


ALTER TABLE appointment ADD CONSTRAINT a_test_fk
    FOREIGN KEY (test_id) REFERENCES "test"(test_id);


CREATE TABLE  "payment"(
         payment_id INTEGER PRIMARY KEY  NOT NULL,
         test_id INTEGER  NOT NULL,
         user_id INTEGER NOT NULL,
         is_payed BOOLEAN DEFAULT false,
         amount INTEGER NOT NULL ,
         payment_created_time TIMESTAMP NOT NULL

);

ALTER TABLE payment ADD CONSTRAINT p_user_fk
    FOREIGN KEY (user_id) REFERENCES "user"(user_id);


ALTER TABLE payment ADD CONSTRAINT p_test_fk
    FOREIGN KEY (test_id) REFERENCES test(test_id);


CREATE TABLE recode(
    recode_id INTEGER PRIMARY KEY NOT NULL,
    test_id INTEGER   NOT NULL,
    appointment_id INTEGER NOT NULL ,
    user_id INTEGER NOT NULL,
    is_urgent BOOLEAN DEFAULT false,
    description    TEXT  NOT NULL,
    test_result text NOT NULL,
    recode_crete_at TIMESTAMP NOT NULL
);

ALTER TABLE recode ADD CONSTRAINT re_user_fk
FOREIGN KEY (user_id) REFERENCES "user"(user_id);

ALTER TABLE recode ADD CONSTRAINT re_test_fk
    FOREIGN KEY (test_id) REFERENCES "test"(test_id);

ALTER TABLE recode ADD CONSTRAINT re_app_fk
    FOREIGN KEY (appointment_id) REFERENCES "appointment"(appointment_id);

--CREATE SEQUENCE user_seq START 1
-- TEST

SELECT T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED, T.TEST_CREATED_TIME

            FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID
            WHERE T.USER_ID = ? GROUP BY A.TEST_ID



SELECT T.TEST_ID, T.USER_ID, T.IS_URGENT, T.DESCRIPTION, T.TEST_RESULT, T.IS_PROGRESS,T.IS_FINISHED, T.TEST_CREATED_TIME,
            FROM APPOINTMENT A RIGHT OUTER JOIN TEST T ON T.TEST_ID = A.TEST_ID
            WHERE T.USER_ID = ? AND T.TEST_ID = ? GROUP BY T.TEST_ID