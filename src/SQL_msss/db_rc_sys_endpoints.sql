create view sys.endpoints as
-- missing source code
go

INSERT INTO sys.endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint) VALUES (N'Dedicated Admin Connection', 1, 1, 2, N'TCP', 2, N'TSQL', 0, N'STARTED', 1);
INSERT INTO sys.endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint) VALUES (N'TSQL Local Machine', 2, 1, 4, N'SHARED_MEMORY', 2, N'TSQL', 0, N'STARTED', 0);
INSERT INTO sys.endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint) VALUES (N'TSQL Named Pipes', 3, 1, 3, N'NAMED_PIPES', 2, N'TSQL', 0, N'STARTED', 0);
INSERT INTO sys.endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint) VALUES (N'TSQL Default TCP', 4, 1, 2, N'TCP', 2, N'TSQL', 0, N'STARTED', 0);
INSERT INTO sys.endpoints (name, endpoint_id, principal_id, protocol, protocol_desc, type, type_desc, state, state_desc, is_admin_endpoint) VALUES (N'TSQL Default VIA', 5, 1, 5, N'VIA', 2, N'TSQL', 0, N'STARTED', 0);
