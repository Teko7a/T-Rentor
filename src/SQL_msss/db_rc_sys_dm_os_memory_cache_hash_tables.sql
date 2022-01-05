create view sys.dm_os_memory_cache_hash_tables as
-- missing source code
go

INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB820720, N'EventNotificationCache', N'CACHESTORE_EVENTS', 0, 442, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB864080, N'Object Plans', N'CACHESTORE_OBJCP', 0, 40009, 11, 0, 1, 1, 1, 301, 270, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB864E00, N'SQL Plans', N'CACHESTORE_SQLCP', 0, 40009, 103, 0, 1, 1, 1, 3266, 587, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB878080, N'Bound Trees', N'CACHESTORE_PHDR', 0, 4001, 106, 0, 2, 1, 3, 7823, 11604, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB878D00, N'Extended Stored Procedures', N'CACHESTORE_XPROC', 0, 127, 0, 0, 0, 0, 0, 0, 3, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DAB82080, N'Temporary Tables & Table Variables', N'CACHESTORE_TEMPTABLES', 0, 4001, 10, 0, 1, 1, 1, 0, 10, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DAB82080, N'Temporary Tables & Table Variables', N'CACHESTORE_TEMPTABLES', 1, 4001, 10, 0, 1, 1, 1, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DAB82D50, N'XMLDBCACHE', N'CACHESTORE_XMLDBTYPE', 0, 401, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DAB82D50, N'XMLDBCACHE', N'CACHESTORE_XMLDBTYPE', 1, 401, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DAB82D50, N'XMLDBCACHE', N'CACHESTORE_XMLDBTYPE', 2, 401, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DABA2080, N'XMLDBCACHE', N'CACHESTORE_XMLDBELEMENT', 0, 401, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DABA2C90, N'XMLDBCACHE', N'CACHESTORE_XMLDBATTRIBUTE', 0, 401, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DABA8080, N'XMLDBCACHE', N'CACHESTORE_XML_SELECTIVE_DG', 0, 401, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81B2ED0, N'Service broker routing cache', N'CACHESTORE_BROKERREADONLY', 0, 997, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81C2080, N'Service broker configuration', N'CACHESTORE_BROKERREADONLY', 0, 997, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81C2C90, N'Service broker dialog cache', N'CACHESTORE_BROKERREADONLY', 0, 997, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81C2C90, N'Service broker dialog cache', N'CACHESTORE_BROKERREADONLY', 1, 997, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81D6080, N'Service Broker Key Exchange Key Cache', N'CACHESTORE_BROKERKEK', 0, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81D6C90, N'Service Broker Dialog Security Header Cache', N'CACHESTORE_BROKERDSH', 0, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81DC080, N'Service Broker user certificates lookup result cache', N'CACHESTORE_BROKERUSERCERTLOOKUP', 0, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D81DCC90, N'Service Broker Null Remote Service Binding Cache', N'CACHESTORE_BROKERRSB', 0, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D8280080, N'Service Broker Transmission Object Cache', N'CACHESTORE_BROKERTO', 0, 20011, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D8288ED0, N'Broker dormant rowsets', N'CACHESTORE_BROKERTBLACS', 0, 997, 0, 0, 0, 0, 0, 0, 1, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D8294080, N'Broker dormant rowsets', N'CACHESTORE_BROKERTBLACS', 0, 997, 0, 0, 0, 0, 0, 0, 2, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D8294C90, N'Service broker mapping table', N'CACHESTORE_BROKERREADONLY', 0, 997, 0, 0, 0, 0, 0, 3, 9, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83B0080, N'View Definition Cache', N'CACHESTORE_VIEWDEFINITIONS', 0, 128, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83B0080, N'View Definition Cache', N'CACHESTORE_VIEWDEFINITIONS', 1, 128, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83B0080, N'View Definition Cache', N'CACHESTORE_VIEWDEFINITIONS', 2, 128, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83B0C90, N'Notification Store', N'CACHESTORE_NOTIF', 0, 16384, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83B0C90, N'Notification Store', N'CACHESTORE_NOTIF', 1, 16384, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83B0C90, N'Notification Store', N'CACHESTORE_NOTIF', 2, 16384, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D83E4080, N'QDSRuntimeStatsManager', N'CACHESTORE_QDSRUNTIMESTATS', 0, 16384, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D5080040, N'Column store object pool', N'CACHESTORE_COLUMNSTOREOBJECTPOOL', 0, 40000, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D5118080, N'SESHAREDCOLMETADATACACHE', N'CACHESTORE_SEHOBTCOLUMNATTRIBUTE', 0, 256, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D5B9E080, N'SystemRowsetStore', N'CACHESTORE_SYSTEMROWSET', 0, 599, 27, 0, 1, 1, 2, 71509, 10445, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D3EA8080, N'FTSTOPLIST_CACHESTORE', N'CACHESTORE_FULLTEXTSTOPLIST', 0, 127, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D3EA8C90, N'SEARCH_PROPERTY_LIST_CACHESTORE', N'CACHESTORE_SEARCHPROPERTYLIST', 0, 127, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D3FD0080, N'SystemRowsetStore', N'CACHESTORE_SYSTEMROWSET', 0, 599, 17, 0, 3, 1, 3, 1530, 283, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D3FD0C90, N'SystemRowsetStore', N'CACHESTORE_SYSTEMROWSET', 0, 599, 84, 0, 4, 1, 5, 1575955, 44833, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CD4E4ED0, N'SystemRowsetStore', N'CACHESTORE_SYSTEMROWSET', 0, 599, 0, 0, 0, 0, 0, 149, 38, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CDABA910, N'ConversationPriorityCache', N'CACHESTORE_CONVPRI', 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CD851240, N'SystemRowsetStore', N'CACHESTORE_SYSTEMROWSET', 0, 599, 47, 0, 2, 1, 2, 25929, 3874, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CDAF1060, N'ConversationPriorityCache', N'CACHESTORE_CONVPRI', 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CDE86080, N'Broker dormant rowsets', N'CACHESTORE_BROKERTBLACS', 0, 997, 0, 0, 0, 0, 0, 0, 2, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CDE86C90, N'Broker dormant rowsets', N'CACHESTORE_BROKERTBLACS', 0, 997, 0, 0, 0, 0, 0, 0, 5, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233CB150080, N'SystemRowsetStore', N'CACHESTORE_SYSTEMROWSET', 0, 599, 16, 0, 3, 1, 3, 36498, 2064, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233D32051A0, N'ConversationPriorityCache', N'CACHESTORE_CONVPRI', 0, 113, 0, 0, 0, 0, 0, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB821460, N'TokenAndPermUserStore', N'USERSTORE_TOKENPERM', 0, 256, 2, 0, 1, 1, 3, 0, 0, 0, 0);
INSERT INTO sys.dm_os_memory_cache_hash_tables (cache_address, name, type, table_level, buckets_count, buckets_in_use_count, buckets_min_length, buckets_max_length, buckets_avg_length, buckets_max_length_ever, hits_count, misses_count, buckets_avg_scan_hit_length, buckets_avg_scan_miss_length) VALUES (0x00000233DB821460, N'TokenAndPermUserStore', N'USERSTORE_TOKENPERM', 1, 128, 2, 0, 1, 1, 2, 0, 0, 0, 0);