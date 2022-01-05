create view sys.dm_os_dispatcher_pools as
-- missing source code
go

INSERT INTO sys.dm_os_dispatcher_pools (dispatcher_pool_address, type, name, dispatcher_count, dispatcher_ideal_count, dispatcher_timeout_ms, dispatcher_waiting_count, queue_length) VALUES (0x00000233DB80E830, N'DISP_POOL_XE_ENGINE', N'XE Engine main dispatcher pool', 1, 0, 30000, 0, 0);
INSERT INTO sys.dm_os_dispatcher_pools (dispatcher_pool_address, type, name, dispatcher_count, dispatcher_ideal_count, dispatcher_timeout_ms, dispatcher_waiting_count, queue_length) VALUES (0x00000233D52843A0, N'DISP_POOL_XTP', N'XTP non-preemptive', 0, 0, 10000, 0, 0);
INSERT INTO sys.dm_os_dispatcher_pools (dispatcher_pool_address, type, name, dispatcher_count, dispatcher_ideal_count, dispatcher_timeout_ms, dispatcher_waiting_count, queue_length) VALUES (0x00000233D52863A0, N'DISP_POOL_XTP', N'XTP non-preemptive workers', 0, 0, 10000, 0, 0);
INSERT INTO sys.dm_os_dispatcher_pools (dispatcher_pool_address, type, name, dispatcher_count, dispatcher_ideal_count, dispatcher_timeout_ms, dispatcher_waiting_count, queue_length) VALUES (0x00000233D52883A0, N'DISP_POOL_XTP', N'XTP non-preemptive redo workers', 0, 0, 10000, 0, 0);
INSERT INTO sys.dm_os_dispatcher_pools (dispatcher_pool_address, type, name, dispatcher_count, dispatcher_ideal_count, dispatcher_timeout_ms, dispatcher_waiting_count, queue_length) VALUES (0x00000233D528A3A0, N'DISP_POOL_XTP', N'XTP preemptive', 0, 0, 10000, 0, 0);
