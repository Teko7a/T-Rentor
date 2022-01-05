create view sys.tcp_endpoints as
-- missing source code
go

INSERT INTO sys.tcp_endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint, port, is_dynamic_port, ip_address) VALUES (N'Dedicated Admin Connection', 1, 1, 2, N'TCP', 2, N'TSQL', 0, N'STARTED', 1, 0, 1, null);
INSERT INTO sys.tcp_endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint, port, is_dynamic_port, ip_address) VALUES (N'TSQL Default TCP', 4, 1, 2, N'TCP', 2, N'TSQL', 0, N'STARTED', 0, 0, 1, null);
