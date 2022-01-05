create view sys.routes as
-- missing source code
go

grant select on sys.routes to [public]
go

INSERT INTO sys.routes (name, route_id, principal_id, remote_service_name, broker_instance, lifetime, address, mirror_address) VALUES (N'AutoCreatedLocal', 65536, 1, null, null, null, N'LOCAL', null);
