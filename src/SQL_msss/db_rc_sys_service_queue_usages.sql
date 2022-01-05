create view sys.service_queue_usages as
-- missing source code
go

grant select on sys.service_queue_usages to [public]
go

INSERT INTO sys.service_queue_usages (service_id, service_queue_id) VALUES (1, 1977058079);
INSERT INTO sys.service_queue_usages (service_id, service_queue_id) VALUES (2, 2009058193);
INSERT INTO sys.service_queue_usages (service_id, service_queue_id) VALUES (3, 2041058307);
