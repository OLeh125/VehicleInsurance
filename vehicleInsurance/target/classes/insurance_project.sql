DROP TABLE IF EXISTS o_insurance_order;
DROP TABLE IF EXISTS o_country_struct;
DROP TABLE IF EXISTS o_street;

CREATE TABLE o_street(
                         street_code integer not null,
                         street_name varchar(300),
                         PRIMARY KEY(street_code)
);


CREATE TABLE o_country_struct(
                                 area_id char(12) not null,
                                 area_name varchar(200),
                                 PRIMARY KEY (area_id)
);


CREATE TABLE o_insurance_order(
                                  insurance_order_id SERIAL,
                                  costumer_name varchar(100) not null,
                                  costumer_last_name varchar(100) not null,
                                  costumer_patronymic varchar(100) not null,
                                  costumer_mobile_phone varchar(15) not null,
                                  costumer_email varchar(100) not null,
                                  costumer_individual_taxpayer_id char(12) not null,
                                  costumer_post_index varchar(10),
                                  costumer_street_code integer not null,
                                  costumer_building varchar(10) not null,
                                  costumer_extension varchar(10),
                                  costumer_apartment varchar(10),
                                  vehicle_year_of_production integer not null,
                                  vehicle_brand varchar(100) not null,
                                  vehicle_model varchar(100) not null,
                                  vehicle_identification_number char(17) not null ,
                                  vehicle_state_number varchar(10) not null,
                                  PRIMARY KEY (insurance_order_id),
                                  FOREIGN KEY (costumer_street_code) REFERENCES o_street(street_code) ON DELETE RESTRICT
);


INSERT INTO o_street(street_code, street_name) VALUES (1,'Street First'),(2,'Street Second'),(3,'Street Third');
SELECT * FROM o_street;
UPDATE o_street SET street_name = 'First Street' WHERE street_code = 1;