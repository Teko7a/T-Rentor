create view sys.server_event_sessions as
-- missing source code
go

INSERT INTO sys.server_event_sessions (event_session_id, name, event_retention_mode, event_retention_mode_desc, max_dispatch_latency, max_memory, max_event_size, memory_partition_mode, memory_partition_mode_desc, track_causality, startup_state, has_long_running_target) VALUES (65536, N'system_health', N'S', N'ALLOW_SINGLE_EVENT_LOSS', 120000, 4096, 0, N'G', N'NONE', 0, 1, 0);
INSERT INTO sys.server_event_sessions (event_session_id, name, event_retention_mode, event_retention_mode_desc, max_dispatch_latency, max_memory, max_event_size, memory_partition_mode, memory_partition_mode_desc, track_causality, startup_state, has_long_running_target) VALUES (65537, N'AlwaysOn_health', N'S', N'ALLOW_SINGLE_EVENT_LOSS', 30000, 4096, 0, N'G', N'NONE', 0, 0, 0);
INSERT INTO sys.server_event_sessions (event_session_id, name, event_retention_mode, event_retention_mode_desc, max_dispatch_latency, max_memory, max_event_size, memory_partition_mode, memory_partition_mode_desc, track_causality, startup_state, has_long_running_target) VALUES (65552, N'telemetry_xevents', N'S', N'ALLOW_SINGLE_EVENT_LOSS', 120000, 4096, 0, N'G', N'NONE', 0, 1, 0);
