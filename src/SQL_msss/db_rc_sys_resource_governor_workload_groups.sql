create view sys.resource_governor_workload_groups as
-- missing source code
go

INSERT INTO sys.resource_governor_workload_groups (group_id, name, importance, request_max_memory_grant_percent, request_max_cpu_time_sec, request_memory_grant_timeout_sec, max_dop, group_max_requests, pool_id, external_pool_id, request_max_memory_grant_percent_numeric) VALUES (1, N'internal', N'Medium', 25, 0, 0, 0, 0, 1, 2, 25);
INSERT INTO sys.resource_governor_workload_groups (group_id, name, importance, request_max_memory_grant_percent, request_max_cpu_time_sec, request_memory_grant_timeout_sec, max_dop, group_max_requests, pool_id, external_pool_id, request_max_memory_grant_percent_numeric) VALUES (2, N'default', N'Medium', 25, 0, 0, 0, 0, 2, 2, 25);
