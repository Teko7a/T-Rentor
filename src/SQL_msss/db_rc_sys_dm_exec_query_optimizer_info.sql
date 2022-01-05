create view sys.dm_exec_query_optimizer_info as
-- missing source code
go

INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'optimizations', 1089, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'elapsed time', 1089, 0.0018365472910927456);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'final cost', 1089, 0.07598126639554427);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'trivial plan', 168, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'tasks', 921, 821.0933767643866);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'no plan', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 0', 436, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 0 time', 441, 0.0073265306122448975);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 0 tasks', 441, 1278.7573696145125);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 1', 484, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 1 time', 495, 0.002426262626262627);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 1 tasks', 495, 381.5010101010101);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 2', 1, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 2 time', 1, 0.008);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'search 2 tasks', 1, 3452);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'gain stage 0 to stage 1', 3, 0.5144412747477703);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'gain stage 1 to stage 2', 1, 0.000887595660087964);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'timeout', 20, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'memory limit exceeded', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'insert stmt', 29, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'delete stmt', 2, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'update stmt', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'merge stmt', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'contains subquery', 74, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'unnest failed', 591, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'tables', 1089, 5.943067033976125);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'hints', 9, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'order hint', 9, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'join hint', 9, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'view reference', 887, 1);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'remote query', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'maximum DOP', 1089, 1.4104683195592287);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'maximum recursion level', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'indexed views loaded', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'indexed views matched', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'indexed views used', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'indexed views updated', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'dynamic cursor request', 0, null);
INSERT INTO sys.dm_exec_query_optimizer_info (counter, occurrence, value) VALUES (N'fast forward cursor request', 0, null);
