create view sys.dm_os_job_object as
-- missing source code
go

INSERT INTO sys.dm_os_job_object (cpu_rate, cpu_affinity_mask, cpu_affinity_group, memory_limit_mb, process_memory_limit_mb, workingset_limit_mb, non_sos_mem_gap_mb, low_mem_signal_threshold_mb, total_user_time, total_kernel_time, write_operation_count, read_operation_count, peak_process_memory_used_mb, peak_job_memory_used_mb, process_physical_affinity) VALUES (100, 255, 0, 17592186044415, null, null, 200, 200, 8762500000, 5387968750, 140667, 619629, 860, 1838, N'{{0,ff}}');
