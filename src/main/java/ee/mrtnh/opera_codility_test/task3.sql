create table servers (
                         id integer not null,
                         server_name varchar not null,
                         connections integer not null,
                         unique(id),
                         unique(server_name)
);

insert into servers values (105, 'Hawk', 3);
insert into servers values (104, 'Buzzard', 0);
insert into servers values (100, 'Falcon', 6);
insert into servers values (103, 'Harrier', 3);

-- couldn't assign AVG function result to variable
SELECT  id,
        server_name,
        CASE
            WHEN connections <= (SELECT AVG(connections) FROM servers) THEN 'OK'
            ELSE 'OVERLOAD'
            END
            AS status
FROM servers
GROUP BY id, server_name, connections
ORDER BY id ASC;

