create view sys.foreign_keys as
-- missing source code
go

grant select on sys.foreign_keys to [public]
go

INSERT INTO sys.foreign_keys (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, referenced_object_id, key_index_id, is_disabled, is_not_for_replication, is_not_trusted, delete_referential_action, delete_referential_action_desc, update_referential_action, update_referential_action_desc, is_system_named) VALUES (N't_rented_t_car_id_fk', 981578535, null, 1, 949578421, N'F ', N'FOREIGN_KEY_CONSTRAINT', N'2022-01-05 09:19:05.667', N'2022-01-05 09:19:05.667', 0, 0, 0, 901578250, 1, 0, 0, 0, 0, N'NO_ACTION', 0, N'NO_ACTION', 0);
INSERT INTO sys.foreign_keys (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, referenced_object_id, key_index_id, is_disabled, is_not_for_replication, is_not_trusted, delete_referential_action, delete_referential_action_desc, update_referential_action, update_referential_action_desc, is_system_named) VALUES (N't_rented_t_user_id_fk', 997578592, null, 1, 949578421, N'F ', N'FOREIGN_KEY_CONSTRAINT', N'2022-01-05 09:19:05.667', N'2022-01-05 09:19:05.667', 0, 0, 0, 581577110, 1, 0, 0, 0, 0, N'NO_ACTION', 0, N'NO_ACTION', 0);
