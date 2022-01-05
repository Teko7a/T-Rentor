create view sys.dm_clr_tasks as
-- missing source code
go

INSERT INTO sys.dm_clr_tasks (task_address, sos_task_address, appdomain_address, state, abort_state, type, affinity_count, forced_yield_count) VALUES (0x00000233D326E040, 0x00000233D326A4E8, 0x0000000000000000, N'E_TASK_ATTACHED_TO_CLR', N'E_ABORT_NONE', N'E_TYPE_ADUNLOAD', 0, 0);
INSERT INTO sys.dm_clr_tasks (task_address, sos_task_address, appdomain_address, state, abort_state, type, affinity_count, forced_yield_count) VALUES (0x00000233D5BF4040, 0x00000233D5BEE4E8, 0x0000000000000000, N'E_TASK_ATTACHED_TO_CLR', N'E_ABORT_NONE', N'E_TYPE_FINALIZER', 0, 0);
