create table t_usr
(
    id       int not null
        primary key,
    name     varchar(30),
    password varchar(20),
    realName varchar(20),
    idc      varchar(18),
    tel      varchar(11)
)
go

INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (1, N'0', N'0', N'tt', N'362881319759759442', N'10000000001');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (10, N'zsh', N'>Vy2', N'ZSH', N'445322112648084966', N'11000195061');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (11, N'rc', N'D1Ei&R+_M', N'陈王', N'403713631597134126', N'14411595855');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (12, N'op', N'YP>L&&', N'李素', N'276613328515851578', N'14196403677');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (13, N'123', N'dD?', N'梅里', N'252592593724689847', N'19297895656');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (14, N'lucy', N'TWgI', N'鲁西', N'292016089025626253', N'11409290972');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (15, N'zhanghe', N'Nim6t', N'张和', N'474327912974768353', N'19115986128');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (16, N'sg', N'ataY', N'孙戈', N'558993862258789960', N'19562972882');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (17, N'wzzNic', N'O1^Gyp7R', N'王之张', N'126065818148467617', N'11608027234');
INSERT INTO db_rc.dbo.t_usr (id, name, password, realName, idc, tel) VALUES (18, N'lxk', N'U@RPmtp0', N'李歆奎', N'210809706648879356', N'11409290972');
