create view sys.dm_exec_session_wait_stats as
-- missing source code
go

INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PAGEIOLATCH_SH', 126, 24, 2, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PAGEIOLATCH_EX', 14, 2, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'SLEEP_TASK', 117, 1754, 23, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'SOS_SCHEDULER_YIELD', 3, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'MEMORY_ALLOCATION_EXT', 2408, 9, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'IO_COMPLETION', 10, 3, 1, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'WRITELOG', 45, 11, 3, 1);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_AUTHENTICATIONOPS', 8, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_AUTHORIZATIONOPS', 4, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_REVERTTOSELF', 4, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_FILEOPS', 15, 14, 2, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_CREATEFILE', 5, 2, 1, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_FILESIZEGET', 4, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_GETFILEATTRIBUTES', 5, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_WRITEFILEGATHER', 1, 1, 1, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_REPORTEVENT', 3, 1, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PREEMPTIVE_OS_QUERYREGISTRY', 13, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (51, N'PARALLEL_REDO_WORKER_SYNC', 1, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (52, N'PAGELATCH_SH', 1, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (52, N'PAGELATCH_EX', 1, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (52, N'PAGEIOLATCH_SH', 76, 10, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (52, N'PAGEIOLATCH_EX', 6, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (52, N'MEMORY_ALLOCATION_EXT', 338, 1, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (52, N'WRITELOG', 3, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (53, N'PAGEIOLATCH_SH', 2, 2, 2, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (53, N'MEMORY_ALLOCATION_EXT', 68, 0, 0, 0);
INSERT INTO sys.dm_exec_session_wait_stats (session_id, wait_type, waiting_tasks_count, wait_time_ms, max_wait_time_ms, signal_wait_time_ms) VALUES (60, N'MEMORY_ALLOCATION_EXT', 44, 0, 0, 0);
