create view sys.dm_exec_query_optimizer_memory_gateways as
-- missing source code
go

INSERT INTO sys.dm_exec_query_optimizer_memory_gateways (pool_id, name, max_count, active_count, waiter_count, threshold_factor, threshold, is_active) VALUES (1, N'Small Gateway', 32, 0, 0, 380000, 380000, 1);
INSERT INTO sys.dm_exec_query_optimizer_memory_gateways (pool_id, name, max_count, active_count, waiter_count, threshold_factor, threshold, is_active) VALUES (1, N'Medium Gateway', 8, 0, 0, 12, -1, 0);
INSERT INTO sys.dm_exec_query_optimizer_memory_gateways (pool_id, name, max_count, active_count, waiter_count, threshold_factor, threshold, is_active) VALUES (1, N'Big Gateway', 1, 0, 0, 8, -1, 0);
INSERT INTO sys.dm_exec_query_optimizer_memory_gateways (pool_id, name, max_count, active_count, waiter_count, threshold_factor, threshold, is_active) VALUES (2, N'Small Gateway', 32, 0, 0, 380000, 380000, 1);
INSERT INTO sys.dm_exec_query_optimizer_memory_gateways (pool_id, name, max_count, active_count, waiter_count, threshold_factor, threshold, is_active) VALUES (2, N'Medium Gateway', 8, 0, 0, 12, -1, 0);
INSERT INTO sys.dm_exec_query_optimizer_memory_gateways (pool_id, name, max_count, active_count, waiter_count, threshold_factor, threshold, is_active) VALUES (2, N'Big Gateway', 1, 0, 0, 8, -1, 0);
