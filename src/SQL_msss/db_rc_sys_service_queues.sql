create view sys.service_queues as
-- missing source code
go

grant select on sys.service_queues to [public]
go

INSERT INTO sys.service_queues (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, max_readers, activation_procedure, execute_as_principal_id, is_activation_enabled, is_receive_enabled, is_enqueue_enabled, is_retention_enabled, is_poison_message_handling_enabled) VALUES (N'QueryNotificationErrorsQueue', 1977058079, null, 1, 0, N'SQ', N'SERVICE_QUEUE', N'2009-04-13 12:59:13.483', N'2009-04-13 12:59:13.483', 1, 0, 0, 0, null, null, 0, 1, 1, 0, 0);
INSERT INTO sys.service_queues (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, max_readers, activation_procedure, execute_as_principal_id, is_activation_enabled, is_receive_enabled, is_enqueue_enabled, is_retention_enabled, is_poison_message_handling_enabled) VALUES (N'EventNotificationErrorsQueue', 2009058193, null, 1, 0, N'SQ', N'SERVICE_QUEUE', N'2009-04-13 12:59:13.500', N'2009-04-13 12:59:13.500', 1, 0, 0, 0, null, null, 0, 1, 1, 0, 0);
INSERT INTO sys.service_queues (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, max_readers, activation_procedure, execute_as_principal_id, is_activation_enabled, is_receive_enabled, is_enqueue_enabled, is_retention_enabled, is_poison_message_handling_enabled) VALUES (N'ServiceBrokerQueue', 2041058307, null, 1, 0, N'SQ', N'SERVICE_QUEUE', N'2009-04-13 12:59:13.500', N'2009-04-13 12:59:13.500', 1, 0, 0, 0, null, null, 0, 1, 1, 0, 0);
