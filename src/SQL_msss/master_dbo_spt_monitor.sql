create table spt_monitor
(
    lastrun       datetime not null,
    cpu_busy      int      not null,
    io_busy       int      not null,
    idle          int      not null,
    pack_received int      not null,
    pack_sent     int      not null,
    connections   int      not null,
    pack_errors   int      not null,
    total_read    int      not null,
    total_write   int      not null,
    total_errors  int      not null
)
go

grant select on spt_monitor to [public]
go

INSERT INTO master.dbo.spt_monitor (lastrun, cpu_busy, io_busy, idle, pack_received, pack_sent, connections, pack_errors, total_read, total_write, total_errors) VALUES (N'2019-09-24 14:21:40.843', 30, 30, 7220, 39, 39, 53, 0, 0, 0, 0);
