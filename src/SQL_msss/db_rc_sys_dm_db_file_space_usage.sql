create view sys.dm_db_file_space_usage as
-- missing source code
go

INSERT INTO sys.dm_db_file_space_usage (database_id, file_id, filegroup_id, total_page_count, allocated_extent_page_count, unallocated_extent_page_count, version_store_reserved_page_count, user_object_reserved_page_count, internal_object_reserved_page_count, mixed_extent_page_count, modified_extent_page_count) VALUES (5, 1, 1, 1024, 448, 576, null, null, null, 192, 0);
