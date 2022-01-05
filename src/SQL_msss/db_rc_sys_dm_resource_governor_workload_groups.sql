create view sys.dm_resource_governor_workload_groups as
-- missing source code
go

INSERT INTO sys.dm_resource_governor_workload_groups (group_id, name, pool_id, external_pool_id, statistics_start_time, total_request_count, total_queued_request_count, active_request_count, queued_request_count, total_cpu_limit_violation_count, total_cpu_usage_ms, max_request_cpu_time_ms, blocked_task_count, total_lock_wait_count, total_lock_wait_time_ms, total_query_optimization_count, total_suboptimal_plan_generation_count, total_reduced_memgrant_count, max_request_grant_memory_kb, active_parallel_thread_count, importance, request_max_memory_grant_percent, request_max_cpu_time_sec, request_memory_grant_timeout_sec, group_max_requests, max_dop, effective_max_dop, total_cpu_usage_preemptive_ms, request_max_memory_grant_percent_numeric) VALUES (1, N'internal', 1, 2, N'2022-01-05 08:55:47.047', 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1221, 20, 0, 0, 0, N'Medium', 25, 0, 0, 0, 0, 8, 0, 25);
