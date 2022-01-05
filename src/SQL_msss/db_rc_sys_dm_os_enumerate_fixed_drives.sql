create view sys.dm_os_enumerate_fixed_drives as
-- missing source code
go

INSERT INTO sys.dm_os_enumerate_fixed_drives (fixed_drive_path, drive_type, drive_type_desc, free_space_in_bytes) VALUES (N'C:\', 3, N'DRIVE_FIXED', 297153925120);
INSERT INTO sys.dm_os_enumerate_fixed_drives (fixed_drive_path, drive_type, drive_type_desc, free_space_in_bytes) VALUES (N'D:\', 3, N'DRIVE_FIXED', 82586484736);
