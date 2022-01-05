create view sys.database_automatic_tuning_mode as
-- missing source code
go

grant select on sys.database_automatic_tuning_mode to [public]
go

INSERT INTO sys.database_automatic_tuning_mode (desired_state, desired_state_desc, actual_state, actual_state_desc) VALUES (3, N'AUTO', 3, N'AUTO');
