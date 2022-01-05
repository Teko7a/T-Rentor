create view sys.dm_fts_memory_pools as
-- missing source code
go

INSERT INTO sys.dm_fts_memory_pools (pool_id, buffer_size, min_buffer_limit, max_buffer_limit, buffer_count) VALUES (0, 262144, 0, 100, 0);
INSERT INTO sys.dm_fts_memory_pools (pool_id, buffer_size, min_buffer_limit, max_buffer_limit, buffer_count) VALUES (1, 1048576, 0, 100, 0);
