create view sys.trace_categories as
-- missing source code
go

INSERT INTO sys.trace_categories (category_id, name, type) VALUES (1, N'Cursors', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (2, N'Database', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (3, N'Errors and Warnings', 2);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (4, N'Locks', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (5, N'Objects', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (6, N'Performance', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (7, N'Scans', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (8, N'Security Audit', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (9, N'Server', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (10, N'Sessions', 1);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (11, N'Stored Procedures', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (12, N'Transactions', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (13, N'TSQL', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (14, N'User configurable', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (15, N'OLEDB', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (16, N'Broker', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (17, N'Full text', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (18, N'Deprecation', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (19, N'Progress Report', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (20, N'CLR', 0);
INSERT INTO sys.trace_categories (category_id, name, type) VALUES (21, N'Query Notifications', 0);
