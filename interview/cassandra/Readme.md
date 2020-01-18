cassandra.bat
cqlsh.bat

CREATE KEYSPACE test_keyspace WITH replication = {'class':'SimpleStrategy','replication_factor':'1'} AND durable_writes='true';
DROP KEYSPACE test_keyspace;
DESCRIBE keyspaces;
USE test_keyspace;
CREATE TABLE employee_by_id(id int PRIMARY KEY, name TEXT, position TEXT);
DROP TABLE employee_by_id;
DESCRIBE tables;
CREATE TABLE employee_by_car_make(car_make TEXT, id INT, car_model TEXT, PRIMARY KEY(car_make,id));
CREATE TABLE employee_by_car_make_sorted(car_make TEXT, age INT, id INT,car_model TEXT, PRIMARY KEY(car_make,age,id));
CREATE TABLE employee_by_car_make_and_model(car_make TEXT, car_model TEXT, id INT, name TEXT, PRIMARY KEY((car_make,car_model),id));

cqlsh:test_keyspace> CONSISTENCY
Current consistency level is ONE.
cqlsh:test_keyspace> CONSISTENCY QUORUM
Consistency level set to QUORUM.
cqlsh:test_keyspace> CONSISTENCY
Current consistency level is QUORUM.
cqlsh:test_keyspace> CONSISTENCY ONE
Consistency level set to ONE.

INSERT INTO employee_by_id(id,name,position) VALUES(1,'John','Manager');
INSERT INTO employee_by_id(id,name,position) VALUES(2,'Bob','CEO');

select * from employee_by_id;
select * from employee_by_id where id=1;
cqlsh:test_keyspace> select * from employee_by_id where name='Bob';
InvalidRequest: Error from server: code=2200 [Invalid query] message="Cannot execute this query as it might involve data filtering and thus may have unpredictable performance. If you want to execute this query despite the performance unpredictability, use ALLOW FILTERING"
cqlsh:test_keyspace>

INSERT INTO employee_by_car_make(car_make,id,car_model) VALUES('BMW',1,'Sports Car');
INSERT INTO employee_by_car_make(car_make,id,car_model) VALUES('BMW',2,'Sports Car');
INSERT INTO employee_by_car_make(car_make,id,car_model) VALUES('AUDI',3,'Truck');
INSERT INTO employee_by_car_make(car_make,id,car_model) VALUES('AUDI',4,'Hatchback');
select * from employee_by_car_make;
select * from employee_by_car_make where car_make='BMW';
select * from employee_by_car_make where car_make='BMW' order by id;

cqlsh:test_keyspace> select * from employee_by_car_make where id=1;
InvalidRequest: Error from server: code=2200 [Invalid query] message="Cannot execute this query as it might involve data filtering and thus may have unpredictable performance. If you want to execute this query despite the performance unpredictability, use ALLOW FILTERING"
cqlsh:test_keyspace> 
cqlsh:test_keyspace> select * from employee_by_car_make where car_make='BMW' order by car_model;
InvalidRequest: Error from server: code=2200 [Invalid query] message="Order by is currently only supported on the clustered columns of the PRIMARY KEY, got car_model" 

INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('BMW','HATCHBACK',1,'John');
cqlsh:test_keyspace> INSERT INTO employee_by_car_make_and_model (car_make,id,name) VALUES('BMW',1,'John');
InvalidRequest: Error from server: code=2200 [Invalid query] message="Some partition key parts are missing: car_model"
cqlsh:test_keyspace>
cqlsh:test_keyspace> INSERT INTO employee_by_car_make_and_model (car_make,car_model,name) VALUES('BMW','HATCHBACK','John');
InvalidRequest: Error from server: code=2200 [Invalid query] message="Some clustering keys are missing: id"

INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('BMW','HATCHBACK',1,'Bob'); <-- Name is Bob instead of John. It will replace John with Bob

INSERT INTO employee_by_car_make_and_model (car_make,car_model,id) VALUES('BMW','HATCHBACK',2); <-- this will insert a record with 'null' name.
INSERT INTO employee_by_car_make_and_model (car_make,car_model,id) VALUES('AUDI','HATCHBACK',3);
INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('AUDI','SPORTS CAR',4,'Tim');
INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('AUDI','SPORTS CAR',5,'Jim');
INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('AUDI','SPORTS CAR',6,'Nick');
INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('AUDI','TRUCK',7,'Amy');
INSERT INTO employee_by_car_make_and_model (car_make,car_model,id,name) VALUES('BMW','TRUCK',8,'Tim');

cqlsh:test_keyspace> select * from employee_by_car_make_and_model WHERE car_make='BMW';
InvalidRequest: Error from server: code=2200 [Invalid query] message="Cannot execute this query as it might involve data filtering and thus may have unpredictable performance. If you want to execute this query despite the performance unpredictability, use ALLOW FILTERING"

select * from employee_by_car_make_and_model WHERE car_make='BMW' and car_model='HATCHBACK';


select car_make,car_model,writetime(car_model) from employee_by_car_make;
UPDATE employee_by_car_make SET car_model='TRUCK' WHERE car_make='BMW' AND id=1;

TTL
------------------
UPDATE employee_by_car_make USING TTL 60 SET car_model='TRUCK'  WHERE car_make='BMW' and id=2;

Lists
------------------
ALTER TABLE employee_by_id ADD phone set<text>;
UPDATE employee_by_id SET phone={'123','345'} WHERE id=1;
UPDATE employee_by_id SET phone=phone + {'555'} WHERE id=1;
UPDATE employee_by_id SET phone=phone - {'555'} WHERE id=1;
UPDATE employee_by_id SET phone={} WHERE id=1;

SECONDARY INDEX
--------------
SELECT * from employee_by_id WHERE name='John' ALLOW FILTERING;
CREATE INDEX ON employee_by_id(name);
 