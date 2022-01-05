create table t_maintain
(
    id        int not null
        primary key,
    carID     int,
    adminID   int,
    errorDesc varchar(50),
    stDate    varchar(20),
    edDate    varchar(20),
    cost      int
)
go

INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (65, 11, 1, N'发动机故障', N'21/09/05', N'21/09/05', 1000);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (66, 10, 1, N'充电故障', N'21/09/05', N'21/09/05', 200);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (67, 5, 8, N'变速箱钝挫', N'21/09/05', N'21/09/05', 220);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (68, 10, 8, N'变速箱钝挫', N'21/09/05', N'21/09/05', 100);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (69, 13, 8, N'变速箱钝挫', N'21/09/05', N'21/09/05', 100);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (70, 13, 8, N'变速箱钝挫', N'21/09/05', N'21/09/05', 100);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (71, 6, 4, N'磨损', N'21/09/05', N'21/09/05', 500);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (72, 9, 4, N'磨损', N'21/09/05', N'21/09/05', 100);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (73, 3, 4, N'磨损', N'21/09/05', N'21/09/05', 500);
INSERT INTO db_rc.dbo.t_maintain (id, carID, adminID, errorDesc, stDate, edDate, cost) VALUES (74, 6, 4, N'', N'21/09/05', N'22/01/04', 0);
