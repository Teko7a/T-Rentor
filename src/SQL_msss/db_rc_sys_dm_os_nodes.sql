create view sys.dm_os_nodes as
-- missing source code
go

INSERT INTO sys.dm_os_nodes (node_id, node_state_desc, memory_object_address, memory_clerk_address, io_completion_worker_address, memory_node_id, cpu_affinity_mask, online_scheduler_count, idle_scheduler_count, active_worker_count, avg_load_balance, timer_task_affinity_mask, permanent_task_affinity_mask, resource_monitor_state, online_scheduler_mask, processor_group, cpu_count) VALUES (0, N'ONLINE', 0x00000233DB032040, 0x00000233DB02AC90, 0x00000233DB800160, 0, 255, 8, 8, 30, 3, 252, 241, 1, 255, 0, 8);
