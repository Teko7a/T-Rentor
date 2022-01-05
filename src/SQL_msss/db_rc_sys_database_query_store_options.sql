create view sys.database_query_store_options as
-- missing source code
go

INSERT INTO sys.database_query_store_options (desired_state, desired_state_desc, actual_state, actual_state_desc, readonly_reason, current_storage_size_mb, flush_interval_seconds, interval_length_minutes, max_storage_size_mb, stale_query_threshold_days, max_plans_per_query, query_capture_mode, query_capture_mode_desc, capture_policy_execution_count, capture_policy_total_compile_cpu_time_ms, capture_policy_total_execution_cpu_time_ms, capture_policy_stale_threshold_hours, size_based_cleanup_mode, size_based_cleanup_mode_desc, wait_stats_capture_mode, wait_stats_capture_mode_desc, actual_state_additional_info) VALUES (0, N'OFF', 0, N'OFF', 0, 0, 900, 60, 1000, 30, 200, 2, N'AUTO', null, null, null, null, 1, N'AUTO', 1, N'ON', N'');
