create view sys.database_automatic_tuning_options as
-- missing source code
go

grant select on sys.database_automatic_tuning_options to [public]
go

INSERT INTO sys.database_automatic_tuning_options (name, desired_state, desired_state_desc, actual_state, actual_state_desc, reason, reason_desc) VALUES (N'FORCE_LAST_GOOD_PLAN', 2, N'DEFAULT', 0, N'OFF', 2, N'AUTO_CONFIGURED');
