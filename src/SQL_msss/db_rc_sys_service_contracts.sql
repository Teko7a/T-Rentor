create view sys.service_contracts as
-- missing source code
go

grant select on sys.service_contracts to [public]
go

INSERT INTO sys.service_contracts (name, service_contract_id, principal_id) VALUES (N'DEFAULT', 6, 1);
INSERT INTO sys.service_contracts (name, service_contract_id, principal_id) VALUES (N'http://schemas.microsoft.com/SQL/Notifications/PostEventNotification', 2, 1);
INSERT INTO sys.service_contracts (name, service_contract_id, principal_id) VALUES (N'http://schemas.microsoft.com/SQL/Notifications/PostQueryNotification', 1, 1);
INSERT INTO sys.service_contracts (name, service_contract_id, principal_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/BrokerConfigurationNotice', 3, 1);
INSERT INTO sys.service_contracts (name, service_contract_id, principal_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceDiagnostic', 5, 1);
INSERT INTO sys.service_contracts (name, service_contract_id, principal_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceEcho', 4, 1);
