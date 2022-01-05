create view sys.dm_os_memory_pools as
-- missing source code
go

INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB04CEE0, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB696040, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 176);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB696E90, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 12);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB69C040, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB69CE90, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB6A2040, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB6A2E90, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB6A8040, 0, N'OBJECTSTORE_SNI_PACKET', N'SNIPacket', 1024, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB6AF070, 0, N'OBJECTSTORE_LOCK_MANAGER', N'Lock Blocks', -1, 1703, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB6AF070, 1, N'OBJECTSTORE_LOCK_MANAGER', N'Lock Owner Blocks', -1, 4189, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DABA8C50, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker dialog timer events', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DABC6040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker transmission transaction data', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DABC6E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker transmission transaction element', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DABFA040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker task local storage object pool', 16384, 0, 14);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DABFAE90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport received blocks', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D818A040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport send blocks', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D818AE90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport premarshaled send blocks', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D8194040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS endpoint connect tasks', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D8194E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport xmit messages', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D819E040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport recv messages', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D819EE90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport forwarded messages', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81A8040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS wire recv messages', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81A8E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS transport marshal tasks', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81B2040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'UCS unmarshall tasks', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81C8040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker rollback handler task object pool', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81C8E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker rollback handler vlr object pool', 16379, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81E2040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker forwarded message wrappers', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81E2E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker forwarded conversations', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81EC040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker received messages', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81ECE90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker send messages', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81F6040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker enqueued message info elements', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D81F6E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Broker transport dialog messages', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D8280C50, 0, N'OBJECTSTORE_SERVICE_BROKER', N'Database Mirroring messages', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D8288040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Messages', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D32F2040, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 0, 897);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D32F2E90, 0, N'OBJECTSTORE_SECAUDIT_EVENT_BUFFER', N'AuditEventBuffers', 2048, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233CD4E4040, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 0, 346);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB53A040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Replica Xmit Msg Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB53AE90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Replica No Copy Xmit Msg Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB544040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Log Block Msg Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB544E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Primary Progress Msg Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB54E040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Log Progress Msg Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB54EE90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Compressed Log Block Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB558040, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Replica Status Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB558E90, 0, N'OBJECTSTORE_SERVICE_BROKER', N'HADR Sync Progress Message Pool', 16384, 0, 0);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233D3EC8040, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 0, 631);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233DB455160, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 0, 1192);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233CC307160, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 2, 780);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233CC302040, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 1, 2273);
INSERT INTO sys.dm_os_memory_pools (memory_pool_address, pool_id, type, name, max_free_entries_count, free_entries_count, removed_in_all_rounds_count) VALUES (0x00000233CD4C0040, 0, N'OBJECTSTORE_LBSS', N'LbssCache', 128, 0, 4);