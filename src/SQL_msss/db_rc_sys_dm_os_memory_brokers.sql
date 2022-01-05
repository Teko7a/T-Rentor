create view sys.dm_os_memory_brokers as
-- missing source code
go

INSERT INTO sys.dm_os_memory_brokers (pool_id, memory_broker_type, allocations_kb, allocations_kb_per_sec, predicted_allocations_kb, target_allocations_kb, future_allocations_kb, overall_limit_kb, last_notification) VALUES (1, N'MEMORYBROKER_FOR_CACHE', 30872, 390, 32432, 498528, 0, 675464, N'GROW');
INSERT INTO sys.dm_os_memory_brokers (pool_id, memory_broker_type, allocations_kb, allocations_kb_per_sec, predicted_allocations_kb, target_allocations_kb, future_allocations_kb, overall_limit_kb, last_notification) VALUES (1, N'MEMORYBROKER_FOR_STEAL', 98112, 6, 98136, 564232, 0, 675464, N'GROW');
INSERT INTO sys.dm_os_memory_brokers (pool_id, memory_broker_type, allocations_kb, allocations_kb_per_sec, predicted_allocations_kb, target_allocations_kb, future_allocations_kb, overall_limit_kb, last_notification) VALUES (1, N'MEMORYBROKER_FOR_RESERVE', 0, 0, 151072, 617168, 151080, 675464, N'GROW');
INSERT INTO sys.dm_os_memory_brokers (pool_id, memory_broker_type, allocations_kb, allocations_kb_per_sec, predicted_allocations_kb, target_allocations_kb, future_allocations_kb, overall_limit_kb, last_notification) VALUES (1, N'MEMORYBROKER_FOR_COMMITTED', 50328, 0, 50328, 516424, 0, 675464, N'GROW');
INSERT INTO sys.dm_os_memory_brokers (pool_id, memory_broker_type, allocations_kb, allocations_kb_per_sec, predicted_allocations_kb, target_allocations_kb, future_allocations_kb, overall_limit_kb, last_notification) VALUES (1, N'MEMORYBROKER_FOR_HASHED_DATA_PAGES', 0, 0, 0, 466096, 0, 675464, N'GROW');
INSERT INTO sys.dm_os_memory_brokers (pool_id, memory_broker_type, allocations_kb, allocations_kb_per_sec, predicted_allocations_kb, target_allocations_kb, future_allocations_kb, overall_limit_kb, last_notification) VALUES (1, N'MEMORYBROKER_FOR_XTP', 2488, 0, 2488, 468584, 0, 675464, N'GROW');
