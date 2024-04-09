
CREATE TABLE equipment_oee (
       serial_no bigint NOT NULL,
       equipment_id nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
       statistics_cycle nvarchar(10) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
       statistics_time nvarchar(100) COLLATE SQL_Latin1_General_CP1_CI_AS NOT NULL,
       oee_ratio float DEFAULT NULL NULL,
       availability float DEFAULT NULL NULL,
       effectiveness_performance float DEFAULT NULL NULL,
       quality_ratio float DEFAULT NULL NULL,
       actual_production_time bigint DEFAULT NULL NULL,
       plan_occupancy_time bigint DEFAULT NULL NULL,
       beat_time float DEFAULT NULL NULL,
       produced_quantity int DEFAULT NULL NULL,
       good_quantity int DEFAULT NULL NULL,
       CONSTRAINT PK_equipment_oee_serial_no PRIMARY KEY (serial_no)
);