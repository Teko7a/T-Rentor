create table t_admin
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

INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (1, N'0', N'0', N'admin', N'398866529958820832', N'13809088888');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (2, N'Tekola', N'azhe1...4', N'TKLA', N'182423323838842690', N'15928450000');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (3, N'sunyu', N'3738', N'孙瑜', N'512901194405120025', N'13521371453');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (4, N'zhaoqiang', N'123', N'赵强', N'183465665758061409', N'17877006758');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (5, N'longaotian', N'%,8R#(dHX0', N'龙傲天', N'440708467465547407', N'15893180124');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (6, N'lishaohua', N'9513901215', N'李少华', N'493414226897949816', N'18269219229');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (7, N'lizonghe', N'lklsY9:SDC', N'李棕鹤', N'156202935635906931', N'17274175896');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (8, N'likai', N'3244137158', N'李开', N'419190706003146421', N'17595049450');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (9, N'lijiale', N'5927$1626', N'李家乐', N'299656076360974801', N'17063247024');
INSERT INTO db_rc.dbo.t_admin (id, name, password, realName, idc, tel) VALUES (10, N'lizhangzhi', N'Qwerty**..1', N'李张志', N'422186777208330434', N'13634145698');
