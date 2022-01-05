create view sys.dm_os_sys_memory as
-- missing source code
go

INSERT INTO sys.dm_os_sys_memory (total_physical_memory_kb, available_physical_memory_kb, total_page_file_kb, available_page_file_kb, system_cache_kb, kernel_paged_pool_kb, kernel_nonpaged_pool_kb, system_high_memory_signal_state, system_low_memory_signal_state, system_memory_state_desc) VALUES (8229672, 1019424, 17111852, 3576200, 321768, 321152, 615280, 0, 0, N'Physical memory usage is steady');
