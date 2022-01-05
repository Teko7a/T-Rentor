create view sys.dm_tcp_listener_states as
-- missing source code
go

INSERT INTO sys.dm_tcp_listener_states (listener_id, ip_address, is_ipv4, port, type, type_desc, state, state_desc, start_time) VALUES (1, N'::', 0, 1433, 0, N'TSQL', 0, N'ONLINE', N'2022-01-05 00:55:47.620');
INSERT INTO sys.dm_tcp_listener_states (listener_id, ip_address, is_ipv4, port, type, type_desc, state, state_desc, start_time) VALUES (2, N'0.0.0.0', 1, 1433, 0, N'TSQL', 0, N'ONLINE', N'2022-01-05 00:55:47.620');
INSERT INTO sys.dm_tcp_listener_states (listener_id, ip_address, is_ipv4, port, type, type_desc, state, state_desc, start_time) VALUES (3, N'::', 0, 52224, 0, N'TSQL', 0, N'ONLINE', N'2022-01-05 00:55:47.620');
INSERT INTO sys.dm_tcp_listener_states (listener_id, ip_address, is_ipv4, port, type, type_desc, state, state_desc, start_time) VALUES (4, N'0.0.0.0', 1, 52224, 0, N'TSQL', 0, N'ONLINE', N'2022-01-05 00:55:47.620');
