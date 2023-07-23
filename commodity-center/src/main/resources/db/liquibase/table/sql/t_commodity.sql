create table t_commodity
(
    id            serial8 primary key,
    name          varchar(50)                         not null,
    price         numeric(17, 2)                      not null,
    description   varchar(255)                        null,
    image         varchar(300)                        null,
    stock         int4      default 0                 not null,
    delivery_type int4[]    default '{}'::int[]       not null,
    status        int4      default 1                 not null,
    create_time   timestamp default current_timestamp not null,
    update_time   timestamp                           null
);

create function update_time()
    returns trigger as
$$
begin
    new.update_time = current_timestamp;
    return new;
end;
$$ language plpgsql;

create trigger t_commodity_update_time
    before update
    on t_commodity
    for each row
execute procedure update_time();

