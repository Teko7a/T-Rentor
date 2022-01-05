create view sys.resource_governor_resource_pools as
-- missing source code
go

INSERT INTO sys.resource_governor_resource_pools (pool_id, name, min_cpu_percent, max_cpu_percent, min_memory_percent, max_memory_percent, cap_cpu_percent, min_iops_per_volume, max_iops_per_volume) VALUES (1, N'internal', 0, 100, 0, 100, 100, 0, 0);
INSERT INTO sys.resource_governor_resource_pools (pool_id, name, min_cpu_percent, max_cpu_percent, min_memory_percent, max_memory_percent, cap_cpu_percent, min_iops_per_volume, max_iops_per_volume) VALUES (2, N'default', 0, 100, 0, 100, 100, 0, 0);
