create view sys.dm_os_memory_node_access_stats as
-- missing source code
go

INSERT INTO sys.dm_os_memory_node_access_stats (local_node, remote_node, page_class, read_count, write_count) VALUES (0, 0, N'DATA_PAGE', 2421747818496, 2421741002816);
INSERT INTO sys.dm_os_memory_node_access_stats (local_node, remote_node, page_class, read_count, write_count) VALUES (0, 0, N'INDEX_PAGE', 2421747810304, 8192);
INSERT INTO sys.dm_os_memory_node_access_stats (local_node, remote_node, page_class, read_count, write_count) VALUES (0, 0, N'QE_PAGE', 2419707676352, 0);
INSERT INTO sys.dm_os_memory_node_access_stats (local_node, remote_node, page_class, read_count, write_count) VALUES (0, 0, N'MAP_PAGE', 4, 8192);
INSERT INTO sys.dm_os_memory_node_access_stats (local_node, remote_node, page_class, read_count, write_count) VALUES (0, 0, N'TEXT_PAGE', 14073972177109045, 14355223815913528);
INSERT INTO sys.dm_os_memory_node_access_stats (local_node, remote_node, page_class, read_count, write_count) VALUES (0, 0, N'OTHER_PAGE', 14636939310268465, 53);
