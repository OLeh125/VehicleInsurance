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
                                  insurance_order_status integer,
                                  insurance_order_date timestamp not null,
                                  costumer_name varchar(100) not null,
                                  costumer_last_name varchar(100) not null,
                                  costumer_patronymic varchar(100) not null,
                                  costumer_mobile_phone varchar(100) not null,
                                  costumer_email varchar(100) not null,
                                  costumer_individual_taxpayer_id varchar(100) not null,
                                  costumer_post_index varchar(100),
                                  costumer_street_code integer not null,
                                  costumer_building varchar(100) not null,
                                  costumer_extension varchar(100),
                                  costumer_apartment varchar(100),
                                  vehicle_year_of_production integer not null,
                                  vehicle_brand varchar(100) not null,
                                  vehicle_model varchar(100) not null,
                                  vehicle_identification_number varchar(100) not null ,
                                  vehicle_state_number varchar(100) not null,
                                  PRIMARY KEY (insurance_order_id),
                                  FOREIGN KEY (costumer_street_code) REFERENCES o_street(street_code) ON DELETE RESTRICT
);

