create view sys.service_message_types as
-- missing source code
go

grant select on sys.service_message_types to [public]
go

INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/Error', 1, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/EndDialog', 2, 1, N'E ', N'EMPTY', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/Notifications/QueryNotification', 3, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/Notifications/EventNotification', 4, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/DialogTimer', 5, 1, N'E ', N'EMPTY', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/BrokerConfigurationNotice/MissingRoute', 6, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/BrokerConfigurationNotice/FailedRoute', 7, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/BrokerConfigurationNotice/MissingRemoteServiceBinding', 8, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/BrokerConfigurationNotice/FailedRemoteServiceBinding', 9, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceEcho/Echo', 10, 1, N'N ', N'BINARY', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceDiagnostic/Query', 11, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceDiagnostic/Status', 12, 1, N'X ', N'XML', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'http://schemas.microsoft.com/SQL/ServiceBroker/ServiceDiagnostic/Description', 13, 1, N'N ', N'BINARY', null);
INSERT INTO sys.service_message_types (name, message_type_id, principal_id, validation, validation_desc, xml_collection_id) VALUES (N'DEFAULT', 14, 1, N'N ', N'BINARY', null);
