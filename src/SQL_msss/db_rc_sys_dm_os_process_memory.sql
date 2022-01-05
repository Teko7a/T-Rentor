create view sys.dm_os_process_memory as
-- missing source code
go

INSERT INTO sys.dm_os_process_memory (physical_memory_in_use_kb, large_page_allocations_kb, locked_page_allocations_kb, total_virtual_address_space_kb, virtual_address_space_reserved_kb, virtual_address_space_committed_kb, virtual_address_space_available_kb, page_fault_count, memory_utilization_percentage, available_commit_limit_kb, process_physical_memory_low, process_virtual_memory_low) VALUES (154224, 0, 0, 137438953344, 15309912, 376200, 137423643432, 275331, 78, 3574636, 1, 0);
