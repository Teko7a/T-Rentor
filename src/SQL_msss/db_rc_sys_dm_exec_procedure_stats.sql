create view sys.dm_exec_procedure_stats as
-- missing source code
go

INSERT INTO sys.dm_exec_procedure_stats (database_id, object_id, type, type_desc, sql_handle, plan_handle, cached_time, last_execution_time, execution_count, total_worker_time, last_worker_time, min_worker_time, max_worker_time, total_physical_reads, last_physical_reads, min_physical_reads, max_physical_reads, total_logical_writes, last_logical_writes, min_logical_writes, max_logical_writes, total_logical_reads, last_logical_reads, min_logical_reads, max_logical_reads, total_elapsed_time, last_elapsed_time, min_elapsed_time, max_elapsed_time, total_spills, last_spills, min_spills, max_spills, total_num_physical_reads, last_num_physical_reads, min_num_physical_reads, max_num_physical_reads, total_page_server_reads, last_page_server_reads, min_page_server_reads, max_page_server_reads, total_num_page_server_reads, last_num_page_server_reads, min_num_page_server_reads, max_num_page_server_reads) VALUES (32767, -450276887, N'P ', N'SQL_STORED_PROCEDURE', 0x0300FF7FE95129E56653EC00D2AA000001000000000000000000000000000000000000000000000000000000, 0x0500FF7FE95129E5D06286DB3302000001000000000000000000000000000000000000000000000000000000, N'2022-01-05 09:29:20.540', N'2022-01-05 09:29:26.653', 29, 1835, 46, 45, 265, 1, 0, 0, 1, 0, 0, 0, 0, 58, 2, 2, 2, 2112, 47, 46, 504, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0);