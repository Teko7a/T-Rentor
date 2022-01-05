create view sys.dm_resource_governor_configuration as
-- missing source code
go

INSERT INTO sys.dm_resource_governor_configuration (classifier_function_id, is_reconfiguration_pending, max_outstanding_io_per_volume) VALUES (0, 0, 10);
