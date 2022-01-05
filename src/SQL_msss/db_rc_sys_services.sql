create view sys.services as
-- missing source code
go

grant select on sys.services to [public]
go

INSERT INTO sys.services (name, service_id, principal_id, service_queue_id) VALUES (N'http://schemas.microsoft.com/SQL/Notifications/EventNotificationService', 2, 1, 2009058193);
INSERT INTO sys.services (name, service_id, principal_id, service_queue_id) VALUES (N'http://schemas.microsoft.com/SQL/Notifications/QueryNotificationService', 1, 1, 1977058079);
INSERT INTO sys.services (name, service_id, principal_id, service_queue_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceBroker', 3, 1, 2041058307);
